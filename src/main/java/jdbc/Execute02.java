package jdbc;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","78767876");
        Statement st = con.createStatement();
/*
        String sql1="CREATE TABLE countries\n" +
                "(\n" +
                "    country_id CHAR(3),\n" +
                "    country_name VARCHAR(50),\n" +
                "    region_id SMALLINT\n" +
                ");\n" +
                "Insert into countries values ('AR','Argentina',2);\n" +
                "Insert into countries values ('AU','Australia',3);\n" +
                "Insert into countries values ('BE','Belgium',1);\n" +
                "Insert into countries values ('BR','Brazil',2);\n" +
                "Insert into countries values ('CA','Canada',2);\n" +
                "Insert into countries values ('CH','Switzerland',1);\n" +
                "Insert into countries values ('CN','China',3);\n" +
                "Insert into countries values ('DE','Germany',1);\n" +
                "Insert into countries values ('DK','Denmark',1);\n" +
                "Insert into countries values ('EG','Egypt',4);\n" +
                "Insert into countries values ('FR','France',1);\n" +
                "Insert into countries values ('IL','Israel',4);\n" +
                "Insert into countries values ('IN','India',3);\n" +
                "Insert into countries values ('IT','Italy',1);\n" +
                "Insert into countries values ('JP','Japan',3);\n" +
                "Insert into countries values ('KW','Kuwait',4);\n" +
                "Insert into countries values ('ML','Malaysia',3);\n" +
                "Insert into countries values ('MX','Mexico',2);\n" +
                "Insert into countries values ('NG','Nigeria',4);\n" +
                "Insert into countries values ('NL','Netherlands',1);\n" +
                "Insert into countries values ('SG','Singapore',3);\n" +
                "Insert into countries values ('UK','United Kingdom',1);\n" +
                "Insert into countries values ('US','United States of America',2);\n" +
                "Insert into countries values ('ZM','Zambia',4);\n" +
                "Insert into countries values ('ZW','Zimbabwe',4);";
        st.execute(sql1);

        //1. Example:  region id'si 1 olan "country name" değerlerini çağırın.
        String sql2="select country_name from countries where region_id =1";
        boolean result1=st.execute(sql2);
        System.out.println("result1 = " + result1);//true yada false verir.Cunku data cagirma islemi yaptik

        //Recordlari gormek icin executeQuery method'u kullanmaliyiz
        ResultSet resSet1=st.executeQuery(sql2);

        while (resSet1.next()){
            System.out.println( resSet1.getString("country_name"));
        }
        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql3="select country_id , country_name from countries where  region_id>2";
        ResultSet resSet2=st.executeQuery(sql3);

        while( resSet2.next()){
            System.out.println(resSet2.
                    getString("country_id")+"-->"+
                    resSet2.getString("country_name"));
        }

        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
*/
        String sql4 = "SELECT *" +
                " FROM companies " +
                "WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";
        ResultSet resSet3 = st.executeQuery(sql4);
             /*
          select *
          from companies
         order by number_of_employees
         limit 1;
             */

        while( resSet3.next()){
            System.out.println(resSet3.
                    getString(1)+
                    resSet3.getString(2)+
                    resSet3.getString(3));
        }
        con.close();
        st.close();







    }
}
