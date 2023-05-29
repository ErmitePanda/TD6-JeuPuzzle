package fr.umontpellier.iut.partie2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.MinimalHTMLWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    public static int[][] grille_sudoku22_incomplete2() {
        return new int[][]{
                {4, 1, 2, 3},
                {0, 0, 1, 4},
                {0, 3, 4, 1},
                {1, 4, 3, 2}
        };
    }

    public static int [][] grille_sudoku_2fils_generer_fils() {
        return new int[][]{
                {0, 1, 2, 0},
                {0, 0, 1, 4},
                {2, 3, 4, 1},
                {1, 4, 3, 2}
        };
    }

    static int[][] grille_sudoku22_gagnante() {
        return new int[][]{
                {4, 1, 2, 3},
                {3, 2, 1, 4},
                {2, 3, 4, 1},
                {1, 4, 3, 2}};
    }

    static int[][] grille_sudoku_nongagnante_ligne() {
        return new int[][]{
                {4, 1, 2, 3},
                {3, 2, 1, 4},
                {2, 3, 4, 2},
                {1, 4, 3, 1}};
    }

    static int[][] grille_sudoku_invalide() {
        return new int[][]{
                {4, 1, 1, 3},
                {3, 2, 2, 4},
                {2, 3, 4, 2},
                {1, 4, 3, 1}};
    }

    static int[][] grille_sudoku_pour_generer_fils() {
        return new int[][]{
                {0, 0, 2, 3},
                {3, 2, 1, 4},
                {2, 3, 4, 1},
                {1, 4, 3, 2}};
    }

    @Test
    public void test_sudoku22_est_gagnant_vrai() {
        Sudoku sudoku = new Sudoku(grille_sudoku22_gagnante());
        assertTrue(sudoku.estGagnant());
    }

    @Test
    public void test_sudoku22_est_gagnant_faux_pbLignes() {
        Sudoku sudoku = new Sudoku(grille_sudoku_nongagnante_ligne());
        assertFalse(sudoku.estGagnant());
    }

    // Mes tests

    @Test
    public void test_sudoku_constructeur_par_recopie() {
        Sudoku s1 = new Sudoku(grille_sudoku22_gagnante());
        Sudoku s2 = s1.copieSudoku();
        assertTrue(s1.equals(s2));
    }

    @Test
    public void test_sudoku_equals() {
        Sudoku s1 = new Sudoku(grille_sudoku22_gagnante());
        Sudoku s2 = new Sudoku(grille_sudoku22_incomplete2());
        Sudoku s3 = new Sudoku(grille_sudoku22_gagnante());
        assertTrue(s1.equals(s1));
        assertFalse(s1.equals(s2));
        assertTrue(s1.equals(s3));
    }

    @Test
    public void test_sudoku_remplie() {
        Sudoku s1 = new Sudoku(grille_sudoku22_gagnante());
        Sudoku s2 = new Sudoku(grille_sudoku22_incomplete2());
        assertTrue(s1.grilleRemplie());
        assertFalse(s2.grilleRemplie());
    }

    @Test
    public void test_sudoku_valeur_valide() {
        Sudoku s1 = new Sudoku(grille_sudoku22_gagnante());
        Sudoku s2 = new Sudoku(grille_sudoku_invalide());

        assertTrue(s1.valeurValide(0,0));
        assertFalse(s2.valeurValide(0,1));
    }

    @Test
    public void test_sudoku_valNonPresente() {
        Sudoku s1 = new Sudoku(grille_sudoku22_incomplete2());
        ArrayList<Integer> valNonPresente = new ArrayList<>(); // i = 1 / j = 0
        valNonPresente.add(2);
        valNonPresente.add(3);
        assertEquals(valNonPresente, s1.valNonPresente(1,0));
    }

    @Test
    public void test_generer_2_fils() {
        Sudoku s = new Sudoku(grille_sudoku_2fils_generer_fils());
        ArrayList<Sudoku> filsSudokuGenerer = s.genererFils();
        int [][] fils1 = new int[][] {
                {3, 1, 2, 0},
                {0, 0, 1, 4},
                {2, 3, 4, 1},
                {1, 4, 3, 2}
        };
        int [][] fils2 = new int[][] {
                {4, 1, 2, 0},
                {0, 0, 1, 4},
                {2, 3, 4, 1},
                {1, 4, 3, 2}
        };

        Sudoku sudokuFils1 = new Sudoku(fils1);
        Sudoku sudokuFils2 =  new Sudoku(fils2);

        ArrayList<Sudoku> filsSudokuAjouter = new ArrayList<>();
        filsSudokuAjouter.add(sudokuFils1);
        filsSudokuAjouter.add(sudokuFils2);

        assertEquals(2, filsSudokuGenerer.size());
        assertEquals(filsSudokuAjouter, filsSudokuGenerer);
    }
}
