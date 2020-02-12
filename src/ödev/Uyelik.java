
package ödev;

public class Uyelik extends hosgeldin
{


    public String kullaniciadi;
    public String sifre;
    public String adres;
    public int masraf;

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setMasraf(int masraf) {
        this.masraf =this.masraf + masraf;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public String getAdres() {
        return adres;
    }

    public int getMasraf() {
        return masraf;
    }
    
    @Override
    void selam() {
        System.out.println("Giris basarili! Hosgeldiniz!");
    }
    
    
}
