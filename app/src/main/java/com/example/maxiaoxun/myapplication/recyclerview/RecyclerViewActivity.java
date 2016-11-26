package com.example.maxiaoxun.myapplication.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maxiaoxun.myapplication.R;

import java.util.ArrayList;


public class RecyclerViewActivity extends Activity {

    private static final String TAG = "RecyclerViewActivityTAG";
    private RecyclerView mMyRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private MyAdapter myAdapter;
    String[] data = new String[]{"A", "B", "C", "D", "E", "F"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无标题栏
        //    requestWindowFeature(Window.FEATURE_NO_TITLE);
        //透明状态栏
        //    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //全频
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //透明导航栏
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        setContentView(R.layout.activity_recycler_view);

        mMyRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //设置LinearLayoutManager
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mMyRecyclerView.setLayoutManager(mLinearLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        //mMyRecyclerView.setHasFixedSize(true);

        //设置GridLayoutManager
//        mGridLayoutManager = new GridLayoutManager(this, 4);
//        mMyRecyclerView.setLayoutManager(mGridLayoutManager);

        //设置StaggeredLayoutManager
//        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL);
//        mMyRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);


        myAdapter = new MyAdapter(data);

        mMyRecyclerView.setAdapter(myAdapter);

    }

    public void insertItem(View v){
        myAdapter.addItem("嘿嘿", 3);
    }

    public void deleteItem(View v){
        myAdapter.delItem(2);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        ArrayList<String> mData = new ArrayList<>();

        public MyAdapter(String[] data) {

            for (int i = 0; i < data.length; i++) {
                mData.add(data[i]);
            }
        }

        public void addItem(String d, int index) {
            mData.add(index, d);
            notifyItemInserted(index);
        }

        public void delItem(int index) {
            mData.remove(index);
            notifyItemRemoved(index);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
            MyViewHolder myViewHolder = new MyViewHolder(itemView);

            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.titleText.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            Log.d(TAG, "mData.length = " + mData.size());
            return mData.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView titleText;

            public MyViewHolder(View itemView) {
                super(itemView);
                titleText = (TextView) itemView.findViewById(R.id.title_text);
            }
        }
    }
}
