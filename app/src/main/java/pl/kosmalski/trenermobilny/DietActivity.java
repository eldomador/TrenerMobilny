package pl.kosmalski.trenermobilny;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class DietActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SQLiteDatabase mDatabase, mdDatabase;
    private DietAdapter mAdapter;
    private DailyDietAdapter mdAdapter;
    private String stringSearch;
    private float proteinSum=0,fatSum=0,carbSum=0,kcalSum=0,age=0,height=0,weight=0,kcalmax=0;
    private boolean male,female,weightDecrease,weightMaintain,weightIncrease;
    private EditText editTextName,editTextKcal,editTextProtein,editTextFat,editTextCarb,editTextSearch,editTextGram;
    private TextView textViewKcalSum,textViewProteinSum,textViewFatSum,textViewCarbSum;
    private LinearLayout linearLayoutSearch,linearLayoutAddModule;
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        DietDBHelper dbHelper = new DietDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DietAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction==ItemTouchHelper.LEFT){
                    removeItem((long) viewHolder.itemView.getTag());
                    Toast.makeText(getApplicationContext(),"Usunięto",Toast.LENGTH_LONG).show();
                }
                if (direction==ItemTouchHelper.RIGHT && editTextGram.getText().length() != 0){
                    addItemMF((long) viewHolder.itemView.getTag());
//                    String s = String.valueOf(viewHolder.itemView.getTag());
//                    Toast.makeText(getApplicationContext(),"Dodano"+s,Toast.LENGTH_LONG).show();
                }
                else{

                    mAdapter.swapCursor(getAllItems());
                    Toast.makeText(getApplicationContext(),"Wpisz ilość gram produktu.",Toast.LENGTH_LONG).show();
                }
            }
        }).attachToRecyclerView(recyclerView);



        DailyDietDBHelper dailyDietDBHelper = new DailyDietDBHelper(this);
        mdDatabase = dailyDietDBHelper.getWritableDatabase();

        RecyclerView dailyRecyclerView = findViewById(R.id.recyclerviewDaily);
        dailyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mdAdapter = new DailyDietAdapter(this, getAllDailyItems());
        dailyRecyclerView.setAdapter(mdAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

                if (direction==ItemTouchHelper.LEFT){
                    removeDailyItem((long) viewHolder.itemView.getTag());
                }

            }
        }).attachToRecyclerView(dailyRecyclerView);


        prefs = getSharedPreferences("prefs", 0);
        editor = prefs.edit();
        kcalSum = prefs.getFloat("kcal", 0.0f);
        proteinSum = prefs.getFloat("protein", 0.0f);
        fatSum = prefs.getFloat("fat", 0.0f);
        carbSum = prefs.getFloat("carb", 0.0f);

        if((prefs.getString("autoSaveAge", "0").length() != 0)){
            age = Float.parseFloat(prefs.getString("autoSaveAge", "0"));
        }

        if((prefs.getString("autoSaveHeight", "0").length() != 0)){
            height = Float.parseFloat(prefs.getString("autoSaveHeight", "0"));
        }

        if((prefs.getString("autoSaveWeight", "0").length() != 0)){
            weight = Float.parseFloat(prefs.getString("autoSaveWeight", "0"));
        }



        male  = prefs.getBoolean("ButtonStateMale", false);
        female = prefs.getBoolean("ButtonStateFemale", false);

        weightDecrease = prefs.getBoolean("ButtonStateDecrease", false);
        weightMaintain = prefs.getBoolean("ButtonStateMaintain", false);
        weightIncrease = prefs.getBoolean("ButtonStateIncrease", false);
//        Toast.makeText(getApplicationContext(),"mniej "+weightDecrease+" nic "+weightMaintain+" wiecej "+weightIncrease,Toast.LENGTH_LONG).show();


        editTextSearch = findViewById(R.id.editTextSearch);
        editTextName = findViewById(R.id.editTextName);
        editTextKcal = findViewById(R.id.editTextKcal);
        editTextProtein = findViewById(R.id.editTextProtein);
        editTextFat  = findViewById(R.id.editTextFat);
        editTextCarb  = findViewById(R.id.editTextCarb);
        editTextGram = findViewById(R.id.editTextGram);
        textViewKcalSum = findViewById(R.id.textViewKcalSum);
        textViewProteinSum = findViewById(R.id.textViewProteinSum);
        textViewFatSum= findViewById(R.id.textViewfatSum);
        textViewCarbSum= findViewById(R.id.textViewCarbSum);
        Button buttonAddCustom = findViewById(R.id.buttonAddCustomProduct);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        linearLayoutSearch = findViewById(R.id.linearLayoutSearch);
        linearLayoutAddModule = findViewById(R.id.linearLayoutAddModule);
        linearLayoutAddModule.setVisibility(View.GONE);
        textViewProteinSum.setText("białko: "+proteinSum);
        textViewFatSum.setText("tłuszcze: "+fatSum);
        textViewCarbSum.setText("węglowodany: "+carbSum);


        if (weight != 0 && height != 0 && age != 0 && male && weightDecrease ) {
            kcalmax = (66 + (13.7f *weight) + (5 * height) - (6.76f * age))-300;
            textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);
        }

        else if (weight != 0 && height != 0 && age != 0 && male && weightMaintain ) {
            kcalmax = 66 + (13.7f *weight) + (5 * height) - (6.76f * age);
            textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);
        }

        else if (weight != 0 && height != 0 && age != 0 && male && weightIncrease ) {
            kcalmax = (66 + (13.7f *weight) + (5 * height) - (6.76f * age))+300;
            textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);
        }

        else if (weight != 0 && height != 0 && age != 0 && female && weightDecrease) {
            kcalmax =(655 +(9.6f *weight)+(1.8f *height)-(4.7f* age))-250;
            textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);
        }

        else if (weight != 0 && height != 0 && age != 0 && female && weightMaintain) {
            kcalmax =655 +(9.6f *weight)+(1.8f *height)-(4.7f* age);
            textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);
        }

        else if (weight != 0 && height != 0 && age != 0 && female && weightDecrease) {
            kcalmax =(655 +(9.6f *weight)+(1.8f *height)-(4.7f* age))+250;
            textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);
        }

        else {
            textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);
        }


        buttonAddCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustom();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
        editTextSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) { }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                stringSearch = editTextSearch.getText().toString();
                mAdapter.swapCursor(getItems(stringSearch));

            }
        });

    }


    private void addCustom() {
        linearLayoutAddModule.setVisibility(View.VISIBLE);
        linearLayoutSearch.setVisibility(View.GONE);
    }


    private void addItem() {

        if (editTextName.getText().toString().trim().length() == 0) {
            return;
        }

        String name = editTextName.getText().toString();
        float kcal = Float.parseFloat(editTextKcal.getText().toString());
        float protein = Float.parseFloat(editTextProtein.getText().toString());
        float fat = Float.parseFloat(editTextFat.getText().toString());
        float carb = Float.parseFloat(editTextCarb.getText().toString());
        ContentValues cv = new ContentValues();
        cv.put(DietContract.DietEntry.COLUMN_NAME, name);
        cv.put(DietContract.DietEntry.COLUMN_KCAL, kcal);
        cv.put(DietContract.DietEntry.COLUMN_PROTEIN, protein);
        cv.put(DietContract.DietEntry.COLUMN_FAT, fat);
        cv.put(DietContract.DietEntry.COLUMN_CARB, carb);

        mDatabase.insert(DietContract.DietEntry.TABLE_NAME, null, cv);
        mAdapter.swapCursor(getAllItems());

        editTextName.getText().clear();
        editTextKcal.getText().clear();
        editTextProtein.getText().clear();
        editTextFat.getText().clear();
        editTextCarb.getText().clear();
        linearLayoutAddModule.setVisibility(View.GONE);
        linearLayoutSearch.setVisibility(View.VISIBLE);
    }

    private void addItemMF(long id) {

        String name = " ";
        float gram =  Float.parseFloat(editTextGram.getText().toString());
        float kcal = 0;
        float protein = 0;
        float fat = 0;
        float carb = 0;
        Cursor csr = mDatabase.query(DietContract.DietEntry.TABLE_NAME,null,"_ID="+id,null,null,null,null);
        if (csr.moveToFirst()) {
            name = csr.getString(csr.getColumnIndex(DietContract.DietEntry.COLUMN_NAME));
            kcal = csr.getFloat(csr.getColumnIndex(DietContract.DietEntry.COLUMN_KCAL));
            protein = csr.getFloat(csr.getColumnIndex(DietContract.DietEntry.COLUMN_PROTEIN));
            fat = csr.getFloat(csr.getColumnIndex(DietContract.DietEntry.COLUMN_FAT));
            carb = csr.getFloat(csr.getColumnIndex(DietContract.DietEntry.COLUMN_CARB));
        }

        float proteinDaily = (float) round((protein/100)*gram, 3, BigDecimal.ROUND_HALF_UP);
        float fatDaily = (float) round((fat/100)*gram, 3, BigDecimal.ROUND_HALF_UP);
        float carbDaily = (float) round((carb/100)*gram, 3, BigDecimal.ROUND_HALF_UP);
        float kcalDaily = (float) round((kcal/100)*gram, 3, BigDecimal.ROUND_HALF_UP);




        kcalSum = prefs.getFloat("kcal", 0.0f);
        kcalSum = (float) round(kcalSum + kcalDaily, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("kcal", kcalSum);
        editor.commit();
        textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);



        proteinSum = prefs.getFloat("protein", 0.0f);
        proteinSum = (float) round(proteinSum + proteinDaily, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("protein", proteinSum);
        editor.commit();
        textViewProteinSum.setText("białko: "+proteinSum);

        fatSum = prefs.getFloat("fat", 0.0f);
        fatSum = (float) round(fatSum + fatDaily, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("fat", fatSum);
        editor.commit();
        textViewFatSum.setText("tłuszcze: "+fatSum);


        carbSum = prefs.getFloat("carb", 0.0f);
        carbSum = (float) round(carbSum +carbDaily, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("carb", carbSum);
        editor.commit();
        textViewCarbSum.setText("węglowodany: "+carbSum);


        ContentValues cv = new ContentValues();
        cv.put(DailyDietContract.DietEntry.COLUMN_NAME, name);
        cv.put(DailyDietContract.DietEntry.COLUMN_KCAL, kcalDaily);
        cv.put(DailyDietContract.DietEntry.COLUMN_PROTEIN, proteinDaily);
        cv.put(DailyDietContract.DietEntry.COLUMN_FAT, fatDaily);
        cv.put(DailyDietContract.DietEntry.COLUMN_CARB, carbDaily);
        cv.put(DailyDietContract.DietEntry.COLUMN_GRAM, gram);
        mdDatabase.insert(DailyDietContract.DietEntry.TABLE_NAME,
                null, cv);
        mdAdapter.swapCursor(getAllDailyItems());
        Toast.makeText(getApplicationContext(),"Dodano "+name,Toast.LENGTH_LONG).show();
        mAdapter.swapCursor(getAllItems());
    }

    private void removeItem(long id) {
        mDatabase.delete(DietContract.DietEntry.TABLE_NAME,
                DietContract.DietEntry._ID + "=" + id, null);
        mAdapter.swapCursor(getAllItems());
    }

    private void removeDailyItem(long id) {
        float kcal = 0;
        float protein = 0;
        float fat = 0;
        float carb = 0;
        String name="";
        Cursor csr = mdDatabase.query(DailyDietContract.DietEntry.TABLE_NAME,null,"_ID="+id,null,null,null,null);
        if (csr.moveToFirst()) {
            name = csr.getString(csr.getColumnIndex(DailyDietContract.DietEntry.COLUMN_NAME));
            kcal = csr.getFloat(csr.getColumnIndex(DailyDietContract.DietEntry.COLUMN_KCAL));
            protein = csr.getFloat(csr.getColumnIndex(DailyDietContract.DietEntry.COLUMN_PROTEIN));
            fat = csr.getFloat(csr.getColumnIndex(DailyDietContract.DietEntry.COLUMN_FAT));
            carb = csr.getFloat(csr.getColumnIndex(DailyDietContract.DietEntry.COLUMN_CARB));
        }


        kcalSum = prefs.getFloat("kcal", 0.0f);
        kcalSum = (float) round( kcalSum - kcal, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("kcal", kcalSum);
        editor.commit();
        textViewKcalSum.setText("kcal: "+kcalSum+"/"+kcalmax);


        proteinSum = prefs.getFloat("protein", 0.0f);
        proteinSum = (float) round( proteinSum - protein, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("protein", proteinSum);
        editor.commit();
        textViewProteinSum.setText("białko: "+proteinSum);


        fatSum = prefs.getFloat("fat", 0.0f);
        fatSum = (float) round( fatSum - fat, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("fat", fatSum);
        editor.commit();
        textViewFatSum.setText("tłuszcze: "+fatSum);


        carbSum = prefs.getFloat("carb", 0.0f);
        carbSum = (float) round( carbSum - carb, 3, BigDecimal.ROUND_HALF_UP);
        editor.putFloat("carb",carbSum);
        editor.commit();
        textViewCarbSum.setText("węglowodany: "+carbSum);



        mdDatabase.delete(DailyDietContract.DietEntry.TABLE_NAME,
                DailyDietContract.DietEntry._ID + "=" + id, null);
        mdAdapter.swapCursor(getAllDailyItems());
        Toast.makeText(getApplicationContext(),"Usunięto "+name,Toast.LENGTH_LONG).show();

    }






    private Cursor getAllItems() {
        return mDatabase.query(
                DietContract.DietEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                DietContract.DietEntry.COLUMN_NAME + " ASC limit 10"

        );
    }

    private Cursor getAllDailyItems() {
        return mdDatabase.query(
                DailyDietContract.DietEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                DailyDietContract.DietEntry.COLUMN_NAME + " ASC limit 10"

        );
    }


    private Cursor getItems(String name) {
        return mDatabase.query(
                DietContract.DietEntry.TABLE_NAME,
                null,
                "name like " + "'%" +name+"%'",
                null,
                null,
                null,
                DietContract.DietEntry.COLUMN_NAME + " ASC limit 10"

        );
    }



    public static double round(double unrounded, int precision, int roundingMode)
    {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(precision, roundingMode);
        return rounded.doubleValue();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.diet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_profile:
                Intent p = new Intent(DietActivity.this,MainActivity.class);
                startActivity(p);
                break;
            case R.id.nav_diet:
                Intent d = new Intent(DietActivity.this,DietActivity.class);
                startActivity(d);
                break;
            case R.id.nav_trening:
                Intent t = new Intent(DietActivity.this,TrainingActivity.class);
                startActivity(t);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
