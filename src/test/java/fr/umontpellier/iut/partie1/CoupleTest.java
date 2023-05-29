package fr.umontpellier.iut.partie1;

import fr.umontpellier.iut.partie2.Contexte;
import fr.umontpellier.iut.partie2.Couple;
import fr.umontpellier.iut.partie2.JeuPuzzle;
import fr.umontpellier.iut.partie2.Taquin;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoupleTest {
    @Test
    public void test_couple_getListeDeMouvements() {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Taquin taquin1 = new Taquin(data1);

        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Taquin taquin2 = new Taquin(data2);

        Couple couple2 = new Couple(taquin2, null);
        Couple couple1 = new Couple(taquin1, couple2);

        ArrayList<JeuPuzzle> res = couple1.getListeDeMouvements();
        ArrayList<Taquin> res2 = new ArrayList<>();
        res2.add(taquin2);
        res2.add(taquin1);
        assertEquals(res, res2);
    }

    @Test
    public void test_couple_getListeDeMouvements_plusieurs_etapes() {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Taquin taquin1 = new Taquin(data1);

        int[][] data2 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        Taquin taquin2 = new Taquin(data2);

        int[][] data3 = {{1, 2, 3}, {4, 0, 5}, {7, 8, 6}};
        Taquin taquin3 = new Taquin(data2);

        Couple couple3 = new Couple(taquin3, null);
        Couple couple2 = new Couple(taquin2, couple3);
        Couple couple1 = new Couple(taquin1, couple2);

        ArrayList<JeuPuzzle> res = couple1.getListeDeMouvements();
        ArrayList<Taquin> res2 = new ArrayList<>();
        res2.add(taquin3);
        res2.add(taquin2);
        res2.add(taquin1);
        /*Contexte c = new Contexte(taquin3); ==> Boucle infini
        c.resoudre();
        System.out.println(c);*/
        assertEquals(res, res2);
    }

    @Test
    public void test_couple_mise_a_jour() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin taquin = new Taquin(data);
        Couple c = new Couple(taquin, null);


        int[][] datafils1 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        Taquin fils1 = new Taquin(datafils1);
        ArrayList<JeuPuzzle> dejavu = new ArrayList<>();
        dejavu.add(fils1);

        ArrayList<Couple> frontiere = new ArrayList<>();

        c.mettreAJour(frontiere, dejavu);
        assertTrue(frontiere.size() == 1 && dejavu.size() == 2);
    }
}