package ClientApp.manager;

import ClientApp.App;
import ClientApp.entity.ClientEntity;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientEntityManager
{
    public static void insert(ClientEntity client) throws SQLException
    {
        try(Connection c = App.getConnection())
        {
            String sql = "INSERT INTO client(firstName, lastName, patronymic,birthday, registrationDate, email, phone, genderCode) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getPatronymic());
            ps.setTimestamp(4, new Timestamp(client.getBirthday().getTime()));
            ps.setTimestamp(5, new Timestamp(client.getRegDate().getTime()));
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getPhone());
            ps.setString(8, String.valueOf(client.getGender()));


            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()) {
                client.setID(keys.getInt(1));
                return;
            }

            throw new SQLException("entity not added");
        }
    }
    public static List<ClientEntity> selectAll() throws SQLException {try(Connection c = App.getConnection()) {
            String sql = "SELECT * FROM client";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<ClientEntity> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(new ClientEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Patronymic"),
                        resultSet.getTimestamp("Birthday"),
                        resultSet.getTimestamp("RegistrationDate"),
                        resultSet.getString("Email"),
                        resultSet.getString("Phone"),
                        resultSet.getString("GenderCode").charAt(0)
                ));
            }

            return list;
        }
    }
}