package com.example.sudokubis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Niveau extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niveau);
    }

    public void niveauFacile(View view){
        startActivity(new Intent(this,PlaySudoku.class ));
    }
    public void niveauInter(View view){ startActivity(new Intent(this, PlaySudoku2.class));}
    public void niveauSenior(View view){ startActivity(new Intent(this, PlaySudoku3.class));}

}
