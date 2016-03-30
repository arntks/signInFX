package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import klasser.Skilt;
import klasser.SkiltFart;

public class UpdateSpeed {
	int sec =0;
	int i =22;
	int speedLimit;
	Skilt fartskilt;
	String speed;
	
	Timer timer = new java.util.Timer();
	private ArrayList<Label> labels = new ArrayList<Label>();
	
	
	public ArrayList<Label> makeLabel() throws FileNotFoundException{
		//Kjører tilfeldig fartsfil. Her må det legges til riktig fartsfil, og selvfølgelig formateres riktig.
		BufferedReader br = new BufferedReader(new FileReader(new File("fartsfil.txt")));
		DropShadow skygge = new DropShadow();
		skygge.setColor(Color.web("#000000"));
		skygge.setRadius(20);
		
		
		Label fartLabel = new Label();
		fartLabel.setFont(new Font("Arial",120));
		fartLabel.setLayoutX(310);
		fartLabel.setLayoutY(37);
		fartLabel.setEffect(skygge);
		fartLabel.setTextFill(Color.web("#F8F8F8"));
		
		Label kmLabel = new Label();
		kmLabel.setText("km/h");
		kmLabel.setFont(new Font("Arial",50));
		kmLabel.setLayoutX(450);
		kmLabel.setLayoutY(102);
		kmLabel.setTextFill(Color.web("#F8F8F8"));
		
		labels.addAll(Arrays.asList(fartLabel, kmLabel));
		
		
		timer.schedule(new TimerTask() {
		    public void run() {
		         Platform.runLater(new Runnable() {
		            public void run() {
		                try {
		                	speed = br.readLine();
		                	fartLabel.setText(speed);
						
		                } catch (IOException e) {
							e.printStackTrace();
						}
		            }
		        });
		    }
		}, 1000, 1000);
		
		return labels;
	}
	
	public String retSpeed(){
		return this.speed;
	}
	
	public static void main(String[] args) {
		
		Label label = new Label();
		
	}
	
}
