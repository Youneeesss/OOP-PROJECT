package org.centrale.projet.objet;

import java.util.StringTokenizer;

/**
 *
 * @author youne
 */
public class Lapin extends Monstre{

    /**
     *
     * @param ptVie :  le nombre de point de vie
     * @param pourcentageAtt : le pourcentage d'attaque
     * @param pourcentagePar : le pourcentage pou parier
     * @param degAtt : le degré d'attaque
     * @param pos : la position de personnage
     * @param ptPar : les points parier
     */
    public Lapin (int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos, int ptPar){
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos, ptPar);
    }

    /**
     *
     * @param lapin
     */
    public Lapin(Lapin lapin){
        super(lapin);
    }

    /**
     *
     */
    public Lapin(){
        super();
    }

    /**
     *
     * @param s la chaine de caractères dont on va extraire les caractéristique de Lapin
     */
    public Lapin(String s){
        StringTokenizer elt = new StringTokenizer(s, " ,;:");
        elt.nextToken();
        this.setPtVie(Integer.parseInt(elt.nextToken()));
        this.setPourcentageAtt(Integer.parseInt(elt.nextToken()));
        this.setPourcentagePar(Integer.parseInt(elt.nextToken()));
        this.setDegAtt(Integer.parseInt(elt.nextToken()));
        this.setPtPar(Integer.parseInt(elt.nextToken()));
        Point2D p = new Point2D(Integer.parseInt(elt.nextToken()),Integer.parseInt(elt.nextToken()));
        this.setPos(p);
    }
   
    /**
     * Affichage des attributs de Lapin
     */
    public void affiche(){
        System.out.println("Creature type Lapin");
        System.out.println("Il a: "+this.getPtVie()+" PtVie");
        System.out.println("Il a: "+this.getPourcentageAtt()+" PourcentageAtt");
        System.out.println("Il a: "+this.getPourcentagePar()+" PourcentagePar");
        System.out.println("Il a: "+this.getDegAtt()+" DegAtt");
        this.getPos().affiche();
        System.out.println("-------------------------------------------------");
    }

    /**
     * Deplacement de lapin vers une position donnée
     * @param pos
     */
    public void deplacer(Point2D pos){
        this.getPos().setX(pos.getX());
        this.getPos().setY(pos.getY());
    }
}
