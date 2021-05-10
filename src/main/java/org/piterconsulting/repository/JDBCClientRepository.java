package org.piterconsulting.repository;

import org.piterconsulting.repository.annotation.JDBCRepository;
import org.piterconsulting.repository.entity.Client;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
@Repository
@JDBCRepository
public class JDBCClientRepository implements ClientRipository {

    public  final String user;
    public  final String password;
    public  final String jdbcurl;

    public JDBCClientRepository(
           @Value("${jdbc.user}") String user,
           @Value("${jdbc.password}") String password,
           @Value("${jdbc.url}") String jdbcurl) {
        this.user = user;
        this.password = password;
        this.jdbcurl = jdbcurl;
    }

    @Override
    public void save(Client client) {
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, user, password);
            final PreparedStatement statement = connection.prepareStatement("INSERT INTO USERS (first_name,mail) values (?,?)");
            statement.setString(1, client.getName());
            statement.setString(2, client.getMail());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Client findByMail(String mail) {
        try {
            Connection connection = DriverManager.getConnection(jdbcurl, user, password);
            final PreparedStatement statement = connection.prepareStatement("select first_name,mail from users where mail=?");
            statement.setString(1, mail);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                final String name = resultSet.getString("FIRST_NAME");
                final String mail1 = resultSet.getString("MAIL");
                return new Client(name, mail1, null);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    @Override
    public void delete(Client client) {

    }
}
