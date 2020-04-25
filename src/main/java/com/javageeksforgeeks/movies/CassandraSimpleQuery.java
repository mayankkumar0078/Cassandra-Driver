package com.javageeksforgeeks.movies;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraSimpleQuery {
    public static void main(String[] args) {
        Cluster cluster=  Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("essentials");

        session.execute("insert into movies(movie_id,title,release_year) values(uuid(),'The Life of Pie',2018)");

        ResultSet resultSet = session.execute("SELECT * from movies");
        for(Row row:resultSet){
            System.out.format("%s %s %s \n",row.getUUID("movie_id"),row.getString("title"),row.getInt("release_year"));
        }
        session.close();
    }
}
