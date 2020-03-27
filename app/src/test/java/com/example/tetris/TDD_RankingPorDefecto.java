package com.example.tetris;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class TDD_RankingPorDefecto {

    private BBDDSimulator simulatedBBDD;

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
        public boolean moveToNext() {
            if (currentRow < 6 && !(bbdd.get(currentRow + 1).name.isEmpty())) {
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
        BBDDRow filax1 = new BBDDRow("", "");
        bbdd.add(filax1);
        BBDDRow fila2 = new BBDDRow("", "");
        bbdd.add(fila2);
        BBDDRow fila3 = new BBDDRow("", "");
        bbdd.add(fila3);
        BBDDRow fila4 = new BBDDRow("", "");
        bbdd.add(fila4);
        BBDDRow fila5 = new BBDDRow("", "");
        bbdd.add(fila5);
        BBDDRow fila6 = new BBDDRow("", "");
        bbdd.add(fila6);
        simulatedBBDD = new BBDDSimulator(bbdd);
    }

    @After
    public void tearDown() throws Exception {
        simulatedBBDD.bbdd = new ArrayList<>();
        simulatedBBDD.currentRow = 0;
    }

    private void rellenerBBDD_Testeable(){
        //to be done
    }

    @Test
    public void testRellenar() {
        String expected = "Primero 600 Segundo 500 Tercero 400 Cuarto 300 Quinto 200 Sexto 100";
        String obtained = "";

        rellenerBBDD_Testeable();

        assertEquals("Cheking BBDD default data", expected, obtained);
    }
}
