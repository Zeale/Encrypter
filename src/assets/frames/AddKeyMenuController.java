package frames;

import java.awt.Button;
import java.io.File;

import com.infinityminers.encrypter.BasicKey;
import com.infinityminers.encrypter.Encrypter;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.text.Text;

public class AddKeyMenuController {

	@FXML
	public static MenuBar menuBar;

	@FXML
	public static TextField field_A;
	@FXML
	public static TextField field_B;
	@FXML
	public static TextField field_C;
	@FXML
	public static TextField field_D;
	@FXML
	public static TextField field_E;
	@FXML
	public static TextField field_F;
	@FXML
	public static TextField field_G;
	@FXML
	public static TextField field_H;
	@FXML
	public static TextField field_I;
	@FXML
	public static TextField field_J;
	@FXML
	public static TextField field_K;
	@FXML
	public static TextField field_L;
	@FXML
	public static TextField field_M;
	@FXML
	public static TextField field_N;
	@FXML
	public static TextField field_O;
	@FXML
	public static TextField field_P;
	@FXML
	public static TextField field_Q;
	@FXML
	public static TextField field_R;
	@FXML
	public static TextField field_S;
	@FXML
	public static TextField field_T;
	@FXML
	public static TextField field_U;
	@FXML
	public static TextField field_V;
	@FXML
	public static TextField field_W;
	@FXML
	public static TextField field_X;
	@FXML
	public static TextField field_Y;
	@FXML
	public static TextField field_Z;
	@FXML
	public static TextField field_a;
	@FXML
	public static TextField field_b;
	@FXML
	public static TextField field_c;
	@FXML
	public static TextField field_d;
	@FXML
	public static TextField field_e;
	@FXML
	public static TextField field_f;
	@FXML
	public static TextField field_g;
	@FXML
	public static TextField field_h;
	@FXML
	public static TextField field_i;
	@FXML
	public static TextField field_j;
	@FXML
	public static TextField field_k;
	@FXML
	public static TextField field_l;
	@FXML
	public static TextField field_m;
	@FXML
	public static TextField field_n;
	@FXML
	public static TextField field_o;
	@FXML
	public static TextField field_p;
	@FXML
	public static TextField field_q;
	@FXML
	public static TextField field_r;
	@FXML
	public static TextField field_s;
	@FXML
	public static TextField field_t;
	@FXML
	public static TextField field_u;
	@FXML
	public static TextField field_v;
	@FXML
	public static TextField field_w;
	@FXML
	public static TextField field_x;
	@FXML
	public static TextField field_y;
	@FXML
	public static TextField field_z;

	@FXML
	private static TextField keyNameTextField;
	@FXML
	private static Text helpText;
	@FXML
	private static Text canContainWarningText;
	@FXML
	private static Button createKeyButton;

	@FXML
	private static void createNewKey() {
		// We create a key with the name in the field.
		BasicKey basicKey = new BasicKey(new File(Encrypter.KEY_DIRECTORY, keyNameTextField.getText()));
		// Now lets set the key name input field, it's button, and the black
		// 'can contain' warning text to be invisible and uneditable.
		canContainWarningText.setVisible(false);
		createKeyButton.setVisible(false);
		createKeyButton.setEnabled(false);
		keyNameTextField.setVisible(false);
		keyNameTextField.setEditable(false);
		// Now we will modify the help text accordingly.

		setKeyUsable(true);

	}

	@FXML
	public static void onAddToEncryptionKey_A() {

	}

	@FXML
	public static void onAddToEncryptionKey_B() {

	}

	@FXML
	public static void onAddToEncryptionKey_C() {

	}

	@FXML
	public static void onAddToEncryptionKey_D() {

	}

	@FXML
	public static void onAddToEncryptionKey_E() {

	}

	@FXML
	public static void onAddToEncryptionKey_F() {

	}

	@FXML
	public static void onAddToEncryptionKey_G() {

	}

	@FXML
	public static void onAddToEncryptionKey_H() {

	}

	@FXML
	public static void onAddToEncryptionKey_I() {

	}

	@FXML
	public static void onAddToEncryptionKey_J() {

	}

	@FXML
	public static void onAddToEncryptionKey_K() {

	}

	@FXML
	public static void onAddToEncryptionKey_L() {

	}

	@FXML
	public static void onAddToEncryptionKey_M() {

	}

	@FXML
	public static void onAddToEncryptionKey_N() {

	}

	@FXML
	public static void onAddToEncryptionKey_O() {

	}

	@FXML
	public static void onAddToEncryptionKey_P() {

	}

	@FXML
	public static void onAddToEncryptionKey_Q() {

	}

	@FXML
	public static void onAddToEncryptionKey_R() {

	}

	@FXML
	public static void onAddToEncryptionKey_S() {

	}

	@FXML
	public static void onAddToEncryptionKey_T() {

	}

	@FXML
	public static void onAddToEncryptionKey_U() {

	}

	@FXML
	public static void onAddToEncryptionKey_V() {

	}

	@FXML
	public static void onAddToEncryptionKey_W() {

	}

	@FXML
	public static void onAddToEncryptionKey_X() {

	}

	@FXML
	public static void onAddToEncryptionKey_Y() {

	}

	@FXML
	public static void onAddToEncryptionKey_Z() {

	}

	@FXML
	public static void onAddToEncryptionKey_a() {

	}

	@FXML
	public static void onAddToEncryptionKey_b() {

	}

	@FXML
	public static void onAddToEncryptionKey_c() {

	}

	@FXML
	public static void onAddToEncryptionKey_d() {

	}

	@FXML
	public static void onAddToEncryptionKey_e() {

	}

	@FXML
	public static void onAddToEncryptionKey_f() {

	}

	@FXML
	public static void onAddToEncryptionKey_g() {

	}

	@FXML
	public static void onAddToEncryptionKey_h() {

	}

	@FXML
	public static void onAddToEncryptionKey_i() {

	}

	@FXML
	public static void onAddToEncryptionKey_j() {

	}

	@FXML
	public static void onAddToEncryptionKey_k() {

	}

	@FXML
	public static void onAddToEncryptionKey_l() {

	}

	@FXML
	public static void onAddToEncryptionKey_m() {

	}

	@FXML
	public static void onAddToEncryptionKey_n() {

	}

	@FXML
	public static void onAddToEncryptionKey_o() {

	}

	@FXML
	public static void onAddToEncryptionKey_p() {

	}

	@FXML
	public static void onAddToEncryptionKey_q() {

	}

	@FXML
	public static void onAddToEncryptionKey_r() {

	}

	@FXML
	public static void onAddToEncryptionKey_s() {

	}

	@FXML
	public static void onAddToEncryptionKey_t() {

	}

	@FXML
	public static void onAddToEncryptionKey_u() {

	}

	@FXML
	public static void onAddToEncryptionKey_v() {

	}

	@FXML
	public static void onAddToEncryptionKey_w() {

	}

	@FXML
	public static void onAddToEncryptionKey_x() {

	}

	@FXML
	public static void onAddToEncryptionKey_y() {

	}

	@FXML
	public static void onAddToEncryptionKey_z() {

	}

	private static void setKeyUsable(boolean value) {
		field_a.setEditable(value);
		field_b.setEditable(value);
		field_c.setEditable(value);
		field_d.setEditable(value);
		field_e.setEditable(value);
		field_f.setEditable(value);
		field_g.setEditable(value);
		field_h.setEditable(value);
		field_i.setEditable(value);
		field_j.setEditable(value);
		field_k.setEditable(value);
		field_l.setEditable(value);
		field_m.setEditable(value);
		field_n.setEditable(value);
		field_o.setEditable(value);
		field_p.setEditable(value);
		field_q.setEditable(value);
		field_r.setEditable(value);
		field_s.setEditable(value);
		field_t.setEditable(value);
		field_u.setEditable(value);
		field_v.setEditable(value);
		field_w.setEditable(value);
		field_x.setEditable(value);
		field_y.setEditable(value);
		field_z.setEditable(value);
		field_A.setEditable(value);
		field_B.setEditable(value);
		field_C.setEditable(value);
		field_D.setEditable(value);
		field_E.setEditable(value);
		field_F.setEditable(value);
		field_G.setEditable(value);
		field_H.setEditable(value);
		field_I.setEditable(value);
		field_J.setEditable(value);
		field_K.setEditable(value);
		field_L.setEditable(value);
		field_M.setEditable(value);
		field_N.setEditable(value);
		field_O.setEditable(value);
		field_P.setEditable(value);
		field_Q.setEditable(value);
		field_R.setEditable(value);
		field_S.setEditable(value);
		field_T.setEditable(value);
		field_U.setEditable(value);
		field_V.setEditable(value);
		field_W.setEditable(value);
		field_X.setEditable(value);
		field_Y.setEditable(value);
		field_Z.setEditable(value);

		field_a.setVisible(value);
		field_b.setVisible(value);
		field_c.setVisible(value);
		field_d.setVisible(value);
		field_e.setVisible(value);
		field_f.setVisible(value);
		field_g.setVisible(value);
		field_h.setVisible(value);
		field_i.setVisible(value);
		field_j.setVisible(value);
		field_k.setVisible(value);
		field_l.setVisible(value);
		field_m.setVisible(value);
		field_n.setVisible(value);
		field_o.setVisible(value);
		field_p.setVisible(value);
		field_q.setVisible(value);
		field_r.setVisible(value);
		field_s.setVisible(value);
		field_t.setVisible(value);
		field_u.setVisible(value);
		field_v.setVisible(value);
		field_w.setVisible(value);
		field_x.setVisible(value);
		field_y.setVisible(value);
		field_z.setVisible(value);
		field_A.setVisible(value);
		field_B.setVisible(value);
		field_C.setVisible(value);
		field_D.setVisible(value);
		field_E.setVisible(value);
		field_F.setVisible(value);
		field_G.setVisible(value);
		field_H.setVisible(value);
		field_I.setVisible(value);
		field_J.setVisible(value);
		field_K.setVisible(value);
		field_L.setVisible(value);
		field_M.setVisible(value);
		field_N.setVisible(value);
		field_O.setVisible(value);
		field_P.setVisible(value);
		field_Q.setVisible(value);
		field_R.setVisible(value);
		field_S.setVisible(value);
		field_T.setVisible(value);
		field_U.setVisible(value);
		field_V.setVisible(value);
		field_W.setVisible(value);
		field_X.setVisible(value);
		field_Y.setVisible(value);
		field_Z.setVisible(value);
	}

	public static void bootUp() {
		Reflection reflection = new Reflection();
		reflection.setBottomOpacity(0.2);
		reflection.setFraction(0.4);
		menuBar.setEffect(reflection);

		setKeyUsable(false);

	}

}
