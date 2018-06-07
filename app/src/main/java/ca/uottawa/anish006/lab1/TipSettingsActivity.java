package ca.uottawa.anish006.lab1;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

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
                final android.app.AlertDialog.Builder mBuilder = new android.app.AlertDialog.Builder(getApplication());
                View mView = LayoutInflater.from(getApplication()).inflate(R.layout.activity_hint, null);

                ratingBar = mView.findViewById(R.id.ratingBar);
                String ratingBarTip = 10 + ratingBar.getRating() * 2 + " %";
                TextView suggestedTip = mView.findViewById(R.id.suggestedTipValue);
                suggestedTip.setText(suggestedTip.getText().toString() + ratingBarTip);

                final Button submitEvaluationButton = mView.findViewById(R.id.submitButton);

                mBuilder.setView(mView);
                final AlertDialog congratulationDialog = mBuilder.create();

                Button backButton = mView.findViewById(R.id.backButton);
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        congratulationDialog.dismiss();

                        Intent intent = new Intent(getApplication(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        intent.putExtra("defaultTipAmount", defaultTipAmount.getText());

                        startActivity(intent);
                    }
                });

                congratulationDialog.show();
            }
        });

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplication(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.putExtra("defaultTipAmount", defaultTipAmount.getText());

                startActivity(intent);
            }
        });

    }
}
