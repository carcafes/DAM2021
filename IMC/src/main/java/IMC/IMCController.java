package IMC;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class IMCController implements Initializable {
	float imc = 0;

	@FXML
	private VBox view;

	@FXML
	private TextField Peso;

	@FXML
	private TextField Altura;

	@FXML
	private Label IMC;

	@FXML
	private Label Clasificacion;

	public IMCController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		Altura.setText("0");
		Peso.setText("0");

	}

	public VBox getView() {
		return view;
	}

	public String imc() {
		String aux = "";
		float peso = Float.parseFloat(Peso.getText());
		float altura = Float.parseFloat(Altura.getText());
		imc = peso / (altura * altura);
		aux += imc;
		return aux;

	}

	@FXML
	public void actionPerformed() {
		IMC.setText(imc());
		if (Float.parseFloat(imc()) > 0)
			if (Float.parseFloat(imc()) < 18.5) {
				Clasificacion.setText("Bajo Peso");
			} else {
				if (Float.parseFloat(imc()) < 25) {
					Clasificacion.setText("Normal");
				} else {
					if (Float.parseFloat(imc()) < 30) {
						Clasificacion.setText("Sobrepeso");
					} else {
						{
							Clasificacion.setText("Obesidad");
						}
					}
				}
			}
	}
}
