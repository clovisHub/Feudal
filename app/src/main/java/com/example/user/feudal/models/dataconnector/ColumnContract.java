package com.example.user.feudal.models.dataconnector;

import android.provider.BaseColumns;

public final class ColumnContract {

    private ColumnContract(){}

    public static class ColumnDef implements BaseColumns{

        public static final String TABLE_NAME ="Users";
        public static final String FIRST_NAME ="First_Name";
        public static final String LAST_NAME ="Last_Name";
        public static final String EMAIL ="Email";
        public static final String USERNAME="Username";
        public static final String PHONE ="Phone";
        public static final String PICTURE ="Picture";
        public static final String PASSWORD ="Password";
        public static final String ACCOUNT_TYPE ="Account_Type";
        public static final String STATUS ="Status";



    }
}
