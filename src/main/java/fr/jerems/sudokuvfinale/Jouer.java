package fr.jerems.sudokuvfinale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class Jouer extends EditeurGrille  {

    public int casesVides = 0;
    public int nbErreurs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jouer);

//=================================Le string a modifier====================================//
//mettre le tableau desire ici

        // Initializing a new String Array
        String[] maGrille = new String[81]/*
                "5","","","","","","","","3",
                "","9","","","","8","","","",
                "","","","","4","","","6","",
                "8","","4","","","","9","5","",
                "","","","","3","","4","1","",
                "1","","","","","4","7","","",
                "2","","","4","","5","","","",
                "","","","","1","","","8","",
                "","","8","2","","","","9",""
        }*/;


//=======================================================================================//

        // Get the widgets reference from XML layout
        final EditeurGrille activity = this;

        grilles = new Grille(findViewById(R.id.container));
        cases = new Cases();

        // Populate a List from Array elements
        //if(Saver.savePresent(this) == null) {

        //System.out.println(maGrille);
        //String[] str = new String[81];
        Bundle extras = getIntent().getExtras();
        maGrille = extras.getStringArray("EXTRA_MESSAGE");
        System.out.println("dans editeur =======================================================");
        for(int i = 0; i<81; i++) {
            if(maGrille[i].equals(""))
                System.out.println("vide");
            else
                System.out.println(maGrille[i]);
        }



        String[] str = new String[81];
        for(int i = 0; i<81; i++){
            str[i] = maGrille[i];
        }

        grilleAsList = new ArrayList<String>(Arrays.asList(str));
        grilleResolu = new ArrayList<String>(Arrays.asList(str));

        casesVides = nbCasesVides(grilleAsList);

        //}
        //else
        //{
        //    grilleAsList = new ArrayList<String>();
        //    grilleResolu = new ArrayList<String>();
        //    Saver.load(grilleAsList,grilleResolu,this);
        //}

        grilles.setAdapters(grilleAsList, this);
        // Data bind GridView with ArrayAdapter (String Array elements)


        Sudoku sudk = new Sudoku(Sudoku.listToArr(grilleResolu));

        sudk.estValide(sudk.getGrille(), 0);
        sudk.print();
        Sudoku.arrToList(sudk.getGrille()  , grilleResolu);

        cases.initJeu(grilleAsList, grilleResolu);

        grilles.setCases(cases);



        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                grilles.click(parent, view, position, id, activity);
            }
        };
        System.out.println("1              =======================================================10");
        grilles.setClickListeners(itemClickListener);
        System.out.println("1              =======================================================11");

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

    public int nbCasesVides(List<String> list){
        int cmpt = 0;

        for(int i = 0; i<81; i++)
            if(list.get(i).equals(""))
    cmpt++;

        return cmpt;
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
                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                        grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "1");
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("1");

                        if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("1"))
                        {
                            casesVides--;
                            cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                            cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                        }
                        else
                            {
                                cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                                nbErreurs++;
                                Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                toast.show();
                            }
                        if (casesVides == 0) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                    }
                    //example de couleur
                    //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button2:

                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "2");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("2");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("2"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button3:

                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "3");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("3");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("3"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button4:

                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "4");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("4");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("4"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button5:
                Log.d("resoltuion ", Integer.toString(casesVides));
                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "5");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("5");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("5"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        Intent intent = new Intent(this, Fin.class);
                        intent.putExtra("EXTRA_MESSAGE", Integer.toString(nbErreurs));
                        startActivity(intent);
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button6:

                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "6");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("6");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("6"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button7:

                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "7");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("7");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("7"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button8:

                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "8");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("8");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("8"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button9:

                if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estModifiable()) {

                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView - 1, previousSelectedPosition), "9");
                    cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setValeur("9");

                    if(cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).estLaReponse("9"))
                    {
                        casesVides--;
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).devenirNonModifiable();
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(1);
                    }
                    else
                    {
                        cases.getCaseAt(previousSelectedGridView - 1, previousSelectedPosition).setCouleur(2);
                        nbErreurs++;
                        Toast toast = Toast.makeText(getApplicationContext(), Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                    if (casesVides == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Fin!!!!!!!!!"+ " nombre d'erreurs :" + Integer.toString(nbErreurs), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
                //example de couleur
                //cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setCouleur(2);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;

            case R.id.button10:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"");

                grilles.refreshNumbers(grilleAsList);

                cases.getCaseAt(previousSelectedGridView-1,previousSelectedPosition).setValeur("");

                grilles.invalidateViews();
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        //grilles.copyFromTo(grilleAsList);
    }

}
