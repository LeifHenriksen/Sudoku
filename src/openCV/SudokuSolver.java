package openCV;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgcodecs.Imgcodecs.*;
import org.opencv.imgproc.Imgproc;;


public class SudokuSolver {
    public static void main(String[] args) {
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	Size size= new Size(344,726);//on redimensionne l'image afin qu'elle pese moins lourd
    	   Mat src= Imgcodecs.imread("C:\\Users\\jerem\\Downloads\\testfr.jpg");
        Mat dest= new Mat();//dst image
     //src image
        Imgproc.resize(src,dest,size,0,0,Imgproc.INTER_LINEAR);//resize image
        Imgcodecs.imwrite("C:\\Users\\jerem\\Downloads\\about2.jpg", dest);

     solveImage("C:\\\\Users\\\\jerem\\\\Downloads\\\\test3.png");
    
    
    }
   //Resout  une grille de sudoku a partir d'une image
    public static void solveImage (String filename) {

        long startTime = System.currentTimeMillis();

		Sudoku sudoku = ImageManipulator.convertToSudoku(filename, false);
		if (sudoku==null) {
		  System.out.println("Désole votre grille n'a pas pu être identifié,essayer de prendre une autre photo...");
		    return;
		}
		sudoku.print();
		sudoku.estValide(sudoku.getGrille(), 0);
		sudoku.print();
		System.out.println("Bravo!");
		
		
		

		System.out.println("\nTemps de résolution  : "+ (System.currentTimeMillis() - startTime)+ " ms");
        

    }



}