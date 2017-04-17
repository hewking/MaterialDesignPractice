//package com.dlodlo.materialdesignpractice.ui.swipetolayout;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
//import com.aspsine.swipetoloadlayout.OnRefreshListener;
//import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
//import com.dlodlo.materialdesignpractice.R;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by hewking on 2016/12/11.
// */
//
//public class SwipeToLayoutActivity extends AppCompatActivity implements OnRefreshListener, OnLoadMoreListener {
//
//    SwipeToLoadLayout swipeToLoadLayout;
//
//    MyAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_swipetolayout);
//
//        swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
//
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.swipe_target);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        swipeToLoadLayout.setOnRefreshListener(this);
//
//        swipeToLoadLayout.setOnLoadMoreListener(this);
//
//        mAdapter = new MyAdapter(SwipeToLayoutActivity.this, android.R.layout.simple_expandable_list_item_1);
//
//
//        recyclerView.setAdapter(mAdapter);
//
//        autoRefresh();
//    }
//
//    @Override
//    public void onRefresh() {
//        swipeToLoadLayout.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                swipeToLoadLayout.setRefreshing(false);
//                mAdapter.add("REFRESH:\n" + new Date());
//            }
//        }, 2000);
//    }
//
//    @Override
//    public void onLoadMore() {
//        swipeToLoadLayout.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                swipeToLoadLayout.setLoadingMore(false);
//                mAdapter.add("LOAD MORE:\n" + new Date());
//            }
//        }, 2000);
//    }
//
//    private void autoRefresh() {
//        swipeToLoadLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeToLoadLayout.setRefreshing(true);
//            }
//        });
//    }
//
//    static class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
//
//        private List<String> datas;
//        int m_layout_id;
//        private Context ctx;
//        public MyAdapter(Context ctx,int res_layout){
//            datas = new ArrayList<>();
//            m_layout_id = res_layout;
//            this.ctx = ctx;
//        }
//
//        public void add(String str){
//            datas.add(str);
//            notifyDataSetChanged();
//        }
//
//        @Override
//        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(ctx).inflate(m_layout_id,null);
//            return new MyViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//            MyViewHolder vh = (MyViewHolder) holder;
//            vh.onBind(position,datas);
//        }
//
//        @Override
//        public int getItemCount() {
//            return datas.size();
//        }
//    }
//
//    static class MyViewHolder extends RecyclerView.ViewHolder{
//
//        TextView tv;
//
//        public void onBind(int position,List<String> datas){
//            String str = datas.get(position);
//            tv.setText(str);
//        }
//
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            tv = (TextView) itemView.findViewById(android.R.id.text1);
//        }
//    }
//}
