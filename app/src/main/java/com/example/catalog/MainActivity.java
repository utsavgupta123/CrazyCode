package com.example.catalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recycleview1;
    public TextView textview5;
    items s1=new items("Paneers Masala",50);
    items s2=new items("Butter Chicken",150);
    items s3=new items("Chicken Biryani",550);
    items s4=new items("Hyderabadi Chicken",530);
   // String []arr={s1.name ,s2.name,s3.name,s4.name};
   public int p=0;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleview1=findViewById(R.id.recyclerView);
        textview5=findViewById(R.id.textView5);
        recycleview1.setLayoutManager(new LinearLayoutManager(this));

        items [] arr;
        arr=new items[3];
        arr[0]=s1;
        arr[1]=s2;
        arr[2]=s3;
         //int p=0;
         int[] pp={11};
        // pp[0]=0;
        CustomAdapter c=new CustomAdapter(arr,pp);
        recycleview1.setAdapter(c);
        String str = getIntent().getStringExtra("key");
         textview5.setText(str);

    }
}

