package Hospital_Project;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import static Hospital_Project.HospitalService.*;
import static Hospital_Project.DataBankService.con;

public class DoctorService implements Methods{
   private static final LinkedList<Doctor> doctorList = new LinkedList<>();

   @Override
    public void entryMenu() throws InterruptedException, IOException, SQLException {

        int secim = -1;
        do {
            System.out.println("=========================================");
            System.out.println("""
                    LUTFEN YAPMAK ISTEDIGINIZ ISLEMI SECINIZ:
                    \t=> 1-DOKTORLARI LISTELE
                    \t=> 2-UNVANDAN DOKTOR BULMA
                    \t=> 3-HASTA BULMA
                    \t=> 4-HASTALARI LISTELE\s
                    \t=> 0-ANAMENU""");
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
                    list();
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
                    patientService.list();
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

    @Override
    public void add() {
        // Doktor Ekleme Metodu
        System.out.println("Eklemek istediginiz doktor ismini giriniz");
        String doktorAdi = scan.nextLine();
        System.out.println("Eklemek istediginiz doktor soy ismini giriniz");
        String doktorSoyadi = scan.nextLine();
        System.out.println("Eklemek İstediginiz doktor Unvanini Giriniz: \n \t=> Allergist\n\t=> Norolog\n\t=> Genel Cerrah\n\t" +
                "=> Cocuk Doktoru\n\t=> Dahiliye\n\t=> Kardiolog");
        String doktorUnvan = scan.nextLine();
        String addDoctor = "INSERT INTO doctors (doctor_name, doctor_surname, doctor_title) VALUES(?,?,?)";
        try {
            PreparedStatement prst = con.prepareStatement(addDoctor);
            prst.setString(1, doktorAdi);
            prst.setString(2, doktorSoyadi);
            prst.setString(3,doktorUnvan);
            prst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        Doctor doctor = new Doctor(doktorAdi, doktorSoyadi, doktorUnvan);
//        doctorList.add(doctor);
        System.out.println(doktorAdi + " " +doktorSoyadi + " isimli doktor sisteme başarıyla eklenmiştir...");
        list();
        // Doktor objesini istersek bir listeye ekleyebilir veya başka bir şekilde saklayabiliriz

    }


    @Override
    public void remove() {
        list();
        System.out.println("Silmek istediginiz doktorun idsini giriniz");
        int doctorId = scan.nextInt();
//        System.out.println("Silmek istediginiz doktor soyadini giriniz");
//        String doktorSurname = scan.nextLine().trim();

        boolean isDeleted = false;
        int deleted;

        String deleteDoctor = "DELETE FROM doctors WHERE doctor_id= ?";
        String findDoctor = "SELECT * FROM doctors WHERE doctor_id = ?";
        try {
            PreparedStatement prst = con.prepareStatement(deleteDoctor);
            PreparedStatement prst2 = con.prepareStatement(findDoctor);
            prst.setInt(1, doctorId);
            prst2.setInt(1, doctorId);

            ResultSet rs = prst2.executeQuery();
            while(rs.next()){
                int id = rs.getInt("doctor_id");
                String name = rs.getString("doctor_name");
                System.out.println("Silinen doktor: \n" + id + " " + name);
            }

            deleted = prst.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(deleted==0){
            System.out.println("ID'si " +doctorId + " olan doktor bulunamadı.");
        }else{
            System.out.println("ID'si " +doctorId + " olan doktor başarıyla silindi.");
        }

//        for (Doctor w : doctorList) {
//            if (w.getIsim().equalsIgnoreCase(doktorName) && w.getSoyIsim().equalsIgnoreCase(doktorSurname)) {
//                System.out.println(w.getIsim() + " " + w.getSoyIsim() + " isimli doktor sistemden basariyla silinmistir...");
//                doctorList.remove(w);
//                isDeleted = true;
//                break;
//            }
//        }
//        if (!isDeleted) {
//            System.out.println("SİLMEK İSTEDİGİNİZ DOKTOR LİSTEMİZDE BULUNMAMAKTADIR");
//        }
        list();
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

    public void list() {
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

    public void createList() {
        for (String w : hospital.unvanlar) {
            doctorList.add(findDoctor(w));
        }
    }
}
