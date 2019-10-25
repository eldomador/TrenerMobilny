package pl.kosmalski.trenermobilny;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.math.BigDecimal;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context context,  String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PRODUCTS( ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT UNIQUE, KCAL FLOAT, PROTEIN FLOAT, FAT FLOAT, CARB FLOAT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCTS;");
    }


    public void insertProduct(String name,float kcal,float protein,float fat,float carb){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("KCAL",kcal);
        contentValues.put("PROTEIN",protein);
        contentValues.put("FAT",fat);
        contentValues.put("CARB",carb);
        this.getWritableDatabase().insertOrThrow("PRODUCTS",null,contentValues);
    }

    public void deleteProduct(String name){
        this.getWritableDatabase().delete("PRODUCTS","NAME='"+name+"'",null);
    }

    public void updateProduct(String oldName, String newName){
        this.getWritableDatabase().execSQL("UPDATE PRODUCTS SET NAME='"+newName+"' WHERE NAME='"+oldName+"'");
    }

    public void listAllProducts(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM PRODUCTS",null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(1)+" k:"+cursor.getString(2)+" B:"+cursor.getString(3)+" T:"+cursor.getString(4)+" W:"+cursor.getString(5)+"\n");
        }
    }

}
