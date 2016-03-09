package sample;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import klasser.Skilt;

public class FiveImage {
	
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList <Integer> numList = new ArrayList <Integer>();
	private ArrayList <Image> imgList = new ArrayList <Image>();
	private ArrayList <String> textList = new ArrayList <String>();
	
	public FiveImage(ArrayList<Skilt> skiltGruppe){
		numList.addAll(Arrays.asList(0,150,310,400,490));
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
			if(i<= 1){
				h=180;
				b=180;
				y=60;
			}else{
				h=100;
				b=100;
				y=260;
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
