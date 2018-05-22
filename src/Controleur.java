import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Controleur implements Initializable {
	
	private Personnage link;
	
	@FXML
    private Pane affichage;

    @FXML
    private Pane terrain;

    @FXML
    private Pane objets;
	
	/*public void placerPerso() {
		link.placerPerso();
	}
	
	public void avancer() {
		link.avancer();
	}
	
	public void reculer() {
		link.reculer();
	}
	
	public void droite() {
		link.droite();
	}
	
	public void gauche() {
		link.gauche();
	}*/
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Map mapLogique = new Map("src/map.txt");
		mapLogique.initMapLogique();
		int[][] map = mapLogique.getMapLogique();
		
		Map map2ecouche = new Map("src/map2.txt");
		map2ecouche.initMapLogique();
		int[][] map2 = map2ecouche.getMapLogique();
		
		for ( int x = 0 ; x < map.length ; x++ ) {
			for ( int y = 0 ; y < map[x].length ; y ++) {
				if (map[x][y]==2){
				
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
		
		File image=new File("src/img/link.png");
		Image pers = new Image(image.toURI().toString(),32,32,false,false);
		ImageView viewperso = new ImageView();
		viewperso.setImage(pers);
		objets.getChildren().add(viewperso);
		link = new Link(50,50,map2);
		
		
		viewperso.translateXProperty().bind(link.getPosX());
		viewperso.translateYProperty().bind(link.getPosY());
		
	}
	
    public void deplacement(KeyEvent key) {
		KeyCode codeDeLaTouche = key.getCode();
        
		switch (codeDeLaTouche) 
        {
            case UP:
            	//System.out.println("vbahb");
            	link.monter();
                break;
            case LEFT:
                link.gauche();
                break;
            case RIGHT:
                link.droite();
                break;
            case DOWN:
                link.descendre();
                break;
            default:
            	break;
        }
		
    }
}
