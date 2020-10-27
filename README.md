# demo03
# demo03

一：ListView

(1)MainActivity.java

```java
public class MainActivity extends AppCompatActivity {

    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog","Cat"};
    private int[] images=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);
        List<Map<String,Object>> listItems=new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("name",names[i]);
            listItem.put("image",images[i]);
            listItems.add(listItem);
        }
        SimpleAdapter sa=new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"name","image"},new int[]{R.id.name,R.id.image});
        ListView list=findViewById(R.id.mylist);
        list.setAdapter(sa);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT);

                toast.show();

            }
        });
    }
}
```

（2）simpleadapter.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">
    <ListView
        android:id="@+id/mylist"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </ListView>
</LinearLayout>
```

(3)simple_item.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:background="@drawable/button_selected"
    >
    <TextView
        android:id="@+id/name"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:paddingLeft="10dp"
        android:gravity="left">

    </TextView>
    <ImageView
        android:id="@+id/image"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginTop="10dp"
        android:layout_marginRight="10dp"
        android:paddingLeft="20dp"
        android:layout_marginLeft="180dp"
        android:layout_marginBottom="10dp">
    </ImageView>
</LinearLayout>

```

(4)实验截图

![image-20201027003625578](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027003625578.png)

![image-20201027003751679](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027003751679.png)



二：创建自定义布局的AlertDialog

(1)MainActivity.java

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Button button=findViewById(R.id.customView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customView(view);
            }
        });
    }
    public void customView(View source)
    {
        // 加载\res\layout\login.xml界面布局文件
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
        new AlertDialog.Builder(this)
                // 设置对话框的图标

                // 设置对话框的标题
                //.setTitle("ANDROID APP")
                // 设置对话框显示的View对象
                .setView(loginForm)
                // 为对话框设置一个“确定”按钮
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                // 创建并显示对话框
                .create().show();
    }
}
```

(2)界面按钮布局layout.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">
  <Button
      android:id="@+id/customView"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:text="button"></Button>
  
</LinearLayout>

```

(3)对话框布局activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical">

    <TableRow
        android:layout_width="wrap_content"
        android:layout_height="match_parent">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="400dp"
            android:layout_height="match_parent"
            app:srcCompat="@drawable/title" />
    </TableRow>

    <TableRow
        android:layout_width="wrap_content"
        android:layout_height="34dp">

        <EditText
            android:id="@+id/TextPersonName"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:ems="10"
            android:hint="Username"
            android:inputType="textPersonName" />
    </TableRow>

    <TableRow
        android:layout_width="wrap_content"
        android:layout_height="match_parent">

        <EditText
            android:id="@+id/TextPassword"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:hint="Password"
            android:ems="10"
            android:inputType="textPassword"
            />
    </TableRow>
</TableLayout>
```

(4)实验截图

![image-20201027004225526](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027004225526.png)

![image-20201027004243929](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027004243929.png)

三：实验xml定义菜单

(1)MainActivity.java

```java
public class MainActivity extends AppCompatActivity {

    // 定义“字体大小”菜单项的标识
    private static final int FONT_10 = 0x111;
    private static final int FONT_16 = 0x114;
    private static final int FONT_20 = 0x115;
    // 定义“普通菜单项”的标识
    private static final int PLAIN_ITEM = 0x11b;
    // 定义“字体颜色”菜单项的标识
    private static final int FONT_RED = 0x116;
    private static final int FONT_BLACK = 0x118;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        text = findViewById(R.id.txt);
    }
    // 当用户单击MENU键时触发该方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // -------------向menu中添加“字体大小”的子菜单-------------
        SubMenu fontMenu = menu.addSubMenu("字体大小");


        // 设置菜单头的标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_20, 0, "20号字体");
        // -------------向menu中添加“普通菜单项”-------------
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        // -------------向menu中添加“字体颜色”的子菜单-------------
        SubMenu colorMenu = menu.addSubMenu("字体颜色");

        // 设置菜单头的图标

        // 设置菜单头的标题
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_BLACK, 0, "黑色");
        return super.onCreateOptionsMenu(menu);
    }
    // 选项菜单的菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        // 判断单击的是哪个菜单项，并有针对性地做出响应
        switch (mi.getItemId())
        {
            case FONT_10: text.setTextSize(10 * 2);	break;

            case FONT_16: text.setTextSize(16 * 2); break;
            case FONT_20: text.setTextSize(20 * 2); break;
            case FONT_RED: text.setTextColor(Color.RED); break;
            case FONT_BLACK: text.setTextColor(Color.BLACK); break;
            case PLAIN_ITEM:
                Toast.makeText(MainActivity.this,
                        "您单击了普通菜单项", Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return true;
    }
}
```

(2)实验截图

![image-20201027004535125](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027004535125.png)

![image-20201027004603896](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027004603896.png)

![image-20201027004641303](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027004641303.png)

![image-20201027004707882](https://github.com/wangwang01-wzx/demo03/blob/master/image-20201027004707882.png)

三：上下文菜单

（1）MainActivity.java

```
public class MainActivity extends AppCompatActivity {
    String[] names = {"One", "Two", "Three", "Four"};
    HashMap<View, Boolean> vis;
    int selected_items = 0;
    ActionMode am;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleadapter);

        vis = new HashMap<>();

        ListView lv_3 = findViewById(R.id.mylist);
        ArrayList<HashMap<String, Object>> lst = new ArrayList<>();
        for (int i = 0; i <= 3; i++)
        {
            HashMap<String, Object> mp = new HashMap<>();
            mp.put("name", names[i]);
            mp.put("image", R.drawable.cat);
            lst.add(mp);
        }

        SimpleAdapter sa = new SimpleAdapter(this,lst,R.layout.listitem,new String[]{"name","image"},new int[]{R.id.name,R.id.image});
        lv_3.setAdapter(sa);
    }

    public void click_select(View V)
    {
        if (am == null)
            am = startActionMode(callback);

        LinearLayout ll = (LinearLayout) V;
        if (vis.get(V) == null || !vis.get(V))
        {
            ll.setBackgroundColor(Color.GREEN);
            vis.put(V, true);
            selected_items++;
        }
        else
        {
            ll.setBackgroundColor(Color.WHITE);
            vis.put(V, false);
            selected_items--;
        }
        callback.onActionItemClicked(am, null);

    }

    ActionMode.Callback callback = new ActionMode.Callback()
    {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu)
        {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu)
        {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem)
        {
            actionMode.setTitle(selected_items + " selected");
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode)
        {

        }
    };

}
```

(2)实验截图

![image-20201027224757513](C:\Users\ASUS\AppData\Roaming\Typora\typora-user-images\image-20201027224757513.png)
