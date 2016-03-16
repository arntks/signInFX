package sample;

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

public class UpdateSpeed {
	int sec =0;
	
	private ArrayList<Label> labels = new ArrayList<Label>();
	
	
	public ArrayList<Label> makeLabel(){
		
		DropShadow skygge = new DropShadow();
		skygge.setColor(Color.web("#000000"));
		skygge.setRadius(20);
		
		Label fartLabel = new Label();
		fartLabel.setText("76");
		fartLabel.setFont(new Font("Arial",120));
		fartLabel.setLayoutX(310);
		fartLabel.setLayoutY(37);
		fartLabel.setTextFill(Color.web("#D80000"));
		fartLabel.setEffect(skygge);
		
		Label kmLabel = new Label();
		kmLabel.setText("km/h");
		kmLabel.setFont(new Font("Arial",50));
		kmLabel.setLayoutX(450);
		kmLabel.setLayoutY(102);
		kmLabel.setTextFill(Color.web("#F8F8F8"));
		
		labels.addAll(Arrays.asList(fartLabel, kmLabel));
		
		return labels;
	}

	Timer timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			sec++;
			System.out.println("tid: " + sec);
		}
	};
	
	
	public void start(){
		timer.scheduleAtFixedRate(task,1000,1000);
	}
	
	public static void main(String[] args) {
		UpdateSpeed u = new UpdateSpeed();
		u.start();
	}
	
}
