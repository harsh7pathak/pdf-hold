package com.example.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "register.db";
    public static final String Table_Name = "registerUser";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Username";
    public static final String COL_3 = "Password";

    public DBHelper(Context context) {
        super(context, "register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE registerUser (ID INTEGER PRIMARY KEY AUTOINCREMENT, Username TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE IF EXISTS" +Table_Name);
        onCreate(MyDB);

    }


    public boolean insertdata(String username, String password){
        SQLiteDatabase MyDB =this.getWritableDatabase();
        ContentValues contentvalues =new ContentValues();
        contentvalues.put("Username", username);
        contentvalues.put("Password", password);
        long result =MyDB.insert("registerUser", null, contentvalues);
        MyDB.close();
        if(result == -1)
            return false;
        else
            return true;
    }


    public boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from registerUser where username = ?",new String[] {username});
        int count = cursor.getCount();
        cursor.close();
        MyDB.close();
        if(count > 0)
        {
            return true;
        }
        else
            return false;

    }

    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from registerUser where username = ? and password = ?", new String[] {username, password});
        int count = cursor.getCount();
        cursor.close();
        MyDB.close();
        if(count > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
