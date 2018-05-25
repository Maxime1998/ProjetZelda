package controleur;

import modele.Personnage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import modele.Link;
import modele.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Controleur implements Initializable {
	
	private Link link;
	
	private Scrolling sc;
	ImageView viewperso = new ImageView();
	
	//viue test
	ImageView viewtest = new ImageView();
	
	private IntegerProperty mvt=new SimpleIntegerProperty(0);
	
	//monte
	File image_link_dos=new File("src/link/link_dos.png");
	Image pers_dos= new Image(image_link_dos.toURI().toString(),32,32,false,false);
	File image_link_dos_marche1=new File("src/link/link_dos_marche1.png");
	Image pers_dos_marche1= new Image(image_link_dos_marche1.toURI().toString(),32,32,false,false);
	File image_link_dos_marche2=new File("src/link/link_dos_marche2.png");
	Image pers_dos_marche2= new Image(image_link_dos_marche2.toURI().toString(),32,32,false,false);
	
	//gauche
	File image_link_gauche=new File("src/link/link_profil_gauche.png");
	Image pers_gauche= new Image(image_link_gauche.toURI().toString(),32,32,false,false);
	File image_link_gauche_marche1=new File("src/link/link_profil_gauche_marche1.png");
	Image pers_gauche_marche1= new Image(image_link_gauche_marche1.toURI().toString(),32,32,false,false);
	File image_link_gauche_marche2=new File("src/link/link_profil_gauche_marche2.png");
	Image pers_gauche_marche2= new Image(image_link_gauche_marche2.toURI().toString(),32,32,false,false);
	//droite
	File image_link_droite=new File("src/link/link_profil_doite.png");
	Image pers_droite= new Image(image_link_droite.toURI().toString(),32,32,false,false);
	File image_link_droite_marche1=new File("src/link/link_profil_doite_marche1.png");
	Image pers_droite_marche1= new Image(image_link_droite_marche1.toURI().toString(),32,32,false,false);
	File image_link_droite_marche2=new File("src/link/link_profil_doite_marche2.png");
	Image pers_droite_marche2= new Image(image_link_droite_marche2.toURI().toString(),32,32,false,false);
	//descend
	File image_link_face=new File("src/link/link_face.png");
	Image pers_face = new Image(image_link_face.toURI().toString(),32,32,false,false);
	File image_link_face_marche1=new File("src/link/link_face_marche1.png");
	Image pers_face_marche1 = new Image(image_link_face_marche1.toURI().toString(),32,32,false,false);
	File image_link_face_marche2=new File("src/link/link_face_marche2.png");
	Image pers_face_marche2 = new Image(image_link_face_marche2.toURI().toString(),32,32,false,false);
	
	@FXML
    private Pane affichage;

    @FXML
    private Pane terrain;

    @FXML
    private Pane objets;
    
    @FXML
    private Pane menu;
    
    @FXML
    private Pane scrolling;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//creation premiere couche map
		Map mapLogique = new Map("src/modele/map.txt");
		mapLogique.initMapLogique();
		int[][] map = mapLogique.getMapLogique();
		
		//creation deuxieme couche map
		Map map2ecouche = new Map("src/modele/map2.txt");
		map2ecouche.initMapLogique();
		int[][] map2 = map2ecouche.getMapLogique();
		
		for ( int x = 0 ; x < map.length ; x++ ) {
			for ( int y = 0 ; y < map[x].length ; y ++) {
				if (map[x][y]==2){
					//stocker dans une map ? tableau avec indice en string 
					//methode speciale dans une classe ?
					File f=new File("src/img/herbe.png");
					Image herbe = new Image(f.toURI().toString(),32,32,false,false);
					ImageView viewHerbe = new ImageView();
					viewHerbe.setImage(herbe);
					terrain.getChildren().add(viewHerbe);
					viewHerbe.relocate(y*32, x*32);
					
				}
				else if(map[x][y]==3){
					File g=new File("src/img/chemin.png");
					Image chemin = new Image(g.toURI().toString(),32,32,false,false);
					ImageView viewchemin = new ImageView();
					viewchemin.setImage(chemin);
					terrain.getChildren().add(viewchemin);
					viewchemin.relocate(y*32, x*32);
				}
			}
		}
		for ( int x = 0 ; x < map2.length ; x++ ) {
			for ( int y = 0 ; y < map2[x].length ; y ++) {
				
				 if(map2[x][y]==1){
					File h=new File("src/img/hautes_herbes.png");
					Image hautes_herbes = new Image(h.toURI().toString(),32,32,false,false);
					ImageView viewhautes_herbes = new ImageView();
					viewhautes_herbes.setImage(hautes_herbes);
					objets.getChildren().add(viewhautes_herbes);
					viewhautes_herbes.relocate(y*32, x*32);
				 }
			}
		}
		
		
		link = new Link(50,50,map2);
		sc=new Scrolling(link);
		
		objets.getChildren().add(viewperso);
 		viewperso.translateXProperty().bind(link.getPosX());
		viewperso.translateYProperty().bind(link.getPosY());
		viewperso.setImage(pers_face);
		
		
		//test affichage menu
		viewtest.setImage(pers_dos);
		menu.getChildren().add(viewtest);
		
		

		
		mvt.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				
				switch(link.getOrientation().get()) {
					case 0:
						viewperso.setImage(pers_dos);
						link.incrementerCompteurPas();
						System.out.println(link.getCompteurPas());
						if(link.getCompteurPas()%6==0 || link.getCompteurPas()%6==1 || link.getCompteurPas()%6==2){
	                		viewperso.setImage(pers_face_marche1);
	                	}
	                	else{
	                		viewperso.setImage(pers_face_marche2);
	                	}
		
						
					break;
					case 1:
						viewperso.setImage(pers_face);
						link.incrementerCompteurPas();
						if(link.getCompteurPas()%6==0 || link.getCompteurPas()%6==1|| link.getCompteurPas()%6==2){
	                		viewperso.setImage(pers_dos_marche1);
	                	}
	                	else{
	                		viewperso.setImage(pers_dos_marche2);
	                	}
					break;
					case 2 :
						viewperso.setImage(pers_droite);
						link.incrementerCompteurPas();
	                     if(link.getCompteurPas()%6==0 || link.getCompteurPas()%6==1|| link.getCompteurPas()%6==2){
	                 		viewperso.setImage(pers_droite_marche1);
	                 	}
	                 	else{
	                 		viewperso.setImage(pers_droite_marche2);
	                 	}
	                  break;
					case 3:
						viewperso.setImage(pers_gauche);
						link.incrementerCompteurPas();
						if(link.getCompteurPas()%6==0 || link.getCompteurPas()%6==1 || link.getCompteurPas()%6==2){
		            		viewperso.setImage(pers_gauche_marche1);
		            	}
		            	else{
		            		viewperso.setImage(pers_gauche_marche2);
		            	}
	            
	                 break;
						
				}
			}
			
		}
				);
		//viewperso.translateXProperty().addListener();
		
	}
	
    public void deplacement(KeyEvent key) {
		KeyCode codeDeLaTouche = key.getCode();
		
		
		switch (codeDeLaTouche) 
        {
            case UP:
        		if(link.monter()==true) {
        			//partie deplacement fenetre
            		sc.setPosYFenetre();
            		scrolling.relocate(-sc.getPosXFenetre(), -sc.getPosYFenetre());
            		mvt.set(mvt.get()+1);
        		}
                break;
            case LEFT:
        		if(link.gauche()==true) {
            		sc.setPosXFenetre();
            		scrolling.relocate(-sc.getPosXFenetre(), -sc.getPosYFenetre());
            		mvt.set(mvt.get()+1); 
	               
        		}
                
                break;
            case RIGHT:
        		
        		
        		if(link.droite()==true) {
            		sc.setPosXFenetre();
            		scrolling.relocate(-sc.getPosXFenetre(), -sc.getPosYFenetre());
            		mvt.set(mvt.get()+1);
            	}
               
                break;
            case DOWN:
        		
        		
        		if(link.descendre()==true) {
            		sc.setPosYFenetre();
            		scrolling.relocate(-sc.getPosXFenetre(), -sc.getPosYFenetre());
            		mvt.set(mvt.get()+1);
        		}
                
                break;
            default:
            	break;
        }
		
    }
    //voir plus tard 
   /* public void arretdeplacement(KeyEvent key) {
    	
    }*/
}
