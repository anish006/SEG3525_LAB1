package ca.uottawa.anish006.lab1.model;

public class setting {

    private  String devise;
    private int pourcent;


    public setting(String monnaie, int pourc){
        this.devise = monnaie;
        this.pourcent = pourc;

    }

    public void setDevise(String cash ){
        devise = cash;    }

    public String getDevise(){
        return devise;    }



    public void setPourc(int prc){
        pourcent = prc;
         }

    public int getPourc(){

        return pourcent;
    }

}
