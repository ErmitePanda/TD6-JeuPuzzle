package fr.umontpellier.iut.partie1;

import fr.umontpellier.iut.partie2.Contexte;
import fr.umontpellier.iut.partie2.Hanoi;
import fr.umontpellier.iut.partie2.JeuPuzzle;
import fr.umontpellier.iut.partie2.Taquin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContexteTest {

    @BeforeEach
    void disableConsole() {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int arg0) {
            }
        }));
    }

    @Test
    public void test_no_exception() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Contexte c = new Contexte(new Taquin(data));
        assertDoesNotThrow(() -> c.resoudre());
    }

    @Test
    public void test_solution_resoluble() {
        int[][] dataContexte = {
                {1,2,3},
                {4,0,5},
                {7,8,6}
        };

        Contexte c = new Contexte(new Taquin(dataContexte));

        c.resoudre();

        ArrayList<JeuPuzzle> solutionContexte = c.getSolution();

        ArrayList<Taquin> solutionData = new ArrayList<>();
        int[][] data1 = {
                {1,2,3},
                {4,0,5},
                {7,8,6}
        };
        int[][] data2 = {
                {1,2,3},
                {4,5,0},
                {7,8,6}
        };
        int[][] data3 = {
                {1,2,3},
                {4,5,6},
                {7,8,0}
        };
        Taquin t1 = new Taquin(data1);
        Taquin t2 = new Taquin(data2);
        Taquin t3 = new Taquin(data3);

        solutionData.add(t1);
        solutionData.add(t2);
        solutionData.add(t3);

        assertEquals(solutionContexte.size(), solutionData.size());
        assertTrue(solutionContexte.equals(solutionData));
    }


}