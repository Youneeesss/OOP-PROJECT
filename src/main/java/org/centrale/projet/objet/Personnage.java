package org.centrale.projet.objet;
import java.util.LinkedList;

/**
 *
 * @author youne
 */
public abstract class Personnage extends Creature{
    private String nom;
    private int ptMana;
    private int pourcentageMag;
    private int pourcentageResistMag;
    private int degMag;
    private int distAttMax;
    private int ptPar;
    private LinkedList<Nourriture> liste_nourriture = new LinkedList<>();

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
     * @param liste_nourriture : liste des nourritures de personnage
     */
    public Personnage(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos, String nom, int ptMana, int pourcentageMag, int pourcentageResistMag, int degMag, int distAttMax, int ptPar) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos);
        this.nom=nom;
        this.ptMana=ptMana;
        this.pourcentageMag=pourcentageMag;
        this.pourcentageResistMag=pourcentageResistMag;
        this.degMag=degMag;
        this.distAttMax=distAttMax;
        this.ptPar=ptPar;
    }

    /**
     *
     * @param perso
     */
    public Personnage(Personnage perso) {
        super(perso);
        this.nom = perso.nom;
        this.ptMana = perso.ptMana;
        this.pourcentageMag = perso.pourcentageMag;
        this.pourcentageResistMag = perso.pourcentageResistMag;
        this.degMag = perso.degMag;
        this.distAttMax = perso.distAttMax;
        this.ptPar=perso.ptPar;
    }
    
    /**
     *
     */
    public Personnage() {
        super();
        this.nom = null;
        this.ptMana = 0;
        this.pourcentageMag = 0;
        this.pourcentageResistMag = 0;
        this.degMag = 0;
        this.distAttMax = 0;
        this.ptPar=0;
    } 

    /**
     *On transforme les caractéristique de Personnage en chaine de caractère pour qu'on puisse charger un partie après.
     * @return
     */
    public String getTextSauvegarde(){
        String result = this.getClass().getSimpleName() + ' ' + this.getNom() + ' ' + this.getPtVie() + ' ' + this.getPtMana() + ' '
                + this.getPourcentageAtt() + ' ' + this.getPourcentagePar() + ' '
                + this.getPourcentageMag() + ' ' + this.getPourcentageResistMag() + ' '
                + this.getDegAtt() + ' ' + this.getDegMag() + ' ' + this.getDistAttMax()
                + ' ' + this.getPtPar() + ' ' + this.getPos().getX() + ' ' + this.getPos().getY() + ' ';
        return result;       
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
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
     * @return
     */
    public int getPourcentageMag() {
        return pourcentageMag;
    }

    /**
     *
     * @return
     */
    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    /**
     *
     * @return
     */
    public int getDegMag() {
        return degMag;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
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
     * @return
     */
    public LinkedList<Nourriture> getListe_nourriture() {
        return liste_nourriture;
    }
    
    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
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
     * @param pourcentageMag
     */
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    /**
     *
     * @param pourcentageResistMag
     */
    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    /**
     *
     * @param degMag
     */
    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
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
     * @param liste_nourriture
     */
    public void setListe_nourriture(LinkedList<Nourriture> liste_nourriture) {
        this.liste_nourriture = liste_nourriture;
    }

    /**
     *
     */
    public abstract void affiche();
   
}