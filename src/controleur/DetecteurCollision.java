package controleur;
public class DetecteurCollision {

	private int[][] mapObjets;
	
	public DetecteurCollision(int[][] map) {
		this.mapObjets=map;
	}

	public boolean testCollisionHaut(int posY, int posX, int posXMax) {
		if((mapObjets[(posY/32)][(posX/32)]!=0) || mapObjets[(posY/32)][(posXMax/32)]!=0) {
			return true;
		}
		return false;
	}
	
	public boolean testCollisionBas(int posYMax, int posX, int posXMax) {
		if((mapObjets[(posYMax/32)][(posX/32)]!=0) || mapObjets[(posYMax/32)][(posXMax/32)]!=0) {
			return true;
		}
		return false;
	}
	
	public boolean testCollisionDroit(int posY, int posXMax, int posYMax) {
		if((mapObjets[(posY/32)][(posXMax/32)]!=0) || mapObjets[(posYMax/32)][(posXMax/32)]!=0) {
			return true;
		}
		return false;
	}
	
	public boolean testCollisionGauche(int posY, int posX, int posYMax) {
		if((mapObjets[(posY/32)][(posX/32)]!=0) || mapObjets[(posYMax/32)][(posX/32)]!=0) {
			return true;
		}
		return false;
	}
}
