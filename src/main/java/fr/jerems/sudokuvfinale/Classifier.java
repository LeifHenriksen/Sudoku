package fr.jerems.sudokuvfinale;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.Core;

import org.opencv.core.Mat;

import org.opencv.imgcodecs.Imgcodecs;


import java.util.HashMap;
import java.util.Map;

import static org.opencv.core.CvType.CV_8UC1;


public class Classifier {

    

  

    private static Map<Integer, int[][]> data;
    private static boolean loaded;

    /**
     * Load the training data for nearest neighbor comparision
     */
    private static void loadData() throws Exception {

        data = new HashMap<>();


        int [][]resources = new int[][]{
                {0,0,0,0,0,0,0},
                {0,R.drawable.e1_1,R.drawable.e1_2,R.drawable.e1_3,R.drawable.e1_4},
                {0,R.drawable.e2_1,R.drawable.e2_2,R.drawable.e2_3,R.drawable.e2_4},
                {0,R.drawable.e3_1,R.drawable.e3_2,R.drawable.e3_3,R.drawable.e3_4},
                {0,R.drawable.e4_1,R.drawable.e4_2,R.drawable.e4_3,R.drawable.e4_4},
                {0,R.drawable.e5_1,R.drawable.e5_2,R.drawable.e5_3,R.drawable.e5_4},
                {0,R.drawable.e6_1,R.drawable.e6_2,R.drawable.e6_3,R.drawable.e6_4},
                {0,R.drawable.e7_1,R.drawable.e7_2,R.drawable.e7_3,R.drawable.e7_4},
                {0,R.drawable.e8_1,R.drawable.e8_2,R.drawable.e8_3,R.drawable.e8_4},
                {0,R.drawable.e9_1,R.drawable.e9_2,R.drawable.e9_3,R.drawable.e9_4}};

        data.put(0, new int[25][25]);
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <=4; j++) {

                Mat s = Utils.loadResource(App.getContext(),resources[i][j],0);

                if(s.empty()) {
                    Log.d("testUl", "mauvais chemin!!!");
                }else {
                    Log.d("testUl", "bon chemin");
                }


                if (s.size().height!=25 || s.size().width!=25) throw new Exception("Need a 25x25 image for training..");
                int[][] _data = new int[25][25];
                for (int x = 0; x < 25; x++) {
                    for (int y = 0; y < 25; y++) {
                        _data[x][y] = (int) s.get(y, x)[0];
                    }
                }
                data.put(i*100 + j, _data);
            }
        }
    }

    /**
     * Compare the given mat image and return the nearest matching number
     */
    public static int getBox(Mat image) throws Exception{
        if (data==null) loadData();

        if (image.size().height!=25 || image.size().width!=25) throw new Exception("Need a 25x25 image for identification..");
        int max_match = 0;
        int max_match_count = 0;
        for (Integer i : data.keySet()) {
            int[][] _data = data.get(i);

            int count = 0;

            for (int x = 0; x < 25; x++) {
                for (int y = 0; y < 25; y++){
                    if ((int) image.get(y,x)[0] == _data[x][y]) count++;
                }
            }

            if (count > max_match_count) {
                max_match = i/100;
                max_match_count = count;
            }
        }
        return max_match;
    }
}

