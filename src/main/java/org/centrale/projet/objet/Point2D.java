package org.centrale.projet.objet;
import java.util.Arrays;

/**
 *
 * @author youne
 */
public class Point2D {
    private int x;
    private int y;

    /**
     *
     * @param x
     * @param y
     */
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     *
     * @param p
     */
    public Point2D(Point2D p){
        this.x=p.x;
        this.y=p.y;
    }
    
    /**
     *
     */
    public Point2D(){
        this.x=0;
        this.y=0;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    /**
     *
     * @param dx
     * @param dy
     */
    public void traslate(int dx, int dy){
        this.x=this.x+dx;
        this.y=this.y+dy;
    }
    
    /**
     *
     */
    public void affiche(){
        int v[] = new int[2];
        v[0] = this.x;
        v[1] = this.y;
        System.out.println(Arrays.toString(v));
    }
    
    /**
     *
     * @param pos_personnage
     * @return
     */
    public double distance(Point2D pos_personnage){
        double dx = pos_personnage.getX() - this.getX();
        double dy = pos_personnage.getY() - this.getY();
        double dist = Math.sqrt(dx*dx + dy*dy);
        return dist;
    }
}
