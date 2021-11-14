package calculadora;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculaController implements Initializable {

	// logic

	private Calculadora calculadora = new Calculadora();

	// model

	private SimpleStringProperty pantalla = new SimpleStringProperty();

	// view

	@FXML
	private GridPane view;

	@FXML
	private TextField pantallaText;

	public CalculaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {

		// bindeos aquí

		pantallaText.textProperty().bind(pantalla);

	}

	@FXML
	void onClick(ActionEvent event) {
		String texto = ((Button) event.getSource()).getText();
		switch (texto) {
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "0":
			calculadora.insertar(texto.charAt(0));
			break;
		case "+":
		case "-":
		case "*":
		case "/":
		case "=":
			calculadora.operar(texto.charAt(0));
			break;
		case "C":
			calculadora.borrar();
			break;
		case "CE":
			calculadora.borrarTodo();
			break;
		}
		pantalla.set(calculadora.getPantalla());
	}

	public GridPane getView() {
		return view;
	}

}
