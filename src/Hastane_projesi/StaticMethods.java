package Hastane_projesi;

import java.util.Scanner;

public class StaticMethods {

    public static String hastayaDurumunuSor(Scanner scan){
        System.out.println("Lutfen hangi doktordan randevu almaniz gerektigini ogrenmek icin" +
                " sikayetinizi giriniz: Allerji, Bas agrisi, Diabet, Soguk Alginligi, Migren, Kalp hastaliklari");

       String durum = scan.nextLine().trim().toLowerCase();

        while (!isValid(durum)) {
            System.out.println("Geçersiz giriş. Lütfen tekrar deneyiniz.");
            durum = scan.nextLine().trim().toLowerCase();
        }

       return durum;
    }

    private static boolean isValid(String durum) {
        switch (durum.trim().toLowerCase()){
            case "allerji":
            case "baş ağrısı":
            case "diabet":
            case "soğuk algınlığı":
            case "migren":
            case "kalp hastalıkları":
                return true;
            default:
                return false;
        }
    }

    public static String doktorUnvan(Scanner scan) {
        System.out.println("Lutfen hangi alandan randevu almaniz gerektigini ogrenmek icin" +
                " sikayetinizi giriniz: Allerji, Bas agrisi, Diabet, Soguk Alginligi, Migren, Kalp hastaliklari");
        String unvan = scan.nextLine().trim().toLowerCase(scan.locale());
        for (int i = 0; i < VeriBankasi.durumlar.size(); i++) {
            if (unvan.equalsIgnoreCase(VeriBankasi.durumlar.get(i))) {
                unvan = VeriBankasi.unvanlar.get(i);
            }
        }
        return unvan;
    }

    public static Doktor doktorBul(String unvan) {
        Doktor doktor = new Doktor();
        for (int i = 0; i < VeriBankasi.unvanlar.size(); i++) {
            if (VeriBankasi.unvanlar.get(i).equals(unvan)) {
                doktor.setIsim(VeriBankasi.doctorIsimleri.get(i));
                doktor.setSoyIsim(VeriBankasi.doctorSoyIsimleri.get(i));
                doktor.setUnvan(VeriBankasi.unvanlar.get(i));
                break;
            }
        }
        return doktor;
    }
    public static Durum hastaDurumuBul(String aktuelDurum) {
        Durum hastaDurumu = new Durum();
        switch (aktuelDurum.toLowerCase()) {
            case "allerji":
            case "bas agrisi":
            case "diabet":
            case "soguk alginligi":
                hastaDurumu.setAciliyet(false);
                break;
            case "migren":
            case "kalp hastaliklari":
                hastaDurumu.setAciliyet(true);
                break;
            default:
                System.out.println("Gecerli bir durum degil");
                hastaDurumu.setAktuelDurum("Gecerli bir durum degil");

        }
        return hastaDurumu;

    }

    public static Hasta hastaBul(String aktuelDurum) {
        Hasta hasta = new Hasta();
        for (int i = 0; i < VeriBankasi.durumlar.size(); i++) {
            if (VeriBankasi.durumlar.get(i).equalsIgnoreCase(aktuelDurum)) {
                hasta.setIsim(VeriBankasi.hastaIsimleri.get(i));
                hasta.setSoyIsim(VeriBankasi.hastaIsimleri.get(i));
                hasta.setHastaID(VeriBankasi.hastaIDleri.get(i));
                hasta.setHastaDurumu((hastaDurumuBul(aktuelDurum)));
                break;
            }

        }
        return hasta;
    }


}

