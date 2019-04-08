//package com.example.lhenriksenla.myapplication;
package com.example.sudokuv2;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import  java.util.Calendar;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//botones de abajo que cambien los valores de la grid
//pasar la grid como tab 9*9
//boton resoudre cambie los valores

/*
referencias

https://android--code.blogspot.com/2015/08/android-gridview-border-between-items.html
http://www.mkyong.com/android/android-gridview-example/
https://android--code.blogspot.com/2015/08/android-gridview-add-item.html
 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //changer a prive et faire un set get
    private int previousSelectedPosition = -1;
    private int previousSelectedGridView = -1;

    private AdapterView.OnItemClickListener itemClickListener;
    private Grille grilles;
    private Cases cases;

    //le string a utiliser pour le jeu
    private List<String> grilleAsList;

    private List<String>  grilleResolu;
    void setPreviousSelectedPosition(int x){
        previousSelectedPosition = x;
    }

    int getPreviousSelectedPosition(){
        return previousSelectedPosition;
    }

    void setPreviousSelectedGridView(int x){
        previousSelectedGridView = x;
    }

    int getPreviousSelectedGridView(){
        return previousSelectedGridView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//=================================Le string a modifier====================================//
//mettre le tableau desire ici

        // Initializing a new String Array
        String[] maGrille = new String[]{
                "5","","","","","","","","3",
                "","9","","","","8","","","",
                "","","","","4","","","6","",
                "8","","4","","","","9","5","",
                "","","","","3","","4","1","",
                "1","","","","","4","7","","",
                "2","","","4","","5","","","",
                "","","","","1","","","8","",
                "","","8","2","","","","9",""
        };


//=======================================================================================//

        // Get the widgets reference from XML layout
        final MainActivity activity = this;

        grilles = new Grille(findViewById(R.id.container));
        cases = new Cases();

        // Populate a List from Array elements
        grilleAsList = new ArrayList<String>(Arrays.asList(maGrille));
        grilleResolu = new ArrayList<String>(Arrays.asList(maGrille));

        grilles.setAdapters(grilleAsList, this);
        // Data bind GridView with ArrayAdapter (String Array elements)

        Sudoku sudk = new Sudoku(Sudoku.listToArr(grilleResolu));
        sudk.estValide(sudk.getGrille(), 0);
        Sudoku.arrToList(sudk.getGrille()  , grilleResolu);

        cases.initModifiable(grilleAsList, grilleResolu);
        grilles.setCases(cases);



        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                grilles.click(parent, view, position, id, activity);
            }
        };

        grilles.setClickListeners(itemClickListener);

        //===================================buttons=========================================//

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

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);


        //===================================buttons fin=========================================//
    }



    // Method for converting DP value to pixels
    public static int getPixelsFromDPs(Activity activity, int dps){
        Resources r = activity.getResources();
        int  px = (int) (TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dps, r.getDisplayMetrics()));
        return px;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            //avec previousSelectedGridView toujours mettre -1;
            case R.id.button1:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"1");

                grilles.refreshNumbers(grilleAsList);
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("1");

                grilles.invalidateViews();
                break;
            case R.id.button2:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"2");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("2");

                grilles.invalidateViews();
                break;
            case R.id.button3:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"3");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("3");

                grilles.invalidateViews();
                break;
            case R.id.button4:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"4");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("4");

                grilles.invalidateViews();
                break;
            case R.id.button5:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"5");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("5");

                grilles.invalidateViews();
                break;
            case R.id.button6:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"6");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("6");

                grilles.invalidateViews();
                break;
            case R.id.button7:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"7");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("7");

                grilles.invalidateViews();
                break;
            case R.id.button8:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"8");


                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("8");

                grilles.invalidateViews();
                break;
            case R.id.button9:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"9");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("9");

                grilles.invalidateViews();
                break;

            case R.id.button10:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("");

                grilles.invalidateViews();
                break;

            case R.id.button12:
                //==================================clear=========================================//
                int[][] tab = new int[9][9];

                for(int i = 0; i<9 ; i++)
                {
                    for (int j = 0; j < 9; j++) {
                        tab[i][j] = 0;
                    }
                }

                Sudoku.arrToList(tab  , grilleAsList);

                grilles.refreshNumbers(grilleAsList);

                cases.clear();

                grilles.invalidateViews();
                break;
            case R.id.button11:
                //===================================Resolution=============================================//
                Toast toast = Toast.makeText(getApplicationContext(),"Resolution en marche", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                int millis = Calendar.getInstance().get(Calendar.MILLISECOND);

                Sudoku sudk = new Sudoku(Sudoku.listToArr(grilleAsList));
                //int sec = Calendar.getInstance().get(Calendar.SECOND);
                sudk.estValide(sudk.getGrille(), 0);

                //on doit changer grilleresolu car c'est possible qje la resolution a change
                //si on modifie pas on peut enlever et simplement faire cases.montrerReponse()
                Sudoku.arrToList(sudk.getGrille()  , grilleResolu);

                Sudoku.arrToList(sudk.getGrille()  , grilleAsList);

                toast = Toast.makeText(getApplicationContext(),"Temps de resolution milliseconds = " + (Calendar.getInstance().get(Calendar.MILLISECOND) - millis), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                //===================================Fin Resolution=============================================//


                grilles.refreshNumbers(grilleAsList);

                //update cases
                cases = new Cases();
                cases.initModifiable(grilleAsList,grilleResolu);
                cases.montrerReponse();
                grilles.setCases(cases);

                grilles.invalidateViews();



                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        //grilles.copyFromTo(grilleAsList);
    }
}