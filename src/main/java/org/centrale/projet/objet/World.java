package org.centrale.projet.objet;
import java.io.IOException;
import static java.lang.Character.toLowerCase;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author youne
 */
public class World {

    /**
     * liste des creatures
     */
    public ArrayList<Creature> MesCreatures;

    /**
     * liste des objets
     */
    public ArrayList<Objet> MesObjets;

    /**
     * notre joeur créé par l'utilisateur
     */
    public Joueur jo;

    /**
     * nombre de créatures
     */
    public int nombre_creatures= 15;

    /**
     * nombre des objets dans le monde
     */
    public int nombre_objets = 10;

    /**
     * la dimension du monde
     */
    public int dim;
    
    /**
     *
     */
    public World() {
        this.MesCreatures = new ArrayList<>();
        this.MesObjets = new ArrayList<>();
        this.dim=20;
        this.jo = new Joueur();
    }

    /**
     *
     * @param MesCreatures : liste des creature
     * @param MesObjets : liste des objets
     * @param nombre_creatures : nombre de creatures
     * @param nombre_potions : nombre de potions
     * @param dim :  la dimension du monde
     * @param jo : le joueur
     */
    public World(ArrayList<Creature> MesCreatures, ArrayList<Objet> MesObjets, int nombre_creatures, int nombre_potions, int dim, Joueur jo) {
        this.MesCreatures = MesCreatures;
        this.MesObjets = MesObjets;
        this.nombre_creatures = nombre_creatures;
        this.nombre_objets=nombre_potions;
        this.dim=dim;
        this.jo = jo;
    }

    /**
     * Getter de MesCreatures
     * @return
     */
    public ArrayList<Creature> getMesCreatures() {
        return MesCreatures;
    }

    /**
     * Getter de MesObjets
     * @return
     */
    public ArrayList<Objet> getMesObjets() {
        return MesObjets;
    }

    /**
     * Getter de nombre de creature
     * @return
     */
    public int getNombre_creatures() {
        return nombre_creatures;
    }

    /**
     * Getter de dimension
     * @return
     */
    public int getDim() {
        return dim;
    }

    /**
     * Getter de joueur
     * @return
     */
    public Joueur getJo() {
        return jo;
    }

    /**
     * Setter de Joueur
     * @param jo
     */
    public void setJo(Joueur jo) {
        this.jo = jo;
    }
    
    /**
     * Setter de Mes Creatures
     * @param MesCreatures
     */
    public void setMesCreatures(ArrayList<Creature> MesCreatures) {
        this.MesCreatures = MesCreatures;
    }

    /**
     * Setter de MesObjets
     * @param MesObjets
     */
    public void setMesObjets(ArrayList<Objet> MesObjets) {
        this.MesObjets = MesObjets;
    }

    /**
     *
     * @param nombre_creatures
     */
    public void setNombre_creatures(int nombre_creatures) {
        this.nombre_creatures = nombre_creatures;
    }

    /**
     *
     * @param dim
     */
    public void setDim(int dim) {
        this.dim = dim;
    }

    /**
     * Création d'une position aléatoire
     * @return
     */
    public Point2D posAlea(){
        Random nb1 = new Random();
        int xc1 = nb1.nextInt(this.dim+1);
        Random nb2 = new Random(); 
        int xc2 = nb2.nextInt(this.dim+1);
        Point2D pt = new Point2D(xc1,xc2);
        
        for(int i=0;i<this.MesCreatures.size();i++){
            while(pt.distance(this.MesCreatures.get(i).getPos()) == 0 || pt.distance(this.MesCreatures.get(i).getPos()) <= 3){
                xc1 = nb1.nextInt(this.dim+1);
                xc2 = nb2.nextInt(this.dim+1);
                pt = new Point2D(xc1,xc2);
                i=0;
                //con que no se cumpla una condición entonces hay que volver a empezar a comprobar desde el principio
            }
        }
        return pt;
    }
    
    /**
     * Creation d'un monde aléatoire
     */
    public void creeMonAlea(){
        //generer un nombre aléatoire de Creatures
        
        int archers=0;
        int paysans=0;
        int lapins=0;
        int guerriers=0;
        int loups=0;
        int mages=0;

//Boucle pour définir le type de creature aléatoirement.
        for (int i=0; i<nombre_creatures; i++){
            Random nb2 = new Random();
            int type_creature = nb2.nextInt(6);//intervalle [0, N[
            
            //definir aleatoirement la position de chaque crature.
            Point2D pt = this.posAlea();
            
            if(type_creature == 0){
                Creature c = new Archer();
                c.setPos(pt);
                this.MesCreatures.add(c);
                archers++;
            }
            if(type_creature == 1){
                Creature c = new Paysan();
                c.setPos(pt);
                this.MesCreatures.add(c);
                paysans++;
            }
            if(type_creature == 2){
                Creature c = new Lapin();
                c.setPos(pt);
                this.MesCreatures.add(c);
                lapins++;
            }
            if(type_creature == 3){
                Creature c = new Guerrier();
                c.setPos(pt);
                this.MesCreatures.add(c);
                guerriers++;
            }
            if(type_creature == 4){
                Creature c = new Loup();
                c.setPos(pt);
                this.MesCreatures.add(c);
                loups++;
            }
            if(type_creature == 5){
                Creature c = new Mage();
                c.setPos(pt);
                this.MesCreatures.add(c);
                mages++;
            }
            
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Nombre creatures: "+nombre_creatures);
        System.out.println("Nombre d'archers: "+archers);
        System.out.println("Nombre paysans: "+paysans);
        System.out.println("Nombre mages: "+mages);
        System.out.println("Nombre lapins: "+lapins);
        System.out.println("Nombre guerriers: "+guerriers);
        System.out.println("Nombre loups: "+loups);
        System.out.println("-------------------------------------------------");
        
        //Création de quelques potions
        
        for(int j=0; j<this.nombre_objets; j++){
            Point2D pt = this.posAlea();
            Random nb3 = new Random();
            int type_potion = nb3.nextInt(4);//intervalle [0, N[
            if(type_potion==0){
                Objet p = new Soin(nb3.nextInt(100));
                p.setPos(pt);
                this.MesObjets.add(p);
            }
            else if((type_potion==1)){
                Objet p = new Mana(nb3.nextInt(100));
                p.setPos(pt);
                this.MesObjets.add(p);
            }
            else if((type_potion==2)){
                Objet p = new Nourriture();
                p.setPos(pt);
                this.MesObjets.add(p);
            }
            else if((type_potion==3)){
                Objet p = new NuageToxique(); // par défaut crée une nuage toxique avec 10 pts de dégâts
                p.setPos(pt);
                this.MesObjets.add(p);
            }
            else{
                System.out.println("Aucun objet a été identifié suite au tire au tirage au sort");
            }
        }
        System.out.println("-------------------------------------------------");
    }
    
    /**
     * Affichage de World 
     */
    public void afficheWorld(){
        System.out.println("la dimension de notre monde est :"+ this.getDim());
        System.out.println("Affichage de MesCreatures[]\n");
        for(int i=0; i<this.MesCreatures.size(); i++){
            if(MesCreatures.get(i) instanceof Archer archer){
                System.out.println("index: "+i);
                archer.affiche();
            }
            if(MesCreatures.get(i) instanceof Guerrier guerrier){
                System.out.println("index: "+i);
                guerrier.affiche();
            }
            if(MesCreatures.get(i) instanceof Paysan paysan){
                System.out.println("index: "+i);
                paysan.affiche();
            }
            if(MesCreatures.get(i) instanceof Mage mage){
                System.out.println("index: "+i);
                mage.affiche();
            }
            if(MesCreatures.get(i) instanceof Loup loup){
                System.out.println("index: "+i);
                loup.affiche();
            }
            if(MesCreatures.get(i) instanceof Lapin lapin){
                System.out.println("index: "+i);
                lapin.affiche();
            }
        }
        System.out.println("Affichage de MesObjets[]\n");
        for(int j=0; j<this.MesObjets.size(); j++){
            if(MesObjets.get(j) instanceof Soin){
                Soin soin = (Soin) MesObjets.get(j);
                System.out.println("index: "+j);
                soin.affiche();
            }
            if(MesObjets.get(j) instanceof Mana){
                Mana mana = (Mana) MesObjets.get(j);
                System.out.println("index: "+j);
                mana.affiche();
            }
            if(MesObjets.get(j) instanceof NuageToxique){
                NuageToxique nuage_toxique = (NuageToxique) MesObjets.get(j);
                System.out.println("index: "+j);
                nuage_toxique.affiche();
            }
            if(MesObjets.get(j) instanceof Nourriture){
                Nourriture nourriture = (Nourriture) MesObjets.get(j);
                System.out.println("index: "+j);
                nourriture.affiche();
            }
        }
    }

    /**
     * Deplacement vers une position donnée en vérifiant si elle est vide ou pas.
     * @param k indice de creature qu'on veut déplacer
     * @param pos_prev position où on veut déplacer la Creature
     */
    public void deplace_avec_contraintes(int k, Point2D pos_prev){
        boolean occupee = false;
        for(int i=0; i<this.MesCreatures.size();i++){
            if(pos_prev.getX()==this.MesCreatures.get(i).getPos().getX()&&pos_prev.getY()==this.MesCreatures.get(i).getPos().getY()){
            System.out.println("Caisse déjà occupée !");
            occupee = true;
            }
        }
        if(occupee == false){
            this.MesCreatures.get(k).deplacer(pos_prev);
        }
    }
    
    /**
     * Creation de Joueur
     * @return
     */
    public Joueur creationJoueur(){
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom de votre joueur :");
        String nom = sc.nextLine();
        Random rd_type_personnage = new Random();
        int type_personnage=rd_type_personnage.nextInt(4);
        
        Random rd = new Random();
        switch (type_personnage){
            case 0 -> {
                this.jo.perso = new Guerrier();
                this.jo.getPerso().setNom(nom);
                this.jo.getPerso().setDegMag(rd.nextInt(80));
                this.jo.getPerso().setDegAtt(rd.nextInt(80));
                this.jo.getPerso().setDegMag(rd.nextInt(80));
                this.jo.getPerso().setDistAttMax(rd.nextInt(20));
                this.jo.getPerso().setPourcentageAtt(rd.nextInt(40));
                this.jo.getPerso().setPourcentageMag(rd.nextInt(30));
                this.jo.getPerso().setPourcentagePar(rd.nextInt(40));
                this.jo.getPerso().setPourcentageResistMag(rd.nextInt(40));
                this.jo.getPerso().setPtMana(rd.nextInt(30));
                this.jo.getPerso().setPtPar(rd.nextInt(50));
                this.jo.getPerso().setPtVie(rd.nextInt(200));
            }
            case 1 -> {
                this.jo.perso = new Archer();
                this.jo.getPerso().setNom(nom);
                ((Archer)this.jo.getPerso()).setNbFleches(20);
                this.jo.getPerso().setDegAtt(rd.nextInt(20));
                this.jo.getPerso().setDegMag(rd.nextInt(150));
                this.jo.getPerso().setDistAttMax(10);
                this.jo.getPerso().setPourcentageAtt(rd.nextInt(200));
                this.jo.getPerso().setPourcentageMag(rd.nextInt(40));
                this.jo.getPerso().setPourcentagePar(rd.nextInt(30));
                this.jo.getPerso().setPourcentageResistMag(rd.nextInt(30));
                this.jo.getPerso().setPtMana(rd.nextInt(10));
                this.jo.getPerso().setPtPar(rd.nextInt(40));
                this.jo.getPerso().setPtVie(rd.nextInt(100));
            }
            case 2 -> {
                this.jo.perso = new Paysan();
                this.jo.getPerso().setNom(nom);
                this.jo.getPerso().setDegAtt(rd.nextInt(30));
                this.jo.getPerso().setDegMag(rd.nextInt(30));
                this.jo.getPerso().setDistAttMax(rd.nextInt(30));
                this.jo.getPerso().setPourcentageAtt(rd.nextInt(30));
                this.jo.getPerso().setPourcentageMag(rd.nextInt(30));
                this.jo.getPerso().setPourcentagePar(rd.nextInt(30));
                this.jo.getPerso().setPourcentageResistMag(rd.nextInt(30));
                this.jo.getPerso().setPtMana(rd.nextInt(30));
                this.jo.getPerso().setPtPar(rd.nextInt(30));
                this.jo.getPerso().setPtVie(rd.nextInt(100));
            }
            case 3 -> {
                this.jo.perso = new Mage();
                this.jo.getPerso().setNom(nom);
                this.jo.getPerso().setDegAtt(rd.nextInt(80));
                this.jo.getPerso().setDegMag(rd.nextInt(120));
                this.jo.getPerso().setDistAttMax(rd.nextInt(20));
                this.jo.getPerso().setPourcentageAtt(rd.nextInt(50));
                this.jo.getPerso().setPourcentageMag(rd.nextInt(50));
                this.jo.getPerso().setPourcentagePar(rd.nextInt(50));
                this.jo.getPerso().setPourcentageResistMag(rd.nextInt(80));
                this.jo.getPerso().setPtMana(rd.nextInt(80));
                this.jo.getPerso().setPtPar(rd.nextInt(40));
                this.jo.getPerso().setPtVie(rd.nextInt(100));
            }
            default -> System.out.println("Erreur choix type de Personnage");
        }
        //Définition de la position initiale aléatoire sur une caise non occupée
        Random rd2 = new Random();
        Point2D pos_prev = new Point2D(rd2.nextInt(this.getDim()), rd2.nextInt(this.getDim()));
        for(int i=0; i<this.nombre_creatures;i++){
            if(pos_prev.getX()==this.getMesCreatures().get(i).getPos().getX()&&pos_prev.getY()==this.getMesCreatures().get(i).getPos().getY()){
                pos_prev = new Point2D(rd2.nextInt(this.getDim()), rd2.nextInt(this.getDim()));
                i=0;
            }
        }
        this.jo.getPerso().setPos(pos_prev);
        return this.jo;
    }

    /**
     * Génération d'une tour de jeu
     * @throws IOException
     */
    public void tourDeJeu() throws IOException{
        Scanner sc2 = new Scanner(System.in);
        System.out.println("choisir 'combattre' ou 'deplacer' ou 'sauvegarder':");
        String res = sc2.nextLine();
        switch(res){
            case "deplacer" ->{
                this.deplacer_avec_contraintes();
            }
            case "combattre"->{
                this.combattre_une_creature_de_w();
            }
            case "sauvegarder" ->{
                SauvegardePartie save = new SauvegardePartie();
                save.sauvegarderPartie(this);
            }
            default -> System.out.println("Choix non valid");
        }
    }
    
    /**
     * Deplacement vers une case voisine
     */
    public void deplacer_avec_contraintes(){
        System.out.print("Tapez 1 pour placer votre Personnage à droite: \n");
        System.out.print("Tapez 2 pour placer votre Personnage à en haut à droite: \n");
        System.out.print("Tapez 3 pour placer votre Personnage en haut : \n");
        System.out.print("Tapez 4 pour placer votre Personnage en haut à gauche : \n");
        System.out.print("Tapez 5 pour placer votre Personnage à gauche : \n");
        System.out.print("Tapez 6 pour placer votre Personnage en bas à gauche : \n");
        System.out.print("Tapez 7 pour placer votre Personnage en bas : \n");
        System.out.print("Tapez 8 pour placer votre Personnage en bas à droite : \n");
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        Point2D pos_prev = new Point2D(this.jo.getPerso().getPos().getX(),this.jo.getPerso().getPos().getY());
        
        switch(i){
            case 1 ->{
                pos_prev.setX(pos_prev.getX()+1);
            }
            case 2 ->{
                pos_prev.setX(pos_prev.getX()+1);
                pos_prev.setY(pos_prev.getY()+1);
            }
            case 3 ->{
                pos_prev.setY(pos_prev.getY()+1);
            }
            case 4 ->{
                pos_prev.setX(pos_prev.getX()-1);
                pos_prev.setY(pos_prev.getY()+1);
            }
            case 5 ->{
                pos_prev.setY(pos_prev.getY()-1);
            }
            case 6 ->{
                pos_prev.setX(pos_prev.getX()-1);
                pos_prev.setY(pos_prev.getY()-1);
                
            }
            case 7 ->{
                pos_prev.setY(pos_prev.getY()-1);
                
            }
            case 8 ->{
                pos_prev.setX(pos_prev.getX()+1);
                pos_prev.setY(pos_prev.getY()-1);
            }
        }
        
        boolean occupee = false;
        for(int j=0; j<this.MesCreatures.size();j++){
            if(pos_prev.getX()==this.getMesCreatures().get(j).getPos().getX() && pos_prev.getY() == this.getMesCreatures().get(j).getPos().getY()){
            System.out.println("Caisse déjà occupée !");
            System.out.println("Position finale de votre personnage: ");
            this.jo.getPerso().getPos().affiche();
            occupee = true;
            }
        }
        if(occupee == false){
            System.out.println("Position initiale de votre personnage: ");
            this.jo.getPerso().getPos().affiche();
            this.jo.getPerso().getPos().setPosition(pos_prev.getX(), pos_prev.getY());
            System.out.println("Position finale de votre personnage: ");
            this.jo.getPerso().getPos().affiche();
        }
    }
    
    /**
     * Combat de joueur avec une créature d'indice donnée par l'utilisateur
     */
    public void combattre_une_creature_de_w(){
        if(this.jo.getPerso() instanceof Archer || this.jo.getPerso() instanceof Guerrier || this.jo.getPerso() instanceof Mage){
            Scanner sc = new Scanner(System.in);
            System.out.println("sélectionnez l'indice de la Creature que vous souhaitez confronter :");
            int res = sc.nextInt();
            while(res > this.MesCreatures.size()){
                System.out.println("choisir un indice inférieur à " +this.MesCreatures.size());
                res = sc.nextInt();
            }
            ((Combattant)(this.jo).getPerso()).combattre(this.MesCreatures.get(res));
            
            
        }
        else{
            System.out.println("Votre personnage ne peut pas combattre...");
        }
    }
    
    /**
     *
     * @param perso 
     * @param item
     */
    public void ramasser(Personnage perso, Objet item){
        if(item instanceof Nourriture){
            perso.getListe_nourriture().add((Nourriture)item);
            System.out.println("Nourriture ajoutée");
        }
    }

    /**
     *
     * @param perso
     * @param i
     */
    public void utiliser_item(Personnage perso, int i){
        if(perso.getListe_nourriture().get(i) instanceof Nourriture){
            if("bonus".equals(((Nourriture)perso.getListe_nourriture().get(i)).getType_bonus_malus())){
                perso.setDegMag(perso.getDegMag()+((Nourriture)perso.getListe_nourriture().get(i)).getValeur_applicable());
                perso.getListe_nourriture().remove(i);
            }
            else if("malus".equals(((Nourriture)perso.getListe_nourriture().get(i)).getType_bonus_malus())){
                perso.setDegMag(perso.getDegMag()-((Nourriture)perso.getListe_nourriture().get(i)).getValeur_applicable());
                perso.getListe_nourriture().remove(i);
            }
            else{
                System.out.println("Nourriture non utilisée");
            }
        }
    }

    /**
     * Affichage graphique simple de World
     */
    public void afficheMinimaliste() {
        char[][] matrixW = new char[this.dim][this.dim];

        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                matrixW[i][j] = '0';
            }
        }

        for (int i = 0; i < this.dim; i++) {
            for (int j = 0; j < this.dim; j++) {
                for (Creature c : this.MesCreatures) {
                    if (c.getPos().getX() == i && c.getPos().getY() == j) {
                        matrixW[this.dim-j-1][i] = c.getClass().getSimpleName().charAt(0);
                    }
                }
                for (Objet o : this.MesObjets) {
                    if (o.getPos().getX() == i && o.getPos().getY() == j) {
                        matrixW[this.dim-j-1][i] = toLowerCase(o.getClass().getSimpleName().charAt(0));
                    }
                }
                if (this.jo.getPerso().getPos().getX() == i && this.jo.getPerso().getPos().getY() == j) {
                    matrixW[this.dim-j-1][i] = this.jo.getPerso().getClass().getSimpleName().charAt(0);
                }  
            }
        }
        System.out.println("Légende : \n ");
        System.out.println("(G)uerrier \n ");
        System.out.println("(M)age : \n ");
        System.out.println("(A)rcher : \n ");
        System.out.println("(P)aysan: \n ");
        System.out.println("(s)oin : \n ");
        System.out.println("(m)ana : \n ");
        System.out.println("(n)uage Toxique : \n ");
        for (int i = 0; i < this.dim; i++) {
            System.out.println(" ");
            for (int j = 0; j < this.dim; j++) {
                if(matrixW[i][j] !=0)
                System.out.print(matrixW[i][j]+"  ");  
            }
        System.out.println(" \n ");    
        }

    }
}
