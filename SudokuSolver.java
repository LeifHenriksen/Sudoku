package com.example.sudoku;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.opencv.core.Core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SudokuSolver extends AppCompatActivity {

    private static Sudoku sodu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_solver);

    }

    public static void resoudre(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        solveImage("120.jpg");
    }

    public static void solveImage (String filename) {

        long startTime = System.currentTimeMillis();

        sodu = ImageManipulator.convertToSudoku(filename, false);

        if (sodu==null) {
            System.out.println("Désole votre grille n'a pas pu être identifié,essayer de prendre une autre photo...");
            return;
        }
        sodu.print();
        sodu.estValide(sodu.getGrille(), 0);
        sodu.print();
        System.out.println("Bravo!");


        System.out.println("\nTemps de résolution  : "+ (System.currentTimeMillis() - startTime)+ " ms");


    }


}
