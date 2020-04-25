package com.javageeksforgeeks.movies;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.QueryBuilder;

import java.util.UUID;

public class CassandraQueryBuilder {
    public static void main(String[] args) {
        Cluster cluster=  Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("essentials");

        CassandraQueryBuilder cassandraQueryBuilder = new CassandraQueryBuilder();
        cassandraQueryBuilder.addMovieByActor(session,"Irfan Khan",UUID.fromString("661a69be-fde4-4bfa-9ef8-f2a960ee5249"),
                "The Life of Pie",2017);
        Statement stmt = QueryBuilder.select().all().from("essentials","movies_by_actor");

        ResultSet resultSet = session.execute(stmt);
        for(Row row:resultSet){
            System.out.format("%s %s %s %s \n",row.getString("actor"),row.getUUID("movie_id"),row.getString("title"),row.getInt("release_year"));
        }
        session.close();
        cluster.close();
    }


    private void addMovieByActor(Session session, String actor, UUID movieId,String title,Integer releaseYear) {
        Statement stmt= QueryBuilder.insertInto("movies_by_actor")
                .value("actor",actor)
                .value("movie_id",movieId)
                .value("title",title)
                .value("release_year",releaseYear);
        session.execute(stmt);
    }
}
