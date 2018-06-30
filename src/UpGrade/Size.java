package UpGrade;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Size {

	private ArrayList<Color>color=new ArrayList<Color>();
	private String id;
	private int inventory_num;
	
	
	public Size(String id) {
		super();
		this.id = id;
	}
	public ArrayList<Color> getColor() {
		return color;
	}
	public void setColor(ArrayList<Color> color) {
		this.color = color;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInventory_num() {
		inventory_num=0;
		for(int i=0;i<color.size();i++){
			inventory_num+=color.get(i).getInventory_num();
		}		
		return inventory_num;
	}
	public void setInventory_num(int inventory_num) {
		this.inventory_num = inventory_num;
	}
	public void addToListColor(String tenMau){
		String maMau=unAccent(tenMau);
		maMau=layMaMau(maMau);
		color.add(new Color(maMau,tenMau));
	}
	public String unAccent(String s) {//tieng viet sang tieng anh
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
	}
	public String layMaMau(String cost){
		String result="";
		for(int i=0;i<cost.length();i++){
			if(cost.charAt(i)>='A'&&cost.charAt(i)<='Z'){
				result+=cost.charAt(i);
			}
		}
		return result;
	}
}
