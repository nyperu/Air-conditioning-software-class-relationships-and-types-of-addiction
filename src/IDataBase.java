import java.sql.Connection;
import java.sql.SQLException;

public interface IDataBase {
    public Connection baglan();
    public boolean kullaniciDogrulama(String kullaniciAdi, String Sifre);
    public void baglantiKes() throws SQLException;
}
