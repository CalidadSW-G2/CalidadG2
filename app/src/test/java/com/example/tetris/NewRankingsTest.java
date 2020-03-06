package com.example.tetris;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class NewRankingsTest {

    private BBDDSimulator fila1;

    public static class BBDDRow implements Comparable<BBDDRow>{
        private String name;
        private String score;

        public BBDDRow(String name, String score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(BBDDRow o) {
            return Integer.compare(Integer.parseInt(o.score), Integer.parseInt(score));
        }
    }
    public static class BBDDSimulator {
        private ArrayList<BBDDRow> bbdd = new ArrayList<>();
        private int currentRow;

        public BBDDSimulator(ArrayList<BBDDRow> bbdd) {
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
            if (currentRow < 6 && !(bbdd.get(Math.min(currentRow + 1, 5)).name.isEmpty())) {
                currentRow++;
                return true;
            }
            return false;
        }
        public String getString (int index) {
            switch (index) {
                case 0: {
                    return bbdd.get(currentRow).name;
                }
                case 1: {
                    return bbdd.get(currentRow).score;
                }
            }
            return "";
        }
        public void rawQuery () {
            Collections.sort(this.bbdd);
        }
    }

    @Before
    public void setUp() throws Exception {
        ArrayList<BBDDRow> bbdd = new ArrayList<>();
        BBDDRow filax1 = new BBDDRow("Juan", "1");
        bbdd.add(filax1);
        BBDDRow fila2 = new BBDDRow("Alberto", "2");
        bbdd.add(fila2);
        BBDDRow fila3 = new BBDDRow("Lucas", "4");
        bbdd.add(fila3);
        BBDDRow fila4 = new BBDDRow("Pedro", "3");
        bbdd.add(fila4);
        BBDDRow fila5 = new BBDDRow("Luis", "6");
        bbdd.add(fila5);
        BBDDRow fila6 = new BBDDRow("Federico", "10");
        bbdd.add(fila6);
        fila1 = new BBDDSimulator(bbdd);
    }

    @After
    public void tearDown() throws Exception {
        fila1.bbdd = new ArrayList<>();
        fila1.currentRow = 0;
    }

    @Test
    public void mostrarTop5() {

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

        fila1.rawQuery();

        int i = 1;
        for(fila1.moveToFirst();!fila1.isAfterLast();fila1.moveToNext()){
            switch (i) {
                case 1:
                    j1 = fila1.getString(0);
                    p1 = fila1.getString(1);
                    break;
                case 2:
                    j2 = fila1.getString(0);
                    p2 = fila1.getString(1);
                    break;
                case 3:
                    j3 = fila1.getString(0);
                    p3 = fila1.getString(1);
                    break;
                case 4:
                    j4 = fila1.getString(0);
                    p4 = fila1.getString(1);
                    break;
                case 5:
                    j5 = fila1.getString(0);
                    p5 = fila1.getString(1);
                    break;
                case 6:
                    j6 = fila1.getString(0);
                    p6 = fila1.getString(1);
                    break;
                default:
                    break;
            }
            i++;
        }

        String expected = "Federico10Luis6Lucas4Pedro3Alberto2Juan1";
        String obtained = j1 + p1 + j2 + p2 + j3 + p3 + j4 + p4 + j5 + p5 + j6 + p6;


        assertEquals("Checking ranking order", expected, obtained);
    }
}




