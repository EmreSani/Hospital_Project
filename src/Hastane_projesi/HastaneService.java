package Hastane_projesi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HastaneService{
    static Scanner scan = new Scanner(System.in);
    private static HastaneService hastane = new HastaneService();
    DoktorServisi doktorservice = new DoktorServisi();
    HastaServisi hastaServisi = new HastaServisi();

    public void showHospitalMenu() {

    }

    public void start() throws InterruptedException, IOException {



    //    Scanner scan = new Scanner(System.in); BELKI EKLE BUNU

     //   slowPrint("\033[34m============== DEV TEAM 02 HASTANESINE HOSGELDİNİZ ================\033[0m\n", 20);
     //   slowPrint("\033[34m================ SAGLIGINIZ BİZİM ICIN ONEMLIDIR ==================\033[0m\n", 20);
        int secim = -1;
do {
    System.out.println("Lütfen giriş yapmak istediğiniz menü kodunu giriniz..\n\n" +
            "1-HASTANE YÖNETİMİ GİRİŞİ\n" +
            "2-DOKTOR GİRİŞİ\n" +
            "3-HASTA GİRİŞİ\n" +
            "4-HASTANE KADROMUZ\n" +
            "5-ÇIKIŞ\n");
    try {
        secim = scan.nextInt();
    } catch (Exception e) {
        scan.nextLine();
        System.out.println("LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!");
        continue;
    }


    switch (secim) {
        case 1:
            hastane.hastaneServisiMenu();
            break;
        case 2:
            doktorservice.doktorGirisiMenu();
            break;
        case 3:
            hastaServisi.hastaGirisiMenu();
            break;
        case 4:
            iletisim();
            break;
        case 5:
            cikis();
            break;
        default:
            System.out.println("HATALI GIRIS, TEKRAR DENEYINIZ!");
            //


    }

}
}while (secim != 0);

    private void hastaneServisiMenu() throws IOException, InterruptedException {
        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTOR EKLE\n\t=> 2-DOKTORLARI LISTELE\n\t" +
                    "=> 3-UNVANDAN DOKTOR BULMA\n\t=> 4-DOKTOR SIL\n\t=> 5-HASTA EKLE\n\t=> 6-HASTA BUL\n\t=>7-HASTA LISTELE\n\t=> 8-HASTA SIL\n\t=>0-ANAMENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();//dummy
            } catch (Exception e) {
//                scan.nextLine();//dummy
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    doktorservice.addDoctor(); //
                    break;
                case 2:
                    doktorservice.listDoctors();
                    break;
                case 3:
                    doktorservice.unvandanDoktorBul();
                    break;
                case 4:
                    doktorservice.removeDoctor();
                    //
                    break;
                case 5:
                    hastaServisi.addPatient();
                    break;
                case 6:
                    System.out.println("BULMAK İSTEDİĞİNİZ HASTANIN DURUMUNU GİRİNİZ...");
                    String durum = scan.nextLine().trim();
                    //System.out.println(hastaBul(durum));
                    hastaServisi.durumdanHastalariListele(durum);
                    break;
                case 7:
                    hastaServisi.listPatients();
                    break;
                case 8:
                    hastaServisi.removePatient();
                    break;
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                    start();
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);
    }




    public void iletisim() throws IOException, InterruptedException {
        Files.lines(Paths.get("src/Hastane_projesi/Yonetim.txt")).forEach(System.out::println);

        start();
    }

    public static void cikis() {
        System.out.println("Hastanemizi tercih ettiğiniz için teşekkürler. \n\t"+"*".repeat(10)+" SAĞLICAKLA KALIN "+"*".repeat(10));

    }

    public static void slowPrint(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
