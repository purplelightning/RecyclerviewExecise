package com.example.wind.recyclerviewexecise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wind.recyclerviewexecise.GalleryDemo.GalleryActivity;
import com.example.wind.recyclerviewexecise.LayoutDemo.ComplexLayoutActivity;
import com.example.wind.recyclerviewexecise.TransDemo.RanimationActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.to_rani);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,RanimationActivity.class);
                startActivity(intent1);
            }
        });

        btn2 = (Button) findViewById(R.id.to_gallery);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,GalleryActivity.class);
                startActivity(intent2);
            }
        });

        btn3=(Button)findViewById(R.id.to_complex);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this, ComplexLayoutActivity.class);
                startActivity(intent3);
            }
        });
    }
}
