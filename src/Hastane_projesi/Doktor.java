package Hastane_projesi;

public class Doktor extends Person {
    String unvan;



    public Doktor() {
    }

    public Doktor(String isim, String soyIsim, String unvan) {
        super(isim, soyIsim);
        this.unvan = unvan;
    }

    public Doktor(String unvan) {
        this.unvan = unvan;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;

    }

    @Override
    public String toString() {
        return "Doktor İsmi: " + this.isim + ", Soyisim: " + this.soyIsim + ", Unvan: " + this.unvan;
    }

}
