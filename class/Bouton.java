package com.example.sudoku;

import android.view.View;
import android.widget.GridView;

import java.util.List;

public class Bouton {
    public void numbers(View v , int previousSelectedPosition, List<String> plantsList, GridView gv)
    {
        switch(v.getId())
        {
            case R.id.button1:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"1");

                gv.invalidateViews();
                break;
            case R.id.button2:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"2");
                gv.invalidateViews();
                break;
            case R.id.button3:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"3");

                gv.invalidateViews();
                break;
            case R.id.button4:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"4");

                gv.invalidateViews();
                break;
            case R.id.button5:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"5");

                gv.invalidateViews();
                break;
            case R.id.button6:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"6");

                gv.invalidateViews();
                break;
            case R.id.button7:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"7");

                gv.invalidateViews();
                break;
            case R.id.button8:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"8");

                gv.invalidateViews();
                break;
            case R.id.button9:
                if(previousSelectedPosition != -1)
                    plantsList.set(previousSelectedPosition,"9");

                gv.invalidateViews();
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }
    }
}
