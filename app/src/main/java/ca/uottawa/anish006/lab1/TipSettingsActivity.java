package ca.uottawa.anish006.lab1;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class TipSettingsActivity extends AppCompatActivity {

    Button submitButton;
    Button evaluateButton;

    TextView value;

    RatingBar ratingBar;

    EditText defaultTipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_settings);

        evaluateButton = findViewById(R.id.evaluationButton);

        defaultTipAmount = findViewById(R.id.defaultTipAmount);

        evaluateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.app.AlertDialog.Builder mBuilder = new android.app.AlertDialog.Builder(TipSettingsActivity.this);
                View mView = LayoutInflater.from(TipSettingsActivity.this).inflate(R.layout.modal_ratingbar_evaluation, null);

                ratingBar = mView.findViewById(R.id.ratingBar);
                final Float ratingBarTip = 10 + ratingBar.getRating() * 2;

                mBuilder.setView(mView);
                final AlertDialog evaluationDialog = mBuilder.create();

                evaluationDialog.show();

                Button submitRatingButton = mView.findViewById(R.id.submitRatingButton);
                submitRatingButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        evaluationDialog.dismiss();

                        // Go to main
                        Intent intent = new Intent(getApplication(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        intent.putExtra("defaultTipAmount", ratingBarTip);

                        startActivity(intent);

                        Toast.makeText(getBaseContext(),"Suggested tip is " + ratingBarTip + " % Thanks!", Toast.LENGTH_LONG).show();
                    }
                });
            }

        });

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.putExtra("defaultTipAmount", defaultTipAmount.getText().toString());

                startActivity(intent);
            }
        });

    }
}
