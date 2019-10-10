package pl.kosmalski.trenermobilny;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class TrainingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
         {

    Spinner spinnerWorkouts;
    SharedPreferences LastSelect;
    SharedPreferences.Editor editor;


    private LinearLayout linearLayoutTrainingA,linearLayoutWeightConfiguration;
    private CheckBox checkBoxSquats,checkBoxBenchPress,checkBoxRowing,checkBoxRisingSideways,checkBoxBiceps,checkBoxTriceps,checkBoxAllahs,checkBoxCalves,checkBoxFacepull;
    private TextView textViewMaxKg,textViewSquat;
    private EditText editTextSquat,editTextBenchPress,editTextRowing,editTextRisingSideways,editTextBiceps,editTextTriceps;
    private Button buttonWeightConfiguration,buttonTrainingConfiguration,buttonSaveWeightConfiguration,buttonFinishWorkout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
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


//        Intent intentGetSquat = getIntent();
//        final String Squat = intentGetSquat.getStringExtra("EXTRA_MESAGE_SQUAT");

//        final SharedPreferences result = getSharedPreferences("autoSaveSquat",Context.MODE_PRIVATE);
//        final String value = result.getString("autoSaveSquat", "");



        linearLayoutTrainingA = (LinearLayout)findViewById(R.id.linearLayoutTrainingA);
        linearLayoutWeightConfiguration = (LinearLayout)findViewById(R.id.linearLayoutWeightConfiguration);
        checkBoxSquats = (CheckBox)findViewById(R.id.checkBoxSquats);
        checkBoxBenchPress = (CheckBox)findViewById(R.id.checkBoxBenchPress);
        checkBoxRowing = (CheckBox)findViewById(R.id.checkBoxRowing);
        checkBoxRisingSideways = (CheckBox)findViewById(R.id.checkBoxRisingSideways);
        checkBoxBiceps = (CheckBox)findViewById(R.id.checkBoxBiceps);
        checkBoxTriceps = (CheckBox)findViewById(R.id.checkBoxTriceps);
        checkBoxAllahs = (CheckBox)findViewById(R.id.checkBoxAllahs);
        checkBoxCalves = (CheckBox)findViewById(R.id.checkBoxCalves);
        checkBoxFacepull = (CheckBox)findViewById(R.id.checkBoxFacepull);

        buttonWeightConfiguration=(Button)findViewById(R.id.buttonWeightConfiguration);
        buttonTrainingConfiguration = (Button)findViewById(R.id.buttonTrainingConfiguration);
        buttonSaveWeightConfiguration =(Button)findViewById(R.id.buttonSaveWeightConfiguration);
        buttonFinishWorkout =(Button)findViewById(R.id.buttonFinishWorkout);
        textViewMaxKg =(TextView)findViewById(R.id.textViewMaxKg);
        textViewSquat =(TextView)findViewById(R.id.textViewSquat);

        editTextSquat = (EditText)findViewById(R.id.editTextSquat);
        editTextBenchPress  = (EditText)findViewById(R.id.editTextBenchPress);
        editTextRowing  = (EditText)findViewById(R.id.editTextRowing);
        editTextRisingSideways = (EditText)findViewById(R.id.editTextRisingSideways);
        editTextBiceps  = (EditText)findViewById(R.id.editTextBiceps);
        editTextTriceps  = (EditText)findViewById(R.id.editTextTriceps);



        buttonWeightConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayoutWeightConfiguration.setVisibility(View.VISIBLE);
                buttonSaveWeightConfiguration.setVisibility(View.VISIBLE);
            }
        });

        buttonTrainingConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        buttonSaveWeightConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutWeightConfiguration.setVisibility(View.GONE);
                buttonSaveWeightConfiguration.setVisibility(View.GONE);
                calcWeightConfiguration();
            }
        });

        buttonFinishWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcWeightConfiguration();


            }
        });


        LastSelect= getSharedPreferences("LastSetting", Context.MODE_PRIVATE);
        editor=LastSelect.edit();
        final int LastClick = LastSelect.getInt("LastClick",0);

        spinnerWorkouts =findViewById(R.id.spinnerWorkouts);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Workouts, android.R.layout.simple_spinner_dropdown_item);
        spinnerWorkouts.setAdapter(adapter);
        spinnerWorkouts.setSelection(LastClick);
        spinnerWorkouts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editor.putInt("LastClick",position).commit();

                switch (position) {
                    case 0:
                        linearLayoutTrainingA.setVisibility(View.GONE);
                        buttonTrainingConfiguration.setVisibility(View.GONE);
                        buttonWeightConfiguration.setVisibility(View.GONE);
                        buttonFinishWorkout.setVisibility(View.GONE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        buttonSaveWeightConfiguration.setVisibility(View.GONE);
                        break;

                    case 1:
                        linearLayoutTrainingA.setVisibility(View.VISIBLE);
                        buttonTrainingConfiguration.setVisibility(View.GONE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        buttonFinishWorkout.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        buttonSaveWeightConfiguration.setVisibility(View.GONE);
                        calcWeightConfiguration();

                        break;

                    case 2:
                        linearLayoutTrainingA.setVisibility(View.GONE);
                        buttonTrainingConfiguration.setVisibility(View.VISIBLE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        buttonSaveWeightConfiguration.setVisibility(View.GONE);
                        break;
                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        final SharedPreferences prefsSquatMax = PreferenceManager.getDefaultSharedPreferences(this);
        editTextSquat.setText(prefsSquatMax.getString("autoSaveSquatMax", ""));
        editTextSquat.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                prefsSquatMax.edit().putString("autoSaveSquatMax", s.toString()).apply();


            }
        });

        final SharedPreferences prefsBenchPressMax = PreferenceManager.getDefaultSharedPreferences(this);
        editTextBenchPress.setText(prefsSquatMax.getString("autoSaveBenchPressMax", ""));
        editTextBenchPress.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                prefsBenchPressMax.edit().putString("autoSaveBenchPressMax", s.toString()).apply();


            }
        });

        final SharedPreferences prefsRowingMax = PreferenceManager.getDefaultSharedPreferences(this);
        editTextRowing.setText(prefsSquatMax.getString("autoSaveRowingMax", ""));
        editTextRowing.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                prefsRowingMax.edit().putString("autoSaveRowingMax", s.toString()).apply();
            }
        });

        final SharedPreferences prefsRisingSidewaysMax = PreferenceManager.getDefaultSharedPreferences(this);
        editTextRisingSideways.setText(prefsSquatMax.getString("autoSaveRisingSidewaysMax", ""));
        editTextRisingSideways.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                prefsRisingSidewaysMax.edit().putString("autoSaveRisingSidewaysMax", s.toString()).apply();
            }
        });


        final SharedPreferences prefsBicepsMax = PreferenceManager.getDefaultSharedPreferences(this);
        editTextBiceps.setText(prefsSquatMax.getString("autoSaveBicepsMax", ""));
        editTextBiceps.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                prefsBicepsMax.edit().putString("autoSaveBicepsMax", s.toString()).apply();
            }



        });

        final SharedPreferences prefsTricepsMax = PreferenceManager.getDefaultSharedPreferences(this);
        editTextTriceps.setText(prefsSquatMax.getString("autoSaveTricepsMax", ""));
        editTextTriceps.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count)
            {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                prefsTricepsMax.edit().putString("autoSaveTricepsMax", s.toString()).apply();
            }



        });




    }

             private void calcWeightConfiguration() {
                 if (editTextSquat.getText().length() != 0 && checkBoxSquats.isChecked()){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady "+5+" x "+nSeries);
                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextSquat.getText().length() != 0 && !checkBoxSquats.isChecked()){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady "+5+" x "+nSeries);
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextSquat.getText().length() == 0) {
                     checkBoxSquats.setText("brak konfiguracji obciążenia dla Przysiadów");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }



                  if (editTextBenchPress.getText().length() != 0 && checkBoxBenchPress.isChecked()){
                     double n1 = Double.parseDouble(editTextBenchPress.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxBenchPress.setText("Wyciskanie Leżąc "+5+" x "+nSeries);
                     editTextBenchPress.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextBenchPress.getText().length() != 0 && !checkBoxBenchPress.isChecked()){
                     double n1 = Double.parseDouble(editTextBenchPress.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxBenchPress.setText("Wyciskanie Leżąc "+5+" x "+nSeries);
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextBenchPress.getText().length() == 0) {
                     checkBoxBenchPress.setText("brak konfiguracji obciążenia dla Wyciskania Leżąc");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextRowing.getText().length() != 0 && checkBoxRowing.isChecked()){
                     double n1 = Double.parseDouble(editTextRowing.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxRowing.setText("Wiosłowanie "+5+" x "+nSeries);
                     editTextRowing.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextRowing.getText().length() != 0 && !checkBoxRowing.isChecked()){
                     double n1 = Double.parseDouble(editTextRowing.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxRowing.setText("Wiosłowanie "+5+" x "+nSeries);
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextRowing.getText().length() == 0) {
                     checkBoxRowing.setText("brak konfiguracji obciążenia dla Wiosłowania");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }


             }


//
//             private void openWeightConfiguration() {
//
//             }

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
        getMenuInflater().inflate(R.menu.training, menu);
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
                Intent p = new Intent(TrainingActivity.this,MainActivity.class);
                startActivity(p);
                break;
            case R.id.nav_diet:
                Intent d = new Intent(TrainingActivity.this,DietActivity.class);
                startActivity(d);
                break;
            case R.id.nav_trening:
                Intent t = new Intent(TrainingActivity.this,TrainingActivity.class);
                startActivity(t);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
