package StoreWarehouse;

public interface Storage {
	
	public Storage storeTheProduct (Product prod);

	public Storage storeTheProduct (String name, String surname, double amount);//przyjmowanie towaru
	
	public Storage storeNewProduct(String name, String surname, double price, String measure, double amount);
	
	public Storage spendTheProduct(String name, String surname, double amount); //wydawanie towaru
	
	public void showInventory(); //pobieranie informacji o stanie magazynu

	
	

}
