package sample;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class FourImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <String> textList = new ArrayList <String> ();
	
	public FourImage(String bilde1, String bilde2, String bilde3, String bilde4){
		numList.addAll(Arrays.asList(0,150,300,450));
		textList.addAll(Arrays.asList(bilde1,bilde2,bilde3,bilde4));
	}
	
	public void makeP(){
		
		int h=150;
		int b=150;
		int x=100;
		int y=10;
		
		for(int i=0; i<4; i++){
			Image img = new Image("img/"+textList.get(i)+".png");
			ImageView imgView = new ImageView(img);
			imgView.setImage(img);
			imgView.setFitHeight(h);
			imgView.setFitWidth(b);
			imgView.setX(numList.get(i));
			imgView.setY(y);
			
			pictures.add(imgView);
		}
	}
	
	public void makeT(){
		int y =170;
		
		for(int i=0; i<4; i++){
			Label label = new Label();
			label.setText("Tekst");
			label.setFont(new Font("Arial",30));
			label.setLayoutX(numList.get(i));
			label.setLayoutY(y);
			
			labels.add(label);
		}	
	}
	
	public ArrayList getPictures(){
		return pictures;
	}
	
	public ArrayList getLabels(){
		return labels;
	}

}
