
public class Eyleyici implements IEyleyici {

    public int sogutucuCalistir(int calisiyorMu) {

        if(calisiyorMu==0) {

            return 1;
        }
        else {
            return 1;
        }
    }
    public int sogutucuKapat(int calisiyorMu) {
        if(calisiyorMu==1){
            return 0;
        }
        else{
            return 0;
        }
    }
    public int sogutucuDurumu(int calisiyorMu){
        if(calisiyorMu == 0)
            return 0;
        else
            return 1;
    }
}
