package sample;
	
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import klasser.Skilt;
import klasser.SkiltFart;
import klasser.Skilt_uten_tekst;
import klasser.Splitt;
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
			
			/*String nokkel = lesKort() + ".txt";
	        Splitt splitt = new Splitt(nokkel);
	        File fil = splitt.getFile();
	        splitt.dele(fil);
	        ArrayList<Skilt> skiltGruppe = splitt.getSkiltGruppe();
			*/
			ArrayList<Skilt> skiltGruppe = new ArrayList<Skilt>();
			skiltGruppe.add(new SkiltFart(80));
			skiltGruppe.add(new Skilt_uten_tekst(6));
			skiltGruppe.add(new Skilt_uten_tekst(1));
			skiltGruppe.add(new Skilt_uten_tekst(4));
			skiltGruppe.add(new Skilt_uten_tekst(11));
			
			AnchorPane root = FXMLLoader.load(getClass().getResource("/sample/bilder.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
	
			//For fire skilt:
			
			/*FourImage mp = new FourImage("bilde1","bilde2","bilde3","bilde4");
			mp.makeP(); 	
			mp.makeT();
			pictures = mp.getPictures();
			labels = mp.getLabels();*/
				
			//For fem skilt:
			
			FiveImage mp = new FiveImage(skiltGruppe);
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
	/*
	private static String lesKort(){
        Scanner scanner = new Scanner(System.in);
        String kortnr = scanner.next();
        scanner.close();
        return kortnr;
    }
	*/
	
	public static void main(String[] args) {
		launch(args);
	}
}
