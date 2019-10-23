package pl.kosmalski.trenermobilny;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import pl.kosmalski.trenermobilny.DietContract.*;

public class DietDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "dietDB.db";
    public static  final int DATABASE_VERSION =1;

    public DietDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_DIET_TABLE = "CREATE TABLE " +
                dietEntry.TABLE_NAME +" ("+
                dietEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                dietEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                dietEntry.COLUMN_KCAL  + " INTEGER NOT NULL, "+
                dietEntry.COLUMN_PROTEIN  + " INTEGER NOT NULL, "+
                dietEntry.COLUMN_FAT + " INTEGER NOT NULL, "+
                dietEntry.COLUMN_CARB+ " INTEGER NOT NULL, "+
                ");";
        db.execSQL(SQL_CREATE_DIET_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS " + dietEntry.TABLE_NAME);
onCreate(db);
    }
}
