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
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // this will be key for the key value pair
    public static final String BUTTON_STATE_M = "Button_State_m";
    public static final String BUTTON_STATE_F = "Button_State_f";
    // this is name of shared preferences file, must be same whenever accessing
    // the key value pair.
    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        // helper method to open up the file.
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        // grab the last saved state here on each activity start
        Boolean lastButtonStateM = sharedpreferences.getBoolean(BUTTON_STATE_M, false);
        Boolean lastButtonStateF = sharedpreferences.getBoolean(BUTTON_STATE_F, false);
        final RadioButton rbm = (RadioButton) findViewById(R.id.radioButtonMale);
        final RadioButton rbf = (RadioButton) findViewById(R.id.radioButtonFemale);
        // restore previous state
        rbm.setChecked(lastButtonStateM);
        rbf.setChecked(lastButtonStateF);
        // set a listener
        rbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call this to enable editing of the shared preferences file
                // in the event of a change
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Boolean isChecked = rbm.isChecked();
                Boolean isNoChecked = rbf.isChecked();
                // use this to add the new state
                editor.putBoolean(BUTTON_STATE_F, isNoChecked);
                editor.putBoolean(BUTTON_STATE_M, isChecked);
                // save
                editor.apply();
            }


        });


        rbf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // call this to enable editing of the shared preferences file
                // in the event of a change
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Boolean isChecked = rbf.isChecked();
                Boolean isNoChecked = rbm.isChecked();
                // use this to add the new state
                editor.putBoolean(BUTTON_STATE_M, isNoChecked);
                editor.putBoolean(BUTTON_STATE_F, isChecked);
                // save
                editor.apply();
            }


        });





        final SharedPreferences prefsAge = PreferenceManager
                .getDefaultSharedPreferences(this);

        EditText age = (EditText) findViewById(R.id.editTextAge);
        age.setText(prefsAge.getString("autoSaveAge", ""));
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
                prefsAge.edit().putString("autoSaveAge", s.toString()).apply();
            }
        });


        final SharedPreferences prefsHeight = PreferenceManager
                .getDefaultSharedPreferences(this);

        EditText height = (EditText) findViewById(R.id.editTextHeight);
        height.setText(prefsHeight.getString("autoSaveHeight", ""));
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
                prefsHeight.edit().putString("autoSaveHeight", s.toString()).apply();
            }
        });

        final SharedPreferences prefsWeight = PreferenceManager
                .getDefaultSharedPreferences(this);

        EditText weight = (EditText) findViewById(R.id.editTextWeight);
        weight.setText(prefsWeight.getString("autoSaveWeight", ""));
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
                prefsWeight.edit().putString("autoSaveWeight", s.toString()).apply();
            }
        });



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
