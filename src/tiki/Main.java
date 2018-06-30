package tiki;

import java.util.ArrayList;

import java.io.IOException;

import java.text.Normalizer;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

	private static ArrayList < TuSach > listTuSach = new ArrayList < TuSach > ();
	private int id = 0;

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		AccessAndGetData("https://tiki.vn/nha-sach-tiki/c8322?src=mega-menu","C:\\Users\\Tran Manh Chung\\Desktop\\Image\\", 50);
		WriteDataDownFile("C:\\Users\\Tran Manh Chung\\Desktop\\data\\ListBookcase.xml","ListBookcase");
		WriteDataDownFile("C:\\Users\\Tran Manh Chung\\Desktop\\data\\ListInfoUser.xml","ListInfoUser");
	}

	static void AccessAndGetData(String linkInput,String duongDan, int soLuongTrang) throws IOException {
		int i = 0;
		String tenSach, idChu, idSach, linkImage, link, nxb, soLuong, donGia, tinhTrang, tacGia;

		Document doc = Jsoup.connect(linkInput).timeout(10000).get();

		//lap qua tat ca cac trang
		for (int j = -1; j < soLuongTrang; j++) {
			int temp =j+2;
			String linkTungTrang = linkInput + "&page=" + temp;
			
			if (j == -1) linkTungTrang = linkInput;

			System.out.println(linkTungTrang);
			idChu = returnIdTypeString(j+1);
			TuSach tuSach = new TuSach(idChu, "0");

			Document docTungTrang = Jsoup.connect(linkTungTrang).timeout(20000).get();
			
			//di vao tung san pham roi lay thong tin ra
			for (int x = 0; x < 24; x++, i++) {
				if (x == 3) x++;

				String pageInside = docTungTrang.select("div[class=product-box-list]").first().getElementsByTag("a").get(x).attr("href"); //link toi trang tiep theo
				Document docInside = Jsoup.connect(pageInside).timeout(20000).get();
//				System.out.println("sach so " + i + " : " + pageInside);
				tenSach = docInside.select("div[class=item-box]").first().getElementsByTag("h1").first().ownText();
				System.out.println("sach so " + i + " : " + tenSach);

				soLuong = String.valueOf(randomValue(10, 0));
				idSach = returnIdTypeString(i);
				nxb = docInside.select("td[class=last]").get(1).ownText();
				if(docInside.select("td[class=last]").size()>4){
					tacGia = docInside.select("td[class=last]").get(3).ownText();//Khong co tac gia
				}else{
					tacGia = "Không xác định";
				}
				
				tinhTrang = "true";
				link = "/999999/" + idSach + ".jpg"; 
				
				linkImage = docInside.select("img[class=product-magiczoom]").first().attr("src");

				//Luu hinh
				String destinationFile = duongDan + idSach + ".jpg";
				saveImage(linkImage, destinationFile);
				
				Book book = new Book(idChu, idSach, tenSach, tacGia, nxb, tinhTrang, soLuong, link);
				tuSach.addBookToList(book);

			}
			listTuSach.add(tuSach);
			System.out.println("-------------------------"+j);
		}
	}
	
	static void WriteDataDownFile(String duongDan,String typeOfFile) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();	
		//Ghi file	
		org.w3c.dom.Document document2=builder.newDocument();
		
		switch(typeOfFile){
		case "ListBookcase":
			document2 = ListBookcase(document2);
			break;
		case "ListInfoUser":
			document2 = ListInfoUser(document2);
			break;
		}
		
		//write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document2);
		StreamResult result=new StreamResult(new File(duongDan));
		transformer.transform(domSource, result);
		
		System.out.println(">>>>>>>>>>DONE<<<<<<<<<<");
	}
	
	static org.w3c.dom.Document ListBookcase(org.w3c.dom.Document document2){
		org.w3c.dom.Element danh_sach_tu_sach = document2.createElement("danh_sach_tu_sach");
		document2.appendChild(danh_sach_tu_sach);
		
		for(int i=0;i<listTuSach.size();i++){//amount of bookcase
			org.w3c.dom.Element tu_sach = document2.createElement("tu_sach");
			//Thuoc tinh the tu_sach
			tu_sach.setAttribute("id_chu", listTuSach.get(i).getIdChu());
			tu_sach.setAttribute("diem_danh_gia", listTuSach.get(i).getDiemDanhGia());
			
				//tag danh_sach_sach
				org.w3c.dom.Element danh_sach_sach=document2.createElement("danh_sach_sach");
				
				for(int k=0;k<listTuSach.get(i).getListBook().size();k++){//amount book of list book
					//tag sach
					org.w3c.dom.Element sach=document2.createElement("sach");
					sach.setAttribute("id_chu",listTuSach.get(i).getListBook().get(k).getIdChu());
					sach.setAttribute("id_sach",listTuSach.get(i).getListBook().get(k).getIdSach());
					sach.setAttribute("ten_sach",listTuSach.get(i).getListBook().get(k).getTenSach());
					sach.setAttribute("tac_gia",listTuSach.get(i).getListBook().get(k).getTacGia());
					sach.setAttribute("ma_ISBN","tamthoichuaco");
					sach.setAttribute("NXB",listTuSach.get(i).getListBook().get(k).getNXB());
					sach.setAttribute("tinh_trang",listTuSach.get(i).getListBook().get(k).getTinhTrang());
					sach.setAttribute("so_luong",listTuSach.get(i).getListBook().get(k).getSoLuong());
					sach.setAttribute("link",listTuSach.get(i).getListBook().get(k).getLink());
					
					danh_sach_sach.appendChild(sach);
				}
				//tag yeu_cau_cho_muon_sach
				org.w3c.dom.Element yeu_cau_cho_muon_sach=document2.createElement("yeu_cau_cho_muon_sach");
				org.w3c.dom.Element yeu_cau_muon_sach=document2.createElement("yeu_cau_muon_sach");
				org.w3c.dom.Element lich_su_cho_muon_sach=document2.createElement("lich_su_cho_muon_sach");
				org.w3c.dom.Element lich_su_muon_sach=document2.createElement("lich_su_muon_sach");
				
				tu_sach.appendChild(danh_sach_sach);
				tu_sach.appendChild(yeu_cau_cho_muon_sach);
				tu_sach.appendChild(yeu_cau_muon_sach);
				tu_sach.appendChild(lich_su_cho_muon_sach);
				tu_sach.appendChild(lich_su_muon_sach);
				danh_sach_tu_sach.appendChild(tu_sach);
		}
		return document2;
	}

	static org.w3c.dom.Document ListInfoUser(org.w3c.dom.Document document2){
		String [] ho =    {"Trần","Từ","Nguyễn","Cao","Lê","Lý","Đỗ","Dương","Trương","Lâm","Phan","Võ"};
		String [] chuLot ={"Văn","Thích","Quốc","Mạnh","Đình","Võ","Phương","Thanh","Thái","Bá","Hồng","Thành"};
		String [] ten =   {"Chung","Chương","Đạt","Sang","Triều","Sa","Nhung","Cẩm","Vấn","Long","Tư","Danh"};
		
		org.w3c.dom.Element danh_sach_user = document2.createElement("danh_sach_user");
		document2.appendChild(danh_sach_user);
		
		for(int i=0;i<listTuSach.size();i++){//amount of bookcase
			org.w3c.dom.Element user = document2.createElement("user");
			//Thuoc tinh the tu_sach
			user.setAttribute("id_user",listTuSach.get(i).getIdChu());
			user.setAttribute("ten_user",ho[randomValue(11,0)]+" "+chuLot[randomValue(11,0)]+" "+ten[randomValue(11,0)]);
			user.setAttribute("ngay_sinh",String.valueOf(randomValue(30,1))+"/"+String.valueOf(randomValue(12,1))+"/"+String.valueOf(randomValue(2005,1980)));
			user.setAttribute("gioi_tinh","Nam");
			user.setAttribute("so_dien_thoai",String.valueOf(randomValue(900000000,0)));
			user.setAttribute("email","user"+i+"@gmail.com");
			user.setAttribute("password","user"+i+"@gmail.com");
			user.setAttribute("avatar","/999999/"+listTuSach.get(i).getIdChu()+".jpg");
				
			danh_sach_user.appendChild(user);
		}
		return document2;
	}
	
	static String returnIdTypeString(int id) {
		String result = "";
		if (String.valueOf(id).length() < 7) {
			for (int i = 0; i < 7 - String.valueOf(id).length(); i++) {
				result += '0';
			}
		}
		return result + String.valueOf(id);
	}

	static int randomValue(int max, int min) {
		Random rn = new Random();
		int range = max - min + 1;
		int randomNum = 0 + rn.nextInt(range);
		return randomNum;
	}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
}