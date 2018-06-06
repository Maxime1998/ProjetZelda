package controleur;

import java.util.ArrayList;

import modele.Personnage;

public class DetecteurCollisionPersonnage {

	private boolean collision;
	private ArrayList<Personnage> listePos;
	
	public DetecteurCollisionPersonnage(ArrayList<Personnage> liste){
		this.collision=false;
		this.listePos=liste;
	}
	
	public void setListe(ArrayList<Personnage> c) {
		this.listePos=c;
	}
	
	public boolean testCollisionBas(int posY, int posX) {
		int i=0;
		collision=false;
		while(i<listePos.size() && collision==false){
			if((posX>=listePos.get(i).getDeplacement().getPosx() && posX<=listePos.get(i).getDeplacement().getPosx()+32) || (posX+32>=listePos.get(i).getDeplacement().getPosx() && posX+32<=listePos.get(i).getDeplacement().getPosx()+32)) {
				if(posY+32>=listePos.get(i).getDeplacement().getPosy() && posY+32<=listePos.get(i).getDeplacement().getPosy()+32) {
					collision=true;
				}
			}
			i++;
			
		}
		return collision;
	}
	
	public boolean testCollisionHaut(int posY, int posX) {
		int i=0;
		collision=false;
		while(i<listePos.size() && collision==false){
			if((posX>=listePos.get(i).getDeplacement().getPosx() && posX<=listePos.get(i).getDeplacement().getPosx()+32) || (posX+32>=listePos.get(i).getDeplacement().getPosx() && posX+32<=listePos.get(i).getDeplacement().getPosx()+32)) {
				if(posY<=listePos.get(i).getDeplacement().getPosy()+32 && posY>=listePos.get(i).getDeplacement().getPosy()) {
					collision=true;
				}
			}
			i++;
		}
		return collision;
	}
	
	public boolean testCollisionDroit(int posY, int posX) {
		int i=0;
		collision=false;
		while(i<listePos.size() && collision==false){
			if((posY+32>=listePos.get(i).getDeplacement().getPosy() && posY<=listePos.get(i).getDeplacement().getPosy()) || (posY<=listePos.get(i).getDeplacement().getPosy()+32 && posY+32>=listePos.get(i).getDeplacement().getPosy()+32)) {
				if(posX+32>=listePos.get(i).getDeplacement().getPosx() && posX<=listePos.get(i).getDeplacement().getPosx()) {
					collision=true;
				}
			}
			i++;
		}
		return collision;
	}
	
	public boolean testCollisionGauche(int posY, int posX) {
		int i=0;
		collision=false;
		while(i<listePos.size() && collision==false){
			if((posY+32>=listePos.get(i).getDeplacement().getPosy() && posY<=listePos.get(i).getDeplacement().getPosy()) || (posY<=listePos.get(i).getDeplacement().getPosy()+32 && posY+32>=listePos.get(i).getDeplacement().getPosy()+32)) {
				if(posX<=listePos.get(i).getDeplacement().getPosx()+32 && posX+32>=listePos.get(i).getDeplacement().getPosx()+32) {
					collision=true;
				}
			}
			i++;
		}
		return collision;
	}
}
