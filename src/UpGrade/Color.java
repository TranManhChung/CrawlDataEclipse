package UpGrade;
import java.util.ArrayList;
import java.util.Random;

public class Color {
	private String id;
	private String name;
	private int inventory_num;
	private ArrayList<Shop>shop=new ArrayList<Shop>();
	
	
	
	public Color(String id,String name) {
		super();
		this.id = id;
		this.name=name;
		
		int dau=randomFunction(29,0);
		int cuoi=randomFunction(29,0);
		if(dau>cuoi){
			int temp=dau;
			dau=cuoi;
			cuoi=temp;
		}
		for(int i=dau;i<=cuoi;i++){
			shop.add(new Shop("shop_"+i,i));
		}
		inventory_num=0;
		for(int i=0;i<shop.size();i++){
			inventory_num+=shop.get(i).getInventory_num();
		}
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
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
	public ArrayList<Shop> getShop() {
		return shop;
	}
	public void setShop(ArrayList<Shop> shop) {
		this.shop = shop;
	}
	public void addToListShop(Shop a){
		shop.add(a);
	}
	public int randomFunction(int max,int min){
		Random rn = new Random();
        int range = max - min + 1;
        int randomNum = 0 + rn.nextInt(range);
        return randomNum;
	}
}
