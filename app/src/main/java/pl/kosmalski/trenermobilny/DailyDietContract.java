package pl.kosmalski.trenermobilny;

import android.provider.BaseColumns;

public class DailyDietContract {

    private DailyDietContract() {
    }

    public static final class DietEntry implements BaseColumns {
        public static final String TABLE_NAME = "DailydietList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_KCAL = "kcal";
        public static final String COLUMN_PROTEIN = "protein";
        public static final String COLUMN_FAT = "fat";
        public static final String COLUMN_CARB = "carb";
        public static final String COLUMN_GRAM = "gram";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
