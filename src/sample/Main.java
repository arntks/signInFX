package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import klasser.Skilt;
import klasser.Splitt;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Main extends Application {
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList<Label> speedLabels = new ArrayList<Label>();
	private	Stage primaryStage = new Stage();
	
	ImageView imgView1 = new ImageView();
	ImageView imgView2 = new ImageView();
	ImageView imgView3 = new ImageView();
	ImageView imgView4 = new ImageView();
	ImageView imgView5 = new ImageView();
	ImageView imgView6 = new ImageView();
	
	Label tekstLabel1 = new Label();
	Label tekstLabel2 = new Label();
	Label tekstLabel3 = new Label();
	Label tekstLabel4 = new Label();
	
	Label speedLabel = new Label();

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		AnchorPane root = FXMLLoader.load(getClass().getResource("/sample/bilder.fxml"));
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		pictures.addAll(Arrays.asList(imgView1, imgView2, imgView3, imgView4, imgView5, imgView6));
		labels.addAll(Arrays.asList(tekstLabel1, tekstLabel2, tekstLabel3, tekstLabel4));
		
		UpdateSpeed us = new UpdateSpeed();
		speedLabels = us.makeLabel();
		speedLabel = speedLabels.get(0);

		/*TopLine topLine = new TopLine();
		Label topLabel = topLine.makeTopLabel();
		root.getChildren().add(topLabel);*/
		
			
		Thread scannerReadThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (scanner.hasNextLine()) {
                	String kortNr = scanner.next();
                	
                    Platform.runLater(new Runnable() {
        	            public void run() {
        	            	String nokkel = kortNr + ".txt";
        	        		Splitt splitt = new Splitt(nokkel);
        	        		File fil = splitt.getFile();
        	        		splitt.dele(fil);
        	        		
        	        		ArrayList<Skilt> skiltGruppe = splitt.getSkiltGruppe();
        	        		
        	        		//Oppdatering av farge på hastigheten sammenlignet med hvilken sone man er i.
        	        		Skilt fartskilt = skiltGruppe.get(0);
        	        		int speedLimit = fartskilt.getSkiltnr();
        	        		
        	        		Timer timer = new java.util.Timer();
        	        		timer.schedule(new TimerTask() {
        	        		    public void run() {
        	        		         Platform.runLater(new Runnable() {
        	        		            public void run() {
        	        		                String speed = us.retSpeed();
											if (speed != null){
												
												if(Integer.parseInt(speed) <= speedLimit)speedLabel.setTextFill(Color.web("#F8F8F8"));
												else if(Integer.parseInt(speed)<= speedLimit+5) speedLabel.setTextFill(Color.web("FF6600"));
												else speedLabel.setTextFill(Color.web("#CC0000"));
											}
        	        		            }
        	        		        });
        	        		    }
        	        		}, 1000, 10);
        	        		
        	        		
        	        		//Oppdaterer hvilken skiltsone man er i.
        	        		if (skiltGruppe.size() == 2) {
        						TwoImage mp = new TwoImage(skiltGruppe, pictures, labels);
        						mp.makeP();
        						pictures = mp.getPictures();
        						addImage(2,pictures);
        						addText(2,labels);
        					} else if (skiltGruppe.size() == 3) {
        						ThreeImage mp = new ThreeImage(skiltGruppe, pictures, labels);
        						mp.makeP();
        						mp.makeT();
        						pictures = mp.getPictures();
        						labels = mp.getLabels();
        						addImage(3,pictures);
        					} else if (skiltGruppe.size() == 4) {
        						FourImage mp = new FourImage(skiltGruppe,pictures, labels);
        						mp.makeP();
        						mp.makeT();
        						pictures = mp.getPictures();
        						labels = mp.getLabels();
        						addImage(4,pictures);
        					} else if (skiltGruppe.size() == 5) {
        						FiveImage mp = new FiveImage(skiltGruppe, pictures, labels);
        						mp.makeP();
        						mp.makeT();
        						pictures = mp.getPictures();
        						labels = mp.getLabels();
        						addImage(5,pictures);
        						
        					} else if (skiltGruppe.size() == 6) {
        						SixImage mp = new SixImage(skiltGruppe, pictures, labels);
        						mp.makeP();
        						mp.makeT();
        						pictures = mp.getPictures();
        						labels = mp.getLabels();
        						addImage(6,pictures);
        					} else {
        						throw new IllegalArgumentException();
        					}
        					
        					
        					

        	            }
        	        });
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
		scannerReadThread.setDaemon(true);
        scannerReadThread.start();
      
		
		root.getChildren().addAll(imgView1, imgView2, imgView3, imgView4, imgView5, imgView6);
		root.getChildren().addAll(tekstLabel1, tekstLabel2, tekstLabel3, tekstLabel4);
		root.getChildren().addAll(speedLabel, speedLabels.get(1));
		
		this.primaryStage.setScene(scene);
		this.primaryStage.show();

	}
	
	@SuppressWarnings("resource")
	private static String lesKort() {
		Scanner scanner = new Scanner(System.in);
		String kortnr = scanner.next();
		return kortnr;
	}
	
	//Sørger for at teksten blir satt riktig, og dersom man oppdaterer blir tidligere tekster fjernet.
	public void addText(int i, ArrayList <Label> labels){
		if(i==2){
			tekstLabel1.setText(null);
			tekstLabel2.setText(null);
			tekstLabel3.setText(null);
			tekstLabel4.setText(null);
		}else if(i==3){
			tekstLabel1 = labels.get(0);
			tekstLabel2.setText(null);
			tekstLabel3.setText(null);
			tekstLabel4.setText(null);
			
		}else if (i==4){
			tekstLabel1 = labels.get(0);
			tekstLabel2 = labels.get(1);
			tekstLabel3.setText(null);
			tekstLabel4.setText(null);
			
		}else if (i==5){
			tekstLabel1 = labels.get(0);
			tekstLabel2 = labels.get(1);
			tekstLabel3 = labels.get(2);
			tekstLabel4.setText(null);
			
		}else if (i==6){
			tekstLabel1 = labels.get(0);
			tekstLabel2 = labels.get(1);
			tekstLabel3 = labels.get(2);
			tekstLabel4 = labels.get(3);
			
		}
	}
	
	//Sørger for at bildet blir satt riktig, og dersom man oppdaterer blir tidligere bilder fjernet.
	public void addImage(int i, ArrayList<ImageView> pictures ){
		if(i==2){
			imgView1 = pictures.get(0);
			imgView2 = pictures.get(1);
			imgView3.setImage(null);
			imgView4.setImage(null);
			imgView5.setImage(null);
			imgView6.setImage(null);
		}else if(i==3){
			imgView1 = pictures.get(0);
			imgView2 = pictures.get(1);
			imgView3 = pictures.get(2);
			imgView4.setImage(null);
			imgView5.setImage(null);
			imgView6.setImage(null);
			
		}else if(i==4){
			imgView1 = pictures.get(0);
			imgView2 = pictures.get(1);
			imgView3 = pictures.get(2);
			imgView4 = pictures.get(3);
			imgView5.setImage(null);
			imgView6.setImage(null);
			
		}else if(i==5){
			imgView1 = pictures.get(0);
			imgView2 = pictures.get(1);
			imgView3 = pictures.get(2);
			imgView4 = pictures.get(3);
			imgView5 = pictures.get(4);
			imgView6.setImage(null);
			
		}else if(i==6){
			imgView1 = pictures.get(0);
			imgView2 = pictures.get(1);
			imgView3 = pictures.get(2);
			imgView4 = pictures.get(3);
			imgView5 = pictures.get(4);
			imgView6 = pictures.get(5);
		}else{
			throw new IllegalArgumentException();
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
