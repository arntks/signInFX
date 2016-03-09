package sample;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList <Label>();
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = FXMLLoader.load(getClass().getResource("/application/bilder.fxml"));
			Scene scene = new Scene(root,600,337.5);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
	
			//For fire skilt:
			
			/*FourImage mp = new FourImage("bilde1","bilde2","bilde3","bilde4");
			mp.makeP(); 	
			mp.makeT();
			pictures = mp.getPictures();
			labels = mp.getLabels();*/
				
			//For fem skilt:
			
			FiveImage mp = new FiveImage("bilde1","bilde2","bilde3","bilde4","bilde5");
			mp.makeP();
			mp.makeT();
			pictures = mp.getPictures();
			labels = mp.getLabels();
			
			for (int i=0; i<pictures.size(); i++){ 
				root.getChildren().add(pictures.get(i));
				root.getChildren().add(labels.get(i));
			}
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	public static void main(String[] args) {
		launch(args);
	}
}
