package calculadora;


import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	
public class CalculApp extends Application{
	
	private CalculaController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new CalculaController();
		
		Scene scene = new Scene(controller.getView(), 500, 400);
		
		primaryStage.setTitle("Calculadora con FXML");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
