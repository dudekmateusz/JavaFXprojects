package StoreWarehouse;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddButton implements EventHandler<MouseEvent>{
	public static EntityManager em = Persistence.createEntityManagerFactory("warehouse-ds").createEntityManager();

	private ObservableList<Product> getData(){
		TypedQuery<Product>q = em.createQuery("SELECT u FROM Product u ", Product.class);
		return FXCollections.observableArrayList(q.getResultList());
	}
	
	public void handle(MouseEvent event) {
		if(event.getButton()==MouseButton.PRIMARY) {
			if(event.getClickCount()==1) {
				
				final Stage newProductView = new Stage();
				GridPane root = new GridPane();
				newProductView.setScene(new Scene(root, 500, 400));
				
//				final ListView<Product> list = (ListView<Product>)event.getSource();
				final ListView<Product> list = new ListView<Product>(getData());
				final Product products = list.getSelectionModel().getSelectedItem();
//				root.add(list, 0, 1);
				
//				final Button adds = (Button)event.getSource();
//				final Product products = adds.; //nie wiem jakiego typu zrobić products, żeby tworzyła się tabelka, w której będę mógł wpisać poniższe dane i zapisać do tabeli
				
				root.add(new Label("Rodzaj"), 0, 0);
				root.add(new Label("Nazwa"), 1, 0);
				root.add(new Label("Cena"), 2, 0);
				root.add(new Label("Jednostka"), 3, 0);
				root.add(new Label("Zapas"), 4, 0);
				
				final TextField name = new TextField();
				final TextField surname = new TextField();
				final TextField price = new TextField();
				final TextField measure = new TextField();
				final TextField amount = new TextField();
				
				root.add(name, 0, 1);
				root.add(surname, 1, 1);
				root.add(price, 2, 1);
				root.add(measure, 3, 1);
				root.add(amount, 4, 1);
				
				Button save = new Button("Zapisz");
				root.add(save, 0, 2);
				save.setOnMouseClicked(new EventHandler<MouseEvent>() {
					
					public void handle(MouseEvent event) {
						products.setSurname(surname.getText());
						products.setPrice(Double.valueOf(price.getText()));
						products.setMeasure(measure.getText());
						products.setAmount(Double.valueOf(amount.getText()));
						
						WarehouseApp.em.getTransaction().begin();
//						WarehouseApp.em.persist(products);
						WarehouseApp.em.persist(new Product(name.getText(),surname.getText(),Double.valueOf(price.getText()),measure.getText(),Double.valueOf(amount.getText())));
						WarehouseApp.em.getTransaction().commit();//zapisanie w bazie
						list.refresh();
						newProductView.hide();
					}
				});
				
				newProductView.show();
				
			}
		}
		
	}

}
