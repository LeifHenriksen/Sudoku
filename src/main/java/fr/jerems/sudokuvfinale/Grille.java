package fr.jerems.sudokuvfinale;
//package com.example.lhenriksenla.myapplication;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Grille {
    private GridView gv;
    private GridView gv2;
    private GridView gv3;
    private GridView gv4;
    private GridView gv5;
    private GridView gv6;
    private GridView gv7;
    private GridView gv8;
    private GridView gv9;
    //pour setAdapters
    private Cases cases;
    private List<List<String>> numbers;
    private int[][] positionGrille;
    private List<Point2> points;


    Grille(View view){
        gv = (GridView) view.findViewById(R.id.gv);
        gv2 = (GridView) view.findViewById(R.id.gv2);
        gv3 = (GridView) view.findViewById(R.id.gv3);
        gv4 = (GridView) view.findViewById(R.id.gv4);
        gv5 = (GridView) view.findViewById(R.id.gv5);
        gv6 = (GridView) view.findViewById(R.id.gv6);
        gv7 = (GridView) view.findViewById(R.id.gv7);
        gv8 = (GridView) view.findViewById(R.id.gv8);
        gv9 = (GridView) view.findViewById(R.id.gv9);

        numbers = new ArrayList<List<String>>(0);
        for(int i = 0 ; i<9 ; i++)
            numbers.add(new ArrayList<String>(0));

        //you give it a gridview and a position in that gridview, and it gives the position in the list of the 9*9
        positionGrille = new int[9][9];
        int x = 0;
        int y = 0;

        for (int i = 0; i<9 ; i = i+3) {

            for (int e = 0; e < 3; e++) {
                for (int k = i; k < (i + 3); k++) {
                    for (int j = x; j < (x + 3); j++) {
                        positionGrille[k][j] = y;
                        y++;
                    }

                }
                x = x + 3;
            }
                x=0;
        }

        points = new ArrayList<Point2>();
        //tu donnes un valeur de 0-80 et te donne la pos x et y
        for (int i = 0; i<9; i++)
            for (int j = 0; j<9; j++)
                 points.add(new Point2(i , j));

    }

    void setCases(Cases cases){
        this.cases = cases;
    }

    Point2 getPoints(int pos){
        return points.get(pos);
    }

    int getPositionGrille(int x , int y){
        //gridview = x, position = y
        return positionGrille[x][y];
    }
    //de string a numbers
    //changer nom
    void copyFromTo(List<String> list){

        int x = 0;
        //9 lignes
        for (int i = 0; i<9 ; i += 3) {

            //3 lignes
            for(int e = 0 ; e<3 ; e++)
                //une lignes
                for(int k = i ; k<(i+3) ; k++) {
                    for (int j = x; j < (x + 3); j++) {
                        numbers.get(k).add(list.get(j));
                    }
                    x = x + 3;
                }

/*
            for (int j = x; j<(x+9) ; j++)
            {
                numbers.get(i).add(list.get(j));
               // Log.d("valeur j", "la valeur de j est : " + j);
               // Log.d("valeur j", "la valeur de numbers i at j est : " + numbers.get(i).get(j%9) + " " + j + " i = " + i);
            }

            x = x + 9;
           // Log.d("valeur i", "la valeur de i est : " + i);
           // Log.d("valeur x", "la valeur de x est : " + x);*/
        }


    }

    void refreshNumbers(List<String> list){
        for (int i = 0; i<9 ; i++) {
            numbers.get(i).clear();
        }

        this.copyFromTo(list);
    }

    //determine le couleur de base
    void setAdapters(List<String> list , EditeurGrille activity){


        this.copyFromTo(list);
//numbers donne la taille aussi de l'adapter
        gv.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(0))
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

                /*-------------------avec cases-----------------------*/
                // Set the TextView text (GridView item text)
                //tv.setText(numbers.get(0).get(position));
                tv.setText(cases.getCaseAt(0,position).getValeur());
               // Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(0,position).getCouleur() == 0) {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(0,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                //tv.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

      // this.copyFromTo(pl);
        gv2.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(1))
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

                tv.setText(cases.getCaseAt(1,position).getValeur());
              //  Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(1,position).getCouleur() == 0)
                {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(1,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

      // this.copyFromTo(pl);
        gv3.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(2))
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

                tv.setText(cases.getCaseAt(2,position).getValeur());
               // Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(2,position).getCouleur() == 0)
                {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(2,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

       // this.copyFromTo(pl);
        gv4.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(3))
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

                tv.setText(cases.getCaseAt(3,position).getValeur());
                //Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(3,position).getCouleur() == 0){
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(3,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

       // this.copyFromTo(pl);
        gv5.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(4))
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

                tv.setText(cases.getCaseAt(4,position).getValeur());
                //Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(4,position).getCouleur() == 0)
                {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(4,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

       // this.copyFromTo(pl);
        gv6.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(5))
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

                tv.setText(cases.getCaseAt(5,position).getValeur());
                //Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(5,position).getCouleur() == 0)
                {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(5,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

     //   this.copyFromTo(pl);
        gv7.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(6))
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

                tv.setText(cases.getCaseAt(6,position).getValeur());
                //Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(6,position).getCouleur() == 0)
                {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(6,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

     //   this.copyFromTo(pl);
        gv8.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(7))
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

                tv.setText(cases.getCaseAt(7,position).getValeur());
                //Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(7,position).getCouleur() == 0)
                {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(7,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

     //   this.copyFromTo(pl);
        gv9.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(8))
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

                tv.setText(cases.getCaseAt(8,position).getValeur());
                //Log.i("position", Integer.toString(position));
                // Set the TextView background color

                if(cases.getCaseAt(8,position).getCouleur() == 0)
                {
                    tv.setTextColor(Color.parseColor("black"));
                    tv.setBackgroundColor(Color.parseColor("white"));
                }
                else if(cases.getCaseAt(8,position).getCouleur() == 1) {
                    tv.setBackgroundColor(Color.parseColor("blue"));
                    tv.setTextColor(Color.parseColor("white"));
                }
                else
                    tv.setBackgroundColor(Color.parseColor("red"));
                // Return the TextView widget as GridView item
                return tv;
            }
        });

    }

    void setClickListeners(AdapterView.OnItemClickListener itemClickListener){

        gv.setOnItemClickListener(itemClickListener);
        gv2.setOnItemClickListener(itemClickListener);
        gv3.setOnItemClickListener(itemClickListener);
        gv4.setOnItemClickListener(itemClickListener);
        gv5.setOnItemClickListener(itemClickListener);
        gv6.setOnItemClickListener(itemClickListener);
        gv7.setOnItemClickListener(itemClickListener);
        gv8.setOnItemClickListener(itemClickListener);
        gv9.setOnItemClickListener(itemClickListener);

        }

    GridView getGv(int x){

        switch (x){
            case 1:
                return gv;

            case 2:
                return gv2;

            case 3:
                return gv3;

            case 4:
                return gv4;

            case 5:
                return gv5;

            case 6:
                return gv6;

            case 7:
                return gv7;

            case 8:
                return gv8;

            case 9:
                return gv9;

            default:
                throw new RuntimeException("Unknow button ID");
        }

    }

    //met le couleur et change previousgrid
    void click(AdapterView<?> parent, View view, int position, long id, EditeurGrille activity){
        Log.d("Previous GRID", "Previous = "+activity.getPreviousSelectedGridView());
        switch(parent.getId()) {

            case R.id.gv: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(1);
                else if(activity.getPreviousSelectedGridView() != 1)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                //GridView previouGV = getGv(activity.getPreviousSelectedGridView());
                activity.setPreviousSelectedGridView(1);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);

                        switch (cases.getCaseAt(0,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }

                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedGridView(1);
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;


            case R.id.gv2: {
                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(2);
                else if(activity.getPreviousSelectedGridView() != 2)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(2);


                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv2.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);
                        switch (cases.getCaseAt(1,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }

                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                    activity.setPreviousSelectedGridView(2);
                }
            }
                break;

            case R.id.gv3: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(3);
                else if(activity.getPreviousSelectedGridView() != 3)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(3);


                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv3.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);
                        switch (cases.getCaseAt(2,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }

                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;

            case R.id.gv4: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(4);
                else if(activity.getPreviousSelectedGridView() != 4)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(4);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv4.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);

                        switch (cases.getCaseAt(3,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }
                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;

            case R.id.gv5: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(5);
                else if(activity.getPreviousSelectedGridView() != 5)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(5);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv5.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);

                        switch (cases.getCaseAt(4,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }
                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;

            case R.id.gv6: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(6);
                else if(activity.getPreviousSelectedGridView() != 6)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(6);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv6.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);

                        switch (cases.getCaseAt(5,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }
                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;

            case R.id.gv7: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(7);
                else if(activity.getPreviousSelectedGridView() != 7)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(7);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv7.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);
                        switch (cases.getCaseAt(6,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }
                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;

            case R.id.gv8: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(8);
                else if(activity.getPreviousSelectedGridView() != 8)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(8);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv8.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);

                        switch (cases.getCaseAt(7,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }
                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;

            case R.id.gv9: {

                if(activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(9);
                else if(activity.getPreviousSelectedGridView() != 9)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(9);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();

                //prendre la cellule actuelle
                TextView tv2 = (TextView) view;

                tv2.setBackgroundColor(Color.parseColor("#FF9AD082"));

                // Display the selected/clicked item text and position on TextView
                //tv.setText("GridView item clicked : " +selectedItem + "\nAt index position : " + position);

                TextView previousSelectedView = (TextView) gv9.getChildAt(activity.getPreviousSelectedPosition());

                // If there is a previous selected view exists
                if (position != activity.getPreviousSelectedPosition()) {
                    if (activity.getPreviousSelectedPosition() != -1) {
                        // Set the last selected View to deselect
                        previousSelectedView.setSelected(false);
                        switch (cases.getCaseAt(8,activity.getPreviousSelectedPosition()).getCouleur())
                        {
                            case 0:
                                previousSelectedView.setBackgroundColor(Color.parseColor("white"));
                                break;
                            case 1:
                                previousSelectedView.setBackgroundColor(Color.parseColor("blue"));
                                break;
                            case 2:
                                previousSelectedView.setBackgroundColor(Color.parseColor("red"));
                                break;
                        }
                        // Set the last selected View text color as deselected item
                        //previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
                break;

        }
    }

    void invalidateViews(){

            gv.invalidateViews();
            gv2.invalidateViews();
            gv3.invalidateViews();
            gv4.invalidateViews();
            gv5.invalidateViews();
            gv6.invalidateViews();
            gv7.invalidateViews();
            gv8.invalidateViews();
            gv9.invalidateViews();

        }


}
