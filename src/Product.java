import java.util.ArrayList;

public class Product {

	private String id;
	private String name;
	private String in_price,out_price;
	private int inventory_num;
	private String in_stock;
	private String description;
	private ArrayList<Size>size=new ArrayList<Size>();
	
	public Product(){
		super();
		size.add(new Size("M"));
		size.add(new Size("L"));
		size.add(new Size("XL"));
		size.add(new Size("XXL"));
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIn_price() {
		return in_price;
	}
	public void setIn_price(String in_price) {
		this.in_price = in_price;
	}
	public String getOut_price() {
		return out_price;
	}
	public void setOut_price(String out_price) {
		this.out_price = out_price;
	}
	public int getInventory_num() {
		inventory_num=0;
		for(int i=0;i<size.size();i++){
			inventory_num+=size.get(i).getInventory_num();
		}
		return inventory_num;
	}
	public void setInventory_num(int inventory_num) {
		this.inventory_num = inventory_num;
	}
	public String getIn_stock() {
		return in_stock;
	}
	public void setIn_stock(String in_stock) {
		this.in_stock = in_stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Size> getSize() {
		return size;
	}
	public void setSize(ArrayList<Size> size) {
		this.size = size;
	}
	public void transferColorForSize(String mau){
		for(int i=0;i<size.size();i++){
			size.get(i).addToListColor(mau);
		}
	}

}
