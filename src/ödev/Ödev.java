//1306160041
//Abdulkadir Semiz

package ödev;

import java.util.*;
import java.io.*;

public class Ödev 
{  
    public static void main(String[] args) 
    {
        
        Scanner scan1 = new Scanner(System.in);
        int i=0;
        int selection;
        
        Kitap veda=new Kitap();
        TestKitabi test1=new TestKitabi("9. Sınıf Matematik", 15, "Palme Yayinevi");
        TestKitabi test2=new TestKitabi("10. Sınıf Türkçe", 20, "Doğru Cevap Yayinevi");
        Dergi dergi1=new Dergi("N'Haber", 10, "MRG Fen Lisesi", "3. sayi");
        Dergi dergi2=new Dergi("Mutfakta Pratik Tarifler", 8, "Gurme Yayinevi", "3. sayi");
        Roman roman1=new Roman("Kitaba isim bulamadim", 1, "İsimsiz Yayinevi", "Abdulkadir Semiz");
        Roman roman2=new Roman("Gri Yol", 25, "Seyyah Yayinevi", "Şahin Duman");
        DersNotu dersnotu1=new DersNotu("Veri Yapıları", 4);
        DersNotu dersnotu2=new DersNotu("Calculus", 7,"Bizim Kopiy");
        Uyelik musteri=new Uyelik();
        
        
        do
        {   
            System.out.printf ("*** *** ***\n");
            System.out.println("Hoşgeldiniz. Sipariş verebilmek lütfen üye olup,giriş yapınız.");
            System.out.printf ("*** *** ***\n");
            System.out.println();
            System.out.println("Lütfen terciğinizi belirtiniz: ");            
            System.out.println("1)Üye olmak ");
            System.out.println("2)Giriş Yapmak ");            
            System.out.println();
                       
           selection = scan1.nextInt();   
         
           
            switch (selection)
            {
                case 1:                
                    String kullaniciadi,sifre,adres;

                    System.out.println("Kullanıcı Adı Oluşturunuz: ");
                    kullaniciadi = scan1.next();
                    musteri.setKullaniciadi(kullaniciadi);

                    System.out.println("Şifre Oluşturunuz: ");
                    sifre = scan1.next();
                    musteri.setSifre(sifre);
                    
                    System.out.println("Adresinizi giriniz: ");
                    adres = scan1.next();
                    musteri.setAdres(adres);


                    File kullanıcıadıdosya = new File("kullanıcıadı.txt");
                    
                    File kullanıcışifredosya = new File("password.txt");
                    File kullanıcıadresdosya = new File("adres.txt");

                try
                { 
                    FileWriter fileWriter = new FileWriter(kullanıcıadıdosya);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(kullaniciadi);
                    bufferedWriter.close();

                    FileWriter fileWriter1 = new FileWriter(kullanıcışifredosya); 

                    BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
                    bufferedWriter1.write(sifre);
                    bufferedWriter1.close();
                    
                    FileWriter fileWriter2 = new FileWriter(kullanıcıadresdosya); 

                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                    bufferedWriter2.write(adres);
                    bufferedWriter2.close();
                }   
                catch(IOException e) 
                {
                     System.out.println("Io exception");
                } 

                    break;

                case 2:  
                     String id="";
                     String pw="";
                     String path1 = System.getProperty("user.dir");  
                try
                {
                    FileInputStream fi = new FileInputStream(path1 + "\\kullanıcıadı.txt");                    
                    BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                    String satir;
                    while ((satir=buf.readLine())!=null)
                    {
                        id = satir; 
                    }
                }    
                catch(FileNotFoundException f)
                {
                    System.out.println("Henüz alışveriş sepetinize bir ürün eklemediniz.");
                }
                catch(IOException ioex)
                {
                    System.out.println("Io exception");
                }
                    
                    
                     String path2 = System.getProperty("user.dir");  
                try
                {
                    FileInputStream fi = new FileInputStream(path2 + "\\password.txt");                    
                    BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                    String satir;
                    while ((satir=buf.readLine())!=null)
                    {
                        pw = satir; 
                    }
                }    
                catch(FileNotFoundException f)
                {
                    System.out.println("Henüz alışveriş sepetinize bir ürün eklemediniz.");
                }
                catch(IOException ioex)
                {
                    System.out.println("Io exception");
                }

                        System.out.println("Kullanıcı Adınızı giriniz: ");
                        String ad = scan1.next();
                        System.out.println("Şifrenizi giriniz: ");
                        String pass = scan1.next();

                        if(id.equals(ad) && pw.equals(pass))
                        {
                            System.out.println("Başarıyla giriş yapıldı.");
                            System.out.println("***********************************");
                            selection = -1;
                            File liste = new File("liste.txt");
                            liste.delete();
                            System.out.printf ("*** *** ***\n");
                            musteri.selam();

                        }

                        else
                            System.out.println("Yanlış kullanıcı adı veya şifre girdiniz.");                                                  
                        break;

            }
        }while(selection != -1);
        
        do
        {   
            System.out.printf ("*** *** ***\n");
            System.out.printf ("      1    -->    Kitap Listesini görüntüleme               \n");
            System.out.printf ("      2    -->    Alişveriş sepetini görüntüleme               \n");
            System.out.printf ("      3    -->    Satın Alma               \n");
            System.out.printf ("      4    -->    EXIT           \n");
            System.out.printf ("*** *** ***\n");

            System.out.printf ("Seçiminizi girin: ");
            selection=scan1.nextInt();
            switch (selection)
            {
            case 1:
                String path = System.getProperty("user.dir");               
                File file = new File(path + "\\kitaplistesi.txt");

                BufferedReader br; 
                try 
                {
                    br = new BufferedReader(new FileReader(file));
                      String st; 
                    while ((st = br.readLine()) != null)
                    { 
                        System.out.println(st); 
                    } 
                } 
                catch (FileNotFoundException ex) 
                {
                    System.out.println("");
                }
                catch(IOException ioex)
                {
                  System.out.println("IOException"); 
                }
                System.out.println("Sepete eklemek istediğiniz kitabın numarasını giriniz: ");
                System.out.println("************");

                int num;
                num= scan1.nextInt();           

                switch(num){
                    case 1:                   
                        test1.sepeteekle();
                        musteri.setMasraf(test1.Fiyat);
                        break;  

                    case 2:
                        test2.sepeteekle();
                        musteri.setMasraf(test2.Fiyat);
                        break; 

                    case 3:
                        dergi1.sepeteekle();
                        musteri.setMasraf(dergi1.Fiyat);
                        break; 
                    case 4:
                        dergi2.sepeteekle();
                        musteri.setMasraf(dergi2.Fiyat);
                        break; 
                    case 5:
                            roman1.sepeteekle();
                            musteri.setMasraf(roman1.Fiyat);
                            break; 
                    case 6:
                            roman2.sepeteekle();
                            musteri.setMasraf(roman2.Fiyat);
                            break;
                    case 7:
                            dersnotu1.sepeteekle();
                            musteri.setMasraf(dersnotu1.Fiyat);
                            break;
                    case 8:
                        dersnotu2.sepeteekle();
                        musteri.setMasraf(dersnotu2.Fiyat);
                        break;
                    case -1:
                        break;
                    }
                break;
            case 2:
                String path1 = System.getProperty("user.dir");  
                try
                {
                    FileInputStream fi = new FileInputStream(path1 + "\\sepet.txt");                    
                    BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                    String satir;
                    while ((satir=buf.readLine())!=null)
                    {
                        System.out.println(satir);
                    }
                }    
                catch(FileNotFoundException f)
                {
                    System.out.println("Henüz alışveriş sepetinize bir ürün eklemediniz.");
                }
                catch(IOException ioex)
                {
                    System.out.println("Io exception");
                }
                double toplam = musteri.getMasraf();
                System.out.println();
                System.out.println("Toplam tutar : " + toplam + " TL");
                break;
            case 3:
                String path2 = System.getProperty("user.dir");
                try
                {
                    FileInputStream fi = new FileInputStream(path2 + "\\sepet.txt");                    
                    BufferedReader buf = new BufferedReader(new InputStreamReader(fi));
                    String satir;
                    while ((satir=buf.readLine())!=null)
                    {
                        System.out.println(satir);//buraya biraz modifiye edilecek
                        File kasa = new File("kasa.txt");
                        try{ 
                            FileWriter fileWriter = new FileWriter(kasa, true);

                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(satir);
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                        } 
                        catch(IOException e) 
                        {
                            System.out.println("Io exception");
                        }
                    }
                    System.out.println("Sayın "+musteri.kullaniciadi+"! Siparişleriniz faturalanmıştıt. Toplam tutar:"+musteri.masraf+" TL");
                    System.out.println("Ürünleriniz "+musteri.adres+" adresinize yollanacaktır. Ödemeniz kapıda ödeme olucaktır.");
                    veda.son();
                    System.out.println("Otomatik çıkış yapılıyor!!");
                    selection=-1;
                    File log = new File("kitaplistesi.txt");

                    try
                    { 
                        FileWriter fileWriter = new FileWriter(log);

                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write("");
                        bufferedWriter.close();
                    } 
                    catch(IOException e) 
                    {
                    System.out.println("Io exception");
                    } 
                    }    
                    catch(FileNotFoundException f)
                        {
                            System.out.println("Henüz ödenecek ürün eklemediniz.");
                        }
                    catch(IOException ioex)
                        {
                            System.out.println("Io exception");
                        }
                break;
            case 4:
                selection=-1;
        
                File log = new File("kitaplistesi.txt");

                try
                { 
                    FileWriter fileWriter = new FileWriter(log);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write("");
                    bufferedWriter.close();
                } 
                catch(IOException e) 
                {
                System.out.println("Io exception");
                } 
                break;
            }
        }while(selection != -1);  
    
    
    
    
    
    
    
    
    
    }
}

