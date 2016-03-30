package sample;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import klasser.Skilt;

public class SixImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <Image> imgList = new ArrayList <Image>();
	private ArrayList <String> textList = new ArrayList <String>();
	
	public SixImage(ArrayList<Skilt> skiltGruppe, ArrayList<ImageView> pictures){
		numList.addAll(Arrays.asList(0,100,150,220,300,400));
		for(int i=0; i<6; i++){
			imgList.add(skiltGruppe.get(i).hentBilde());
			textList.add(skiltGruppe.get(i).hentTekst());
		}
		this.pictures = pictures;
		
		
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
		}
	}
	
	public void makeT(){
		int y=170;
		
		for(int i=2; i<6; i++){
			Label label = new Label();
			label.setText(textList.get(i));
			label.setFont(new Font("Arial",30));
			label.setLayoutX(numList.get(i));
			label.setLayoutY(y);
			
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
