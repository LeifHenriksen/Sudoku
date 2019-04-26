package fr.jerems.sudokuvfinale;

public class Case {
    private boolean estModifiable;
    private int couleur; //0 =  white, 1 = blue, 2 = red;
    private String valeur;
    private String valeurReponse;


    public Case(boolean estModifiable, String valeur, String valeurReponse)
    {
        this.estModifiable = estModifiable;

        if(this.estModifiable)
            couleur = 0;
        else
            couleur = 1;

        this.valeur = valeur;
        this.valeurReponse = valeurReponse;
    }

    public boolean estModifiable() {
        return estModifiable;
    }

    public void devenirNonModifiable(){
        estModifiable = false;
    }

    public String getValeur(){
        return valeur;
    }

    public void setValeur(String val){
        valeur = val;
    }

    public String getValeurReponse(){
        return valeurReponse;
    }

    public boolean estLaReponse(String val){
        return (valeurReponse.equals(val));
    }

    public void setCouleur(int col){
        couleur = col;
    }

    public int getCouleur(){
        return couleur;
    }
}
