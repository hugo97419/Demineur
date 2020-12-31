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
        while (Cellules[i][column].mine == false) {
            i--;
            if (i == 0) {
                break;
            }
        }
        if (i >= 0 && i < largeur) {
            Cellules[i][column].activerMine();
        }
        

    }

int analyseMine(int lignes, int colonnes) {
    if (lignes >= 0 && lignes <largeur && colonnes >= 0 && colonnes < longueur && Cellules[lignes][colonnes].mine == true) {
        return 1;
    }
        return 0;
 }

int analyseMineAutour(int lignes, int colonnes) {
   int nbMines  = 0;
 
   nbMines += analyseMine(lignes+1, colonnes);
   nbMines += analyseMine(lignes, colonnes+1);
   nbMines += analyseMine(lignes+1, colonnes+1);
   
   nbMines += analyseMine(lignes-1, colonnes);
   nbMines += analyseMine(lignes, colonnes-1);
   nbMines += analyseMine(lignes-1, colonnes-1);
   
   nbMines += analyseMine(lignes+1, colonnes-1);
   nbMines += analyseMine(lignes-1, colonnes+1);
 
   return nbMines;
}
    
void ouvrirCellules(int lignes, int colonnes) {
    if (lignes >= 0 && lignes <largeur && colonnes >= 0 && colonnes < longueur && Cellules[lignes][colonnes].mine == false) {
        int mineAutour = analyseMineAutour(lignes, colonnes);
        
    }
    
    
    
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

