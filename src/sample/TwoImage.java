package sample;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import klasser.Skilt;

public class TwoImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <Image> imgList = new ArrayList <Image>();
	private ArrayList <String> textList = new ArrayList <String>();
	
	public TwoImage(ArrayList<Skilt> skiltGruppe, ArrayList<ImageView> pictures){
		numList.addAll(Arrays.asList(0,150));
		for(int i=0; i<2; i++){
			imgList.add(skiltGruppe.get(i).hentBilde());
			textList.add(skiltGruppe.get(i).hentTekst());
		}
		this.pictures = pictures;
	}
	
	public void makeP(){
		
		int h=150;
		int b=150;
		int x=100;
		int y=10;
		
		for(int i=0; i<2; i++){
			pictures.get(i).setImage(imgList.get(i));
			
			if(i<= 1){
				h=200;
				b=200;
			}else{
				h=100;
				b=100;
			}
			pictures.get(i).setFitHeight(h);
			pictures.get(i).setFitWidth(b);
			pictures.get(i).setX(numList.get(i));
			pictures.get(i).setY(y);
			
		}
	}
	
	
	
	public ArrayList<ImageView> getPictures(){
		return pictures;
	}
	
	public ArrayList<Label> getLabels(){
		return labels;
	}

}
