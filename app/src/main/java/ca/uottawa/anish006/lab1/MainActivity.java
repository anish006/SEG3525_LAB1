package ca.uottawa.anish006.lab1;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    private double amount;
    private double percentage;
    private int quantity;
    private RatingBar ratBar;
    private float val;
    private logic logique;
    public static final String MyPREFERENCES = "MyPrefs" ;



    SharedPreferences sharedpreferences;
    EditText facture, pourcentage, number,  pourcentageperdef;
    TextView result_1, result_2, result_3, result_4, result_5, result_6;
    Button buttonSubmit, btnBack, btnsettings, btnchoice, btnratings, btneval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        facture = (EditText) findViewById(R.id.editText);
        pourcentage = (EditText) findViewById(R.id.editText3);
        number = (EditText) findViewById(R.id.editText5);

        buttonSubmit = (Button) findViewById(R.id.button);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                amount = Double.parseDouble(facture.getText().toString());
                percentage = Double.parseDouble(pourcentage.getText().toString()) / 100;
                quantity = Integer.parseInt(number.getText().toString());
                 logique = new logic(amount, percentage, quantity);

                setContentView(R.layout.activity_logic);
                result_1 = (TextView) findViewById(R.id.montant);
                result_1.setText("$ " + String.valueOf(logique.getAmount()));
                result_2 = (TextView) findViewById(R.id.pourboire);
                result_2.setText("$ " + String.valueOf(logique.getTip()));
                result_3 = (TextView) findViewById(R.id.total_amount);
                result_3.setText("$ " + String.valueOf(logique.getTotalAmount()));
                result_4 = (TextView) findViewById(R.id.prb_par_pers);
                result_4.setText("$ " + String.valueOf(logique.getTipPerP()));
                result_5 = (TextView) findViewById(R.id.mont_par_pers);
                result_5.setText("$ " + String.valueOf(logique.getAmountPerP()));

                btnBack = (Button) findViewById(R.id.back);

                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View s) {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
            }


        });



        btnsettings = (Button) findViewById(R.id.button2);

        btnsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View z) {

                setContentView(R.layout.activity_settings);

                pourcentageperdef = (EditText) findViewById(R.id.prcprdef);



                btnchoice = (Button) findViewById(R.id.button3);

                btnchoice.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View w) {

                        if(pourcentageperdef.getText().toString().trim().length() == 0) {

                            setContentView(R.layout.activity_evaluation);

                            ratBar = (RatingBar) findViewById(R.id.ratingBar);

                            btnratings = (Button) findViewById(R.id.eval);

                            btnratings.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View d) {

                                    setContentView(R.layout.activity_hint);
                                    result_6 = (TextView) findViewById(R.id.value);
                                    result_6.setText((10 + ratBar.getRating() * 2) + " %");

                                    btneval = (Button) findViewById(R.id.main);

                                    btneval.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View o) {

                                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(intent);


                                        }
                                    });

                                }
                            });

                        }

                        else{
                            /*
                            *  kevin gatera
                            *
                            *
                            *
                            * */
                        }
                    }
                });


            }

        });

    }

    /*private void updateInfo(String devise, int pourcent_perdef) {
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("infos");
        setting set = new setting(devise, pourcent_perdef);
        dR.child("devise").setValue(set.getDevise());
        dR.child("pourcent_par_déf").setValue(set.getPourc());
        Toast.makeText(getApplicationContext(), "Product updated", Toast.LENGTH_LONG).show();
    }*/





}

