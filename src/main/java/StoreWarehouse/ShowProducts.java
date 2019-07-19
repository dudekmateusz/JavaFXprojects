package StoreWarehouse;

public class ShowProducts extends Product{
	
	public ShowProducts(String name, String surname, double price, String measure, double amount) {
		super(name, surname, price, measure, amount);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public double getPrice() {
		return super.getPrice();
	}

	@Override
	public String getMeasure() {
		return super.getMeasure();
	}

	public static void main(String[] args) {
	
		System.out.println(new ShowProducts("Baton","KitKat", 2.2, "sztukę", 5));
		System.out.println(new ShowProducts("Jabłko","Lobo", 2.5, "kilogram", 2));
		System.out.println(new ShowProducts("Mleko","UHT", 2.4 , "litr", 8));
		System.out.println(new ShowProducts("Chipsy","Crunchips", 5, "opakowanie", 14));
		
		
		
	}
}
