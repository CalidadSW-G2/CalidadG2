package com.example.tetris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;

public class Rankings extends AppCompatActivity {
    private TextView textoRanking1;
    private TextView textoRanking2;
    private TextView textoRanking3;
    private TextView textoRanking4;
    private TextView textoRanking5;
    private TextView textoRanking6;
    private TextView mostrarPunt1;
    private TextView mostrarPunt2;
    private TextView mostrarPunt3;
    private TextView mostrarPunt4;
    private TextView mostrarPunt5;
    private TextView mostrarPunt6;
    private TextView num1;
    private TextView num2;
    private TextView num3;
    private TextView num4;
    private TextView num5;
    private TextView num6;
    private ImageView imageAvatar1;
    private ImageView imageAvatar2;
    private ImageView imageAvatar3;
    private ImageView imageAvatar4;
    private ImageView imageAvatar5;
    private ImageView imageAvatar6;
    private SQLiteDatabase baseDeDatos;
    private AdminSQLiteOpenHelper bbdd;
    private int modo;
    private String tipoBBDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle p = this.getIntent().getExtras();
        modo = p.getInt("modo");
        bbdd = new AdminSQLiteOpenHelper(this, "RankingJugadores", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        Button restEstadisticas =  findViewById(R.id.restablecerEstadisticas);
        Button menu= findViewById(R.id.goMenu);

        num1 = findViewById(R.id.primero);
        num2 = findViewById(R.id.segundo);
        num3 = findViewById(R.id.tercero);
        num4 = findViewById(R.id.cuarto);
        num5 = findViewById(R.id.quinto);
        num6 = findViewById(R.id.sexto);

        textoRanking1 = findViewById(R.id.mostrarRanking1);
        textoRanking2 = findViewById(R.id.mostrarRanking2);
        textoRanking3 = findViewById(R.id.mostrarRanking3);
        textoRanking4 = findViewById(R.id.mostrarRanking4);
        textoRanking5 = findViewById(R.id.mostrarRanking5);
        textoRanking6 = findViewById(R.id.mostrarRanking6);

        mostrarPunt1= findViewById(R.id.textpunt1);
        mostrarPunt2= findViewById(R.id.textpunt2);
        mostrarPunt3= findViewById(R.id.textpunt3);
        mostrarPunt4= findViewById(R.id.textpunt4);
        mostrarPunt5= findViewById(R.id.textpunt5);
        mostrarPunt6= findViewById(R.id.textpunt6);

        imageAvatar1 = findViewById(R.id.imageJ1);
        imageAvatar2 = findViewById(R.id.imageJ2);
        imageAvatar3 = findViewById(R.id.imageJ3);
        imageAvatar4 = findViewById(R.id.imageJ4);
        imageAvatar5 = findViewById(R.id.imageJ5);
        imageAvatar6 = findViewById(R.id.imageJ6);

        mostrarTop5();

        restEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restablecerEstadiaticas(v);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMenu = new Intent(Rankings.this, Inicio.class);
                startActivity(intentMenu);
            }
        });

    }

    public void mostrarTop5 (){
        baseDeDatos = bbdd.getWritableDatabase();
        String j1="";
        String j2="";
        String j3="";
        String j4="";
        String j5="";
        String j6="";
        String p1="";
        String p2="";
        String p3="";
        String p4="";
        String p5="";
        String p6="";
        Bitmap bitmap1 = null;
        Bitmap bitmap2 = null;
        Bitmap bitmap3 = null;
        Bitmap bitmap4 = null;
        Bitmap bitmap5 = null;
        Bitmap bitmap6 = null;

        //********************** AMBAS FUNCIONAN

        if(modo==0){
            tipoBBDD = "rankingNormal";
        }else{
            tipoBBDD = "rankingHard";
        }

        Cursor fila1 = baseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by puntuacion DESC",null);

        int i = 1;
        if(fila1.moveToFirst()){

            while(!fila1.isAfterLast()){
                switch (i){
                    case 1:
                        mostrarTop5Aux(j1,p1,fila1,bitmap1,i);
                        imageAvatar1.setVisibility(View.VISIBLE);
                        num1.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        mostrarTop5Aux(j2,p2,fila1,bitmap2,i);
                        imageAvatar2.setVisibility(View.VISIBLE);
                        num2.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        mostrarTop5Aux(j3,p3,fila1,bitmap3,i);
                        imageAvatar3.setVisibility(View.VISIBLE);
                        num3.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        mostrarTop5Aux(j4,p4,fila1,bitmap4,i);
                        imageAvatar4.setVisibility(View.VISIBLE);
                        num4.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        mostrarTop5Aux(j5,p5,fila1,bitmap5,i);
                        imageAvatar5.setVisibility(View.VISIBLE);
                        num5.setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        mostrarTop5Aux(j6,p6,fila1,bitmap6,i);
                        imageAvatar6.setVisibility(View.VISIBLE);
                        num6.setVisibility(View.VISIBLE);
                }
                fila1.moveToNext();
                i++;
            }

        }else {
            j1="";
            j2="";
            j3="";
            j4="";
            j5="";
            j6="";
            p1="";
            p2="";
            p3="";
            p4="";
            p5="";
            p6="";
        }

        textoRanking1.setText(j1);
        textoRanking2.setText(j2);
        textoRanking3.setText(j3);
        textoRanking4.setText(j4);
        textoRanking5.setText(j5);
        textoRanking6.setText(j6);

        mostrarPunt1.setText(p1);
        mostrarPunt2.setText(p2);
        mostrarPunt3.setText(p3);
        mostrarPunt4.setText(p4);
        mostrarPunt5.setText(p5);
        mostrarPunt6.setText(p6);

        baseDeDatos.close();
    }

    public void mostrarTop5Aux(String j, String p,Cursor fila1,Bitmap bitmap,int i){
        j = fila1.getString(0);
        p = fila1.getString(1);
        byte[] blob = fila1.getBlob(2);
        if(blob!=null) {
            ByteArrayInputStream bais = new ByteArrayInputStream(blob);
            bitmap = BitmapFactory.decodeStream(bais);
            switch (i) {
                case 1:
                    imageAvatar1.setImageBitmap(bitmap);
                    break;
                case 2:
                    imageAvatar2.setImageBitmap(bitmap);
                    break;
                case 3:
                    imageAvatar3.setImageBitmap(bitmap);
                    break;
                case 4:
                    imageAvatar4.setImageBitmap(bitmap);
                    break;
                case 5:
                    imageAvatar5.setImageBitmap(bitmap);
                    break;
                case 6:
                    imageAvatar6.setImageBitmap(bitmap);
                    break;
            }
        }
    }

    public void restablecerEstadiaticas (View view){
        baseDeDatos = bbdd.getWritableDatabase();

        if(modo==0){
            tipoBBDD = "rankingNormal";
        }else{
            tipoBBDD = "rankingHard";
        }
        baseDeDatos.execSQL("DELETE FROM "+tipoBBDD);
        Toast.makeText(this, "Estadisticas restablecidas", Toast.LENGTH_SHORT).show();
        baseDeDatos.close();

        imageAvatar1.setVisibility(View.INVISIBLE);
        num1.setVisibility(View.INVISIBLE);
        imageAvatar2.setVisibility(View.INVISIBLE);
        num2.setVisibility(View.INVISIBLE);
        imageAvatar3.setVisibility(View.INVISIBLE);
        num3.setVisibility(View.INVISIBLE);
        imageAvatar4.setVisibility(View.INVISIBLE);
        num4.setVisibility(View.INVISIBLE);
        imageAvatar5.setVisibility(View.INVISIBLE);
        num5.setVisibility(View.INVISIBLE);
        imageAvatar6.setVisibility(View.INVISIBLE);
        num6.setVisibility(View.INVISIBLE);

        mostrarTop5();
    }

}
