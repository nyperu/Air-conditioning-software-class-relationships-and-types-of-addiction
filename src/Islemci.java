
public class Islemci implements IIslemci {
    IEyleyici eyleyici = Factory.eyleyici();
    IAgArayuz kullaniciya =  Factory.arayuz();

    ISicaklikAlgilayici algilayici = Factory.sicaklikOlcer();
    int sogutucuDurumu=0;
    int guncelSicaklik=algilayici.sicaklikOkuRastGele();
    int olmasiGerekenSicaklik=15;

    public void setDefaultSicaklik(int defaultSicaklik){
        olmasiGerekenSicaklik=defaultSicaklik;
        sogutucuDurumu=eyleyici.sogutucuKapat(sogutucuDurumu);
        kullaniciya.goster("Sogutucu derecesi ile oynandığı için kapanmıştır.\n Tekrar Açılacak");

        sogutucuAc();
    }
    public void sicaklikGoster(){
        kullaniciya.goster("Guncel Sicaklik = "+ algilayici.sicaklikGoster(guncelSicaklik));

    }
    public void sogutucuAc(){
        if(eyleyici.sogutucuDurumu(sogutucuDurumu)==1){
            kullaniciya.goster("Sogutucu Zaten Calisiyor.");
        }
        else {

            sogutucuDurumu = eyleyici.sogutucuCalistir(sogutucuDurumu);
            if (1 == sogutucuDurumu && olmasiGerekenSicaklik<algilayici.sicaklikGoster(guncelSicaklik)) {
                kullaniciya.goster("Sogutucu Açılıyor...");
                kullaniciya.goster("Sogutucu Acildi!");
                do {
                    if (eyleyici.sogutucuDurumu(sogutucuDurumu) == 1) {

                        guncelSicaklik--;

                        kullaniciya.goster("Guncel Sicaklik = " + algilayici.sicaklikGoster(guncelSicaklik));
                    }
                    else {
                        kullaniciya.goster("Sogutucu Arizalandi veya Sogutucu Kapatildi!");
                    }

                } while (olmasiGerekenSicaklik != guncelSicaklik);

            }
            else{
                if(1==sogutucuDurumu) {
                    if(guncelSicaklik!=olmasiGerekenSicaklik){
                        kullaniciya.goster("Sogutucu açılmıştır. Erişilmesi beklenen sıcaklık "+ olmasiGerekenSicaklik);
                        do {
                            if (eyleyici.sogutucuDurumu(sogutucuDurumu) == 1) {
                                guncelSicaklik++;
                                kullaniciya.goster("Guncel Sicaklik = " + algilayici.sicaklikGoster(guncelSicaklik));
                            }
                            else {
                                kullaniciya.goster("Sogutucu Arizalandi veya Sogutucu Kapatildi!");
                            }

                        } while (olmasiGerekenSicaklik != guncelSicaklik);

                    }
                    kullaniciya.goster("Soğutucu açılmıştır. Guncel sicaklik = "+ algilayici.sicaklikGoster(guncelSicaklik));
                }else{
                    kullaniciya.goster("");
                 }
            }

        }
    }
    public void sogutucuKapat(){
        if(eyleyici.sogutucuDurumu(sogutucuDurumu)==0){
            kullaniciya.goster("Sogutucu Zaten Kapali.");
        }
        else{
            sogutucuDurumu = eyleyici.sogutucuKapat(sogutucuDurumu);
            kullaniciya.goster("Sogutucu kapandi.");
        }
    }


}
