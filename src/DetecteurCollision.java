public class DetecteurCollision {

	private int[][] mapObjets;
	private int posX,posY,posXMax,posYMax;
	
	public DetecteurCollision(int[][] map,int x,int y,int xMax,int yMax) {
		this.mapObjets=map;
		this.posX=x;
		this.posY=y;
		this.posXMax=xMax;
		this.posYMax=yMax;
	}
	
	public void setPosX(int x) {
		this.posX=x;
	}
	
	public void setPosY(int y) {
		this.posY=y;
	}
	
	public void setPosXMax(int xMax) {
		this.posXMax=xMax;
	}
	
	public void setPosYMax(int yMax) {
		this.posYMax=yMax;
	}
	
	public boolean testCollisionHaut() {
		if((mapObjets[(posY/32)][(posX/32)]!=0) || mapObjets[(posY/32)][(posXMax/32)]!=0) {
			return true;
		}
		return false;
	}
	
	public boolean testCollisionBas() {
		if((mapObjets[(posYMax/32)][(posX/32)]!=0) || mapObjets[(posYMax/32)][(posXMax/32)]!=0) {
			return true;
		}
		return false;
	}
	
	public boolean testCollisionDroit() {
		if((mapObjets[(posY/32)][(posXMax/32)]!=0) || mapObjets[(posYMax/32)][(posXMax/32)]!=0) {
			return true;
		}
		return false;
	}
	
	public boolean testCollisionGauche() {
		if((mapObjets[(posY/32)][(posX/32)]!=0) || mapObjets[(posYMax/32)][(posX/32)]!=0) {
			return true;
		}
		return false;
	}
}
