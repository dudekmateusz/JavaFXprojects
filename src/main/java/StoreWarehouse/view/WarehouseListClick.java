package StoreWarehouse.view;

import StoreWarehouse.Product;
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

public class WarehouseListClick implements EventHandler<MouseEvent>{

	public void handle(MouseEvent event) {
		if(event.getButton()==MouseButton.PRIMARY) {
			if(event.getClickCount()==2) {
				
				final Stage productView = new Stage();
				GridPane root = new GridPane();
				productView.setScene(new Scene(root, 500, 400));
				
				final ListView<Product> list = (ListView<Product>)event.getSource();
				final Product products = list.getSelectionModel().getSelectedItem();
				
				root.add(new Label("Rodzaj"), 0, 0);
				root.add(new Label("Nazwa"), 1, 0);
				root.add(new Label("Cena"), 2, 0);
				root.add(new Label("Jednostka"), 3, 0);
				root.add(new Label("Zapas"), 4, 0);
				final TextField name = new TextField(products.getName());
				final TextField surname = new TextField(products.getSurname());
				final TextField price = new TextField(String.valueOf(products.getPrice()));
				final TextField measure = new TextField(products.getMeasure());
				final TextField amount = new TextField(String.valueOf(products.getAmount()));
				root.add(name, 0, 1);
				root.add(surname, 1, 1);
				root.add(price, 2, 1);
				root.add(measure, 3, 1);
				root.add(amount, 4, 1);
				
				Button save = new Button("Zapisz");
				root.add(save, 0, 2);
				save.setOnMouseClicked(new EventHandler<MouseEvent>() {
					
					public void handle(MouseEvent event) {
						products.setName(name.getText());
						products.setSurname(surname.getText());
						products.setPrice(Double.valueOf(price.getText()));
						products.setMeasure(measure.getText());
						products.setAmount(Double.valueOf(amount.getText()));
					
						
						WarehouseApp.em.getTransaction().begin();
						WarehouseApp.em.persist(products);
//						WarehouseApp.em.persist(new Product(products.getName(),products.getSurname(),products.getPrice(),products.getMeasure(),products.getAmount()));
						WarehouseApp.em.getTransaction().commit();//zapisanie w bazie
						list.refresh();
						productView.hide();
					}
				});
				productView.show();
				}
			}
			
		
	}

}
