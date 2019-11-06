package mencariJalan;

public class Jarak {
	private int jarak;
	private String kotaTujuan;	
	
	public Jarak(int jarak, String kotaTujuan) {
		this.jarak = jarak;
		this.kotaTujuan = kotaTujuan;
	}

	public int getJarak() {
		return jarak;
	}

	public void setJarak(int jarak) {
		this.jarak = jarak;
	}

	public String getKotaTujuan() {
		return kotaTujuan;
	}

	public void setKotaTujuan(String kotaTujuan) {
		this.kotaTujuan = kotaTujuan;
	}
	
	
}
