//Fikri Hashfi N_M0516021
package mencariJalan;

import java.util.ArrayList;
import java.util.Scanner;

public class FindTheWay {
	Scanner input = new Scanner(System.in);
	public ArrayList<Kota> city = new ArrayList<Kota>();
	public ArrayList<String> jalan = new ArrayList<String>();
	public ArrayList<Integer> jarak = new ArrayList<Integer>();
	public ArrayList<String> jalanTersimpan = new ArrayList<String>();
	public ArrayList<Integer> jarakTersimpan = new ArrayList<Integer>();
	public int Awal, Akhir;
	
	public static void main(String[] args) {
		
		FindTheWay f = new FindTheWay();	
		f.city.add(new Kota("A")); f.city.add(new Kota("B")); f.city.add(new Kota("C"));
		f.city.add(new Kota("D")); f.city.add(new Kota("E")); f.city.add(new Kota("F"));
		f.city.add(new Kota("G")); f.city.add(new Kota("H")); f.city.add(new Kota("I"));
		f.city.add(new Kota("J")); f.city.add(new Kota("K"));
		f.city.add(new Kota("L")); f.city.add(new Kota("M"));
		f.city.add(new Kota("N")); f.city.add(new Kota("O"));
		f.city.add(new Kota("P")); f.city.add(new Kota("Q"));
		f.city.add(new Kota("R")); f.city.add(new Kota("S"));
		f.city.get(0).setJarak(4, "B"); //A KE-
		f.city.get(1).setJarak(4, "A"); //B KE-
		f.city.get(1).setJarak(5, "C");
		f.city.get(2).setJarak(5, "B"); //C KE-
		f.city.get(2).setJarak(6, "D");
		f.city.get(2).setJarak(8, "F");
		f.city.get(3).setJarak(6, "C"); //D KE-
		f.city.get(3).setJarak(7, "E");
		f.city.get(4).setJarak(7, "D"); //E KE-
		f.city.get(5).setJarak(8, "C"); //F KE-
		f.city.get(5).setJarak(9, "G");
		f.city.get(5).setJarak(10, "H");
		f.city.get(5).setJarak(11, "L");
		f.city.get(6).setJarak(9, "F"); //G KE-
		f.city.get(7).setJarak(10, "F"); // H KE-
		f.city.get(7).setJarak(12, "J");
		f.city.get(8).setJarak(13, "J"); //I KE -
		f.city.get(8).setJarak(15, "M");
		f.city.get(9).setJarak(12, "H"); //J KE -
		f.city.get(9).setJarak(13, "I");
		f.city.get(9).setJarak(16, "N");
		f.city.get(9).setJarak(17, "K");
		f.city.get(10).setJarak(17, "J"); //K KE-
		f.city.get(10).setJarak(18, "L");
		f.city.get(10).setJarak(19, "S");
		f.city.get(11).setJarak(18, "K"); // L KE-
		f.city.get(11).setJarak(11, "F");
		f.city.get(11).setJarak(26, "S");
		f.city.get(12).setJarak(15, "I"); // M KE-
		f.city.get(12).setJarak(20, "N");
		f.city.get(13).setJarak(20, "M"); // N KE -
		f.city.get(13).setJarak(16, "J");
		f.city.get(13).setJarak(21, "O");
		f.city.get(14).setJarak(22, "P"); // O KE -
		f.city.get(14).setJarak(21, "N");
		f.city.get(15).setJarak(22, "O"); // P KE -
		f.city.get(15).setJarak(23, "Q");
		f.city.get(16).setJarak(23, "P"); // Q KE -
		f.city.get(16).setJarak(24, "R");
		f.city.get(17).setJarak(24, "Q"); // R KE -
		f.city.get(17).setJarak(25, "S");
		f.city.get(18).setJarak(19, "K"); // S KE -
		f.city.get(18).setJarak(26, "L");
		f.city.get(18).setJarak(25, "R");
		
		System.out.print("==================================================\n");
		System.out.println("||  List Kota   ||  Kota Tujuan ||     Jarak    ||");
		System.out.print("==================================================\n");
		for(int x=0 ; x<f.city.size();x++) {
			for(int y=0; y<f.city.get(x).getListJarak().size(); y++) {
				
				if(y>0)
					System.out.println("||\t\t|| "+ f.city.get(x).getKotaTujuan(y) +"\t\t|| "+ f.city.get(x).getJarak(y) +" Km \t||");
				else
					System.out.println("|| "+f.city.get(x).getNama() +"\t\t|| "+ f.city.get(x).getKotaTujuan(y) +"\t\t|| "+ f.city.get(x).getJarak(y) +" Km \t||");
			}
		}
		
		System.out.print("==================================================\n");	
	
		f.findTheWay();
		
		System.out.print("=======JALAN======\n");
		f.theWay(f.Awal, f.Akhir);
		
		for(int b=0; b<f.jalan.size(); b++) {
			System.out.println((b+1)+". "+f.jalan.get(b) + f.jarak.get(b));
		}
	}
	
	public void theWay(int Awal, int Akhir) {	
		jalanTersimpan.add(city.get(Awal).getNama());
		for(int a=0; a<city.get(Awal).getListJarak().size(); a++) {
			
			if(!checkKotaTersimpan(city.get(Awal).getListJarak().get(a).getKotaTujuan())) {
				if(checkKotaSelanjutnya(city.get(Awal).getListJarak().get(a).getKotaTujuan())==Akhir) {
					jalanTersimpan.add(city.get(Awal).getListJarak().get(a).getKotaTujuan());
					jarakTersimpan.add(city.get(Awal).getListJarak().get(a).getJarak());
					jarak.add(jarak());
					jalan.add(jalan());
				}
				else {
					jarakTersimpan.add(city.get(Awal).getListJarak().get(a).getJarak());
					theWay(checkKotaSelanjutnya(city.get(Awal).getListJarak().get(a).getKotaTujuan()), Akhir);
				}
				jarakTersimpan.remove(jarakTersimpan.size()-1);
				jalanTersimpan.remove(jalanTersimpan.size()-1);
			}

		}
	}
	
	int jarak() {
		int jarak = 0;
		for(int a=0; a<jarakTersimpan.size(); a++) {
			jarak += jarakTersimpan.get(a);
		}
	return jarak;
	}

	String jalan() {
		String jalan = "";
			for(int a=0; a<jalanTersimpan.size(); a++) {
				jalan += jalanTersimpan.get(a) + " - ";
			}
		return jalan;
	}
	
	boolean checkKotaTersimpan(String kota) {
		for(int a=0; a<jalanTersimpan.size(); a++){
			if(jalanTersimpan.get(a).matches(kota)){
				return true;
			}
		}
	return false;
	}	

	int checkKotaSelanjutnya(String kotaSelanjutnya) {
		int temp = -1;
			for(int a=0; a<city.size(); a++){
				if(kotaSelanjutnya.toLowerCase().matches(city.get(a).getNama().toLowerCase())) {
					return a;
				}
			}
		return temp;
	}
	
	
	boolean checkTheCity(String kotaTujuan, String kotaAwal) {
		int x=0;
		for(int a=0; a<city.size(); a++){
			if(kotaTujuan.toLowerCase().matches(city.get(a).getNama().toLowerCase())) {
				x++;
				this.Akhir = a;
			}
			if(kotaAwal.toLowerCase().matches(city.get(a).getNama().toLowerCase())) {
				x++;
				this.Awal = a;
			}
		}
			if(x==2)
				return true;
	
		return false;
	}
	
	
	public void findTheWay() {
		System.out.print("Kota Awal = ");
		String kotaAwal = input.next();
		System.out.print("\nKota Tujuan = ");
		String kotaTujuan = input.next();
			if(checkTheCity(kotaTujuan, kotaAwal)) 
				System.out.println("Kota ditemukan");
			else 
				System.out.println("Kota tidak ditemukan");
				
	}

}
