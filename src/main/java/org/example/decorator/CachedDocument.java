package org.example.decorator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.*;

@AllArgsConstructor
public class CachedDocument  implements Document{
    String document;
    @Override
    public String parse() throws ClassNotFoundException {
        String DbUrl = "jdbc:postgresql://localhost:5433/photos";
        String username = "postgres";
        String password = "postgres";
        String info = null;
        try {
            Connection connection = DriverManager.getConnection(DbUrl, username, password);
            System.out.println("Successfully connected");
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT text FROM info WHERE url='" +  document + "'");
            while (result.next()){
                info = result.getString("text");
            }
            if (info == null){
                info = new SmartDocument(document).parse();
                statement.executeUpdate(("INSERT INTO info VALUES ('" + document + "', '" + info + "')"));}
            connection.close();
            }
        catch (SQLException ex) {
            System.out.println("Some error in connecting to the database");
            throw new RuntimeException(ex);
        }
        System.out.println(info);
        return info;


    }
}
