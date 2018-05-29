package modele;

import java.util.ArrayList;
import modele.Case;

public class Monstre extends Personnage{
		
	
	public Monstre(int abs, int ord, int pv, int[][] m) {
		super(abs, ord, pv, m, null);
		
	}

	

	public void deplacerSqlt() {
		int choix=(int) (Math.random()*5);
	
		switch (choix) 
        {
            case 1:
            	this.monter();
                break;
            case 2:
                this.gauche();
                break;
            case 3:
                this.droite();
                break;
            case 4:
                this.descendre();
                break;
            default: System.out.println("sur place");
            
            	break;
        }
	}
	
	
	public void deplacerGobelinBFS(){
		ArrayList<Case> voisinListe = new ArrayList<>();
		
		
		Case caseCible = new Case(Link.getPosX().get()/32, Personnage.getPosY().get()/32);
		
		Case caseDepart = new Case(Gobelins.getPosX().get()/32, Gobelins.getPosY().get()/32);
		
		Case caseVoisin = new Case(caseDepart.getX()+1, caseDepart.getY());
		
		
		do{
			
		if ( caseVoisin.equals(caseCible)){
			System.out.println("Case final trouvé");
			// ligne pour deplacer gobelins vers Link
			this.droite();
			
		}else if(caseVoisin != caseCible){
			// Stocker case suivante et changer case suiv avec une nouvelle case suiv
			System.out.println(caseCible);
			
			voisinListe.add(caseVoisin);
			caseVoisin.setX(caseVoisin.getX()+1);
		}
			
		
			
		
		}while(caseVoisin != caseCible);	
		
	}
	
	
	
	
	
	
}









