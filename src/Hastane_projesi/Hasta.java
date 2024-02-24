package Hastane_projesi;

class Hasta extends Person {
    private int hastaID;
    private String durum;

    public Hasta(String isim, String soyIsim, int hastaID, String durum) {
        super(isim, soyIsim);
        this.hastaID = hastaID;
        this.durum = durum;
    }

    public int getHastaID() {
        return hastaID;
    }

    public String getDurum() {
        return durum;
    }
}

}
