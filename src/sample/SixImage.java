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
		numList.addAll(Arrays.asList(0,100,150,220,300,400));
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
		int y=10;
		
		for(int i=0; i<6; i++){
			pictures.get(i).setImage(imgList.get(i));
			if(i<= 1){
				h=100;
				b=100;
			}else{
				h=50;
				b=50;
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
		int y=170;
		
		for(int i=2; i<6; i++){
			
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
