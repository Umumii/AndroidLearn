package com.example;

/*
 * RoomBasic
 * WordDatabase
 *
 * Created by Tianta on 2020/09/07.
 * Copyright (c) 2020 Tianta. All rights reserved.
 * Describe TODO
 */
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Word.class},version = 3,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase INSTANCE;
    static synchronized WordDatabase getWordDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,WordDatabase.class,"word_database")
                    //.fallbackToDestructiveMigration()
                    .addMigrations(MYMIGRATION2_3)
                    .build();
        }
        return INSTANCE;
    }
    public abstract WordDao getWordDao();

    static final Migration MYMIGRATION2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE word ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 0");
        }
    };

    static final Migration MIGRATION3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            // 有问题,暂时没找到问题在哪里/
            // 创建临时表
//            database.execSQL("CREATE TABLE word_temp (id INTEGER PRIMARY KEY NOT NULL,english_word TEXT," +
//                    "chinese_meaning TEXT)");
//            database.execSQL("INSERT INTO word_temp (id, english_word, chinese_meaning) " +
//                    "SELECT id,english_word,chinese_meaning FROM Word");
//            database.execSQL("DROP TABLE Word");
//            database.execSQL("ALTER TABLE word_temp RENAME TO Word");

            database.execSQL("CREATE TABLE word_temp (id INTEGER PRIMARY KEY NOT NULL ,english_word TEXT," +
                    "chinese_meaning TEXT)");
            database.execSQL("INSERT INTO word_temp (id,english_word,chinese_meaning) " +
                    "SELECT id,english_word,chinese_meaning FROM Word");
            database.execSQL("DROP TABLE Word");
            database.execSQL("ALTER TABLE word_temp RENAME to Word");
        }
    };
}
