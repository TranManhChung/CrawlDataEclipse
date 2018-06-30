import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class BillList {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();

		Document document = builder.parse(new File("D:\\text1.xml"));
		
		
		int id=0;
		Document document2=builder.newDocument();
		Element bill_list = document2.createElement("bill_list");
		document2.appendChild(bill_list);
		
		Element rootNode = document.getDocumentElement();		
			
		for(int j=0;j<300;j++){
			Element bill=document2.createElement("bill");
			bill.setAttribute("id", phatSinhId(id));
			bill.setAttribute("staff_id", "Nhan_Vien_"+randomFunction(29,0));
			bill.setAttribute("shop_id",""+randomFunction(29,0));
			bill.setAttribute("date",""+randomFunction(30,1)+"/"+ randomFunction(12,1)+"/2018");
			bill.setAttribute("revenue", "");
			bill.setAttribute("type", getType());
			
			int begin=randomFunction(100,0);
			int end=randomFunction(800,200);
			int total=0;
			for(int i=begin;i<end;i++){
				Element item=document2.createElement("item");
				item.setAttribute("id", rootNode.getElementsByTagName("product").item(i).getAttributes().getNamedItem("id").getNodeValue());
				item.setAttribute("count", String.valueOf(randomFunction(50,1)));
				
				if(bill.getAttribute("type").equals("in")==true){
					total=total+Integer.parseInt(item.getAttribute("count"))*Integer.parseInt(rootNode.getElementsByTagName("product").item(i).getAttributes().getNamedItem("in_price").getNodeValue());
				}
				else{
					total=total+Integer.parseInt(item.getAttribute("count"))*Integer.parseInt(rootNode.getElementsByTagName("product").item(i).getAttributes().getNamedItem("out_price").getNodeValue());
				}
				bill.appendChild(item);
			}
			bill.setAttribute("total", String.valueOf(total));
			bill_list.appendChild(bill);
		}
			
		//write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document2);
		StreamResult result=new StreamResult(new File("D:\\bill_list1.xml"));
		transformer.transform(domSource, result);
		
		System.out.println("done");
	} 

	static String getType(){
	    if(randomFunction(10,0)%2==0){
	    	  return "in";	    	 
	       }
	       return "out";
	}
	
	public static int randomFunction(int max,int min){
		Random rn = new Random();
        int range = max - min + 1;
        int randomNum = 0 + rn.nextInt(range);
        return randomNum;
	}
	public static String phatSinhId(int id){
		String result="00000000";
		return result.substring(0,result.length()-String.valueOf(id).length())+String.valueOf(id);
	}
}
