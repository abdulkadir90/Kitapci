
package ödev;

import java.io.*;

public class DersNotu extends Kitap implements Ikitapozellikleri, Igoruntuleme, Isepet {

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
            bufferedWriter.write(kitapno + ")" + Ad + "*****" + "*****" + "*****" + " (" + yayinevi + ") " + " ***** " + Fiyat + " TL");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } 
        catch(IOException e) 
        {
        System.out.println("Io exception");
        } 
    }
    
    DersNotu(String a,int b,String c){
        getKitapadi(a);
        getFiyat(b);
        getYayinevi(c);
        listeno++;
        kitapno=listeno;
        kitaplistesihazirla();
    }
    DersNotu(String a,int b){
        getKitapadi(a);
        getFiyat(b);
        getYayinevi("Fotokopi Dünyasi");
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
