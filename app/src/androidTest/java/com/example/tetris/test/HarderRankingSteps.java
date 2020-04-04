package com.example.tetris.test;

import androidx.annotation.Nullable;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HarderRankingSteps {

    private static BBDDSimulator baseDeDatos, fila0;
    private static String tipoBBDD = "rankingNormal";

    public static class ContentValues implements Comparable<ContentValues>{
        private String name;
        private int score;

        public ContentValues() {
        }

        public void put(String _, String value) {
            this.name = value;
        }
        public void put(String _, int value) {
            this.score = value;
        }

        @Override
        public int compareTo(ContentValues o) {
            return Integer.compare(o.score, score);
        }
    }
    public static class BBDDSimulator {
        private ArrayList<ContentValues> bbdd;
        private int currentRow;

        public BBDDSimulator(ArrayList<ContentValues> bbdd) {
            this.bbdd = bbdd;
        }
        public boolean moveToFirst() {
            currentRow = 0;
            return true;
        }
        public boolean isAfterLast() {
            return currentRow > 5;
        }
        public boolean moveToNext() {
            if (currentRow < 6 && !(bbdd.get(currentRow).name.isEmpty())) {
                currentRow++;
                return true;
            }
            return false;
        }
        public void getWritableDatabase() {
            //fake function
        }
        public void insert(String _, @Nullable String __, ContentValues row) {
            baseDeDatos.bbdd.add(row);
        }
        public String getString (int index) {
            switch (index) {
                case 0: {
                    return bbdd.get(currentRow).name;
                }
                case 1: {
                    return Integer.toString(bbdd.get(currentRow).score);
                }
            }
            return "";
        }
        public void update (@Nullable String __, ContentValues row, @Nullable String _, String [] nombre){
            for (int i = 0; i < bbdd.size(); i++) {
                if (bbdd.get(i).name.equals(nombre[0])) {
                    bbdd.get(i).score = row.score;
                    break;
                }
            }
        }
        public void rawQuery (@Nullable String __, @Nullable String _) {
            Collections.sort(this.bbdd);
        }

        public int getInt(int i) {
            return bbdd.get(i-1).score;
        }

        public void close() {

        }
    }

    private void rellenerBBDD_Testeable(){
        //baseDeDatos = bbdd.getWritableDatabase();
        baseDeDatos.getWritableDatabase();

        ContentValues registro1 = new ContentValues();
        registro1.put("nombre", "Primero");
        registro1.put("puntuacion", 600);

        ContentValues registro2 = new ContentValues();
        registro2.put("nombre", "Segundo");
        registro2.put("puntuacion", 500);

        ContentValues registro3 = new ContentValues();
        registro3.put("nombre", "Tercero");
        registro3.put("puntuacion", 400);

        ContentValues registro4 = new ContentValues();
        registro4.put("nombre", "Cuarto");
        registro4.put("puntuacion", 300);

        ContentValues registro5 = new ContentValues();
        registro5.put("nombre", "Quinto");
        registro5.put("puntuacion", 200);

        ContentValues registro6 = new ContentValues();
        registro6.put("nombre", "Sexto");
        registro6.put("puntuacion", 100);
        baseDeDatos.insert("rankingNormal", null, registro1);
        baseDeDatos.insert("rankingNormal", null, registro2);
        baseDeDatos.insert("rankingNormal", null, registro3);
        baseDeDatos.insert("rankingNormal", null, registro4);
        baseDeDatos.insert("rankingNormal", null, registro5);
        baseDeDatos.insert("rankingNormal", null, registro6);
    }

    private String leerBBDD(){
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

        int i = 1;
        for(baseDeDatos.moveToFirst();!baseDeDatos.isAfterLast();baseDeDatos.moveToNext()){
            switch (i) {
                case 1:
                    j1 = baseDeDatos.getString(0);
                    p1 = baseDeDatos.getString(1);
                    break;
                case 2:
                    j2 = baseDeDatos.getString(0);
                    p2 = baseDeDatos.getString(1);
                    break;
                case 3:
                    j3 = baseDeDatos.getString(0);
                    p3 = baseDeDatos.getString(1);
                    break;
                case 4:
                    j4 = baseDeDatos.getString(0);
                    p4 = baseDeDatos.getString(1);
                    break;
                case 5:
                    j5 = baseDeDatos.getString(0);
                    p5 = baseDeDatos.getString(1);
                    break;
                case 6:
                    j6 = baseDeDatos.getString(0);
                    p6 = baseDeDatos.getString(1);
                    break;
                default:
                    break;
            }
            i++;
        }

        return j1 + p1 + j2 + p2 + j3 + p3 + j4 + p4 + j5 + p5 + j6 + p6;
    }

    public void nuevaPartidaJugada(){ //Funcion identica a la de Ranking.java pero aqui usando fakes para BBDD
        baseDeDatos.getWritableDatabase();
        fila0 = baseDeDatos; baseDeDatos.rawQuery("select * from "+tipoBBDD+
                "  order by puntuacion DESC", null);
        fila0.moveToFirst();
        ContentValues againnew = new ContentValues();
        againnew.put("puntuacion", fila0.getInt(1)+10);
        String whereArgs[] = {fila0.getString(0)};
        baseDeDatos = fila0; baseDeDatos.update(tipoBBDD, againnew, "nombre=?", whereArgs);
        baseDeDatos.close();
    }
    @Given("^DefaultRanking$")
    public void defaultranking() {
        ArrayList<ContentValues> bbdd = new ArrayList<>();
        baseDeDatos = new BBDDSimulator(bbdd);
        rellenerBBDD_Testeable(); //usamos este codigo tranquilos
        //porque fue testeado en la fase anterior
    }
    @When("^NewScoreWorseThanAllIsGotten$")
    public void newscoreworsethanallisgotten() {
        nuevaPartidaJugada();
    }
    @Then("^FirstScoreIncrementsTen$")
    public void firstscoreincrementsten()  {
        String expected = "Primero610Segundo500Tercero400Cuarto300Quinto200Sexto100";
        String obtained = leerBBDD();
        Assert.assertEquals("Cheking Harder Ranking", expected, obtained);
    }

}




