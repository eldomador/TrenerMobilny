package pl.kosmalski.trenermobilny.contract;

import android.provider.BaseColumns;

public class DietContract {

    private DietContract() {
    }

    public static final class DietEntry implements BaseColumns {
        public static final String TABLE_NAME = "dietList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_KCAL = "kcal";
        public static final String COLUMN_PROTEIN = "protein";
        public static final String COLUMN_FAT = "fat";
        public static final String COLUMN_CARB = "carb";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
