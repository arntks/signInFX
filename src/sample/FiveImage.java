package sample;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class FiveImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <String> textList = new ArrayList <String>();
	
	public FiveImage(String bilde1, String bilde2, String bilde3, String bilde4, String bilde5){
		numList.addAll(Arrays.asList(0,150,310,400,490));
		textList.addAll(Arrays.asList(bilde1,bilde2,bilde3,bilde4,bilde5));
	}
	
	public void makeP(){
		int h;
		int b;
		int y=10;
		
		for(int i=0; i<5; i++){
			Image img = new Image("img/"+textList.get(i)+".png");
			ImageView imgView = new ImageView(img);
			imgView.setImage(img);
			if(i<= 1){
				h=150;
				b=150;
			}else{
				h=90;
				b=90;
			}
			imgView.setFitHeight(h);
			imgView.setFitWidth(b);
			imgView.setX(numList.get(i));
			imgView.setY(y);
			
			pictures.add(imgView);
		}
	}
	
	public void makeT(){
		int y;
		
		for(int i=0; i<5; i++){
			Label label = new Label();
			label.setText("Tekst");
			label.setFont(new Font("Arial",20));
			
			if(i<=1) y=170;
			else y=110;
			
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
