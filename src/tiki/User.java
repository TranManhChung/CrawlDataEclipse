package tiki;

public class User {

	private String idUser;
	private String tenUser;
	private String ngaySinh;
	private String gioiTinh;
	private String soDienThoai;
	private String email;
	private String password;
	private String avatar;
	public User(String idUser, String tenUser, String ngaySinh, String gioiTinh, String soDienThoai, String email,
			String password, String avatar) {
		super();
		this.idUser = idUser;
		this.tenUser = tenUser;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getTenUser() {
		return tenUser;
	}
	public void setTenUser(String tenUser) {
		this.tenUser = tenUser;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
