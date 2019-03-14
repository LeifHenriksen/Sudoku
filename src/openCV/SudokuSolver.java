package openCV;

import org.opencv.core.Core;


public class SudokuSolver {
    public static void main(String[] args) {
    	  System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
     solveImage("C:\\Users\\jerem\\Downloads\\testfr-min.jpg");
     
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