package com.example;

/*
 * RoomBasic
 * WordDatabase
 *
 * Created by Tianta on 2020/09/07.
 * Copyright (c) 2020 Tianta. All rights reserved.
 * Describe TODO
 */
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    public abstract WordDao getWordDao();
}
