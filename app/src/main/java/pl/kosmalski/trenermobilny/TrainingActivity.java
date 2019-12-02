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

import java.math.BigDecimal;

public class TrainingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
         {

    Spinner spinnerWorkouts;
    SharedPreferences prefs;
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
            editTextOhp,editTextPullingUpNarrow,editTextNarrowBenchPress,editTextYRaise,
            editTextSeriesSquat,editTextRepsSquat,editTextPercentSquat,editTextProgressionSquat,
            editTextSeriesDeadliftClassic,editTextRepsDeadliftClassic,editTextPercentDeadliftClassic,editTextProgressionDeadliftClassic,
            editTextSeriesBenchPress,editTextRepsBenchPress,editTextPercentBenchPress,editTextProgressionBenchPress,
            editTextSeriesNarrowBenchPress,editTextRepsNarrowBenchPress,editTextPercentNarrowBenchPress,editTextProgressionNarrowBenchPress,
            editTextSeriesOhp,editTextRepsOhp,editTextPercentOhp,editTextProgressionOhp,
            editTextSeriesRowing,editTextRepsRowing,editTextPercentRowing,editTextProgressionRowing,
            editTextSeriesPullingUpNarrow,editTextRepsPullingUpNarrow,editTextPercentPullingUpNarrow,editTextProgressionPullingUpNarrow,
            editTextSeriesRisingSideways,editTextRepsRisingSideways,editTextPercentRisingSideways,editTextProgressionRisingSideways,
            editTextSeriesBiceps,editTextRepsBiceps,editTextPercentBiceps,editTextProgressionBiceps,
            editTextSeriesTriceps,editTextRepsTriceps,editTextPercentTriceps,editTextProgressionTriceps,
            editTextSeriesAllahs,editTextRepsAllahs,editTextPercentAllahs,editTextProgressionAllahs,
            editTextSeriesPlank,editTextSecondsPlank,editTextProgressionPlank,
            editTextSeriesCalves,editTextRepsCalves,editTextPercentCalves,editTextProgressionCalves,
            editTextSeriesYRaise,editTextRepsYRaise,editTextPercentYRaise,editTextProgressionYRaise,
            editTextSeriesFacepull,editTextRepsFacepull,editTextPercentFacepull,editTextProgressionFacepull,
            editTextSeriesSquatB,editTextRepsSquatB,editTextPercentSquatB,editTextProgressionSquatB,
            editTextSeriesDeadliftClassicB,editTextRepsDeadliftClassicB,editTextPercentDeadliftClassicB,editTextProgressionDeadliftClassicB,
            editTextSeriesBenchPressB,editTextRepsBenchPressB,editTextPercentBenchPressB,editTextProgressionBenchPressB,
            editTextSeriesNarrowBenchPressB,editTextRepsNarrowBenchPressB,editTextPercentNarrowBenchPressB,editTextProgressionNarrowBenchPressB,
            editTextSeriesOhpB,editTextRepsOhpB,editTextPercentOhpB,editTextProgressionOhpB,
            editTextSeriesRowingB,editTextRepsRowingB,editTextPercentRowingB,editTextProgressionRowingB,
            editTextSeriesPullingUpNarrowB,editTextRepsPullingUpNarrowB,editTextPercentPullingUpNarrowB,editTextProgressionPullingUpNarrowB,
            editTextSeriesRisingSidewaysB,editTextRepsRisingSidewaysB,editTextPercentRisingSidewaysB,editTextProgressionRisingSidewaysB,
            editTextSeriesBicepsB,editTextRepsBicepsB,editTextPercentBicepsB,editTextProgressionBicepsB,
            editTextSeriesTricepsB,editTextRepsTricepsB,editTextPercentTricepsB,editTextProgressionTricepsB,
            editTextSeriesAllahsB,editTextRepsAllahsB,editTextPercentAllahsB,editTextProgressionAllahsB,
            editTextSeriesPlankB,editTextSecondsPlankB,editTextProgressionPlankB,
            editTextSeriesCalvesB,editTextRepsCalvesB,editTextPercentCalvesB,editTextProgressionCalvesB,
            editTextSeriesYRaiseB,editTextRepsYRaiseB,editTextPercentYRaiseB,editTextProgressionYRaiseB,
            editTextSeriesFacepullB,editTextRepsFacepullB,editTextPercentFacepullB,editTextProgressionFacepullB,
            editTextSeriesSquatC,editTextRepsSquatC,editTextPercentSquatC,editTextProgressionSquatC,
            editTextSeriesDeadliftClassicC,editTextRepsDeadliftClassicC,editTextPercentDeadliftClassicC,editTextProgressionDeadliftClassicC,
            editTextSeriesBenchPressC,editTextRepsBenchPressC,editTextPercentBenchPressC,editTextProgressionBenchPressC,
            editTextSeriesNarrowBenchPressC,editTextRepsNarrowBenchPressC,editTextPercentNarrowBenchPressC,editTextProgressionNarrowBenchPressC,
            editTextSeriesOhpC,editTextRepsOhpC,editTextPercentOhpC,editTextProgressionOhpC,
            editTextSeriesRowingC,editTextRepsRowingC,editTextPercentRowingC,editTextProgressionRowingC,
            editTextSeriesPullingUpNarrowC,editTextRepsPullingUpNarrowC,editTextPercentPullingUpNarrowC,editTextProgressionPullingUpNarrowC,
            editTextSeriesRisingSidewaysC,editTextRepsRisingSidewaysC,editTextPercentRisingSidewaysC,editTextProgressionRisingSidewaysC,
            editTextSeriesBicepsC,editTextRepsBicepsC,editTextPercentBicepsC,editTextProgressionBicepsC,
            editTextSeriesTricepsC,editTextRepsTricepsC,editTextPercentTricepsC,editTextProgressionTricepsC,
            editTextSeriesAllahsC,editTextRepsAllahsC,editTextPercentAllahsC,editTextProgressionAllahsC,
            editTextSeriesPlankC,editTextSecondsPlankC,editTextProgressionPlankC,
            editTextSeriesCalvesC,editTextRepsCalvesC,editTextPercentCalvesC,editTextProgressionCalvesC,
            editTextSeriesYRaiseC,editTextRepsYRaiseC,editTextPercentYRaiseC,editTextProgressionYRaiseC,
            editTextSeriesFacepullC,editTextRepsFacepullC,editTextPercentFacepullC,editTextProgressionFacepullC,
            editTextSeriesSquatD,editTextRepsSquatD,editTextPercentSquatD,editTextProgressionSquatD,
            editTextSeriesDeadliftClassicD,editTextRepsDeadliftClassicD,editTextPercentDeadliftClassicD,editTextProgressionDeadliftClassicD,
            editTextSeriesBenchPressD,editTextRepsBenchPressD,editTextPercentBenchPressD,editTextProgressionBenchPressD,
            editTextSeriesNarrowBenchPressD,editTextRepsNarrowBenchPressD,editTextPercentNarrowBenchPressD,editTextProgressionNarrowBenchPressD,
            editTextSeriesOhpD,editTextRepsOhpD,editTextPercentOhpD,editTextProgressionOhpD,
            editTextSeriesRowingD,editTextRepsRowingD,editTextPercentRowingD,editTextProgressionRowingD,
            editTextSeriesPullingUpNarrowD,editTextRepsPullingUpNarrowD,editTextPercentPullingUpNarrowD,editTextProgressionPullingUpNarrowD,
            editTextSeriesRisingSidewaysD,editTextRepsRisingSidewaysD,editTextPercentRisingSidewaysD,editTextProgressionRisingSidewaysD,
            editTextSeriesBicepsD,editTextRepsBicepsD,editTextPercentBicepsD,editTextProgressionBicepsD,
            editTextSeriesTricepsD,editTextRepsTricepsD,editTextPercentTricepsD,editTextProgressionTricepsD,
            editTextSeriesAllahsD,editTextRepsAllahsD,editTextPercentAllahsD,editTextProgressionAllahsD,
            editTextSeriesPlankD,editTextSecondsPlankD,editTextProgressionPlankD,
            editTextSeriesCalvesD,editTextRepsCalvesD,editTextPercentCalvesD,editTextProgressionCalvesD,
            editTextSeriesYRaiseD,editTextRepsYRaiseD,editTextPercentYRaiseD,editTextProgressionYRaiseD,
            editTextSeriesFacepullD,editTextRepsFacepullD,editTextPercentFacepullD,editTextProgressionFacepullD;


    private Button buttonWeightConfiguration,buttonTrainingConfiguration,buttonSaveWeightConfiguration,buttonFinishWorkout,buttonFinishWorkoutB,buttonFinishWorkoutC,buttonFinishWorkoutD,
            buttonSaveTrainingConfiguration,buttonNextTrainingConfiguration,buttonNextTrainingConfigurationB,buttonNextTrainingConfigurationC;
    private int LastClick,LastCustomWorkoutState,
            seriesSquat,repsSquat,percentSquat,
            seriesDeadliftClassic,repsDeadliftClassic,percentDeadliftClassic,
            seriesBenchPress,repsBenchPress,percentBenchPress,
            seriesNarrowBenchPress,repsNarrowBenchPress,percentNarrowBenchPress,
            seriesOhp,repsOhp,percentOhp,
            seriesRowing,repsRowing,percentRowing,
            seriesPullingUpNarrow,repsPullingUpNarrow,percentPullingUpNarrow,
            seriesRisingSideways,repsRisingSideways,percentRisingSideways,
            seriesBiceps,repsBiceps,percentBiceps,
            seriesTriceps,repsTriceps,percentTriceps,
            seriesAllahs,repsAllahs,percentAllahs,
            seriesPlank,secondsPlank,
            seriesCalves,repsCalves,percentCalves,
            seriesYRaise,repsYRaise,percentYRaise,
            seriesFacepull,repsFacepull,percentFacepull,
            seriesSquatB,repsSquatB,percentSquatB,
            seriesDeadliftClassicB,repsDeadliftClassicB,percentDeadliftClassicB,
            seriesBenchPressB,repsBenchPressB,percentBenchPressB,
            seriesNarrowBenchPressB,repsNarrowBenchPressB,percentNarrowBenchPressB,
            seriesOhpB,repsOhpB,percentOhpB,
            seriesRowingB,repsRowingB,percentRowingB,
            seriesPullingUpNarrowB,repsPullingUpNarrowB,percentPullingUpNarrowB,
            seriesRisingSidewaysB,repsRisingSidewaysB,percentRisingSidewaysB,
            seriesBicepsB,repsBicepsB,percentBicepsB,
            seriesTricepsB,repsTricepsB,percentTricepsB,
            seriesAllahsB,repsAllahsB,percentAllahsB,
            seriesPlankB,secondsPlankB,
            seriesCalvesB,repsCalvesB,percentCalvesB,
            seriesYRaiseB,repsYRaiseB,percentYRaiseB,
            seriesFacepullB,repsFacepullB,percentFacepullB,
            seriesSquatC,repsSquatC,percentSquatC,
            seriesDeadliftClassicC,repsDeadliftClassicC,percentDeadliftClassicC,
            seriesBenchPressC,repsBenchPressC,percentBenchPressC,
            seriesNarrowBenchPressC,repsNarrowBenchPressC,percentNarrowBenchPressC,
            seriesOhpC,repsOhpC,percentOhpC,
            seriesRowingC,repsRowingC,percentRowingC,
            seriesPullingUpNarrowC,repsPullingUpNarrowC,percentPullingUpNarrowC,
            seriesRisingSidewaysC,repsRisingSidewaysC,percentRisingSidewaysC,
            seriesBicepsC,repsBicepsC,percentBicepsC,
            seriesTricepsC,repsTricepsC,percentTricepsC,
            seriesAllahsC,repsAllahsC,percentAllahsC,
            seriesPlankC,secondsPlankC,
            seriesCalvesC,repsCalvesC,percentCalvesC,
            seriesYRaiseC,repsYRaiseC,percentYRaiseC,
            seriesFacepullC,repsFacepullC,percentFacepullC,
            seriesSquatD,repsSquatD,percentSquatD,
            seriesDeadliftClassicD,repsDeadliftClassicD,percentDeadliftClassicD,
            seriesBenchPressD,repsBenchPressD,percentBenchPressD,
            seriesNarrowBenchPressD,repsNarrowBenchPressD,percentNarrowBenchPressD,
            seriesOhpD,repsOhpD,percentOhpD,
            seriesRowingD,repsRowingD,percentRowingD,
            seriesPullingUpNarrowD,repsPullingUpNarrowD,percentPullingUpNarrowD,
            seriesRisingSidewaysD,repsRisingSidewaysD,percentRisingSidewaysD,
            seriesBicepsD,repsBicepsD,percentBicepsD,
            seriesTricepsD,repsTricepsD,percentTricepsD,
            seriesAllahsD,repsAllahsD,percentAllahsD,
            seriesPlankD,secondsPlankD,
            seriesCalvesD,repsCalvesD,percentCalvesD,
            seriesYRaiseD,repsYRaiseD,percentYRaiseD,
            seriesFacepullD,repsFacepullD,percentFacepullD;

    private float progressionSquat,progressionDeadliftClassic,progressionBenchPress,progressionNarrowBenchPress,progressionOhp,progressionRowing,
            progressionPullingUpNarrow,progressionRisingSideways,progressionBiceps,progressionTriceps,progressionAllahs,progressionPlank,progressionCalves,
            progressionYRaise,progressionFacepull,progressionSquatB,progressionDeadliftClassicB,progressionBenchPressB,progressionNarrowBenchPressB,progressionOhpB,progressionRowingB,
            progressionPullingUpNarrowB,progressionRisingSidewaysB,progressionBicepsB,progressionTricepsB,progressionAllahsB,progressionPlankB,progressionCalvesB,
            progressionYRaiseB,progressionFacepullB,progressionSquatC,progressionDeadliftClassicC,progressionBenchPressC,progressionNarrowBenchPressC,progressionOhpC,progressionRowingC,
            progressionPullingUpNarrowC,progressionRisingSidewaysC,progressionBicepsC,progressionTricepsC,progressionAllahsC,progressionPlankC,progressionCalvesC,
            progressionYRaiseC,progressionFacepullC,progressionSquatD,progressionDeadliftClassicD,progressionBenchPressD,progressionNarrowBenchPressD,progressionOhpD,progressionRowingD,
            progressionPullingUpNarrowD,progressionRisingSidewaysD,progressionBicepsD,progressionTricepsD,progressionAllahsD,progressionPlankD,progressionCalvesD,
            progressionYRaiseD,progressionFacepullD;
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

        editTextSeriesSquat = (EditText)findViewById(R.id.editTextSeriesSquat);
        editTextRepsSquat = (EditText)findViewById(R.id.editTextRepsSquat);
        editTextPercentSquat= (EditText)findViewById(R.id.editTextPercentSquat);
        editTextProgressionSquat = (EditText)findViewById(R.id.editTextProgressionSquat);
        editTextSeriesDeadliftClassic= (EditText)findViewById(R.id.editTextSeriesDeadliftClassic);
        editTextRepsDeadliftClassic= (EditText)findViewById(R.id.editTextRepsDeadliftClassic);
        editTextPercentDeadliftClassic= (EditText)findViewById(R.id.editTextPercentDeadliftClassic);
        editTextProgressionDeadliftClassic= (EditText)findViewById(R.id.editTextProgressionDeadliftClassic);
        editTextSeriesBenchPress= (EditText)findViewById(R.id.editTextSeriesBenchPress);
        editTextRepsBenchPress= (EditText)findViewById(R.id.editTextRepsBenchPress);
        editTextPercentBenchPress= (EditText)findViewById(R.id.editTextPercentBenchPress);
        editTextProgressionBenchPress= (EditText)findViewById(R.id.editTextProgressionBenchPress);
        editTextSeriesNarrowBenchPress= (EditText)findViewById(R.id. editTextSeriesNarrowBenchPress);
        editTextRepsNarrowBenchPress= (EditText)findViewById(R.id.editTextRepsNarrowBenchPress);
        editTextPercentNarrowBenchPress= (EditText)findViewById(R.id.editTextPercentNarrowBenchPress);
        editTextProgressionNarrowBenchPress= (EditText)findViewById(R.id.editTextProgressionNarrowBenchPress);
        editTextSeriesOhp= (EditText)findViewById(R.id.editTextSeriesOhp);
        editTextRepsOhp= (EditText)findViewById(R.id.editTextRepsOhp);
        editTextPercentOhp= (EditText)findViewById(R.id.editTextPercentOhp);
        editTextProgressionOhp= (EditText)findViewById(R.id. editTextProgressionOhp);
        editTextSeriesRowing= (EditText)findViewById(R.id.editTextSeriesRowing);
        editTextRepsRowing= (EditText)findViewById(R.id.editTextRepsRowing);
        editTextPercentRowing= (EditText)findViewById(R.id.editTextPercentRowing);
        editTextProgressionRowing= (EditText)findViewById(R.id.editTextProgressionRowing);
        editTextSeriesPullingUpNarrow= (EditText)findViewById(R.id.editTextSeriesPullingUpNarrow);
        editTextRepsPullingUpNarrow= (EditText)findViewById(R.id.editTextRepsPullingUpNarrow);
        editTextPercentPullingUpNarrow= (EditText)findViewById(R.id.editTextPercentPullingUpNarrow);
        editTextProgressionPullingUpNarrow= (EditText)findViewById(R.id.editTextProgressionPullingUpNarrow);
        editTextSeriesRisingSideways = (EditText)findViewById(R.id.editTextSeriesRisingSideways);
        editTextRepsRisingSideways = (EditText)findViewById(R.id.editTextRepsRisingSideways);
        editTextPercentRisingSideways = (EditText)findViewById(R.id.editTextPercentRisingSideways);
        editTextProgressionRisingSideways = (EditText)findViewById(R.id.editTextProgressionRisingSideways);
        editTextSeriesBiceps= (EditText)findViewById(R.id.editTextSeriesBiceps);
        editTextRepsBiceps= (EditText)findViewById(R.id. editTextRepsBiceps);
        editTextPercentBiceps= (EditText)findViewById(R.id. editTextPercentBiceps);
        editTextProgressionBiceps= (EditText)findViewById(R.id.editTextProgressionBiceps);
        editTextSeriesTriceps= (EditText)findViewById(R.id.editTextSeriesTriceps);
        editTextRepsTriceps= (EditText)findViewById(R.id.editTextRepsTriceps);
        editTextPercentTriceps= (EditText)findViewById(R.id.editTextPercentTriceps);
        editTextProgressionTriceps= (EditText)findViewById(R.id.editTextProgressionTriceps);
        editTextSeriesAllahs= (EditText)findViewById(R.id.editTextSeriesAllahs);
        editTextRepsAllahs= (EditText)findViewById(R.id.editTextRepsAllahs);
        editTextPercentAllahs= (EditText)findViewById(R.id. editTextPercentAllahs);
        editTextProgressionAllahs= (EditText)findViewById(R.id.editTextProgressionAllahs);
        editTextSeriesPlank= (EditText)findViewById(R.id.editTextSeriesPlank);
        editTextSecondsPlank= (EditText)findViewById(R.id.editTextSecondsPlank);
        editTextProgressionPlank= (EditText)findViewById(R.id.editTextProgressionPlank);
        editTextSeriesCalves= (EditText)findViewById(R.id.editTextSeriesCalves);
        editTextRepsCalves= (EditText)findViewById(R.id.editTextRepsCalves);
        editTextPercentCalves= (EditText)findViewById(R.id.editTextPercentCalves);
        editTextProgressionCalves= (EditText)findViewById(R.id.editTextProgressionCalves);
        editTextSeriesYRaise= (EditText)findViewById(R.id.editTextSeriesYRaise);
        editTextRepsYRaise= (EditText)findViewById(R.id.editTextRepsYRaise);
        editTextPercentYRaise= (EditText)findViewById(R.id.editTextPercentYRaise);
        editTextProgressionYRaise= (EditText)findViewById(R.id.editTextProgressionYRaise);
        editTextSeriesFacepull= (EditText)findViewById(R.id.editTextSeriesFacepull);
        editTextRepsFacepull= (EditText)findViewById(R.id.editTextRepsFacepull);
        editTextPercentFacepull= (EditText)findViewById(R.id.editTextPercentFacepull);
        editTextProgressionFacepull= (EditText)findViewById(R.id.editTextProgressionFacepull);


        editTextSeriesSquatB = (EditText)findViewById(R.id.editTextSeriesSquatB);
        editTextRepsSquatB = (EditText)findViewById(R.id.editTextRepsSquatB);
        editTextPercentSquatB= (EditText)findViewById(R.id.editTextPercentSquatB);
        editTextProgressionSquatB = (EditText)findViewById(R.id.editTextProgressionSquatB);
        editTextSeriesDeadliftClassicB= (EditText)findViewById(R.id.editTextSeriesDeadliftClassicB);
        editTextRepsDeadliftClassicB= (EditText)findViewById(R.id.editTextRepsDeadliftClassicB);
        editTextPercentDeadliftClassicB= (EditText)findViewById(R.id.editTextPercentDeadliftClassicB);
        editTextProgressionDeadliftClassicB= (EditText)findViewById(R.id.editTextProgressionDeadliftClassicB);
        editTextSeriesBenchPressB= (EditText)findViewById(R.id.editTextSeriesBenchPressB);
        editTextRepsBenchPressB= (EditText)findViewById(R.id.editTextRepsBenchPressB);
        editTextPercentBenchPressB= (EditText)findViewById(R.id.editTextPercentBenchPressB);
        editTextProgressionBenchPressB= (EditText)findViewById(R.id.editTextProgressionBenchPressB);
        editTextSeriesNarrowBenchPressB= (EditText)findViewById(R.id. editTextSeriesNarrowBenchPressB);
        editTextRepsNarrowBenchPressB= (EditText)findViewById(R.id.editTextRepsNarrowBenchPressB);
        editTextPercentNarrowBenchPressB= (EditText)findViewById(R.id.editTextPercentNarrowBenchPressB);
        editTextProgressionNarrowBenchPressB= (EditText)findViewById(R.id.editTextProgressionNarrowBenchPressB);
        editTextSeriesOhpB= (EditText)findViewById(R.id.editTextSeriesOhpB);
        editTextRepsOhpB= (EditText)findViewById(R.id.editTextRepsOhpB);
        editTextPercentOhpB= (EditText)findViewById(R.id.editTextPercentOhpB);
        editTextProgressionOhpB= (EditText)findViewById(R.id. editTextProgressionOhpB);
        editTextSeriesRowingB= (EditText)findViewById(R.id.editTextSeriesRowingB);
        editTextRepsRowingB= (EditText)findViewById(R.id.editTextRepsRowingB);
        editTextPercentRowingB= (EditText)findViewById(R.id.editTextPercentRowingB);
        editTextProgressionRowingB= (EditText)findViewById(R.id.editTextProgressionRowingB);
        editTextSeriesPullingUpNarrowB= (EditText)findViewById(R.id.editTextSeriesPullingUpNarrowB);
        editTextRepsPullingUpNarrowB= (EditText)findViewById(R.id.editTextRepsPullingUpNarrowB);
        editTextPercentPullingUpNarrowB= (EditText)findViewById(R.id.editTextPercentPullingUpNarrowB);
        editTextProgressionPullingUpNarrowB= (EditText)findViewById(R.id.editTextProgressionPullingUpNarrowB);
        editTextSeriesRisingSidewaysB = (EditText)findViewById(R.id.editTextSeriesRisingSidewaysB);
        editTextRepsRisingSidewaysB = (EditText)findViewById(R.id.editTextRepsRisingSidewaysB);
        editTextPercentRisingSidewaysB = (EditText)findViewById(R.id.editTextPercentRisingSidewaysB);
        editTextProgressionRisingSidewaysB = (EditText)findViewById(R.id.editTextProgressionRisingSidewaysB);
        editTextSeriesBicepsB= (EditText)findViewById(R.id.editTextSeriesBicepsB);
        editTextRepsBicepsB= (EditText)findViewById(R.id. editTextRepsBicepsB);
        editTextPercentBicepsB= (EditText)findViewById(R.id. editTextPercentBicepsB);
        editTextProgressionBicepsB= (EditText)findViewById(R.id.editTextProgressionBicepsB);
        editTextSeriesTricepsB= (EditText)findViewById(R.id.editTextSeriesTricepsB);
        editTextRepsTricepsB= (EditText)findViewById(R.id.editTextRepsTricepsB);
        editTextPercentTricepsB= (EditText)findViewById(R.id.editTextPercentTricepsB);
        editTextProgressionTricepsB= (EditText)findViewById(R.id.editTextProgressionTricepsB);
        editTextSeriesAllahsB= (EditText)findViewById(R.id.editTextSeriesAllahsB);
        editTextRepsAllahsB= (EditText)findViewById(R.id.editTextRepsAllahsB);
        editTextPercentAllahsB= (EditText)findViewById(R.id. editTextPercentAllahsB);
        editTextProgressionAllahsB= (EditText)findViewById(R.id.editTextProgressionAllahsB);
        editTextSeriesPlankB= (EditText)findViewById(R.id.editTextSeriesPlankB);
        editTextSecondsPlankB= (EditText)findViewById(R.id.editTextSecondsPlankB);
        editTextProgressionPlankB= (EditText)findViewById(R.id.editTextProgressionPlankB);
        editTextSeriesCalvesB= (EditText)findViewById(R.id.editTextSeriesCalvesB);
        editTextRepsCalvesB= (EditText)findViewById(R.id.editTextRepsCalvesB);
        editTextPercentCalvesB= (EditText)findViewById(R.id.editTextPercentCalvesB);
        editTextProgressionCalvesB= (EditText)findViewById(R.id.editTextProgressionCalvesB);
        editTextSeriesYRaiseB= (EditText)findViewById(R.id.editTextSeriesYRaiseB);
        editTextRepsYRaiseB= (EditText)findViewById(R.id.editTextRepsYRaiseB);
        editTextPercentYRaiseB= (EditText)findViewById(R.id.editTextPercentYRaiseB);
        editTextProgressionYRaiseB= (EditText)findViewById(R.id.editTextProgressionYRaiseB);
        editTextSeriesFacepullB= (EditText)findViewById(R.id.editTextSeriesFacepullB);
        editTextRepsFacepullB= (EditText)findViewById(R.id.editTextRepsFacepullB);
        editTextPercentFacepullB= (EditText)findViewById(R.id.editTextPercentFacepullB);
        editTextProgressionFacepullB= (EditText)findViewById(R.id.editTextProgressionFacepullB);


        editTextSeriesSquatC = (EditText)findViewById(R.id.editTextSeriesSquatC);
        editTextRepsSquatC = (EditText)findViewById(R.id.editTextRepsSquatC);
        editTextPercentSquatC= (EditText)findViewById(R.id.editTextPercentSquatC);
        editTextProgressionSquatC = (EditText)findViewById(R.id.editTextProgressionSquatC);
        editTextSeriesDeadliftClassicC= (EditText)findViewById(R.id.editTextSeriesDeadliftClassicC);
        editTextRepsDeadliftClassicC= (EditText)findViewById(R.id.editTextRepsDeadliftClassicC);
        editTextPercentDeadliftClassicC= (EditText)findViewById(R.id.editTextPercentDeadliftClassicC);
        editTextProgressionDeadliftClassicC= (EditText)findViewById(R.id.editTextProgressionDeadliftClassicC);
        editTextSeriesBenchPressC= (EditText)findViewById(R.id.editTextSeriesBenchPressC);
        editTextRepsBenchPressC= (EditText)findViewById(R.id.editTextRepsBenchPressC);
        editTextPercentBenchPressC= (EditText)findViewById(R.id.editTextPercentBenchPressC);
        editTextProgressionBenchPressC= (EditText)findViewById(R.id.editTextProgressionBenchPressC);
        editTextSeriesNarrowBenchPressC= (EditText)findViewById(R.id. editTextSeriesNarrowBenchPressC);
        editTextRepsNarrowBenchPressC= (EditText)findViewById(R.id.editTextRepsNarrowBenchPressC);
        editTextPercentNarrowBenchPressC= (EditText)findViewById(R.id.editTextPercentNarrowBenchPressC);
        editTextProgressionNarrowBenchPressC= (EditText)findViewById(R.id.editTextProgressionNarrowBenchPressC);
        editTextSeriesOhpC= (EditText)findViewById(R.id.editTextSeriesOhpC);
        editTextRepsOhpC= (EditText)findViewById(R.id.editTextRepsOhpC);
        editTextPercentOhpC= (EditText)findViewById(R.id.editTextPercentOhpC);
        editTextProgressionOhpC= (EditText)findViewById(R.id. editTextProgressionOhpC);
        editTextSeriesRowingC= (EditText)findViewById(R.id.editTextSeriesRowingC);
        editTextRepsRowingC= (EditText)findViewById(R.id.editTextRepsRowingC);
        editTextPercentRowingC= (EditText)findViewById(R.id.editTextPercentRowingC);
        editTextProgressionRowingC= (EditText)findViewById(R.id.editTextProgressionRowingC);
        editTextSeriesPullingUpNarrowC= (EditText)findViewById(R.id.editTextSeriesPullingUpNarrowC);
        editTextRepsPullingUpNarrowC= (EditText)findViewById(R.id.editTextRepsPullingUpNarrowC);
        editTextPercentPullingUpNarrowC= (EditText)findViewById(R.id.editTextPercentPullingUpNarrowC);
        editTextProgressionPullingUpNarrowC= (EditText)findViewById(R.id.editTextProgressionPullingUpNarrowC);
        editTextSeriesRisingSidewaysC = (EditText)findViewById(R.id.editTextSeriesRisingSidewaysC);
        editTextRepsRisingSidewaysC = (EditText)findViewById(R.id.editTextRepsRisingSidewaysC);
        editTextPercentRisingSidewaysC = (EditText)findViewById(R.id.editTextPercentRisingSidewaysC);
        editTextProgressionRisingSidewaysC = (EditText)findViewById(R.id.editTextProgressionRisingSidewaysC);
        editTextSeriesBicepsC = (EditText)findViewById(R.id.editTextSeriesBicepsC);
        editTextRepsBicepsC = (EditText)findViewById(R.id. editTextRepsBicepsC);
        editTextPercentBicepsC = (EditText)findViewById(R.id. editTextPercentBicepsC);
        editTextProgressionBicepsC = (EditText)findViewById(R.id.editTextProgressionBicepsC);
        editTextSeriesTricepsC = (EditText)findViewById(R.id.editTextSeriesTricepsC);
        editTextRepsTricepsC = (EditText)findViewById(R.id.editTextRepsTricepsC);
        editTextPercentTricepsC = (EditText)findViewById(R.id.editTextPercentTricepsC);
        editTextProgressionTricepsC = (EditText)findViewById(R.id.editTextProgressionTricepsC);
        editTextSeriesAllahsC = (EditText)findViewById(R.id.editTextSeriesAllahsC);
        editTextRepsAllahsC = (EditText)findViewById(R.id.editTextRepsAllahsC);
        editTextPercentAllahsC = (EditText)findViewById(R.id. editTextPercentAllahsC);
        editTextProgressionAllahsC = (EditText)findViewById(R.id.editTextProgressionAllahsC);
        editTextSeriesPlankC = (EditText)findViewById(R.id.editTextSeriesPlankC);
        editTextSecondsPlankC = (EditText)findViewById(R.id.editTextSecondsPlankC);
        editTextProgressionPlankC = (EditText)findViewById(R.id.editTextProgressionPlankC);
        editTextSeriesCalvesC = (EditText)findViewById(R.id.editTextSeriesCalvesC);
        editTextRepsCalvesC = (EditText)findViewById(R.id.editTextRepsCalvesC);
        editTextPercentCalvesC = (EditText)findViewById(R.id.editTextPercentCalvesC);
        editTextProgressionCalvesC = (EditText)findViewById(R.id.editTextProgressionCalvesC);
        editTextSeriesYRaiseC = (EditText)findViewById(R.id.editTextSeriesYRaiseC);
        editTextRepsYRaiseC = (EditText)findViewById(R.id.editTextRepsYRaiseC);
        editTextPercentYRaiseC = (EditText)findViewById(R.id.editTextPercentYRaiseC);
        editTextProgressionYRaiseC = (EditText)findViewById(R.id.editTextProgressionYRaiseC);
        editTextSeriesFacepullC = (EditText)findViewById(R.id.editTextSeriesFacepullC);
        editTextRepsFacepullC = (EditText)findViewById(R.id.editTextRepsFacepullC);
        editTextPercentFacepullC = (EditText)findViewById(R.id.editTextPercentFacepullC);
        editTextProgressionFacepullC = (EditText)findViewById(R.id.editTextProgressionFacepullC);

        editTextSeriesSquatD = (EditText)findViewById(R.id.editTextSeriesSquatD);
        editTextRepsSquatD = (EditText)findViewById(R.id.editTextRepsSquatD);
        editTextPercentSquatD = (EditText)findViewById(R.id.editTextPercentSquatD);
        editTextProgressionSquatD = (EditText)findViewById(R.id.editTextProgressionSquatD);
        editTextSeriesDeadliftClassicD = (EditText)findViewById(R.id.editTextSeriesDeadliftClassicD);
        editTextRepsDeadliftClassicD = (EditText)findViewById(R.id.editTextRepsDeadliftClassicD);
        editTextPercentDeadliftClassicD = (EditText)findViewById(R.id.editTextPercentDeadliftClassicD);
        editTextProgressionDeadliftClassicD = (EditText)findViewById(R.id.editTextProgressionDeadliftClassicD);
        editTextSeriesBenchPressD = (EditText)findViewById(R.id.editTextSeriesBenchPressD);
        editTextRepsBenchPressD = (EditText)findViewById(R.id.editTextRepsBenchPressD);
        editTextPercentBenchPressD = (EditText)findViewById(R.id.editTextPercentBenchPressD);
        editTextProgressionBenchPressD = (EditText)findViewById(R.id.editTextProgressionBenchPressD);
        editTextSeriesNarrowBenchPressD = (EditText)findViewById(R.id. editTextSeriesNarrowBenchPressD);
        editTextRepsNarrowBenchPressD = (EditText)findViewById(R.id.editTextRepsNarrowBenchPressD);
        editTextPercentNarrowBenchPressD = (EditText)findViewById(R.id.editTextPercentNarrowBenchPressD);
        editTextProgressionNarrowBenchPressD = (EditText)findViewById(R.id.editTextProgressionNarrowBenchPressD);
        editTextSeriesOhpD = (EditText)findViewById(R.id.editTextSeriesOhpD);
        editTextRepsOhpD = (EditText)findViewById(R.id.editTextRepsOhpD);
        editTextPercentOhpD = (EditText)findViewById(R.id.editTextPercentOhpD);
        editTextProgressionOhpD = (EditText)findViewById(R.id. editTextProgressionOhpD);
        editTextSeriesRowingD = (EditText)findViewById(R.id.editTextSeriesRowingD);
        editTextRepsRowingD = (EditText)findViewById(R.id.editTextRepsRowingD);
        editTextPercentRowingD = (EditText)findViewById(R.id.editTextPercentRowingD);
        editTextProgressionRowingD = (EditText)findViewById(R.id.editTextProgressionRowingD);
        editTextSeriesPullingUpNarrowD = (EditText)findViewById(R.id.editTextSeriesPullingUpNarrowD);
        editTextRepsPullingUpNarrowD = (EditText)findViewById(R.id.editTextRepsPullingUpNarrowD);
        editTextPercentPullingUpNarrowD = (EditText)findViewById(R.id.editTextPercentPullingUpNarrowD);
        editTextProgressionPullingUpNarrowD = (EditText)findViewById(R.id.editTextProgressionPullingUpNarrowD);
        editTextSeriesRisingSidewaysD = (EditText)findViewById(R.id.editTextSeriesRisingSidewaysD);
        editTextRepsRisingSidewaysD = (EditText)findViewById(R.id.editTextRepsRisingSidewaysD);
        editTextPercentRisingSidewaysD = (EditText)findViewById(R.id.editTextPercentRisingSidewaysD);
        editTextProgressionRisingSidewaysD = (EditText)findViewById(R.id.editTextProgressionRisingSidewaysD);
        editTextSeriesBicepsD = (EditText)findViewById(R.id.editTextSeriesBicepsD);
        editTextRepsBicepsD = (EditText)findViewById(R.id. editTextRepsBicepsD);
        editTextPercentBicepsD= (EditText)findViewById(R.id. editTextPercentBicepsD);
        editTextProgressionBicepsD= (EditText)findViewById(R.id.editTextProgressionBicepsD);
        editTextSeriesTricepsD= (EditText)findViewById(R.id.editTextSeriesTricepsD);
        editTextRepsTricepsD= (EditText)findViewById(R.id.editTextRepsTricepsD);
        editTextPercentTricepsD= (EditText)findViewById(R.id.editTextPercentTricepsD);
        editTextProgressionTricepsD= (EditText)findViewById(R.id.editTextProgressionTricepsD);
        editTextSeriesAllahsD= (EditText)findViewById(R.id.editTextSeriesAllahsD);
        editTextRepsAllahsD= (EditText)findViewById(R.id.editTextRepsAllahsD);
        editTextPercentAllahsD= (EditText)findViewById(R.id. editTextPercentAllahsD);
        editTextProgressionAllahsD= (EditText)findViewById(R.id.editTextProgressionAllahsD);
        editTextSeriesPlankD= (EditText)findViewById(R.id.editTextSeriesPlankD);
        editTextSecondsPlankD= (EditText)findViewById(R.id.editTextSecondsPlankD);
        editTextProgressionPlankD= (EditText)findViewById(R.id.editTextProgressionPlankD);
        editTextSeriesCalvesD= (EditText)findViewById(R.id.editTextSeriesCalvesD);
        editTextRepsCalvesD= (EditText)findViewById(R.id.editTextRepsCalvesD);
        editTextPercentCalvesD= (EditText)findViewById(R.id.editTextPercentCalvesD);
        editTextProgressionCalvesD= (EditText)findViewById(R.id.editTextProgressionCalvesD);
        editTextSeriesYRaiseD= (EditText)findViewById(R.id.editTextSeriesYRaiseD);
        editTextRepsYRaiseD= (EditText)findViewById(R.id.editTextRepsYRaiseD);
        editTextPercentYRaiseD= (EditText)findViewById(R.id.editTextPercentYRaiseD);
        editTextProgressionYRaiseD= (EditText)findViewById(R.id.editTextProgressionYRaiseD);
        editTextSeriesFacepullD= (EditText)findViewById(R.id.editTextSeriesFacepullD);
        editTextRepsFacepullD= (EditText)findViewById(R.id.editTextRepsFacepullD);
        editTextPercentFacepullD= (EditText)findViewById(R.id.editTextPercentFacepullD);
        editTextProgressionFacepullD= (EditText)findViewById(R.id.editTextProgressionFacepullD);

        prefs = getSharedPreferences("LastClick", Context.MODE_PRIVATE);
        editor= prefs.edit();
        LastClick = prefs.getInt("LastClick",0);
        final int LastFbwWorkoutState= prefs.getInt("LastFbwWorkoutState",0);
        LastCustomWorkoutState= prefs.getInt("LastCustomWorkoutState",0);

        getCustomWorkoutPrefs();


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

                customWorkoutPrefs();

            }
        });

        buttonNextTrainingConfigurationB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutTrainingConfigurationB.setVisibility(View.GONE);
                linearLayoutTrainingConfigurationC.setVisibility(View.VISIBLE);
                customWorkoutPrefs();

            }
        });

        buttonNextTrainingConfigurationC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayoutTrainingConfigurationC.setVisibility(View.GONE);
                linearLayoutTrainingConfigurationD.setVisibility(View.VISIBLE);
                customWorkoutPrefs();

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
                editor.putInt("LastCustomWorkoutState",0).commit();
                LastCustomWorkoutState = prefs.getInt("LastCustomWorkoutState",0);
                customWorkoutPrefs();
                CustomWorkout();
                calcWeightConfiguration();
            }
        });

        buttonFinishWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LastClick==1){
                    FbwWorkoutB();
                    editor.putInt("LastFbwWorkoutState",1).commit();
                }
               else if (LastClick==2&&(checkBoxSquatsConfB.isChecked()||checkBoxDeadliftClassicConfB.isChecked()||checkBoxOhpConfB.isChecked()||checkBoxBenchPressConfB.isChecked()||
                        checkBoxNarrowBenchPressConfB.isChecked()||checkBoxRisingSidewaysConfB.isChecked()||checkBoxPullingUpNarrowConfB.isChecked()||checkBoxRisingSidewaysConfB.isChecked()||
                        checkBoxBicepsConfB.isChecked()||checkBoxTricepsConfB.isChecked()||checkBoxAllahsConfB.isChecked()||checkBoxPlankConfB.isChecked()|| checkBoxCalvesConfB.isChecked()||
                        checkBoxYRaiseConfB.isChecked()||checkBoxFacepullConfB.isChecked())){
                    CustomWorkoutB();
                    editor.putInt("LastCustomWorkoutState",1).commit();
                }
                else {
                    CustomWorkout();
                    editor.putInt("LastCustomWorkoutState",0).commit();
                }

                LastCustomWorkoutState= prefs.getInt("LastCustomWorkoutState",0);
                calcWeightConfiguration();
                unchekedCheckBoxes();



            }
        });

        buttonFinishWorkoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (LastClick==1){
                    FbwWorkoutA();
                    editor.putInt("LastFbwWorkoutState",0).apply();
                }
                else if (LastClick==2&&(checkBoxSquatsConfC.isChecked()||checkBoxDeadliftClassicConfC.isChecked()||checkBoxOhpConfC.isChecked()||checkBoxBenchPressConfC.isChecked()||
                        checkBoxNarrowBenchPressConfC.isChecked()||checkBoxRisingSidewaysConfC.isChecked()||checkBoxPullingUpNarrowConfC.isChecked()||checkBoxRisingSidewaysConfC.isChecked()||
                        checkBoxBicepsConfC.isChecked()||checkBoxTricepsConfC.isChecked()||checkBoxAllahsConfC.isChecked()||checkBoxPlankConfC.isChecked()|| checkBoxCalvesConfC.isChecked()||
                        checkBoxYRaiseConfC.isChecked()||checkBoxFacepullConfC.isChecked())){
                    CustomWorkoutC();
                    editor.putInt("LastCustomWorkoutState",2).commit();
                }
                else {
                    CustomWorkout();
                    editor.putInt("LastCustomWorkoutState",0).commit();
                }
                LastCustomWorkoutState= prefs.getInt("LastCustomWorkoutState",0);
                calcWeightConfiguration();
                unchekedCheckBoxes();


            }
        });

        buttonFinishWorkoutC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (LastClick==2&&(checkBoxSquatsConfD.isChecked()||checkBoxDeadliftClassicConfD.isChecked()||checkBoxOhpConfD.isChecked()||checkBoxBenchPressConfD.isChecked()||
                        checkBoxNarrowBenchPressConfD.isChecked()||checkBoxRisingSidewaysConfD.isChecked()||checkBoxPullingUpNarrowConfD.isChecked()||checkBoxRisingSidewaysConfD.isChecked()||
                        checkBoxBicepsConfD.isChecked()||checkBoxTricepsConfD.isChecked()||checkBoxAllahsConfD.isChecked()||checkBoxPlankConfD.isChecked()|| checkBoxCalvesConfD.isChecked()||
                        checkBoxYRaiseConfD.isChecked()||checkBoxFacepullConfD.isChecked())){
                    CustomWorkoutD();
                    editor.putInt("LastCustomWorkoutState",3).commit();
                }
                else {
                    CustomWorkout();
                    editor.putInt("LastCustomWorkoutState",0).commit();
                }
                LastCustomWorkoutState= prefs.getInt("LastCustomWorkoutState",0);
                calcWeightConfiguration();
                unchekedCheckBoxes();

            }
        });

        buttonFinishWorkoutD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("LastCustomWorkoutState",0).commit();
                LastCustomWorkoutState= prefs.getInt("LastCustomWorkoutState",0);
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
                        LastClick = prefs.getInt("LastClick",0);

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
                        if (LastFbwWorkoutState==0){

                            FbwWorkoutA();
                            //linearLayoutTrainingB.setVisibility(View.GONE);
                            //linearLayoutTrainingA.setVisibility(View.VISIBLE);
                        }

                        else if (LastFbwWorkoutState==1){
                            FbwWorkoutB();
                            //linearLayoutTrainingB.setVisibility(View.VISIBLE);
                            //linearLayoutTrainingA.setVisibility(View.GONE);
                            }

                        editor.putInt("LastClick",1);
                        editor.commit();
                        LastClick = prefs.getInt("LastClick",0);
                        //xd=1;
                        //editor.putInt("LastClick",1).apply();
                        //StateOne();
                       // Toast.makeText(getApplicationContext()," TEST "+LastClick,Toast.LENGTH_LONG).show();
                        break;

                    case 2:
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
                        LastClick = prefs.getInt("LastClick",0);
                        if (LastCustomWorkoutState==0){
                            CustomWorkout();
                        }
                        else if (LastCustomWorkoutState==1){
                            CustomWorkoutB();
                        }
                        else if (LastCustomWorkoutState==2){
                            CustomWorkoutC();
                        }
                        else if (LastCustomWorkoutState==3){
                            CustomWorkoutD();
                        }
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

                 if (editTextSquat.getText().length() != 0 && checkBoxSquats.isChecked() && LastClick==1){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = Math.round((n1*0.80)+2);
                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady 5 x 5 x "+nSeries+"kg");
                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextSquat.getText().length() != 0 && !checkBoxSquats.isChecked() && LastClick==1){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = Math.round(n1*0.80);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady 5 x 5 x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextSquat.getText().length() == 0 && LastClick==1) {
                     checkBoxSquats.setText("brak konfiguracji obciążenia dla Przysiadów");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

//własny trening wersja A przysiady
                 if (editTextSquat.getText().length() != 0 && checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 0){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquat/100)+ progressionSquat, 3, BigDecimal.ROUND_HALF_UP);
                     double nMax = Math.round((nSeries/percentSquat)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquat +" x "+ repsSquat +" x "+nSeries+"kg");
                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextSquat.getText().length() != 0 && !checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 0){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquat/100), 3, BigDecimal.ROUND_HALF_UP);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquat +" x "+ repsSquat +" x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextSquat.getText().length() == 0 && LastClick==2 && LastCustomWorkoutState == 0) {
                     checkBoxSquats.setText("brak konfiguracji obciążenia dla Przysiadów");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

//własny trening wersja B przysiady
                 if (editTextSquat.getText().length() != 0 && checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 1){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquatB/100)+ progressionSquatB, 3, BigDecimal.ROUND_HALF_UP);
                     double nMax = Math.round((nSeries/percentSquatB)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquatB +" x "+ repsSquatB +" x "+nSeries+"kg");
                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextSquat.getText().length() != 0 && !checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 1){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquatB/100), 3, BigDecimal.ROUND_HALF_UP);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquatB +" x "+ repsSquatB +" x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextSquat.getText().length() == 0 && LastClick==2 && LastCustomWorkoutState == 1) {
                     checkBoxSquats.setText("brak konfiguracji obciążenia dla Przysiadów");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 //własny trening wersja C przysiady
                 if (editTextSquat.getText().length() != 0 && checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 2){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquatC/100)+ progressionSquatC, 3, BigDecimal.ROUND_HALF_UP);
                     double nMax = Math.round((nSeries/percentSquatC)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquatC +" x "+ repsSquatC +" x "+nSeries+"kg");
                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextSquat.getText().length() != 0 && !checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 2){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquatC/100), 3, BigDecimal.ROUND_HALF_UP);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquatC +" x "+ repsSquatC +" x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextSquat.getText().length() == 0 && LastClick==2 && LastCustomWorkoutState == 2) {
                     checkBoxSquats.setText("brak konfiguracji obciążenia dla Przysiadów");
                     // Toast.makeText(getApplicationContext(),"TEST2",Toast.LENGTH_LONG).show();
                 }

                 //własny trening wersja D przysiady
                 if (editTextSquat.getText().length() != 0 && checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 3){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquatD/100)+ progressionSquatD, 3, BigDecimal.ROUND_HALF_UP);
                     double nMax = Math.round((nSeries/percentSquatD)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquatD +" x "+ repsSquatD +" x "+nSeries+"kg");
                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if (editTextSquat.getText().length() != 0 && !checkBoxSquats.isChecked() && LastClick==2 && LastCustomWorkoutState == 3){
                     double n1 = Double.parseDouble(editTextSquat.getText().toString());
                     double nSeries = round((n1*percentSquatD/100), 3, BigDecimal.ROUND_HALF_UP);
//                     double nMax = Math.round((nSeries/80)*100);

                     checkBoxSquats.setText("Przysiady "+ seriesSquatD +" x "+ repsSquatD +" x "+nSeries+"kg");
//                     editTextSquat.setText(""+nMax);
                     // Toast.makeText(getApplicationContext(),nSeries+" TEST "+nMax,Toast.LENGTH_LONG).show();
                 }

                 else if(editTextSquat.getText().length() == 0 && LastClick==2 && LastCustomWorkoutState == 3) {
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




             private void customWorkoutPrefs() {

                 if (editTextSeriesSquat.getText().length() != 0) {
                     seriesSquat = Integer.parseInt(editTextSeriesSquat.getText().toString());
                     editor.putInt("SeriesSquat", seriesSquat);
                     editor.commit();
                 }


                 if (editTextRepsSquat.getText().length() != 0) {
                     repsSquat = Integer.parseInt(editTextRepsSquat.getText().toString());
                     editor.putInt("RepsSquat", repsSquat);
                     editor.commit();
                 }


                 if (editTextPercentSquat.getText().length() != 0) {
                     percentSquat = Integer.parseInt(editTextPercentSquat.getText().toString());
                     editor.putInt("PercentSquat", percentSquat);
                     editor.commit();
                 }

                 if (editTextProgressionSquat.getText().length() != 0) {
                     progressionSquat =  Float.parseFloat(editTextProgressionSquat.getText().toString());
                     editor.putFloat("ProgressionSquat", progressionSquat);
                     editor.commit();
                 }



                 if (editTextSeriesDeadliftClassic.getText().length() != 0) {
                     seriesDeadliftClassic = Integer.parseInt(editTextSeriesDeadliftClassic.getText().toString());
                     editor.putInt("SeriesDeadliftClassic", seriesDeadliftClassic);
                     editor.commit();
                 }


                 if (editTextRepsDeadliftClassic.getText().length() != 0) {
                     repsDeadliftClassic = Integer.parseInt(editTextRepsDeadliftClassic.getText().toString());
                     editor.putInt("RepsDeadliftClassic", repsDeadliftClassic);
                     editor.commit();
                 }


                 if (editTextPercentDeadliftClassic.getText().length() != 0) {
                     percentDeadliftClassic = Integer.parseInt(editTextPercentDeadliftClassic.getText().toString());
                     editor.putInt("PercentDeadliftClassic", percentDeadliftClassic);
                     editor.commit();
                 }

                 if (editTextProgressionDeadliftClassic.getText().length() != 0) {
                     progressionDeadliftClassic =  Float.parseFloat(editTextProgressionDeadliftClassic.getText().toString());
                     editor.putFloat("ProgressionDeadliftClassic", progressionDeadliftClassic);
                     editor.commit();
                 }



                 if (editTextSeriesBenchPress.getText().length() != 0) {
                     seriesBenchPress = Integer.parseInt(editTextSeriesBenchPress.getText().toString());
                     editor.putInt("SeriesBenchPress", seriesBenchPress);
                     editor.commit();
                 }


                 if (editTextRepsBenchPress.getText().length() != 0) {
                     repsBenchPress = Integer.parseInt(editTextRepsBenchPress.getText().toString());
                     editor.putInt("RepsBenchPress", repsBenchPress);
                     editor.commit();
                 }


                 if (editTextPercentBenchPress.getText().length() != 0) {
                     percentBenchPress = Integer.parseInt(editTextPercentBenchPress.getText().toString());
                     editor.putInt("PercentBenchPress", percentBenchPress);
                     editor.commit();
                 }

                 if (editTextProgressionBenchPress.getText().length() != 0) {
                     progressionBenchPress =  Float.parseFloat(editTextProgressionBenchPress.getText().toString());
                     editor.putFloat("ProgressionBenchPress", progressionBenchPress);
                     editor.commit();
                 }


                 if (editTextSeriesNarrowBenchPress.getText().length() != 0) {
                     seriesNarrowBenchPress = Integer.parseInt(editTextSeriesNarrowBenchPress.getText().toString());
                     editor.putInt("SeriesNarrowBenchPress", seriesNarrowBenchPress);
                     editor.commit();
                 }


                 if (editTextRepsNarrowBenchPress.getText().length() != 0) {
                     repsNarrowBenchPress = Integer.parseInt(editTextRepsNarrowBenchPress.getText().toString());
                     editor.putInt("RepsNarrowBenchPress", repsNarrowBenchPress);
                     editor.commit();
                 }


                 if (editTextPercentNarrowBenchPress.getText().length() != 0) {
                     percentNarrowBenchPress = Integer.parseInt(editTextPercentNarrowBenchPress.getText().toString());
                     editor.putInt("PercentNarrowBenchPress", percentNarrowBenchPress);
                     editor.commit();
                 }

                 if (editTextProgressionNarrowBenchPress.getText().length() != 0) {
                     progressionNarrowBenchPress =  Float.parseFloat(editTextProgressionNarrowBenchPress.getText().toString());
                     editor.putFloat("ProgressionNarrowBenchPress", progressionNarrowBenchPress);
                     editor.commit();
                 }


                 if (editTextSeriesOhp.getText().length() != 0) {
                     seriesOhp = Integer.parseInt(editTextSeriesOhp.getText().toString());
                     editor.putInt("SeriesOhp", seriesOhp);
                     editor.commit();
                 }


                 if (editTextRepsOhp.getText().length() != 0) {
                     repsOhp = Integer.parseInt(editTextRepsOhp.getText().toString());
                     editor.putInt("RepsOhp", repsOhp);
                     editor.commit();
                 }


                 if (editTextPercentOhp.getText().length() != 0) {
                     percentOhp = Integer.parseInt(editTextPercentOhp.getText().toString());
                     editor.putInt("PercentOhp", percentOhp);
                     editor.commit();
                 }

                 if (editTextProgressionOhp.getText().length() != 0) {
                     progressionOhp =  Float.parseFloat(editTextProgressionOhp.getText().toString());
                     editor.putFloat("ProgressionOhp", progressionOhp);
                     editor.commit();
                 }

                 if (editTextSeriesRowing.getText().length() != 0) {
                     seriesRowing = Integer.parseInt(editTextSeriesRowing.getText().toString());
                     editor.putInt("SeriesRowing", seriesRowing);
                     editor.commit();
                 }


                 if (editTextRepsRowing.getText().length() != 0) {
                     repsRowing = Integer.parseInt(editTextRepsRowing.getText().toString());
                     editor.putInt("RepsRowing", repsRowing);
                     editor.commit();
                 }


                 if (editTextPercentRowing.getText().length() != 0) {
                     percentRowing = Integer.parseInt(editTextPercentRowing.getText().toString());
                     editor.putInt("PercentRowing", percentRowing);
                     editor.commit();
                 }

                 if (editTextProgressionRowing.getText().length() != 0) {
                     progressionRowing =  Float.parseFloat(editTextProgressionRowing.getText().toString());
                     editor.putFloat("ProgressionRowing", progressionRowing);
                     editor.commit();
                 }


                 if (editTextSeriesPullingUpNarrow.getText().length() != 0) {
                     seriesPullingUpNarrow = Integer.parseInt(editTextSeriesPullingUpNarrow.getText().toString());
                     editor.putInt("SeriesPullingUpNarrow", seriesPullingUpNarrow);
                     editor.commit();
                 }


                 if (editTextRepsPullingUpNarrow.getText().length() != 0) {
                     repsPullingUpNarrow = Integer.parseInt(editTextRepsPullingUpNarrow.getText().toString());
                     editor.putInt("RepsPullingUpNarrow", repsPullingUpNarrow);
                     editor.commit();
                 }


                 if (editTextPercentPullingUpNarrow.getText().length() != 0) {
                     percentPullingUpNarrow = Integer.parseInt(editTextPercentPullingUpNarrow.getText().toString());
                     editor.putInt("PercentPullingUpNarrow", percentPullingUpNarrow);
                     editor.commit();
                 }

                 if (editTextProgressionPullingUpNarrow.getText().length() != 0) {
                     progressionPullingUpNarrow =  Float.parseFloat(editTextProgressionPullingUpNarrow.getText().toString());
                     editor.putFloat("ProgressionPullingUpNarrow", progressionPullingUpNarrow);
                     editor.commit();
                 }


                 if (editTextSeriesRisingSideways.getText().length() != 0) {
                     seriesRisingSideways = Integer.parseInt(editTextSeriesRisingSideways.getText().toString());
                     editor.putInt("SeriesRisingSideways", seriesRisingSideways);
                     editor.commit();
                 }


                 if (editTextRepsRisingSideways.getText().length() != 0) {
                     repsRisingSideways = Integer.parseInt(editTextRepsRisingSideways.getText().toString());
                     editor.putInt("RepsRisingSideways", repsRisingSideways);
                     editor.commit();
                 }


                 if (editTextPercentRisingSideways.getText().length() != 0) {
                     percentRisingSideways = Integer.parseInt(editTextPercentRisingSideways.getText().toString());
                     editor.putInt("PercentRisingSideways", percentRisingSideways);
                     editor.commit();
                 }

                 if (editTextProgressionRisingSideways.getText().length() != 0) {
                     progressionRisingSideways =  Float.parseFloat(editTextProgressionRisingSideways.getText().toString());
                     editor.putFloat("ProgressionRisingSideways", progressionRisingSideways);
                     editor.commit();
                 }

                 if (editTextSeriesBiceps.getText().length() != 0) {
                     seriesBiceps = Integer.parseInt(editTextSeriesBiceps.getText().toString());
                     editor.putInt("SeriesBiceps", seriesBiceps);
                     editor.commit();
                 }


                 if (editTextRepsBiceps.getText().length() != 0) {
                     repsBiceps = Integer.parseInt(editTextRepsBiceps.getText().toString());
                     editor.putInt("RepsBiceps", repsBiceps);
                     editor.commit();
                 }


                 if (editTextPercentBiceps.getText().length() != 0) {
                     percentBiceps = Integer.parseInt(editTextPercentBiceps.getText().toString());
                     editor.putInt("PercentBiceps", percentBiceps);
                     editor.commit();
                 }

                 if (editTextProgressionBiceps.getText().length() != 0) {
                     progressionBiceps =  Float.parseFloat(editTextProgressionBiceps.getText().toString());
                     editor.putFloat("ProgressionBiceps", progressionBiceps);
                     editor.commit();
                 }



                 if (editTextSeriesTriceps.getText().length() != 0) {
                     seriesTriceps = Integer.parseInt(editTextSeriesTriceps.getText().toString());
                     editor.putInt("SeriesTriceps", seriesTriceps);
                     editor.commit();
                 }


                 if (editTextRepsTriceps.getText().length() != 0) {
                     repsTriceps = Integer.parseInt(editTextRepsTriceps.getText().toString());
                     editor.putInt("RepsTriceps", repsTriceps);
                     editor.commit();
                 }


                 if (editTextPercentTriceps.getText().length() != 0) {
                     percentTriceps = Integer.parseInt(editTextPercentTriceps.getText().toString());
                     editor.putInt("PercentTriceps", percentTriceps);
                     editor.commit();
                 }

                 if (editTextProgressionTriceps.getText().length() != 0) {
                     progressionTriceps =  Float.parseFloat(editTextProgressionTriceps.getText().toString());
                     editor.putFloat("ProgressionTriceps", progressionTriceps);
                     editor.commit();
                 }

                 if (editTextSeriesAllahs.getText().length() != 0) {
                     seriesAllahs = Integer.parseInt(editTextSeriesAllahs.getText().toString());
                     editor.putInt("SeriesAllahs", seriesAllahs);
                     editor.commit();
                 }


                 if (editTextRepsAllahs.getText().length() != 0) {
                     repsAllahs = Integer.parseInt(editTextRepsAllahs.getText().toString());
                     editor.putInt("RepsAllahs", repsAllahs);
                     editor.commit();
                 }


                 if (editTextPercentAllahs.getText().length() != 0) {
                     percentAllahs = Integer.parseInt(editTextPercentAllahs.getText().toString());
                     editor.putInt("PercentAllahs", percentAllahs);
                     editor.commit();
                 }

                 if (editTextProgressionAllahs.getText().length() != 0) {
                     progressionAllahs =  Float.parseFloat(editTextProgressionAllahs.getText().toString());
                     editor.putFloat("ProgressionAllahs", progressionAllahs);
                     editor.commit();
                 }


                 if (editTextSeriesPlank.getText().length() != 0) {
                     seriesPlank = Integer.parseInt(editTextSeriesPlank.getText().toString());
                     editor.putInt("SeriesPlank", seriesPlank);
                     editor.commit();
                 }


                 if (editTextSecondsPlank.getText().length() != 0) {
                     secondsPlank = Integer.parseInt(editTextSecondsPlank.getText().toString());
                     editor.putInt("SecondsPlank", secondsPlank);
                     editor.commit();
                 }


                 if (editTextProgressionPlank.getText().length() != 0) {
                     progressionPlank =  Float.parseFloat(editTextProgressionPlank.getText().toString());
                     editor.putFloat("ProgressionPlank", progressionPlank);
                     editor.commit();
                 }


                 if (editTextSeriesCalves.getText().length() != 0) {
                     seriesCalves = Integer.parseInt(editTextSeriesCalves.getText().toString());
                     editor.putInt("SeriesCalves", seriesCalves);
                     editor.commit();
                 }


                 if (editTextRepsCalves.getText().length() != 0) {
                     repsCalves = Integer.parseInt(editTextRepsCalves.getText().toString());
                     editor.putInt("RepsCalves", repsCalves);
                     editor.commit();
                 }

                 if (editTextPercentCalves.getText().length() != 0) {
                     percentCalves = Integer.parseInt(editTextPercentCalves.getText().toString());
                     editor.putInt("PercentCalves", percentCalves);
                     editor.commit();
                 }

                 if (editTextProgressionCalves.getText().length() != 0) {
                     progressionCalves =  Float.parseFloat(editTextProgressionCalves.getText().toString());
                     editor.putFloat("ProgressionCalves", progressionCalves);
                     editor.commit();
                 }


                 if (editTextSeriesYRaise.getText().length() != 0) {
                     seriesYRaise = Integer.parseInt(editTextSeriesYRaise.getText().toString());
                     editor.putInt("SeriesYRaise", seriesYRaise);
                     editor.commit();
                 }


                 if (editTextRepsYRaise.getText().length() != 0) {
                     repsYRaise = Integer.parseInt(editTextRepsYRaise.getText().toString());
                     editor.putInt("RepsYRaise", repsYRaise);
                     editor.commit();
                 }


                 if (editTextPercentYRaise.getText().length() != 0) {
                     percentYRaise = Integer.parseInt(editTextPercentYRaise.getText().toString());
                     editor.putInt("PercentYRaise", percentYRaise);
                     editor.commit();
                 }

                 if (editTextProgressionYRaise.getText().length() != 0) {
                     progressionYRaise =  Float.parseFloat(editTextProgressionYRaise.getText().toString());
                     editor.putFloat("ProgressionYRaise", progressionYRaise);
                     editor.commit();
                 }


                 if (editTextSeriesFacepull.getText().length() != 0) {
                     seriesFacepull = Integer.parseInt(editTextSeriesFacepull.getText().toString());
                     editor.putInt("SeriesFacepull", seriesFacepull);
                     editor.commit();
                 }


                 if (editTextRepsFacepull.getText().length() != 0) {
                     repsFacepull = Integer.parseInt(editTextRepsFacepull.getText().toString());
                     editor.putInt("RepsFacepull", repsFacepull);
                     editor.commit();
                 }


                 if (editTextPercentFacepull.getText().length() != 0) {
                     percentFacepull = Integer.parseInt(editTextPercentFacepull.getText().toString());
                     editor.putInt("PercentFacepull", percentFacepull);
                     editor.commit();
                 }

                 if (editTextProgressionFacepull.getText().length() != 0) {
                     progressionFacepull =  Float.parseFloat(editTextProgressionFacepull.getText().toString());
                     editor.putFloat("ProgressionFacepull", progressionFacepull);
                     editor.commit();
                 }







                 if (editTextSeriesSquatB.getText().length() != 0) {
                     seriesSquatB = Integer.parseInt(editTextSeriesSquatB.getText().toString());
                     editor.putInt("SeriesSquatB", seriesSquatB);
                     editor.commit();
                 }


                 if (editTextRepsSquatB.getText().length() != 0) {
                     repsSquatB = Integer.parseInt(editTextRepsSquatB.getText().toString());
                     editor.putInt("RepsSquatB", repsSquatB);
                     editor.commit();
                 }


                 if (editTextPercentSquatB.getText().length() != 0) {
                     percentSquatB = Integer.parseInt(editTextPercentSquatB.getText().toString());
                     editor.putInt("PercentSquatB", percentSquatB);
                     editor.commit();
                 }

                 if (editTextProgressionSquatB.getText().length() != 0) {
                     progressionSquatB =  Float.parseFloat(editTextProgressionSquatB.getText().toString());
                     editor.putFloat("ProgressionSquatB", progressionSquatB);
                     editor.commit();
                 }



                 if (editTextSeriesDeadliftClassicB.getText().length() != 0) {
                     seriesDeadliftClassicB = Integer.parseInt(editTextSeriesDeadliftClassicB.getText().toString());
                     editor.putInt("SeriesDeadliftClassicB", seriesDeadliftClassicB);
                     editor.commit();
                 }


                 if (editTextRepsDeadliftClassicB.getText().length() != 0) {
                     repsDeadliftClassicB = Integer.parseInt(editTextRepsDeadliftClassicB.getText().toString());
                     editor.putInt("RepsDeadliftClassicB", repsDeadliftClassicB);
                     editor.commit();
                 }


                 if (editTextPercentDeadliftClassicB.getText().length() != 0) {
                     percentDeadliftClassicB = Integer.parseInt(editTextPercentDeadliftClassicB.getText().toString());
                     editor.putInt("PercentDeadliftClassicB", percentDeadliftClassicB);
                     editor.commit();
                 }

                 if (editTextProgressionDeadliftClassicB.getText().length() != 0) {
                     progressionDeadliftClassicB =  Float.parseFloat(editTextProgressionDeadliftClassicB.getText().toString());
                     editor.putFloat("ProgressionDeadliftClassicB", progressionDeadliftClassicB);
                     editor.commit();
                 }



                 if (editTextSeriesBenchPressB.getText().length() != 0) {
                     seriesBenchPressB = Integer.parseInt(editTextSeriesBenchPressB.getText().toString());
                     editor.putInt("SeriesBenchPressB", seriesBenchPressB);
                     editor.commit();
                 }


                 if (editTextRepsBenchPressB.getText().length() != 0) {
                     repsBenchPressB = Integer.parseInt(editTextRepsBenchPressB.getText().toString());
                     editor.putInt("RepsBenchPressB", repsBenchPressB);
                     editor.commit();
                 }


                 if (editTextPercentBenchPressB.getText().length() != 0) {
                     percentBenchPressB = Integer.parseInt(editTextPercentBenchPressB.getText().toString());
                     editor.putInt("PercentBenchPressB", percentBenchPressB);
                     editor.commit();
                 }

                 if (editTextProgressionBenchPressB.getText().length() != 0) {
                     progressionBenchPressB =  Float.parseFloat(editTextProgressionBenchPressB.getText().toString());
                     editor.putFloat("ProgressionBenchPressB", progressionBenchPressB);
                     editor.commit();
                 }


                 if (editTextSeriesNarrowBenchPressB.getText().length() != 0) {
                     seriesNarrowBenchPressB = Integer.parseInt(editTextSeriesNarrowBenchPressB.getText().toString());
                     editor.putInt("SeriesNarrowBenchPressB", seriesNarrowBenchPressB);
                     editor.commit();
                 }


                 if (editTextRepsNarrowBenchPressB.getText().length() != 0) {
                     repsNarrowBenchPressB = Integer.parseInt(editTextRepsNarrowBenchPressB.getText().toString());
                     editor.putInt("RepsNarrowBenchPressB", repsNarrowBenchPressB);
                     editor.commit();
                 }


                 if (editTextPercentNarrowBenchPressB.getText().length() != 0) {
                     percentNarrowBenchPressB = Integer.parseInt(editTextPercentNarrowBenchPressB.getText().toString());
                     editor.putInt("PercentNarrowBenchPressB", percentNarrowBenchPressB);
                     editor.commit();
                 }

                 if (editTextProgressionNarrowBenchPressB.getText().length() != 0) {
                     progressionNarrowBenchPressB =  Float.parseFloat(editTextProgressionNarrowBenchPressB.getText().toString());
                     editor.putFloat("ProgressionNarrowBenchPressB", progressionNarrowBenchPressB);
                     editor.commit();
                 }


                 if (editTextSeriesOhpB.getText().length() != 0) {
                     seriesOhpB = Integer.parseInt(editTextSeriesOhpB.getText().toString());
                     editor.putInt("SeriesOhpB", seriesOhpB);
                     editor.commit();
                 }


                 if (editTextRepsOhpB.getText().length() != 0) {
                     repsOhpB = Integer.parseInt(editTextRepsOhpB.getText().toString());
                     editor.putInt("RepsOhpB", repsOhpB);
                     editor.commit();
                 }


                 if (editTextPercentOhpB.getText().length() != 0) {
                     percentOhpB = Integer.parseInt(editTextPercentOhpB.getText().toString());
                     editor.putInt("PercentOhpB", percentOhpB);
                     editor.commit();
                 }

                 if (editTextProgressionOhpB.getText().length() != 0) {
                     progressionOhpB =  Float.parseFloat(editTextProgressionOhpB.getText().toString());
                     editor.putFloat("ProgressionOhpB", progressionOhpB);
                     editor.commit();
                 }

                 if (editTextSeriesRowingB.getText().length() != 0) {
                     seriesRowingB = Integer.parseInt(editTextSeriesRowingB.getText().toString());
                     editor.putInt("SeriesRowingB", seriesRowingB);
                     editor.commit();
                 }


                 if (editTextRepsRowingB.getText().length() != 0) {
                     repsRowingB = Integer.parseInt(editTextRepsRowingB.getText().toString());
                     editor.putInt("RepsRowingB", repsRowingB);
                     editor.commit();
                 }


                 if (editTextPercentRowingB.getText().length() != 0) {
                     percentRowingB = Integer.parseInt(editTextPercentRowingB.getText().toString());
                     editor.putInt("PercentRowingB", percentRowingB);
                     editor.commit();
                 }

                 if (editTextProgressionRowingB.getText().length() != 0) {
                     progressionRowingB =  Float.parseFloat(editTextProgressionRowingB.getText().toString());
                     editor.putFloat("ProgressionRowingB", progressionRowingB);
                     editor.commit();
                 }


                 if (editTextSeriesPullingUpNarrowB.getText().length() != 0) {
                     seriesPullingUpNarrowB = Integer.parseInt(editTextSeriesPullingUpNarrowB.getText().toString());
                     editor.putInt("SeriesPullingUpNarrowB", seriesPullingUpNarrowB);
                     editor.commit();
                 }


                 if (editTextRepsPullingUpNarrowB.getText().length() != 0) {
                     repsPullingUpNarrowB = Integer.parseInt(editTextRepsPullingUpNarrowB.getText().toString());
                     editor.putInt("RepsPullingUpNarrowB", repsPullingUpNarrowB);
                     editor.commit();
                 }


                 if (editTextPercentPullingUpNarrowB.getText().length() != 0) {
                     percentPullingUpNarrowB = Integer.parseInt(editTextPercentPullingUpNarrowB.getText().toString());
                     editor.putInt("PercentPullingUpNarrowB", percentPullingUpNarrowB);
                     editor.commit();
                 }

                 if (editTextProgressionPullingUpNarrowB.getText().length() != 0) {
                     progressionPullingUpNarrowB =  Float.parseFloat(editTextProgressionPullingUpNarrowB.getText().toString());
                     editor.putFloat("ProgressionPullingUpNarrowB", progressionPullingUpNarrowB);
                     editor.commit();
                 }


                 if (editTextSeriesRisingSidewaysB.getText().length() != 0) {
                     seriesRisingSidewaysB = Integer.parseInt(editTextSeriesRisingSidewaysB.getText().toString());
                     editor.putInt("SeriesRisingSidewaysB", seriesRisingSidewaysB);
                     editor.commit();
                 }


                 if (editTextRepsRisingSidewaysB.getText().length() != 0) {
                     repsRisingSidewaysB = Integer.parseInt(editTextRepsRisingSidewaysB.getText().toString());
                     editor.putInt("RepsRisingSidewaysB", repsRisingSidewaysB);
                     editor.commit();
                 }


                 if (editTextPercentRisingSidewaysB.getText().length() != 0) {
                     percentRisingSidewaysB = Integer.parseInt(editTextPercentRisingSidewaysB.getText().toString());
                     editor.putInt("PercentRisingSidewaysB", percentRisingSidewaysB);
                     editor.commit();
                 }

                 if (editTextProgressionRisingSidewaysB.getText().length() != 0) {
                     progressionRisingSidewaysB =  Float.parseFloat(editTextProgressionRisingSidewaysB.getText().toString());
                     editor.putFloat("ProgressionRisingSidewaysB", progressionRisingSidewaysB);
                     editor.commit();
                 }

                 if (editTextSeriesBicepsB.getText().length() != 0) {
                     seriesBicepsB = Integer.parseInt(editTextSeriesBicepsB.getText().toString());
                     editor.putInt("SeriesBicepsB", seriesBicepsB);
                     editor.commit();
                 }


                 if (editTextRepsBicepsB.getText().length() != 0) {
                     repsBicepsB = Integer.parseInt(editTextRepsBicepsB.getText().toString());
                     editor.putInt("RepsBicepsB", repsBicepsB);
                     editor.commit();
                 }


                 if (editTextPercentBicepsB.getText().length() != 0) {
                     percentBicepsB = Integer.parseInt(editTextPercentBicepsB.getText().toString());
                     editor.putInt("PercentBicepsB", percentBicepsB);
                     editor.commit();
                 }

                 if (editTextProgressionBicepsB.getText().length() != 0) {
                     progressionBicepsB =  Float.parseFloat(editTextProgressionBicepsB.getText().toString());
                     editor.putFloat("ProgressionBicepsB", progressionBicepsB);
                     editor.commit();
                 }



                 if (editTextSeriesTricepsB.getText().length() != 0) {
                     seriesTricepsB = Integer.parseInt(editTextSeriesTricepsB.getText().toString());
                     editor.putInt("SeriesTricepsB", seriesTricepsB);
                     editor.commit();
                 }


                 if (editTextRepsTricepsB.getText().length() != 0) {
                     repsTricepsB = Integer.parseInt(editTextRepsTricepsB.getText().toString());
                     editor.putInt("RepsTricepsB", repsTricepsB);
                     editor.commit();
                 }


                 if (editTextPercentTricepsB.getText().length() != 0) {
                     percentTricepsB = Integer.parseInt(editTextPercentTricepsB.getText().toString());
                     editor.putInt("PercentTricepsB", percentTricepsB);
                     editor.commit();
                 }

                 if (editTextProgressionTricepsB.getText().length() != 0) {
                     progressionTricepsB =  Float.parseFloat(editTextProgressionTricepsB.getText().toString());
                     editor.putFloat("ProgressionTricepsB", progressionTricepsB);
                     editor.commit();
                 }

                 if (editTextSeriesAllahsB.getText().length() != 0) {
                     seriesAllahsB = Integer.parseInt(editTextSeriesAllahsB.getText().toString());
                     editor.putInt("SeriesAllahsB", seriesAllahsB);
                     editor.commit();
                 }


                 if (editTextRepsAllahsB.getText().length() != 0) {
                     repsAllahsB = Integer.parseInt(editTextRepsAllahsB.getText().toString());
                     editor.putInt("RepsAllahsB", repsAllahsB);
                     editor.commit();
                 }


                 if (editTextPercentAllahsB.getText().length() != 0) {
                     percentAllahsB = Integer.parseInt(editTextPercentAllahsB.getText().toString());
                     editor.putInt("PercentAllahsB", percentAllahsB);
                     editor.commit();
                 }

                 if (editTextProgressionAllahsB.getText().length() != 0) {
                     progressionAllahsB =  Float.parseFloat(editTextProgressionAllahsB.getText().toString());
                     editor.putFloat("ProgressionAllahsB", progressionAllahsB);
                     editor.commit();
                 }


                 if (editTextSeriesPlankB.getText().length() != 0) {
                     seriesPlankB = Integer.parseInt(editTextSeriesPlankB.getText().toString());
                     editor.putInt("SeriesPlankB", seriesPlankB);
                     editor.commit();
                 }


                 if (editTextSecondsPlankB.getText().length() != 0) {
                     secondsPlankB = Integer.parseInt(editTextSecondsPlankB.getText().toString());
                     editor.putInt("SecondsPlankB", secondsPlankB);
                     editor.commit();
                 }


                 if (editTextProgressionPlankB.getText().length() != 0) {
                     progressionPlankB =  Float.parseFloat(editTextProgressionPlankB.getText().toString());
                     editor.putFloat("ProgressionPlankB", progressionPlankB);
                     editor.commit();
                 }


                 if (editTextSeriesCalvesB.getText().length() != 0) {
                     seriesCalvesB = Integer.parseInt(editTextSeriesCalvesB.getText().toString());
                     editor.putInt("SeriesCalvesB", seriesCalvesB);
                     editor.commit();
                 }


                 if (editTextRepsCalvesB.getText().length() != 0) {
                     repsCalvesB = Integer.parseInt(editTextRepsCalvesB.getText().toString());
                     editor.putInt("RepsCalvesB", repsCalvesB);
                     editor.commit();
                 }

                 if (editTextPercentCalvesB.getText().length() != 0) {
                     percentCalvesB = Integer.parseInt(editTextPercentCalvesB.getText().toString());
                     editor.putInt("PercentCalvesB", percentCalvesB);
                     editor.commit();
                 }

                 if (editTextProgressionCalvesB.getText().length() != 0) {
                     progressionCalvesB =  Float.parseFloat(editTextProgressionCalvesB.getText().toString());
                     editor.putFloat("ProgressionCalvesB", progressionCalvesB);
                     editor.commit();
                 }


                 if (editTextSeriesYRaiseB.getText().length() != 0) {
                     seriesYRaiseB = Integer.parseInt(editTextSeriesYRaiseB.getText().toString());
                     editor.putInt("SeriesYRaiseB", seriesYRaiseB);
                     editor.commit();
                 }


                 if (editTextRepsYRaiseB.getText().length() != 0) {
                     repsYRaiseB = Integer.parseInt(editTextRepsYRaiseB.getText().toString());
                     editor.putInt("RepsYRaiseB", repsYRaiseB);
                     editor.commit();
                 }


                 if (editTextPercentYRaiseB.getText().length() != 0) {
                     percentYRaiseB = Integer.parseInt(editTextPercentYRaiseB.getText().toString());
                     editor.putInt("PercentYRaiseB", percentYRaiseB);
                     editor.commit();
                 }

                 if (editTextProgressionYRaiseB.getText().length() != 0) {
                     progressionYRaiseB =  Float.parseFloat(editTextProgressionYRaiseB.getText().toString());
                     editor.putFloat("ProgressionYRaiseB", progressionYRaiseB);
                     editor.commit();
                 }


                 if (editTextSeriesFacepullB.getText().length() != 0) {
                     seriesFacepullB = Integer.parseInt(editTextSeriesFacepullB.getText().toString());
                     editor.putInt("SeriesFacepullB", seriesFacepullB);
                     editor.commit();
                 }


                 if (editTextRepsFacepullB.getText().length() != 0) {
                     repsFacepullB = Integer.parseInt(editTextRepsFacepullB.getText().toString());
                     editor.putInt("RepsFacepullB", repsFacepullB);
                     editor.commit();
                 }


                 if (editTextPercentFacepullB.getText().length() != 0) {
                     percentFacepullB = Integer.parseInt(editTextPercentFacepullB.getText().toString());
                     editor.putInt("PercentFacepullB", percentFacepullB);
                     editor.commit();
                 }

                 if (editTextProgressionFacepullB.getText().length() != 0) {
                     progressionFacepullB =  Float.parseFloat(editTextProgressionFacepullB.getText().toString());
                     editor.putFloat("ProgressionFacepullB", progressionFacepullB);
                     editor.commit();
                 }



                 if (editTextSeriesSquatC.getText().length() != 0) {
                     seriesSquatC = Integer.parseInt(editTextSeriesSquatC.getText().toString());
                     editor.putInt("SeriesSquatC", seriesSquatC);
                     editor.commit();
                 }


                 if (editTextRepsSquatC.getText().length() != 0) {
                     repsSquatC = Integer.parseInt(editTextRepsSquatC.getText().toString());
                     editor.putInt("RepsSquatC", repsSquatC);
                     editor.commit();
                 }


                 if (editTextPercentSquatC.getText().length() != 0) {
                     percentSquatC = Integer.parseInt(editTextPercentSquatC.getText().toString());
                     editor.putInt("PercentSquatC", percentSquatC);
                     editor.commit();
                 }

                 if (editTextProgressionSquatC.getText().length() != 0) {
                     progressionSquatC =  Float.parseFloat(editTextProgressionSquatC.getText().toString());
                     editor.putFloat("ProgressionSquatC", progressionSquatC);
                     editor.commit();
                 }



                 if (editTextSeriesDeadliftClassicC.getText().length() != 0) {
                     seriesDeadliftClassicC = Integer.parseInt(editTextSeriesDeadliftClassicC.getText().toString());
                     editor.putInt("SeriesDeadliftClassicC", seriesDeadliftClassicC);
                     editor.commit();
                 }


                 if (editTextRepsDeadliftClassicC.getText().length() != 0) {
                     repsDeadliftClassicC = Integer.parseInt(editTextRepsDeadliftClassicC.getText().toString());
                     editor.putInt("RepsDeadliftClassicC", repsDeadliftClassicC);
                     editor.commit();
                 }


                 if (editTextPercentDeadliftClassicC.getText().length() != 0) {
                     percentDeadliftClassicC = Integer.parseInt(editTextPercentDeadliftClassicC.getText().toString());
                     editor.putInt("PercentDeadliftClassicC", percentDeadliftClassicC);
                     editor.commit();
                 }

                 if (editTextProgressionDeadliftClassicC.getText().length() != 0) {
                     progressionDeadliftClassicC =  Float.parseFloat(editTextProgressionDeadliftClassicC.getText().toString());
                     editor.putFloat("ProgressionDeadliftClassicC", progressionDeadliftClassicC);
                     editor.commit();
                 }



                 if (editTextSeriesBenchPressC.getText().length() != 0) {
                     seriesBenchPressC = Integer.parseInt(editTextSeriesBenchPressC.getText().toString());
                     editor.putInt("SeriesBenchPressC", seriesBenchPressC);
                     editor.commit();
                 }


                 if (editTextRepsBenchPressC.getText().length() != 0) {
                     repsBenchPressC = Integer.parseInt(editTextRepsBenchPressC.getText().toString());
                     editor.putInt("RepsBenchPressC", repsBenchPressC);
                     editor.commit();
                 }


                 if (editTextPercentBenchPressC.getText().length() != 0) {
                     percentBenchPressC = Integer.parseInt(editTextPercentBenchPressC.getText().toString());
                     editor.putInt("PercentBenchPressC", percentBenchPressC);
                     editor.commit();
                 }

                 if (editTextProgressionBenchPressC.getText().length() != 0) {
                     progressionBenchPressC =  Float.parseFloat(editTextProgressionBenchPressC.getText().toString());
                     editor.putFloat("ProgressionBenchPressC", progressionBenchPressC);
                     editor.commit();
                 }


                 if (editTextSeriesNarrowBenchPressC.getText().length() != 0) {
                     seriesNarrowBenchPressC = Integer.parseInt(editTextSeriesNarrowBenchPressC.getText().toString());
                     editor.putInt("SeriesNarrowBenchPressC", seriesNarrowBenchPressC);
                     editor.commit();
                 }


                 if (editTextRepsNarrowBenchPressC.getText().length() != 0) {
                     repsNarrowBenchPressC = Integer.parseInt(editTextRepsNarrowBenchPressC.getText().toString());
                     editor.putInt("RepsNarrowBenchPressC", repsNarrowBenchPressC);
                     editor.commit();
                 }


                 if (editTextPercentNarrowBenchPressC.getText().length() != 0) {
                     percentNarrowBenchPressC = Integer.parseInt(editTextPercentNarrowBenchPressC.getText().toString());
                     editor.putInt("PercentNarrowBenchPressC", percentNarrowBenchPressC);
                     editor.commit();
                 }

                 if (editTextProgressionNarrowBenchPressC.getText().length() != 0) {
                     progressionNarrowBenchPressC =  Float.parseFloat(editTextProgressionNarrowBenchPressC.getText().toString());
                     editor.putFloat("ProgressionNarrowBenchPressC", progressionNarrowBenchPressC);
                     editor.commit();
                 }


                 if (editTextSeriesOhpC.getText().length() != 0) {
                     seriesOhpC = Integer.parseInt(editTextSeriesOhpC.getText().toString());
                     editor.putInt("SeriesOhpC", seriesOhpC);
                     editor.commit();
                 }


                 if (editTextRepsOhpC.getText().length() != 0) {
                     repsOhpC = Integer.parseInt(editTextRepsOhpC.getText().toString());
                     editor.putInt("RepsOhpC", repsOhpC);
                     editor.commit();
                 }


                 if (editTextPercentOhpC.getText().length() != 0) {
                     percentOhpC = Integer.parseInt(editTextPercentOhpC.getText().toString());
                     editor.putInt("PercentOhpC", percentOhpC);
                     editor.commit();
                 }

                 if (editTextProgressionOhpC.getText().length() != 0) {
                     progressionOhpC =  Float.parseFloat(editTextProgressionOhpC.getText().toString());
                     editor.putFloat("ProgressionOhpC", progressionOhpC);
                     editor.commit();
                 }

                 if (editTextSeriesRowingC.getText().length() != 0) {
                     seriesRowingC = Integer.parseInt(editTextSeriesRowingC.getText().toString());
                     editor.putInt("SeriesRowingC", seriesRowingC);
                     editor.commit();
                 }


                 if (editTextRepsRowingC.getText().length() != 0) {
                     repsRowingC = Integer.parseInt(editTextRepsRowingC.getText().toString());
                     editor.putInt("RepsRowingC", repsRowingC);
                     editor.commit();
                 }


                 if (editTextPercentRowingC.getText().length() != 0) {
                     percentRowingC = Integer.parseInt(editTextPercentRowingC.getText().toString());
                     editor.putInt("PercentRowingC", percentRowingC);
                     editor.commit();
                 }

                 if (editTextProgressionRowingC.getText().length() != 0) {
                     progressionRowingC =  Float.parseFloat(editTextProgressionRowingC.getText().toString());
                     editor.putFloat("ProgressionRowingC", progressionRowingC);
                     editor.commit();
                 }


                 if (editTextSeriesPullingUpNarrowC.getText().length() != 0) {
                     seriesPullingUpNarrowC = Integer.parseInt(editTextSeriesPullingUpNarrowC.getText().toString());
                     editor.putInt("SeriesPullingUpNarrowC", seriesPullingUpNarrowC);
                     editor.commit();
                 }


                 if (editTextRepsPullingUpNarrowC.getText().length() != 0) {
                     repsPullingUpNarrowC = Integer.parseInt(editTextRepsPullingUpNarrowC.getText().toString());
                     editor.putInt("RepsPullingUpNarrowC", repsPullingUpNarrowC);
                     editor.commit();
                 }


                 if (editTextPercentPullingUpNarrowC.getText().length() != 0) {
                     percentPullingUpNarrowC = Integer.parseInt(editTextPercentPullingUpNarrowC.getText().toString());
                     editor.putInt("PercentPullingUpNarrowC", percentPullingUpNarrowC);
                     editor.commit();
                 }

                 if (editTextProgressionPullingUpNarrowC.getText().length() != 0) {
                     progressionPullingUpNarrowC =  Float.parseFloat(editTextProgressionPullingUpNarrowC.getText().toString());
                     editor.putFloat("ProgressionPullingUpNarrowC", progressionPullingUpNarrowC);
                     editor.commit();
                 }


                 if (editTextSeriesRisingSidewaysC.getText().length() != 0) {
                     seriesRisingSidewaysC = Integer.parseInt(editTextSeriesRisingSidewaysC.getText().toString());
                     editor.putInt("SeriesRisingSidewaysC", seriesRisingSidewaysC);
                     editor.commit();
                 }


                 if (editTextRepsRisingSidewaysC.getText().length() != 0) {
                     repsRisingSidewaysC = Integer.parseInt(editTextRepsRisingSidewaysC.getText().toString());
                     editor.putInt("RepsRisingSidewaysC", repsRisingSidewaysC);
                     editor.commit();
                 }


                 if (editTextPercentRisingSidewaysC.getText().length() != 0) {
                     percentRisingSidewaysC = Integer.parseInt(editTextPercentRisingSidewaysC.getText().toString());
                     editor.putInt("PercentRisingSidewaysC", percentRisingSidewaysC);
                     editor.commit();
                 }

                 if (editTextProgressionRisingSidewaysC.getText().length() != 0) {
                     progressionRisingSidewaysC =  Float.parseFloat(editTextProgressionRisingSidewaysC.getText().toString());
                     editor.putFloat("ProgressionRisingSidewaysC", progressionRisingSidewaysC);
                     editor.commit();
                 }

                 if (editTextSeriesBicepsC.getText().length() != 0) {
                     seriesBicepsC = Integer.parseInt(editTextSeriesBicepsC.getText().toString());
                     editor.putInt("SeriesBicepsC", seriesBicepsC);
                     editor.commit();
                 }


                 if (editTextRepsBicepsC.getText().length() != 0) {
                     repsBicepsC = Integer.parseInt(editTextRepsBicepsC.getText().toString());
                     editor.putInt("RepsBicepsC", repsBicepsC);
                     editor.commit();
                 }


                 if (editTextPercentBicepsC.getText().length() != 0) {
                     percentBicepsC = Integer.parseInt(editTextPercentBicepsC.getText().toString());
                     editor.putInt("PercentBicepsC", percentBicepsC);
                     editor.commit();
                 }

                 if (editTextProgressionBicepsC.getText().length() != 0) {
                     progressionBicepsC =  Float.parseFloat(editTextProgressionBicepsC.getText().toString());
                     editor.putFloat("ProgressionBicepsC", progressionBicepsC);
                     editor.commit();
                 }



                 if (editTextSeriesTricepsC.getText().length() != 0) {
                     seriesTricepsC = Integer.parseInt(editTextSeriesTricepsC.getText().toString());
                     editor.putInt("SeriesTricepsC", seriesTricepsC);
                     editor.commit();
                 }


                 if (editTextRepsTricepsC.getText().length() != 0) {
                     repsTricepsC = Integer.parseInt(editTextRepsTricepsC.getText().toString());
                     editor.putInt("RepsTricepsC", repsTricepsC);
                     editor.commit();
                 }


                 if (editTextPercentTricepsC.getText().length() != 0) {
                     percentTricepsC = Integer.parseInt(editTextPercentTricepsC.getText().toString());
                     editor.putInt("PercentTricepsC", percentTricepsC);
                     editor.commit();
                 }

                 if (editTextProgressionTricepsC.getText().length() != 0) {
                     progressionTricepsC =  Float.parseFloat(editTextProgressionTricepsC.getText().toString());
                     editor.putFloat("ProgressionTricepsC", progressionTricepsC);
                     editor.commit();
                 }

                 if (editTextSeriesAllahsC.getText().length() != 0) {
                     seriesAllahsC = Integer.parseInt(editTextSeriesAllahsC.getText().toString());
                     editor.putInt("SeriesAllahsC", seriesAllahsC);
                     editor.commit();
                 }


                 if (editTextRepsAllahsC.getText().length() != 0) {
                     repsAllahsC = Integer.parseInt(editTextRepsAllahsC.getText().toString());
                     editor.putInt("RepsAllahsC", repsAllahsC);
                     editor.commit();
                 }


                 if (editTextPercentAllahsC.getText().length() != 0) {
                     percentAllahsC = Integer.parseInt(editTextPercentAllahsC.getText().toString());
                     editor.putInt("PercentAllahsC", percentAllahsC);
                     editor.commit();
                 }

                 if (editTextProgressionAllahsC.getText().length() != 0) {
                     progressionAllahsC =  Float.parseFloat(editTextProgressionAllahsC.getText().toString());
                     editor.putFloat("ProgressionAllahsC", progressionAllahsC);
                     editor.commit();
                 }


                 if (editTextSeriesPlankC.getText().length() != 0) {
                     seriesPlankC = Integer.parseInt(editTextSeriesPlankC.getText().toString());
                     editor.putInt("SeriesPlankC", seriesPlankC);
                     editor.commit();
                 }


                 if (editTextSecondsPlankC.getText().length() != 0) {
                     secondsPlankC = Integer.parseInt(editTextSecondsPlankC.getText().toString());
                     editor.putInt("SecondsPlankC", secondsPlankC);
                     editor.commit();
                 }


                 if (editTextProgressionPlankC.getText().length() != 0) {
                     progressionPlankC =  Float.parseFloat(editTextProgressionPlankC.getText().toString());
                     editor.putFloat("ProgressionPlankC", progressionPlankC);
                     editor.commit();
                 }


                 if (editTextSeriesCalvesC.getText().length() != 0) {
                     seriesCalvesC = Integer.parseInt(editTextSeriesCalvesC.getText().toString());
                     editor.putInt("SeriesCalvesC", seriesCalvesC);
                     editor.commit();
                 }


                 if (editTextRepsCalvesC.getText().length() != 0) {
                     repsCalvesC= Integer.parseInt(editTextRepsCalvesC.getText().toString());
                     editor.putInt("RepsCalvesC", repsCalvesC);
                     editor.commit();
                 }

                 if (editTextPercentCalvesC.getText().length() != 0) {
                     percentCalvesC = Integer.parseInt(editTextPercentCalvesC.getText().toString());
                     editor.putInt("PercentCalvesC", percentCalvesC);
                     editor.commit();
                 }

                 if (editTextProgressionCalvesC.getText().length() != 0) {
                     progressionCalvesC =  Float.parseFloat(editTextProgressionCalvesC.getText().toString());
                     editor.putFloat("ProgressionCalvesC", progressionCalvesC);
                     editor.commit();
                 }


                 if (editTextSeriesYRaiseC.getText().length() != 0) {
                     seriesYRaiseC = Integer.parseInt(editTextSeriesYRaiseC.getText().toString());
                     editor.putInt("SeriesYRaiseC", seriesYRaiseC);
                     editor.commit();
                 }


                 if (editTextRepsYRaiseC.getText().length() != 0) {
                     repsYRaiseC = Integer.parseInt(editTextRepsYRaiseC.getText().toString());
                     editor.putInt("RepsYRaiseC", repsYRaiseC);
                     editor.commit();
                 }


                 if (editTextPercentYRaiseC.getText().length() != 0) {
                     percentYRaiseC = Integer.parseInt(editTextPercentYRaiseC.getText().toString());
                     editor.putInt("PercentYRaiseC", percentYRaiseC);
                     editor.commit();
                 }

                 if (editTextProgressionYRaiseC.getText().length() != 0) {
                     progressionYRaiseC =  Float.parseFloat(editTextProgressionYRaiseC.getText().toString());
                     editor.putFloat("ProgressionYRaiseC", progressionYRaiseC);
                     editor.commit();
                 }


                 if (editTextSeriesFacepullC.getText().length() != 0) {
                     seriesFacepullC = Integer.parseInt(editTextSeriesFacepullC.getText().toString());
                     editor.putInt("SeriesFacepullC", seriesFacepullC);
                     editor.commit();
                 }


                 if (editTextRepsFacepullC.getText().length() != 0) {
                     repsFacepullC = Integer.parseInt(editTextRepsFacepullC.getText().toString());
                     editor.putInt("RepsFacepullC", repsFacepullC);
                     editor.commit();
                 }


                 if (editTextPercentFacepullC.getText().length() != 0) {
                     percentFacepullC = Integer.parseInt(editTextPercentFacepullC.getText().toString());
                     editor.putInt("PercentFacepullC", percentFacepullC);
                     editor.commit();
                 }

                 if (editTextProgressionFacepullC.getText().length() != 0) {
                     progressionFacepullC =  Float.parseFloat(editTextProgressionFacepullC.getText().toString());
                     editor.putFloat("ProgressionFacepullC", progressionFacepullC);
                     editor.commit();
                 }



                 if (editTextSeriesSquatD.getText().length() != 0) {
                     seriesSquatD = Integer.parseInt(editTextSeriesSquatD.getText().toString());
                     editor.putInt("SeriesSquatD", seriesSquatD);
                     editor.commit();
                 }


                 if (editTextRepsSquatD.getText().length() != 0) {
                     repsSquatD = Integer.parseInt(editTextRepsSquatD.getText().toString());
                     editor.putInt("RepsSquatD", repsSquatD);
                     editor.commit();
                 }


                 if (editTextPercentSquatD.getText().length() != 0) {
                     percentSquatD = Integer.parseInt(editTextPercentSquatD.getText().toString());
                     editor.putInt("PercentSquatD", percentSquatD);
                     editor.commit();
                 }

                 if (editTextProgressionSquatD.getText().length() != 0) {
                     progressionSquatD =  Float.parseFloat(editTextProgressionSquatD.getText().toString());
                     editor.putFloat("ProgressionSquatD", progressionSquatD);
                     editor.commit();
                 }



                 if (editTextSeriesDeadliftClassicD.getText().length() != 0) {
                     seriesDeadliftClassicD = Integer.parseInt(editTextSeriesDeadliftClassicD.getText().toString());
                     editor.putInt("SeriesDeadliftClassicD", seriesDeadliftClassicD);
                     editor.commit();
                 }


                 if (editTextRepsDeadliftClassicD.getText().length() != 0) {
                     repsDeadliftClassicD = Integer.parseInt(editTextRepsDeadliftClassicD.getText().toString());
                     editor.putInt("RepsDeadliftClassicD", repsDeadliftClassicD);
                     editor.commit();
                 }


                 if (editTextPercentDeadliftClassicD.getText().length() != 0) {
                     percentDeadliftClassicD = Integer.parseInt(editTextPercentDeadliftClassicD.getText().toString());
                     editor.putInt("PercentDeadliftClassicD", percentDeadliftClassicD);
                     editor.commit();
                 }

                 if (editTextProgressionDeadliftClassicD.getText().length() != 0) {
                     progressionDeadliftClassicD =  Float.parseFloat(editTextProgressionDeadliftClassicD.getText().toString());
                     editor.putFloat("ProgressionDeadliftClassicD", progressionDeadliftClassicD);
                     editor.commit();
                 }



                 if (editTextSeriesBenchPressD.getText().length() != 0) {
                     seriesBenchPressD = Integer.parseInt(editTextSeriesBenchPressD.getText().toString());
                     editor.putInt("SeriesBenchPressD", seriesBenchPressD);
                     editor.commit();
                 }


                 if (editTextRepsBenchPressD.getText().length() != 0) {
                     repsBenchPressD = Integer.parseInt(editTextRepsBenchPressD.getText().toString());
                     editor.putInt("RepsBenchPressD", repsBenchPressD);
                     editor.commit();
                 }


                 if (editTextPercentBenchPressD.getText().length() != 0) {
                     percentBenchPressD = Integer.parseInt(editTextPercentBenchPressD.getText().toString());
                     editor.putInt("PercentBenchPressD", percentBenchPressD);
                     editor.commit();
                 }

                 if (editTextProgressionBenchPressD.getText().length() != 0) {
                     progressionBenchPressD =  Float.parseFloat(editTextProgressionBenchPressD.getText().toString());
                     editor.putFloat("ProgressionBenchPressD", progressionBenchPressD);
                     editor.commit();
                 }


                 if (editTextSeriesNarrowBenchPressD.getText().length() != 0) {
                     seriesNarrowBenchPressD = Integer.parseInt(editTextSeriesNarrowBenchPressD.getText().toString());
                     editor.putInt("SeriesNarrowBenchPressD", seriesNarrowBenchPressD);
                     editor.commit();
                 }


                 if (editTextRepsNarrowBenchPressD.getText().length() != 0) {
                     repsNarrowBenchPressD = Integer.parseInt(editTextRepsNarrowBenchPressD.getText().toString());
                     editor.putInt("RepsNarrowBenchPressD", repsNarrowBenchPressD);
                     editor.commit();
                 }


                 if (editTextPercentNarrowBenchPressD.getText().length() != 0) {
                     percentNarrowBenchPressD = Integer.parseInt(editTextPercentNarrowBenchPressD.getText().toString());
                     editor.putInt("PercentNarrowBenchPressD", percentNarrowBenchPressD);
                     editor.commit();
                 }

                 if (editTextProgressionNarrowBenchPressD.getText().length() != 0) {
                     progressionNarrowBenchPressD =  Float.parseFloat(editTextProgressionNarrowBenchPressD.getText().toString());
                     editor.putFloat("ProgressionNarrowBenchPressD", progressionNarrowBenchPressD);
                     editor.commit();
                 }


                 if (editTextSeriesOhpD.getText().length() != 0) {
                     seriesOhpD = Integer.parseInt(editTextSeriesOhpD.getText().toString());
                     editor.putInt("SeriesOhpD", seriesOhpD);
                     editor.commit();
                 }


                 if (editTextRepsOhpD.getText().length() != 0) {
                     repsOhpD = Integer.parseInt(editTextRepsOhpD.getText().toString());
                     editor.putInt("RepsOhpD", repsOhpD);
                     editor.commit();
                 }


                 if (editTextPercentOhpD.getText().length() != 0) {
                     percentOhpD = Integer.parseInt(editTextPercentOhpD.getText().toString());
                     editor.putInt("PercentOhpD", percentOhpD);
                     editor.commit();
                 }

                 if (editTextProgressionOhpD.getText().length() != 0) {
                     progressionOhpD =  Float.parseFloat(editTextProgressionOhpD.getText().toString());
                     editor.putFloat("ProgressionOhpD", progressionOhpD);
                     editor.commit();
                 }

                 if (editTextSeriesRowingD.getText().length() != 0) {
                     seriesRowingD = Integer.parseInt(editTextSeriesRowingD.getText().toString());
                     editor.putInt("SeriesRowingD", seriesRowingD);
                     editor.commit();
                 }


                 if (editTextRepsRowingD.getText().length() != 0) {
                     repsRowingD = Integer.parseInt(editTextRepsRowingD.getText().toString());
                     editor.putInt("RepsRowingD", repsRowingD);
                     editor.commit();
                 }


                 if (editTextPercentRowingD.getText().length() != 0) {
                     percentRowingD = Integer.parseInt(editTextPercentRowingD.getText().toString());
                     editor.putInt("PercentRowingD", percentRowingD);
                     editor.commit();
                 }

                 if (editTextProgressionRowingD.getText().length() != 0) {
                     progressionRowingD =  Float.parseFloat(editTextProgressionRowingD.getText().toString());
                     editor.putFloat("ProgressionRowingD", progressionRowingD);
                     editor.commit();
                 }


                 if (editTextSeriesPullingUpNarrowD.getText().length() != 0) {
                     seriesPullingUpNarrowD = Integer.parseInt(editTextSeriesPullingUpNarrowD.getText().toString());
                     editor.putInt("SeriesPullingUpNarrowD", seriesPullingUpNarrowD);
                     editor.commit();
                 }


                 if (editTextRepsPullingUpNarrowD.getText().length() != 0) {
                     repsPullingUpNarrowD = Integer.parseInt(editTextRepsPullingUpNarrowD.getText().toString());
                     editor.putInt("RepsPullingUpNarrowD", repsPullingUpNarrowD);
                     editor.commit();
                 }


                 if (editTextPercentPullingUpNarrowD.getText().length() != 0) {
                     percentPullingUpNarrowD = Integer.parseInt(editTextPercentPullingUpNarrowD.getText().toString());
                     editor.putInt("PercentPullingUpNarrowD", percentPullingUpNarrowD);
                     editor.commit();
                 }

                 if (editTextProgressionPullingUpNarrowD.getText().length() != 0) {
                     progressionPullingUpNarrowD =  Float.parseFloat(editTextProgressionPullingUpNarrowD.getText().toString());
                     editor.putFloat("ProgressionPullingUpNarrowD", progressionPullingUpNarrowD);
                     editor.commit();
                 }


                 if (editTextSeriesRisingSidewaysD.getText().length() != 0) {
                     seriesRisingSidewaysD = Integer.parseInt(editTextSeriesRisingSidewaysD.getText().toString());
                     editor.putInt("SeriesRisingSidewaysD", seriesRisingSidewaysD);
                     editor.commit();
                 }


                 if (editTextRepsRisingSidewaysD.getText().length() != 0) {
                     repsRisingSidewaysD = Integer.parseInt(editTextRepsRisingSidewaysD.getText().toString());
                     editor.putInt("RepsRisingSidewaysD", repsRisingSidewaysD);
                     editor.commit();
                 }


                 if (editTextPercentRisingSidewaysD.getText().length() != 0) {
                     percentRisingSidewaysD = Integer.parseInt(editTextPercentRisingSidewaysD.getText().toString());
                     editor.putInt("PercentRisingSidewaysD", percentRisingSidewaysD);
                     editor.commit();
                 }

                 if (editTextProgressionRisingSidewaysD.getText().length() != 0) {
                     progressionRisingSidewaysD =  Float.parseFloat(editTextProgressionRisingSidewaysD.getText().toString());
                     editor.putFloat("ProgressionRisingSidewaysD", progressionRisingSidewaysD);
                     editor.commit();
                 }

                 if (editTextSeriesBicepsD.getText().length() != 0) {
                     seriesBicepsD = Integer.parseInt(editTextSeriesBicepsD.getText().toString());
                     editor.putInt("SeriesBicepsD", seriesBicepsD);
                     editor.commit();
                 }


                 if (editTextRepsBicepsD.getText().length() != 0) {
                     repsBicepsD = Integer.parseInt(editTextRepsBicepsD.getText().toString());
                     editor.putInt("RepsBicepsD", repsBicepsD);
                     editor.commit();
                 }


                 if (editTextPercentBicepsD.getText().length() != 0) {
                     percentBicepsD = Integer.parseInt(editTextPercentBicepsD.getText().toString());
                     editor.putInt("PercentBicepsD", percentBicepsD);
                     editor.commit();
                 }

                 if (editTextProgressionBicepsD.getText().length() != 0) {
                     progressionBicepsD =  Float.parseFloat(editTextProgressionBicepsD.getText().toString());
                     editor.putFloat("ProgressionBicepsD", progressionBicepsD);
                     editor.commit();
                 }



                 if (editTextSeriesTricepsD.getText().length() != 0) {
                     seriesTricepsD = Integer.parseInt(editTextSeriesTricepsD.getText().toString());
                     editor.putInt("SeriesTricepsD", seriesTricepsD);
                     editor.commit();
                 }


                 if (editTextRepsTricepsD.getText().length() != 0) {
                     repsTricepsD = Integer.parseInt(editTextRepsTricepsD.getText().toString());
                     editor.putInt("RepsTricepsD", repsTricepsD);
                     editor.commit();
                 }


                 if (editTextPercentTricepsD.getText().length() != 0) {
                     percentTricepsD = Integer.parseInt(editTextPercentTricepsD.getText().toString());
                     editor.putInt("PercentTricepsD", percentTricepsD);
                     editor.commit();
                 }

                 if (editTextProgressionTricepsD.getText().length() != 0) {
                     progressionTricepsD =  Float.parseFloat(editTextProgressionTricepsD.getText().toString());
                     editor.putFloat("ProgressionTricepsD", progressionTricepsD);
                     editor.commit();
                 }

                 if (editTextSeriesAllahsD.getText().length() != 0) {
                     seriesAllahsD = Integer.parseInt(editTextSeriesAllahsD.getText().toString());
                     editor.putInt("SeriesAllahsD", seriesAllahsD);
                     editor.commit();
                 }


                 if (editTextRepsAllahsD.getText().length() != 0) {
                     repsAllahsD = Integer.parseInt(editTextRepsAllahsD.getText().toString());
                     editor.putInt("RepsAllahsD", repsAllahsD);
                     editor.commit();
                 }


                 if (editTextPercentAllahsD.getText().length() != 0) {
                     percentAllahsD = Integer.parseInt(editTextPercentAllahsD.getText().toString());
                     editor.putInt("PercentAllahsD", percentAllahsD);
                     editor.commit();
                 }

                 if (editTextProgressionAllahsD.getText().length() != 0) {
                     progressionAllahsD =  Float.parseFloat(editTextProgressionAllahsD.getText().toString());
                     editor.putFloat("ProgressionAllahsD", progressionAllahsD);
                     editor.commit();
                 }


                 if (editTextSeriesPlankD.getText().length() != 0) {
                     seriesPlankD = Integer.parseInt(editTextSeriesPlankD.getText().toString());
                     editor.putInt("SeriesPlankD", seriesPlankD);
                     editor.commit();
                 }


                 if (editTextSecondsPlankD.getText().length() != 0) {
                     secondsPlankD = Integer.parseInt(editTextSecondsPlankD.getText().toString());
                     editor.putInt("SecondsPlankD", secondsPlankD);
                     editor.commit();
                 }


                 if (editTextProgressionPlankD.getText().length() != 0) {
                     progressionPlankD =  Float.parseFloat(editTextProgressionPlankD.getText().toString());
                     editor.putFloat("ProgressionPlankD", progressionPlankD);
                     editor.commit();
                 }


                 if (editTextSeriesCalvesD.getText().length() != 0) {
                     seriesCalvesD = Integer.parseInt(editTextSeriesCalvesD.getText().toString());
                     editor.putInt("SeriesCalvesD", seriesCalvesD);
                     editor.commit();
                 }


                 if (editTextRepsCalvesD.getText().length() != 0) {
                     repsCalvesD = Integer.parseInt(editTextRepsCalvesD.getText().toString());
                     editor.putInt("RepsCalvesD", repsCalvesD);
                     editor.commit();
                 }

                 if (editTextPercentCalvesD.getText().length() != 0) {
                     percentCalvesD = Integer.parseInt(editTextPercentCalvesD.getText().toString());
                     editor.putInt("PercentCalvesD", percentCalvesD);
                     editor.commit();
                 }

                 if (editTextProgressionCalvesD.getText().length() != 0) {
                     progressionCalvesD =  Float.parseFloat(editTextProgressionCalvesD.getText().toString());
                     editor.putFloat("ProgressionCalvesD", progressionCalvesD);
                     editor.commit();
                 }


                 if (editTextSeriesYRaiseD.getText().length() != 0) {
                     seriesYRaiseD = Integer.parseInt(editTextSeriesYRaiseD.getText().toString());
                     editor.putInt("SeriesYRaiseD", seriesYRaiseD);
                     editor.commit();
                 }


                 if (editTextRepsYRaiseD.getText().length() != 0) {
                     repsYRaiseD = Integer.parseInt(editTextRepsYRaiseD.getText().toString());
                     editor.putInt("RepsYRaiseD", repsYRaiseD);
                     editor.commit();
                 }


                 if (editTextPercentYRaiseD.getText().length() != 0) {
                     percentYRaiseD = Integer.parseInt(editTextPercentYRaiseD.getText().toString());
                     editor.putInt("PercentYRaiseD", percentYRaiseD);
                     editor.commit();
                 }

                 if (editTextProgressionYRaiseD.getText().length() != 0) {
                     progressionYRaiseD =  Float.parseFloat(editTextProgressionYRaiseD.getText().toString());
                     editor.putFloat("ProgressionYRaiseD", progressionYRaiseD);
                     editor.commit();
                 }


                 if (editTextSeriesFacepullD.getText().length() != 0) {
                     seriesFacepullD = Integer.parseInt(editTextSeriesFacepullD.getText().toString());
                     editor.putInt("SeriesFacepullD", seriesFacepullD);
                     editor.commit();
                 }


                 if (editTextRepsFacepullD.getText().length() != 0) {
                     repsFacepullD = Integer.parseInt(editTextRepsFacepullD.getText().toString());
                     editor.putInt("RepsFacepullD", repsFacepullD);
                     editor.commit();
                 }


                 if (editTextPercentFacepullD.getText().length() != 0) {
                     percentFacepullD = Integer.parseInt(editTextPercentFacepullD.getText().toString());
                     editor.putInt("PercentFacepullD", percentFacepullD);
                     editor.commit();
                 }

                 if (editTextProgressionFacepullD.getText().length() != 0) {
                     progressionFacepullD =  Float.parseFloat(editTextProgressionFacepullD.getText().toString());
                     editor.putFloat("ProgressionFacepullD", progressionFacepullD);
                     editor.commit();
                 }
         }


             private void getCustomWorkoutPrefs() {
                 seriesSquat = prefs.getInt("SeriesSquat", 0);
                 repsSquat = prefs.getInt("RepsSquat", 0);
                 percentSquat = prefs.getInt("PercentSquat", 0);
                 progressionSquat = prefs.getFloat("ProgressionSquat", 0.0f);
                 editTextSeriesSquat.setText(String.valueOf(prefs.getInt("SeriesSquat", 0)));
                 editTextRepsSquat.setText(String.valueOf(prefs.getInt("RepsSquat", 0)));
                 editTextPercentSquat.setText(String.valueOf(prefs.getInt("PercentSquat", 0)));
                 editTextProgressionSquat.setText(String.valueOf(prefs.getFloat("ProgressionSquat", 0.0f)));

                 seriesDeadliftClassic = prefs.getInt("SeriesDeadliftClassic", 0);
                 repsDeadliftClassic = prefs.getInt("RepsDeadliftClassic", 0);
                 percentDeadliftClassic = prefs.getInt("PercentDeadliftClassic", 0);
                 progressionDeadliftClassic = prefs.getFloat("ProgressionDeadliftClassic", 0.0f);
                 editTextSeriesDeadliftClassic.setText(String.valueOf(prefs.getInt("SeriesDeadliftClassic", 0)));
                 editTextRepsDeadliftClassic.setText(String.valueOf(prefs.getInt("RepsDeadliftClassic", 0)));
                 editTextPercentDeadliftClassic.setText(String.valueOf(prefs.getInt("PercentDeadliftClassic", 0)));
                 editTextProgressionDeadliftClassic.setText(String.valueOf(prefs.getFloat("ProgressionDeadliftClassic", 0.0f)));

                 seriesBenchPress = prefs.getInt("SeriesBenchPress", 0);
                 repsBenchPress = prefs.getInt("RepsBenchPress", 0);
                 percentBenchPress = prefs.getInt("PercentBenchPress", 0);
                 progressionBenchPress = prefs.getFloat("ProgressionBenchPress", 0.0f);
                 editTextSeriesBenchPress.setText(String.valueOf(prefs.getInt("SeriesBenchPress", 0)));
                 editTextRepsBenchPress.setText(String.valueOf(prefs.getInt("RepsBenchPress", 0)));
                 editTextPercentBenchPress.setText(String.valueOf(prefs.getInt("PercentBenchPress", 0)));
                 editTextProgressionBenchPress.setText(String.valueOf(prefs.getFloat("ProgressionBenchPress", 0.0f)));

                 seriesNarrowBenchPress = prefs.getInt("SeriesNarrowBenchPress", 0);
                 repsNarrowBenchPress = prefs.getInt("RepsNarrowBenchPress", 0);
                 percentNarrowBenchPress = prefs.getInt("PercentNarrowBenchPress", 0);
                 progressionNarrowBenchPress = prefs.getFloat("ProgressionNarrowBenchPress", 0.0f);
                 editTextSeriesNarrowBenchPress.setText(String.valueOf(prefs.getInt("SeriesNarrowBenchPress", 0)));
                 editTextRepsNarrowBenchPress.setText(String.valueOf(prefs.getInt("RepsNarrowBenchPress", 0)));
                 editTextPercentNarrowBenchPress.setText(String.valueOf(prefs.getInt("PercentNarrowBenchPress", 0)));
                 editTextProgressionNarrowBenchPress.setText(String.valueOf(prefs.getFloat("ProgressionNarrowBenchPress", 0.0f)));

                 seriesOhp = prefs.getInt("SeriesOhp", 0);
                 repsOhp = prefs.getInt("RepsOhp", 0);
                 percentOhp = prefs.getInt("PercentOhp", 0);
                 progressionOhp = prefs.getFloat("ProgressionOhp", 0.0f);
                 editTextSeriesOhp.setText(String.valueOf(prefs.getInt("SeriesOhp", 0)));
                 editTextRepsOhp.setText(String.valueOf(prefs.getInt("RepsOhp", 0)));
                 editTextPercentOhp.setText(String.valueOf(prefs.getInt("PercentOhp", 0)));
                 editTextProgressionOhp.setText(String.valueOf(prefs.getFloat("ProgressionOhp", 0.0f)));

                 seriesRowing = prefs.getInt("SeriesRowing", 0);
                 repsRowing = prefs.getInt("RepsRowing", 0);
                 percentRowing = prefs.getInt("PercentRowing", 0);
                 progressionRowing = prefs.getFloat("ProgressionRowing", 0.0f);
                 editTextSeriesRowing.setText(String.valueOf(prefs.getInt("SeriesRowing", 0)));
                 editTextRepsRowing.setText(String.valueOf(prefs.getInt("RepsRowing", 0)));
                 editTextPercentRowing.setText(String.valueOf(prefs.getInt("PercentRowing", 0)));
                 editTextProgressionRowing.setText(String.valueOf(prefs.getFloat("ProgressionRowing", 0.0f)));

                 seriesPullingUpNarrow = prefs.getInt("SeriesPullingUpNarrow", 0);
                 repsPullingUpNarrow = prefs.getInt("RepsPullingUpNarrow", 0);
                 percentPullingUpNarrow = prefs.getInt("PercentPullingUpNarrow", 0);
                 progressionPullingUpNarrow = prefs.getFloat("ProgressionPullingUpNarrow", 0.0f);
                 editTextSeriesPullingUpNarrow.setText(String.valueOf(prefs.getInt("SeriesPullingUpNarrow", 0)));
                 editTextRepsPullingUpNarrow.setText(String.valueOf(prefs.getInt("RepsPullingUpNarrow", 0)));
                 editTextPercentPullingUpNarrow.setText(String.valueOf(prefs.getInt("PercentPullingUpNarrow", 0)));
                 editTextProgressionPullingUpNarrow.setText(String.valueOf(prefs.getFloat("ProgressionPullingUpNarrow", 0.0f)));

                 seriesRisingSideways= prefs.getInt("SeriesRisingSideways", 0);
                 repsRisingSideways = prefs.getInt("RepsRisingSideways", 0);
                 percentRisingSideways = prefs.getInt("PercentRisingSideways", 0);
                 progressionRisingSideways = prefs.getFloat("ProgressionRisingSideways", 0.0f);
                 editTextSeriesRisingSideways.setText(String.valueOf(prefs.getInt("SeriesRisingSideways", 0)));
                 editTextRepsRisingSideways.setText(String.valueOf(prefs.getInt("RepsRisingSideways", 0)));
                 editTextPercentRisingSideways.setText(String.valueOf(prefs.getInt("PercentRisingSideways", 0)));
                 editTextProgressionRisingSideways.setText(String.valueOf(prefs.getFloat("ProgressionRisingSideways", 0.0f)));

                 seriesBiceps= prefs.getInt("SeriesBiceps", 0);
                 repsBiceps = prefs.getInt("RepsBiceps", 0);
                 percentBiceps = prefs.getInt("PercentBiceps", 0);
                 progressionBiceps = prefs.getFloat("ProgressionBiceps", 0.0f);
                 editTextSeriesBiceps.setText(String.valueOf(prefs.getInt("SeriesBiceps", 0)));
                 editTextRepsBiceps.setText(String.valueOf(prefs.getInt("RepsBiceps", 0)));
                 editTextPercentBiceps.setText(String.valueOf(prefs.getInt("PercentBiceps", 0)));
                 editTextProgressionBiceps.setText(String.valueOf(prefs.getFloat("ProgressionBiceps", 0.0f)));

                 seriesTriceps= prefs.getInt("SeriesTriceps", 0);
                 repsTriceps = prefs.getInt("RepsTriceps", 0);
                 percentTriceps= prefs.getInt("PercentTriceps", 0);
                 progressionTriceps = prefs.getFloat("ProgressionTriceps", 0.0f);
                 editTextSeriesTriceps.setText(String.valueOf(prefs.getInt("SeriesTriceps", 0)));
                 editTextRepsTriceps.setText(String.valueOf(prefs.getInt("RepsTriceps", 0)));
                 editTextPercentTriceps.setText(String.valueOf(prefs.getInt("PercentTriceps", 0)));
                 editTextProgressionTriceps.setText(String.valueOf(prefs.getFloat("ProgressionTriceps", 0.0f)));

                 seriesAllahs= prefs.getInt("SeriesAllahs", 0);
                 repsAllahs = prefs.getInt("RepsAllahs", 0);
                 percentAllahs= prefs.getInt("PercentAllahs", 0);
                 progressionAllahs = prefs.getFloat("ProgressionAllahs", 0.0f);
                 editTextSeriesAllahs.setText(String.valueOf(prefs.getInt("SeriesAllahs", 0)));
                 editTextRepsAllahs.setText(String.valueOf(prefs.getInt("RepsAllahs", 0)));
                 editTextPercentAllahs.setText(String.valueOf(prefs.getInt("PercentAllahs", 0)));
                 editTextProgressionAllahs.setText(String.valueOf(prefs.getFloat("ProgressionAllahs", 0.0f)));

                 seriesPlank= prefs.getInt("SeriesPlank", 0);
                 secondsPlank = prefs.getInt("SecondsPlank", 0);
                 progressionPlank = prefs.getFloat("ProgressionPlank", 0.0f);
                 editTextSeriesPlank.setText(String.valueOf(prefs.getInt("SeriesPlank", 0)));
                 editTextSecondsPlank.setText(String.valueOf(prefs.getInt("SecondsPlank", 0)));
                 editTextProgressionPlank.setText(String.valueOf(prefs.getFloat("ProgressionPlank", 0.0f)));

                 seriesCalves= prefs.getInt("SeriesCalves", 0);
                 repsCalves = prefs.getInt("RepsCalves", 0);
                 percentCalves= prefs.getInt("PercentCalves", 0);
                 progressionCalves = prefs.getFloat("ProgressionCalves", 0.0f);
                 editTextSeriesCalves.setText(String.valueOf(prefs.getInt("SeriesCalves", 0)));
                 editTextRepsCalves.setText(String.valueOf(prefs.getInt("RepsCalves", 0)));
                 editTextPercentCalves.setText(String.valueOf(prefs.getInt("PercentCalves", 0)));
                 editTextProgressionCalves.setText(String.valueOf(prefs.getFloat("ProgressionCalves", 0.0f)));

                 seriesYRaise= prefs.getInt("SeriesYRaise", 0);
                 repsYRaise = prefs.getInt("RepsYRaise", 0);
                 percentYRaise= prefs.getInt("PercentYRaise", 0);
                 progressionYRaise = prefs.getFloat("ProgressionYRaise", 0.0f);
                 editTextSeriesYRaise.setText(String.valueOf(prefs.getInt("SeriesYRaise", 0)));
                 editTextRepsYRaise.setText(String.valueOf(prefs.getInt("RepsYRaise", 0)));
                 editTextPercentYRaise.setText(String.valueOf(prefs.getInt("PercentYRaise", 0)));
                 editTextProgressionYRaise.setText(String.valueOf(prefs.getFloat("ProgressionYRaise", 0.0f)));

                 seriesFacepull= prefs.getInt("SeriesFacepull", 0);
                 repsFacepull = prefs.getInt("RepsFacepull", 0);
                 percentFacepull= prefs.getInt("PercentFacepull", 0);
                 progressionFacepull = prefs.getFloat("ProgressionFacepull", 0.0f);
                 editTextSeriesFacepull.setText(String.valueOf(prefs.getInt("SeriesFacepull", 0)));
                 editTextRepsFacepull.setText(String.valueOf(prefs.getInt("RepsFacepull", 0)));
                 editTextPercentFacepull.setText(String.valueOf(prefs.getInt("PercentFacepull", 0)));
                 editTextProgressionFacepull.setText(String.valueOf(prefs.getFloat("ProgressionFacepull", 0.0f)));






                 seriesSquatB = prefs.getInt("SeriesSquatB", 0);
                 repsSquatB = prefs.getInt("RepsSquatB", 0);
                 percentSquatB = prefs.getInt("PercentSquatB", 0);
                 progressionSquatB = prefs.getFloat("ProgressionSquatB", 0.0f);
                 editTextSeriesSquatB.setText(String.valueOf(prefs.getInt("SeriesSquatB", 0)));
                 editTextRepsSquatB.setText(String.valueOf(prefs.getInt("RepsSquatB", 0)));
                 editTextPercentSquatB.setText(String.valueOf(prefs.getInt("PercentSquatB", 0)));
                 editTextProgressionSquatB.setText(String.valueOf(prefs.getFloat("ProgressionSquatB", 0.0f)));

                 seriesDeadliftClassicB = prefs.getInt("SeriesDeadliftClassicB", 0);
                 repsDeadliftClassicB = prefs.getInt("RepsDeadliftClassicB", 0);
                 percentDeadliftClassicB = prefs.getInt("PercentDeadliftClassicB", 0);
                 progressionDeadliftClassicB= prefs.getFloat("ProgressionDeadliftClassicB", 0.0f);
                 editTextSeriesDeadliftClassicB.setText(String.valueOf(prefs.getInt("SeriesDeadliftClassicB", 0)));
                 editTextRepsDeadliftClassicB.setText(String.valueOf(prefs.getInt("RepsDeadliftClassicB", 0)));
                 editTextPercentDeadliftClassicB.setText(String.valueOf(prefs.getInt("PercentDeadliftClassicB", 0)));
                 editTextProgressionDeadliftClassicB.setText(String.valueOf(prefs.getFloat("ProgressionDeadliftClassicB", 0.0f)));

                 seriesBenchPressB = prefs.getInt("SeriesBenchPressB", 0);
                 repsBenchPressB = prefs.getInt("RepsBenchPressB", 0);
                 percentBenchPressB = prefs.getInt("PercentBenchPressB", 0);
                 progressionBenchPressB = prefs.getFloat("ProgressionBenchPressB", 0.0f);
                 editTextSeriesBenchPressB.setText(String.valueOf(prefs.getInt("SeriesBenchPressB", 0)));
                 editTextRepsBenchPressB.setText(String.valueOf(prefs.getInt("RepsBenchPressB", 0)));
                 editTextPercentBenchPressB.setText(String.valueOf(prefs.getInt("PercentBenchPressB", 0)));
                 editTextProgressionBenchPressB.setText(String.valueOf(prefs.getFloat("ProgressionBenchPressB", 0.0f)));

                 seriesNarrowBenchPressB = prefs.getInt("SeriesNarrowBenchPressB", 0);
                 repsNarrowBenchPressB = prefs.getInt("RepsNarrowBenchPressB", 0);
                 percentNarrowBenchPressB = prefs.getInt("PercentNarrowBenchPressB", 0);
                 progressionNarrowBenchPressB = prefs.getFloat("ProgressionNarrowBenchPressB", 0.0f);
                 editTextSeriesNarrowBenchPressB.setText(String.valueOf(prefs.getInt("SeriesNarrowBenchPressB", 0)));
                 editTextRepsNarrowBenchPressB.setText(String.valueOf(prefs.getInt("RepsNarrowBenchPressB", 0)));
                 editTextPercentNarrowBenchPressB.setText(String.valueOf(prefs.getInt("PercentNarrowBenchPressB", 0)));
                 editTextProgressionNarrowBenchPressB.setText(String.valueOf(prefs.getFloat("ProgressionNarrowBenchPressB", 0.0f)));

                 seriesOhpB = prefs.getInt("SeriesOhpB", 0);
                 repsOhpB = prefs.getInt("RepsOhpB", 0);
                 percentOhpB = prefs.getInt("PercentOhpB", 0);
                 progressionOhpB = prefs.getFloat("ProgressionOhpB", 0.0f);
                 editTextSeriesOhpB.setText(String.valueOf(prefs.getInt("SeriesOhpB", 0)));
                 editTextRepsOhpB.setText(String.valueOf(prefs.getInt("RepsOhpB", 0)));
                 editTextPercentOhpB.setText(String.valueOf(prefs.getInt("PercentOhpB", 0)));
                 editTextProgressionOhpB.setText(String.valueOf(prefs.getFloat("ProgressionOhpB", 0.0f)));

                 seriesRowingB = prefs.getInt("SeriesRowingB", 0);
                 repsRowingB = prefs.getInt("RepsRowingB", 0);
                 percentRowingB = prefs.getInt("PercentRowingB", 0);
                 progressionRowingB = prefs.getFloat("ProgressionRowingB", 0.0f);
                 editTextSeriesRowingB.setText(String.valueOf(prefs.getInt("SeriesRowingB", 0)));
                 editTextRepsRowingB.setText(String.valueOf(prefs.getInt("RepsRowingB", 0)));
                 editTextPercentRowingB.setText(String.valueOf(prefs.getInt("PercentRowingB", 0)));
                 editTextProgressionRowingB.setText(String.valueOf(prefs.getFloat("ProgressionRowingB", 0.0f)));

                 seriesPullingUpNarrowB = prefs.getInt("SeriesPullingUpNarrowB", 0);
                 repsPullingUpNarrowB = prefs.getInt("RepsPullingUpNarrowB", 0);
                 percentPullingUpNarrowB = prefs.getInt("PercentPullingUpNarrowB", 0);
                 progressionPullingUpNarrowB = prefs.getFloat("ProgressionPullingUpNarrowB", 0.0f);
                 editTextSeriesPullingUpNarrowB.setText(String.valueOf(prefs.getInt("SeriesPullingUpNarrowB", 0)));
                 editTextRepsPullingUpNarrowB.setText(String.valueOf(prefs.getInt("RepsPullingUpNarrowB", 0)));
                 editTextPercentPullingUpNarrowB.setText(String.valueOf(prefs.getInt("PercentPullingUpNarrowB", 0)));
                 editTextProgressionPullingUpNarrowB.setText(String.valueOf(prefs.getFloat("ProgressionPullingUpNarrowB", 0.0f)));

                 seriesRisingSidewaysB = prefs.getInt("SeriesRisingSidewaysB", 0);
                 repsRisingSidewaysB = prefs.getInt("RepsRisingSidewaysB", 0);
                 percentRisingSidewaysB = prefs.getInt("PercentRisingSidewaysB", 0);
                 progressionRisingSidewaysB = prefs.getFloat("ProgressionRisingSidewaysB", 0.0f);
                 editTextSeriesRisingSidewaysB.setText(String.valueOf(prefs.getInt("SeriesRisingSidewaysB", 0)));
                 editTextRepsRisingSidewaysB.setText(String.valueOf(prefs.getInt("RepsRisingSidewaysB", 0)));
                 editTextPercentRisingSidewaysB.setText(String.valueOf(prefs.getInt("PercentRisingSidewaysB", 0)));
                 editTextProgressionRisingSidewaysB.setText(String.valueOf(prefs.getFloat("ProgressionRisingSidewaysB", 0.0f)));

                 seriesBicepsB= prefs.getInt("SeriesBicepsB", 0);
                 repsBicepsB = prefs.getInt("RepsBicepsB", 0);
                 percentBicepsB = prefs.getInt("PercentBicepsB", 0);
                 progressionBicepsB = prefs.getFloat("ProgressionBicepsB", 0.0f);
                 editTextSeriesBicepsB.setText(String.valueOf(prefs.getInt("SeriesBicepsB", 0)));
                 editTextRepsBicepsB.setText(String.valueOf(prefs.getInt("RepsBicepsB", 0)));
                 editTextPercentBicepsB.setText(String.valueOf(prefs.getInt("PercentBicepsB", 0)));
                 editTextProgressionBicepsB.setText(String.valueOf(prefs.getFloat("ProgressionBicepsB", 0.0f)));

                 seriesTricepsB= prefs.getInt("SeriesTricepsB", 0);
                 repsTricepsB = prefs.getInt("RepsTricepsB", 0);
                 percentTricepsB= prefs.getInt("PercentTricepsB", 0);
                 progressionTricepsB = prefs.getFloat("ProgressionTricepsB", 0.0f);
                 editTextSeriesTricepsB.setText(String.valueOf(prefs.getInt("SeriesTricepsB", 0)));
                 editTextRepsTricepsB.setText(String.valueOf(prefs.getInt("RepsTricepsB", 0)));
                 editTextPercentTricepsB.setText(String.valueOf(prefs.getInt("PercentTricepsB", 0)));
                 editTextProgressionTricepsB.setText(String.valueOf(prefs.getFloat("ProgressionTricepsB", 0.0f)));

                 seriesAllahsB= prefs.getInt("SeriesAllahsB", 0);
                 repsAllahsB = prefs.getInt("RepsAllahsB", 0);
                 percentAllahsB= prefs.getInt("PercentAllahsB", 0);
                 progressionAllahsB = prefs.getFloat("ProgressionAllahsB", 0.0f);
                 editTextSeriesAllahsB.setText(String.valueOf(prefs.getInt("SeriesAllahsB", 0)));
                 editTextRepsAllahsB.setText(String.valueOf(prefs.getInt("RepsAllahsB", 0)));
                 editTextPercentAllahsB.setText(String.valueOf(prefs.getInt("PercentAllahsB", 0)));
                 editTextProgressionAllahsB.setText(String.valueOf(prefs.getFloat("ProgressionAllahsB", 0.0f)));

                 seriesPlankB= prefs.getInt("SeriesPlankB", 0);
                 secondsPlankB = prefs.getInt("SecondsPlankB", 0);
                 progressionPlankB = prefs.getFloat("ProgressionPlankB", 0.0f);
                 editTextSeriesPlankB.setText(String.valueOf(prefs.getInt("SeriesPlankB", 0)));
                 editTextSecondsPlankB.setText(String.valueOf(prefs.getInt("SecondsPlankB", 0)));
                 editTextProgressionPlankB.setText(String.valueOf(prefs.getFloat("ProgressionPlankB", 0.0f)));

                 seriesCalvesB= prefs.getInt("SeriesCalvesB", 0);
                 repsCalvesB = prefs.getInt("RepsCalvesB", 0);
                 percentCalvesB= prefs.getInt("PercentCalvesB", 0);
                 progressionCalvesB = prefs.getFloat("ProgressionCalvesB", 0.0f);
                 editTextSeriesCalvesB.setText(String.valueOf(prefs.getInt("SeriesCalvesB", 0)));
                 editTextRepsCalvesB.setText(String.valueOf(prefs.getInt("RepsCalvesB", 0)));
                 editTextPercentCalvesB.setText(String.valueOf(prefs.getInt("PercentCalvesB", 0)));
                 editTextProgressionCalvesB.setText(String.valueOf(prefs.getFloat("ProgressionCalvesB", 0.0f)));

                 seriesYRaiseB= prefs.getInt("SeriesYRaiseB", 0);
                 repsYRaiseB = prefs.getInt("RepsYRaiseB", 0);
                 percentYRaiseB= prefs.getInt("PercentYRaiseB", 0);
                 progressionYRaiseB = prefs.getFloat("ProgressionYRaiseB", 0.0f);
                 editTextSeriesYRaiseB.setText(String.valueOf(prefs.getInt("SeriesYRaiseB", 0)));
                 editTextRepsYRaiseB.setText(String.valueOf(prefs.getInt("RepsYRaiseB", 0)));
                 editTextPercentYRaiseB.setText(String.valueOf(prefs.getInt("PercentYRaise", 0)));
                 editTextProgressionYRaiseB.setText(String.valueOf(prefs.getFloat("ProgressionYRaiseB", 0.0f)));

                 seriesFacepullB= prefs.getInt("SeriesFacepullB", 0);
                 repsFacepullB = prefs.getInt("RepsFacepullB", 0);
                 percentFacepullB= prefs.getInt("PercentFacepullB", 0);
                 progressionFacepullB = prefs.getFloat("ProgressionFacepullB", 0.0f);
                 editTextSeriesFacepullB.setText(String.valueOf(prefs.getInt("SeriesFacepullB", 0)));
                 editTextRepsFacepullB.setText(String.valueOf(prefs.getInt("RepsFacepulLB", 0)));
                 editTextPercentFacepullB.setText(String.valueOf(prefs.getInt("PercentFacepullB", 0)));
                 editTextProgressionFacepullB.setText(String.valueOf(prefs.getFloat("ProgressionFacepullB", 0.0f)));






                 seriesSquatC = prefs.getInt("SeriesSquatC", 0);
                 repsSquatC = prefs.getInt("RepsSquatC", 0);
                 percentSquatC = prefs.getInt("PercentSquatC", 0);
                 progressionSquatC = prefs.getFloat("ProgressionSquatC", 0.0f);
                 editTextSeriesSquatC.setText(String.valueOf(prefs.getInt("SeriesSquatC", 0)));
                 editTextRepsSquatC.setText(String.valueOf(prefs.getInt("RepsSquatC", 0)));
                 editTextPercentSquatC.setText(String.valueOf(prefs.getInt("PercentSquatC", 0)));
                 editTextProgressionSquatC.setText(String.valueOf(prefs.getFloat("ProgressionSquatC", 0.0f)));

                 seriesDeadliftClassicC = prefs.getInt("SeriesDeadliftClassicC", 0);
                 repsDeadliftClassicC = prefs.getInt("RepsDeadliftClassicC", 0);
                 percentDeadliftClassicC = prefs.getInt("PercentDeadliftClassicC", 0);
                 progressionDeadliftClassicC = prefs.getFloat("ProgressionDeadliftClassicC", 0.0f);
                 editTextSeriesDeadliftClassicC.setText(String.valueOf(prefs.getInt("SeriesDeadliftClassicC", 0)));
                 editTextRepsDeadliftClassicC.setText(String.valueOf(prefs.getInt("RepsDeadliftClassicC", 0)));
                 editTextPercentDeadliftClassicC.setText(String.valueOf(prefs.getInt("PercentDeadliftClassicC", 0)));
                 editTextProgressionDeadliftClassicC.setText(String.valueOf(prefs.getFloat("ProgressionDeadliftClassicC", 0.0f)));

                 seriesBenchPressC = prefs.getInt("SeriesBenchPressC", 0);
                 repsBenchPressC = prefs.getInt("RepsBenchPressC", 0);
                 percentBenchPressC = prefs.getInt("PercentBenchPressC", 0);
                 progressionBenchPressC = prefs.getFloat("ProgressionBenchPressC", 0.0f);
                 editTextSeriesBenchPressC.setText(String.valueOf(prefs.getInt("SeriesBenchPressC", 0)));
                 editTextRepsBenchPressC.setText(String.valueOf(prefs.getInt("RepsBenchPressC", 0)));
                 editTextPercentBenchPressC.setText(String.valueOf(prefs.getInt("PercentBenchPressC", 0)));
                 editTextProgressionBenchPressC.setText(String.valueOf(prefs.getFloat("ProgressionBenchPressC", 0.0f)));

                 seriesNarrowBenchPressC = prefs.getInt("SeriesNarrowBenchPressC", 0);
                 repsNarrowBenchPressC = prefs.getInt("RepsNarrowBenchPressC", 0);
                 percentNarrowBenchPressC = prefs.getInt("PercentNarrowBenchPressC", 0);
                 progressionNarrowBenchPressC = prefs.getFloat("ProgressionNarrowBenchPressC", 0.0f);
                 editTextSeriesNarrowBenchPressC.setText(String.valueOf(prefs.getInt("SeriesNarrowBenchPressC", 0)));
                 editTextRepsNarrowBenchPressC.setText(String.valueOf(prefs.getInt("RepsNarrowBenchPressC", 0)));
                 editTextPercentNarrowBenchPressC.setText(String.valueOf(prefs.getInt("PercentNarrowBenchPressC", 0)));
                 editTextProgressionNarrowBenchPressC.setText(String.valueOf(prefs.getFloat("ProgressionNarrowBenchPressC", 0.0f)));

                 seriesOhpC = prefs.getInt("SeriesOhpC", 0);
                 repsOhpC = prefs.getInt("RepsOhpC", 0);
                 percentOhpC = prefs.getInt("PercentOhpC", 0);
                 progressionOhpC = prefs.getFloat("ProgressionOhpC", 0.0f);
                 editTextSeriesOhpC.setText(String.valueOf(prefs.getInt("SeriesOhpC", 0)));
                 editTextRepsOhpC.setText(String.valueOf(prefs.getInt("RepsOhpC", 0)));
                 editTextPercentOhpC.setText(String.valueOf(prefs.getInt("PercentOhpC", 0)));
                 editTextProgressionOhpC.setText(String.valueOf(prefs.getFloat("ProgressionOhpC", 0.0f)));

                 seriesRowingC = prefs.getInt("SeriesRowingC", 0);
                 repsRowingC = prefs.getInt("RepsRowingC", 0);
                 percentRowingC = prefs.getInt("PercentRowingC", 0);
                 progressionRowingC = prefs.getFloat("ProgressionRowingC", 0.0f);
                 editTextSeriesRowingC.setText(String.valueOf(prefs.getInt("SeriesRowingC", 0)));
                 editTextRepsRowingC.setText(String.valueOf(prefs.getInt("RepsRowingC", 0)));
                 editTextPercentRowingC.setText(String.valueOf(prefs.getInt("PercentRowingC", 0)));
                 editTextProgressionRowingC.setText(String.valueOf(prefs.getFloat("ProgressionRowingC", 0.0f)));

                 seriesPullingUpNarrowC = prefs.getInt("SeriesPullingUpNarrowC", 0);
                 repsPullingUpNarrowC = prefs.getInt("RepsPullingUpNarrowC", 0);
                 percentPullingUpNarrowC = prefs.getInt("PercentPullingUpNarrowC", 0);
                 progressionPullingUpNarrowC = prefs.getFloat("ProgressionPullingUpNarrowC", 0.0f);
                 editTextSeriesPullingUpNarrowC.setText(String.valueOf(prefs.getInt("SeriesPullingUpNarrowC", 0)));
                 editTextRepsPullingUpNarrowC.setText(String.valueOf(prefs.getInt("RepsPullingUpNarrowC", 0)));
                 editTextPercentPullingUpNarrowC.setText(String.valueOf(prefs.getInt("PercentPullingUpNarrowC", 0)));
                 editTextProgressionPullingUpNarrowC.setText(String.valueOf(prefs.getFloat("ProgressionPullingUpNarrowC", 0.0f)));

                 seriesRisingSidewaysC= prefs.getInt("SeriesRisingSidewaysC", 0);
                 repsRisingSidewaysC= prefs.getInt("RepsRisingSidewaysC", 0);
                 percentRisingSidewaysC = prefs.getInt("PercentRisingSidewaysC", 0);
                 progressionRisingSidewaysC = prefs.getFloat("ProgressionRisingSidewaysC", 0.0f);
                 editTextSeriesRisingSidewaysC.setText(String.valueOf(prefs.getInt("SeriesRisingSidewaysC", 0)));
                 editTextRepsRisingSidewaysC.setText(String.valueOf(prefs.getInt("RepsRisingSidewaysC", 0)));
                 editTextPercentRisingSidewaysC.setText(String.valueOf(prefs.getInt("PercentRisingSidewaysC", 0)));
                 editTextProgressionRisingSidewaysC.setText(String.valueOf(prefs.getFloat("ProgressionRisingSidewaysC", 0.0f)));

                 seriesBicepsC= prefs.getInt("SeriesBicepsC", 0);
                 repsBicepsC = prefs.getInt("RepsBicepsC", 0);
                 percentBicepsC = prefs.getInt("PercentBicepsC", 0);
                 progressionBicepsC = prefs.getFloat("ProgressionBicepsC", 0.0f);
                 editTextSeriesBicepsC.setText(String.valueOf(prefs.getInt("SeriesBicepsC", 0)));
                 editTextRepsBicepsC.setText(String.valueOf(prefs.getInt("RepsBicepsC", 0)));
                 editTextPercentBicepsC.setText(String.valueOf(prefs.getInt("PercentBicepsC", 0)));
                 editTextProgressionBicepsC.setText(String.valueOf(prefs.getFloat("ProgressionBicepsC", 0.0f)));

                 seriesTricepsC= prefs.getInt("SeriesTricepsC", 0);
                 repsTricepsC = prefs.getInt("RepsTricepC", 0);
                 percentTricepsC= prefs.getInt("PercentTricepsC", 0);
                 progressionTricepsC = prefs.getFloat("ProgressionTricepsC", 0.0f);
                 editTextSeriesTricepsC.setText(String.valueOf(prefs.getInt("SeriesTricepsC", 0)));
                 editTextRepsTricepsC.setText(String.valueOf(prefs.getInt("RepsTricepsC", 0)));
                 editTextPercentTricepsC.setText(String.valueOf(prefs.getInt("PercentTricepsC", 0)));
                 editTextProgressionTricepsC.setText(String.valueOf(prefs.getFloat("ProgressionTricepsC", 0.0f)));

                 seriesAllahsC= prefs.getInt("SeriesAllahsC", 0);
                 repsAllahsC = prefs.getInt("RepsAllahsC", 0);
                 percentAllahsC= prefs.getInt("PercentAllahsC", 0);
                 progressionAllahsC = prefs.getFloat("ProgressionAllahsC", 0.0f);
                 editTextSeriesAllahsC.setText(String.valueOf(prefs.getInt("SeriesAllahsC", 0)));
                 editTextRepsAllahsC.setText(String.valueOf(prefs.getInt("RepsAllahsC", 0)));
                 editTextPercentAllahsC.setText(String.valueOf(prefs.getInt("PercentAllahsC", 0)));
                 editTextProgressionAllahsC.setText(String.valueOf(prefs.getFloat("ProgressionAllahsC", 0.0f)));

                 seriesPlankC= prefs.getInt("SeriesPlankC", 0);
                 secondsPlankC = prefs.getInt("SecondsPlankC", 0);
                 progressionPlankC = prefs.getFloat("ProgressionPlankC", 0.0f);
                 editTextSeriesPlankC.setText(String.valueOf(prefs.getInt("SeriesPlankC", 0)));
                 editTextSecondsPlankC.setText(String.valueOf(prefs.getInt("SecondsPlankC", 0)));
                 editTextProgressionPlankC.setText(String.valueOf(prefs.getFloat("ProgressionPlankC", 0.0f)));

                 seriesCalvesC= prefs.getInt("SeriesCalvesC", 0);
                 repsCalvesC = prefs.getInt("RepsCalvesC", 0);
                 percentCalvesC= prefs.getInt("PercentCalvesC", 0);
                 progressionCalvesC = prefs.getFloat("ProgressionCalvesC", 0.0f);
                 editTextSeriesCalvesC.setText(String.valueOf(prefs.getInt("SeriesCalvesC", 0)));
                 editTextRepsCalvesC.setText(String.valueOf(prefs.getInt("RepsCalvesC", 0)));
                 editTextPercentCalvesC.setText(String.valueOf(prefs.getInt("PercentCalvesC", 0)));
                 editTextProgressionCalvesC.setText(String.valueOf(prefs.getFloat("ProgressionCalvesC", 0.0f)));

                 seriesYRaiseC= prefs.getInt("SeriesYRaiseC", 0);
                 repsYRaiseC = prefs.getInt("RepsYRaiseC", 0);
                 percentYRaiseC= prefs.getInt("PercentYRaiseC", 0);
                 progressionYRaiseC = prefs.getFloat("ProgressionYRaiseC", 0.0f);
                 editTextSeriesYRaiseC.setText(String.valueOf(prefs.getInt("SeriesYRaiseC", 0)));
                 editTextRepsYRaiseC.setText(String.valueOf(prefs.getInt("RepsYRaiseC", 0)));
                 editTextPercentYRaiseC.setText(String.valueOf(prefs.getInt("PercentYRaiseC", 0)));
                 editTextProgressionYRaiseC.setText(String.valueOf(prefs.getFloat("ProgressionYRaiseC", 0.0f)));

                 seriesFacepullC= prefs.getInt("SeriesFacepullC", 0);
                 repsFacepullC = prefs.getInt("RepsFacepullC", 0);
                 percentFacepullC= prefs.getInt("PercentFacepullC", 0);
                 progressionFacepullC = prefs.getFloat("ProgressionFacepullC", 0.0f);
                 editTextSeriesFacepullC.setText(String.valueOf(prefs.getInt("SeriesFacepullC", 0)));
                 editTextRepsFacepullC.setText(String.valueOf(prefs.getInt("RepsFacepullC", 0)));
                 editTextPercentFacepullC.setText(String.valueOf(prefs.getInt("PercentFacepullC", 0)));
                 editTextProgressionFacepullC.setText(String.valueOf(prefs.getFloat("ProgressionFacepullC", 0.0f)));







                 seriesSquatD = prefs.getInt("SeriesSquatD", 0);
                 repsSquatD = prefs.getInt("RepsSquatD", 0);
                 percentSquatD = prefs.getInt("PercentSquatD", 0);
                 progressionSquatD = prefs.getFloat("ProgressionSquatD", 0.0f);
                 editTextSeriesSquatD.setText(String.valueOf(prefs.getInt("SeriesSquatD", 0)));
                 editTextRepsSquatD.setText(String.valueOf(prefs.getInt("RepsSquatD", 0)));
                 editTextPercentSquatD.setText(String.valueOf(prefs.getInt("PercentSquatD", 0)));
                 editTextProgressionSquatD.setText(String.valueOf(prefs.getFloat("ProgressionSquatD", 0.0f)));

                 seriesDeadliftClassicD = prefs.getInt("SeriesDeadliftClassicD", 0);
                 repsDeadliftClassicD = prefs.getInt("RepsDeadliftClassicD", 0);
                 percentDeadliftClassicD = prefs.getInt("PercentDeadliftClassicD", 0);
                 progressionDeadliftClassicD = prefs.getFloat("ProgressionDeadliftClassicD", 0.0f);
                 editTextSeriesDeadliftClassicD.setText(String.valueOf(prefs.getInt("SeriesDeadliftClassicD", 0)));
                 editTextRepsDeadliftClassicD.setText(String.valueOf(prefs.getInt("RepsDeadliftClassicD", 0)));
                 editTextPercentDeadliftClassicD.setText(String.valueOf(prefs.getInt("PercentDeadliftClassicD", 0)));
                 editTextProgressionDeadliftClassicD.setText(String.valueOf(prefs.getFloat("ProgressionDeadliftClassicD", 0.0f)));

                 seriesBenchPressD = prefs.getInt("SeriesBenchPressD", 0);
                 repsBenchPressD = prefs.getInt("RepsBenchPressD", 0);
                 percentBenchPressD = prefs.getInt("PercentBenchPressD", 0);
                 progressionBenchPressD = prefs.getFloat("ProgressionBenchPressD", 0.0f);
                 editTextSeriesBenchPressD.setText(String.valueOf(prefs.getInt("SeriesBenchPressD", 0)));
                 editTextRepsBenchPressD.setText(String.valueOf(prefs.getInt("RepsBenchPressD", 0)));
                 editTextPercentBenchPressD.setText(String.valueOf(prefs.getInt("PercentBenchPressD", 0)));
                 editTextProgressionBenchPressD.setText(String.valueOf(prefs.getFloat("ProgressionBenchPressD", 0.0f)));

                 seriesNarrowBenchPressD = prefs.getInt("SeriesNarrowBenchPressD", 0);
                 repsNarrowBenchPressD = prefs.getInt("RepsNarrowBenchPressD", 0);
                 percentNarrowBenchPressD = prefs.getInt("PercentNarrowBenchPressD", 0);
                 progressionNarrowBenchPressD = prefs.getFloat("ProgressionNarrowBenchPressD", 0.0f);
                 editTextSeriesNarrowBenchPressD.setText(String.valueOf(prefs.getInt("SeriesNarrowBenchPressD", 0)));
                 editTextRepsNarrowBenchPressD.setText(String.valueOf(prefs.getInt("RepsNarrowBenchPressD", 0)));
                 editTextPercentNarrowBenchPressD.setText(String.valueOf(prefs.getInt("PercentNarrowBenchPressD", 0)));
                 editTextProgressionNarrowBenchPressD.setText(String.valueOf(prefs.getFloat("ProgressionNarrowBenchPressD", 0.0f)));

                 seriesOhpD = prefs.getInt("SeriesOhpD", 0);
                 repsOhpD = prefs.getInt("RepsOhpD", 0);
                 percentOhpD = prefs.getInt("PercentOhpD", 0);
                 progressionOhpD = prefs.getFloat("ProgressionOhpD", 0.0f);
                 editTextSeriesOhpD.setText(String.valueOf(prefs.getInt("SeriesOhpD", 0)));
                 editTextRepsOhpD.setText(String.valueOf(prefs.getInt("RepsOhpD", 0)));
                 editTextPercentOhpD.setText(String.valueOf(prefs.getInt("PercentOhpD", 0)));
                 editTextProgressionOhpD.setText(String.valueOf(prefs.getFloat("ProgressionOhpD", 0.0f)));

                 seriesRowingD = prefs.getInt("SeriesRowingD", 0);
                 repsRowingD = prefs.getInt("RepsRowingD", 0);
                 percentRowingD = prefs.getInt("PercentRowingD", 0);
                 progressionRowingD = prefs.getFloat("ProgressionRowingD", 0.0f);
                 editTextSeriesRowingD.setText(String.valueOf(prefs.getInt("SeriesRowingD", 0)));
                 editTextRepsRowingD.setText(String.valueOf(prefs.getInt("RepsRowingD", 0)));
                 editTextPercentRowingD.setText(String.valueOf(prefs.getInt("PercentRowingD", 0)));
                 editTextProgressionRowingD.setText(String.valueOf(prefs.getFloat("ProgressionRowingD", 0.0f)));

                 seriesPullingUpNarrowD = prefs.getInt("SeriesPullingUpNarrowD", 0);
                 repsPullingUpNarrowD = prefs.getInt("RepsPullingUpNarrowD", 0);
                 percentPullingUpNarrowD = prefs.getInt("PercentPullingUpNarrowD", 0);
                 progressionPullingUpNarrowD = prefs.getFloat("ProgressionPullingUpNarrowD", 0.0f);
                 editTextSeriesPullingUpNarrowD.setText(String.valueOf(prefs.getInt("SeriesPullingUpNarrowD", 0)));
                 editTextRepsPullingUpNarrowD.setText(String.valueOf(prefs.getInt("RepsPullingUpNarrowD", 0)));
                 editTextPercentPullingUpNarrowD.setText(String.valueOf(prefs.getInt("PercentPullingUpNarrowD", 0)));
                 editTextProgressionPullingUpNarrowD.setText(String.valueOf(prefs.getFloat("ProgressionPullingUpNarrowD", 0.0f)));

                 seriesRisingSidewaysD= prefs.getInt("SeriesRisingSidewaysD", 0);
                 repsRisingSidewaysD = prefs.getInt("RepsRisingSidewaysD", 0);
                 percentRisingSidewaysD = prefs.getInt("PercentRisingSidewaysD", 0);
                 progressionRisingSidewaysD = prefs.getFloat("ProgressionRisingSidewaysD", 0.0f);
                 editTextSeriesRisingSidewaysD.setText(String.valueOf(prefs.getInt("SeriesRisingSidewaysD", 0)));
                 editTextRepsRisingSidewaysD.setText(String.valueOf(prefs.getInt("RepsRisingSidewaysD", 0)));
                 editTextPercentRisingSidewaysD.setText(String.valueOf(prefs.getInt("PercentRisingSidewaysD", 0)));
                 editTextProgressionRisingSidewaysD.setText(String.valueOf(prefs.getFloat("ProgressionRisingSidewaysD", 0.0f)));

                 seriesBicepsD= prefs.getInt("SeriesBicepsD", 0);
                 repsBicepsD = prefs.getInt("RepsBicepsD", 0);
                 percentBicepsD = prefs.getInt("PercentBicepsD", 0);
                 progressionBicepsD = prefs.getFloat("ProgressionBicepsD", 0.0f);
                 editTextSeriesBicepsD.setText(String.valueOf(prefs.getInt("SeriesBicepsD", 0)));
                 editTextRepsBicepsD.setText(String.valueOf(prefs.getInt("RepsBicepsD", 0)));
                 editTextPercentBicepsD.setText(String.valueOf(prefs.getInt("PercentBicepsD", 0)));
                 editTextProgressionBicepsD.setText(String.valueOf(prefs.getFloat("ProgressionBicepsD", 0.0f)));

                 seriesTricepsD= prefs.getInt("SeriesTricepsD", 0);
                 repsTricepsD = prefs.getInt("RepsTricepsD", 0);
                 percentTricepsD= prefs.getInt("PercentTricepsD", 0);
                 progressionTricepsD = prefs.getFloat("ProgressionTricepsD", 0.0f);
                 editTextSeriesTricepsD.setText(String.valueOf(prefs.getInt("SeriesTricepsD", 0)));
                 editTextRepsTricepsD.setText(String.valueOf(prefs.getInt("RepsTricepsD", 0)));
                 editTextPercentTricepsD.setText(String.valueOf(prefs.getInt("PercentTricepsD", 0)));
                 editTextProgressionTricepsD.setText(String.valueOf(prefs.getFloat("ProgressionTricepsD", 0.0f)));

                 seriesAllahsD= prefs.getInt("SeriesAllahsD", 0);
                 repsAllahsD = prefs.getInt("RepsAllahsD", 0);
                 percentAllahsD= prefs.getInt("PercentAllahsD", 0);
                 progressionAllahsD = prefs.getFloat("ProgressionAllahsD", 0.0f);
                 editTextSeriesAllahsD.setText(String.valueOf(prefs.getInt("SeriesAllahsD", 0)));
                 editTextRepsAllahsD.setText(String.valueOf(prefs.getInt("RepsAllahsD", 0)));
                 editTextPercentAllahsD.setText(String.valueOf(prefs.getInt("PercentAllahsD", 0)));
                 editTextProgressionAllahsD.setText(String.valueOf(prefs.getFloat("ProgressionAllahsD", 0.0f)));

                 seriesPlankD= prefs.getInt("SeriesPlankD", 0);
                 secondsPlankD = prefs.getInt("SecondsPlankD", 0);
                 progressionPlankD = prefs.getFloat("ProgressionPlankD", 0.0f);
                 editTextSeriesPlankD.setText(String.valueOf(prefs.getInt("SeriesPlankD", 0)));
                 editTextSecondsPlankD.setText(String.valueOf(prefs.getInt("SecondsPlankD", 0)));
                 editTextProgressionPlankD.setText(String.valueOf(prefs.getFloat("ProgressionPlankD", 0.0f)));

                 seriesCalvesD= prefs.getInt("SeriesCalvesD", 0);
                 repsCalvesD = prefs.getInt("RepsCalvesD", 0);
                 percentCalvesD= prefs.getInt("PercentCalvesD", 0);
                 progressionCalvesD = prefs.getFloat("ProgressionCalvesD", 0.0f);
                 editTextSeriesCalvesD.setText(String.valueOf(prefs.getInt("SeriesCalvesD", 0)));
                 editTextRepsCalvesD.setText(String.valueOf(prefs.getInt("RepsCalvesD", 0)));
                 editTextPercentCalvesD.setText(String.valueOf(prefs.getInt("PercentCalvesD", 0)));
                 editTextProgressionCalvesD.setText(String.valueOf(prefs.getFloat("ProgressionCalvesD", 0.0f)));

                 seriesYRaiseD= prefs.getInt("SeriesYRaiseD", 0);
                 repsYRaiseD = prefs.getInt("RepsYRaiseD", 0);
                 percentYRaiseD= prefs.getInt("PercentYRaiseD", 0);
                 progressionYRaiseD = prefs.getFloat("ProgressionYRaiseD", 0.0f);
                 editTextSeriesYRaiseD.setText(String.valueOf(prefs.getInt("SeriesYRaiseD", 0)));
                 editTextRepsYRaiseD.setText(String.valueOf(prefs.getInt("RepsYRaiseD", 0)));
                 editTextPercentYRaiseD.setText(String.valueOf(prefs.getInt("PercentYRaiseD", 0)));
                 editTextProgressionYRaiseD.setText(String.valueOf(prefs.getFloat("ProgressionYRaiseD", 0.0f)));

                 seriesFacepullD= prefs.getInt("SeriesFacepullD", 0);
                 repsFacepullD = prefs.getInt("RepsFacepullD", 0);
                 percentFacepullD= prefs.getInt("PercentFacepullD", 0);
                 progressionFacepullD = prefs.getFloat("ProgressionFacepullD", 0.0f);
                 editTextSeriesFacepullD.setText(String.valueOf(prefs.getInt("SeriesFacepullD", 0)));
                 editTextRepsFacepullD.setText(String.valueOf(prefs.getInt("RepsFacepullD", 0)));
                 editTextPercentFacepullD.setText(String.valueOf(prefs.getInt("PercentFacepullD", 0)));
                 editTextProgressionFacepullD.setText(String.valueOf(prefs.getFloat("ProgressionFacepullD", 0.0f)));


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
