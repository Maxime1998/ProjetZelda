package modele;
import controleur.DetecteurCollision;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Personnage {

	private IntegerProperty posX,posY;
	private IntegerProperty posXMax,posYMax;
	private int pdv;
	private DetecteurCollision collision;
	private int[][] map;
	private Arme arme;
	private int compteurpas;
	private IntegerProperty orientation;//1==Haut; 0==Bas, 2==Droite; 3==Gauche
	//va etre observe 
	//listener sur orienattion 

	public Personnage(int abs, int ord,int pv,int[][] m, Arme arme) {
		this.arme= arme;
		this.posX= new SimpleIntegerProperty();
		this.posX.set(abs);
		this.posY= new SimpleIntegerProperty();
		this.posY.set(ord);
		this.pdv=pv;
		this.posXMax= new SimpleIntegerProperty();
		this.posXMax.set(abs+30);
		this.posYMax= new SimpleIntegerProperty();
		this.posYMax.set(ord+32);
		this.map=m;
		this.compteurpas=0;
		this.collision=new DetecteurCollision(map);
		this.orientation=new SimpleIntegerProperty();
		this.orientation.set(0);
	}
	
	public IntegerProperty getOrientation() {
		return orientation;
	}
	
	
	public IntegerProperty getPosX() {
		return posX;
	}
	
	public IntegerProperty getPosY() {
		return posY;
	}
	
	public IntegerProperty getPosXMax() {
		return posXMax;
	}
	
	public IntegerProperty getPosYMax() {
		return posYMax;
	}
	
	public int getPosx() {
		return this.posX.get();
	}
	
	public int getPosy() {
		return this.posY.get();
	}
	
	
	public int getPDV() {
		return this.pdv;
	}
	
	public void setPDV(int pv) {
		this.pdv=pv;
	}
	
	public void perdrePV() {
		this.pdv--;
	}
	
	public void gagnerPV() {
		this.pdv++;
	}
	
	public void setPosX(int x) {
		this.posX.set(x);
	}
	
	public void setPosY(int y) {
		this.posY.set(y);
	}
	
	public void setPosXMax(int xMax) {
		this.posXMax.set(xMax);
	}
	
	public void setPosYMax(int yMax) {
		this.posYMax.set(yMax);
	}
	
	public boolean monter() {
		this.orientation.set(1);
		if(collision.testCollisionHaut(posY.get(),posX.get(),posXMax.get())==false) {
			if(this.posY.get()>0) {
				this.posY.set(posY.get()-1);
				setPosYMax(posYMax.get()-1);
				return true;
			}
		}
		return false;
	}
	
	public boolean descendre() {
		this.orientation.set(0);
		if(collision.testCollisionBas(posYMax.get(),posX.get(),posXMax.get())==false) {
			if(this.posYMax.get()<640) {
				this.posY.set(posY.get()+1);
				this.posYMax.set(posYMax.get()+1);
				return true;
			}	
		}
		return false;
	}
	
	public boolean droite() {
		this.orientation.set(2);
		if(collision.testCollisionDroit(posY.get(),posXMax.get(),posYMax.get())==false) {
			if(this.posXMax.get()<640) {
				this.posX.set(posX.get()+1);
				this.posXMax.set(posXMax.get()+1);
				return true;
			}
		}
		return false;
	}
	
	public boolean gauche() {
		this.orientation.set(3);
		if(collision.testCollisionGauche(posY.get(),posX.get(),posYMax.get())==false) {
			if(this.posX.get()>0) {
				this.posX.set(posX.get()-1);
				this.posXMax.set(posXMax.get()-1);
				return true;
			}
		}
		return false;
	}
	
	public int getCompteurPas(){
		return this.compteurpas;
	}
	public void incrementerCompteurPas(){
		this.compteurpas++;
	}
}
