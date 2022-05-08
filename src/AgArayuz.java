

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AgArayuz implements IAgArayuz{

    public void girisEkrani(){
        Scanner input = new Scanner(System.in);
        IDataBase db = Factory.dataBase();
        db.baglan();
        goster("Kullanici adi ve sifrenizi giriniz = ");
        String kullaniciAdi=input.nextLine();
        String sifre=input.nextLine();
        if(true==db.kullaniciDogrulama(kullaniciAdi,sifre)){
            islemSecimi();
        }
    }
    public void islemSecimi() {
        Scanner input = new Scanner(System.in);
        IIslemci islemci = Factory.islemci()    ;
        int sec;
        int defaultSicaklikSec;
        do {

            goster("___SEÇİM YAPINIZ___");
            goster("1.Sıcaklık Göster");
            goster("2.Soğutucuyu Aç");
            goster("3.Soğutucuyu Kapat");
            goster("4.İstenen Sıcaklığı Değiştir");
            goster("5.Çıkış");

            sec = input.nextInt();
            if(sec==1)
            {
                islemci.sicaklikGoster();
            }
            else if(sec==2){
                islemci.sogutucuAc();
            }
            else if(sec==3){
                islemci.sogutucuKapat();
            }
            else if(sec==4) {
                 goster("Ulaşmak istediğiniz sıcaklığı giriniz = ");
                 defaultSicaklikSec=input.nextInt();
                 islemci.setDefaultSicaklik(defaultSicaklikSec);

            }


        } while (sec != 5);
        goster("IYI GUNLER DILERIZ...");
    }
    public void goster(String s){
        System.out.println(""+s);
    }
    public int degerGir(int deger){
        Scanner input = new Scanner(System.in);
        deger= input.nextInt();
        return deger;
    }
}
