/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hugo
 */
public class Partie {
Grille grilleJeu = new Grille();
 



void initialiserPartie() {
        //Mise en place de la grille
        grilleJeu.viderGrille();

        Scanner sc = new Scanner(System.in);
        System.out.println("Choix du pseudo du joueur :");
        Joueur joueur = new Joueur(sc.nextLine());
        
        System.out.println("Choix du nombre de lignes");
        int largeur = sc.nextInt();
        System.out.println("Choix du nombre de colonnes");
        int longueur = sc.nextInt();
        
        //générer mines
        Random r = new Random();
        int mineAleat = r.nextInt( - min + 1) + min;
        
        
        int compteur = 0;
        for (int i = 0; i < 5; i++) {
            int ligne_mine = r.nextInt(largeur);
            int colonne_mine = r.nextInt(longueur);
            if (compteur < 2) {
                if (!grilleJeu.placerMine(ligne_mine, colonne_mine)) {
                    compteur--;
                }
                compteur = compteur + 1;
            }
            if (!grilleJeu.placerTrouNoir(ligne_trou_noir, colonne_trou_noir)) {
                i--;
            }
        }


        grilleDeJeu.afficherGrilleSurConsole();

    }
}