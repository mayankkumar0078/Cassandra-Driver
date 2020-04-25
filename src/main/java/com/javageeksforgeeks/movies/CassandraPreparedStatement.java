package com.javageeksforgeeks.movies;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import java.util.UUID;

public class CassandraPreparedStatement {
    public static void main(String[] args) {
        Cluster cluster=  Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("essentials");
        CassandraPreparedStatement cassandraPreparedStatement = new CassandraPreparedStatement();
        cassandraPreparedStatement.addMovie(session,"WestWorld",1976);

        session.close();
        cluster.close();
    }

    private void addMovie(Session session,String title,int releaseYear) {
        PreparedStatement ps = session.prepare("insert into movies(movie_id,title,release_year) values(?,?,?)");
        BoundStatement bs = ps.bind(UUID.randomUUID(),title,releaseYear);
        session.execute(bs);
    }
}
