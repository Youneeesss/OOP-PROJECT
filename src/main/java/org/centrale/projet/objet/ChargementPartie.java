/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import org.centrale.projet.objet.Archer;
import org.centrale.projet.objet.Guerrier;
import org.centrale.projet.objet.Lapin;
import org.centrale.projet.objet.Loup;
import org.centrale.projet.objet.Mage;
import org.centrale.projet.objet.Mana;
import org.centrale.projet.objet.NuageToxique;
import org.centrale.projet.objet.Paysan;
import org.centrale.projet.objet.Soin;

/**
 *
 * @author youne
 */
public class ChargementPartie {
    private String destination;
    private BufferedReader fich;

    /**
     *
     * @return
     */
    public BufferedReader getFich() {
        return fich;
    }

    /**
     *
     * @param fich
     */
    public void setFich(BufferedReader fich) {
        this.fich = fich;
    }

    /**
     * Constructeur par l'adresse de fichier
     * @param destination
     */
    public ChargementPartie(String destination) {
        this.destination = destination;
    }

    /**
     * Elle retourne un objet de type World
       contenant l'ensemble des éléments du jeu qui étaient sauvegardés dans le
       fichier texte
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public World chargerPartie() throws FileNotFoundException, IOException{
        String line;
        World w = new World();
        // On définit les délimiteurs
        String delimiters = " ,;:";
        this.fich = new BufferedReader(new FileReader(this.destination));
        // La lecture de chaque ligne dans le fichier destination
        line = this.fich.readLine();
        while(line != null){
            StringTokenizer elt = new StringTokenizer(line, delimiters);
                // Traitement mot par mot pour chaque ligne de fichier texte
                String mot = elt.nextToken();
                /*On sait que chaque ligne commence par la classe du Creature ou de l'objet ou du joueur.
                * Pour chaque début de ligne on fait un chargement au type correspondant à la ligne.
                */
                switch(mot){
                    case "Largeur" -> {
                        w.setDim(Integer.parseInt(elt.nextToken()));
                    }
                    case "Hauteur" -> {
                        w.setDim(Integer.parseInt(elt.nextToken()));
                    }
                    case "Guerrier" -> {
                        Guerrier g =  new Guerrier(line);
                        w.MesCreatures.add(g);
                    }
                    case "Archer" -> {
                        Archer g =  new Archer(line);
                        w.MesCreatures.add(g);
                    }
                    case "Paysan" -> {
                        Paysan g =  new Paysan(line);
                        w.MesCreatures.add(g);
                    }
                    case "Lapin" -> {
                        Lapin g =  new Lapin(line);
                        w.MesCreatures.add(g);
                    }
                    case "Loup" -> {
                        Loup g =  new Loup(line);
                        w.MesCreatures.add(g);
                    }
                    case "Voleur" -> {
                        Mage g =  new Mage(line);
                        w.MesCreatures.add(g);
                    }
                    case "Mage" -> {
                        Mage g =  new Mage(line);
                        w.MesCreatures.add(g);
                    }
                    case "NuageToxique" -> {
                        NuageToxique g =  new NuageToxique(line);
                        w.MesObjets.add(g);
                    }
                    case "Soin" -> {
                        Soin g =  new Soin(line);
                        w.MesObjets.add(g);
                    }
                    case "Mana" -> {
                        Mana g =  new Mana(line);
                        w.MesObjets.add(g);
                    }
                    case "Joueur" -> {
                        Joueur g = new Joueur(line);
                        w.setJo(g);
                    }
                    default -> {
                        System.out.println("stop");
                    }
                }
                line = this.fich.readLine();
        }    
        fich.close();
        return w;
        
    }
}

