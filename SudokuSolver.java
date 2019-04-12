package com.example.sudoku;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SudokuSolver extends AppCompatActivity implements View.OnClickListener{

    private int previousSelectedPosition = -1;
    private int previousSelectedGridView = -1;
    private AdapterView.OnItemClickListener itemClickListener;
    private Grille grilles;

    private List<String> grilleAsList;

    private static Context context;
    private Button btnphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_solver);

        context=getApplicationContext();
        System.loadLibrary("opencv_java3");
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Log.d("Creation","test132155");
        initActivity();

        final SudokuSolver activity = this;

        grilles = new Grille(findViewById(R.id.container));


        // Initializing a new String Array
        String[] maGrille = new String[]{
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","","",
                "","","","","","","","",""
        };

        // Populate a List from Array elements
        grilleAsList = new ArrayList<String>(Arrays.asList(maGrille));

        //grilleAsList = new ArrayList<String>(Arrays.asList(maGrille));

        grilles.setAdapters(grilleAsList,this);
        // Data bind GridView with ArrayAdapter (String Array elements)

        itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                grilles.click(parent, view, position, id, activity);
            }
        };

        grilles.setClickListeners(itemClickListener);

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
    }

    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button1:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"1");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button2:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"2");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button3:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"3");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button4:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"4");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button5:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"5");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button6:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"6");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button7:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"7");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button8:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"8");


                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button9:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"9");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;

            case R.id.button10:
                if(previousSelectedPosition != -1)
                    grilleAsList.set(grilles.getPositionGrille(previousSelectedGridView-1,previousSelectedPosition),"");

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;

            case R.id.button12:
                int[][] tab = new int[9][9];

                for(int i = 0; i<9 ; i++)
                {
                    for (int j = 0; j < 9; j++) {
                        tab[i][j] = 0;
                    }
                }

                Sudoku.arrToList(tab  , grilleAsList);

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();
                break;
            case R.id.button11:
                //===================================Resolution=============================================//
                Toast toast = Toast.makeText(getApplicationContext(),"Resolution en marche", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                int millis = Calendar.getInstance().get(Calendar.MILLISECOND);

                Sudoku sudk = new Sudoku(Sudoku.listToArr(grilleAsList));
                //int sec = Calendar.getInstance().get(Calendar.SECOND);
                sudk.estValide(sudk.getGrille(), 0);
                Sudoku.arrToList(sudk.getGrille()  , grilleAsList);

                toast = Toast.makeText(getApplicationContext(),"Temps de resolution milliseconds = " + (Calendar.getInstance().get(Calendar.MILLISECOND) - millis), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                grilles.refreshNumbers(grilleAsList);
                grilles.invalidateViews();


                //===================================Fin Resolution=============================================//
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

        //grilles.copyFromTo(grilleAsList);
    }

    void setPreviousSelectedPosition(int x){
        previousSelectedPosition = x;
    }

    int getPreviousSelectedPosition(){
        return previousSelectedPosition;
    }

    void setPreviousSelectedGridView(int x){
        previousSelectedGridView = x;
    }

    int getPreviousSelectedGridView(){
        return previousSelectedGridView;
    }

    //Resout  une grille de sudoku a partir d'une image
    public void solveImage(String filename) {

        long startTime = System.currentTimeMillis();

        Sudoku sudoku = ImageManipulator.convertToSudoku(filename, false);
        if (sudoku==null) {
            System.out.println("D�sole votre grille n'a pas pu �tre identifi�,essayer de prendre une autre photo...");
            return;
        }
        sudoku.print();
        sudoku.estValide(sudoku.getGrille(), 0);
        sudoku.arrToList(sudoku.getGrille(), grilleAsList);
        grilles.refreshNumbers(grilleAsList);
        grilles.invalidateViews();
        System.out.println("grille normalement résolu s'affiche");
        sudoku.estValide(sudoku.getGrille(), 0);
        sudoku.print();
    }

    private void initActivity(){
        btnphoto= (Button)findViewById(R.id.btnPhoto);
        createOnClickPhotoButton();
    }

    private void createOnClickPhotoButton(){

        btnphoto.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //acces a la gallerie
                Intent galleryIntent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,1);
            }
        });
    }

    public void onActivityResult(int requestCode,int resultCode,Intent data){

        super.onActivityResult(requestCode,resultCode,data);
        //on verifie si l'image a été recuperee
        if(requestCode==1 && resultCode==RESULT_OK){
            //acces a l'image a partir de data
            Uri selectedImage= data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = this.getContentResolver().query(selectedImage, filePathColumn,null,null,null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String imgPath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap image = BitmapFactory.decodeFile(imgPath);
            Log.d("imgPath", imgPath);
            Size size= new Size(344,726);//on redimensionne l'image afin qu'elle pese moins lourd
            Mat src= Imgcodecs.imread(imgPath);
            if(src.height() > 727 && src.width() >345) {
                Mat dest= new Mat();//dst image
                String resizePath=imgPath;
                Imgproc.resize(src,dest,size,344,726,Imgproc.INTER_LINEAR);//resize image
                Imgcodecs.imwrite(resizePath, dest);
                solveImage(resizePath);
            }else {

                solveImage(imgPath);
            }
            Log.d("finResolution", imgPath);
        }
        else{
            Toast.makeText(this,"aucune image selectione", Toast.LENGTH_LONG).show();
        }
    }

}
