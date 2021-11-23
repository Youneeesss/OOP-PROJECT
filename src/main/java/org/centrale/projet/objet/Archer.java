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
public class Archer extends Personnage implements Combattant{
    
    private int nbFleches;

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
     * @param nbFleches : le nombre des flèches
     */
    public Archer(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos, String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptPar, int nbFleches) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos, nom, ptMana, pourcentageMag, pourcentageResistMag, degMag, distAttMax, ptPar);
        this.nbFleches = nbFleches;
    }

    /**
     *
     * @param archer
     */
    public Archer(Archer archer) {
        super(archer);
        this.nbFleches = archer.nbFleches;
    }

    /**
     *
     */
    public Archer() {
        super();
        this.nbFleches = 0;
    }

    /**
     *
     * @param s la chaine de caractères dont on va extraire les caractéristique d' Archer
     */
    public Archer(String s){
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
     *
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     *
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Combattre un créature
     * @param c
     */
    public void combattre(Creature c){
        // Combat au corps à corps
        if((this.getPos()).distance(c.getPos())==1){
            System.out.println("C'est un combat corps à corps");
            Random nb1 = new Random();
            int Rand_attaquante = nb1.nextInt(100);
            System.out.println("Numero Random "+Rand_attaquante);
            
            if(Rand_attaquante<=this.getPourcentageAtt()){
                System.out.println("Attaque réussie");
                System.out.println("Nombre de flèches initial "+this.getNbFleches());
                this.setNbFleches(this.getNbFleches()-1);
                System.out.println("Nombre de flèches final "+this.getNbFleches());
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
        
        //Combat à distance
        else if((this.getPos()).distance(c.getPos())>1 && (this.getPos()).distance(c.getPos())<this.getDistAttMax()){   
            System.out.println("C'est un combat à distance");
            Random nb1 = new Random(); 
            int Rand_attaquante = nb1.nextInt(100);
            System.out.println("Numero Random "+Rand_attaquante);
            
            if(Rand_attaquante>this.getPourcentageAtt()){
                System.out.println("Attaque ratée");
            }
            
            if (Rand_attaquante<=this.getPourcentageAtt()){
                System.out.println("Attaque réussie");
                System.out.println("Points de vie initiaux de la cible: "+c.getPtVie());
                c.setPtVie(c.getPtVie()-this.getDegAtt());
                System.out.println("Points de vie finaux de la cible: "+c.getPtVie());
            }
        }
        
        //Combat magique
        else if((this.getPos()).distance(c.getPos())>this.getDistAttMax()){   
            System.out.println("C'est un combat magique");
            Random nb1 = new Random(100);
            int Rand_attaquante = nb1.nextInt(100);
            System.out.println("Numero Random "+Rand_attaquante);
            
            if(Rand_attaquante>this.getPourcentageAtt()){
                System.out.println("Attaque ratée");
            }
            
            if (Rand_attaquante<=this.getPourcentageAtt()){
                System.out.println("Attaque réussie");
                System.out.println("Points de vie initiaux : "+c.getPtVie());
                c.setPtVie(c.getPtVie()-this.getDegMag());
                System.out.println("Points de vie finaux : "+c.getPtVie());
            }
        }
        else
        {
            System.out.println("Combat non faisable");
        }
    }
    
    /**
     * Affichage des attributs de l'Archer
     */
    public void affiche(){
        System.out.println("Creature type Archer");
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
        System.out.println("Il a: "+this.nbFleches+ " nbFleches");
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