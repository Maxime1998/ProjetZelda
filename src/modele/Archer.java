package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Archer extends Personnage{

	//private int ptAttaque;
	//private int pv;
	
	
	public Archer(int abs, int ord,int[][] m) {
		
		super(abs,ord,50,m,new Arc(7));
	}
	

}