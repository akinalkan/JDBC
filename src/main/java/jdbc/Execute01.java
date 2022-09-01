package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Adim: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adim : Database'e baglan
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "78767876");

        //3.Adim: Statement olustur.
        Statement st = con.createStatement();

        //4.Adim:Query calisir.
        // 1.Example: "workers" adında bir table oluşturup
        // "worker_id,worker_name, worker_salary" sütunlarını ekleyin.

        String sql1="CREATE TABLE workers(worker_id VARCHAR(50)" +
                ",worker_name VARCHAR(50), " +
                "worker_salary INT)";
       boolean result =  st.execute(sql1);

        System.out.println("result = " + result);
        //False return yapar, cunku data cagrilmadi.

        //2.Örnek: Alter table by adding worker_address column into the workers table
        //[İşçiler tablosuna worker_address sütunu ekleyerek tabloyu değiştirin]

        String sql2="Alter table workers add worker_address varchar(50)";
        boolean result2 =  st.execute(sql2);
        System.out.println("result2 = "+result2);

        String sql4="insert into workers (worker_id ,worker_name,worker_salary,worker_address)" +
                " values ('101','Adam Smith',2000,'Miami,FL,USA')";
        boolean result4 = st.execute(sql4);
        System.out.println("result4 = " + result4);

        //3.Example: Drop workers table
        String sql3="Drop table workers";
       boolean result3= st.execute(sql3);
        System.out.println("result3 = "+result3);


    //5.Adim: Baglanti ve Statement 'i kapat.
        con.close();
        st.close();







    }


}
