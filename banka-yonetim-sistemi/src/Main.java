import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Banka banka  = new Banka();
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        while (true){
            System.out.println("------------------------");
            System.out.println("hesap acilisi (1 e bas)");
            System.out.println("bakiye gor (2 ye bas)");
            System.out.println("para yatir (3 e bas)");
            System.out.println("para cek (4 e bas)");
            System.out.println("bankadaki tum bakiyeyi goruntule (5 e bas)");
            System.out.println("cikis (6 e bas)");
            System.out.println("------------------------");
            int secim = s.nextInt();
            s.nextLine();
            if(secim == 1){
                System.out.println("adiniz : ");
                String musteri_adi = s.nextLine();
                System.out.println("bakiyenizi giriniz : ");
                double bakiye = s.nextDouble();
                if (bakiye < 0){
                    throw new IllegalArgumentException("bakiye 0 in altinda olamaz!!!");
                }
                int hesap_numarasi = 100_000_000 + r.nextInt(900_000_000);
                System.out.println("------------------------");
                System.out.println("hesap turu seciniz : ");
                System.out.println("banka hesabi acilisi (1 e bas)");
                System.out.println("tasarruf hesabi acilisi (2 ye bas)");
                System.out.println("cari hesap acilisi (3 e bas)");
                System.out.println("------------------------");
                int hesap_turu = s.nextInt();
                Hesap yeni_hesap;
                if (hesap_turu == 1){
                    yeni_hesap = new Hesap(musteri_adi,hesap_numarasi,bakiye);
                } else if (hesap_turu == 2) {
                    yeni_hesap = new TasarrufHesabi(musteri_adi,hesap_numarasi,bakiye);
                    yeni_hesap.hesap_islemi();
                } else if (hesap_turu == 3) {
                    yeni_hesap = new CariHesap(musteri_adi,hesap_numarasi,bakiye);
                    yeni_hesap.hesap_islemi();
                }else {
                    System.out.println("gecersiz secim!");
                    continue;
                }
                banka.hesap_ekle(yeni_hesap);
                System.out.println("hesap basariyla olusturuldu. hesap numaraniz : " + hesap_numarasi);
            }
            else if(secim == 2){
                banka.hesap_bakiyeleri_goster();
            } else if (secim == 3) {
                System.out.println("hesap numaranizi giriniz :");
                int hesap_num = s.nextInt();
                Hesap hesap = banka.hesap_bul(hesap_num);
                if (hesap != null){
                    System.out.println("yatirilacak miktar : ");
                    double yatirilan = s.nextDouble();
                    s.nextLine();
                    try {
                        hesap.para_yatir(yatirilan);
                        System.out.println("para yatirildi! yeni bakiyeniz : " + hesap.bakiye);
                    }catch (IllegalArgumentException e){
                        System.out.println("hata!!! : " + e.getMessage());
                    }
                }
                else System.out.println("hesap bulunamadi!!!");
            } else if (secim == 4) {
                System.out.println("hesap numaranizi giriniz :");
                int hesap_num = s.nextInt();
                Hesap hesap = banka.hesap_bul(hesap_num);
                if (hesap != null){
                    System.out.println("cekilecek miktar : ");
                    double cekilen = s.nextDouble();
                    s.nextLine();
                    try {
                        hesap.para_cek(cekilen);
                        System.out.println("para cekildi! kalan bakiyeniz : " + hesap.bakiye);
                    }catch (IllegalArgumentException e){
                        System.out.println("hata!!! : " + e.getMessage());
                    }
                }
            } else if (secim == 5) {
                System.out.println(banka.toplam_bakiye());
            } else if (secim == 6) {
                System.out.println("gorusmek uzere \ncikis yapiliyor...");
                break;
            }
            else System.out.println("gecersiz secim");
        }
    }
}