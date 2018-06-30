package UpGrade;
import java.io.File;
import java.io.IOException;

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

public class NapAllFile {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		Document document[]={builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_khoac\\adachi\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_khoac\\kirimaru\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_khoac\\ma_bu\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_khoac\\no_style\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_so_mi\\adachi\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_so_mi\\kirimaru\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_so_mi\\ma_bu\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_so_mi\\no_style\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_thun\\adachi\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_thun\\kirimaru\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_thun\\ma_bu\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\ao_thun\\no_style\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\balo\\balo\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\dep_sandal\\adachi\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\dep_sandal\\nam\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\dep_sandal\\sandal\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\giay_nam\\adachi\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\giay_nam\\giay_da\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\giay_nam\\giay_thoi_trang\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\giay_nu\\giay_nu\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\phu_kien\\day_nit\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\phu_kien\\kinh\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\phu_kien\\non\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\phu_kien\\vi_da\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_dai\\adachi\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_dai\\kirimaru\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_dai\\ma_bu\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_dai\\no_style\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_dai\\quan_tay\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_short\\adachi\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_short\\kirimaru\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_short\\ma_bu\\xml\\product_list.xml")),
		builder.parse(new File("C:\\Users\\Tran Manh Chung\\Desktop\\Đồ án xml\\yameshop\\server_service\\data\\product\\quan_short\\no_style\\xml\\product_list.xml"))
		};
		
		int id=0;
		Document document2=builder.newDocument();
		Element product_list = document2.createElement("product_list");
		document2.appendChild(product_list);
		
		for(int i=0;i<33;i++){
			//lay node root
			Element rootNode = document[i].getDocumentElement();
			
			for(int j=0;j<rootNode.getElementsByTagName("product").getLength();j++){
				Element product=document2.createElement("product");
				product.setAttribute("id", rootNode.getElementsByTagName("product").item(j).getAttributes().getNamedItem("id").getNodeValue());
				product.setAttribute("in_price",rootNode.getElementsByTagName("product").item(j).getAttributes().getNamedItem("in_price").getNodeValue());
				product.setAttribute("out_price", rootNode.getElementsByTagName("product").item(j).getAttributes().getNamedItem("out_price").getNodeValue());
				
				product_list.appendChild(product);
			}
					
		}
		
		//write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document2);
		StreamResult result=new StreamResult(new File("D:\\text1.xml"));
		transformer.transform(domSource, result);
		
		System.out.println("done");
	} 

}
