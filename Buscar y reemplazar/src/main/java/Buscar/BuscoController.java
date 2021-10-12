package Buscar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BuscoController implements Initializable {


	  @FXML
	    private VBox view;

	    @FXML
	    private GridPane grid;

	    @FXML
	    private Label labelBuscar;

	    @FXML
	    private Label labelRemplazar;

	    @FXML
	    private TextField textRe;

	    @FXML
	    private TextField textBu;

	    @FXML
	    private Button buttonRe;

	    @FXML
	    private Button buttonBu;

	    @FXML
	    private Button buttonCerrar;

	    @FXML
	    private Button buttonReTodo;

	    @FXML
	    private Button buttonAyuda;

	    @FXML
	    private CheckBox buttonEx;

	    @FXML
	    private CheckBox buttonMayus;

	    @FXML
	    private CheckBox buttonResaltar;

	    @FXML
	    private CheckBox BuscarAtras;

	

	public BuscoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		

	}

	public VBox getView() {
		return view;
	}
	


}
