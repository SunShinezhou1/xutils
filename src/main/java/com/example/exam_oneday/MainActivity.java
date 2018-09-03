package com.example.exam_oneday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {
String uri ="http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=10&page=1";
    bean bean;
    //(4)	使用ViewUtils加载RecyclerView（10分）
    @ViewInject(R.id.lv)
    RecyclerView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        inView();
        RequestParams requestParams = new RequestParams(uri);
        //(5)	使用HttpUtils加载网络数据（10分）
        x.http().get(requestParams, new Callback.CacheCallback<String>() {
            @Override
            //(8)	将数据展示到RecycleView中(10分)
            public void onSuccess(String result) {
                Gson gson = new Gson();
                bean = gson.fromJson(result, bean.class);
                Adapter adapter = new Adapter(MainActivity.this,bean);
                lv.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }
    private void inView(){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
         lv.setLayoutManager(staggeredGridLayoutManager);
    }
}
