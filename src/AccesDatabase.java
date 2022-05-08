import org.apache.commons.lang3.ObjectUtils;

import java.sql.*;

public class AccesDatabase implements  IDataBase{
    String databaseURL = "jdbc:ucanaccess://Users.accdb";
    private  Connection baglanti=null;
    Statement durum;
    ResultSet resultSet=null;
    PreparedStatement preparedStatement=null;
    public void setDatabaseURL(String s){
        databaseURL=s;
    }
    public  Connection baglan() {
        System.out.println("Bağlanıyor...");
        try {
            baglanti = (Connection) DriverManager.getConnection(databaseURL);

            System.out.println("Bağlantı başarılı.");

        } catch (SQLException e) {
            System.out.println("Bağlantı girişimi başarısız.");
            e.printStackTrace();
        }

        return baglanti;
    }
    public boolean kullaniciDogrulama(String kullaniciAdi, String Sifre) {
        if(baglanti!=null){
        try {
                String GetUsersSQL = "SELECT * FROM kul";
                boolean dogrula = false;
                preparedStatement=baglanti.prepareStatement(GetUsersSQL);
                resultSet=preparedStatement.executeQuery();
                while(resultSet.next()){
                    if (resultSet.getString("users").equals(kullaniciAdi) && resultSet.getString("pas").equals(Sifre)){
                        dogrula = true;
                    }
                }
                if (dogrula) {
                    System.out.println("Giriş Başarılı !");
                    return true;
                }else {
                    System.out.println("\nGiriş yapamadınız...!\n");
                    return false;
                }
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
        }
        else
            System.out.printf("Veri tabanı bağlantısı bozuldu.");
        return false;
    }
    public void baglantiKes() throws SQLException {
        baglanti.close();
    }

}
