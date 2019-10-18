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


    private LinearLayout linearLayoutWeightConfiguration,linearLayoutTrainingConfiguration,linearLayoutTrainingConfigurationB,linearLayoutTrainingConfigurationC,linearLayoutTrainingConfigurationD;
    private CheckBox checkBoxSquats,checkBoxBenchPress,checkBoxRowing,checkBoxRisingSideways,checkBoxBiceps,checkBoxTriceps,
            checkBoxAllahs,checkBoxCalves,checkBoxFacepull,checkBoxDeadliftClassic,checkBoxOhp,checkBoxPullingUpNarrow,checkBoxNarrowBenchPress,checkBoxYRaise,
            checkBoxPlank,checkBoxSquatsConf,checkBoxBenchPressConf,checkBoxRowingConf,checkBoxRisingSidewaysConf,checkBoxBicepsConf,checkBoxTricepsConf,
            checkBoxAllahsConf,checkBoxCalvesConf,checkBoxFacepullConf,checkBoxDeadliftClassicConf,checkBoxOhpConf,checkBoxPullingUpNarrowConf,checkBoxNarrowBenchPressConf,checkBoxYRaiseConf,
            checkBoxPlankConf,checkBoxSquatsConfB,checkBoxBenchPressConfB,checkBoxRowingConfB,checkBoxRisingSidewaysConfB,checkBoxBicepsConfB,checkBoxTricepsConfB,
            checkBoxAllahsConfB,checkBoxCalvesConfB,checkBoxFacepullConfB,checkBoxDeadliftClassicConfB,checkBoxOhpConfB,checkBoxPullingUpNarrowConfB,checkBoxNarrowBenchPressConfB,checkBoxYRaiseConfB,
            checkBoxPlankConfB,checkBoxSquatsConfC,checkBoxBenchPressConfC,checkBoxRowingConfC,checkBoxRisingSidewaysConfC,checkBoxBicepsConfC,checkBoxTricepsConfC,
            checkBoxAllahsConfC,checkBoxCalvesConfC,checkBoxFacepullConfC,checkBoxDeadliftClassicConfC,checkBoxOhpConfC,checkBoxPullingUpNarrowConfC,checkBoxNarrowBenchPressConfC,checkBoxYRaiseConfC,
            checkBoxPlankConfC,checkBoxSquatsConfD,checkBoxBenchPressConfD,checkBoxRowingConfD,checkBoxRisingSidewaysConfD,checkBoxBicepsConfD,checkBoxTricepsConfD,
            checkBoxAllahsConfD,checkBoxCalvesConfD,checkBoxFacepullConfD,checkBoxDeadliftClassicConfD,checkBoxOhpConfD,checkBoxPullingUpNarrowConfD,checkBoxNarrowBenchPressConfD,checkBoxYRaiseConfD,
            checkBoxPlankConfD;
    private TextView textViewTrainingA,textViewTrainingB,textViewTrainingC,textViewTrainingD;
    private EditText editTextSquat,editTextBenchPress,editTextRowing,editTextRisingSideways,editTextBiceps,editTextTriceps,editTextAllahs,editTextFacepull,editTextDeadliftClassic,
            editTextOhp,editTextPullingUpNarrow,editTextNarrowBenchPress,editTextYRaise;
    private Button buttonWeightConfiguration,buttonTrainingConfiguration,buttonSaveWeightConfiguration,buttonFinishWorkout,buttonFinishWorkoutB,buttonFinishWorkoutC,buttonFinishWorkoutD,
            buttonSaveTrainingConfiguration,buttonNextTrainingConfiguration,buttonNextTrainingConfigurationB,buttonNextTrainingConfigurationC;
    private int LastClick,xd;
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




        linearLayoutWeightConfiguration = (LinearLayout)findViewById(R.id.linearLayoutWeightConfiguration);
        linearLayoutTrainingConfiguration = (LinearLayout)findViewById(R.id.linearLayoutTrainingConfiguration);
        linearLayoutTrainingConfigurationB = (LinearLayout)findViewById(R.id.linearLayoutTrainingConfigurationB);
        linearLayoutTrainingConfigurationC= (LinearLayout)findViewById(R.id.linearLayoutTrainingConfigurationC);
        linearLayoutTrainingConfigurationD = (LinearLayout)findViewById(R.id.linearLayoutTrainingConfigurationD);

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
        checkBoxSquatsConfB = (CheckBox)findViewById(R.id.checkBoxSquatsConfB);
        checkBoxBenchPressConfB = (CheckBox)findViewById(R.id.checkBoxBenchPressConfB);
        checkBoxRowingConfB = (CheckBox)findViewById(R.id.checkBoxRowingConfB);
        checkBoxRisingSidewaysConfB = (CheckBox)findViewById(R.id.checkBoxRisingSidewaysConfB);
        checkBoxBicepsConfB  = (CheckBox)findViewById(R.id.checkBoxBicepsConfB);
        checkBoxTricepsConfB = (CheckBox)findViewById(R.id.checkBoxTricepsConfB);
        checkBoxAllahsConfB = (CheckBox)findViewById(R.id.checkBoxAllahsConfB);
        checkBoxCalvesConfB = (CheckBox)findViewById(R.id.checkBoxCalvesConfB);
        checkBoxFacepullConfB = (CheckBox)findViewById(R.id.checkBoxFacepullConfB);
        checkBoxDeadliftClassicConfB = (CheckBox)findViewById(R.id.checkBoxDeadliftClassicConfB);
        checkBoxOhpConfB = (CheckBox)findViewById(R.id.checkBoxOhpConfB);
        checkBoxPullingUpNarrowConfB = (CheckBox)findViewById(R.id.checkBoxPullingUpNarrowConfB);
        checkBoxNarrowBenchPressConfB = (CheckBox)findViewById(R.id.checkBoxNarrowBenchPressConfB);
        checkBoxYRaiseConfB = (CheckBox)findViewById(R.id.checkBoxYRaiseConfB);
        checkBoxPlankConfB = (CheckBox)findViewById(R.id.checkBoxPlankConfB);
        checkBoxSquatsConfC = (CheckBox)findViewById(R.id.checkBoxSquatsConfC);
        checkBoxBenchPressConfC = (CheckBox)findViewById(R.id.checkBoxBenchPressConfC);
        checkBoxRowingConfC = (CheckBox)findViewById(R.id.checkBoxRowingConfC);
        checkBoxRisingSidewaysConfC = (CheckBox)findViewById(R.id.checkBoxRisingSidewaysConfC);
        checkBoxBicepsConfC  = (CheckBox)findViewById(R.id.checkBoxBicepsConfC);
        checkBoxTricepsConfC = (CheckBox)findViewById(R.id.checkBoxTricepsConfC);
        checkBoxAllahsConfC = (CheckBox)findViewById(R.id.checkBoxAllahsConfC);
        checkBoxCalvesConfC = (CheckBox)findViewById(R.id.checkBoxCalvesConfC);
        checkBoxFacepullConfC = (CheckBox)findViewById(R.id.checkBoxFacepullConfC);
        checkBoxDeadliftClassicConfC = (CheckBox)findViewById(R.id.checkBoxDeadliftClassicConfC);
        checkBoxOhpConfC = (CheckBox)findViewById(R.id.checkBoxOhpConfC);
        checkBoxPullingUpNarrowConfC = (CheckBox)findViewById(R.id.checkBoxPullingUpNarrowConfC);
        checkBoxNarrowBenchPressConfC = (CheckBox)findViewById(R.id.checkBoxNarrowBenchPressConfC);
        checkBoxYRaiseConfC = (CheckBox)findViewById(R.id.checkBoxYRaiseConfC);
        checkBoxPlankConfC = (CheckBox)findViewById(R.id.checkBoxPlankConfC);
        checkBoxSquatsConfD = (CheckBox)findViewById(R.id.checkBoxSquatsConfD);
        checkBoxBenchPressConfD = (CheckBox)findViewById(R.id.checkBoxBenchPressConfD);
        checkBoxRowingConfD = (CheckBox)findViewById(R.id.checkBoxRowingConfD);
        checkBoxRisingSidewaysConfD = (CheckBox)findViewById(R.id.checkBoxRisingSidewaysConfD);
        checkBoxBicepsConfD  = (CheckBox)findViewById(R.id.checkBoxBicepsConfD);
        checkBoxTricepsConfD = (CheckBox)findViewById(R.id.checkBoxTricepsConfD);
        checkBoxAllahsConfD = (CheckBox)findViewById(R.id.checkBoxAllahsConfD);
        checkBoxCalvesConfD = (CheckBox)findViewById(R.id.checkBoxCalvesConfD);
        checkBoxFacepullConfD = (CheckBox)findViewById(R.id.checkBoxFacepullConfD);
        checkBoxDeadliftClassicConfD = (CheckBox)findViewById(R.id.checkBoxDeadliftClassicConfD);
        checkBoxOhpConfD = (CheckBox)findViewById(R.id.checkBoxOhpConfD);
        checkBoxPullingUpNarrowConfD = (CheckBox)findViewById(R.id.checkBoxPullingUpNarrowConfD);
        checkBoxNarrowBenchPressConfD = (CheckBox)findViewById(R.id.checkBoxNarrowBenchPressConfD);
        checkBoxYRaiseConfD = (CheckBox)findViewById(R.id.checkBoxYRaiseConfD);
        checkBoxPlankConfD = (CheckBox)findViewById(R.id.checkBoxPlankConfD);

        buttonWeightConfiguration=(Button)findViewById(R.id.buttonWeightConfiguration);
        buttonTrainingConfiguration = (Button)findViewById(R.id.buttonTrainingConfiguration);
        buttonSaveWeightConfiguration =(Button)findViewById(R.id.buttonSaveWeightConfiguration);
        buttonFinishWorkout =(Button)findViewById(R.id.buttonFinishWorkout);
        buttonFinishWorkoutB =(Button)findViewById(R.id.buttonFinishWorkoutB);
        buttonFinishWorkoutC =(Button)findViewById(R.id.buttonFinishWorkoutC);
        buttonFinishWorkoutD =(Button)findViewById(R.id.buttonFinishWorkoutD);
        buttonSaveTrainingConfiguration =(Button)findViewById(R.id.buttonSaveTrainingConfiguration);
        buttonNextTrainingConfiguration =(Button)findViewById(R.id.buttonNextTrainingConfiguration);
        buttonNextTrainingConfigurationB =(Button)findViewById(R.id.buttonNextTrainingConfigurationB);
        buttonNextTrainingConfigurationC =(Button)findViewById(R.id.buttonNextTrainingConfigurationC);

        textViewTrainingA =(TextView)findViewById(R.id.textViewTrainingA);
        textViewTrainingB =(TextView)findViewById(R.id.textViewTrainingB);
        textViewTrainingC =(TextView)findViewById(R.id.textViewTrainingC);
        textViewTrainingD =(TextView)findViewById(R.id.textViewTrainingD);


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
                buttonSaveTrainingConfiguration.setVisibility(View.VISIBLE);


            }
        });
        buttonNextTrainingConfiguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                linearLayoutTrainingConfigurationB.setVisibility(View.VISIBLE);



            }
        });

        buttonNextTrainingConfigurationB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutTrainingConfigurationB.setVisibility(View.GONE);
                linearLayoutTrainingConfigurationC.setVisibility(View.VISIBLE);



            }
        });

        buttonNextTrainingConfigurationC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayoutTrainingConfigurationC.setVisibility(View.GONE);
                linearLayoutTrainingConfigurationD.setVisibility(View.VISIBLE);


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
                linearLayoutTrainingConfigurationB.setVisibility(View.GONE);
                linearLayoutTrainingConfigurationC.setVisibility(View.GONE);
                linearLayoutTrainingConfigurationD.setVisibility(View.GONE);
                buttonSaveTrainingConfiguration.setVisibility(View.GONE);

                CustomWorkout();
                calcWeightConfiguration();
            }
        });

        buttonFinishWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcWeightConfiguration();
                unchekedCheckBoxes();
                Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();

                if (LastClick==1){
                    FbwWorkoutB();
                }
               else if (LastClick==2&&(checkBoxSquatsConfB.isChecked()||checkBoxDeadliftClassicConfB.isChecked()||checkBoxOhpConfB.isChecked()||checkBoxBenchPressConfB.isChecked()||
                        checkBoxNarrowBenchPressConfB.isChecked()||checkBoxRisingSidewaysConfB.isChecked()||checkBoxPullingUpNarrowConfB.isChecked()||checkBoxRisingSidewaysConfB.isChecked()||
                        checkBoxBicepsConfB.isChecked()||checkBoxTricepsConfB.isChecked()||checkBoxAllahsConfB.isChecked()||checkBoxPlankConfB.isChecked()|| checkBoxCalvesConfB.isChecked()||
                        checkBoxYRaiseConfB.isChecked()||checkBoxFacepullConfB.isChecked())){
                    CustomWorkoutB();
                }
                else {
                    CustomWorkout();
                }

                editor.putInt("LastWorkoutState",1).commit();

            }
        });

        buttonFinishWorkoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcWeightConfiguration();
                unchekedCheckBoxes();
                Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();


                if (LastClick==1){
                    FbwWorkoutA();
                }
                else if (LastClick==2&&(checkBoxSquatsConfC.isChecked()||checkBoxDeadliftClassicConfC.isChecked()||checkBoxOhpConfC.isChecked()||checkBoxBenchPressConfC.isChecked()||
                        checkBoxNarrowBenchPressConfC.isChecked()||checkBoxRisingSidewaysConfC.isChecked()||checkBoxPullingUpNarrowConfC.isChecked()||checkBoxRisingSidewaysConfC.isChecked()||
                        checkBoxBicepsConfC.isChecked()||checkBoxTricepsConfC.isChecked()||checkBoxAllahsConfC.isChecked()||checkBoxPlankConfC.isChecked()|| checkBoxCalvesConfC.isChecked()||
                        checkBoxYRaiseConfC.isChecked()||checkBoxFacepullConfC.isChecked())){
                    CustomWorkoutC();
                }
                else {
                    CustomWorkout();
                }

                editor.putInt("LastWorkoutState",0).apply();

            }
        });

        buttonFinishWorkoutC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcWeightConfiguration();
                unchekedCheckBoxes();
                Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();



                if (LastClick==2&&(checkBoxSquatsConfD.isChecked()||checkBoxDeadliftClassicConfD.isChecked()||checkBoxOhpConfD.isChecked()||checkBoxBenchPressConfD.isChecked()||
                        checkBoxNarrowBenchPressConfD.isChecked()||checkBoxRisingSidewaysConfD.isChecked()||checkBoxPullingUpNarrowConfD.isChecked()||checkBoxRisingSidewaysConfD.isChecked()||
                        checkBoxBicepsConfD.isChecked()||checkBoxTricepsConfD.isChecked()||checkBoxAllahsConfD.isChecked()||checkBoxPlankConfD.isChecked()|| checkBoxCalvesConfD.isChecked()||
                        checkBoxYRaiseConfD.isChecked()||checkBoxFacepullConfD.isChecked())){
                    CustomWorkoutD();
                }
                else {
                    CustomWorkout();
                }



            }
        });

        buttonFinishWorkoutD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcWeightConfiguration();
                unchekedCheckBoxes();
                CustomWorkout();


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
                        linearLayoutTrainingConfigurationB.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationC.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationD.setVisibility(View.GONE);
                        buttonSaveTrainingConfiguration.setVisibility(View.GONE);
                        editor.putInt("LastClick",0);
                        editor.commit();
                        LastClick = LastSelect.getInt("LastClick",0);

                        //xd=0;
                        //StateZero();
                        //Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        buttonTrainingConfiguration.setVisibility(View.GONE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        buttonFinishWorkout.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationB.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationC.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationD.setVisibility(View.GONE);
                        textViewTrainingC.setVisibility(View.GONE);
                        textViewTrainingD.setVisibility(View.GONE);
                        buttonSaveTrainingConfiguration.setVisibility(View.GONE);
                        calcWeightConfiguration();
                        //CustomWorkout();
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

                        editor.putInt("LastClick",1);
                        editor.commit();
                        LastClick = LastSelect.getInt("LastClick",0);
                        //xd=1;
                        //editor.putInt("LastClick",1).apply();
                        //StateOne();
                       // Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        CustomWorkout();
                        calcWeightConfiguration();
                        //linearLayoutTrainingA.setVisibility(View.GONE);
                       // linearLayoutTrainingB.setVisibility(View.GONE);
                        buttonTrainingConfiguration.setVisibility(View.VISIBLE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationB.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationC.setVisibility(View.GONE);
                        linearLayoutTrainingConfigurationD.setVisibility(View.GONE);
                        buttonSaveTrainingConfiguration.setVisibility(View.GONE);
                        editor.putInt("LastClick",2);
                        editor.commit();
                        LastClick = LastSelect.getInt("LastClick",0);
                        //xd=2;
                        //StateTwo();
                        //editor.putInt("LastClick",2).apply();
                        // Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
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





        if(preferencesTrainingConf.contains("SquatsConfB") && preferencesTrainingConf.getBoolean("SquatsConfB",false) == true) {
            checkBoxSquatsConfB.setChecked(true);
        }else {
            checkBoxSquatsConfB.setChecked(false);

        }
        checkBoxSquatsConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxSquatsConfB.isChecked()) {
                    editor.putBoolean("SquatsConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("SquatsConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConfB") && preferencesTrainingConf.getBoolean("DeadliftClassicConfB",false) == true) {
            checkBoxDeadliftClassicConfB.setChecked(true);
        }else {
            checkBoxDeadliftClassicConfB.setChecked(false);

        }
        checkBoxDeadliftClassicConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConfB.isChecked()) {
                    editor.putBoolean("DeadliftClassicConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConfB") && preferencesTrainingConf.getBoolean("DeadliftClassicConfB",false) == true) {
            checkBoxDeadliftClassicConfB.setChecked(true);
        }else {
            checkBoxDeadliftClassicConfB.setChecked(false);

        }
        checkBoxDeadliftClassicConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConfB.isChecked()) {
                    editor.putBoolean("DeadliftClassicConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BenchPressConfB") && preferencesTrainingConf.getBoolean("BenchPressConfB",false) == true) {
            checkBoxBenchPressConfB.setChecked(true);
        }else {
            checkBoxBenchPressConfB.setChecked(false);

        }
        checkBoxBenchPressConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBenchPressConfB.isChecked()) {
                    editor.putBoolean("BenchPressConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BenchPressConfB", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("NarrowBenchPressConfB") && preferencesTrainingConf.getBoolean("NarrowBenchPressConfB",false) == true) {
            checkBoxNarrowBenchPressConfB.setChecked(true);
        }else {
            checkBoxNarrowBenchPressConfB.setChecked(false);

        }
        checkBoxNarrowBenchPressConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxNarrowBenchPressConfB.isChecked()) {
                    editor.putBoolean("NarrowBenchPressConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("NarrowBenchPressConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("OhpConfB") && preferencesTrainingConf.getBoolean("OhpConfB",false) == true) {
            checkBoxOhpConfB.setChecked(true);
        }else {
            checkBoxOhpConfB.setChecked(false);

        }
        checkBoxOhpConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxOhpConfB.isChecked()) {
                    editor.putBoolean("OhpConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("OhpConfB", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("RowingConfB") && preferencesTrainingConf.getBoolean("RowingConfB",false) == true) {
            checkBoxRowingConfB.setChecked(true);
        }else {
            checkBoxRowingConfB.setChecked(false);

        }
        checkBoxRowingConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRowingConfB.isChecked()) {
                    editor.putBoolean("RowingConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RowingConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("PullingUpNarrowConfB") && preferencesTrainingConf.getBoolean("PullingUpNarrowConfB",false) == true) {
            checkBoxPullingUpNarrowConfB.setChecked(true);
        }else {
            checkBoxPullingUpNarrowConfB.setChecked(false);

        }
        checkBoxPullingUpNarrowConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPullingUpNarrowConfB.isChecked()) {
                    editor.putBoolean("PullingUpNarrowConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PullingUpNarrowConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("RisingSidewaysConfB") && preferencesTrainingConf.getBoolean("RisingSidewaysConfB",false) == true) {
            checkBoxRisingSidewaysConfB.setChecked(true);
        }else {
            checkBoxRisingSidewaysConfB.setChecked(false);

        }
        checkBoxRisingSidewaysConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRisingSidewaysConfB.isChecked()) {
                    editor.putBoolean("RisingSidewaysConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RisingSidewaysConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BicepsConfB") && preferencesTrainingConf.getBoolean("BicepsConfB",false) == true) {
            checkBoxBicepsConfB.setChecked(true);
        }else {
            checkBoxBicepsConfB.setChecked(false);

        }
        checkBoxBicepsConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBicepsConfB.isChecked()) {
                    editor.putBoolean("BicepsConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BicepsConfB", false);
                    editor.apply();

                }
            }
        });


        if(preferencesTrainingConf.contains("TricepsConfB") && preferencesTrainingConf.getBoolean("TricepsConfB",false) == true) {
            checkBoxTricepsConfB.setChecked(true);
        }else {
            checkBoxTricepsConfB.setChecked(false);

        }
        checkBoxTricepsConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxTricepsConfB.isChecked()) {
                    editor.putBoolean("TricepsConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("TricepsConfB", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("AllahsConfB") && preferencesTrainingConf.getBoolean("AllahsConfB",false) == true) {
            checkBoxAllahsConfB.setChecked(true);
        }else {
            checkBoxAllahsConfB.setChecked(false);

        }
        checkBoxAllahsConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConfB.isChecked()) {
                    editor.putBoolean("AllahsConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("AllahsConfB") && preferencesTrainingConf.getBoolean("AllahsConfB",false) == true) {
            checkBoxAllahsConfB.setChecked(true);
        }else {
            checkBoxAllahsConfB.setChecked(false);

        }
        checkBoxAllahsConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConfB.isChecked()) {
                    editor.putBoolean("AllahsConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConfB", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("PlankConfB") && preferencesTrainingConf.getBoolean("PlankConfB",false) == true) {
            checkBoxPlankConfB.setChecked(true);
        }else {
            checkBoxPlankConfB.setChecked(false);

        }
        checkBoxPlankConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPlankConfB.isChecked()) {
                    editor.putBoolean("PlankConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PlankConfB", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("CalvesConfB") && preferencesTrainingConf.getBoolean("CalvesConfB",false) == true) {
            checkBoxCalvesConfB.setChecked(true);
        }else {
            checkBoxCalvesConfB.setChecked(false);

        }
        checkBoxCalvesConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxCalvesConfB.isChecked()) {
                    editor.putBoolean("CalvesConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("CalvesConfB", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("YRaiseConfB") && preferencesTrainingConf.getBoolean("YRaiseConfB",false) == true) {
            checkBoxYRaiseConfB.setChecked(true);
        }else {
            checkBoxYRaiseConfB.setChecked(false);

        }
        checkBoxYRaiseConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConfB.isChecked()) {
                    editor.putBoolean("YRaiseConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("YRaiseConfB", false);
                    editor.apply();
                }
            }
        });




        if(preferencesTrainingConf.contains("FacepullConfB") && preferencesTrainingConf.getBoolean("FacepullConfB",false) == true) {
            checkBoxFacepullConfB.setChecked(true);
        }else {
            checkBoxFacepullConfB.setChecked(false);

        }
        checkBoxFacepullConfB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConfB.isChecked()) {
                    editor.putBoolean("FacepullConfB", true);
                    editor.apply();
                }else{
                    editor.putBoolean("FacepullConfB", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("SquatsConfC") && preferencesTrainingConf.getBoolean("SquatsConfC",false) == true) {
            checkBoxSquatsConfC.setChecked(true);
        }else {
            checkBoxSquatsConfC.setChecked(false);

        }
        checkBoxSquatsConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxSquatsConfC.isChecked()) {
                    editor.putBoolean("SquatsConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("SquatsConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConfC") && preferencesTrainingConf.getBoolean("DeadliftClassicConfC",false) == true) {
            checkBoxDeadliftClassicConfC.setChecked(true);
        }else {
            checkBoxDeadliftClassicConfC.setChecked(false);

        }
        checkBoxDeadliftClassicConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConfC.isChecked()) {
                    editor.putBoolean("DeadliftClassicConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConfC") && preferencesTrainingConf.getBoolean("DeadliftClassicConfC",false) == true) {
            checkBoxDeadliftClassicConfC.setChecked(true);
        }else {
            checkBoxDeadliftClassicConfC.setChecked(false);

        }
        checkBoxDeadliftClassicConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConfC.isChecked()) {
                    editor.putBoolean("DeadliftClassicConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BenchPressConfC") && preferencesTrainingConf.getBoolean("BenchPressConfC",false) == true) {
            checkBoxBenchPressConfC.setChecked(true);
        }else {
            checkBoxBenchPressConfC.setChecked(false);

        }
        checkBoxBenchPressConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBenchPressConfC.isChecked()) {
                    editor.putBoolean("BenchPressConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BenchPressConfC", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("NarrowBenchPressConfC") && preferencesTrainingConf.getBoolean("NarrowBenchPressConfC",false) == true) {
            checkBoxNarrowBenchPressConfC.setChecked(true);
        }else {
            checkBoxNarrowBenchPressConfC.setChecked(false);

        }
        checkBoxNarrowBenchPressConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxNarrowBenchPressConfC.isChecked()) {
                    editor.putBoolean("NarrowBenchPressConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("NarrowBenchPressConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("OhpConfC") && preferencesTrainingConf.getBoolean("OhpConfC",false) == true) {
            checkBoxOhpConfC.setChecked(true);
        }else {
            checkBoxOhpConfC.setChecked(false);

        }
        checkBoxOhpConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxOhpConfC.isChecked()) {
                    editor.putBoolean("OhpConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("OhpConfC", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("RowingConfC") && preferencesTrainingConf.getBoolean("RowingConfC",false) == true) {
            checkBoxRowingConfC.setChecked(true);
        }else {
            checkBoxRowingConfC.setChecked(false);

        }
        checkBoxRowingConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRowingConfC.isChecked()) {
                    editor.putBoolean("RowingConf", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RowingConf", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("PullingUpNarrowConfC") && preferencesTrainingConf.getBoolean("PullingUpNarrowConfC",false) == true) {
            checkBoxPullingUpNarrowConfC.setChecked(true);
        }else {
            checkBoxPullingUpNarrowConfC.setChecked(false);

        }
        checkBoxPullingUpNarrowConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPullingUpNarrowConfC.isChecked()) {
                    editor.putBoolean("PullingUpNarrowConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PullingUpNarrowConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("RisingSidewaysConfC") && preferencesTrainingConf.getBoolean("RisingSidewaysConfC",false) == true) {
            checkBoxRisingSidewaysConfC.setChecked(true);
        }else {
            checkBoxRisingSidewaysConfC.setChecked(false);

        }
        checkBoxRisingSidewaysConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRisingSidewaysConfC.isChecked()) {
                    editor.putBoolean("RisingSidewaysConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RisingSidewaysConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BicepsConfC") && preferencesTrainingConf.getBoolean("BicepsConfC",false) == true) {
            checkBoxBicepsConfC.setChecked(true);
        }else {
            checkBoxBicepsConfC.setChecked(false);

        }
        checkBoxBicepsConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBicepsConfC.isChecked()) {
                    editor.putBoolean("BicepsConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BicepsConfC", false);
                    editor.apply();

                }
            }
        });


        if(preferencesTrainingConf.contains("TricepsConfC") && preferencesTrainingConf.getBoolean("TricepsConfC",false) == true) {
            checkBoxTricepsConfC.setChecked(true);
        }else {
            checkBoxTricepsConfC.setChecked(false);

        }
        checkBoxTricepsConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxTricepsConfC.isChecked()) {
                    editor.putBoolean("TricepsConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("TricepsConfC", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("AllahsConfC") && preferencesTrainingConf.getBoolean("AllahsConfC",false) == true) {
            checkBoxAllahsConfC.setChecked(true);
        }else {
            checkBoxAllahsConfC.setChecked(false);

        }
        checkBoxAllahsConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConfC.isChecked()) {
                    editor.putBoolean("AllahsConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("AllahsConfC") && preferencesTrainingConf.getBoolean("AllahsConfC",false) == true) {
            checkBoxAllahsConfC.setChecked(true);
        }else {
            checkBoxAllahsConfC.setChecked(false);

        }
        checkBoxAllahsConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConfC.isChecked()) {
                    editor.putBoolean("AllahsConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConfC", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("PlankConfC") && preferencesTrainingConf.getBoolean("PlankConfC",false) == true) {
            checkBoxPlankConfC.setChecked(true);
        }else {
            checkBoxPlankConfC.setChecked(false);

        }
        checkBoxPlankConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPlankConfC.isChecked()) {
                    editor.putBoolean("PlankConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PlankConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("CalvesConfC") && preferencesTrainingConf.getBoolean("CalvesConfC",false) == true) {
            checkBoxCalvesConfC.setChecked(true);
        }else {
            checkBoxCalvesConfC.setChecked(false);

        }
        checkBoxCalvesConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxCalvesConfC.isChecked()) {
                    editor.putBoolean("CalvesConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("CalvesConfC", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("YRaiseConfC") && preferencesTrainingConf.getBoolean("YRaiseConfC",false) == true) {
            checkBoxYRaiseConfC.setChecked(true);
        }else {
            checkBoxYRaiseConfC.setChecked(false);

        }
        checkBoxYRaiseConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConfC.isChecked()) {
                    editor.putBoolean("YRaiseConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("YRaiseConf", false);
                    editor.apply();
                }
            }
        });




        if(preferencesTrainingConf.contains("FacepullConfC") && preferencesTrainingConf.getBoolean("FacepullConfC",false) == true) {
            checkBoxFacepullConfC.setChecked(true);
        }else {
            checkBoxFacepullConfC.setChecked(false);

        }
        checkBoxFacepullConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConf.isChecked()) {
                    editor.putBoolean("FacepullConfC", true);
                    editor.apply();
                }else{
                    editor.putBoolean("FacepullConfC", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("SquatsConfD") && preferencesTrainingConf.getBoolean("SquatsConfD",false) == true) {
            checkBoxSquatsConfC.setChecked(true);
        }else {
            checkBoxSquatsConfC.setChecked(false);

        }
        checkBoxSquatsConfC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxSquatsConfC.isChecked()) {
                    editor.putBoolean("SquatsConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("SquatsConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConfD") && preferencesTrainingConf.getBoolean("DeadliftClassicConfD",false) == true) {
            checkBoxDeadliftClassicConfD.setChecked(true);
        }else {
            checkBoxDeadliftClassicConfD.setChecked(false);

        }
        checkBoxDeadliftClassicConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConfD.isChecked()) {
                    editor.putBoolean("DeadliftClassicConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("DeadliftClassicConfD") && preferencesTrainingConf.getBoolean("DeadliftClassicConfD",false) == true) {
            checkBoxDeadliftClassicConfD.setChecked(true);
        }else {
            checkBoxDeadliftClassicConfD.setChecked(false);

        }
        checkBoxDeadliftClassicConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxDeadliftClassicConfD.isChecked()) {
                    editor.putBoolean("DeadliftClassicConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("DeadliftClassicConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BenchPressConfD") && preferencesTrainingConf.getBoolean("BenchPressConfD",false) == true) {
            checkBoxBenchPressConfD.setChecked(true);
        }else {
            checkBoxBenchPressConfD.setChecked(false);

        }
        checkBoxBenchPressConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBenchPressConfD.isChecked()) {
                    editor.putBoolean("BenchPressConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BenchPressConfD", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("NarrowBenchPressConfD") && preferencesTrainingConf.getBoolean("NarrowBenchPressConfD",false) == true) {
            checkBoxNarrowBenchPressConfD.setChecked(true);
        }else {
            checkBoxNarrowBenchPressConfD.setChecked(false);

        }
        checkBoxNarrowBenchPressConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxNarrowBenchPressConfD.isChecked()) {
                    editor.putBoolean("NarrowBenchPressConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("NarrowBenchPressConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("OhpConfD") && preferencesTrainingConf.getBoolean("OhpConfD",false) == true) {
            checkBoxOhpConfD.setChecked(true);
        }else {
            checkBoxOhpConfD.setChecked(false);

        }
        checkBoxOhpConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxOhpConfD.isChecked()) {
                    editor.putBoolean("OhpConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("OhpConfD", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("RowingConfD") && preferencesTrainingConf.getBoolean("RowingConfD",false) == true) {
            checkBoxRowingConfD.setChecked(true);
        }else {
            checkBoxRowingConfD.setChecked(false);

        }
        checkBoxRowingConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRowingConfD.isChecked()) {
                    editor.putBoolean("RowingConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RowingConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("PullingUpNarrowConfD") && preferencesTrainingConf.getBoolean("PullingUpNarrowConfD",false) == true) {
            checkBoxPullingUpNarrowConfD.setChecked(true);
        }else {
            checkBoxPullingUpNarrowConfD.setChecked(false);

        }
        checkBoxPullingUpNarrowConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPullingUpNarrowConfD.isChecked()) {
                    editor.putBoolean("PullingUpNarrowConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PullingUpNarrowConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("RisingSidewaysConfD") && preferencesTrainingConf.getBoolean("RisingSidewaysConfD",false) == true) {
            checkBoxRisingSidewaysConfD.setChecked(true);
        }else {
            checkBoxRisingSidewaysConfD.setChecked(false);

        }
        checkBoxRisingSidewaysConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxRisingSidewaysConfD.isChecked()) {
                    editor.putBoolean("RisingSidewaysConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("RisingSidewaysConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("BicepsConfD") && preferencesTrainingConf.getBoolean("BicepsConfD",false) == true) {
            checkBoxBicepsConfD.setChecked(true);
        }else {
            checkBoxBicepsConfD.setChecked(false);

        }
        checkBoxBicepsConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxBicepsConfD.isChecked()) {
                    editor.putBoolean("BicepsConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("BicepsConfD", false);
                    editor.apply();

                }
            }
        });


        if(preferencesTrainingConf.contains("TricepsConfD") && preferencesTrainingConf.getBoolean("TricepsConfD",false) == true) {
            checkBoxTricepsConfD.setChecked(true);
        }else {
            checkBoxTricepsConfD.setChecked(false);

        }
        checkBoxTricepsConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxTricepsConfD.isChecked()) {
                    editor.putBoolean("TricepsConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("TricepsConfD", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("AllahsConfD") && preferencesTrainingConf.getBoolean("AllahsConfD",false) == true) {
            checkBoxAllahsConfD.setChecked(true);
        }else {
            checkBoxAllahsConfD.setChecked(false);

        }
        checkBoxAllahsConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConfD.isChecked()) {
                    editor.putBoolean("AllahsConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("AllahsConfD") && preferencesTrainingConf.getBoolean("AllahsConfD",false) == true) {
            checkBoxAllahsConfD.setChecked(true);
        }else {
            checkBoxAllahsConfD.setChecked(false);

        }
        checkBoxAllahsConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxAllahsConfD.isChecked()) {
                    editor.putBoolean("AllahsConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("AllahsConfD", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("PlankConfD") && preferencesTrainingConf.getBoolean("PlankConfD",false) == true) {
            checkBoxPlankConfD.setChecked(true);
        }else {
            checkBoxPlankConfD.setChecked(false);

        }
        checkBoxPlankConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxPlankConfD.isChecked()) {
                    editor.putBoolean("PlankConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("PlankConfD", false);
                    editor.apply();
                }
            }
        });

        if(preferencesTrainingConf.contains("CalvesConfD") && preferencesTrainingConf.getBoolean("CalvesConfD",false) == true) {
            checkBoxCalvesConfD.setChecked(true);
        }else {
            checkBoxCalvesConfD.setChecked(false);

        }
        checkBoxCalvesConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxCalvesConfD.isChecked()) {
                    editor.putBoolean("CalvesConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("CalvesConfD", false);
                    editor.apply();
                }
            }
        });


        if(preferencesTrainingConf.contains("YRaiseConfD") && preferencesTrainingConf.getBoolean("YRaiseConfD",false) == true) {
            checkBoxYRaiseConfD.setChecked(true);
        }else {
            checkBoxYRaiseConfD.setChecked(false);

        }
        checkBoxYRaiseConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConfD.isChecked()) {
                    editor.putBoolean("YRaiseConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("YRaiseConfD", false);
                    editor.apply();
                }
            }
        });




        if(preferencesTrainingConf.contains("FacepullConfD") && preferencesTrainingConf.getBoolean("FacepullConfD",false) == true) {
            checkBoxFacepullConfD.setChecked(true);
        }else {
            checkBoxFacepullConfD.setChecked(false);

        }
        checkBoxFacepullConfD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkBoxYRaiseConfD.isChecked()) {
                    editor.putBoolean("FacepullConfD", true);
                    editor.apply();
                }else{
                    editor.putBoolean("FacepullConfD", false);
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


             private void StateZero(){
                 editor.putInt("LastClick",0).apply();
             }
             private void StateOne(){
                 editor.putInt("LastClick",1).apply();
             }

             private void StateTwo(){
                 editor.putInt("LastClick",2).apply();
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
                 buttonFinishWorkoutC.setVisibility(View.GONE);
                 buttonFinishWorkoutD.setVisibility(View.GONE);

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
                 buttonFinishWorkoutC.setVisibility(View.GONE);
                 buttonFinishWorkoutD.setVisibility(View.GONE);

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
                 textViewTrainingC.setVisibility(View.GONE);
                 textViewTrainingD.setVisibility(View.GONE);

             }



             private void CustomWorkout() {

                 if (LastClick==2&&checkBoxSquatsConf.isChecked()||checkBoxDeadliftClassicConf.isChecked()||checkBoxOhpConf.isChecked()||checkBoxBenchPressConf.isChecked()||
                         checkBoxNarrowBenchPressConf.isChecked()||checkBoxRisingSidewaysConf.isChecked()||checkBoxPullingUpNarrowConf.isChecked()||checkBoxRisingSidewaysConf.isChecked()||
                         checkBoxBicepsConf.isChecked()||checkBoxTricepsConf.isChecked()||checkBoxAllahsConf.isChecked()||checkBoxPlankConf.isChecked()|| checkBoxCalvesConf.isChecked()||
                         checkBoxYRaiseConf.isChecked()||checkBoxFacepullConf.isChecked()) {

                     textViewTrainingA.setVisibility(View.VISIBLE);
                     textViewTrainingB.setVisibility(View.GONE);
                     textViewTrainingC.setVisibility(View.GONE);
                     textViewTrainingD.setVisibility(View.GONE);
                     buttonFinishWorkout.setVisibility(View.VISIBLE);
                     buttonFinishWorkoutB.setVisibility(View.GONE);
                     buttonFinishWorkoutC.setVisibility(View.GONE);
                     buttonFinishWorkoutD.setVisibility(View.GONE);

                 }
                 else
                 {
                     textViewTrainingA.setVisibility(View.GONE);
                     textViewTrainingB.setVisibility(View.GONE);
                     textViewTrainingC.setVisibility(View.GONE);
                     textViewTrainingD.setVisibility(View.GONE);
                     buttonFinishWorkout.setVisibility(View.GONE);
                     buttonFinishWorkoutB.setVisibility(View.GONE);
                     buttonFinishWorkoutC.setVisibility(View.GONE);
                     buttonFinishWorkoutD.setVisibility(View.GONE);
                 }


                 if (LastClick==2&&checkBoxSquatsConf.isChecked()){
                     checkBoxSquats.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxSquats.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxBenchPressConf.isChecked()){
                     checkBoxBenchPress.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBenchPress.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRowingConf.isChecked()){
                     checkBoxRowing.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRowing.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRisingSidewaysConf.isChecked()){
                     checkBoxRisingSideways.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRisingSideways.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxBicepsConf.isChecked()){
                     checkBoxBiceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBiceps.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxTricepsConf.isChecked()){
                     checkBoxTriceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxTriceps.setVisibility(View.GONE);
                 }


                 if (LastClick==2&&checkBoxAllahsConf.isChecked()){
                     checkBoxAllahs.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxAllahs.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxCalvesConf.isChecked()){
                 }
                 else {
                     checkBoxCalves.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxFacepullConf.isChecked()){
                 }
                 else {
                     checkBoxFacepull.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxDeadliftClassicConf.isChecked()){
                     checkBoxDeadliftClassic.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxDeadliftClassic.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxOhpConf.isChecked()){
                     checkBoxOhp.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxOhp.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPullingUpNarrowConf.isChecked()){
                     checkBoxPullingUpNarrow.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPullingUpNarrow.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxNarrowBenchPressConf.isChecked()){
                     checkBoxNarrowBenchPress.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxNarrowBenchPress.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxYRaiseConf.isChecked()){
                     checkBoxYRaise.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxYRaise.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPlankConf.isChecked()){
                     checkBoxPlank.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPlank.setVisibility(View.GONE);
                 }

             }





                 private void CustomWorkoutB() {
                     textViewTrainingA.setVisibility(View.GONE);
                     textViewTrainingB.setVisibility(View.VISIBLE);
                     textViewTrainingC.setVisibility(View.GONE);
                     textViewTrainingD.setVisibility(View.GONE);
                     buttonFinishWorkout.setVisibility(View.GONE);
                     buttonFinishWorkoutB.setVisibility(View.VISIBLE);
                     buttonFinishWorkoutC.setVisibility(View.GONE);
                     buttonFinishWorkoutD.setVisibility(View.GONE);





                 if (LastClick==2&&checkBoxSquatsConfB.isChecked()){
                     checkBoxSquats.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxSquats.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxBenchPressConfB.isChecked()){
                     checkBoxBenchPress.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBenchPress.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRowingConfB.isChecked()){
                     checkBoxRowing.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRowing.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRisingSidewaysConfB.isChecked()){
                     checkBoxRisingSideways.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRisingSideways.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxBicepsConfB.isChecked()){
                     checkBoxBiceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBiceps.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxTricepsConfB.isChecked()){
                     checkBoxTriceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxTriceps.setVisibility(View.GONE);
                 }


                 if (LastClick==2&&checkBoxAllahsConfB.isChecked()){
                     checkBoxAllahs.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxAllahs.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxCalvesConfB.isChecked()){
                 }
                 else {
                     checkBoxCalves.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxFacepullConfB.isChecked()){
                 }
                 else {
                     checkBoxFacepull.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxDeadliftClassicConfB.isChecked()){
                     checkBoxDeadliftClassic.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxDeadliftClassic.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxOhpConfB.isChecked()){
                     checkBoxOhp.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxOhp.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPullingUpNarrowConfB.isChecked()){
                     checkBoxPullingUpNarrow.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPullingUpNarrow.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxNarrowBenchPressConfB.isChecked()){
                     checkBoxNarrowBenchPress.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxNarrowBenchPress.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxYRaiseConfB.isChecked()){
                     checkBoxYRaise.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxYRaise.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPlankConfB.isChecked()){
                     checkBoxPlank.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPlank.setVisibility(View.GONE);
                 }

             }

             private void CustomWorkoutC() {
                 textViewTrainingA.setVisibility(View.GONE);
                 textViewTrainingB.setVisibility(View.GONE);
                 textViewTrainingC.setVisibility(View.VISIBLE);
                 textViewTrainingD.setVisibility(View.GONE);
                 buttonFinishWorkout.setVisibility(View.GONE);
                 buttonFinishWorkoutB.setVisibility(View.GONE);
                 buttonFinishWorkoutC.setVisibility(View.VISIBLE);
                 buttonFinishWorkoutD.setVisibility(View.GONE);





                 if (LastClick==2&&checkBoxSquatsConfC.isChecked()){
                     checkBoxSquats.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxSquats.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxBenchPressConfC.isChecked()){
                     checkBoxBenchPress.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBenchPress.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRowingConfC.isChecked()){
                     checkBoxRowing.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRowing.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRisingSidewaysConfC.isChecked()){
                     checkBoxRisingSideways.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRisingSideways.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxBicepsConfC.isChecked()){
                     checkBoxBiceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBiceps.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxTricepsConfC.isChecked()){
                     checkBoxTriceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxTriceps.setVisibility(View.GONE);
                 }


                 if (LastClick==2&&checkBoxAllahsConfC.isChecked()){
                     checkBoxAllahs.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxAllahs.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxCalvesConfC.isChecked()){
                 }
                 else {
                     checkBoxCalves.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxFacepullConfC.isChecked()){
                 }
                 else {
                     checkBoxFacepull.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxDeadliftClassicConfC.isChecked()){
                     checkBoxDeadliftClassic.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxDeadliftClassic.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxOhpConfC.isChecked()){
                     checkBoxOhp.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxOhp.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPullingUpNarrowConfC.isChecked()){
                     checkBoxPullingUpNarrow.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPullingUpNarrow.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxNarrowBenchPressConfC.isChecked()){
                     checkBoxNarrowBenchPress.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxNarrowBenchPress.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxYRaiseConfC.isChecked()){
                     checkBoxYRaise.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxYRaise.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPlankConfC.isChecked()){
                     checkBoxPlank.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPlank.setVisibility(View.GONE);
                 }

             }


             private void CustomWorkoutD() {



                     textViewTrainingA.setVisibility(View.GONE);
                     textViewTrainingB.setVisibility(View.GONE);
                     textViewTrainingC.setVisibility(View.GONE);
                     textViewTrainingD.setVisibility(View.VISIBLE);
                     buttonFinishWorkout.setVisibility(View.GONE);
                     buttonFinishWorkoutB.setVisibility(View.GONE);
                     buttonFinishWorkoutC.setVisibility(View.GONE);
                     buttonFinishWorkoutD.setVisibility(View.VISIBLE);





                 if (LastClick==2&&checkBoxSquatsConfD.isChecked()){
                     checkBoxSquats.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxSquats.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxBenchPressConfD.isChecked()){
                     checkBoxBenchPress.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBenchPress.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRowingConfD.isChecked()){
                     checkBoxRowing.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRowing.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxRisingSidewaysConfD.isChecked()){
                     checkBoxRisingSideways.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxRisingSideways.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxBicepsConfD.isChecked()){
                     checkBoxBiceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxBiceps.setVisibility(View.GONE);

                 }

                 if (LastClick==2&&checkBoxTricepsConfD.isChecked()){
                     checkBoxTriceps.setVisibility(View.VISIBLE);

                 }
                 else {
                     checkBoxTriceps.setVisibility(View.GONE);
                 }


                 if (LastClick==2&&checkBoxAllahsConfD.isChecked()){
                     checkBoxAllahs.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxAllahs.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxCalvesConfD.isChecked()){
                 }
                 else {
                     checkBoxCalves.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxFacepullConfD.isChecked()){
                 }
                 else {
                     checkBoxFacepull.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxDeadliftClassicConfD.isChecked()){
                     checkBoxDeadliftClassic.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxDeadliftClassic.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxOhpConfD.isChecked()){
                     checkBoxOhp.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxOhp.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPullingUpNarrowConfD.isChecked()){
                     checkBoxPullingUpNarrow.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPullingUpNarrow.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxNarrowBenchPressConfD.isChecked()){
                     checkBoxNarrowBenchPress.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxNarrowBenchPress.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxYRaiseConfD.isChecked()){
                     checkBoxYRaise.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxYRaise.setVisibility(View.GONE);
                 }

                 if (LastClick==2&&checkBoxPlankConfD.isChecked()){
                     checkBoxPlank.setVisibility(View.VISIBLE);
                 }
                 else {
                     checkBoxPlank.setVisibility(View.GONE);
                 }

             }
             private void unchekedCheckBoxes(){
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
