package Hastane_projesi;

public class Durum{
    private String aktuelDurum;
    private boolean aciliyet;

    @Override
    public String toString() {
        return "acil bir durum mu=" + aciliyet ;
    }

    public String getAktuelDurum() {
        return aktuelDurum;
    }

    public void setAktuelDurum(String aktuelDurum) {
        this.aktuelDurum = aktuelDurum;
    }

    public boolean isAciliyet() {
        return aciliyet;
    }

    public void setAciliyet(boolean aciliyet) {
        this.aciliyet = aciliyet;
    }
}
