package tiki;

public class Book {
	private String idChu;
	private String idSach;
	private String tenSach;
	private String tacGia;
	private String NXB;
	private String tinhTrang;
	private String soLuong;
	private String link;
	
	public Book(String idChu, String idSach, String tenSach, String tacGia, String nXB, String tinhTrang,
			String soLuong, String link) {
		super();
		this.idChu = idChu;
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		NXB = nXB;
		this.tinhTrang = tinhTrang;
		this.soLuong = soLuong;
		this.link = link;
	}
	public String getIdChu() {
		return idChu;
	}
	public void setIdChu(String idChu) {
		this.idChu = idChu;
	}
	public String getIdSach() {
		return idSach;
	}
	public void setIdSach(String idSach) {
		this.idSach = idSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNXB() {
		return NXB;
	}
	public void setNXB(String nXB) {
		NXB = nXB;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
}
