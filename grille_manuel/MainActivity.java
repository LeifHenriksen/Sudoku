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


public class MainActivity extends AppCompatActivity {

    private int previousSelectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the widgets reference from XML layout
        final GridView gv = (GridView) findViewById(R.id.gv);
        //final TextView tv = (TextView) findViewById(R.id.tv);

        // Initializing a new String Array
        final String[] plants = new String[]{
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0",
                "0","0","0","0","0","0","0","0","0"
        };

        // Populate a List from Array elements
        final List<String> plantsList = new ArrayList<String>(Arrays.asList(plants));

        //final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>
        //       (this,android.R.layout.simple_list_item_1, plantsList);

        // Data bind GridView with ArrayAdapter (String Array elements)
        gv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, plantsList)
        {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position,convertView,parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp =  new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)tv.getLayoutParams();

                // Set the width of TextView widget (item of GridView)
                /*
                    IMPORTANT
                        Adjust the TextView widget width depending
                        on GridView width and number of columns.

                        GridView width / Number of columns = TextView width.

                        Also calculate the GridView padding, margins, vertical spacing
                        and horizontal spacing.
                 */
                //params.width = getPixelsFromDPs(MainActivity.this,168);

                // Set the TextView layout parameters
                tv.setLayoutParams(params);

                // Display TextView text in center position
                tv.setGravity(Gravity.CENTER);

                // Set the TextView text font family and text size
                //tv.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                //tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
                tv.setPadding(0,0,0,0);
                // Set the TextView text (GridView item text)
                tv.setText(plantsList.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });



        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv.getChildAt(previousSelectedPosition);

                // If there is a previous selected view exists
                if(position != previousSelectedPosition) {
                    if (previousSelectedPosition != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    previousSelectedPosition = position;
                }
            }
        });




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

        //===================================buttons=========================================//

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"1");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"2");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"3");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();


                gv.invalidateViews();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"4");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"5");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"6");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"7");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"8");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Add/insert item to ArrayAdapter
                // Insert at the end of ArrayAdapter

                // ArrayAdapter is zero based index
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"9");

                // Update the GridView
                //gridViewArrayAdapter.notifyDataSetChanged();

                gv.invalidateViews();
            }
        });

        //===================================buttons fin=========================================//

        buttonResoudre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //===================================Resolution=============================================//
                Toast toast = Toast.makeText(getApplicationContext(),"Resolution en marche", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                Sudoku sudk = new Sudoku(listToArr(plantsList));
                sudk.estValide(sudk.getGrille(), 0);
                arrToList(sudk.getGrille()  ,plantsList);

                gv.invalidateViews();


                //===================================Fin Resolution=============================================//
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int[][] tab = new int[9][9];

                for(int i = 0; i<9 ; i++)
                {
                    for (int j = 0; j < 9; j++) {
                        tab[i][j] = 0;
                    }
                }

                arrToList(tab  ,plantsList);
                gv.invalidateViews();

            }
        });



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


}
