package com.infinityminers.encrypter.guis;

import java.io.IOException;

import com.infinityminers.encrypter.BasicKey;

import frames.LoaderClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Stages {

	public static Stage keyManagerMenuStage;
	public static Stage addKeyMenuStage;

	public static void bootUp(Stage primaryStage) throws IOException {

		// Create the stages.
		Stages.keyManagerMenuStage = new Stage();
		Stages.addKeyMenuStage = new Stage();

		// Give the stages scenes.
		keyManagerMenuStage
				.setScene(new Scene((BorderPane) FXMLLoader.load(LoaderClass.class.getResource("AddKeyMenu.fxml"))));
		Stages.addKeyMenuStage
				.setScene(new Scene((BorderPane) FXMLLoader.load(LoaderClass.class.getResource("AddKeyMenu.fxml"))));

		// Give the stages icons.
		keyManagerMenuStage.getIcons().add(new Image(images.LoaderClass.class.getResourceAsStream("ProgramIcon.png")));
		addKeyMenuStage.getIcons().add(new Image(images.LoaderClass.class.getResourceAsStream("ProgramIcon.png")));

		// Initialize the styles.
		keyManagerMenuStage.initStyle(StageStyle.UNDECORATED);
		addKeyMenuStage.initStyle(StageStyle.UNDECORATED);

		// Give the stages titles.
		Stages.keyManagerMenuStage.setTitle("Key Manager");
		Stages.addKeyMenuStage.setTitle("Add Key Menu");

		// Load keys into memory.
		BasicKey.bootUp();
	}
}
