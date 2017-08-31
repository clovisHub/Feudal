package com.example.user.feudal.models.dataconnector;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.user.feudal.models.dataconnector.ColumnContract.*;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "feudalDatabase.db";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE "+ColumnDef.TABLE_NAME+"("+
                    ColumnDef._ID+" INTEGER PRIMARY KEY,"+
                    ColumnDef.FIRST_NAME+" TEXT,"+
                    ColumnDef.LAST_NAME+" TEXT,"+
                    ColumnDef.USERNAME+" TEXT,"+
                    ColumnDef.EMAIL+" TEXT,"+
                    ColumnDef.PHONE+" TEXT,"+
                    ColumnDef.PICTURE+" TEXT,"+
                    ColumnDef.STATUS+" TEXT,"+
                    ColumnDef.PASSWORD+" TEXT,"+
                    ColumnDef.ACCOUNT_TYPE+" TEXT)";

    public static final String SQL_DELETE_ENTRIES ="DROP TABLE IF EXIST "+
            ColumnDef.TABLE_NAME;

    public DataBaseHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }


}
