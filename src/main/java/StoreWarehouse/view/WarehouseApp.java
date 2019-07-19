package StoreWarehouse.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class WarehouseApp extends Application{

	public static void main(String[] args) {
		WarehouseApp.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ProductView productView = new ProductView();
		productView.show();

			
	}

}
