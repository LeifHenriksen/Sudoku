package fr.jerems.sudokuvfinale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void page (View view){
        startActivity(new Intent(this, DetecteurGrille.class));
    }
    public  void photo (View view){
        startActivity(new Intent(this,CameraActivity.class));
    }
    public  void jouer (View view){
        String[] maGrille = {
                "5","","","","","","","","3",
                "","9","","","","8","","","",
                "","","","","4","","","6","",
                "8","","4","","","","9","5","",
                "","","","","3","","4","1","",
                "1","","","","","4","7","","",
                "2","","","4","","5","","","",
                "","","","","1","","","8","",
                "","","8","2","","","","9",""
        };
        Intent intent = new Intent(this, Jouer.class);
        intent.putExtra("EXTRA_MESSAGE", maGrille);
        startActivity(intent);
    }
}
