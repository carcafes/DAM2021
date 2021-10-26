package CambioDivisa;


import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	
public class DivisApp extends Application{
	
	private DivisaController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new DivisaController();
		
		Scene scene = new Scene(controller.getView(), 672, 200);
		
		primaryStage.setTitle("Reemplaza con FXML");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
