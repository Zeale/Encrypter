package com.infinityminers.encrypter.guis;

import java.io.IOException;

import com.infinityminers.encrypter.guis.logic.KeyManagerMenuController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Stages {

	public static Stage keyManagerMenuStage;

	public static void bootUp() throws IOException {
		keyManagerMenuStage = new Stage();
		keyManagerMenuStage.initStyle(StageStyle.UNDECORATED);
		keyManagerMenuStage.setScene(new Scene(
				(BorderPane) FXMLLoader.load(KeyManagerMenuController.class.getResource("KeyManagerMenu.fxml"))));
		keyManagerMenuStage.setTitle("Key Manager");
	}

}
