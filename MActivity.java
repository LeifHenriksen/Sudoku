package com.example.sudoku;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class MActivity extends AppCompatActivity {
        private static Context context;
        private ImageView imgPhoto;
        private Button btnphoto;
        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            context=getApplicationContext();
            System.loadLibrary("opencv_java3");
            setContentView(R.layout.activity_m);
            //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

            initActivity();


            Log.d("Creation","test132155");
        }

        private void initActivity(){
            imgPhoto= (ImageView)findViewById(R.id.imgPhoto);
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
        String currentPhotoPath;
        private File createImageFile() throws IOException {
            // Create an image file name
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String imageFileName = "JPEG_" + timeStamp + "_";
            File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            File image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );

            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = image.getAbsolutePath();
            return image;
        }

        public void onActivityResult(int requestCode,int resultCode,Intent data){
            int tabEdiGrille[][] = new int[9][9];
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
                imgPhoto.setImageBitmap(image);
                Size size= new Size(344,726);//on redimensionne l'image afin qu'elle pese moins lourd
                Mat src= Imgcodecs.imread(imgPath);
                try {
                    File imageFile = createImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(src.height() > 727 && src.width() >345) {
                    Mat dest= new Mat();//dst image
                    String resizePath=imgPath;
                    Imgproc.resize(src,dest,size,344,726,Imgproc.INTER_LINEAR);//resize image
                    Imgcodecs.imwrite(currentPhotoPath, dest);
                    System.out.println("laaaaaaaaaaaaaaaaaaaaa" + currentPhotoPath);
                    if ((SudokuSolver.solveImage(currentPhotoPath)) !=null) {
                        tabEdiGrille = (SudokuSolver.solveImage(currentPhotoPath)).getGrille();
                    }else{
                        Log.d("bcdebeho", "vkfzgnjrpbzrv");
                    }
                }else {

                    tabEdiGrille = (SudokuSolver.solveImage(imgPath)).getGrille();
                }


                Log.d("finResolution", imgPath);

                Intent intent = new Intent(this, EditeurGrille.class);

                for(int i = 0 ; i<9; i++)
                    for(int j = 0 ; j<9; j++)
                        System.out.println(tabEdiGrille[i][j]);

                intent.putExtra("EXTRA_MESSAGE", Sudoku.arrToTabString(tabEdiGrille));

                startActivity(intent);
            }
            else{
                Toast.makeText(this,"aucune image selectione", Toast.LENGTH_LONG).show();
            }
        }


    }