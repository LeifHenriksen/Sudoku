package com.example.sudoku;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Fonction qui va commencer l'activity CameraActivity grace à un bouton
    public void prendrePhoto(View view){
        if(checkCameraHardware(getApplicationContext())){
            startActivity(new Intent(this,CameraActivity.class));
        }
    }

    //Fonction permettant de remplir un sudoku manuellement grace à l'activity EntreManuel
    public void grille(View view){
        startActivity(new Intent(this,EditeurGrille.class));
    }

    public void resoudSudokuPhoto(View view){
        startActivity(new Intent(this,MActivity.class));
    }

    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    public void jouerSudoku(View view){
        startActivity(new Intent(this, PlaySudoku.class));
    }
}
