
package ödev;
import java.io.*;

public class Roman extends Kitap implements Ikitapozellikleri, Igoruntuleme, Isepet {
    
    public String yazar;
    public void getYazar(String Yazar){
        yazar=Yazar;
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
            bufferedWriter.write(kitapno + ")" + Ad + "*****" + "*****" + "Yazar:" + yazar + "*****" + " (" + yayinevi + ") " + " ***** " + Fiyat + " TL");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } 
        catch(IOException e) 
        {
        System.out.println("Io exception");
        } 
    }
    
    Roman(String a,int b,String c, String d){
        getKitapadi(a);
        getFiyat(b);
        getYayinevi(c);
        getYazar(d);
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
