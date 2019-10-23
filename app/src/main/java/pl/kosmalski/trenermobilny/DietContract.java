package pl.kosmalski.trenermobilny;

import android.provider.BaseColumns;

public class DietContract  {

    private DietContract(){}

    public static final class dietEntry implements BaseColumns{
    public static final String TABLE_NAME ="dietList";
    public static final String COLUMN_NAME= "Nazawa";
    public static final String COLUMN_KCAL= "Kcal";
    public static final String COLUMN_PROTEIN= "Białko";
    public static final String COLUMN_FAT= "Tłuszcze";
    public static final String COLUMN_CARB= "Węglowodany";}
}
