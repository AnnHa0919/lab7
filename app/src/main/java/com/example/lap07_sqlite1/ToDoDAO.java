package com.example.lap07_sqlite1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;

public class ToDoDAO {
    private final DbHelper dbHelper;
    public ToDoDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public boolean Add(ToDo toDo){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TITLE",toDo.getTitle());
        cv.put("CONTENT",toDo.getContent());
        cv.put("TYPE",toDo.getType());
        cv.put("STATUS",0);
        long check = db.insert("TODO",null,cv);
        return check !=-1;
    }
    /*public boolean Update(ToDo toDo){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TITLE",toDo.getTitle());
        cv.put("CONTENT",toDo.getContent());
        cv.put("TYPE",toDo.getType());
        cv.put("STATUS",0);
        long check = db.update("TODO",null,c);
        return check !=-1;
    }*/

    public ArrayList<ToDo> getListToDo(){
        ArrayList<ToDo> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.beginTransaction();
        try {
            Cursor cursor = db.rawQuery("SELECT * FROM TODO",null);
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                do{
                    list.add(new ToDo(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getInt(4)));
                }while (cursor.moveToNext());
                db.setTransactionSuccessful();
            }
        }catch (Exception e){
            Log.e(null,"getListToDO"+e);
        }finally {
            db.endTransaction();
        }
        return list;
    }
}
