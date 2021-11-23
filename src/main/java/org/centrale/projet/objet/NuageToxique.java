package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * On transforme les caractéristique de NUage toxique en chaine de caractère pour qu'on puisse charger un partie après.
 * @author youne
 */
public class NuageToxique extends Objet implements Combattant, Deplacable{
    private int pourcentageAtt;
    private int pourcentagePar;
    private int degAtt;
    private int ptPar;

    /**
     *
     * @param pourcentageAtt : le pourcentage d'attaque
     * @param degAtt : le degré d'attaque
     * @param ptPar : les points parier
     */
    public NuageToxique(int pourcentageAtt, int degAtt, int ptPar) {
        this.pourcentageAtt = pourcentageAtt;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
    }

    /**
     *
     * @param s la chaine de caractères dont on va extraire les caractéristique de NuageToxique
     */
    public NuageToxique(String s){
        StringTokenizer elt = new StringTokenizer(s, " ,;:");
        elt.nextToken();
        this.setPourcentageAtt(Integer.parseInt(elt.nextToken()));
        this.setPourcentagePar(Integer.parseInt(elt.nextToken()));
        this.setDegAtt(Integer.parseInt(elt.nextToken()));
        this.setPtPar(Integer.parseInt(elt.nextToken()));
        Point2D p = new Point2D(Integer.parseInt(elt.nextToken()),Integer.parseInt(elt.nextToken()));
        this.setPos(p);
    }

    /**
     *
     */
    public NuageToxique() {
        this.degAtt = 0;
    }

    /**
     *On transforme les caractéristique de NuageToxique en chaine de caractère pour qu'on puisse charger un partie après.
     * @return
     */
    public String getTextSauvegarde(){
        String result = this.getClass().getSimpleName() + ' ' + this.getPourcentageAtt() + ' ' 
                + this.getPourcentagePar() + ' ' + this.getDegAtt() + ' '+ this.getPtPar() + ' '
                + this.getPos().getX() + ' ' + this.getPos().getY() + ' ' ;
        return result;       
    }

    /**
     *
     * @return
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     *
     * @param pourcentageAtt
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     *
     * @return
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     *
     * @param pourcentagePar
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @param p
     */
    public void deplacer(Point2D p){
        
    }
    
    /**
     *
     * @param c
     */
    public void combattre(Creature c){
        
    }

    /**
     *
     */
    public void affiche(){
        System.out.println("Nuage toxique avec "+degAtt+" points de degats");
    }
}
