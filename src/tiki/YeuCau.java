package tiki;

public class YeuCau {

	private String idYeuCau;
	private String idUserMuon;
	private String idSach;
	private String ngayMuon;
	private String ngayTra;
	public String getIdYeuCau() {
		return idYeuCau;
	}
	public void setIdYeuCau(String idYeuCau) {
		this.idYeuCau = idYeuCau;
	}
	public String getIdUserMuon() {
		return idUserMuon;
	}
	public void setIdUserMuon(String idUserMuon) {
		this.idUserMuon = idUserMuon;
	}
	public String getIdSach() {
		return idSach;
	}
	public void setIdSach(String idSach) {
		this.idSach = idSach;
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
	public YeuCau(String idYeuCau, String idUserMuon, String idSach, String ngayMuon, String ngayTra) {
		super();
		this.idYeuCau = idYeuCau;
		this.idUserMuon = idUserMuon;
		this.idSach = idSach;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
	}
	
	
}
