package com.example.sudokuv2;

//l'algo ne marche pas si il y a une mauvais saisie, on doit faire une mesage de erreur
public class Sudoku {

    private int [][] grille;

    public Sudoku(int [][] grille){
        this.grille=grille;
    }
    public int[][] getGrille(){return grille;}

    private boolean absentSurLigne(int k,int [][] grille,int i){
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
                    System.out.print(grille[i][j]);
                else System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean absentSurColonne(int k,int [][] grille,int j){
        for(int i=0;i<9;i++){
            if(grille[i][j]==k){
                return false;
            }
        }
        return true;
    }
    private boolean absentSurBloc(int k,int [][] grille,int i,int j){
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



/*
    public static void main(String arg[]){
        int [][] grilleT=
                {       {0,0,6,8,0,0,0,9,4},
                        {0,2,0,0,6,0,7,0,0},
                        {7,0,0,4,0,2,0,0,0},
                        {0,0,0,0,0,0,0,1,0},
                        {6,4,0,0,2,8,3,5,0},
                        {0,9,0,5,0,1,0,0,2},
                        {4,0,2,6,0,3,0,0,5},
                        {0,0,0,0,1,0,0,0,3},
                        {8,0,9,0,0,0,1,2,0}};
        Sudoku test= new Sudoku(grilleT);
        //	estValide(test,0);
        test.affichage();
        test.estValide(grilleT,0);
        test.affichage();
    }
*/
}
//Sources :
//https://openclassrooms.com/fr/courses/1256706-le-backtracking-par-lexemple-resoudre-un-sudoku
//http://imss-www.upmf-grenoble.fr/prevert/Prog/Java/CoursJava/tableaux.html