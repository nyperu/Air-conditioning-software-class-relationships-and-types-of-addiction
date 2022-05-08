public class Factory {
    public static IAgArayuz arayuz(){
        return  new AgArayuz();
    }
    public static IEyleyici eyleyici(){return new Eyleyici();}
    public static IDataBase dataBase(){return new AccesDatabase();}
    public static IIslemci islemci(){return new Islemci();}
    public static ISicaklikAlgilayici sicaklikOlcer(){return new SicaklikAlgilayici();}
    public static ISubject bildirimUret(){return new Publisher();}
}
