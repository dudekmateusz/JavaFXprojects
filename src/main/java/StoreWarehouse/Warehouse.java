package StoreWarehouse;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Warehouse implements Storage {
	EntityManager em = Persistence.createEntityManagerFactory("warehouse-ds").createEntityManager();

	private Product[] products = new Product[0];

	public Warehouse() {
		TypedQuery<Product> q = em.createQuery("SELECT p FROM Product p ", Product.class);
		List<Product> res = q.getResultList();
		products = new Product[res.size()];
		int i = 0;
		for (Product item : res) {
			products[i++] = item;
		}
	}

	private void extendsProduct() {// dodaj Produkt danego typu do tablicy(magazynu)
		Product[] tmp = new Product[products.length + 1];
		for (int i = 0; i < products.length; i++) {
			tmp[i] = products[i];
		}
		products = tmp;
	}

	public Storage storeTheProduct(Product prod) {
		for (Product item : products) {
			if (item.getName().equals(prod.getName())) {
				item.addAmount(prod.getAmount());
				return this;
			}
		}

		extendsProduct();
		products[products.length - 1] = prod;

		return this;
	}

	public Storage storeTheProduct(String name, String surname, double amount) {
		for (Product item : products) {
//			if(item.getName().equalsIgnoreCase(name)){
			if (item.getName().equals(name)) {
				if (item.getSurname().equals(surname)) {

					item.addAmount(amount);
					em.getTransaction().begin();
					try {
						em.persist(item);
						em.getTransaction().commit();
					} catch (Exception e) {
						em.getTransaction().rollback();
					}
					break;
				}
				return this;
			}
		}

		return this;
	}

	public Storage spendTheProduct(String name, String surname, double amount) {
		for (Product item : products) {
			if (item.getName().equals(name)) {
				if (item.getSurname().equals(surname)) {
					item.addAmount(-1 * amount);
					return this;
				}
				return this;
			}
		}

		System.out.println("Nie ma takich produktów w magazynie!");
		return this;
	}

	public void showInventory() {
		for (Product item : products) {
			System.out.println(item);
		}
	}

	public Storage storeNewProduct(String name, String surname, double price, String measure, double amount) {
		for (Product item : products) {
			if (item.getName().equals(name)) {
				if (!item.getSurname().equals(surname)) {
					item.setSurname(surname);
					item.setPrice(price);
					item.setMeasure(measure);
					item.setAmount(amount);
					return this;
				}
				return this;
			}
		}
		return null;
	}

}
