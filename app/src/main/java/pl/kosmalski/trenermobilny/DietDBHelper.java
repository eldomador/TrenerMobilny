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
        db.execSQL("INSERT INTO "+TABLE_NAME+"(name,kcal,protein,fat,carb) values ('Agrest',41.0,0.8,0.2,11.8)," +
                "('Ananas',54.0,0.4,0.2,13.6),('Anyż',337.0,17.6,16.0,50.0),('Arbuz',36.0,0.6,0.1,8.4),('Avocado',160.0,2.0,15.3,7.4),('Bakłażan',21.0,1.1,0.1,6.3)," +
                "('Baleron',244.0,15.1,20.2,0.9),('Banan',95.0,1.0,0.3,23.5),('Bób',66.0,7.1,0.4,14.0),('Brokuły',27.0,3.0,0.4,5.2),('Brukselka',37.0,4.7,0.5,8.7),('Brzoskwinia',46.0,1.0,0.2,11.9),('Bułka owsiana',304.0,9.3,4.5,58.4),('Bułka pszenna',273.0,8.1,1.5,57.7),('Bułka sojowa',315.0,10.1,4.0,61.1),('Bułka tarta',347.0,9.7,1.9,77.6),('Burak',38.0,1.8,0.1,9.5),('Cebula',30.0,1.4,0.4,6.9),('Chili',40.0,0.4,0.1,1.8),('Chleb pszenny',257.0,8.5,1.4,54.3),('Chleb zwykły',248.0,6.1,1.3,56.3),('Chrzan',67.0,4.5,0.6,18.1),('Cieciorka',364.0,19.3,6.0,60.6),('Cukier',405.0,0.0,0.0,99.8),('Cukinia',15.0,1.2,0.1,3.2),('Curry',325.0,13.0,14.0,58.0),('Ćwikła',40.0,1.6,0.1,10.2),('Cykoria',21.0,1.7,0.2,4.1),('Cynamon',247.0,4.0,1.2,81.0),('Cytryna',36.0,0.8,0.3,9.5),('Czereśnie',61.0,1.0,0.3,14.6),('Czosnek',146.0,6.4,0.5,32.6),('Dynia',28.0,1.3,0.3,7.7),('Flądra',83.0,16.5,1.8,0.0),('Goździk',323.0,6.0,20.0,61.0),('Grahamka',252.0,9.0,1.7,56.1),('Granat',83.0,1.7,1.2,18.7),('Grejpfrut',36.0,0.6,0.2,9.8),('Gruszka',54.0,0.6,0.2,14.4)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}