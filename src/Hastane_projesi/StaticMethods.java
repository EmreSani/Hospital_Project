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

