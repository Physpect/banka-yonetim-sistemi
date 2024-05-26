import java.util.ArrayList;
public class Banka {
    private ArrayList<Hesap> hesaplar;
    public Banka(){
        hesaplar = new ArrayList<>();
    }
    public void hesap_ekle(Hesap hesap){
        hesaplar.add(hesap);
    }
    public double toplam_bakiye(){
        double toplam = 0.0;
        for (Hesap hesap : hesaplar){
            toplam += hesap.getBakiye();
        }
        return toplam;
    }
    public void hesap_bakiyeleri_goster() {
        for (Hesap hesap : hesaplar) {
            System.out.println("------------------------");
            System.out.println("Müşteri Adı: " + hesap.getMusteri_adi());
            System.out.println("Hesap Numarası: " + hesap.getHesap_numarasi());
            System.out.println("Bakiye: " + hesap.getBakiye());
            System.out.println("------------------------");
        }
    }
    public Hesap hesap_bul(int hesap_numarasi) {
        for (Hesap hesap : hesaplar) {
            if (hesap.getHesap_numarasi() == hesap_numarasi) {
                return hesap;
            }
        }
        return null;
    }

}
