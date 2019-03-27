package com.example.sudoku;

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

import java.lang.reflect.Array;
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
    private List<List<String>> numbers;
    private int[][] positionGrille;
    //private int x;
    //private int y;

    Grille(View view) {
        gv = (GridView)view.findViewById(R.id.gv);
        gv2 = (GridView)view.findViewById(R.id.gv2);
        gv3 = (GridView)view.findViewById(R.id.gv3);
        gv4 = (GridView) view.findViewById(R.id.gv4);
        gv5 = (GridView) view.findViewById(R.id.gv5);
        gv6 = (GridView) view.findViewById(R.id.gv6);
        gv7 = (GridView) view.findViewById(R.id.gv7);
        gv8 = (GridView) view.findViewById(R.id.gv8);
        gv9 = (GridView) view.findViewById(R.id.gv9);

        numbers = new ArrayList<List<String>>(0);
        for (int i = 0; i < 9; i++)
            numbers.add(new ArrayList<String>(0));

        positionGrille = new int[9][9];
        int x = 0;
        int y = 0;

        for (int i = 0; i < 9; i = i + 3) {

            for (int e = 0; e < 3; e++) {
                for (int k = i; k < (i + 3); k++) {
                    for (int j = x; j < (x + 3); j++) {
                        positionGrille[k][j] = y;
                        y++;
                    }

                }
                x = x + 3;
            }
            x = 0;
        }

    }

    int getPositionGrille(int x, int y) {
        return positionGrille[x][y];
    }

    void copyFromTo(List<String> list) {

        int x = 0;
        //9 lignes
        for (int i = 0; i < 9; i += 3) {

            //3 lignes
            for (int e = 0; e < 3; e++)
                //une lignes
                for (int k = i; k < (i + 3); k++) {
                    for (int j = x; j < (x + 3); j++) {
                        numbers.get(k).add(list.get(j));
                    }
                    x = x + 3;
                }

        }


    }

    void refreshNumbers(List<String> list) {
        for (int i = 0; i < 9; i++) {
            numbers.get(i).clear();
        }

        this.copyFromTo(list);
    }

    void setAdapters(List<String> list, EntreManuel activity) {


        this.copyFromTo(list);

        gv.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(0)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(0).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        // this.copyFromTo(pl);
        gv2.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(1)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(1).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        // this.copyFromTo(pl);
        gv3.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(2)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(2).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        // this.copyFromTo(pl);
        gv4.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(3)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(3).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        // this.copyFromTo(pl);
        gv5.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(4)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(4).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        // this.copyFromTo(pl);
        gv6.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(5)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(5).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        //   this.copyFromTo(pl);
        gv7.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(6)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(6).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        //   this.copyFromTo(pl);
        gv8.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(7)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(7).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        //   this.copyFromTo(pl);
        gv9.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers.get(8)) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;

                //tv.setTextColor(Color.DKGRAY);

                // Set the layout parameters for TextView widget
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();

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
                tv.setPadding(0, 0, 0, 0);

                // Set the TextView text (GridView item text)
                tv.setText(numbers.get(8).get(position % 9));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

    }

    void setClickListeners(AdapterView.OnItemClickListener itemClickListener) {

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

    GridView getGv(int x) {

        switch (x) {
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

    void click(AdapterView<?> parent, View view, int position, long id, EntreManuel activity) {

        switch (parent.getId()) {

            case R.id.gv: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(1);
                else if (activity.getPreviousSelectedGridView() != 1)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                //GridView previouGV = getGv(activity.getPreviousSelectedGridView());


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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedGridView(1);
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;


            case R.id.gv2: {
                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(2);
                else if (activity.getPreviousSelectedGridView() != 2)
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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                    activity.setPreviousSelectedGridView(2);
                }
            }
            break;

            case R.id.gv3: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(3);
                else if (activity.getPreviousSelectedGridView() != 3)
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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;

            case R.id.gv4: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(4);
                else if (activity.getPreviousSelectedGridView() != 4)
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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;

            case R.id.gv5: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(5);
                else if (activity.getPreviousSelectedGridView() != 5)
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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;

            case R.id.gv6: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(6);
                else if (activity.getPreviousSelectedGridView() != 6)
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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;

            case R.id.gv7: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(7);
                else if (activity.getPreviousSelectedGridView() != 7)
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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;

            case R.id.gv8: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(8);
                else if (activity.getPreviousSelectedGridView() != 8)
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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;

            case R.id.gv9: {

                if (activity.getPreviousSelectedGridView() == -1)
                    activity.setPreviousSelectedGridView(9);
                else if (activity.getPreviousSelectedGridView() != 9)
                    getGv(activity.getPreviousSelectedGridView()).invalidateViews();

                activity.setPreviousSelectedGridView(9);

                // Get the GridView selected/clicked item text
                String selectedItem = parent.getItemAtPosition(position).toString();


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

                        // Set the last selected View background color as deselected item
                        previousSelectedView.setBackgroundColor(Color.parseColor("white"));

                        // Set the last selected View text color as deselected item
                        previousSelectedView.setTextColor(Color.DKGRAY);
                    }

                    // Set the current selected view position as previousSelectedPosition
                    activity.setPreviousSelectedPosition(position);
                }
            }
            break;

        }
    }

    void invalidateViews() {

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
