package com.infinityminers.encrypter;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

import com.infinityminers.encrypter.guis.Stages;

import frames.AddKeyMenuController;
import frames.KeyManagerMenuController;
import frames.LoaderClass;
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
import javafx.scene.image.Image;
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

	private static boolean allowCopy = true;

	public static final File DIRECTORY = new File("C:/Encryption/");

	public static final File KEY_DIRECTORY = new File(DIRECTORY, "keys/");

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
		Stages.addKeyMenuStage.show();
	}

	@FXML
	private void equipKey() {

	}

	@Override
	public void init() throws Exception {
		if (!DIRECTORY.exists())
			DIRECTORY.mkdirs();
		if (!KEY_DIRECTORY.exists())
			KEY_DIRECTORY.mkdirs();
		super.init();
	}

	@FXML
	private void listKeys() {
		try {
			Stages.keyManagerMenuStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
			encryptButton.setPrefWidth(95);
		} else {
			encryptButton.setText("Encrypt");
			encryptButtonTip.setText("Click here to encrypt text.");
			encryptButton.setPrefWidth(107);
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

		BorderPane main = (BorderPane) FXMLLoader.load(LoaderClass.class.getResource("EncrypterFrame.fxml"));
		Scene scene = new Scene(main);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.getIcons().add(new Image(images.LoaderClass.class.getResourceAsStream("ProgramIcon.png")));
		stage.setScene(scene);
		stage.setTitle(NAME + " V" + VERSION);
		stage.show();

		stage.addEventHandler(WindowEvent.WINDOW_SHOWING, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				encryptButton.setMaxWidth(85);
				KeyManagerMenuController.bootKeyTable();
				AddKeyMenuController.bootUp();
			}
		});
		bootUp(primaryStage);

	}

	public static boolean isFirstRun = false;

	public static void bootUp(Stage primaryStage) throws IOException {
		if (DIRECTORY.mkdirs()) {
			System.out.println("Created the Encryption directory.");
			isFirstRun = true;
		}
		if (KEY_DIRECTORY.mkdir())
			System.out.println("Created the Encryption Keys directory.");

		Stages.bootUp(primaryStage);

	}

}
