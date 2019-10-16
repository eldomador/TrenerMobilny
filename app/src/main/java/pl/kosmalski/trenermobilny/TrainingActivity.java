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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TrainingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
         {

    Spinner spinnerWorkouts;
    SharedPreferences LastSelect;
    SharedPreferences.Editor editor;


    private LinearLayout linearLayoutTrainingA,linearLayoutWeightConfiguration,linearLayoutTrainingConfiguration;
    private CheckBox checkBoxSquats,checkBoxBenchPress,checkBoxRowing,checkBoxRisingSideways,checkBoxBiceps,checkBoxTriceps,
            checkBoxAllahs,checkBoxCalves,checkBoxFacepull,checkBoxDeadliftClassic,checkBoxOhp,checkBoxPullingUpNarrow,checkBoxNarrowBenchPress,checkBoxYRaise,
            checkBoxPlank,checkBoxSquatsConf,checkBoxBenchPressConf,checkBoxRowingConf,checkBoxRisingSidewaysConf,checkBoxBicepsConf,checkBoxTricepsConf,
            checkBoxAllahsConf,checkBoxCalvesConf,checkBoxFacepullConf,checkBoxDeadliftClassicConf,checkBoxOhpConf,checkBoxPullingUpNarrowConf,checkBoxNarrowBenchPressConf,checkBoxYRaiseConf,
            checkBoxPlankConf;
    private TextView textViewMaxKg,textViewSquat,textViewTrainingA,textViewTrainingB;
    private EditText editTextSquat,editTextBenchPress,editTextRowing,editTextRisingSideways,editTextBiceps,editTextTriceps,editTextAllahs,editTextFacepull,editTextDeadliftClassic,
            editTextOhp,editTextPullingUpNarrow,editTextNarrowBenchPress,editTextYRaise;
    private Button buttonWeightConfiguration,buttonTrainingConfiguration,buttonSaveWeightConfiguration,buttonFinishWorkout,buttonFinishWorkoutB,buttonSaveTrainingConfiguration;
    private int LastClick;
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
        linearLayoutTrainingConfiguration = (LinearLayout)findViewById(R.id.linearLayoutTrainingConfiguration);

        checkBoxSquats = (CheckBox)findViewById(R.id.checkBoxSquats);
        checkBoxBenchPress = (CheckBox)findViewById(R.id.checkBoxBenchPress);
        checkBoxRowing = (CheckBox)findViewById(R.id.checkBoxRowing);
        checkBoxRisingSideways = (CheckBox)findViewById(R.id.checkBoxRisingSideways);
        checkBoxBiceps = (CheckBox)findViewById(R.id.checkBoxBiceps);
        checkBoxTriceps = (CheckBox)findViewById(R.id.checkBoxTriceps);
        checkBoxAllahs = (CheckBox)findViewById(R.id.checkBoxAllahs);
        checkBoxCalves = (CheckBox)findViewById(R.id.checkBoxCalves);
        checkBoxFacepull = (CheckBox)findViewById(R.id.checkBoxFacepull);
        checkBoxDeadliftClassic = (CheckBox)findViewById(R.id.checkBoxDeadliftClassic);
        checkBoxOhp = (CheckBox)findViewById(R.id.checkBoxOhp);
        checkBoxPullingUpNarrow = (CheckBox)findViewById(R.id.checkBoxPullingUpNarrow);
        checkBoxNarrowBenchPress = (CheckBox)findViewById(R.id.checkBoxNarrowBenchPress);
        checkBoxYRaise = (CheckBox)findViewById(R.id.checkBoxYRaise);
        checkBoxPlank =  (CheckBox)findViewById(R.id.checkBoxPlank);


        checkBoxSquatsConf = (CheckBox)findViewById(R.id.checkBoxSquatsConf);
        checkBoxBenchPressConf = (CheckBox)findViewById(R.id.checkBoxBenchPressConf);
        checkBoxRowingConf = (CheckBox)findViewById(R.id.checkBoxRowingConf);
        checkBoxRisingSidewaysConf = (CheckBox)findViewById(R.id.checkBoxRisingSidewaysConf);
        checkBoxBicepsConf  = (CheckBox)findViewById(R.id.checkBoxBicepsConf);
        checkBoxTricepsConf = (CheckBox)findViewById(R.id.checkBoxTricepsConf);
        checkBoxAllahsConf = (CheckBox)findViewById(R.id.checkBoxAllahsConf);
        checkBoxCalvesConf = (CheckBox)findViewById(R.id.checkBoxCalvesConf);
        checkBoxFacepullConf = (CheckBox)findViewById(R.id.checkBoxFacepullConf);
        checkBoxDeadliftClassicConf = (CheckBox)findViewById(R.id.checkBoxDeadliftClassicConf);
        checkBoxOhpConf = (CheckBox)findViewById(R.id.checkBoxOhpConf);
        checkBoxPullingUpNarrowConf = (CheckBox)findViewById(R.id.checkBoxPullingUpNarrowConf);
        checkBoxNarrowBenchPressConf = (CheckBox)findViewById(R.id.checkBoxNarrowBenchPressConf);
        checkBoxYRaiseConf = (CheckBox)findViewById(R.id.checkBoxYRaiseConf);
        checkBoxPlankConf = (CheckBox)findViewById(R.id.checkBoxPlankConf);

        buttonWeightConfiguration=(Button)findViewById(R.id.buttonWeightConfiguration);
        buttonTrainingConfiguration = (Button)findViewById(R.id.buttonTrainingConfiguration);
        buttonSaveWeightConfiguration =(Button)findViewById(R.id.buttonSaveWeightConfiguration);
        buttonFinishWorkout =(Button)findViewById(R.id.buttonFinishWorkout);
        buttonFinishWorkoutB =(Button)findViewById(R.id.buttonFinishWorkoutB);
        buttonSaveTrainingConfiguration =(Button)findViewById(R.id.buttonSaveTrainingConfiguration);

        textViewMaxKg =(TextView)findViewById(R.id.textViewMaxKg);
        textViewSquat =(TextView)findViewById(R.id.textViewSquat);
        textViewTrainingA =(TextView)findViewById(R.id.textViewTrainingA);
        textViewTrainingB =(TextView)findViewById(R.id.textViewTrainingB);

        editTextSquat = (EditText)findViewById(R.id.editTextSquat);
        editTextBenchPress  = (EditText)findViewById(R.id.editTextBenchPress);
        editTextRowing  = (EditText)findViewById(R.id.editTextRowing);
        editTextRisingSideways = (EditText)findViewById(R.id.editTextRisingSideways);
        editTextBiceps  = (EditText)findViewById(R.id.editTextBiceps);
        editTextTriceps  = (EditText)findViewById(R.id.editTextTriceps);
        editTextAllahs = (EditText)findViewById(R.id.editTextAllahs);
        editTextFacepull = (EditText)findViewById(R.id.editTextFacepull);
        editTextDeadliftClassic = (EditText)findViewById(R.id.editTextDeadliftClassic);
        editTextOhp = (EditText)findViewById(R.id.editTextOhp);
        editTextPullingUpNarrow = (EditText)findViewById(R.id.editTextPullingUpNarrow);
        editTextNarrowBenchPress = (EditText)findViewById(R.id.editTextNarrowBenchPress);
        editTextYRaise = (EditText)findViewById(R.id.editTextYRaise);


        LastSelect= getSharedPreferences("LastClick", Context.MODE_PRIVATE);
        editor=LastSelect.edit();
        LastClick = LastSelect.getInt("LastClick",0);
        final int LastWorkoutState= LastSelect.getInt("LastWorkoutState",0);



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
                linearLayoutTrainingConfiguration.setVisibility(View.VISIBLE);

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

        buttonSaveTrainingConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                CustomWorkout();
            }
        });

        buttonFinishWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcWeightConfiguration();

                checkBoxSquats.setChecked(false);
                checkBoxBenchPress.setChecked(false);
                checkBoxRowing.setChecked(false);
                checkBoxRisingSideways.setChecked(false);
                checkBoxBiceps.setChecked(false);
                checkBoxTriceps.setChecked(false);
                checkBoxAllahs.setChecked(false);
                checkBoxCalves.setChecked(false);
                checkBoxFacepull.setChecked(false);
                checkBoxDeadliftClassic.setChecked(false);
                checkBoxOhp.setChecked(false);
                checkBoxPullingUpNarrow.setChecked(false);
                checkBoxNarrowBenchPress.setChecked(false);
                checkBoxYRaise.setChecked(false);
                checkBoxYRaise.setChecked(false);
                checkBoxPlank.setChecked(false);

                FbwWorkoutB();
               // linearLayoutTrainingA.setVisibility(View.GONE);
                //linearLayoutTrainingB.setVisibility(View.VISIBLE);

                editor.putInt("LastWorkoutState",1).commit();
                //Toast.makeText(getApplicationContext()," TEST "+LastWorkoutState,Toast.LENGTH_LONG).show();
            }
        });

        buttonFinishWorkoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcWeightConfiguration();
                checkBoxSquats.setChecked(false);
                checkBoxBenchPress.setChecked(false);
                checkBoxRowing.setChecked(false);
                checkBoxRisingSideways.setChecked(false);
                checkBoxBiceps.setChecked(false);
                checkBoxTriceps.setChecked(false);
                checkBoxAllahs.setChecked(false);
                checkBoxCalves.setChecked(false);
                checkBoxFacepull.setChecked(false);
                checkBoxDeadliftClassic.setChecked(false);
                checkBoxOhp.setChecked(false);
                checkBoxPullingUpNarrow.setChecked(false);
                checkBoxNarrowBenchPress.setChecked(false);
                checkBoxYRaise.setChecked(false);
                checkBoxPlank.setChecked(false);



                FbwWorkoutA();
               // linearLayoutTrainingA.setVisibility(View.VISIBLE);
               // linearLayoutTrainingB.setVisibility(View.GONE);
                editor.putInt("LastWorkoutState",0).apply();
              //  Toast.makeText(getApplicationContext()," TEST "+LastWorkoutState,Toast.LENGTH_LONG).show();




            }
        });


        spinnerWorkouts =findViewById(R.id.spinnerWorkouts);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Workouts, android.R.layout.simple_spinner_dropdown_item);
        spinnerWorkouts.setAdapter(adapter);
        spinnerWorkouts.setSelection(LastClick);
        spinnerWorkouts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



                switch (position) {
                    case 0:
                        ClearCheckboxs();
                       // linearLayoutTrainingA.setVisibility(View.GONE);
                        //linearLayoutTrainingB.setVisibility(View.GONE);
                        buttonTrainingConfiguration.setVisibility(View.GONE);
                        buttonWeightConfiguration.setVisibility(View.GONE);
                        buttonFinishWorkout.setVisibility(View.GONE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        editor.putInt("LastClick",0).apply();
                       // Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        buttonTrainingConfiguration.setVisibility(View.GONE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        buttonFinishWorkout.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        calcWeightConfiguration();
                        CustomWorkout();

                        if (LastWorkoutState==0){

                            FbwWorkoutA();
                            //linearLayoutTrainingB.setVisibility(View.GONE);
                            //linearLayoutTrainingA.setVisibility(View.VISIBLE);
                        }

                        else if (LastWorkoutState==1){
                            FbwWorkoutB();
                            //linearLayoutTrainingB.setVisibility(View.VISIBLE);
                            //linearLayoutTrainingA.setVisibility(View.GONE);
                            }
                        editor.putInt("LastClick",1).commit();
                       // Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        CustomWorkout();
                        //linearLayoutTrainingA.setVisibility(View.GONE);
                       // linearLayoutTrainingB.setVisibility(View.GONE);
                        buttonTrainingConfiguration.setVisibility(View.VISIBLE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        editor.putInt("LastClick",2).commit();
                       // Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();

                        break;
                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        SharedPreferences preferencesTrainingConf = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = preferencesTrainingConf.edit();


        if(preferencesTrainingConf.contains("SquatsConf") && preferencesTrainingConf.getBoolean("SquatsConf",false) == true) {
            checkBoxSquatsConf.setChecked(true);
        }else {
            checkBoxSquatsConf.setChecked(false);

        }
        checkBoxSquatsConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxSquatsConf.isChecked()) {
                    editor.putBoolean("SquatsConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("SquatsConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConf") && preferencesTrainingConf.getBoolean("DeadliftClassicConf",false) == true) {
            checkBoxDeadliftClassicConf.setChecked(true);
        }else {
            checkBoxDeadliftClassicConf.setChecked(false);

        }
        checkBoxDeadliftClassicConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConf.isChecked()) {
                    editor.putBoolean("DeadliftClassicConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConf") && preferencesTrainingConf.getBoolean("DeadliftClassicConf",false) == true) {
            checkBoxDeadliftClassicConf.setChecked(true);
        }else {
            checkBoxDeadliftClassicConf.setChecked(false);

        }
        checkBoxDeadliftClassicConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConf.isChecked()) {
                    editor.putBoolean("DeadliftClassicConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BenchPressConf") && preferencesTrainingConf.getBoolean("BenchPressConf",false) == true) {
            checkBoxBenchPressConf.setChecked(true);
        }else {
            checkBoxBenchPressConf.setChecked(false);

        }
        checkBoxBenchPressConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBenchPressConf.isChecked()) {
                    editor.putBoolean("BenchPressConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BenchPressConf", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("NarrowBenchPressConf") && preferencesTrainingConf.getBoolean("NarrowBenchPressConf",false) == true) {
            checkBoxNarrowBenchPressConf.setChecked(true);
        }else {
            checkBoxNarrowBenchPressConf.setChecked(false);

        }
        checkBoxNarrowBenchPressConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxNarrowBenchPressConf.isChecked()) {
                    editor.putBoolean("NarrowBenchPressConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("NarrowBenchPressConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("OhpConf") && preferencesTrainingConf.getBoolean("OhpConf",false) == true) {
            checkBoxOhpConf.setChecked(true);
        }else {
            checkBoxOhpConf.setChecked(false);

        }
        checkBoxOhpConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxOhpConf.isChecked()) {
                    editor.putBoolean("OhpConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("OhpConf", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("RowingConf") && preferencesTrainingConf.getBoolean("RowingConf",false) == true) {
            checkBoxRowingConf.setChecked(true);
        }else {
            checkBoxRowingConf.setChecked(false);

        }
        checkBoxRowingConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRowingConf.isChecked()) {
                    editor.putBoolean("RowingConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RowingConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("PullingUpNarrowConf") && preferencesTrainingConf.getBoolean("PullingUpNarrowConf",false) == true) {
            checkBoxPullingUpNarrowConf.setChecked(true);
        }else {
            checkBoxPullingUpNarrowConf.setChecked(false);

        }
        checkBoxPullingUpNarrowConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPullingUpNarrowConf.isChecked()) {
                    editor.putBoolean("PullingUpNarrowConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PullingUpNarrowConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("RisingSidewaysConf") && preferencesTrainingConf.getBoolean("RisingSidewaysConf",false) == true) {
            checkBoxRisingSidewaysConf.setChecked(true);
        }else {
            checkBoxRisingSidewaysConf.setChecked(false);

        }
        checkBoxRisingSidewaysConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRisingSidewaysConf.isChecked()) {
                    editor.putBoolean("RisingSidewaysConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RisingSidewaysConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BicepsConf") && preferencesTrainingConf.getBoolean("BicepsConf",false) == true) {
            checkBoxBicepsConf.setChecked(true);
        }else {
            checkBoxBicepsConf.setChecked(false);

        }
        checkBoxBicepsConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBicepsConf.isChecked()) {
                    editor.putBoolean("BicepsConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BicepsConf", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("TricepsConf") && preferencesTrainingConf.getBoolean("TricepsConf",false) == true) {
            checkBoxTricepsConf.setChecked(true);
        }else {
            checkBoxTricepsConf.setChecked(false);

        }
        checkBoxTricepsConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxTricepsConf.isChecked()) {
                    editor.putBoolean("TricepsConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("TricepsConf", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("AllahsConf") && preferencesTrainingConf.getBoolean("AllahsConf",false) == true) {
            checkBoxAllahsConf.setChecked(true);
        }else {
            checkBoxAllahsConf.setChecked(false);

        }
        checkBoxAllahsConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConf.isChecked()) {
                    editor.putBoolean("AllahsConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("AllahsConf") && preferencesTrainingConf.getBoolean("AllahsConf",false) == true) {
            checkBoxAllahsConf.setChecked(true);
        }else {
            checkBoxAllahsConf.setChecked(false);

        }
        checkBoxAllahsConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConf.isChecked()) {
                    editor.putBoolean("AllahsConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConf", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("PlankConf") && preferencesTrainingConf.getBoolean("PlankConf",false) == true) {
            checkBoxPlankConf.setChecked(true);
        }else {
            checkBoxPlankConf.setChecked(false);

        }
        checkBoxPlankConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPlankConf.isChecked()) {
                    editor.putBoolean("PlankConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PlankConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("CalvesConf") && preferencesTrainingConf.getBoolean("CalvesConf",false) == true) {
            checkBoxCalvesConf.setChecked(true);
        }else {
            checkBoxCalvesConf.setChecked(false);

        }
        checkBoxCalvesConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxCalvesConf.isChecked()) {
                    editor.putBoolean("CalvesConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("CalvesConf", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("YRaiseConf") && preferencesTrainingConf.getBoolean("YRaiseConf",false) == true) {
            checkBoxYRaiseConf.setChecked(true);
        }else {
            checkBoxYRaiseConf.setChecked(false);

        }
        checkBoxYRaiseConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConf.isChecked()) {
                    editor.putBoolean("YRaiseConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("YRaiseConf", false);
                    editor.apply();
                }
            }
        });




        if(preferencesTrainingConf.contains("FacepullConf") && preferencesTrainingConf.getBoolean("FacepullConf",false) == true) {
            checkBoxFacepullConf.setChecked(true);
        }else {
            checkBoxFacepullConf.setChecked(false);

        }
        checkBoxFacepullConf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConf.isChecked()) {
                    editor.putBoolean("FacepullConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("FacepullConf", false);
                    editor.apply();
                }
            }
        });




        final SharedPreferences prefsMax = PreferenceManager.getDefaultSharedPreferences(this);
        editTextSquat.setText(prefsMax.getString("autoSaveSquatMax", ""));
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
                prefsMax.edit().putString("autoSaveSquatMax", s.toString()).apply();


            }
        });

        editTextBenchPress.setText(prefsMax.getString("autoSaveBenchPressMax", ""));
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
                prefsMax.edit().putString("autoSaveBenchPressMax", s.toString()).apply();


            }
        });


        editTextRowing.setText(prefsMax.getString("autoSaveRowingMax", ""));
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
                prefsMax.edit().putString("autoSaveRowingMax", s.toString()).apply();
            }
        });


        editTextRisingSideways.setText(prefsMax.getString("autoSaveRisingSidewaysMax", ""));
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
                prefsMax.edit().putString("autoSaveRisingSidewaysMax", s.toString()).apply();
            }
        });



        editTextBiceps.setText(prefsMax.getString("autoSaveBicepsMax", ""));
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
                prefsMax.edit().putString("autoSaveBicepsMax", s.toString()).apply();
            }



        });


        editTextTriceps.setText(prefsMax.getString("autoSaveTricepsMax", ""));
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
                prefsMax.edit().putString("autoSaveTricepsMax", s.toString()).apply();
            }



        });


        editTextAllahs.setText(prefsMax.getString("autoSaveAllahsMax", ""));
        editTextAllahs.addTextChangedListener(new TextWatcher() {
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
                prefsMax.edit().putString("autoSaveAllahsMax", s.toString()).apply();
            }



        });


        editTextFacepull.setText(prefsMax.getString("autoSaveFacepullMax", ""));
        editTextFacepull.addTextChangedListener(new TextWatcher() {
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
                prefsMax.edit().putString("autoSaveFacepullMax", s.toString()).apply();
            }



        });


        editTextDeadliftClassic.setText(prefsMax.getString("autoSaveDeadliftClassicMax", ""));
        editTextDeadliftClassic.addTextChangedListener(new TextWatcher() {
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
                prefsMax.edit().putString("autoSaveDeadliftClassicMax", s.toString()).apply();
            }

        });



        editTextOhp.setText(prefsMax.getString("autoSaveOhpMax", ""));
        editTextOhp.addTextChangedListener(new TextWatcher() {
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
                prefsMax.edit().putString("autoSaveOhpMax", s.toString()).apply();
            }

        });


        editTextPullingUpNarrow.setText(prefsMax.getString("autoSavePullingUpNarrowMax", ""));
        editTextPullingUpNarrow.addTextChangedListener(new TextWatcher() {
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
                prefsMax.edit().putString("autoSavePullingUpNarrowMax", s.toString()).apply();
            }

        });


        editTextNarrowBenchPress.setText(prefsMax.getString("autoSaveNarrowBenchPressMax", ""));
        editTextNarrowBenchPress.addTextChangedListener(new TextWatcher() {
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
                prefsMax.edit().putString("autoSaveNarrowBenchPressMax", s.toString()).apply();
            }

        });


        editTextYRaise.setText(prefsMax.getString("autoSaveYRaiseMax", ""));
        editTextYRaise.addTextChangedListener(new TextWatcher() {
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
                prefsMax.edit().putString("autoSaveYRaiseMax", s.toString()).apply();
            }

        });


    }

             private void FbwWorkoutA() {
                 checkBoxSquats.setVisibility(View.VISIBLE);
                 checkBoxBenchPress.setVisibility(View.VISIBLE);
                 checkBoxRowing.setVisibility(View.VISIBLE);
                 checkBoxRisingSideways.setVisibility(View.VISIBLE);
                 checkBoxBiceps.setVisibility(View.VISIBLE);
                 checkBoxTriceps.setVisibility(View.VISIBLE);
                 checkBoxAllahs.setVisibility(View.VISIBLE);
                 checkBoxCalves.setVisibility(View.VISIBLE);
                 checkBoxFacepull.setVisibility(View.VISIBLE);
                 textViewTrainingA.setVisibility(View.VISIBLE);
                 buttonFinishWorkout.setVisibility(View.VISIBLE);

                 checkBoxDeadliftClassic.setVisibility(View.GONE);
                 checkBoxOhp.setVisibility(View.GONE);
                 checkBoxPullingUpNarrow.setVisibility(View.GONE);
                 checkBoxNarrowBenchPress.setVisibility(View.GONE);
                 checkBoxPlank.setVisibility(View.GONE);
                 checkBoxYRaise.setVisibility(View.GONE);
                 textViewTrainingB.setVisibility(View.GONE);
                 buttonFinishWorkoutB.setVisibility(View.GONE);

             }

             private void FbwWorkoutB() {

                 checkBoxDeadliftClassic.setVisibility(View.VISIBLE);
                 checkBoxOhp.setVisibility(View.VISIBLE);
                 checkBoxPullingUpNarrow.setVisibility(View.VISIBLE);
                 checkBoxNarrowBenchPress.setVisibility(View.VISIBLE);
                 checkBoxBiceps.setVisibility(View.VISIBLE);
                 checkBoxPlank.setVisibility(View.VISIBLE);
                 checkBoxCalves.setVisibility(View.VISIBLE);
                 checkBoxYRaise.setVisibility(View.VISIBLE);
                 textViewTrainingB.setVisibility(View.VISIBLE);
                 buttonFinishWorkoutB.setVisibility(View.VISIBLE);

                 checkBoxSquats.setVisibility(View.GONE);
                 checkBoxBenchPress.setVisibility(View.GONE);
                 checkBoxRowing.setVisibility(View.GONE);
                 checkBoxRisingSideways.setVisibility(View.GONE);
                 checkBoxTriceps.setVisibility(View.GONE);
                 checkBoxAllahs.setVisibility(View.GONE);
                 checkBoxFacepull.setVisibility(View.GONE);
                 textViewTrainingA.setVisibility(View.GONE);
                 buttonFinishWorkout.setVisibility(View.GONE);

             }


             private void ClearCheckboxs() {
                 checkBoxSquats.setVisibility(View.GONE);
                 checkBoxBenchPress.setVisibility(View.GONE);
                 checkBoxRowing.setVisibility(View.GONE);
                 checkBoxRisingSideways.setVisibility(View.GONE);
                 checkBoxBiceps.setVisibility(View.GONE);
                 checkBoxTriceps.setVisibility(View.GONE);
                 checkBoxAllahs.setVisibility(View.GONE);
                 checkBoxCalves.setVisibility(View.GONE);
                 checkBoxFacepull.setVisibility(View.GONE);
                 textViewTrainingA.setVisibility(View.GONE);
                 buttonFinishWorkout.setVisibility(View.GONE);
                 checkBoxDeadliftClassic.setVisibility(View.GONE);
                 checkBoxOhp.setVisibility(View.GONE);
                 checkBoxPullingUpNarrow.setVisibility(View.GONE);
                 checkBoxNarrowBenchPress.setVisibility(View.GONE);
                 checkBoxYRaise.setVisibility(View.GONE);
                 checkBoxYRaise.setVisibility(View.GONE);
                 checkBoxPlank.setVisibility(View.GONE);
                 textViewTrainingB.setVisibility(View.GONE);
                 buttonFinishWorkoutB.setVisibility(View.GONE);

             }


             private void CustomWorkout() {


                 if (LastClick==2&&checkBoxSquatsConf.isChecked()){
                     checkBoxSquats.setVisibility(View.VISIBLE);
                     checkBoxBenchPress.setVisibility(View.GONE);
                     checkBoxRowing.setVisibility(View.GONE);
                     checkBoxRisingSideways.setVisibility(View.GONE);
                     checkBoxBiceps.setVisibility(View.GONE);
                     checkBoxTriceps.setVisibility(View.GONE);
                     checkBoxAllahs.setVisibility(View.GONE);
                     checkBoxCalves.setVisibility(View.GONE);
                     checkBoxFacepull.setVisibility(View.GONE);
                     textViewTrainingA.setVisibility(View.GONE);
                     buttonFinishWorkout.setVisibility(View.GONE);
                     checkBoxDeadliftClassic.setVisibility(View.GONE);
                     checkBoxOhp.setVisibility(View.GONE);
                     checkBoxPullingUpNarrow.setVisibility(View.GONE);
                     checkBoxNarrowBenchPress.setVisibility(View.GONE);
                     checkBoxYRaise.setVisibility(View.GONE);
                     checkBoxYRaise.setVisibility(View.GONE);
                     checkBoxPlank.setVisibility(View.GONE);
                     textViewTrainingB.setVisibility(View.GONE);
                     buttonFinishWorkoutB.setVisibility(View.GONE);
                 }
                 else {
                     checkBoxSquats.setVisibility(View.GONE);
                     checkBoxBenchPress.setVisibility(View.GONE);
                     checkBoxRowing.setVisibility(View.GONE);
                     checkBoxRisingSideways.setVisibility(View.GONE);
                     checkBoxBiceps.setVisibility(View.GONE);
                     checkBoxTriceps.setVisibility(View.GONE);
                     checkBoxAllahs.setVisibility(View.GONE);
                     checkBoxCalves.setVisibility(View.GONE);
                     checkBoxFacepull.setVisibility(View.GONE);
                     textViewTrainingA.setVisibility(View.GONE);
                     buttonFinishWorkout.setVisibility(View.GONE);
                     checkBoxDeadliftClassic.setVisibility(View.GONE);
                     checkBoxOhp.setVisibility(View.GONE);
                     checkBoxPullingUpNarrow.setVisibility(View.GONE);
                     checkBoxNarrowBenchPress.setVisibility(View.GONE);
                     checkBoxYRaise.setVisibility(View.GONE);
                     checkBoxYRaise.setVisibility(View.GONE);
                     checkBoxPlank.setVisibility(View.GONE);
                     textViewTrainingB.setVisibility(View.GONE);
                     buttonFinishWorkoutB.setVisibility(View.GONE);
                 }


             }



             private void calcWeightConfiguration() {
                 if (editTextSquat.getText().length() != 0 && checkBoxSquats.isChecked()){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady 5 x 5 x "+nSeries+"kg");
                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextSquat.getText().length() != 0 && !checkBoxSquats.isChecked()){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady 5 x 5 x "+nSeries+"kg");
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

                     checkBoxBenchPress.setText("Wyciskanie Leżąc 5 x 5 x "+nSeries+"kg");
                     editTextBenchPress.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextBenchPress.getText().length() != 0 && !checkBoxBenchPress.isChecked()){
                     double n1 = Double.parseDouble(editTextBenchPress.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxBenchPress.setText("Wyciskanie Leżąc 5 x 5 x "+nSeries+"kg");
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

                     checkBoxRowing.setText("Wiosłowanie 5 x 5 x "+nSeries+"kg");
                     editTextRowing.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextRowing.getText().length() != 0 && !checkBoxRowing.isChecked()){
                     double n1 = Double.parseDouble(editTextRowing.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxRowing.setText("Wiosłowanie 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextRowing.getText().length() == 0) {
                     checkBoxRowing.setText("brak konfiguracji obciążenia dla Wiosłowania");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextRisingSideways.getText().length() != 0 && checkBoxRisingSideways.isChecked()){
                     double n1 = Double.parseDouble(editTextRisingSideways.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxRisingSideways.setText("Wznosy bokiem 5 x 5 x "+nSeries+"kg");
                     editTextRisingSideways.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextRisingSideways.getText().length() != 0 && !checkBoxRisingSideways.isChecked()){
                     double n1 = Double.parseDouble(editTextRisingSideways.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxRisingSideways.setText("Wznosy bokiem 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextRisingSideways.getText().length() == 0) {
                     checkBoxRisingSideways.setText("brak konfiguracji obciążenia dla Wznosów bokiem");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextBiceps.getText().length() != 0 && checkBoxBiceps.isChecked()){
                     double n1 = Double.parseDouble(editTextBiceps.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxBiceps.setText("Biceps 5 x 5 x "+nSeries+"kg");
                     editTextBiceps.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextBiceps.getText().length() != 0 && !checkBoxBiceps.isChecked()){
                     double n1 = Double.parseDouble(editTextBiceps.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxBiceps.setText("Biceps 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextBiceps.getText().length() == 0) {
                     checkBoxBiceps.setText("brak konfiguracji obciążenia dla Bicepsa");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextTriceps.getText().length() != 0 && checkBoxTriceps.isChecked()){
                     double n1 = Double.parseDouble(editTextTriceps.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxTriceps.setText("Triceps 5 x 5 x "+nSeries+"kg");
                     editTextTriceps.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextTriceps.getText().length() != 0 && !checkBoxTriceps.isChecked()){
                     double n1 = Double.parseDouble(editTextTriceps.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxTriceps.setText("Triceps 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextTriceps.getText().length() == 0) {
                     checkBoxTriceps.setText("brak konfiguracji obciążenia dla Triceps");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextAllahs.getText().length() != 0 && checkBoxAllahs.isChecked()){
                     double n1 = Double.parseDouble(editTextAllahs.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxAllahs.setText("Allahy 5 x 5 x "+nSeries+"kg");
                     editTextAllahs.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextAllahs.getText().length() != 0 && !checkBoxAllahs.isChecked()){
                     double n1 = Double.parseDouble(editTextAllahs.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxAllahs.setText("Allahy 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextAllahs.getText().length() == 0) {
                     checkBoxAllahs.setText("brak konfiguracji obciążenia dla Allahów");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextFacepull.getText().length() != 0 && checkBoxFacepull.isChecked()){
                     double n1 = Double.parseDouble(editTextFacepull.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxFacepull.setText("Facepull 5 x 5 x "+nSeries+"kg");
                     editTextFacepull.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextFacepull.getText().length() != 0 && !checkBoxFacepull.isChecked()){
                     double n1 = Double.parseDouble(editTextFacepull.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxFacepull.setText("Facepull 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextFacepull.getText().length() == 0) {
                     checkBoxFacepull.setText("brak konfiguracji obciążenia dla Facepull");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }


                 if (editTextDeadliftClassic.getText().length() != 0 && checkBoxDeadliftClassic.isChecked()){
                     double n1 = Double.parseDouble(editTextDeadliftClassic.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxDeadliftClassic.setText("Martwy Ciąg Klasyczny 5 x 5 x "+nSeries+"kg");
                     editTextDeadliftClassic.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextDeadliftClassic.getText().length() != 0 && !checkBoxDeadliftClassic.isChecked()){
                     double n1 = Double.parseDouble(editTextDeadliftClassic.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxDeadliftClassic.setText("Martwy Ciąg Klasyczny 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextDeadliftClassic.getText().length() == 0) {
                     checkBoxDeadliftClassic.setText("brak konfiguracji obciążenia dla Martwego Ciągu Klasycznego");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextOhp.getText().length() != 0 && checkBoxOhp.isChecked()){
                     double n1 = Double.parseDouble(editTextOhp.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxOhp.setText("Wyciskanie Żołnierskie 5 x 5 x "+nSeries+"kg");
                     editTextOhp.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextOhp.getText().length() != 0 && !checkBoxOhp.isChecked()){
                     double n1 = Double.parseDouble(editTextOhp.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxOhp.setText("Wyciskanie Żołnierskie 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextOhp.getText().length() == 0) {
                     checkBoxOhp.setText("brak konfiguracji obciążenia dla Wyciskania Żołnierskiego");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextOhp.getText().length() != 0 && checkBoxOhp.isChecked()){
                     double n1 = Double.parseDouble(editTextOhp.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxOhp.setText("Wyciskanie Żołnierskie 5 x 5 x "+nSeries+"kg");
                     editTextOhp.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextOhp.getText().length() != 0 && !checkBoxOhp.isChecked()){
                     double n1 = Double.parseDouble(editTextOhp.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxOhp.setText("Wyciskanie Żołnierskie 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextOhp.getText().length() == 0) {
                     checkBoxOhp.setText("brak konfiguracji obciążenia dla Wyciskania Żołnierskiego");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextPullingUpNarrow.getText().length() != 0 && checkBoxPullingUpNarrow.isChecked()){
                     double n1 = Double.parseDouble(editTextPullingUpNarrow.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxPullingUpNarrow.setText("WPodciąganie Wąsko 5 x 5 x "+nSeries+"kg");
                     editTextPullingUpNarrow.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextPullingUpNarrow.getText().length() != 0 && !checkBoxPullingUpNarrow.isChecked()){
                     double n1 = Double.parseDouble(editTextPullingUpNarrow.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxPullingUpNarrow.setText("Podciąganie Wąsko 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextPullingUpNarrow.getText().length() == 0) {
                     checkBoxPullingUpNarrow.setText("brak konfiguracji obciążenia dla Podciągania Wąsko");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextNarrowBenchPress.getText().length() != 0 && checkBoxNarrowBenchPress.isChecked()){
                     double n1 = Double.parseDouble(editTextNarrowBenchPress.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxNarrowBenchPress.setText("Wyciskanie Wąsko 5 x 5 x "+nSeries+"kg");
                     editTextNarrowBenchPress.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextNarrowBenchPress.getText().length() != 0 && !checkBoxNarrowBenchPress.isChecked()){
                     double n1 = Double.parseDouble(editTextNarrowBenchPress.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxNarrowBenchPress.setText("Wyciskanie Wąsko 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextNarrowBenchPress.getText().length() == 0) {
                     checkBoxNarrowBenchPress.setText("brak konfiguracji obciążenia dla Wyciskania Wąsko");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 if (editTextYRaise.getText().length() != 0 && checkBoxYRaise.isChecked()){
                     double n1 = Double.parseDouble(editTextYRaise.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxYRaise.setText("Y-Raise 5 x 5 x "+nSeries+"kg");
                     editTextYRaise.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextYRaise.getText().length() != 0 && !checkBoxYRaise.isChecked()){
                     double n1 = Double.parseDouble(editTextNarrowBenchPress.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxYRaise.setText("Y-Raise 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextYRaise.getText().length() == 0) {
                     checkBoxYRaise.setText("brak konfiguracji obciążenia dla Y-Raise");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }




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
