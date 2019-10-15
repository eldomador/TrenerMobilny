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
import android.widget.Toast;

public class TrainingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
         {

    Spinner spinnerWorkouts;
    SharedPreferences LastSelect,LastWorkout;
    SharedPreferences.Editor editor,editorSelect;


    private LinearLayout linearLayoutTrainingA,linearLayoutWeightConfiguration,linearLayoutTrainingConfiguration;
    private CheckBox checkBoxSquats,checkBoxBenchPress,checkBoxRowing,checkBoxRisingSideways,checkBoxBiceps,checkBoxTriceps,checkBoxAllahs,checkBoxCalves,checkBoxFacepull,checkBoxDeadliftClassic,checkBoxOhp,checkBoxPullingUpNarrow,checkBoxNarrowBenchPress,checkBoxYRaise,checkBoxPlank;
    private TextView textViewMaxKg,textViewSquat;
    private EditText editTextSquat,editTextBenchPress,editTextRowing,editTextRisingSideways,editTextBiceps,editTextTriceps,editTextAllahs,editTextFacepull,editTextDeadliftClassic,editTextOhp,editTextPullingUpNarrow,editTextNarrowBenchPress,editTextYRaise;
    private Button buttonWeightConfiguration,buttonTrainingConfiguration,buttonSaveWeightConfiguration,buttonFinishWorkout,buttonFinishWorkoutB;
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



        buttonWeightConfiguration=(Button)findViewById(R.id.buttonWeightConfiguration);
        buttonTrainingConfiguration = (Button)findViewById(R.id.buttonTrainingConfiguration);
        buttonSaveWeightConfiguration =(Button)findViewById(R.id.buttonSaveWeightConfiguration);
        buttonFinishWorkout =(Button)findViewById(R.id.buttonFinishWorkout);
        buttonFinishWorkoutB =(Button)findViewById(R.id.buttonFinishWorkoutB);

        textViewMaxKg =(TextView)findViewById(R.id.textViewMaxKg);
        textViewSquat =(TextView)findViewById(R.id.textViewSquat);

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
        editorSelect=LastSelect.edit();
        final int LastClick = LastSelect.getInt("LastClick",0);

        LastWorkout = getSharedPreferences("LastWorkoutState", Context.MODE_PRIVATE);
        editor=LastWorkout.edit();
        final int LastWorkoutState= LastWorkout.getInt("LastWorkoutState",0);



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


                WorkoutAVisiable();
                WorkoutBGone();
               // linearLayoutTrainingA.setVisibility(View.GONE);
                //linearLayoutTrainingB.setVisibility(View.VISIBLE);

                editor.putInt("LastWorkoutState",1).commit();
                Toast.makeText(getApplicationContext()," TEST "+LastWorkoutState,Toast.LENGTH_LONG).show();
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
                checkBoxYRaise.setChecked(false);
                checkBoxPlank.setChecked(false);



                WorkoutAVisiable();
                WorkoutBGone();
               // linearLayoutTrainingA.setVisibility(View.VISIBLE);
               // linearLayoutTrainingB.setVisibility(View.GONE);
                editor.putInt("LastWorkoutState",0).apply();
                Toast.makeText(getApplicationContext()," TEST "+LastWorkoutState,Toast.LENGTH_LONG).show();




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
                        WorkoutAGone();
                        WorkoutBGone();
                       // linearLayoutTrainingA.setVisibility(View.GONE);
                        //linearLayoutTrainingB.setVisibility(View.GONE);
                        buttonTrainingConfiguration.setVisibility(View.GONE);
                        buttonWeightConfiguration.setVisibility(View.GONE);
                        buttonFinishWorkout.setVisibility(View.GONE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        editorSelect.putInt("LastClick",0).apply();
                        Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        buttonTrainingConfiguration.setVisibility(View.GONE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        buttonFinishWorkout.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        calcWeightConfiguration();

                        if (LastWorkoutState==0){

                            WorkoutAVisiable();
                            WorkoutBGone();
                            //linearLayoutTrainingB.setVisibility(View.GONE);
                            //linearLayoutTrainingA.setVisibility(View.VISIBLE);
                        }

                        else if (LastWorkoutState==1){
                            WorkoutAGone();
                            WorkoutBVisiable();
                            //linearLayoutTrainingB.setVisibility(View.VISIBLE);
                            //linearLayoutTrainingA.setVisibility(View.GONE);
                            }
                        editorSelect.putInt("LastClick",1).commit();
                        Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        WorkoutAGone();
                        WorkoutBGone();
                        //linearLayoutTrainingA.setVisibility(View.GONE);
                       // linearLayoutTrainingB.setVisibility(View.GONE);
                        buttonTrainingConfiguration.setVisibility(View.VISIBLE);
                        buttonWeightConfiguration.setVisibility(View.VISIBLE);
                        linearLayoutWeightConfiguration.setVisibility(View.GONE);
                        linearLayoutTrainingConfiguration.setVisibility(View.GONE);
                        editorSelect.putInt("LastClick",2).commit();
                        Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();

                        break;
                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

             private void WorkoutAVisiable() {}
             private void WorkoutAGone() {}
             private void WorkoutBVisiable() {}
             private void WorkoutBGone() {}

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

                     checkBoxYRaise.setText("Wyciskanie Wąsko 5 x 5 x "+nSeries+"kg");
                     editTextYRaise.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextYRaise.getText().length() != 0 && !checkBoxYRaise.isChecked()){
                     double n1 = Double.parseDouble(editTextNarrowBenchPress.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxYRaise.setText("Wyciskanie Wąsko 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextYRaise.getText().length() == 0) {
                     checkBoxYRaise.setText("brak konfiguracji obciążenia dla Y-Raise");
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
