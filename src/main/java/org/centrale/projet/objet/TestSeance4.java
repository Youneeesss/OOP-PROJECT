package org.centrale.projet.objet;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author youne
 */
public class TestSeance4 {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Clique 1 pour jouer une partie existante ou cliquez sur 2 pour créer une partie aléatoire.");
        int res = sc.nextInt();
        World monde = new World();
        switch(res){
            case 1 :
                Scanner sca = new Scanner(System.in);
                System.out.println("Donnez le nom de la partie");
                String destination = sca.nextLine();
                ChargementPartie sp = new ChargementPartie(destination);
                monde = sp.chargerPartie();
                System.out.println("Si vous voulez jouer un tour de jeu, cliquez sur 1 sinon 0");
                res = sc.nextInt();
                while(res == 1){
                    monde.tourDeJeu();
                    monde.afficheMinimaliste();
                    System.out.println("Si vous voulez jouer un autre tour de jeu, cliquez sur 1 et si vous voulez quitter le jeu cliquez sur 0");
                    res = sc.nextInt();
               }
                System.out.println("\n");
                System.out.println("Vous avez quitter le jeu, Voulez vous sauvegarder la partie, cliquez sur 1 si oui 0 sinon");
                if(sc.nextInt() == 1){
                    SauvegardePartie save = new SauvegardePartie();
                    save.sauvegarderPartie(monde);
                }

            case 2 :
                monde.creeMonAlea();
                monde.creationJoueur();
                System.out.println("Votre Joueur est dans la position :");
                monde.jo.getPerso().getPos().affiche();
                System.out.println("Si vous voulez jouer un tour de jeu, cliquez sur 1 sinon 0");
                res = sc.nextInt();
                while(res == 1){
                    monde.tourDeJeu();
                    monde.afficheMinimaliste();
                    System.out.println("Si vous voulez jouer un autre tour de jeu, cliquez sur 1 et si vous voulez quitter le jeu cliquez sur 0");
                    res = sc.nextInt();
                }
                System.out.println("\n");
                System.out.println("Vous avez quitter le jeu, Voulez vous sauvegarder la partie, cliquez sur 1 si oui 0 sinon");
                if(sc.nextInt() == 1){
                    SauvegardePartie save = new SauvegardePartie();
                    save.sauvegarderPartie(monde);
                }
                
                
        }
        
    }
        
}

