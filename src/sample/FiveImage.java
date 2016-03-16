package sample;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import klasser.Skilt;

public class FiveImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <Image> imgList = new ArrayList <Image>();
	private ArrayList <String> textList = new ArrayList <String>();
	
	public FiveImage(ArrayList<Skilt> skiltGruppe){
		numList.addAll(Arrays.asList(60,60,385,302,468));
		for(int i=0; i<5; i++){
			imgList.add(skiltGruppe.get(i).hentBilde());
			textList.add(skiltGruppe.get(i).hentTekst());
		}
		
		
	}
	
	public void makeP(){
		int h;
		int b;
		int y;
		
		for(int i=0; i<5; i++){
			ImageView imgView = new ImageView();
			imgView.setImage(imgList.get(i));
			if(i== 0){
				h=150;
				b=150;
				y=60;
			}else if(i==1){
				h=150;
				b=150;
				y=230;
			}else if(i==2){
				h=87;
				b=100;
				y=167;
			}else{
				h=87;
				b=100;
				y=277;
			}
			
			
			imgView.setFitHeight(h);
			imgView.setFitWidth(b);
			imgView.setX(numList.get(i));
			imgView.setY(y);
			
			DropShadow skygge = new DropShadow();
			skygge.setColor(Color.web("#000000"));
			skygge.setRadius(30);
			imgView.setEffect(skygge);
			
			pictures.add(imgView);
		}
	}
	
	public void makeT(){
		int y=170;
		
		for(int i=2; i<5; i++){
			if(i==2){
				y = 255;
			}else{
				y= 363;
			}
			Label label = new Label();
			label.setText(textList.get(i));
			label.setFont(new Font("Arial",20));
			label.setLayoutX(numList.get(i));
			label.setLayoutY(y);
			label.setTextFill(Color.web("#F8F8F8"));
			labels.add(label);
		}	

	}
	
	public ArrayList<ImageView> getPictures(){
		return pictures;
	}
	
	public ArrayList<Label> getLabels(){
		return labels;
	}

}
