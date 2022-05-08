

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {//bu sınıftaki işlemler gerçek hayatta olmayacaktır.
    public int sicaklikOkuRastGele() {
        Random rastgele = new Random();
        int sayi = rastgele.nextInt(55);
        return  sayi+15;
    }

    public int sicaklikGoster(int sicaklik) {//buraya parametre ile gelen değer, gerçek hayata benzemesi içindir.
        return sicaklik;
    }
}
