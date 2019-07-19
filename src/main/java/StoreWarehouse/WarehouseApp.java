package StoreWarehouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WarehouseApp extends Application{
	public static EntityManager em = Persistence.createEntityManagerFactory("warehouse-ds").createEntityManager();

	public static void main(String[] args) {
		launch(args);
	}
	private ObservableList<Product> getData(){
		TypedQuery<Product>q = em.createQuery("SELECT u FROM Product u ", Product.class);
		return FXCollections.observableArrayList(q.getResultList());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.centerOnScreen();
		primaryStage.setTitle("Mój Magazyn");
		GridPane root = new GridPane();
		Label title = new Label("Produkty w magazynie");
		root.add(title, 0, 0);
		
		ListView<Product> list = new ListView<Product>(getData());
		list.setPrefSize(700, 500);
		root.add(list, 0, 1);
		list.setOnMouseClicked(new WarehouseListClick());
		list.setOnMouseClicked(new WarehouseListClick());
		
		Button adds = new Button("Dodaj");
		root.add(adds, 0, 2);
		adds.setOnMouseClicked(new AddButton());

		Scene scene = new Scene(root,700,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
