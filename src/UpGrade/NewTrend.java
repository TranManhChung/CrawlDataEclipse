package UpGrade;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;


public class NewTrend {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		Document document = builder.parse(new File("D:\\data.xml"));
		
		//lay node root
		Element rootNode = document.getDocumentElement();
		
		
		Document document2=builder.newDocument();
		Element new_trend_product = document2.createElement("new_trend_product");
		document2.appendChild(new_trend_product);
		
		Element new_product=document2.createElement("new_product");

		for(int i=0;i<rootNode.getElementsByTagName("product").getLength();i++){
			Element item=document2.createElement("item");
			item.setAttribute("id", rootNode.getElementsByTagName("product").item(i).getAttributes().getNamedItem("id").getNodeValue());
			new_product.appendChild(item);
		}
				
		new_trend_product.appendChild(new_product);
		
		
		//write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document2);
		StreamResult result=new StreamResult(new File("D:\\text1.xml"));
		transformer.transform(domSource, result);
		
		System.out.println("done");
	} 

}
