package com.example.sudokubis;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Sudo3x3{

    private Case[][] tabC = new Case[9][9];
    //private String[] listeTab = new String[81];


    Sudo3x3(int n){
        int[][] tabh = new int[9][9];

        for (int j = 0;j < 9 ; j++ ) {
            for (int k = 0;k < 9 ;k++ ) {
                tabC[j][k] = new Case(0);
            }
        }
        for (int i = 0;i < 10;i++ ) {
            rempli(tabC);
        }
        tabh = convertInt(); //on copie tabC dans tabh
        resoudre(tabh, 0);
        convertCase(tabh);
        vide(n);
        bloqueCase();

    }

    //cette fonction permet de savoir si il y' a un chiffre en double sur une ligne
    public static boolean checkLigne(int i, int j, Case[][] tab){
        boolean check = true;
        for (int x = 0;x < 9 ;x++ ) {
            if( (tab[i][x].getValeur()==tab[i][j].getValeur())  && j!=x){
                check = false;
            }
        }
        return check;
    }

    //cette fonction permet de savoir si il y' a un chiffre en double sur une colonne
    public static boolean checkColonne(int i, int j, Case[][] tab){
        boolean check = true;
        for (int x =0 ;x <9 ;x++ ) {
            if ( (tab[x][j].getValeur()==tab[i][j].getValeur()) && i!=x) {
                check = false;
            }
        }
        return check;
    }

    //cette fonction permet de savoir si il y' a un chiffre en double dans un block
    public static boolean checkBlock(int i, int j, Case [][] tab){
        boolean check = true;
        int i2 = i-(i%3), j2 = j-(j%3);
        for (int a = i2;a < i2+3 ;a++ ) {
            for (int b = j2; b< j2+3 ;b++ ) {
                if( (tab[a][b].getValeur()==tab[i][j].getValeur()) && (a!=i || b!=j)){
                    check= false;
                }
            }
        }
        return check;
    }

    public String toString(){
        String res ="";
        for (int i = 0;i < 9 ;i++ ) {
            for (int j = 0; j< 9; j++) {
                res+= tabC[i][j]+"|";
            }
            res+="\n";
        }
        return res;
    }

    //va convertir notre tableau de case en list epour ensuite pouvoir utiliser cette liste pour l'affichage
    public List<String> convert(){
        List<String> convS = new ArrayList<String>();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(tabC[i][j].getValeur()==0){
                    convS.add("");
                }else{
                    convS.add(String.valueOf(tabC[i][j].getValeur()));
                }
            }
        }
        return convS;
    }

    public Case getCase(int position){
        int i = position%9; int j = position/9;
        return tabC[j][i];
    }

    //nous retourne le tableau en entier de case
    public Case[][] getTab(){
        return tabC;
    }

    //rempli aléatoirement des case avec un chiffre compris entre 1-9
    public void rempli(Case[][] tab){
        int i = (int) (Math.random() * 9);
        int j = (int) (Math.random() * 9);
        Case c = new Case();

        if(tab[i][j].getValeur() == 0){
            tab[i][j] = c;
            while(!checkLigne(i,j,tab) || !checkBlock(i,j, tab) || !checkColonne(i,j,tab)){
                c.setValeur((int)(Math.random()*9+1));
                tab[i][j] = c;
            }
        }else{
            rempli(tabC);
        }
    }

    //cette focntion est comme chekligne plus haut mais ici nous aidera pour la backtrack
    public static boolean checkLigne(int i, int j, int[][] tab, int k){
        boolean check = true;
        for (int x = 0;x < 9 ;x++ ) {
            if( (tab[i][x]==k)  && j!=x){
                check = false;
            }
        }
        return check;
    }

    public static boolean checkColonne(int i, int j, int[][] tab, int k){
        boolean check = true;
        for (int x =0 ;x <9 ;x++ ) {
            if ( (tab[x][j]==k) && i!=x) {
                check = false;
            }
        }
        return check;
    }

    public static boolean checkBlock(int i, int j, int[][] tab, int k){
        boolean check = true;
        int i2 = i-(i%3), j2 = j-(j%3);
        for (int a = i2;a < i2+3 ;a++ ) {
            for (int b = j2; b< j2+3 ;b++ ) {
                if( (tab[a][b]==k) && (a!=i || b!=j)){
                    check= false;
                }
            }
        }
        return check;
    }

    //va convertir notre tableau de Case en tableau de int pour le backtrack
    public int[][] convertInt(){
        int[][] tab = new int[9][9];
        for (int i= 0;i<9 ;i++ ) {
            for (int j = 0;j<9 ;j++ ) {
                tab[i][j] = tabC[i][j].getValeur();
            }
        }
        return tab;
    }

    public void convertCase(int[][] tab){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j<9; j++){
                tabC[i][j].setValeur(tab[i][j]);
            }
        }
    }

    //utilise l'algo du backtrack pour resoudre la grille et renvoi un boolean
    public boolean resoudre(int[][] tab, int position){

        if(position == 81){
            return true;
        }
        int i=position/9; int j = position%9;
        if(tab[i][j] != 0){
            return resoudre(tab, position+1);
        }
        for (int k = 1; k < 10 ;k++) {
            if(checkLigne(i,j, tab, k) && checkColonne(i, j, tab, k) && checkBlock(i, j, tab,k)){
                tab[i][j] = k;

                if(resoudre(tab, position+1)){
                    return true;
                }
            }
        }
        tab[i][j] = 0;
        return false;
    }

    public boolean LancerResolution(int position){
        int[][] tabh = new int[9][9];
        return resoudre(tabh, position);
    }

    //vide de n nombre un sudoku et laisse les autre en bloque
    public void vide(int nombre){
        int i;
        int j;
        while(nombre>0){
            i = (int) (Math.random() * 9);
            j = (int) (Math.random() * 9);
            if (tabC[i][j].getValeur()!=0){
                tabC[i][j].setValeur(0);
                nombre--;
            }

        }
    }

    public void bloqueCase(){
        for (int i = 0; i <9; i++){
            for (int j = 0; j <9 ; j++){
                if(tabC[i][j].getValeur()!=0){
                    tabC[i][j].setBloque(true);
                }
            }
        }
    }

    public String affiche(){
        String res = "";
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++) {
                res += tabC[i][j].getValeur() + "|";
            }
        }
        return  res;
    }


}