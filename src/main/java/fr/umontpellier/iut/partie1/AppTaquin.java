package fr.umontpellier.iut.partie1;

import fr.umontpellier.iut.partie2.Taquin;

public class AppTaquin {
    public static void main(String[] args) {
        int [][] mat = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        Taquin t = new Taquin(mat);
        System.out.println(t);
    }
}
