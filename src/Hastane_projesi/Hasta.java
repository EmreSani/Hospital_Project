package Hastane_projesi;

class Hasta extends Person {
    private int hastaID;
    private Durum hastaDurumu;

    public Hasta(String isim, String soyIsim, int hastaID, Durum hastaDurumu) {
        super(isim, soyIsim);
        this.hastaID = hastaID;
        this.hastaDurumu = hastaDurumu;
    }



    public void setHastaID(int hastaID) {
        this.hastaID = hastaID;
    }

    public Durum getHastaDurumu() {
        return hastaDurumu;
    }

    public void setHastaDurumu(Durum hastaDurumu) {
        this.hastaDurumu = hastaDurumu;
    }

    public Hasta() {
        super();
    }

    public int getHastaID() {
        return hastaID;
    }

    @Override
    public String toString() {
        return "Hasta İsmi: " + this.isim + ", Soyisim: " + this.soyIsim + ", Hasta ID: " + this.hastaID + ", " +
                "Hasta durumu: " + this.hastaDurumu;
    }



}


