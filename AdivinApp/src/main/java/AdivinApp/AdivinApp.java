package AdivinApp;



import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	
public class AdivinApp extends Application{
	
	private AdivinController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new AdivinController();
		Scene scene = new Scene(controller.getView(), 320, 200);
		
		primaryStage.setTitle("AdivinApp con FXML");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
