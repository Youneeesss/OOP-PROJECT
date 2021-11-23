package org.centrale.projet.objet;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author youne
 */
public class Loup extends Monstre implements Combattant{

    /**
     *
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param pos
     * @param ptPar
     */
    /**
     *
     * @param ptVie :  le nombre de point de vie
     * @param pourcentageAtt : le pourcentage d'attaque
     * @param pourcentagePar : le pourcentage pou parier
     * @param degAtt : le degré d'attaque
     * @param pos : la position de personnage
     * @param ptPar : les points parier
     */
    public Loup (int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos, int ptPar){
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos, ptPar);
    }

    /**
     *
     * @param loup
     */
    public Loup(Loup loup){
        super(loup);
    }

    /**
     *
     */
    public Loup(){
        super();
    }

    /**
     *
     * @param s la chaine de caractères dont on va extraire les caractéristique de Mana de Loup
     */
    public Loup(String s){
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
     * Combat avec une Creature c
     * @param c Creature
     */
    public void combattre(Creature c){
        // Combat au corps à corps
        if((this.getPos()).distance(c.getPos())==1){
            System.out.println("C'est un combat corps à corps");
            Random nb1 = new Random();
            int Rand_attaquante = nb1.nextInt(100);
            System.out.println("Numero Random"+Rand_attaquante);
            
            if(Rand_attaquante<=this.getPourcentageAtt()){
                System.out.println("Attaque réussie");
            }
            if(Rand_attaquante>this.getPourcentageAtt()){
                System.out.println("Attaque ratée");
            }
            
            if (Rand_attaquante<=this.getPourcentageAtt()){
                
                Random nb2 = new Random(); 
                int Rand_defenseur = nb2.nextInt(100);
                
                if(Rand_defenseur>this.getPourcentagePar()){
                    System.out.println("dégâts subis = degAtt");
                    System.out.println("Points de vie ititiaux : "+c.getPtVie());
                    c.setPtVie(c.getPtVie()-this.getDegAtt());
                    System.out.println("Points de vie finaux : "+c.getPtVie());
                }
                
                if(Rand_defenseur<=this.getPourcentagePar()){
                    System.out.println("dégâts subis = degAtt - ptPar");
                    System.out.println("Points de vie initiaux : "+c.getPtVie());
                    c.setPtVie(c.getPtVie()-(this.getDegAtt()-c.getPourcentagePar()));
                    System.out.println("Points de vie finaux : "+c.getPtVie());
                }
            }
        }
        else
        {
            System.out.println("Combat non faisable");
        }
    }
    
    /**
     *
     */
    public void affiche(){
        System.out.println("Creature type Loup");
        System.out.println("Il a: "+this.getPtVie()+" PtVie");
        System.out.println("Il a: "+this.getPourcentageAtt()+" PourcentageAtt");
        System.out.println("Il a: "+this.getPourcentagePar()+" PourcentagePar");
        System.out.println("Il a: "+this.getDegAtt()+" DegAtt");
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
