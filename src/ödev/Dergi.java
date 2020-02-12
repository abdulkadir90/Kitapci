
package ödev;

import java.io.*;

public class Dergi extends Kitap implements Ikitapozellikleri, Igoruntuleme, Isepet {

    public String sayi;
    public void getsayi(String Sayi){
        sayi=Sayi;
    }
    
    @Override
    public void getKitapadi(String ad) {
        Ad=ad;
    }

    @Override
    public void getFiyat(int fiyat) {
        Fiyat=fiyat;
    }

    @Override
    public void getYayinevi(String Yayinevi) {
        yayinevi= Yayinevi;
    }
    
    @Override
    public void kitaplistesihazirla() {
        File log = new File("kitaplistesi.txt");

        try{ 
            FileWriter fileWriter = new FileWriter(log, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(kitapno + ")" + Ad + "*****" + "*****" + sayi + "*****" + " (" + yayinevi + ") " + " ***** " + Fiyat + " TL");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } 
        catch(IOException e) 
        {
        System.out.println("Io exception");
        } 
    }
    
    Dergi(String a,int b,String c, String d){
        getKitapadi(a);
        getFiyat(b);
        getYayinevi(c);
        getsayi(d);
        listeno++;
        kitapno=listeno;
        kitaplistesihazirla();
    }

    @Override
    public void sepeteekle() {
        File log = new File("sepet.txt");

        try{ 
            FileWriter fileWriter = new FileWriter(log, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(Ad + "*****" + Fiyat + " TL");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } 
        catch(IOException e) 
        {
        System.out.println("Io exception");
        }
    }

    
}
