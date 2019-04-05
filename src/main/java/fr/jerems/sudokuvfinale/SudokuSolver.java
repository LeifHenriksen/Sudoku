package fr.jerems.sudokuvfinale;

import android.provider.Settings;
import android.util.Log;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgcodecs.Imgcodecs.*;
import org.opencv.imgproc.Imgproc;;
import static org.opencv.imgproc.Imgproc.*;


public class SudokuSolver {

	public static void Solver() {
		Log.d("Creation","*****************************************qsdhhqs********************\n");
		System.loadLibrary("opencv_java3");
    	//Size size= new Size(344,726);//on redimensionne l'image afin qu'elle pese moins lourd
		// Mat src= Imgcodecs.imread("media/storage/emulated/0/Download/722px-Sudoku_Puzzle_by_L2G-20050714_standardized_layout.svg.png");
    	//Mat dest= new Mat();//dst image
     	//src image
    	//Imgproc.resize(src,dest,size,0,0,Imgproc.INTER_LINEAR);//resize image
   		//Imgcodecs.imwrite("media/storage/emulated/0/Download/722px-Sudoku_Puzzle_by_L2G-20050714_standardized_layout.svg.png", dest);



     	solveImage("file:///storage/emulated/0/Download/260px-Sudoku_Puzzle_by_L2G-20050714_standardized_layout.svg.png");
     	Log.d("Creation","2222222222222222222222222222222222222222222222222222222222\n");
    
    }
   //Resout  une grille de sudoku a partir d'une image
    public static void solveImage (String filename) {

        long startTime = System.currentTimeMillis();

		Sudoku sudoku = ImageManipulator.convertToSudoku(filename, false);
		if (sudoku==null) {
		  System.out.println("D�sole votre grille n'a pas pu �tre identifi�,essayer de prendre une autre photo...");
		    return;
		}
		sudoku.print();
		//sudoku.estValide(sudoku.getGrille(), 0);
		//sudoku.print();
		System.out.println("Bravo!");
		
		
		

		System.out.println("\nTemps de r�solution  : "+ (System.currentTimeMillis() - startTime)+ " ms");
        

    }



}