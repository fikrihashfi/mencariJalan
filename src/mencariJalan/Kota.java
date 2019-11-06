package mencariJalan;

import java.util.ArrayList;

public class Kota {
	
	private ArrayList<Jarak> jarak = new ArrayList<>();
	private String Nama;
	
	public Kota(String nama) {
		this.Nama = nama;
	}
	
	public String getNama() {
		return Nama;
	}
	
	public ArrayList<Jarak> getListJarak() {
		return jarak;
	}


	public int getJarak(int a) {
		return jarak.get(a).getJarak();
	}

	public String getKotaTujuan(int a) {
		return jarak.get(a).getKotaTujuan();
	}

	public void setJarak(int Jarak, String kotaTujuan) {
		jarak.add(new Jarak(Jarak, kotaTujuan));
	}

	public void setNama(String nama) {
		Nama = nama;
	}

	
	


}
