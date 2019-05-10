package com.example.sudokubis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PlaySudoku3 extends AppCompatActivity implements View.OnClickListener{

    Sudo3x3 grillede3 = new Sudo3x3(65); //on créer un sudoku avec un tableau de case (9*9) dans la structure
    private List<String> grille9;//va servir à faire la liason entre le sudoku et l'affichage
    private GrilleVue affichage;//grille qui est affiché

    private int previousSelectedPosition = -1;
    private int previousSelectedGridView = -1;
    private AdapterView.OnItemClickListener itemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sudoku3);
        final PlaySudoku3 activity = this;

        affichage = new GrilleVue(findViewById(R.id.container));

        String[] maGrille = new String[]{
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","",""
        };

        grille9 = new ArrayList<String>();
        grille9 = grillede3.convert();//on remplit notre list avec notre sudoku

        affichage.setAdapters(grille9, this);//et on affiche ensuite la grille

        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                affichage.click(parent, view, position, id, activity);
            }
        };

        affichage.setClickListeners(itemClickListener);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonVide = findViewById(R.id.button10);
        Button buttonResoudre = findViewById(R.id.button11);
        Button buttonClear = findViewById(R.id.button12);

        button1.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
        button5.setOnClickListener((View.OnClickListener) this);
        button6.setOnClickListener((View.OnClickListener) this);
        button7.setOnClickListener((View.OnClickListener) this);
        button8.setOnClickListener((View.OnClickListener) this);
        button9.setOnClickListener((View.OnClickListener) this);



    }

    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button1:
                if(previousSelectedPosition != -1) {
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(previousSelectedGridView-1, previousSelectedPosition);//on calcul la position de la case
                    if (grillede3.getCase(position).getBloque() == false) {//on regarde si elle est pas bloqué
                        grillede3.getCase(position).setValeur(1);//on modifie ca valeur dans notre sudoku mais on la bloque pas
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button2:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(2);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button3:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(3);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button4:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(4);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button5:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(5);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button6:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(6);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button7:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(7);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button8:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(8);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button9:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(9);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;

            case R.id.button10:
                if(previousSelectedPosition != -1){
                    int posx = (previousSelectedGridView-1);
                    int posy = previousSelectedPosition;
                    int position = affichage.getPositionGrille(posx, posy);
                    if (grillede3.getCase(position).getBloque() == false) {
                        grillede3.getCase(position).setValeur(0);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }
                break;

            case R.id.button12:
                for (int i = 0; i < 81; i++){
                    if (grillede3.getCase(i).getBloque() == false) {
                        grillede3.getCase(i).setValeur(0);
                        grille9 = grillede3.convert();
                        affichage.refreshNumbers(grille9);
                        affichage.invalidateViews();
                    }
                }

                break;
            case R.id.button11:
                //===================================Resolution=============================================//
                Toast toast = Toast.makeText(getApplicationContext(),"Resolution en marche", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                int[][] tab = new int[9][9];
                tab = grillede3.convertInt();
                grillede3.resoudre(tab, 0);
                grillede3.convertCase(tab);
                grille9 = grillede3.convert();
                affichage.refreshNumbers(grille9);
                affichage.invalidateViews();

                int millis = Calendar.getInstance().get(Calendar.MILLISECOND);




                //===================================Fin Resolution=============================================//
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        //grilles.copyFromTo(grilleAsList);
    }

    public int getPreviousSelectedGridView() {
        return previousSelectedGridView;
    }

    public int getPreviousSelectedPosition(){
        return previousSelectedPosition;
    }

    public void setPreviousSelectedGridView(int i) {
        previousSelectedGridView = i;
    }

    public void setPreviousSelectedPosition(int i){
        previousSelectedPosition = i;
    }
}
