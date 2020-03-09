package com.von_seyha.mobile.jobseeker.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "database";
    static int version = 1;

    String createTableUser = " CREATE TABLE IF NOT EXISTS `user` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `username` TEXT, " +
            " `email` TEXT, `password` TEXT, `address` TEXT, `gender` TEXT )" ;

    public DatabaseHelper(Context context) {
        super(context, name , null , 1);
        getWritableDatabase().execSQL(createTableUser);
    }

    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert("user","",contentValues);
    }

    public  boolean isLoginValid(String email , String password){
        String sql = " SELECT COUNT(*) FROM user WHERE email='" + email + "' AND password='" + password + "'";
        SQLiteStatement sqLiteStatement = getReadableDatabase().compileStatement(sql);
        long l = sqLiteStatement.simpleQueryForLong();
        sqLiteStatement.close();

        if ( l == 1){
            return true;
        }else {
            return false;
        }
    }

    public void uppdatePassword(String email , String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("password",password);
        db.update(createTableUser,values,"email"+"=?",new String[]{email});
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
