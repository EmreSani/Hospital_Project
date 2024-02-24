package Hastane_projesi;

public class StaticMethods {
    public static String doktorUnvan(String aktuelDurum) {
        String unvan = "Yanlis unvan";
        for (int i = 0; i < VeriBankasi.durumlar.size(); i++) {
            if (aktuelDurum.equalsIgnoreCase(VeriBankasi.durumlar.get(i))) {
              unvan = VeriBankasi.unvanlar.get(i);
            }
        }
        return unvan;
    }









 }

