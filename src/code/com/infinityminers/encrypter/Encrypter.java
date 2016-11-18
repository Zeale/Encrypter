package com.infinityminers.encrypter;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Encrypter extends Application {
	@FXML
	private Button encryptButton;
	@FXML
	private RadioButton decryptRadioButton;
	@FXML
	private TextField cryptoBox;
	@FXML
	private TextArea outputBox;

	// =========================================================================================================================
	// DECLARE FXML EVENT METHODS
	// =========================================================================================================================
	@FXML
	private void onEncryptButtonClicked() {

		if (!decryptRadioButton.isSelected()) {
			// First we handle encryption.
			if (cryptoBox.getText().isEmpty())
				outputBox.setText("You didn't give me anything to encrypt.");
			else
				outputBox.setText(Tools.encrypt(cryptoBox.getText()));
		}

		// Then we handle decryption
		else {
			if (cryptoBox.getText().isEmpty())
				outputBox.setText("You didn't give me anything to decrypt.");
			else
				outputBox.setText(Tools.decrypt(cryptoBox.getText()));
		}
	}

	@FXML
	private void onDecryptRadioButtonClicked() {
		if (decryptRadioButton.isSelected()) {
			encryptButton.setText("Decrypt");
			encryptButton.setPrefWidth(75);
		} else {
			encryptButton.setText("Encrypt");
			encryptButton.setPrefWidth(70);
		}
	}

	@FXML
	private void onPaste() {
		try {
			cryptoBox.setText(cryptoBox.getText()
					+ (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void onCopy() {
		if (outputBox.getText().isEmpty() && cryptoBox.getText().isEmpty()
				|| outputBox.getText().equals("You must encrypt/decrypt something to copy!")
						&& cryptoBox.getText().isEmpty()
				|| outputBox.getText()
						.equals("You must encrypt/decrypt something to copy! Copying the input instead...")
						&& cryptoBox.getText().isEmpty())
			outputBox.setText("You must encrypt/decrypt something to copy!");
		else if (outputBox.getText().isEmpty()
				|| outputBox.getText().equals("You must encrypt/decrypt something to copy!") || outputBox.getText()
						.equals("You must encrypt/decrypt something to copy! Copying the input instead...")) {

			outputBox.setText("You must encrypt/decrypt something to copy! Copying the input instead...");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(cryptoBox.getText()),
					null);

		} else
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(outputBox.getText()),
					null);
	}

	@FXML
	private void onClose() {
		System.exit(0);
	}

	// =========================================================================================================================
	// OVERRIDDEN METHODS
	// =========================================================================================================================

	@Override
	public void start(Stage primaryStage) throws IOException {
		BorderPane main = (BorderPane) FXMLLoader.load(Encrypter.class.getResource("EncrypterFrame.fxml"));
		Scene scene = new Scene(main);
		primaryStage.setScene(scene);
		primaryStage.setTitle(Information.NAME + " V" + Information.VERSION);
		primaryStage.show();

		primaryStage.addEventHandler(WindowEvent.WINDOW_SHOWING, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				encryptButton.setMaxWidth(85);
			}
		});

	}

	// =========================================================================================================================
	// DECLARE MAIN METHOD
	// =========================================================================================================================

	public static void main(String[] args) {
		Application.launch(Encrypter.class, args);
	}

	// =========================================================================================================================
	// DECLARE OTHER CLASSES
	// =========================================================================================================================

	/**
	 * @author Zeale
	 *
	 */
	public static abstract class Information {
		public static String VERSION = "1.0";
		public static String NAME = "Encrypter";
	}

	public static abstract class Tools {
		public static String encrypt(String input) {
			LinkedList<Character> chars = new LinkedList<Character>();
			String returnText = "";
			for (int i = 0; i < input.length(); i++) {
				char c0 = input.charAt(i);
				c0 = (char) (c0 + '\101');
				chars.add(i, Character.valueOf(c0));
			}
			for (int i = 0; i <= chars.size() - 1; i++) {
				returnText = returnText.concat(((Character) chars.get(i)).toString());
			}
			return returnText;
		}

		public static String decrypt(String input) {
			LinkedList<Character> chars = new LinkedList<Character>();
			String returnText = "";
			for (int i = 0; i < input.length(); i++) {
				char c0 = input.charAt(i);
				c0 = (char) (c0 - '\101');
				chars.add(i, Character.valueOf(c0));
			}
			for (int i = 0; i <= chars.size() - 1; i++) {
				returnText = returnText.concat(((Character) chars.get(i)).toString());
			}
			return returnText;
		}
	}
}
