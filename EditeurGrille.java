package com.example.sudoku;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class EditeurGrille extends AppCompatActivity implements View.OnClickListener{

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

    private static Context context;
    private Button btnphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editeur_grille);

        context=getApplicationContext();
        System.loadLibrary("opencv_java3");
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Log.d("Creation","test132155");

        final EditeurGrille activity = this;

        grilles = new Grille(findViewById(R.id.container));


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

        //grilleAsList = new ArrayList<String>(Arrays.asList(maGrille));

        grilles.setAdapters(grilleAsList,this);
        // Data bind GridView with ArrayAdapter (String Array elements)

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

    public static int getPixelsFromDPs(Activity activity, int dps){
        Resources r = activity.getResources();
        int  px = (int) (TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dps, r.getDisplayMetrics()));
        return px;
    }

    @Override
    public void onClick(View v) {
        int posGrille = 0;
        if(previousSelectedPosition != -1)
            posGrille = grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition);

        switch(v.getId())
        {
            //avec previousSelectedGridView toujours mettre -1;
            case R.id.button1:
                if(previousSelectedPosition != -1)
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "1");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("1");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button2:
                if(previousSelectedPosition != -1)
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "2");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("2");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button3:
                if(previousSelectedPosition != -1)
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "3");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("3");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button4:
                if(previousSelectedPosition != -1)
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "4");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("4");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button5:
                if(previousSelectedPosition != -1 )
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "5");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("5");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button6:
                if(previousSelectedPosition != -1)
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "6");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("6");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button7:
                if(previousSelectedPosition != -1)
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "7");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("7");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button8:
                if(previousSelectedPosition != -1)
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "8");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("8");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button9:
                if(previousSelectedPosition != -1 )
                {
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "9");
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("9");
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(),"Numero NON valide", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;

            case R.id.button10:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"");

                grilles.refreshNumbers(grilleAsList);

                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("");

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

                grilles.refreshNumbers(grilleAsList);

                //cases.clear();

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



                grilles.invalidateViews();



                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        //grilles.copyFromTo(grilleAsList);
    }
}
