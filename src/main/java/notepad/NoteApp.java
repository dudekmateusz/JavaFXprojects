package notepad;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class NoteApp extends Application {

	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Notatnik dla kursantów Codeme");
		GridPane root = new GridPane();
		GridPane root1 = new GridPane();
		
		
		TextArea textArea = new TextArea(
			
			);

		textArea.setPrefSize(1000, 600);
 
		root.add(textArea, 0, 1);

		Scene scene = new Scene(root, 1000, 600); 
		primaryStage.setScene(scene);

		
		primaryStage.show();
		
		Button save = new Button("Zapis");
		root.add(save, 0, 0);
		Button save1 = new Button("Zapis");
		root1.add(save1, 0, 0);
		Button delete = new Button("Usuń");
		root1.add(delete, 1, 0);
		save.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override		
			public void handle(MouseEvent event) {
				
				
				
			}
		});


			
	}

}
//"C:/Users/Madzia/Desktop/trawa.jpg"