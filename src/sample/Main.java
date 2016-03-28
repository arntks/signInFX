package sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import klasser.Skilt;
import klasser.Splitt;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	private ArrayList<ImageView> pictures = new ArrayList<ImageView>();
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList<Label> fartLabels = new ArrayList<Label>();
	private	Stage primaryStage = new Stage();

	@Override
	public void start(Stage primaryStage) {
		Scanner scanner = new Scanner(System.in);
		String kortnr = scanner.next();
		//Stage primaryStage2 = new Stage();
		while (!(kortnr.equals("exit"))) {
			Stage primaryStage2 = new Stage();
			makeScene(kortnr, scanner, primaryStage2);
			kortnr = scanner.next();
		}
		//makeScene(kortnr, scanner, primaryStage2);
		Scanner scanner2 = new Scanner(System.in);
	}
	
	public void makeScene (String kortNr, Scanner scanner, Stage primaryStage) {
		try {
				String nokkel = kortNr + ".txt";
				Splitt splitt = new Splitt(nokkel);
				File fil = splitt.getFile();
				splitt.dele(fil);
				ArrayList<Skilt> skiltGruppe = splitt.getSkiltGruppe();

				AnchorPane root = FXMLLoader.load(getClass().getResource("/sample/bilder.fxml"));
				Scene scene = new Scene(root, 600, 400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				if (skiltGruppe.size() == 2) {
					TwoImage mp = new TwoImage(skiltGruppe);
					mp.makeP();
					pictures = mp.getPictures();
				} else if (skiltGruppe.size() == 3) {
					ThreeImage mp = new ThreeImage(skiltGruppe);
					mp.makeP();
					mp.makeT();
					pictures = mp.getPictures();
					labels = mp.getLabels();
				} else if (skiltGruppe.size() == 4) {
					FourImage mp = new FourImage(skiltGruppe);
					mp.makeP();
					mp.makeT();
					pictures = mp.getPictures();
					labels = mp.getLabels();
				} else if (skiltGruppe.size() == 5) {
					FiveImage mp = new FiveImage(skiltGruppe);
					mp.makeP();
					mp.makeT();
					pictures = mp.getPictures();
					labels = mp.getLabels();
				} else if (skiltGruppe.size() == 6) {
					SixImage mp = new SixImage(skiltGruppe);
					mp.makeP();
					mp.makeT();
					pictures = mp.getPictures();
					labels = mp.getLabels();
				} else {
					throw new IllegalArgumentException();
				}

				UpdateSpeed us = new UpdateSpeed(skiltGruppe.get(0));
				fartLabels = us.makeLabel();
				root.getChildren().addAll(fartLabels.get(0), fartLabels.get(1));

				TopLine topLine = new TopLine();
				Label topLabel = topLine.makeTopLabel();
				root.getChildren().add(topLabel);

				for (int i = 0; i < pictures.size(); i++) {
					root.getChildren().add(pictures.get(i));
					if (i > 1)
						root.getChildren().add(labels.get(i - 2));
				}


				primaryStage.setScene(scene);
				primaryStage.show();
				/*if(scanner.hasNext()){
					System.exit(1);
				}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	private static String lesKort() {
		Scanner scanner = new Scanner(System.in);
		String kortnr = scanner.next();
		return kortnr;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
