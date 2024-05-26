public class CariHesap extends Hesap{
    private static final double HESAP_UCRETI = 3.0;

    public CariHesap(String musteri_adi, int hesap_numarasi, double bakiye) {
        super(musteri_adi, hesap_numarasi, bakiye);
    }
    @Override
    public void hesap_islemi(){
        if(bakiye - HESAP_UCRETI < 0){
            throw new IllegalArgumentException("hesap ucreti icin yetersiz bakiye");
        }
        bakiye -= HESAP_UCRETI;
    }
}
