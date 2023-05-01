package com.cookandroid.danggeunmarket_clone_project

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
        override fun onCreate(db: SQLiteDatabase) {
            var sql : String = "CREATE TABLE if not exists resellData (" +
                    "num integer primary key autoincrement," +
                    "image text," +
                    "title text," +
                    "placetime text," +
                    "cost text," +
                    "likeNum text);";

            db.execSQL(sql)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            val sql : String = "DROP TABLE if exists resells"

            db.execSQL(sql)
            onCreate(db)
        }

    }