package ca.uottawa.anish006.lab1.model;

public class Logic {

    private  double montant;
    private double pourcent;
    private int nombre;
    private double tip;
    private double total;
    private float evaluation;

    public Logic(Double amount, double percentage, int quantity){
        this.montant = amount;
        this.pourcent = percentage;
        this.nombre = quantity;
        tip = 0.0;
        total = 0.0;
    }

    public double getAmount(){
        return montant;
    }



    public double getTip(){
        tip = pourcent * montant;
        return tip;
    }

    public double getTotalAmount(){
        total = montant + tip ;
        return total;
            }

            public void setEvaluation(float eval){
               evaluation = eval;
            }



            public double getTipPerP(){
        return tip / nombre;
            }

            public double getAmountPerP(){
                return total / nombre;
            }


            public double getTipbyEvaluation(){
        tip = 10 +(evaluation * 2);
        return tip ;
           }




}
