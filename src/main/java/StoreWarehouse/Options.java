package StoreWarehouse;

public enum Options {

	DODAJ("Dodaj produkt do magazynu"), SPRZEDAJ("Wez produkt z magazynu"), WYSWIETL("Wyświetl zapas magazynu"), NOWY("Podaj rodzaj produktu,nazwę, cenę, miarę i ilość");

	private String helpText;

	private Options(String helpText) {
		this.helpText = helpText;
	}

	public String getHelpText() {
		return helpText;
	}

	public static Options getOptionByTxt(String txt) {
		for(Options item : Options.values()) {
			if(item.name().equalsIgnoreCase(txt)) {
				item.getHelpText();
				return item;
			}
		}

		return null;
	}
}
