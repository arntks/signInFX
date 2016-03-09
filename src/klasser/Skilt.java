package klasser;

import javafx.scene.image.Image;

/**
 * Created by ArntKristoffer on 09.03.2016.
 */
public abstract class Skilt {

    protected int skiltnr;
    protected int skiltgruppe;

    public int getSkiltgruppe() {
        return skiltgruppe;
    }

    public int getSkiltnr() {
        return skiltnr;
    }

    public Image hentBilde() {
        //metode som henter ut bilde basert på skiltnr og gruppe
        String imageUrl;
        StringBuilder sb = new StringBuilder("andre_ting\\img\\" + this.getSkiltgruppe() + "_" + this.getSkiltnr() + ".jpg");
        imageUrl = sb.toString();
        Image bilde = new Image(imageUrl);
        return bilde;
    }
}
