package com.javageeksforgeeks.movies;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.javageeksforgeeks.movies.model.MovieByActor;

import java.util.UUID;

public class CassandraObjectMapper {
    public static void main(String[] args) {
        Cluster cluster=  Cluster.builder().addContactPoint("127.0.0.1").build();
        Session session = cluster.connect("essentials");
        MappingManager mappingManager = new MappingManager(session);
        Mapper<MovieByActor> movieByActorMapper = mappingManager.mapper(MovieByActor.class);

        MovieByActor braddPitt= movieByActorMapper.get("Bradd Pitt", 2006,UUID.fromString("839422d9-68c1-4d88-bced-4ef9a47e8c35"));
        System.out.println(braddPitt);

        cluster.close();
    }
}
