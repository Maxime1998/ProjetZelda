

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Main extends Application{
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
		FXMLLoader loader = new FXMLLoader();
		URL url = new File("src/vueMap.fxml").toURI().toURL();
		loader.setLocation(url);
		System.out.println(loader.getLocation());
		
		Pane root = new Pane();
		root=loader.load();
		
		Controleur c = loader.getController();
		Scene scene = new Scene(root,160,320);
		scene.setOnKeyPressed(event ->{c.deplacement(event);});
		primaryStage.setScene(scene);
		primaryStage.show();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		
	

	}
	
	public static void main(String[] args) throws IOException {
		launch(args);
		
	}
}

