package com.example.lhenriksenla.myapplication;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

    private List<String> plantsList;

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

        // Get the widgets reference from XML layout
        final MainActivity activity = this;



        grilles = new Grille(findViewById(R.id.container));


        // Initializing a new String Array
        final String[] plants = new String[]{
                "1","2","0","0","0","0","0","0","9",
                "9","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","9"
        };

        // Populate a List from Array elements
        plantsList = new ArrayList<String>(Arrays.asList(plants));

        grilles.setAdapters(plantsList, this);
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
        Button buttonResoudre = findViewById(R.id.button10);
        Button buttonClear = findViewById(R.id.button11);

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

    public void arrToList(int[][] tab, List<String> list){
        int indiceList = 0;
        //List<String> list = new LinkedList<>();

        for(int i = 0; i<9 ; i++)
        {
            for (int j = 0; j < 9; j++) {
                list.set(indiceList, Integer.toString(tab[i][j]));
                indiceList++;
            }
        }
        //return list;
    }

    public int[][] listToArr(List<String> list){
        int[][] tab = new int[9][9];
        int indiceList = 0;

        for(int i = 0; i<9 ; i++)
            for(int j = 0; j<9 ; j++)
            {
                tab[i][j] = Integer.parseInt(list.get(indiceList));
                indiceList++;
            }
        return tab;
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
            case R.id.button1:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"1");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button2:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"2");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button3:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"3");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button4:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"4");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button5:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"5");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button6:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"6");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button7:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"7");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button8:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"8");


                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button9:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition+((previousSelectedGridView-1)*9),"9");

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;

            case R.id.button11:
                int[][] tab = new int[9][9];

                for(int i = 0; i<9 ; i++)
                {
                    for (int j = 0; j < 9; j++) {
                        tab[i][j] = 0;
                    }
                }

                arrToList(tab  ,plantsList);

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();
                break;
            case R.id.button10:
                //===================================Resolution=============================================//
                Toast toast = Toast.makeText(getApplicationContext(),"Resolution en marche", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                Sudoku sudk = new Sudoku(listToArr(plantsList));
                sudk.estValide(sudk.getGrille(), 0);
                arrToList(sudk.getGrille()  ,plantsList);

                grilles.refreshNumbers(plantsList);
                grilles.invalidateViews();


                //===================================Fin Resolution=============================================//
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        //grilles.copyFromTo(plantsList);
    }
}