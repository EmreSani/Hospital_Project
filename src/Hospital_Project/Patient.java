package Hospital_Project;

class Patient extends Person {
    private int hastaID;
    private Case hastaDurumu;

    public Patient(String isim, String soyIsim, int hastaID, Case hastaDurumu) {
        super(isim, soyIsim);
        this.hastaID = hastaID;
        this.hastaDurumu = hastaDurumu;
    }

    public void setHastaID(int hastaID) {
        this.hastaID = hastaID;
    }

    public Case getHastaDurumu() {
        return hastaDurumu;
    }

    public void setHastaDurumu(Case hastaDurumu) {
        this.hastaDurumu = hastaDurumu;
    }

    public Patient() {
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


