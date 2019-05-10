package com.example.sudokubis;

public class Case{
    private int valeur;
    private String couleur;
    private boolean bloque;

    Case(){
        valeur = (int) (Math.random() * 9)+1;
        couleur = "blanc";
        bloque = false;
    }

    Case(int i){
        valeur = i;
        couleur = "blanc";
        bloque = false;
    }

    public String toString(){
        return valeur+"";
    }

    public int getValeur(){
        return valeur;
    }

    public boolean getBloque(){
        return bloque;
    }

    public void setBloque(boolean bloque){ this.bloque = bloque;}

    public void setValeur(int valeur){
        this.valeur = valeur;
    }
}