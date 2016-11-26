package com.example.maxiaoxun.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.maxiaoxun.myapplication.propertyanimation.PropertyAnimActivity;
import com.example.maxiaoxun.myapplication.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mGotoRecyclerViewBtn;
    private Button mGotoPropertyAnimBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        mGotoRecyclerViewBtn = (Button) findViewById(R.id.goto_recycler_view_btn);
        mGotoRecyclerViewBtn.setOnClickListener(this);

        mGotoPropertyAnimBtn = (Button) findViewById(R.id.goto_property_anim_btn);
        mGotoPropertyAnimBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.goto_recycler_view_btn){
            Intent intentGotoRecyclerView = new Intent(this, RecyclerViewActivity.class);

            startActivity(intentGotoRecyclerView);
        }

        if(id == R.id.goto_property_anim_btn){
            Intent intentGotoPropertyAnim = new Intent(this, PropertyAnimActivity.class);

            startActivity(intentGotoPropertyAnim);
        }
    }
}
