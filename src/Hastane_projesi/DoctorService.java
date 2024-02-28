package Hastane_projesi;

import java.util.LinkedList;
import java.util.Scanner;

import static Hastane_projesi.HastaneService.scan;
import static Hastane_projesi.HastaneService.slowPrint;

public class DoctorService implements Service {

    private static Hastane hastane = new Hastane();
    LinkedList<Doktor> doktorList = new LinkedList<>();

    @Override
    public void menu() {
        int secim = -1;
        while (secim != 0) {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTOR EKLE\n\t=> 2-DOKTORLARI LISTELE\n\t" +
                    "=> 3-UNVANDAN DOKTOR BULMA\n\t=> 4-DOKTOR SIL\n\t=> 0-ANAMENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!");
                continue;
            }
            switch (secim) {
                case 1:
                    add();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    remove();
                    break;
                case 0:
                    slowPrint("ANA MENUYE YONLENİDİRİLİYORSUNUZ....\n", 20);
                    break;
                default:
                    System.out.println("HATALI GIRIS, TEKRAR DENEYINIZ!");

            }

        }

    }

    @Override
    public void add() {
        // Doktor Ekleme Metodu
        System.out.println("Eklemek istediginiz doktor ismini giriniz");
        String doktorAdi = scan.next();
        System.out.println("Eklemek istediginiz doktor soy ismini giriniz");
        String doktorSoyadi = scan.next();
        System.out.println("Eklemek İstediginiz doktor Unvanini Giriniz: \n \t=> Allergist\n\t=> Norolog\n\t=> Genel Cerrah\n\t" +
                "=> Cocuk Doktoru\n\t=> Dahiliye\n\t=> Kardiolog");
        String doktorUnvan = scan.next();
        Doktor doktor = new Doktor(doktorAdi, doktorSoyadi, doktorUnvan);
        doktorList.add(doktor);
        list();
        // Doktor objesini isterseniz bir listeye ekleyebilir veya başka bir şekilde saklayabiliriz

    }


    @Override
    public void remove() {
        list();
        Scanner scan = new Scanner(System.in);
        System.out.println("Silmek istediginiz doktor ismini giriniz");
        String doktorName = scan.next();
        System.out.println("Silmek istediginiz doktor soyadini giriniz");
        String doktorSurname = scan.next();
        System.out.println(doktorList);

        boolean isDeleted = false;
        for (Doktor w : doktorList) {
            if (w.getIsim().equalsIgnoreCase(doktorName) && w.getSoyIsim().equalsIgnoreCase(doktorSurname)) {
                doktorList.remove(w);
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("SİLMEK İSTEDİGİNİZ DOKTOR LİSTEMİZDE BULUNMAMAKTADIR");
        }
        list();
    }


    @Override
    public void search() {
        System.out.println("Bulmak Istediginiz Doktorun Unvanini Giriniz:\n\t=> Allergist\n\t=> Norolog\n\t" +
                "=> Genel Cerrah\n\t=> Cocuk Doktoru\n\t=> Dahiliye Uzmanı\n\t=> Kardiolog");
        scan.nextLine();
        String unvan = scan.nextLine();

        System.out.println("------------------------------------------------------");
        System.out.println("---------- HASTANEDE BULUNAN DOKTORLARİMİZ -----------");
        System.out.printf("%-13s | %-15s | %-15s\n", "DOKTOR İSİM", "DOKTOR SOYİSİM", "DOKTOR UNVAN");
        System.out.println("------------------------------------------------------");
        boolean varMi = false;

        for (Doktor w : doktorList) {
            if (w.getUnvan().equalsIgnoreCase(unvan)) {
                System.out.printf("%-13s | %-15s | %-15s\n", w.getIsim(), w.getSoyIsim(), w.getUnvan());
                varMi = true;
            }
        }
        if (!varMi) {
            System.out.println("BU UNVANA AİT DOKTOR BULUNMAMAKTADIR");
            slowPrint("\033[39mANAMENU'YE YONLENDIRILIYORSUNUZ...\033[0m\n", 20);
        }
            System.out.println("------------------------------------------------------");

        }


        @Override
        public void list () {
            System.out.println("------------------------------------------------------");
            System.out.println("---------- HASTANEDE BULUNAN DOKTORLARİMİZ -----------");
            System.out.printf("%-13s | %-15s | %-15s\n", "DOKTOR İSİM", "DOKTOR SOYİSİM", "DOKTOR UNVAN");
            System.out.println("------------------------------------------------------");
            for (Doktor w : doktorList) {
                System.out.printf("%-13s | %-15s | %-15s\n", w.getIsim(), w.getSoyIsim(), w.getUnvan());


            }


        }

        public Doktor doktorBul (String unvan){
            Doktor doktor = new Doktor();
            for (int i = 0; i < hastane.unvanlar.size(); i++) {
                if (hastane.unvanlar.get(i).equals(unvan)) {
                    doktor.setIsim(hastane.doctorIsimleri.get(i));
                    doktor.setSoyIsim(hastane.doctorSoyIsimleri.get(i));
                    doktor.setUnvan(hastane.unvanlar.get(i));
                    break;

                }
            }
            return doktor;
        }
        public void firstList () {
            for (String w : hastane.unvanlar) {
                doktorList.add(doktorBul(w));
            }
        }
    }
