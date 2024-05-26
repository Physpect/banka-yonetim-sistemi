public class TasarrufHesabi extends Hesap{
    private static final double FAIZ_ORANI = 0.03;
    public TasarrufHesabi(String musteri_adi, int hesap_numarasi, double bakiye){
        super(musteri_adi,hesap_numarasi,bakiye);
    }
    @Override
    public void hesap_islemi(){
        bakiye += bakiye * FAIZ_ORANI;
    }
}
