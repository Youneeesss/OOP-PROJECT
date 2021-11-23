package org.centrale.projet.objet;

/**
 *
 * @author youne
 */
public abstract class Monstre extends Creature{
    private int ptPar;
    
    /**
     *
     * @param ptVie :  le nombre de point de vie
     * @param pourcentageAtt : le pourcentage d'attaque
     * @param pourcentagePar : le pourcentage pou parier
     * @param degAtt : le degré d'attaque
     * @param pos : la position de personnage
     * @param ptPar : les points parier
     */
    public Monstre(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos, int ptPar){
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos);
        this.ptPar=ptPar;
    }
    
    /**
     *
     * @param monstre
     */
    public Monstre(Monstre monstre){
        super(monstre);
        this.ptPar=monstre.ptPar;
    }
    
    /**
     *
     */
    public Monstre(){
        super();
        this.ptPar=0;
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
     * @return
     */
    public String getTextSauvegarde(){
        String result = this.getClass().getSimpleName() + ' ' + this.getPtVie() + ' '
                + this.getPourcentageAtt() + ' ' + this.getPourcentagePar() + ' '
                + this.getDegAtt() + ' ' + this.getPtPar() + ' '
                + this.getPos().getX() + ' ' + this.getPos().getY() + ' ';
        return result;       
    }
    
}
