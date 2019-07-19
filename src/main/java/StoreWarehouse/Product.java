package StoreWarehouse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "products")

public class Product {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(generator="increment") 
	@GenericGenerator(name="increment", strategy = "increment")

	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;

	@Column(name = "price")
	private double price;

	@Column(name = "measure")
	private String measure;

	@Column(name = "amount")
	private double amount;

	public Product() {}
	
	public Product(String name, String surname, double price, String measure, double amount) {
		this.name = name;
		this.surname = surname;
		this.price = price;
		this.measure = measure;
		this.amount = amount;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void addAmount(double amount) {
//		System.out.println(amount);
		this.amount += amount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getMeasure() {
		return measure;
	}

	@Override
	public String toString() {//nadpisanie metody toString - mega ważne, żeby ją nadpisać jak się pojawia @ i liczby (miejsce w pamięci)
//		return getName() + " "+ getSurname()+" - " + getPrice() + " zł za " + getMeasure() + ". Ilość: " + getAmount();
		return id+" | "+name+" | "+surname+" | "+price+" | "+measure+" | "+amount;
	}

}
