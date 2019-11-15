package pl.kosmalski.trenermobilny;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import pl.kosmalski.trenermobilny.DietContract.*;
import static pl.kosmalski.trenermobilny.DietContract.DietEntry.TABLE_NAME;


public class DietDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "diet.db";
    public static final int DATABASE_VERSION = 1;

    public DietDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                DietEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DietEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                DietEntry.COLUMN_KCAL + " FLOAT NOT NULL, " +
                DietEntry.COLUMN_PROTEIN + " FLOAT NOT NULL, " +
                DietEntry.COLUMN_FAT + " FLOAT NOT NULL, " +
                DietEntry.COLUMN_CARB + " FLOAT NOT NULL, " +
                DietEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_TABLE);
        db.execSQL("INSERT INTO "+TABLE_NAME+"(name,kcal,protein,fat,carb) values ('Mleko', 63, 13, 12.9, 5.7)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}