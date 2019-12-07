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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
     private SharedPreferences prefs;

//    private TextView trainingPreferences ;
//    private CheckBox checkBoxMusculature;
//    private RadioGroup radioGroupTrainingPreferences;

    // this will be key for the key value pair
    public static final String ButtonStateMale = "ButtonStateMale";
    public static final String ButtonStateFemale = "ButtonStateFemale";

    public static final String ButtonStateDecrease = "ButtonStateDecrease";
    public static final String ButtonStateMaintain = "ButtonStateMaintain";
    public static final String ButtonStateIncrease = "ButtonStateIncrease";

//    public static final String ButtonStateGym = "ButtonStateGym ";
//    public static final String ButtonStateStreetWorkout= "ButtonStaterStreetWorkout";
//    public static final String ButtonStateHome = "ButtonStateHome";
//
//    public static final String CheckBoxStateMusculature = "CheckBoxStateMusculature";


    // this is name of shared preferences file, must be same whenever accessing
    // the key value pair.
    public static final String MyPreferences = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



//        trainingPreferences = (TextView) findViewById(R.id.textViewTrainingPreferences) ;
//        checkBoxMusculature = (CheckBox)findViewById(R.id.checkBoxMusculature);
//        radioGroupTrainingPreferences =  (RadioGroup)findViewById(R.id.radioGroupTrainingPreferences);


        // helper method to open up the file.
        sharedpreferences = getSharedPreferences("prefs", 0);
        // grab the last saved state here on each activity start
        Boolean lastButtonStateMale = sharedpreferences.getBoolean(ButtonStateMale, false);
        Boolean lastButtonStateFemale = sharedpreferences.getBoolean(ButtonStateFemale, false);


        Boolean lastButtonStateDecrease = sharedpreferences.getBoolean(ButtonStateDecrease, false);
        Boolean lastButtonStateMaintain = sharedpreferences.getBoolean(ButtonStateMaintain, false);
        Boolean lastButtonStateIncrease = sharedpreferences.getBoolean(ButtonStateIncrease, false);


//        Boolean lastButtonStateGym= sharedpreferences.getBoolean(ButtonStateGym, false);
//        Boolean lastButtonStateStreetWorkout = sharedpreferences.getBoolean(ButtonStateStreetWorkout, false);
//        Boolean lastButtonStateHome = sharedpreferences.getBoolean(ButtonStateHome, false);
//
//        Boolean lastCheckBoxStateMusculature = sharedpreferences.getBoolean(CheckBoxStateMusculature, false);


        final RadioButton radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        final RadioButton radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);


        final RadioButton radioButtonDecrease = (RadioButton) findViewById(R.id.radioButtonDecrease);
        final RadioButton radioButtonMaintain = (RadioButton) findViewById(R.id.radioButtonMaintain);
        final RadioButton radioButtonIncrease = (RadioButton) findViewById(R.id.radioButtonIncrease);


//        final RadioButton radioButtonGym = (RadioButton) findViewById(R.id.radioButtonGym);
//        final RadioButton radioButtonStreetWorkout = (RadioButton) findViewById(R.id.radioButtonStreetWorkout);
//        final RadioButton radioButtonHome = (RadioButton) findViewById(R.id.radioButtonHome);


        // restore previous state
        radioButtonMale.setChecked(lastButtonStateMale);
        radioButtonFemale.setChecked(lastButtonStateFemale);

        radioButtonDecrease.setChecked(lastButtonStateDecrease);
        radioButtonMaintain.setChecked(lastButtonStateMaintain);
        radioButtonIncrease.setChecked(lastButtonStateIncrease);

//        radioButtonGym.setChecked(lastButtonStateGym);
//        radioButtonStreetWorkout.setChecked(lastButtonStateStreetWorkout);
//        radioButtonHome.setChecked(lastButtonStateHome);

//        checkBoxMusculature.setChecked(lastCheckBoxStateMusculature);


        // set a listener
        radioButtonMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call this to enable editing of the shared preferences file
                // in the event of a change
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Boolean isChecked = radioButtonMale.isChecked();
                Boolean isNoChecked = radioButtonFemale.isChecked();
                // use this to add the new state
                editor.putBoolean(ButtonStateFemale, isNoChecked);
                editor.putBoolean(ButtonStateMale, isChecked);
                // save
                editor.apply();
            }


        });


        radioButtonFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call this to enable editing of the shared preferences file
                // in the event of a change
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Boolean isChecked = radioButtonFemale.isChecked();
                Boolean isNoChecked = radioButtonMale.isChecked();
                // use this to add the new state
                editor.putBoolean(ButtonStateMale, isNoChecked);
                editor.putBoolean(ButtonStateFemale, isChecked);
                // save
                editor.apply();
            }


        });


        radioButtonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call this to enable editing of the shared preferences file
                // in the event of a change
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Boolean isCheckedDecrease = radioButtonDecrease.isChecked();
                Boolean isCheckedMaintain = radioButtonMaintain.isChecked();
                Boolean isCheckedIncrease = radioButtonIncrease.isChecked();
                // use this to add the new state
                editor.putBoolean(ButtonStateDecrease, isCheckedDecrease);
                editor.putBoolean(ButtonStateMaintain, isCheckedMaintain);
                editor.putBoolean(ButtonStateIncrease, isCheckedIncrease);
                // save
                editor.apply();
            }


        });


        radioButtonMaintain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call this to enable editing of the shared preferences file
                // in the event of a change
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Boolean isCheckedDecrease = radioButtonDecrease.isChecked();
                Boolean isCheckedMaintain = radioButtonMaintain.isChecked();
                Boolean isCheckedIncrease = radioButtonIncrease.isChecked();
                // use this to add the new state
                editor.putBoolean(ButtonStateDecrease, isCheckedDecrease);
                editor.putBoolean(ButtonStateMaintain, isCheckedMaintain);
                editor.putBoolean(ButtonStateIncrease, isCheckedIncrease);
                // save
                editor.apply();
            }


        });


        radioButtonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call this to enable editing of the shared preferences file
                // in the event of a change
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Boolean isCheckedDecrease = radioButtonDecrease.isChecked();
                Boolean isCheckedMaintain = radioButtonMaintain.isChecked();
                Boolean isCheckedIncrease = radioButtonIncrease.isChecked();
                // use this to add the new state
                editor.putBoolean(ButtonStateDecrease, isCheckedDecrease);
                editor.putBoolean(ButtonStateMaintain, isCheckedMaintain);
                editor.putBoolean(ButtonStateIncrease, isCheckedIncrease);
                // save
                editor.apply();
            }


        });

//
//        radioButtonGym.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // call this to enable editing of the shared preferences file
//                // in the event of a change
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                Boolean isCheckedGym = radioButtonGym.isChecked();
//                Boolean isCheckedStreetWorkout = radioButtonStreetWorkout.isChecked();
//                Boolean isCheckedHome = radioButtonHome.isChecked();
//                // use this to add the new state
//                editor.putBoolean(ButtonStateGym, isCheckedGym);
//                editor.putBoolean(ButtonStateStreetWorkout, isCheckedStreetWorkout);
//                editor.putBoolean(ButtonStateHome, isCheckedHome);
//                // save
//                editor.apply();
//            }
//
//
//        });
//
//        radioButtonStreetWorkout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // call this to enable editing of the shared preferences file
//                // in the event of a change
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                Boolean isCheckedGym = radioButtonGym.isChecked();
//                Boolean isCheckedStreetWorkout = radioButtonStreetWorkout.isChecked();
//                Boolean isCheckedHome = radioButtonHome.isChecked();
//                // use this to add the new state
//                editor.putBoolean(ButtonStateGym, isCheckedGym);
//                editor.putBoolean(ButtonStateStreetWorkout, isCheckedStreetWorkout);
//                editor.putBoolean(ButtonStateHome, isCheckedHome);
//                // save
//                editor.apply();
//            }
//
//
//        });
//
//        radioButtonHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // call this to enable editing of the shared preferences file
//                // in the event of a change
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                Boolean isCheckedGym = radioButtonGym.isChecked();
//                Boolean isCheckedStreetWorkout = radioButtonStreetWorkout.isChecked();
//                Boolean isCheckedHome = radioButtonHome.isChecked();
//                // use this to add the new state
//                editor.putBoolean(ButtonStateGym, isCheckedGym);
//                editor.putBoolean(ButtonStateStreetWorkout, isCheckedStreetWorkout);
//                editor.putBoolean(ButtonStateHome, isCheckedHome);
//                // save
//                editor.apply();
//            }
//
//
//        });




        prefs = getSharedPreferences("prefs", 0);
        EditText age = (EditText) findViewById(R.id.editTextAge);
        age.setText(prefs.getString("autoSaveAge", ""));
        age.addTextChangedListener(new TextWatcher() {
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
                prefs.edit().putString("autoSaveAge", s.toString()).apply();
            }
        });




        EditText height = (EditText) findViewById(R.id.editTextHeight);
        height.setText(prefs.getString("autoSaveHeight", ""));
        height.addTextChangedListener(new TextWatcher() {
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
                prefs.edit().putString("autoSaveHeight", s.toString()).apply();
            }
        });


        EditText weight = (EditText) findViewById(R.id.editTextWeight);
        weight.setText(prefs.getString("autoSaveWeight", ""));
        weight.addTextChangedListener(new TextWatcher() {
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
                prefs.edit().putString("autoSaveWeight", s.toString()).apply();
            }
        });




//        checkBoxMusculature.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(((CompoundButton) view).isChecked()){
//
//                    trainingPreferences.setVisibility(View.VISIBLE);
//                    radioGroupTrainingPreferences.setVisibility(View.VISIBLE);
//
//                    SharedPreferences.Editor editor = sharedpreferences.edit();
//                    Boolean isChecked = checkBoxMusculature.isChecked();
//                    // use this to add the new state
//                    editor.putBoolean(CheckBoxStateMusculature, isChecked);
//                    // save
//                    editor.apply();
//
//                } else {
//
//                    trainingPreferences.setVisibility(View.GONE);
//                    radioGroupTrainingPreferences.setVisibility(View.GONE);
//
//                    SharedPreferences.Editor editor = sharedpreferences.edit();
//                    Boolean isChecked = checkBoxMusculature.isChecked();
//                    // use this to add the new state
//                    editor.putBoolean(CheckBoxStateMusculature, isChecked);
//                    // save
//                    editor.apply();
//                }
//            }
//        });
//
//
//        {
//            //code to check if this checkbox is checked!
//
//            if(checkBoxMusculature.isChecked()){
//
//                trainingPreferences.setVisibility(View.VISIBLE);
//                radioGroupTrainingPreferences.setVisibility(View.VISIBLE);
//            }
//
//            else{
//                trainingPreferences.setVisibility(View.GONE);
//                radioGroupTrainingPreferences.setVisibility(View.GONE);
//            }
//        }


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
        getMenuInflater().inflate(R.menu.main, menu);
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
                Intent p = new Intent(MainActivity.this,MainActivity.class);
                startActivity(p);
                break;
            case R.id.nav_diet:
                Intent d = new Intent(MainActivity.this,DietActivity.class);
                startActivity(d);
                break;
            case R.id.nav_trening:
                Intent t = new Intent(MainActivity.this,TrainingActivity.class);
                startActivity(t);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
