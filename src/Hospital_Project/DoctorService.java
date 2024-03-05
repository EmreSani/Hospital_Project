package Hospital_Project;

import java.io.IOException;
import java.util.LinkedList;

import static Hospital_Project.HospitalService.*;

public class DoctorService {
   private static final LinkedList<Doctor> doctorList = new LinkedList<>();

    public void doctorEntryMenu() throws InterruptedException, IOException {

        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:\n\t=> 1-DOKTORLARI LISTELE\n\t" +
                    "=> 2-UNVANDAN DOKTOR BULMA\n\t=> 3-HASTA BULMA\n\t=> 4-HASTALARI LISTELE \n\t=> 0-ANAMENU");
            System.out.println("=========================================");
            try {
                secim = scan.nextInt();
                scan.nextLine();//dummy
            } catch (Exception e) {
                System.out.println("\"LUTFEN SIZE SUNULAN SECENEKLERIN DISINDA VERI GIRISI YAPMAYINIZ!\"");
                continue;
            }
            switch (secim) {
                case 1:
                    listDoctors();
                    break;
                case 2:
                    findDoctorByTitle();
                    break;
                case 3:
                    System.out.println("BULMAK İSTEDİĞİNİZ HASTANIN DURUMUNU GİRİNİZ...");
                    String durum = scan.nextLine().trim();
                    //System.out.println(hastaBul(durum));
                    patientService.listPatientByCase(durum);
                    //o durumda bir hasta yoksa hicbir sey dondurmuyor
                    break;
                case 4:
                    patientService.listPatients();
                    break;
                case 0:
                    slowPrint("ANA MENUYE YÖNLENDİRİLİYORSUNUZ...\n", 20);
                  hospitalService.start();
                    break;
                default:
                    System.out.println("HATALI GİRİŞ, TEKRAR DENEYİNİZ...\n");
            }
        } while (secim != 0);

    }

    public void addDoctor() {
        // Doktor Ekleme Metodu
        System.out.println("Eklemek istediginiz doktor ismini giriniz");
        String doktorAdi = scan.nextLine();
        System.out.println("Eklemek istediginiz doktor soy ismini giriniz");
        String doktorSoyadi = scan.nextLine();
        System.out.println("Eklemek İstediginiz doktor Unvanini Giriniz: \n \t=> Allergist\n\t=> Norolog\n\t=> Genel Cerrah\n\t" +
                "=> Cocuk Doktoru\n\t=> Dahiliye\n\t=> Kardiolog");
        String doktorUnvan = scan.nextLine();
        Doctor doctor = new Doctor(doktorAdi, doktorSoyadi, doktorUnvan);
        doctorList.add(doctor);
        System.out.println(doctor.getIsim() + " " +doctor.getSoyIsim() + " isimli doktor sisteme başarıyla eklenmiştir...");
        listDoctors();
        // Doktor objesini istersek bir listeye ekleyebilir veya başka bir şekilde saklayabiliriz

    }


    public void removeDoctor() {
        listDoctors();
        System.out.println("Silmek istediginiz doktor ismini giriniz");
        String doktorName = scan.nextLine().trim();
        System.out.println("Silmek istediginiz doktor soyadini giriniz");
        String doktorSurname = scan.nextLine().trim();

        boolean isDeleted = false;
        for (Doctor w : doctorList) {
            if (w.getIsim().equalsIgnoreCase(doktorName) && w.getSoyIsim().equalsIgnoreCase(doktorSurname)) {
                System.out.println(w.getIsim() + " " + w.getSoyIsim() + " isimli doktor sistemden basariyla silinmistir...");
                doctorList.remove(w);
                isDeleted = true;
                break;
            }
        }
        if (!isDeleted) {
            System.out.println("SİLMEK İSTEDİGİNİZ DOKTOR LİSTEMİZDE BULUNMAMAKTADIR");
        }
        listDoctors();
    }

    public void findDoctorByTitle() {
        System.out.println("Bulmak Istediginiz Doktorun Unvanini Giriniz:\n\t=> Allergist\n\t=> Norolog\n\t" +
                "=> Genel Cerrah\n\t=> Cocuk Doktoru\n\t=> Dahiliye Uzmanı\n\t=> Kardiolog");
        //scan.nextLine();
        String unvan = scan.nextLine();

        System.out.println("------------------------------------------------------");
        System.out.println("---------- HASTANEDE BULUNAN DOKTORLARİMİZ -----------");
        System.out.printf("%-13s | %-15s | %-15s\n", "DOKTOR İSİM", "DOKTOR SOYİSİM", "DOKTOR UNVAN");
        System.out.println("------------------------------------------------------");
        boolean varMi = false;

        for (Doctor w : doctorList) {
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

    public void listDoctors() {
        System.out.println("------------------------------------------------------");
        System.out.println("---------- HASTANEDE BULUNAN DOKTORLARİMİZ -----------");
        System.out.printf("%-13s | %-15s | %-15s\n", "DOKTOR İSİM", "DOKTOR SOYİSİM", "DOKTOR UNVAN");
        System.out.println("------------------------------------------------------");
        for (Doctor w : doctorList) {
            System.out.printf("%-13s | %-15s | %-15s\n", w.getIsim(), w.getSoyIsim(), w.getUnvan());
        }
    }

    public Doctor findDoctor(String unvan) {
        Doctor doctor = new Doctor();
        for (int i = 0; i < hospital.unvanlar.size(); i++) {
            if (hospital.unvanlar.get(i).equals(unvan)) {
                doctor.setIsim(hospital.doctorIsimleri.get(i));
                doctor.setSoyIsim(hospital.doctorSoyIsimleri.get(i));
                doctor.setUnvan(hospital.unvanlar.get(i));
                break;
            }
        }
        return doctor;
    }

    public void createFirstDoctorList() {
        for (String w : hospital.unvanlar) {
            doctorList.add(findDoctor(w));
        }
    }
}
