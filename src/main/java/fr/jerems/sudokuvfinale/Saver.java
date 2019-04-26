package fr.jerems.sudokuvfinale;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

//ne pas mettre dans grilleAslist une mauvaise valeur car Saver va la souvgarde comme good
public class Saver {

    static public String grilleSauvegarde;

    static void save(List<String> grilleAsList, Activity activity){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grilleAsList.size(); i++) {
            if(grilleAsList.get(i) == "")
                sb.append(" ");
            else
                sb.append(grilleAsList.get(i));
        }
        SharedPreferences sharedPref = activity.getPreferences(activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("grille", sb.toString());
        editor.commit();
    }

    static String savePresent(Activity activity){
        SharedPreferences sharedPref = activity.getPreferences(activity.MODE_PRIVATE);
        grilleSauvegarde = sharedPref.getString("grille", null);
        return grilleSauvegarde;
    }

    static void load(List<String> grilleAsList, List<String> grilleResolu, Activity activity){


        for(int i =0; i<81; i++) {
            if (grilleSauvegarde.charAt(i) == ' ')
                grilleAsList.add("");
            else
                grilleAsList.add("" + grilleSauvegarde.charAt(i));
        }


        for(int i =0; i<81; i++) {
            if (grilleSauvegarde.charAt(i) == ' ')
                grilleResolu.add("");
            else
                grilleResolu.add("" + grilleSauvegarde.charAt(i));
        }
    }
}
