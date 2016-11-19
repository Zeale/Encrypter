package com.infinityminers.encrypter.guis.logic;

import com.infinityminers.encrypter.Encrypter;
import com.infinityminers.encrypter.Key;
import com.infinityminers.encrypter.guis.Stages;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class KeyManagerMenuController {

	@FXML
	private static TableView<Key> keyTable;

	@FXML
	private void closeWindow() {
		if (Stages.keyManagerMenuStage.isShowing())
			Stages.keyManagerMenuStage.hide();
		else
			System.err.println("I was told to close the Key Manager window but it wasn't open! :(");
	}

	@FXML
	private void closeProgram() {
		System.exit(0);
	}

	@FXML
	private void onGotoEncryptionPane() {
		Encrypter.stage.toFront();
	}

	public static void bootKeyTable() {
	}
}
