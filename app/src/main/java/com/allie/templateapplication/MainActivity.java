package com.allie.templateapplication;

import android.os.Bundle;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActionBar mActionBar;
    private Toolbar mToolbar;
    private  List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        toolbarSetup();

        //this is an example list - create your own from your json file to populate the recyclerview
        list.add("Employee");
        list.add("Employee");
        list.add("Employee");

       recyclerViewSetup();
    }

    private void recyclerViewSetup() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pass in your list to the recyclerview adapter
        RecyclerAdapter adapter = new RecyclerAdapter(list, this);
        mRecyclerView.setAdapter(adapter);
    }

    private void toolbarSetup() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setTitle(R.string.app_name);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

    //example of how to get items from your json file
//    private List<Employee> getJsonObject() {
//            if (mJsonList == null) {
//                String json = null;
//                try {
//                    InputStream is = MainActivity.this.getAssets().open("Employee.json");
//                    int size = is.available();
//                    byte[] buffer = new byte[size];
//                    is.read(buffer);
//                    is.close();
//                    json = new String(buffer, "UTF-8");
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    return null;
//                }
//                Gson gson = new Gson();
//                Type type = new TypeToken<List<Employee>>() {
//                }.getType();
//                mJsonList = gson.fromJson(json, type);
//
//                for (Employee employee : mJsonList) {
//                }
//            }
//            return mJsonList;
//        }
}
