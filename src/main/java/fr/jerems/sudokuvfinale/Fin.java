package fr.jerems.sudokuvfinale;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Fin extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoire);

        String str;
        Bundle extras = getIntent().getExtras();
        str = extras.getString("EXTRA_MESSAGE");
        TextView tv = (TextView)findViewById(R.id.tv1);

        tv.setText("nb d'erreurs = " + str);

    }
}
