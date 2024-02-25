package Hastane_projesi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Hastane_projesi.StaticMethods.*;

public class HastaneRunner {
    private static Hastane hastane1 = new Hastane();

    public static void main(String[] args) {

        VeriBankasi.addDoctor("Emre", "Sani", "Allergist");
        VeriBankasi.addPatient("Said", "Patlar", "Allerji", 9999);
        VeriBankasi.addPatient("Mali", "Soylu", "Allerji", 10000);

        Scanner scan = new Scanner(System.in);
        String durum = hastayaDurumunuSor(scan);
        String doktorUnvan = doktorUnvan(durum);

       hastane1.setHasta(hastaBul(durum));
       System.out.println(hastane1.getHasta());

       Doktor doktor1 = doktorBul(doktorUnvan);
       hastane1.setDoktor(doktor1);
       System.out.println("burayı oku" + hastane1.getDoktor());

 //      hastane1.setDoktor(doktorBul(doktorUnvan));
 //      System.out.println(hastane1.getDoktor());
        List<Doktor> doktorlarListesi = doktorlariBul(doktorUnvan);
        if (!doktorlarListesi.isEmpty()) {
            System.out.println("Alanında uzman doktorlar:");
            for (Doktor doktor : doktorlarListesi) {
                System.out.println(doktor);
            }
        } else {
            System.out.println("Belirtilen unvan için doktor bulunamadı.");
        }

     Hasta hasta1 = hastaBul(durum);
        System.out.println("Ben hasta1 " + hasta1);







      //  hastane1.setDoktor(doktorBul(doktorUnvan(durum)));
     //   System.out.println(hastane1.getDoktor(doktorBul(doktorUnvan(durum))));

      //  System.out.println(hastane1.getHasta(hastaBul(String.valueOf(scan))));


     //   hastane1.setHasta();
        //   Durum hastaDurumu = hastaDurumuBul(durum);

      //  System.out.println(doktor1);
     //   System.out.println(hastaBul(durum));

        scan.close();

    //    VeriBankasi.addDoctor("Emre", "Sani", "genel cerrah");

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
