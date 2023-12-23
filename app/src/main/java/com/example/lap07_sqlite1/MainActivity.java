package com.example.lap07_sqlite1;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private static ToDoApdapter adapter;
    private Button btnAdd;
    private Button btnUpdate;
    private Button btnDelete;
    private EditText txtTitle;
    private EditText txtContent;
    private EditText txtType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rcv);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        txtTitle = findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);
        txtType = findViewById(R.id.txtType);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ToDoDAO toDoDAO = new ToDoDAO(this);
        ArrayList<ToDo> listToDo = toDoDAO.getListToDo();
        adapter = new ToDoApdapter(this,listToDo);
        recyclerView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = txtTitle.getText().toString();
                String content  =txtContent.getText().toString();
                String type = txtTitle.getText().toString();
                ToDo model = new ToDo(title,content,type);
                boolean a = toDoDAO.Add(model);
                System.out.println(a);
                showAlertDialog(a);
            }
        });
    }

    private void showAlertDialog(Boolean a) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");  // Tiêu đề của hộp thoại
        if(a)
            builder.setMessage("Ok"); // Nội dung thông báo
        else
            builder.setMessage("Không Ok");
        // Thiết lập nút "Đóng" để đóng hộp thoại
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Đóng hộp thoại khi nút "Đóng" được nhấn
                dialog.dismiss();
            }
        });
        // Tạo và hiển thị hộp thoại
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}