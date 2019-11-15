package pl.kosmalski.trenermobilny;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DailyDietAdapter extends RecyclerView.Adapter<DailyDietAdapter.DailyDietViewHolder> {
    private Context mdContext;
    private Cursor mdCursor;

    public DailyDietAdapter(Context context, Cursor cursor) {
        mdContext = context;
        mdCursor = cursor;
    }

    public class DailyDietViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView kcalText;
        public TextView proteinText;
        public TextView fatText;
        public TextView carbText;
        public TextView gramText;

        public DailyDietViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.textview_name_item_daily);
            kcalText = itemView.findViewById(R.id.textview_kcal_item_daily);
            proteinText = itemView.findViewById(R.id.textview_protein_item_daily);
            fatText = itemView.findViewById(R.id.textview_fat_item_daily);
            carbText = itemView.findViewById(R.id.textview_carb_item_daily);
            gramText = itemView.findViewById(R.id.textview_gram_item_daily);
        }

    }

    @Override
    public DailyDietViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mdContext);
        View view = inflater.inflate(R.layout.daily_item, parent, false);
        return new DailyDietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyDietViewHolder holder, int position) {
        if (!mdCursor.moveToPosition(position)) {
            return;
        }

        String name = mdCursor.getString(mdCursor.getColumnIndex(DailyDietContract.DietEntry.COLUMN_NAME));
        float kcal = mdCursor.getFloat(mdCursor.getColumnIndex(DailyDietContract.DietEntry.COLUMN_KCAL));
        float protein = mdCursor.getFloat(mdCursor.getColumnIndex(DailyDietContract.DietEntry.COLUMN_PROTEIN));
        float fat = mdCursor.getFloat(mdCursor.getColumnIndex(DailyDietContract.DietEntry.COLUMN_FAT));
        float carb = mdCursor.getFloat(mdCursor.getColumnIndex(DailyDietContract.DietEntry.COLUMN_CARB));
        float gram = mdCursor.getFloat(mdCursor.getColumnIndex(DailyDietContract.DietEntry.COLUMN_GRAM));
        long id = mdCursor.getLong(mdCursor.getColumnIndex(DailyDietContract.DietEntry._ID));

        holder.nameText.setText(name);
        holder.kcalText.setText(" k:"+String.valueOf(kcal));
        holder.proteinText.setText(" b:"+String.valueOf(protein));
        holder.fatText.setText(" t:"+String.valueOf(fat));
        holder.carbText.setText(" w:"+String.valueOf(carb));
        holder.gramText.setText(" g:"+String.valueOf(gram));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mdCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mdCursor != null) {
            mdCursor.close();
        }

        mdCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}
