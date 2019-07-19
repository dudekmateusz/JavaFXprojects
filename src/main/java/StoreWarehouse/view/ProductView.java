package StoreWarehouse.view;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import StoreWarehouse.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductView {
	
	private Stage stage;
	
	private VBox products;
	
	public static EntityManager em = Persistence.createEntityManagerFactory("warehouse-ds").createEntityManager();
	
	private ObservableList<Product> getData(){
		TypedQuery<Product>q = em.createQuery("SELECT u FROM Product u ", Product.class);
		return FXCollections.observableArrayList(q.getResultList());
	}
	
	public ProductView() {
	stage = new Stage();
	stage.centerOnScreen();
	stage.setTitle("Mój magazyn");
//	stage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("warehouse.png")));
	
	GridPane root = new GridPane();
	stage.setScene(new Scene(root, 700, 500));
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
	}
	
	 public void show() {
	        stage.showAndWait();
	    }

}
