package com.meliismyself.todolistrealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.meliismyself.todolistrealm.adapter.TodoAdapter;
import com.meliismyself.todolistrealm.db.TodoHelper;
import com.meliismyself.todolistrealm.db.TodoItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvItem;
    private TodoHelper helper;
    private ArrayList<TodoItem> list;
    private TodoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItem = (ListView)findViewById(R.id.lv_item);
        helper = new TodoHelper(this);
        list = new ArrayList<>();

        LoadData();

    }

    private void LoadData(){
        list = helper.getAllItem();
        if (list != null && !list.isEmpty()){
            adapter = new TodoAdapter(this, list);
            lvItem.setAdapter(adapter);
        }else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add){
            Intent intent = new Intent(MainActivity.this, EditTaskActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (list.size() > 0){
            list.clear();
        }
        LoadData();

    }
}
