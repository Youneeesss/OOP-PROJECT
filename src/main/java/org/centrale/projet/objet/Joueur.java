package org.centrale.projet.objet;

import java.util.StringTokenizer;
import org.centrale.projet.objet.Archer;
import org.centrale.projet.objet.Guerrier;
import org.centrale.projet.objet.Mage;
import org.centrale.projet.objet.Paysan;
import org.centrale.projet.objet.Personnage;
import org.centrale.projet.objet.Point2D;

/**
 *
 * @author youne
 */
public class Joueur {

    /**
     * le Personnage qui définit le Joueur
     */
    public Personnage perso;
    
    /**
     *
     */
    public Joueur() {
    }
    
    /**
     *
     * @return
     */
    public Personnage getPerso() {
        return perso;
    }

    /**
     *
     * @param perso
     */
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

    /**
     * Ce constructeur nous permet de construire un Joueur à partie d'une chaine de caractères qui contient ses attributs ( son type, ses caractéristiques...)
     * @param s
     */
    public Joueur(String s){
        StringTokenizer elt = new StringTokenizer(s, " ,;:");
                elt.nextToken();
                String mot = elt.nextToken(); 
                switch(mot){
                    case "Guerrier" -> {
                        this.perso = new Guerrier();
                    }
                    case "Paysan" -> {
                        this.perso = new Paysan();
                    }
                    case "Mage" -> {
                        this.perso = new Mage();
                    }
                    case "Archer" -> {
                        this.perso = new Archer();
                    }
                }
                this.perso.setNom(elt.nextToken());
                this.perso.setPtVie(Integer.parseInt(elt.nextToken()));
                this.perso.setPtMana(Integer.parseInt(elt.nextToken()));
                this.perso.setPourcentageAtt(Integer.parseInt(elt.nextToken()));
                this.perso.setPourcentagePar(Integer.parseInt(elt.nextToken()));
                this.perso.setPourcentageMag(Integer.parseInt(elt.nextToken()));
                this.perso.setPourcentageResistMag(Integer.parseInt(elt.nextToken()));
                this.perso.setDegAtt(Integer.parseInt(elt.nextToken()));
                this.perso.setDegMag(Integer.parseInt(elt.nextToken()));
                this.perso.setDistAttMax(Integer.parseInt(elt.nextToken()));
                this.perso.setPtPar(Integer.parseInt(elt.nextToken()));
                Point2D p = new Point2D(Integer.parseInt(elt.nextToken()),Integer.parseInt(elt.nextToken()));
                this.perso.setPos(p);
    }

    /**
     * On transforme les caractéristique de joueur en chaine de caractère pour qu'on puisse charger un partie après.
     * @return
     */
    public String getTextSauvegarde(){
        String res = "Joueur" + ' ' + this.perso.getTextSauvegarde();
        return res;
    }
}
