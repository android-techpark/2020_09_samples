package ru.mail.techpark.lesson8.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "simple_entity")
public class SimpleEntity {

    @PrimaryKey(autoGenerate = true)
    int id;

    String text;
}
