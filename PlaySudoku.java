package com.example.sudoku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class PlaySudoku extends AppCompatActivity  implements View.OnClickListener {

    private int previousSelectedPosition = -1;
    private int previousSelectedGridView = -1;

    private AdapterView.OnItemClickListener itemClickListener;
    private Grille grilles;
    private Cases cases;
    private Sudoku sudo;
    public Sudoku casebloque;

    private List<String> grilleAsList;
    private List<String> grilleResolu;
    private List<String> grilledeBase;
    private List<Case> caseInchangeable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_sudoku);
        // Get the widgets reference from XML layout
        final PlaySudoku activity = this;

        grilles = new Grille(findViewById(R.id.container));
        cases = new Cases();
        int[][] tab = new int[9][9];
        for (int compteur = 0; compteur < 10; compteur++) {
            rempli(tab);
        }
        sudo = new Sudoku(tab);
        sudo.estValide(tab, 0);
        for (int vider = 0; vider < 40; vider++) {
            vide(sudo.getGrille());
        }

        tab = sudo.getGrille();


        caseInchangeable = new ArrayList<Case>();
        //tu donnes un valeur de 0-80 et te donne la pos x et y
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (tab[i][j] != 0) {
                    caseInchangeable.add(new Case(false, String.valueOf(tab[i][j]), String.valueOf(tab[i][j])));
                    Log.d("liste caseInchangeable ", String.valueOf(caseInchangeable));
                }



        // Initializing a new String Array
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

        // Populate a List from Array elements
        grilleAsList = new ArrayList<String>(Arrays.asList(maGrille));
        grilleResolu = new ArrayList<String>(Arrays.asList(maGrille));
        grilledeBase = new ArrayList<String>(Arrays.asList(maGrille));
        sudo.arrToList(sudo.getGrille(), grilleAsList);
        sudo.arrToList(sudo.getGrille(), grilledeBase);

        Sudoku sudk = new Sudoku(Sudoku.listToArr(grilleResolu));
        sudk.estValide(sudk.getGrille(), 0);
        Sudoku.arrToList(sudk.getGrille()  , grilleResolu);

        grilles.setAdapters(grilleAsList, this);
        // Data bind GridView with ArrayAdapter (String Array elements)

        cases.initJeu(grilleAsList, grilleResolu);
        grilles.setCases(cases);

        casebloque = sudo;

        //cases.caseBloque(caseInchangeable);

        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("test", String.valueOf(casebloque.getGrille()));
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

        button1.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
        button5.setOnClickListener((View.OnClickListener) this);
        button6.setOnClickListener((View.OnClickListener) this);
        button7.setOnClickListener((View.OnClickListener) this);
        button8.setOnClickListener((View.OnClickListener) this);
        button9.setOnClickListener((View.OnClickListener) this);


        //===================================buttons fin=========================================//
    }

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

    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button1:
                if(previousSelectedPosition != -1)
                    //if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                    if(accessible(grilledeBase, grilleAsList.get(grilles.getPositionGrille(previousSelectedGridView-1, previousSelectedPosition))))
                        //Log.d("meme case ? ", String.valueOf(accessible(cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition), caseInchangeable)));
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"1");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button2:
                if(previousSelectedPosition != -1){
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"2");
                }

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button3:
                if(previousSelectedPosition != -1)
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"3");


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button4:
                if(previousSelectedPosition != -1)
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"4");


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button5:
                if(previousSelectedPosition != -1)
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"5");


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button6:
                if(previousSelectedPosition != -1)
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"6");


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button7:
                if(previousSelectedPosition != -1)
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"7");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button8:
                if(previousSelectedPosition != -1)
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"8");


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button9:
                if(previousSelectedPosition != -1)
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == "")
                    {
                        (cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).setValeur("9");
                    }


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;

            case R.id.button10:
                if(previousSelectedPosition != -1) {
                    if((cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition)).getValeur() == ""){
                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "");

                    }
                }


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;

            case R.id.button12:

                grilleAsList = grilledeBase;
                grilles.refreshNumbers(grilledeBase);
                grilles.invalidateViews();
                break;
            case R.id.button11:
                //===================================Resolution=============================================//
                Toast toast = Toast.makeText(getApplicationContext(),"Resolution en marche", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                int millis = Calendar.getInstance().get(Calendar.MILLISECOND);

                Sudoku sudk = new Sudoku(Sudoku.listToArr(grilleAsList));

                if (sudk.estValide(sudk.getGrille(), 0)){
                    toast = Toast.makeText(getApplicationContext(),"vous avez gagné !!!!" , Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }else{
                    toast = Toast.makeText(getApplicationContext(),"Dommage, la grille n'est pas le bonne... ", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                Sudoku.arrToList(sudk.getGrille()  , grilleAsList);


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();


                //===================================Fin Resolution=============================================//
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        //grilles.copyFromTo(grilleAsList);
    }

    public static void rempli(int[][] m)
    {
        int i = (int) (Math.random()*9);
        int j = (int) (Math.random()*9);

        if(m[i][j] == 0)
        {	m[i][j]=(int) (Math.random()*9) +1;
            while(!checkligne(i,j,m)||!checkcolonne(i,j,m)||!checkblock(i,j,m))
            {
                m[i][j]=(int) (Math.random()*9) +1;
            }
        }
        else
        {
            rempli(m);
        }


    }
    public static boolean checkligne(int i,int j,int[][] m)
    {
        boolean check = true;
        for(int x = 0; x<9 ;x++)
        {
            if((m[i][x] == m[i][j])&&(j != x)) check = false;
        }
        return check;
    }
    public static boolean checkcolonne(int i,int j,int[][] m)
    {
        boolean check = true;
        for(int x = 0; x<9 ;x++)
        {
            if((m[x][j] == m[i][j])&&(i != x)) check = false;
        }
        return check;
    }
    public static boolean checkblock(int i,int j,int[][] m)
    {
        int i2 = i-(i%3);int j2 = j-(j%3);
        for(int a = i2 ; a < i2 + 3 ;a++)
        {
            for(int b = j2 ; b < j2 + 3 ;b++)
            {
                if(m[a][b]==m[i][j] && ((a!=i) || (b!=j)))return false;
            }
        }
        return true;
    }
    public static void vide(int[][] m) {
        int i = (int) (Math.random() * 9);
        int j = (int) (Math.random() * 9);

        if (m[i][j] != 0) {
            m[i][j] = 0;
        } else {
            vide(m);
        }
    }

    public boolean accessible(List<String> c, String p){
        boolean pmeme = true;

        for (String b : c){
            if (b == p && p!=""){
                pmeme = false;
            }
        }
        return pmeme;
    }

}
