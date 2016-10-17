package primek.osszeadas.kezelo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import primek.osszeadas.szamellenorzes.primEllenorzes;

public class PrimekOsszeadasaKezelo implements Initializable {

	@FXML
	private Text beadottSzam;

	@FXML
	private Text primekOsszege;

	@FXML
	private Text hibaUzenet;

	@FXML
	private Text szoveg1;

	@FXML
	private Text szoveg2;

	@FXML
	private TextField megadottSzam;

	@FXML
	private void szamol(ActionEvent event) {

		if (megadottSzam.getText().isEmpty()) {
			hibaUzenet.setFill(Color.RED);
			hibaUzenet.setText("Meg kell adni egy számot!");
			SzovegElrejtese();
			return;
		}

		if (megadottSzam.getText().length() >=10 ) {
			hibaUzenet.setFill(Color.RED);
			hibaUzenet.setText("A maximum megadható szám 5000!");
			SzovegElrejtese();
			NagyobbSzam();
			return;
		}

		String mennyitadjonOssze = megadottSzam.getText();

		int beirtSzam = Integer.parseInt(mennyitadjonOssze);

		long eredmeny = 0;
		int szam = 2;
		int szamlalo = 0;

		if (beirtSzam > 5000) {
			hibaUzenet.setFill(Color.RED);
			hibaUzenet.setText("A maximum megadható szám 5000!");
			SzovegElrejtese();
			NagyobbSzam();
			return;
		}

		while (szamlalo < beirtSzam) {
			if (primEllenorzes.PrimVizsgalat(szam)) {
				eredmeny = eredmeny + szam;
				szamlalo++;
			}
			szam++;
		}

		OsszegKiirasa();
		beadottSzam.setFill(Color.GREEN);
		beadottSzam.setText(mennyitadjonOssze);
		String osszeg = Long.toString(eredmeny);
		primekOsszege.setFill(Color.GREEN);
		primekOsszege.setText(osszeg);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SzovegElrejtese();
	}

	public void SzovegElrejtese() {
		szoveg1.setVisible(false);
		szoveg2.setVisible(false);
		beadottSzam.setVisible(false);
		primekOsszege.setVisible(false);
	}

	public void NagyobbSzam() {
		megadottSzam.clear();
		beadottSzam.setText("");
		primekOsszege.setText("");
	}

	public void OsszegKiirasa() {
		szoveg1.setVisible(true);
		szoveg2.setVisible(true);
		beadottSzam.setVisible(true);
		primekOsszege.setVisible(true);
		hibaUzenet.setText("");
		megadottSzam.clear();
	}

}
