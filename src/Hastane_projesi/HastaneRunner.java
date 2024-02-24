package Hastane_projesi;

import static Hastane_projesi.StaticMethods.doktorUnvan;

public class HastaneRunner {
    private static Hastane hastane1 = new Hastane();
    public static void main(String[] args) {
        String hastaDurumu = "migren"; // Burada hasta durumunuza göre bir değer atayın
        String unvan = doktorUnvan(hastaDurumu);
        System.out.println("Doktorunuzun unvanı: " + unvan);

        System.out.println(VeriBankasi.durumlar);


        VeriBankasi.searchDoctorByName("Nilson");
        VeriBankasi.searchPatientByName("Hasan");
        VeriBankasi.hospitalStatistics();
        VeriBankasi.addDoctor("Emre", "Sani", "Kardiyolog");






    }


 //  public static Doktor doktorBul(String unvan){
 //       VeriBankasi veriBankasi = new VeriBankasi();
 //       Doktor doktor = new Doktor();
 //      for (int i = 0; i < ; i++) {
//
 //      }
//
 //   }





//
 //   public static Durum hastaDurumuBul(String aktuelDurum){
 //   return
 //   }
//
 //   public static Hasta hastaBul(String actualCase){
 //   return
//
 //   }



}
