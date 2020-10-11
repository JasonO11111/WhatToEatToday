package com.zoulongsheng.whattoeattoday.tools.dbcontroller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zoulongsheng.whattoeattoday.beans.History;
import com.zoulongsheng.whattoeattoday.tools.db.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class HistoryDatabaseController {

    private MyDatabaseHelper dbHelper;
    private SQLiteDatabase db;

    public HistoryDatabaseController(Context context){
        createDateBase(context);
    }

    /**
     * 创建数据库
     */
    private void createDateBase(Context context){
        dbHelper = new MyDatabaseHelper(context,"History.db",null,1);
        dbHelper.getWritableDatabase();
        db = dbHelper.getWritableDatabase();
    }

    /**
     *  插入数据
     *
     */
    public void insertData(History history){
        ContentValues values = new ContentValues();
        values.put("name",history.getName());
        values.put("time",history.getTime());
        db.insert("History",null,values);
    }

    /**
     *
     * 删除数据
     */
    public void delData(){
        db.delete("History","name != ?",new String[]{"null"});
    }

    /**
     *
     * 查询数据
     */
    public List<History> queryData(){
        Cursor cursor = db.query("History",null,null,null,null,null,null);
        List<History> list = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                History history = new History();
                history.setName(name);
                history.setTime(time);
                list.add(history);
            }while(cursor.moveToNext());
        }
        return list;
    }


}
