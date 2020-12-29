/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineur;

/**
 *
 * @author Hugo
 */
public class Grille {
int largeur;
int longueur;
Cellule[][] Cellules = new Cellule[largeur][longueur];

Grille() {
        for (int i=0; i<largeur; i++) {
            for (int j=0; j<longueur; j++) {
                Cellules[i][j] = new Cellule();
            }
        }
    }

void activer_mine(int column) { // ressort vrai si il y a un desing
        int i = largeur-1;
        while (Cellules[i][column]. == null) {
            i--;
            if (i == 0) {
                break;
            }
        }
        if (i >= 0 && i < 6) {
            Cellules[i][column].activerMine();
        }
        

    }

boolean analyseCellule() {
 
for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < longueur; j++) {
        
             if (Cellules[i][j].mine == false) {
                 Cellules[i][j].proxiMine = 
             }
             
    }
}
}

void ouvrirCellule() {
    
}

void viderGrille() {
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < longueur; j++) {
                Cellules[i][j].mine = false;
                Cellules[i][j].proxiMine = 0;
                Cellules[i][j].kitDeDeminage = false;
                    
                }
            }
        }
    
 boolean placerTrouNoir(int ligne, int colonne) {
        if (!Cellules[ligne][colonne].mine) {
            Cellules[ligne][colonne].mine = true;
            return true;
        }
        return false;
    } 

}

