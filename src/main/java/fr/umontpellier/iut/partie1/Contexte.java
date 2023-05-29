package fr.umontpellier.iut.partie1;

import java.util.ArrayList;

public class Contexte {

    private final Taquin taquinInitial;
    private ArrayList<Taquin> solution;

    public Contexte(Taquin taquinInitial) {
        this.taquinInitial = taquinInitial;
        solution = new ArrayList<>();
    }

    public void resoudre() {
        ArrayList<Taquin> dejaVu = new ArrayList<>();
        ArrayList<Couple> frontiere = new ArrayList<>();
        boolean gagnant = false;
        frontiere.add(new Couple(taquinInitial, null));

        while (!frontiere.isEmpty() && !gagnant) {
            // Fonctionnement sous forme de pile
            if (frontiere.get(0).getTaquin().estGagnant()) {
                gagnant = true;
                solution = frontiere.get(0).getListeDeMouvements();
            } else {
                // On met à jour
                frontiere.get(0).mettreAJour(frontiere, dejaVu);
                frontiere.remove(frontiere.get(0));
            }
        }
    }

    public ArrayList<Taquin> getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < solution.size(); i++) {
            s = solution.get(i).toString() + "\n\n_______________________________";
        }
        return s;
    }
}
