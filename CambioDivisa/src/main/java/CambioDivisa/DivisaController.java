package CambioDivisa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class DivisaController implements Initializable {
int origen,destino;
	@FXML
    private TextField Destino;

    @FXML
    private ComboBox<?> DestinoBox;

    @FXML
    private TextField Origen;

    @FXML
    private ComboBox<?> OrigenBox;

    @FXML
    private Button botonCambiar;

    @FXML
    private Pane view;

    @FXML
    void onClickBotonCambiar(ActionEvent event) {

    }
    
	public DivisaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		

	}

	public Pane getView() {
		return view;
	}
	


}
