package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
	
	@FXML
    private ImageView hovedBilde1;
	
	public void setImage() throws Exception{
        Image image = new Image("img/1_110.jpg");
        hovedBilde1.setImage(image);
	}
}
