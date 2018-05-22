import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.ImageView;


public class Personnage {

	private IntegerProperty posX,posY;
	private IntegerProperty posXMax,posYMax;
	private int pdv;
	private DetecteurCollision collision;
	private int[][] map;
	private Arme arme;
	
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
		this.collision=new DetecteurCollision(map,posX.get(),posY.get(),posXMax.get(),posYMax.get());
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
	
	public int getPDV() {
		return this.pdv;
	}
	
	public void setPDV(int pv) {
		this.pdv=pv;
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
	
	public void monter() {
		if(collision.testCollisionHaut()==false) {
			this.posY.set(posY.get()-2);
			setPosYMax(posYMax.get()-2);
			collision.setPosY(posY.get());
			collision.setPosYMax(posYMax.get());
		}
	}
	
	public void descendre() {
		if(collision.testCollisionBas()==false) {
			this.posY.set(posY.get()+2);
			this.posYMax.set(posYMax.get()+2);
			collision.setPosY(posY.get());
			collision.setPosYMax(posYMax.get());
		}
	}
	
	public void droite() {
		if(collision.testCollisionDroit()==false) {
			//System.out.println("droite");
			this.posX.set(posX.get()+2);
			this.posXMax.set(posXMax.get()+2);
			collision.setPosX(posX.get());
			collision.setPosXMax(posXMax.get());
		}
	}
	
	public void gauche() {
		if(collision.testCollisionGauche()==false) {
			//System.out.println("left");
			this.posX.set(posX.get()-2);
			this.posXMax.set(posXMax.get()-2);
			collision.setPosX(posX.get());
			collision.setPosXMax(posXMax.get());
		}
	}
	
	//methodes attaque
	public void recevoirDegats(int deg) {
		this.pdv-=deg;
	}
	
	public void infligerDegats( Personnage pers) {
		pers.recevoirDegats(this.arme.getDegats());
	}
}
