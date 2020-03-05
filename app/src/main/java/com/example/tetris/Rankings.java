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
    private String tipoBBDD = "rankingNormal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bundle p = this.getIntent().getExtras();
        int modo = p.getInt("modo");
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

        if(modo != 0){
            tipoBBDD = "rankingHard";
        }

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

        //********************** AMBAS FUNCIONAN

        Cursor fila1 = baseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by puntuacion DESC",null);

        int i = 1;
        for(fila1.moveToFirst();!fila1.isAfterLast();fila1.moveToNext()){
            switch (i) {
                case 1:
                    j1 = fila1.getString(0);
                    p1 = fila1.getString(1);
                    imageAvatar1.setVisibility(View.VISIBLE);
                    imageAvatar1.setImageBitmap(mostrarTop5Aux(fila1));
                    num1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    j2 = fila1.getString(0);
                    p2 = fila1.getString(1);
                    imageAvatar2.setVisibility(View.VISIBLE);
                    imageAvatar2.setImageBitmap(mostrarTop5Aux(fila1));
                    num2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    j3 = fila1.getString(0);
                    p3 = fila1.getString(1);
                    imageAvatar3.setVisibility(View.VISIBLE);
                    imageAvatar3.setImageBitmap(mostrarTop5Aux(fila1));
                    num3.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    j4 = fila1.getString(0);
                    p4 = fila1.getString(1);
                    imageAvatar4.setVisibility(View.VISIBLE);
                    imageAvatar4.setImageBitmap(mostrarTop5Aux(fila1));
                    num4.setVisibility(View.VISIBLE);
                    break;
                case 5:
                    j5 = fila1.getString(0);
                    p5 = fila1.getString(1);
                    imageAvatar5.setVisibility(View.VISIBLE);
                    imageAvatar5.setImageBitmap(mostrarTop5Aux(fila1));
                    num5.setVisibility(View.VISIBLE);
                    break;
                case 6:
                    j6 = fila1.getString(0);
                    p6 = fila1.getString(1);
                    imageAvatar6.setVisibility(View.VISIBLE);
                    imageAvatar6.setImageBitmap(mostrarTop5Aux(fila1));
                    num6.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
            i++;
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

    public Bitmap mostrarTop5Aux(Cursor fila1){
        byte[] blob = fila1.getBlob(2);
        if(blob!=null) {
            ByteArrayInputStream bais = new ByteArrayInputStream(blob);
            return BitmapFactory.decodeStream(bais);
        }
        return null;
    }

    public void restablecerEstadiaticas (View view){
        baseDeDatos = bbdd.getWritableDatabase();

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