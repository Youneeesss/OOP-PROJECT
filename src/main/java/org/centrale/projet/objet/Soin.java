package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author youne
 */
public class Soin extends Potion{
    private int ptVie;
       
    /**
     *
     */
    public Soin(){
        this.ptVie = 0;
    }
    
    /**
     *
     * @param ptVie Les points de vie fournis par Soin
     */
    public Soin(int ptVie) {
        this.ptVie = ptVie;
    } 

    /**
     *
     * @return le nombre de points de vie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * On transforme les caractéristique de Soin en chaine de caractère pour qu'on puisse charger un partie après.
     * @return
     */
    public String getTextSauvegarde(){
        String result = this.getClass().getSimpleName() + ' ' + this.getPtVie() + ' '
                 + this.getPos().getX() + ' ' + this.getPos().getY() + ' ';
        return result;       
    }

    /**
     *
     * @param s la chaine de caractères dont on va extraire les caractéristique de Soin
     */
    public Soin(String s){
        StringTokenizer elt = new StringTokenizer(s, " ,;:");
        elt.nextToken();
        this.setPtVie(Integer.parseInt(elt.nextToken()));
        Point2D p = new Point2D(Integer.parseInt(elt.nextToken()),Integer.parseInt(elt.nextToken()));
        this.setPos(p);
    }

    /**
     * Affichage
     */
    public void affiche(){
        System.out.println("Potion avec "+ptVie+" points de vie");
        this.getPos().affiche();
    }
}
