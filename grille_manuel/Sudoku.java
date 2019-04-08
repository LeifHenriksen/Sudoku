package com.example.sudokuv2;
//package com.example.lhenriksenla.myapplication;

import android.util.Log;

import java.util.List;

//l'algo ne marche pas si il y a une mauvais saisie, on doit faire une mesage de erreur
public class Sudoku {

    private int [][] grille;

    public Sudoku(int [][] grille){
        this.grille=grille;
    }
    public int[][] getGrille(){return grille;}

    static private boolean absentSurLigne(int k,int [][] grille,int i){
        for(int j=0;j<9;j++){
            if(grille[i][j]==k){
                return false;
            }
        }
        return true;
    }

    public void affichage(){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grille[i][j]!=0)
                    Log.i("tab", Integer.toString(grille[i][j]));
                else
                    Log.i("tab", " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static private boolean absentSurColonne(int k,int [][] grille,int j){
        for(int i=0;i<9;i++){
            if(grille[i][j]==k){
                return false;
            }
        }
        return true;
    }
    static private boolean absentSurBloc(int k,int [][] grille,int i,int j){
        int _i=i-(i%3),_j=j-(j%3);
        for(i=_i;i<_i+3;i++){
            for(j=_j;j<_j+3;j++){
                if(grille[i][j]==k){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean estValide(int [][] grille,int position){
        if(position==9*9){
            return true;
        }
        int i=position/9,j=position%9;
        if (grille[i][j]!=0){
            return estValide(grille,position+1);
        }
        for(int k=1;k<=9;k++){
            if(absentSurLigne(k,grille,i) && absentSurColonne(k,grille,j) && absentSurBloc(k,grille,i,j)){
                grille[i][j]=k;
                if(estValide(grille,position+1))
                    return true;
            }
        }

        grille[i][j]=0;
        return false;
    }

    static public void arrToList(int[][] tab, List<String> list){
        int indiceList = 0;
        //List<String> list = new LinkedList<>();

        for(int i = 0; i<9 ; i++)
        {
            for (int j = 0; j < 9; j++) {
                if(tab[i][j] == 0)
                    list.set(indiceList, "");
                else
                    list.set(indiceList, Integer.toString(tab[i][j]));

                indiceList++;
            }
        }
        //return list;
    }

    static public int[][] listToArr(List<String> list){

        int[][] tab = new int[9][9];
        int indiceList = 0;
        String grille = "";
        for(int i = 0; i<9 ; i++)
        {
            for (int j = 0; j < 9; j++) {
                //tab[i][j] = Integer.parseInt(list.get(indiceList));
                if (list.get(indiceList) == "") {
                    tab[i][j] = 0;
                    grille = grille + '0';
                }
                else {
                    tab[i][j] = Integer.parseInt(list.get(indiceList));
                    grille = grille + list.get(indiceList);
                }
                indiceList++;
            }
            grille = grille + '\n';

        }
        Log.d("mon tab", "\n" + grille);
        Log.d("mon tab", Integer.toString(tab[0][8]));
        return tab;
    }

    static boolean positionValide(int [][] grille,int val, int positionx, int positiony){
        return (absentSurLigne(val,grille,positionx) && absentSurColonne(val,grille,positiony) && absentSurBloc(val,grille,positionx,positiony));
    }

}
//Sources :
//https://openclassrooms.com/fr/courses/1256706-le-backtracking-par-lexemple-resoudre-un-sudoku
//http://imss-www.upmf-grenoble.fr/prevert/Prog/Java/CoursJava/tableaux.html