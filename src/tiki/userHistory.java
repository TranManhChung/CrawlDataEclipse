package tiki;

public class userHistory {

	private String idUser;
	private String ngayMuon;
	private String ngayTra;
	public userHistory(String idUser, String ngayMuon, String ngayTra) {
		super();
		this.idUser = idUser;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(String ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public String getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}
	
}
