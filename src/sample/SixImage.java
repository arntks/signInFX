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
	
	public SixImage(ArrayList<Skilt> skiltGruppe){
		numList.addAll(Arrays.asList(0,100,150,220,300,400));
		for(int i=0; i<6; i++){
			imgList.add(skiltGruppe.get(i).hentBilde());
			textList.add(skiltGruppe.get(i).hentTekst());
		}
		
		
	}
	
	public void makeP(){
		int h;
		int b;
		int y=10;
		
		for(int i=0; i<6; i++){
			ImageView imgView = new ImageView();
			imgView.setImage(imgList.get(i));
			if(i<= 1){
				h=100;
				b=100;
			}else{
				h=50;
				b=50;
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
		
		for(int i=0; i<6; i++){
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
