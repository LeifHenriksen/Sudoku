package com.example.sudokuv2;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
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
    private List<String> numbers;

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
    }

    void setAdapters(List<String> pl , MainActivity activity){
        numbers = pl;

        gv.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv2.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv3.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv4.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv5.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv6.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv7.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv8.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

        gv9.setAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, numbers)
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
                tv.setText(numbers.get(position));

                // Set the TextView background color
                tv.setBackgroundColor(Color.parseColor("white"));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

    }

}
