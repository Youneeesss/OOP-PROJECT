package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author youne
 */
public class Paysan extends Personnage{

    /**
     *
     * @param nom : le nom de personnage
     * @param ptVie :  le nombre de point de vie
     * @param ptMana : le nombre des points Mana
     * @param pourcentageAtt : le pourcentage d'attaque
     * @param pourcentagePar : le pourcentage pou parier
     * @param pourcentageMag : le pourcentage de la magie
     * @param pourcentageResistMag : le pourcentage pour résister à une magie
     * @param degAtt : le degré d'attaque
     * @param degMag : le degré magique
     * @param distAttMax : la distance maximale pour attaquer
     * @param pos : la position de personnage
     * @param ptPar : les points parier
     */
    public Paysan(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos, String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptPar) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos, nom, ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, ptPar);
    }

    /**
     *
     * @param paysan
     */
    public Paysan(Paysan paysan) {
        super(paysan);
    }

    /**
     *
     */
    public Paysan() {
        super();
    }

    /**
     *
     * @param s la chaine de caractères dont on va extraire les caractéristique de Paysan
     */
    public Paysan(String s){
        StringTokenizer elt = new StringTokenizer(s, " ,;:");
                elt.nextToken();
                this.setNom(elt.nextToken());
                this.setPtVie(Integer.parseInt(elt.nextToken()));
                this.setPtMana(Integer.parseInt(elt.nextToken()));
                this.setPourcentageAtt(Integer.parseInt(elt.nextToken()));
                this.setPourcentagePar(Integer.parseInt(elt.nextToken()));
                this.setPourcentageMag(Integer.parseInt(elt.nextToken()));
                this.setPourcentageResistMag(Integer.parseInt(elt.nextToken()));
                this.setDegAtt(Integer.parseInt(elt.nextToken()));
                this.setDegMag(Integer.parseInt(elt.nextToken()));
                this.setDistAttMax(Integer.parseInt(elt.nextToken()));
                this.setPtPar(Integer.parseInt(elt.nextToken()));
                Point2D p = new Point2D(Integer.parseInt(elt.nextToken()),Integer.parseInt(elt.nextToken()));
                this.setPos(p);
    }

    /**
     * Affichage des attributs de Paysan
     */
    public void affiche(){
        System.out.println("Creature type Paysan");
        System.out.println("Nom: "+this.getNom());
        System.out.println("Il a: "+this.getPtVie()+" PtVie");
        System.out.println("Il a: "+this.getPtMana()+" PtMana");
        System.out.println("Il a: "+this.getPourcentageAtt()+" PourcentageAtt");
        System.out.println("Il a: "+this.getPourcentagePar()+" PourcentagePar");
        System.out.println("Il a: "+this.getPourcentageMag()+" PourcentageMag");
        System.out.println("Il a: "+this.getPourcentageResistMag()+" PourcentageResistMag");
        System.out.println("Il a: "+this.getDegAtt()+" DegAtt");
        System.out.println("Il a: "+this.getDegMag()+" DegMag");
        System.out.println("Il a: "+this.getDistAttMax()+" DistAttMax");
        this.getPos().affiche();
        System.out.println("-------------------------------------------------");
    }

    /**
     *
     * @param pos
     */
    public void deplacer(Point2D pos){
        this.getPos().setX(pos.getX());
        this.getPos().setY(pos.getY());
    }
}
