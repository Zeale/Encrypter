package frames;

import com.infinityminers.encrypter.BasicKey;
import com.infinityminers.encrypter.Encrypter;
import com.infinityminers.encrypter.guis.Stages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class KeyManagerMenuController {

	@FXML
	private static TableView<BasicKey> keyTable;

	public static void bootKeyTable() {
		System.out.println("Booted once");
		keyTable.setEditable(true);

		ObservableList<BasicKey> keyList = FXCollections.observableArrayList();

	}

	@FXML
	private void closeProgram() {
		System.exit(0);
	}

	@FXML
	private void closeWindow() {
		if (Stages.keyManagerMenuStage.isShowing())
			Stages.keyManagerMenuStage.hide();
		else
			System.err.println("I was told to close the Key Manager window but it wasn't open! :(");
	}

	@FXML
	private void onGotoEncryptionPane() {
		Encrypter.stage.toFront();
	}
}
