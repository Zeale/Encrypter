package com.infinityminers.encrypter;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.LinkedList;

import com.infinityminers.encrypter.guis.Stages;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * @author Zeale
 *
 */
public class Encrypter extends Application {

	public static String VERSION = "1.2.3";
	public static String NAME = "Encrypter";
	public static Stage stage;

	public static abstract class Tools {
		public static String decrypt(String input) {
			LinkedList<Character> chars = new LinkedList<Character>();
			String returnText = "";
			for (int i = 0; i < input.length(); i++) {
				char c0 = input.charAt(i);
				c0 = (char) (c0 - '\101');
				chars.add(i, Character.valueOf(c0));
			}
			for (int i = 0; i <= chars.size() - 1; i++) {
				returnText = returnText.concat(chars.get(i).toString());
			}
			return returnText;
		}

		public static String encrypt(String input) {
			LinkedList<Character> chars = new LinkedList<Character>();
			String returnText = "";
			for (int i = 0; i < input.length(); i++) {
				char c0 = input.charAt(i);
				c0 = (char) (c0 + '\101');
				chars.add(i, Character.valueOf(c0));
			}
			for (int i = 0; i <= chars.size() - 1; i++) {
				returnText = returnText.concat(chars.get(i).toString());
			}
			return returnText;
		}
	}

	private static boolean allowCopy = true;

	public static void main(String[] args) {
		Application.launch(Encrypter.class, args);
	}

	@FXML
	private Button encryptButton;
	@FXML
	private RadioButton decryptRadioButton;
	@FXML
	private TextField cryptoBox;
	@FXML
	private TextArea outputBox;
	@FXML
	private Tooltip encryptButtonTip;
	@FXML
	private Button closeButton;
	@FXML
	private Label errorLabel;

	@FXML
	private void addKey() {

	}

	@FXML
	private void equipKey() {

	}

	@FXML
	private void listKeys() {
		Stages.keyManagerMenuStage.show();
	}

	@FXML
	private void onExit() {
		try {
			this.stop();
		} catch (Exception e) {
			System.out.println("COULD NOT SUCCESFULLY CLOSE PROGRAM!");
			e.printStackTrace();
		}
		System.exit(0);
	}

	@FXML
	private void onCopy() {
		if (outputBox.getText().isEmpty() && cryptoBox.getText().isEmpty()
				|| !allowCopy && cryptoBox.getText().isEmpty())
			setOutputError("You must encrypt/decrypt something to copy!");
		else if (outputBox.getText().isEmpty() || !allowCopy) {
			setOutputError("You must encrypt/decrypt something to copy! Copying the input instead...");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(cryptoBox.getText()),
					null);
		} else
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(outputBox.getText()),
					null);
	}

	@FXML
	private void onDecryptRadioButtonClicked() {
		if (decryptRadioButton.isSelected()) {
			encryptButton.setText("Decrypt");
			encryptButtonTip.setText("Click here to decrypt text.");
			encryptButton.setPrefWidth(85);
		} else {
			encryptButton.setText("Encrypt");
			encryptButtonTip.setText("Click here to encrypt text.");
			encryptButton.setPrefWidth(80);
		}
	}

	@FXML
	private void onEncryptButtonClicked() {

		if (!decryptRadioButton.isSelected()) {
			// First we handle encryption.
			if (cryptoBox.getText().isEmpty())
				setOutputError("You didn't give me anything to encrypt.");
			else
				setOutputText(Tools.encrypt(cryptoBox.getText()));
		}

		// Then we handle decryption
		else {
			if (cryptoBox.getText().isEmpty()) {
				setOutputError("You didn't give me anything to decrypt.");
			} else
				setOutputText(Tools.decrypt(cryptoBox.getText()));
		}
	}

	@FXML
	private void onPaste() {
		try {
			cryptoBox.setText(cryptoBox.getText()
					+ (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor));
		} catch (HeadlessException e) {
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			setOutputError("The data stored on your clipboard was unpastable.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void removeKey() {

	}

	public void setOutputError(String error) {
		outputBox.setText(error);
		allowCopy = false;
	}

	public void setOutputText(String text) {
		outputBox.setText(text);
		allowCopy = true;
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		BorderPane main = (BorderPane) FXMLLoader.load(Encrypter.class.getResource("EncrypterFrame.fxml"));
		Scene scene = new Scene(main);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.setTitle(NAME + " V" + VERSION);
		stage.show();
		stage.addEventHandler(WindowEvent.WINDOW_SHOWING, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				encryptButton.setMaxWidth(85);
			}
		});
		Stages.bootUp();

	}

}
