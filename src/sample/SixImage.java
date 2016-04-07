package sample;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import klasser.Skilt;

public class SixImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <Image> imgList = new ArrayList <Image>();
	private ArrayList <String> textList = new ArrayList <String>();
	
	public SixImage(ArrayList<Skilt> skiltGruppe, ArrayList<ImageView> pictures, ArrayList<Label> labels){
		numList.addAll(Arrays.asList(60,60,302,468,302,468));
		for(int i=0; i<6; i++){
			imgList.add(skiltGruppe.get(i).hentBilde());
			textList.add(skiltGruppe.get(i).hentTekst());
		}
		this.pictures = pictures;
		this.labels = labels;
		
		
	}
	
	public void makeP(){
		int h;
		int b;
		int y;
		
		for(int i=0; i<6; i++){
			pictures.get(i).setImage(imgList.get(i));
			if(i==0){
				h=150;
				b=150;
				y=60;
			}else if(i==1){
				h=150;
				b=150;
				y=230;
			}else if((i==2)||(i==3)){
				h=87;
				b=100;
				y=173;
			}else{
				h=87;
				b=100;
				y=283;
			}
		
			pictures.get(i).setFitHeight(h);
			pictures.get(i).setFitWidth(b);
			pictures.get(i).setX(numList.get(i));
			pictures.get(i).setY(y);
			
			DropShadow skygge = new DropShadow();
			skygge.setColor(Color.web("#000000"));
			skygge.setRadius(30);
			pictures.get(i).setEffect(skygge);
		}
	}
	
	public void makeT(){
		int y;
		
		for(int i=2; i<6; i++){
			if(i==2||i==3){
				y=259;
			}else{
				y=369;
			}
			
			labels.get(i-2).setPrefSize(150, 15);
			labels.get(i-2).setText(textList.get(i));
			labels.get(i-2).setFont(new Font("Arial",18));
			labels.get(i-2).setLayoutX(numList.get(i)-25);
			labels.get(i-2).setLayoutY(y);
			labels.get(i-2).setTextFill(Color.web("#F8F8F8"));
			labels.get(i-2).setAlignment(Pos.CENTER);
			
			DropShadow skygge = new DropShadow();
			skygge.setColor(Color.web("#000000"));
			skygge.setRadius(15);
			labels.get(i-2).setEffect(skygge);
		}	
	}
	
	public ArrayList<ImageView> getPictures(){
		return pictures;
	}
	
	public ArrayList<Label> getLabels(){
		return labels;
	}

}
