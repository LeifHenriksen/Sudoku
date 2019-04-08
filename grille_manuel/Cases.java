package com.example.sudokuv2;

import java.util.ArrayList;
import java.util.List;

public class Cases {
    private List<List<Case>> cases;

    public Cases() {
        cases = new ArrayList<List<Case>>(0);
        for (int i = 0; i < 9; i++)
            cases.add(new ArrayList<Case>(0));
    }



    public void initJeu(List<String> vals, List<String> valsResolution) {
        int x = 0;
        //9 lignes
        for (int i = 0; i < 9; i += 3) {

            //3 lignes
            for (int e = 0; e < 3; e++)
                //une lignes
                for (int k = i; k < (i + 3); k++) {
                    for (int j = x; j < (x + 3); j++) {
                        if(vals.get(j) == "")
                            cases.get(k).add(new Case(true, vals.get(j), valsResolution.get(j)));
                        else
                            cases.get(k).add(new Case(false, vals.get(j), valsResolution.get(j)));
                    }
                    x = x + 3;
                }
        }

    }

    public void initModifiable(List<String> vals, List<String> valsResolution) {
        int x = 0;
        //9 lignes
        for (int i = 0; i < 9; i += 3) {

            //3 lignes
            for (int e = 0; e < 3; e++)
                //une lignes
                for (int k = i; k < (i + 3); k++) {
                    for (int j = x; j < (x + 3); j++) {
                        if(vals.get(j) == "")
                            cases.get(k).add(new Case(true, vals.get(j), valsResolution.get(j)));
                        else
                            cases.get(k).add(new Case(true, vals.get(j), valsResolution.get(j)));
                    }
                    x = x + 3;
                }
        }

    }

    public Case getCaseAt(int previousSelectedGridView, int previousSelectedPosition){

        return cases.get(previousSelectedGridView).get(previousSelectedPosition);

    }

    public void montrerReponse(){
        for(int i = 0; i<9; i++){
            for (int j = 0; j<9; j++)
               cases.get(i).get(j).setValeur(cases.get(i).get(j).getValeurReponse());
        }
    }

    public void clear(){
        for(int i = 0; i<9; i++){
            for (int j = 0; j<9; j++) {
                cases.get(i).get(j).setValeur("");
                cases.get(i).get(j).setCouleur(0);
            }
        }
    }
}
