package org.centrale.projet.objet;

/**
 *
 * @author youne
 */
public class Nourriture extends Objet{
    private int duree;
    private int valeur_applicable;
    private String type_bonus_malus;
    private String caracteristique_modifiee;

    /**
     *
     */
    public Nourriture() {
        this.duree = 3;
        this.valeur_applicable=10;
        this.type_bonus_malus="bonus";
        //afin de pouvoir tester la diminution du damage effectué pour un combat magique
        this.caracteristique_modifiee="degMag"; 
    }

    /**
     *
     * @param duree
     * @param valeur_applicable
     * @param type_bonus_malus
     * @param caracteristique_modifiee
     */
    public Nourriture(int duree, int valeur_applicable, String type_bonus_malus, String caracteristique_modifiee) {
        this.duree = duree;
        this.valeur_applicable=valeur_applicable;
        this.type_bonus_malus=type_bonus_malus;
        this.caracteristique_modifiee=caracteristique_modifiee;
    }

    /**
     *
     * @return
     */
    public int getDuree() {
        return duree;
    }

    /**
     *
     * @return
     */
    public int getValeur_applicable() {
        return valeur_applicable;
    }

    /**
     *
     * @return
     */
    public String getType_bonus_malus() {
        return type_bonus_malus;
    }

    /**
     *
     * @return
     */
    public String getCaracteristique_modifiee() {
        return caracteristique_modifiee;
    }

    /**
     *
     * @param duree
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     *
     * @param valeur_applicable
     */
    public void setValeur_applicable(int valeur_applicable) {
        this.valeur_applicable = valeur_applicable;
    }

    /**
     *
     * @param type_bonus_malus
     */
    public void setType_bonus_malus(String type_bonus_malus) {
        this.type_bonus_malus = type_bonus_malus;
    }

    /**
     *
     * @param caracteristique_modifiee
     */
    public void setCaracteristique_modifiee(String caracteristique_modifiee) {
        this.caracteristique_modifiee = caracteristique_modifiee;
    }

    /**
     *
     */
    public void affiche(){
        System.out.println("Nourriture type "+type_bonus_malus+ " avec "+valeur_applicable+" points");
    }
    
}
