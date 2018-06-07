package ca.uottawa.anish006.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG";

    EditText billAmount;
    EditText tipAmount;
    EditText peopleNumber;

    Button settingsButton;
    Button submitButton;

    // public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        billAmount = findViewById(R.id.billAmount);
        tipAmount = findViewById(R.id.tipAmount);
        peopleNumber = findViewById(R.id.peopleNumber);

        Intent intent = getIntent();

        String defaultTipAmountAsString = intent.getStringExtra("defaultTipAmount");

        if(defaultTipAmountAsString != null && !defaultTipAmountAsString.isEmpty()){

            Log.e("TEST", "" + intent.getStringExtra("defaultTipAmount"));

            Double defaultTipAmount = Double.parseDouble(intent.getStringExtra("defaultTipAmount"));

            Log.e("DEBUG", "defaultTipAmount is " + defaultTipAmount);

            tipAmount.setText(defaultTipAmount.toString());
        }

        settingsButton = findViewById(R.id.settingsButton);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), TipSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(), BillResultActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.putExtra("billAmount", billAmount.getText().toString());
                intent.putExtra("tipAmount", tipAmount.getText().toString());
                intent.putExtra("peopleNumber", peopleNumber.getText().toString());

                startActivity(intent);
            }
        });

    }

}
