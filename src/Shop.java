import java.util.Random;

public class Shop {
	private String id;
	private int inventory_num;
	
	
	public Shop(String id, int inventory_num) {
		super();
		this.id = id;
		this.inventory_num = inventory_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInventory_num() {
		return inventory_num;
	}
	public void setInventory_num(int inventory_num) {
		this.inventory_num = inventory_num;
	}
	
}
