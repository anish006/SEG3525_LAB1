package ca.uottawa.anish006.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ca.uottawa.anish006.lab1.model.Logic;

public class BillResultActivity extends AppCompatActivity {

    Double billAmount;
    Double tipAmount;
    int peopleNumber;

    Button backButton;

    TextView result_1;
    TextView result_2;
    TextView result_3;
    TextView result_4;
    TextView result_5;

    private Logic logique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bill_result);

        Intent intent = getIntent();

        billAmount = Double.valueOf(Float.parseFloat(intent.getStringExtra("billAmount")));
        tipAmount = Double.parseDouble(intent.getStringExtra("tipAmount")) / 100;
        peopleNumber = Integer.parseInt(intent.getStringExtra("peopleNumber"));

        logique = new Logic(billAmount, tipAmount, peopleNumber);

        result_1 = findViewById(R.id.montant);
        result_1.setText("$ " + String.valueOf(logique.getAmount()));

        result_2 = findViewById(R.id.pourboire);
        result_2.setText("$ " + String.valueOf(logique.getTip()));

        result_3 = findViewById(R.id.total_amount);
        result_3.setText("$ " + String.valueOf(logique.getTotalAmount()));

        result_4 = findViewById(R.id.prb_par_pers);
        result_4.setText("$ " + String.valueOf(logique.getTipPerP()));

        result_5 = findViewById(R.id.mont_par_pers);
        result_5.setText("$ " + String.valueOf(logique.getAmountPerP()));

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View s) {
                        Intent intent = new Intent(getApplication(), MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
        });
    }
}
