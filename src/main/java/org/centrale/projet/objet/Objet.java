package org.centrale.projet.objet;

/**
 *
 * @author youne
 */
public abstract class Objet extends ElementDeJeu{
    private Point2D pos;

    /**
     *
     */
    public Objet() {
        this.pos = null;
    }
    
    /**
     *
     * @param pos
     */
    public Objet(Point2D pos) {
        this.pos = pos;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
}
