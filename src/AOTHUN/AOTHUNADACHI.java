//package AOTHUN;
//
//	import java.io.IOException;
//
//	import java.text.Normalizer;
//	import java.util.regex.Pattern;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//
//import org.jsoup.Jsoup;
//	import org.jsoup.nodes.Document;
//	import org.jsoup.nodes.Element;
//	import org.jsoup.select.Elements;
//
//import java.io.File;
//import java.io.FileOutputStream;
//	import java.io.IOException;
//	import java.io.InputStream;
//	import java.io.OutputStream;
//	import java.net.URL;
//	import java.util.ArrayList;
//	import java.util.List;
//	import java.util.Random;
//
//	
//public class AOTHUNADACHI {
//
//static ArrayList<Product>productList=new ArrayList<Product>();
//	
//	public static String unAccent(String s) {//tieng viet sang tieng anh
//        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
//        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
//}
//	
//	public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException{
//		
//		fetchData("https://yame.vn/shop/giay-da?s=1","GN_GD_","GN_GD/Photo/");
//		writeFile(productList,"C:\\Users\\Tran Manh Chung\\workspace\\Crawl data\\GN_GD\\Info\\product_list.xml");
//			
//	}
//	
//	static void fetchData(String linkInput,String idGoc,String duongDan) throws IOException{
//		
//		int i=0;
//		String nameOfProduct="";
//		//Áo thun no style
//		String link=linkInput;
//		Document doc= Jsoup.connect(link).timeout(10000).get();
//		//lay so luong trang
//		Element page=doc.select("ul[class=pagination]").get(0);
//		int soLuongTrang=Integer.parseInt(page.getElementsByTag("a").get(4).ownText());
//				
//		//lap qua tat ca cac trang
//		for(int j=1;j<=soLuongTrang;j++){
//		String linkTungTrang=linkInput.substring(0,linkInput.length()-3)+"page="+j+"&s=1";
//		if(j==1){
//			linkTungTrang=linkInput;
//		}
//		String linkImage="";
//		Document docTungTrang= Jsoup.connect(linkTungTrang).timeout(20000).get();
//		//di vao tung san pham roi lay thong tin ra
//			for(int x=0;x<docTungTrang.select("div[class=pitem]").size();x++,i++){
//				
//				Product product=new Product();
//				
//				String id=idGoc;
//				String diaChiWeb="https://yame.vn";
//				String pageInside=docTungTrang.select("div[class=pitem]").get(x).getElementsByTag("a").get(0).attr("href");//link toi trang tiep theo
//				diaChiWeb+=pageInside;//Lay full duong dan
//				Document docInside= Jsoup.connect(diaChiWeb).timeout(20000).get();
//				
//				nameOfProduct=docInside.select("div[class=ditem]").first().getElementsByTag("h4").first().ownText();
//				System.out.println("ao so "+i+" : "+nameOfProduct);
//				if(checkExist(productList,nameOfProduct)==false){
//					System.out.println("Shuyt");
//					i--;
//				}
//				else if(checkExist(productList,nameOfProduct)==true){
//				product.setName(nameOfProduct);
//				
//				int randomNum=randomGiaTri(50000,0);
//				product.setId(idGoc+xuLySoThuTu(i));
//				product.setIn_price(""+(Integer.parseInt(processCostString(docInside.select("div[class=ditem]").first().getElementsByTag("h5").first().ownText()))-randomNum));
//				product.setOut_price(processCostString(docInside.select("div[class=ditem]").first().getElementsByTag("h5").first().ownText()));
//				product.setIn_stock("true");
//				product.setDescription(docInside.getElementsByClass("col-md-4").get(2).ownText());
//				
//				for(int k=0;k<docInside.select("div[class=vitem]").size();k++){
//					if(docInside.select("div[class=vitem]").get(k).getElementsByTag("p").size()!=0){
//						String mauSac=docInside.select("div[class=vitem]").get(k).getElementsByTag("p").first().ownText();
//						product.transferColorForSize(mauSac);
//						System.out.println("+++++"+mauSac);
//						mauSac=unAccent(mauSac);
//						String maMau=layMaMau(mauSac);
//						
//						
//						linkImage=docInside.select("div[class=vitem]").get(k).getElementsByTag("img").first().attr("src").substring(
//									0,timKiTu(docInside.select("div[class=vitem]").get(k).getElementsByTag("img").first().attr("src"),'?'));
//						//tai hinh
//						System.out.println(linkImage);
//						//Luu hinh
//						String destinationFile = duongDan+product.getId()+"_"+maMau+".jpg";
//						saveImage(linkImage, destinationFile);
//						}	
//					}
//					productList.add(product);
//				}
//			}
//		}
//	}
//	
//	static void writeFile(ArrayList<Product>p,String duongDan) throws TransformerException, ParserConfigurationException{
//
//		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder=factory.newDocumentBuilder();	
//		//Ghi file	
//		org.w3c.dom.Document document2=builder.newDocument();
//		org.w3c.dom.Element product_list = document2.createElement("product_list");
//		document2.appendChild(product_list);
//		
//		for(int i=0;i<p.size();i++){//amount of product
//			org.w3c.dom.Element product = document2.createElement("product");
//			//Thuoc tinh the product
//			product.setAttribute("id", p.get(i).getId());
//			product.setAttribute("in_price", p.get(i).getIn_price());
//			product.setAttribute("out_price", p.get(i).getOut_price());
//			product.setAttribute("inventory_num", String.valueOf(p.get(i).getInventory_num()));
//			product.setAttribute("in_stock", p.get(i).getIn_stock());
//			product.setAttribute("name", p.get(i).getName());
//			//description
//			org.w3c.dom.Element description=document2.createElement("description");
//			description.setTextContent(p.get(i).getDescription());
//			product.appendChild(description);
//			
//			for(int j=0;j<4;j++){//amount of list size
//				//tag size
//				org.w3c.dom.Element size=document2.createElement("size");
//				size.setAttribute("id",p.get(i).getSize().get(j).getId());
//				size.setAttribute("inventory_num",String.valueOf(p.get(i).getSize().get(j).getInventory_num()));
//				//product.appendChild(size);
//				
//				for(int k=0;k<p.get(i).getSize().get(j).getColor().size();k++){//amount of list color 
//					//tag color
//					org.w3c.dom.Element color=document2.createElement("color");
//					color.setAttribute("id",p.get(i).getSize().get(j).getColor().get(k).getId());
//					color.setAttribute("name", p.get(i).getSize().get(j).getColor().get(k).getName());
//					color.setAttribute("inventory_num", String.valueOf(p.get(i).getSize().get(j).getColor().get(k).getInventory_num()));
//					
//					for(int l=0;l<p.get(i).getSize().get(j).getColor().get(k).getShop().size();l++){//amount of list shop
//						org.w3c.dom.Element shop=document2.createElement("shop");
//						shop.setAttribute("id",p.get(i).getSize().get(j).getColor().get(k).getShop().get(l).getId());
//						shop.setAttribute("inventory_num", String.valueOf(p.get(i).getSize().get(j).getColor().get(k)
//																				.getShop().get(l).getInventory_num()));
//						color.appendChild(shop);
//					}
//					size.appendChild(color);
//				}
//				product.appendChild(size);
//			}
//			product_list.appendChild(product);
//		}
//		
//		//write the content into xml file
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer=transformerFactory.newTransformer();
//		DOMSource domSource = new DOMSource(document2);
//		StreamResult result=new StreamResult(new File(duongDan));
//		transformer.transform(domSource, result);
//
//	}
//	static void printTest(ArrayList<Product>p){
//		for(int i=0;i<p.size();i++){
//			System.out.println("------"+p.get(i).getName());
//		}
//	}
//	static boolean checkExist(ArrayList<Product>p,String nameOfProduct){
//		String temp_1=nameOfProduct.replaceAll(" ", "");
//		String temp_2="";
//		for(int i=0;i<p.size();i++){
//			temp_2=p.get(i).getName().replaceAll(" ", "");
//			if(temp_1.equals(temp_2)==true){
//				return false;
//			}
//		}
//		return true;
//	}
//	static int timKiTu(String input,char search){
//		for(int i=0;i<input.length();i++){
//			if(input.charAt(i)==search){
//				return i;
//			}
//		}
//		return 0;
//	}
//	static String xuLySoThuTu(int stt){
//		if(stt<10){
//			return "000"+stt;
//		}
//		else if(stt>=10&&stt<100){
//			return "00"+stt;
//		}
//		else if(stt>=100&&stt<1000){
//			return "0"+stt;
//		}
//		return ""+stt;
//	}
//	
//	static int randomGiaTri(int max,int min){
//		Random rn = new Random();
//        int range = max - min + 1;
//        int randomNum = 0 + rn.nextInt(range);
//        return randomNum;
//	}
//	static String processCostString(String cost){
//		cost=cost.substring(2);
//		String result="";
//		for(int i=0;i<cost.length();i++){
//			if(cost.charAt(i)!=','){
//				result+=cost.charAt(i);
//			}
//		}
//		return result;
//	}
//	static String layMaMau(String cost){
//		String result="";
//		for(int i=0;i<cost.length();i++){
//			if(cost.charAt(i)>='A'&&cost.charAt(i)<='Z'){
//				result+=cost.charAt(i);
//			}
//		}
//		return result;
//	}
//	static String layMaSize(String cost){
//		String result="";
//		for(int i=0;i<cost.length();i++){
//			if(cost.charAt(i)==','){
//				for(int j=i+1;j<cost.length();j++){
//					if(cost.charAt(j)>='A'&&cost.charAt(j)<='Z'){
//						result+=cost.charAt(j);
//					}
//				}
//			}
//		}
//		return result;
//	}
//	//luu hinh
//
//	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
//		URL url = new URL(imageUrl);
//		InputStream is = url.openStream();
//		OutputStream os = new FileOutputStream(destinationFile);
//
//		byte[] b = new byte[2048];
//		int length;
//
//		while ((length = is.read(b)) != -1) {
//			os.write(b, 0, length);
//		}
//
//		is.close();
//		os.close();
//	}
//	
//}
