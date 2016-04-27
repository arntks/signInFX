package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.net.*;
import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import klasser.Skilt;
import klasser.SkiltFart;
import klasser.Splitt;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


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
	@FXML TextField input_text = new TextField();
	int speedLimit;
	ArrayList<Skilt> skiltGruppe;
	
	int correctSpeedLimit;

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		AnchorPane root = FXMLLoader.load(getClass().getResource("/sample/bilder.fxml"));
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		
		UpdateSpeed us = new UpdateSpeed();
		speedLabels = us.makeLabel();
		speedLabel = speedLabels.get(0);
		
		
		TopLine topLine = new TopLine();
		Label topLabel = topLine.makeTopLabel();
		
		makeThread(topLabel, us); // Lager thread slik at man oppdatere GUI-en kontinuerlig.
		
		root.getChildren().addAll(imgView1, imgView2, imgView3, imgView4, imgView5, imgView6);
		root.getChildren().addAll(topLabel,tekstLabel1, tekstLabel2, tekstLabel3, tekstLabel4);
		root.getChildren().addAll(speedLabel, speedLabels.get(1));
		
		this.primaryStage.setScene(scene);
		this.primaryStage.show();
		
		input_text.requestFocus();

	}
	
	@SuppressWarnings("resource")
	private static String lesKort() {
		Scanner scanner = new Scanner(System.in);
		String kortnr = scanner.next();
		return kortnr;
	}
	
	public void makeThread(Label topLabel, UpdateSpeed us){

		Thread scannerReadThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (scanner.hasNextLine()) {
                	String kortNr = scanner.next();
                	input_text.requestFocus();
                    Platform.runLater(new Runnable() {
        	            public void run() {
        	            	  	        		
        	        		//Oppdatering av farge på hastigheten sammenlignet med hvilken sone man er i.

        	        		updateColore(us);
        	        		updateZone();	
        					
        	            }
        	        });
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
		scannerReadThread.setDaemon(true);
        scannerReadThread.start();
	}
	
	public void updateZone(){
		//Oppdaterer hvilken skiltsone man er i.
		pictures.addAll(Arrays.asList(imgView1, imgView2, imgView3, imgView4, imgView5, imgView6));
		labels.addAll(Arrays.asList(tekstLabel1, tekstLabel2, tekstLabel3, tekstLabel4));
    	String kortNr2 = input_text.getText();
    	System.out.println(input_text.getText());
    	input_text.clear();
    	input_text.requestFocus();
    	String nokkel = "src/andre_ting/"+kortNr2+".txt";
		Splitt splitt = new Splitt(nokkel);
		File fil = splitt.getFile();
		splitt.dele(fil);
		this.skiltGruppe = splitt.getSkiltGruppe();
		if (skiltGruppe.size() == 2) {
			TwoImage mp = new TwoImage(this.skiltGruppe, this.pictures, this.labels);
			mp.makeP();
			pictures = mp.getPictures();
			addImage(2,pictures);
			addText(2,labels);
		} else if (skiltGruppe.size() == 3) {
			ThreeImage mp = new ThreeImage(this.skiltGruppe, this.pictures, this.labels);
			mp.makeP();
			mp.makeT();
			pictures = mp.getPictures();
			labels = mp.getLabels();
			addImage(3,pictures);
			addText(3,labels);
		} else if (skiltGruppe.size() == 4) {
			FourImage mp = new FourImage(this.skiltGruppe, this.pictures, this.labels);
			mp.makeP();
			mp.makeT();
			pictures = mp.getPictures();
			labels = mp.getLabels();
			addImage(4,pictures);
			addText(4,labels);
		} else if (skiltGruppe.size() == 5) {
			FiveImage mp = new FiveImage(this.skiltGruppe, this.pictures, this.labels);
			addImage(5,pictures);
			addText(5,labels);
			pictures = mp.getPictures();
			labels = mp.getLabels();
			mp.makeP();
			mp.makeT();
			
		} else if (skiltGruppe.size() == 6) {
			SixImage mp = new SixImage(this.skiltGruppe, this.pictures, this.labels);
			mp.makeP();
			mp.makeT();
			this.pictures = mp.getPictures();
			labels = mp.getLabels();
			addImage(6,this.pictures);
			addText(6,labels);
		} else {
			throw new IllegalArgumentException();
		}
		Skilt fartskilt = skiltGruppe.get(0);
		speedLimit = fartskilt.getSkiltnr();
		
	}
	
	public void updateColore(UpdateSpeed us){
		correctSpeedLimit = speedLimit;
		Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
		    public void run() {
		         Platform.runLater(new Runnable() {
		            public void run() {
		                String speed = us.retSpeed();
						if (speed != null){
							
							if(Integer.parseInt(speed) <= correctSpeedLimit){
								speedLabel.setTextFill(Color.web("#F8F8F8"));
								//mediaPlayer.stop();
							}
							else if(Integer.parseInt(speed)<= correctSpeedLimit*1.15){
								speedLabel.setTextFill(Color.web("FF6600"));
								//mediaPlayer.stop();
								
							}
							else {
								speedLabel.setTextFill(Color.web("#CC0000"));

								//mediaPlayer.play();
								
							}
						}
		            }
		        });
		    }
		}, 1000, 10);
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
