package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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