package com.example.lap07_sqlite1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context,"ToDoDatabase",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TODO(ID INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT," +
                "CONTENT TEXT, TYPE TEXT, STATUS INTEGER)";
        db.execSQL(sql);
        String data = "INSERT INTO TODO VALUES(1,'HỌC JAVA','HỌC Java cơ bản','Bình thường',1)";

        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i!=i1){
            db.execSQL("DROP TABLE IF EXISTS TODO");
            onCreate(db);
        }
    }
}
