package org.genesis.genesispooltracker;

import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Db {
    private Connection connection;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    public void getConnection(){
        try{
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection("jdbc:sqlite:genesis.db");
                logger.info("Connected to database");
                createTable();
            }
        }catch (SQLException e){
            logger.info(e.toString());
        }
    }

    private void createTable(){
        getConnection();
        String query = "create table if  not exists team (name text not null, wins integer not null, losses integer not null, games_played integer not null, win_rate double not null)";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.executeUpdate();
            logger.info("Table created");

        }catch (SQLException e){
            logger.info(e.toString());
        }
    }



}
