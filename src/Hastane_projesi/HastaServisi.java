package Hastane_projesi;

import java.io.IOException;

import static Hastane_projesi.HastaneService.scan;
import static Hastane_projesi.HastaneService.slowPrint;

public class HastaServisi implements Service {
    HastaneService hastaneServisi = new HastaneService();

    Hastane hastaneHasta = new Hastane();

    public void hastaGirisiMenu() throws InterruptedException, IOException {

        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTORLARI LİSTELE\n\t=> 2-DOKTOR BUL\n\t" +
                    "=> 3-DURUMUNU OGREN\n\t=>4-RANDEVU AL\n\t=> 0-ANA MENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    doktorlariListele();
                    break;
                case 2:
                    unvandanDoktorBul();
                    Thread.sleep(3000);
                    break;
                case 3:
                    System.out.println("DURUMUNUZU ÖĞRENMEK İÇİN HASTALIĞINIZI GİRİNİZ...");
                    String durum = scan.nextLine().trim();
                    System.out.println(hastaDurumuBul(durum));
                    break;
                case 4:
                    // randevu al
                    break;
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                    hastaneServisi.start();
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);
    }

    @Override
    public void addPatient() {
        scan.nextLine();
        System.out.println("Eklemek istediginiz hastanin ADINI giriniz");
        String hastaAdi = scan.nextLine();
        System.out.println("Eklemek istediginiz hastanin SOYADINI giriniz");
        String hastaSoyadi = scan.nextLine();
        //      scan.nextLine();
        int hastaId = hastaListesi.getLast().getHastaID() + 111;
        String  durum;
        boolean aciliyet;

        do {
            System.out.println("Hastanin Durumu:\n\t=> Allerji\n\t=> Bas agrisi\n\t=> Diabet\n\t=> Soguk alginligi\n\t=> Migren\n\t" +
                    "=> Kalp hastaliklari");
            durum = scan.nextLine().toLowerCase();


        } while (hastaDurumuBul(durum).getAktuelDurum().equalsIgnoreCase("Yanlis Durum"));
        aciliyet = hastaDurumuBul(durum).isAciliyet();
        Durum hastaDurum = new Durum(durum, aciliyet);
        Hasta hasta = new Hasta(hastaAdi, hastaSoyadi, hastaId, hastaDurum);
        hastaListesi.add(hasta);
        hastaDurumListesi.add(hastaDurum);
        hastaListele();

    }
    }
    @Override
    public void removePatient() {
        hastaListele();
        boolean sildiMi = false;
        System.out.println("Silmek Istediginiz Hastanin Id sini giriniz.");
        int hastaId = 0;
        try {
            scan.nextLine();
            hastaId = scan.nextInt();

        } catch (Exception e) {
            System.out.println("GECERSİZ ID");
            remove();
        }
        for (Hasta w : hastaListesi) {
            if (w.getHastaID() == hastaId) {
                sildiMi = true;
                hastaListesi.remove(w);
                break;
            }
        }
        if (!sildiMi) {
            System.out.println("SİLMEK İSTEDİGİNİZ HASTA LİSTEMİZDE BULUNMAMAKTADIR!");
        }
        hastaListele();

    }

    @Override
    public void searchPatient() {

    }

    @Override
    public void listPatients() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("----------------------- HASTANEDE BULUNAN HASTALARIMIZ --------------------");
        System.out.printf("%-10s | %-10s | %-15s | %-20s\n", "HASTA ID", "HASTA ISIM", "HASTA SOYISIM", "HASTA DURUM");
        System.out.println("---------------------------------------------------------------------------");
        for (Hasta w : hastaListesi) {
            System.out.printf("%-10s | %-10s | %-15s | %-20s\n", w.getHastaID(), w.getIsim(), w.getSoyIsim(), w.getHastaDurumu(), w.getHastaDurumu().isAciliyet());
        }
        System.out.println("---------------------------------------------------------------------------");

    }

    public void durumdanHastalariListele(String aktuelDurum){
        for (Hasta w : hastaListesi) {
            if(w.getHastaDurumu().getAktuelDurum().equalsIgnoreCase(aktuelDurum)){
                System.out.printf("%-10s | %-10s | %-15s | %-20s\n", w.getHastaID(), w.getIsim(), w.getSoyisim(), w.getHastaDurumu(), w.getHastaDurumu().isAciliyet());
            }
        }
    }

    public void firstListHasta() {
        for (String w : hastaneHasta.durumlar) {
            hastaListesi.add(hastaBul(w));
            hastaDurumListesi.add(hastaDurumuBul(w.toLowerCase()));
        }
    }
}
