package fr.umontpellier.iut.partie2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

class HanoiTest {
    Hanoi h1;
    Hanoi h2;

    Hanoi h3;

    ArrayList<Integer> TG;
    ArrayList<Integer> TM;
    ArrayList<Integer> TD;

    @Test
    public void test_constructeur_1() {
        h1 = new Hanoi(4);
        h2 = new Hanoi(4);
        h3 = new Hanoi(5);
        assertTrue(h1.equals(h2));
        assertFalse(h1.equals(h3));
    }

    @Test
    public void test_constructeur_2() {
        TG = new ArrayList<>();
        TM = new ArrayList<>();
        TD = new ArrayList<>();
        TG.add(4);
        TG.add(3);
        TD.add(1);
        TM.add(2);

        h1 = new Hanoi(TG, TM, TD, 4);
        h2 = new Hanoi(TG, TM, TD, 4);
        h3 = new Hanoi(4);

        assertTrue(h1.equals(h2));
        assertFalse(h1.equals(h3));
    }

    @Test
    public void test_constructeur_par_recopie() {
        h1 = new Hanoi(5);
        h2 = new Hanoi(h1);
        assertTrue(h1.equals(h2));
    }

    @Test
    public void test_deplacement_valide() {
        h1 = new Hanoi(5);
        assertTrue(h1.deplacementValide(h1.getTourGauche(), h1.getTourMillieu()));
        assertFalse(h1.deplacementValide(h1.getTourGauche(), h1.getTourGauche()));
        assertFalse(h1.deplacementValide(h1.getTourMillieu(), h1.getTourGauche()));
    }

    @Test
    public void generer_fils() {
        h1 = new Hanoi(5);
        ArrayList<Hanoi> filsHanoi = h1.genererFils();
        assertTrue(filsHanoi.size() == 2);
    }

    @Test
    public void generer_fils_hanoi_modifier() {
        TG = new ArrayList<>();
        TM = new ArrayList<>();
        TD = new ArrayList<>();

        TG.add(3);
        TG.add(2);
        TM.add(1);

        h1 = new Hanoi(TG, TM, TD, 3);
        ArrayList<Hanoi> filsHanoi = h1.genererFils();
        assertTrue(filsHanoi.size() == 3);
    }

    @Test
    public void getListMouvement_hanoi() {
        TG = new ArrayList<>();
        TG.add(1);
        TM = new ArrayList<>();
        TM.add(2);
        TD = new ArrayList<>();
        TD.add(3);

        h1 = new Hanoi(TG ,TM ,TD ,3);

        TD.add(TM.remove(0));

        h2 = new Hanoi(TG, TM, TD, 3);

        TD.add(TG.remove(0));

        h3 = new Hanoi(TG, TM, TD, 3);

        Couple c1 = new Couple(h1, null);
        Couple c2 = new Couple(h2, c1);
        Couple c3 = new Couple(h3, c2);

        ArrayList<JeuPuzzle> res = c3.getListeDeMouvements();
        ArrayList<JeuPuzzle> res2 = new ArrayList<>();

        res2.add(h1);
        res2.add(h2);
        res2.add(h3);

        assertEquals(res, res2);
    }
}