package pl.kosmalski.trenermobilny;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DietAdapter extends RecyclerView.Adapter<DietAdapter.DietViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public DietAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    public class DietViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView kcalText;
        public TextView proteinText;
        public TextView fatText;
        public TextView carbText;

        public DietViewHolder(View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.textview_name_item);
            kcalText = itemView.findViewById(R.id.textview_kcal_item);
            proteinText = itemView.findViewById(R.id.textview_protein_item);
            fatText = itemView.findViewById(R.id.textview_fat_item);
            carbText = itemView.findViewById(R.id.textview_carb_item);
        }

    }

    @Override
    public DietViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.diet_item, parent, false);
        return new DietViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DietViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(DietContract.DietEntry.COLUMN_NAME));
        float kcal = mCursor.getFloat(mCursor.getColumnIndex(DietContract.DietEntry.COLUMN_KCAL));
        float protein = mCursor.getFloat(mCursor.getColumnIndex(DietContract.DietEntry.COLUMN_PROTEIN));
        float fat = mCursor.getFloat(mCursor.getColumnIndex(DietContract.DietEntry.COLUMN_FAT));
        float carb = mCursor.getFloat(mCursor.getColumnIndex(DietContract.DietEntry.COLUMN_CARB));
        long id = mCursor.getLong(mCursor.getColumnIndex(DietContract.DietEntry._ID));

        holder.nameText.setText(name);
        holder.kcalText.setText(" k:"+String.valueOf(kcal));
        holder.proteinText.setText(" b:"+String.valueOf(protein));
        holder.fatText.setText(" t:"+String.valueOf(fat));
        holder.carbText.setText(" w:"+String.valueOf(carb));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }
}
