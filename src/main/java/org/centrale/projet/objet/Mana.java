package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author youne
 */
public class Mana extends Potion{
    private int ptMana;

    /**
     *
     */
    public Mana(){
        this.ptMana = 0;
    }
    
    /**
     *
     * @param ptMana
     */
    public Mana(int ptMana) {
        this.ptMana = ptMana;
    }

    /**
     *
     * @return
     */
    public int getPtMana() {
        return ptMana;
    }

    /**
     *
     * @param ptMana
     */
    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    /**
     *
     * @param s la chaine de caractères dont on va extraire les caractéristique de Mana
     */
    public Mana(String s){
        StringTokenizer elt = new StringTokenizer(s, " ,;:");
        elt.nextToken();
        this.setPtMana(Integer.parseInt(elt.nextToken()));
        Point2D p = new Point2D(Integer.parseInt(elt.nextToken()),Integer.parseInt(elt.nextToken()));
        this.setPos(p);
    }

    /**
     *On transforme les caractéristique de Mana en chaine de caractère pour qu'on puisse charger un partie après.
     * @return
     */
    public String getTextSauvegarde(){
        String result = this.getClass().getSimpleName() + ' ' + this.getPtMana() + ' '
                 + this.getPos().getX() + ' ' + this.getPos().getY() + ' ';
        return result;       
    }

    /**
     * Affichage des attributs de Mana
     */
    public void affiche(){
        System.out.println("Potion avec "+ptMana+" points de mana");
    }
    
}
