package Hastane_projesi;

import java.util.Arrays;
import java.util.Scanner;

import static Hastane_projesi.StaticMethods.*;

public class HastaneRunner {
    private static Hastane hastane1 = new Hastane();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String durum = hastayaDurumunuSor(scan);
        Doktor doktor = doktorBul(doktorUnvan(scan));
        //   Durum hastaDurumu = hastaDurumuBul(durum);

        System.out.println(doktor);
        System.out.println(hastaBul(durum));

        scan.close();

        VeriBankasi.addDoctor("Emre", "Sani", "genel cerrah");

        //  String unvan = doktorUnvan(hastaDurumu);
        //   System.out.println("Doktorunuzun unvanı: " + unvan);

        // Doktor bulunanDoktor=doktorBul(unvan);
        //     System.out.println(bulunanDoktor);

        // System.out.println(hastaDurumuBul("allerji"));

        //    hastane1.setDoktor(doktorBul(unvan));
        //     System.out.println(hastane1.getDoktor(doktorBul(unvan)));
        //hastane1.setHasta(hastaBul(hastaDurumu));
        //System.out.println(hastane1.getHasta());


        // System.out.println(VeriBankasi.durumlar);


        //  VeriBankasi.searchDoctorByName("Nilson");
        //  VeriBankasi.addDoctor("Emre", "Sani", "Kardiyolog");
        // VeriBankasi.hospitalStatistics();
        //  System.out.println(hastane1.hasta.getIsim());


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
