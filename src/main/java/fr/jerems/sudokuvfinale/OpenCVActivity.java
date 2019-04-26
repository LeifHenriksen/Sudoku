package fr.jerems.sudokuvfinale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class OpenCVActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opencv_activity);
    }
    public  void page (View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    public  void jouer (View view){
        startActivity(new Intent(this,CameraActivity.class));
    }
}
