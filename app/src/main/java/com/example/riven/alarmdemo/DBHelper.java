package com.example.riven.alarmdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Riven on 2017/6/20.
 * Email : 1819485687@qq.com
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "alarm_db";
    private static final String TABLE_NAME = "alarm";
    public static final String TABLE_ID = "_id";
    public static final String TABLE_USER_ID = "user_id";
    public static final String TABLE_TRIGGER_TIME = "trigger_time";
    public static final String TABLE_LAST_DATE = "last_date";
    private static final String CREATE_TABLE = "create table if not exists " + TABLE_NAME + "(" + TABLE_ID + " integer primary key," + TABLE_USER_ID + " text," + TABLE_TRIGGER_TIME + " text," + TABLE_LAST_DATE + " text);";
    private SQLiteDatabase db;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        Log.e("DBHelper", "create SQLiteDatabase");
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor query() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        return c;
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "_id=?", new String[]{String.valueOf(id)});
    }

    public void update(ContentValues values, String wheereClause, String[] whereArgs) {
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLE_NAME, values, wheereClause, whereArgs);
    }

    public void closeDB() {
        if (db != null) {
            db.close();
        }
    }


}
