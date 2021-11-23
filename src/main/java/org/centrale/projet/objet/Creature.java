package org.centrale.projet.objet;

/**
 *
 * @author youne
 */
public abstract class Creature extends ElementDeJeu implements Deplacable{
    private int ptVie;
    private int pourcentageAtt;
    private int pourcentagePar;
    private int degAtt;
    private Point2D pos;

    /**
     *
     * @param ptVie : le nombre de point de vie
     * @param pourcentageAtt : le pourcentage d'attaque
     * @param pourcentagePar : le pourcentage pour parier
     * @param degAtt : le degré d'attaque
     * @param pos : la position
     */
    
    public Creature(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.pos = new Point2D(pos);
    }
    
    /**
     *
     * @param creature
     */
    public Creature(Creature creature){
        this.ptVie = creature.ptVie;
        this.pourcentageAtt = creature.pourcentageAtt;
        this.pourcentagePar = creature.pourcentagePar;
        this.degAtt = creature.degAtt;
        this.pos = new Point2D(creature.pos);
    }
    
    /**
     *
     */
    public Creature(){
        this.ptVie = 0;
        this.pourcentageAtt = 0;
        this.pourcentagePar = 0;
        this.degAtt = 0;
        this.pos = null;
    }
    
    /**
     * Getter les points de vie de Creature
     * @return : pour avoir les points de vie de la Creature
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Getter le pourcentage d'attaque de Creature
     * @return : pour avoir le pourcentage d'attaque de la Creature
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     * Avoir le pourcentage pour parer une attaque
     * @return
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     * Avoir le degrée max d'attaque
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Changer les points de vie de Creature
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * Changer pourcentage d'attaque de Creature
     * @param pourcentageAtt
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     * Changer le pourcentage pour parer une attaque
     * @param pourcentagePar
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     * Changer la distance max d'attaque
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
}
