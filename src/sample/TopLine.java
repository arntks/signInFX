package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TopLine {
	
	public Label makeTopLabel(){
		Label topLabel = new Label();
		topLabel.setText("E 18");
		topLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		topLabel.setAlignment(Pos.CENTER);
		topLabel.setPrefHeight(40);
		topLabel.setPrefWidth(600);		
		topLabel.setStyle("-fx-background-color:#303030;");
		topLabel.setTextFill(Color.web("#F8F8F8"));
		
		return topLabel;
	}

}
