package Hastane_projesi;

class Person {
    protected String isim;
    protected String soyIsim;

    public Person(String isim, String soyIsim) {
        this.isim = isim;
        this.soyIsim = soyIsim;
    }

    public String getIsim() {
        return isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }