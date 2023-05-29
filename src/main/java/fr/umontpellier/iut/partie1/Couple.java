package fr.umontpellier.iut.partie1;

import java.util.ArrayList;
import java.util.Collections;

public class Couple {

    private final Taquin taquin;
    private Couple predecesseur;

    public Couple(Taquin taquin, Couple predecesseur) {
        this.taquin = taquin;
        this.predecesseur = predecesseur;
    }

    /**
     * Vérifie si les fils du taquin sont déjà vus et met à jour la frontière
     * et l'ensemble des configurations déjà vues.
     */
    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<Taquin> dejaVus) {
        ArrayList<Taquin> filsTaquin = taquin.genererFils();
        Couple c;
        for (int i = 0; i < filsTaquin.size(); i++) {
            if (!dejaVus.contains(filsTaquin.get(i))) {
                c = new Couple(filsTaquin.get(i), this);
                frontiere.add(c);
                dejaVus.add(filsTaquin.get(i));
            }
        }
    }

    /**
     * @return la liste des taquins intermédiaire à partir du taquin initial
     * et jusqu'au taquin courant
     */
    public ArrayList<Taquin> getListeDeMouvements() {
        if (taquin == null) return new ArrayList<Taquin>();
        ArrayList<Taquin> listeMouvement = new ArrayList<>();
        Couple c = this;
        while (c != null) {
            listeMouvement.add(c.taquin);
            c = c.predecesseur;
        }

        Collections.reverse(listeMouvement);

        return listeMouvement;
    }

    public Taquin getTaquin() {
        return taquin;
    }
}
