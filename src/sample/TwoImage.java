package sample;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import klasser.Skilt;

public class TwoImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <Image> imgList = new ArrayList <Image>();
	private ArrayList <String> textList = new ArrayList <String>();
	
	public TwoImage(ArrayList<Skilt> skiltGruppe, ArrayList<ImageView> pictures, ArrayList<Label> labels){
		numList.addAll(Arrays.asList(60,60));
		for(int i=0; i<2; i++){
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
		
		for(int i=0; i<2; i++){
			pictures.get(i).setImage(imgList.get(i));
			
			if(i< 1){
				h=150;
				b=150;
				y= 60;
			}else{
				h=150;
				b=150;
				y=230;
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
	
	
	
	public ArrayList<ImageView> getPictures(){
		return pictures;
	}
	
	public ArrayList<Label> getLabels(){
		return labels;
	}

}
