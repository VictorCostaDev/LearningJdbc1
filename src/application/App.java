package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class App {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        
        try {
            connection = DB.getConnection(); // Estabelecendo conexão
            statement = connection.createStatement(); // instanciando statement
            resultSet = statement.executeQuery("select * from department");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechando os objetos para não haver vazamento de dados
            DB.closeConnection();
            DB.closeStatement(statement);
            DB.closeResultSet(resultSet);
        }
    }
}
