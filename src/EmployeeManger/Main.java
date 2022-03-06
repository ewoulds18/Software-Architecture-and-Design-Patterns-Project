package src.EmployeeManger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static final View view = new View();
	
	public static void main(String[] args){
		launch(args);}
	
	@Override
	public void start(Stage primaryStage) {
		try{
			Scene scene = new Scene(view, 1000, 500);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
