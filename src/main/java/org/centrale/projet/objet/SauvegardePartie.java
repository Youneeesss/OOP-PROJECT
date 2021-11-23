/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.centrale.projet.objet.Creature;
import org.centrale.projet.objet.Mana;
import org.centrale.projet.objet.Monstre;
import org.centrale.projet.objet.NuageToxique;
import org.centrale.projet.objet.Objet;
import org.centrale.projet.objet.Personnage;
import org.centrale.projet.objet.Soin;

/**
 *
 * @author youne
 */
public class SauvegardePartie {
    private String nomFile;
    private BufferedWriter content;

    /**
     *
     */
    public SauvegardePartie() {
    }
    
    /**
     *
     * @param nomFile
     */
    public SauvegardePartie(String nomFile) {
        this.nomFile = nomFile;
    }

    /**
     * On sauvegarde un partie de jeu dans un fichier de type texte.
     * @param w
     * @throws IOException
     */
    public void sauvegarderPartie(World w) throws IOException{
        Scanner sc = new Scanner(System.in);
        // on donne le choix à l'utilisateur de sauvegarder ou non la partie
        System.out.println("Voulez vous sauvegarder la partie : yes or no");
        String reponse = sc.next();
        if("yes".equals(reponse)){
            // on donne le choix à l'utilisateur de donner le nom de fichier de sauvegarde.
            System.out.println("Voulez vous donner le nom de fichier? oui ou non");
            String reponse1 = sc.next();
            if("oui".equals(reponse1)){
                System.out.println("Entrer le nom de fichier");
                this.nomFile = sc.next();
            }
            else{
                this.nomFile = "sauvegardeAuto";
            }
            // appel à la méthode changenomFile() pour définir un nom unique à notre fichier.
            this.nomFile = this.changenomFile(this.nomFile);
            this.content = new BufferedWriter(new FileWriter(this.nomFile + ".txt"));
            // Commencement de l'écriture dans notre fichier.
            // La hauteur et la largeur
            content.write("Largeur " + w.dim);
            content.newLine();
            content.write("Hauteur " + w.dim);
            content.newLine();
            // L'écriture des caractéristiques des Creatures
            for(Creature c: w.MesCreatures){
                if(c instanceof Personnage ){
                    this.content.write(((Personnage)c).getTextSauvegarde());
                    this.content.newLine();        
                }
                if(c instanceof Monstre ){
                    this.content.write(((Monstre)c).getTextSauvegarde());
                    this.content.newLine();        
                }
            }
            // L'écriture des caractéristiques des Objets
            for(Objet o: w.MesObjets){
                if(o instanceof Mana ){
                    this.content.write(((Mana)o).getTextSauvegarde());
                    this.content.newLine();        
                }
                if(o instanceof Soin){
                    this.content.write(((Soin)o).getTextSauvegarde());
                    this.content.newLine();        
                }
                if(o instanceof NuageToxique ){
                    this.content.write(((NuageToxique)o).getTextSauvegarde());
                    this.content.newLine();        
                }
            }
            // L'écriture des caractéristiques de Joueur
            this.content.write(w.jo.getTextSauvegarde());
            System.out.println("partie sauvegardée dans :" + this.nomFile + ".txt");
            this.content.flush();
            this.content.close();
        }
        else{
            System.out.println("partie non sauvegardée.");
        }
    }

    /**
     * Création d'un mot unique pour le fichier de sauvegarde
     * @param nomFile : le nom de fichier à modifier s'il existe déjà
     * @return
     */
    public String changenomFile(String nomFile){
        File f = new File(nomFile +".txt");
        int i = 1;
        String newName=nomFile;
        while(f.exists()){
            newName = nomFile+i;
            f = new File(newName +".txt");
            i++;
        
        }
        nomFile = newName;
        return nomFile;        
    }
}
