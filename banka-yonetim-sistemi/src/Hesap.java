public class Hesap {
    private String musteri_adi;
    private int hesap_numarasi;
    protected  double bakiye;
    public Hesap(String musteri_adi, int hesap_numarasi, double bakiye) {
        this.musteri_adi = musteri_adi;
        this.hesap_numarasi = hesap_numarasi;
        this.bakiye = bakiye;
    }

    public String getMusteri_adi() {
        return musteri_adi;
    }

    public int getHesap_numarasi() {
        return hesap_numarasi;
    }

    public double getBakiye() {
        return bakiye;
    }
    public void para_yatir(double tutar){
        if(tutar <= 0){
            throw new IllegalArgumentException("yatirilacak tutar 0 veya 0 dan fazla olmali!");
        }
        bakiye += tutar;
    }
    public void para_cek(double tutar){
        if((bakiye - tutar)<=0){
            throw new IllegalArgumentException("yetersiz bakiye ;)");
        }
        if(tutar <= 0){
            throw new IllegalArgumentException("cekilcek tutar 0 veya 0 dan fazla olmali!");
        }
        bakiye -= tutar;
    }
    public void hesap_islemi(){
    }
}





















