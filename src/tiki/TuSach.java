package tiki;

import java.util.ArrayList;

public class TuSach {

	private ArrayList<Book> listBook = new ArrayList<Book>();
	private String idChu;
	private String diemDanhGia;
	
	public TuSach(String idChu, String diemDanhGia) {
		super();
		this.idChu = idChu;
		this.diemDanhGia = diemDanhGia;
	}

	public ArrayList<Book> getListBook() {
		return listBook;
	}

	public void setListBook(ArrayList<Book> listBook) {
		this.listBook = listBook;
	}

	public String getIdChu() {
		return idChu;
	}

	public void setIdChu(String idChu) {
		this.idChu = idChu;
	}

	public String getDiemDanhGia() {
		return diemDanhGia;
	}

	public void setDiemDanhGia(String diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}
	
	public void addBookToList(Book book){
		listBook.add(book);
	}
	public Book getABook(int pos){
		return listBook.get(pos);
	}
}
