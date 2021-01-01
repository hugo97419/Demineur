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
int CaseDecouverte;
int proxiMine;

Grille() {
        for (int i=0; i<largeur; i++) {
            for (int j=0; j<longueur; j++) {
                Cellules[i][j] = new Cellule();
                
            }
        }
    }

void activer_mine(int column) { 
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
    
void decouvrirCellules(int lignes, int colonnes) {
    if (lignes >= 0 && lignes <largeur && colonnes >= 0 && colonnes < longueur && Cellules[lignes][colonnes].mine == false) {
        int mineAutour = analyseMineAutour(lignes, colonnes);
        CaseDecouverte ++;
    
     if (mineAutour == 0) {
         CaseDecouverte = proxiMine;
         decouvrirCellules(lignes, colonnes +1);
         decouvrirCellules(lignes+1, colonnes);
         decouvrirCellules(lignes+1, colonnes +1);
         decouvrirCellules(lignes-1, colonnes);
         decouvrirCellules(lignes, colonnes-1);
         decouvrirCellules(lignes-1, colonnes-1);
         decouvrirCellules(lignes+1, colonnes-1);
         decouvrirCellules(lignes-1, colonnes+1);
     }
    }
}

void ouvrirCellules(int ligne, int colonne) {
    while(ligne>=0 && ligne<largeur && colonne >=0 && colonne<longueur) {
        if (Cellules[ligne][colonne].mine == false) {
            
        }
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


void afficherGrillesurConsole(){
    for (int i = largeur-1; i >= 0; i--) {
            for (int j = 0; j < longueur; j++) {
                if(Cellules[i][j].mine){
                    System.out.print("\u001B[0m O ");
                }
                  else if (Cellules[i][j].drapeau) {
                    System.out.print("\u001B[0m D ");
                } else if (Cellules[i][j].proxiMine ==1) {
                    System.out.print("\u001B[0m N ");
                
                } else if (Cellules[i][j].kitDeDeminage) {
                    System.out.print("\u001B[0m K ");
                } 
            }
            System.out.println(" " + (i+1));
        }
        for(int i=0; i<longueur;i++){
            System.out.print(" " + (i+1) + " ");
        }
        System.out.println();
}

boolean placerKit(int ligne, int colonne) {
        if (!Cellules[ligne][colonne].kitDeDeminage) {
            Cellules[ligne][colonne].kitDeDeminage = true;
            return true;
        }
        return false;
    }


}