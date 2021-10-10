package IMC;


import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.stage.Stage;
	
public class IMCApp extends Application{
	
	private IMCController controller;
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new IMCController();
		
		Scene scene = new Scene(controller.getView(), 320, 200);
		
		primaryStage.setTitle("IMC con FXML");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
