package StoreWarehouse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Reader {

	private BufferedReader reader;

	public Reader(InputStream in) {
		reader = new BufferedReader(new InputStreamReader(in));
	}

	public String readString() {
		try { // start sekcji try wyczulenie na wystapienia wyjÄ…tkĂłw
			return reader.readLine(); // odczytanie linii tekstu
		} catch (IOException e) { // jeĹĽeli wystÄ…pi wyjÄ…tek typu IOException
			e.printStackTrace(); // wypisanie zrzutu z pamieci
		}

		return null;
	}

	public static void main(String[] args) {
		Reader reader = new Reader(System.in);
		Warehouse warhouse = new Warehouse();
		
		Apple apple = new Apple("Jabłko","Lobo", 2.5, "kilogram", 1);
		Milk milk = new Milk("Mleko","Mućka",2.2,"litr",1);
		Candy kitkat = new Candy("Baton","KitKat", 2.8, "sztuka", 1);
		Banana banan = new Banana("Banan","Chiquita", 4, "kilogram", 1);
		
		warhouse.storeTheProduct(apple);
		warhouse.storeTheProduct(milk);
		warhouse.storeTheProduct(kitkat);
		warhouse.storeTheProduct(banan);
	
		while (true) {
			for (Options item : Options.values()) {
				System.out.println(item+" ("+item.getHelpText()+")");
			}

			String line = reader.readString();
			if (line.toLowerCase().equals("exit")) {
				break; // jeĹĽeli podaĹ‚ t to przerywamy pÄ™tle while
			}

			String[] val = line.split("[ ,,]");
			Options option = Options.getOptionByTxt(val[0]);
			switch (option) {
			case DODAJ:
//				EntityManager em = Persistence.createEntityManagerFactory("warehouse-ds").createEntityManager();
				warhouse.storeTheProduct(val[1],val[2], Double.valueOf(val[3]));
//				em.getTransaction().begin();
//				try {
//					em.persist(warhouse);
//					em.getTransaction().commit();
//				}catch(Exception e) {
//					em.getTransaction().rollback();
//				}
				break;
			case SPRZEDAJ:
				warhouse.spendTheProduct(val[1], val[2], Double.valueOf(val[3]));
				break;
			case WYSWIETL:
				warhouse.showInventory();
				break;
			case NOWY:
//				em = Persistence.createEntityManagerFactory("warehouse-ds").createEntityManager();
				warhouse.storeNewProduct(val[1], val[2], Double.valueOf(val[3]), val[4], Double.valueOf(val[5]));
//				em.getTransaction().begin();
//				try {
//					em.persist(warhouse);
//					em.getTransaction().commit();
//				}catch(Exception e) {
//					em.getTransaction().rollback();
//				}
			default:
				System.out.println("Nie ma takiej opcji, wybierz ponownie: ");
			}
		}

	}

}//wywala mi błąd przy wpisywaniu nowego produktu, przechodzi do defaulta. Dodatkowo nie dodaje produktów do bazy sql
