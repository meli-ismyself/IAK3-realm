package com.meliismyself.todolistrealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.meliismyself.todolistrealm.db.TodoHelper;
import com.meliismyself.todolistrealm.db.TodoItem;

public class EditTaskActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editTask, editDescription;
    private Button btnSubmit;
    private TodoHelper todoHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        getSupportActionBar().setTitle("Add New Task");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editDescription = (EditText)findViewById(R.id.edt_description);
        editTask = (EditText)findViewById(R.id.edt_task);
        btnSubmit = (Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);

        todoHelper = new TodoHelper(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_submit){
            String task = editTask.getText().toString().trim();
            String description = editDescription.getText().toString().trim();

            if (TextUtils.isEmpty(task) || TextUtils.isEmpty(description)){
                Toast.makeText(this, "All fields are mendatory", Toast.LENGTH_LONG).show();

            }else {
                TodoItem item = new TodoItem();
                item.setId(System.currentTimeMillis());
                item.setTask(task);
                item.setDescription(description);
                todoHelper.create(item.getId(), item.getTask(), item.getDescription());
                Toast.makeText(this, "One task added", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}
