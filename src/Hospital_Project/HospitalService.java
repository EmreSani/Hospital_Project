package Hospital_Project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HospitalService {
    static Scanner scan = new Scanner(System.in);

    public static Hospital hospital = new Hospital();
    public static HospitalService hospitalService = new HospitalService();
    public static DoctorService doctorService = new DoctorService();
    public static PatientService patientService = new PatientService();

    public void start() throws InterruptedException, IOException {
       //   slowPrint("\033[34m============== DEV TEAM 02 HASTANESINE HOSGELDİNİZ ================\033[0m\n", 20);
        //  slowPrint("\033[34m================ SAGLIGINIZ BIZIM ICIN ONEMLIDIR ==================\033[0m\n", 20);
        int secim = -1;
        while (secim != 0) {
            System.out.println("Lütfen giriş yapmak istediğiniz menü kodunu giriniz..\n\n" +
                    "1-HASTANE YÖNETİMİ GİRİŞİ\n" +
                    "2-DOKTOR GİRİŞİ\n" +
                    "3-HASTA GİRİŞİ\n" +
                    "4-HASTANE KADROMUZ\n" +
                    "0-ÇIKIŞ");
            try {
                secim = scan.nextInt();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!");
                continue;
            }
            switch (secim) {
                case 1:
                    hospitalService.hospitalServiceMenu();
                    break;
                case 2:
                    doctorService.doctorEntryMenu();
                    break;
                case 3:
                    patientService.patientEntryMenu();
                    break;
                case 4:
                    contactUs();
                    break;
                case 0:
                  exit();
                  break;
                default:
                    System.out.println("HATALI GIRIS, TEKRAR DENEYINIZ!");
            }

        }
        scan.close();
    }

    private void hospitalServiceMenu() {
        int secim = -1;
        scan.nextLine();
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTOR EKLE\n\t=> 2-DOKTORLARI LISTELE\n\t" +
                    "=> 3-UNVANDAN DOKTOR BULMA\n\t=> 4-DOKTOR SIL\n\t=> 5-HASTA EKLE\n\t=> 6-HASTA BUL\n\t=> 7-HASTA LISTELE\n\t=> 8-HASTA SIL\n\t=> 0-ANAMENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();//dummy
            } catch (Exception e) {
                scan.nextLine();//dummy
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    doctorService.addDoctor(); //
                    break;
                case 2:
                    doctorService.listDoctors();
                    break;
                case 3:
                    doctorService.findDoctorByTitle();
                    break;
                case 4:
                    doctorService.removeDoctor();
                    //
                    break;
                case 5:
                    patientService.addPatient();
                    break;
                case 6:
                    System.out.println("BULMAK İSTEDİĞİNİZ HASTANIN DURUMUNU GİRİNİZ...");
                    String durum = scan.nextLine().trim();
                  //System.out.println(hastaBul(durum));
                    patientService.listPatientByCase(durum);
                    break;
                case 7:
                    patientService.listPatients();
                    break;
                case 8:
                    patientService.removePatient();
                    break;
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);
    }

    public void contactUs() throws IOException, InterruptedException{
        Files.lines(Paths.get("src/Hospital_Project/Yonetim.txt")).forEach(System.out::println);
        start();
    }

    public static void exit() {
        slowPrint("\033[32m================== BIZI TERCIH ETTIGINIZ ICIN TESEKKUR EDER SAGLIKLI GUNLER DILERIZ =================\033[0m\n", 20);

        System.out.println();
        slowPrint("\033[32m======================================= DEV TEAM 02 HASTANESI =======================================\033[0m\n", 20);
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

    static {
        patientService.createFirstPatientList();
        doctorService.createFirstDoctorList();
    }

}
