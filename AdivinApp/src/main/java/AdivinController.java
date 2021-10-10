
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AdivinController implements Initializable {
	int numero = 0, i = 0;

	@FXML
	private VBox view;

	@FXML
	private TextField Numero;

	@FXML
	private Button Compronbar;

	@FXML
	void onClickComprobar(ActionEvent event) {
		if (numero < Integer.parseInt(Numero.getText())) {
			mostrarAlertMenor();
		}
		if (numero > Integer.parseInt(Numero.getText())) {
			
			mostrarAlertMayor();
		}
		if (numero == Integer.parseInt(Numero.getText())) {
			mostrarAlertAcierto();
		}
	}
	
	
	private void mostrarAlertMayor() {
	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.setHeaderText(null);
	    alert.setTitle("Fallo");
	    alert.setContentText("El numero es mayor que "+Numero.getText());
	    alert.showAndWait();
	}
	private void mostrarAlertMenor() {
	    Alert alert = new Alert(Alert.AlertType.WARNING);
	    alert.setHeaderText(null);
	    alert.setTitle("Fallo");
	    alert.setContentText("El numero es menor que "+Numero.getText());
	    alert.showAndWait();
	}
	private void mostrarAlertAcierto() {
	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    alert.setHeaderText(null);
	    alert.setTitle("Acierto");
	    alert.setContentText("El numero es : "+Numero.getText());
	    alert.showAndWait();
	}

	public AdivinController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
		Random r = new Random();
		numero = r.nextInt(99)+1;
	}

	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public VBox getView() {
		return view;
	}
	

	

}
