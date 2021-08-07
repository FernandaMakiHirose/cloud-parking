package one.digitalinnovation.parking.controller;

import org.testcontainers.containers.PostgreSQLContainer;

public abstract class AbstractContainerBase {

    // define uma variável static
    static final PostgreSQLContainer POSTGRE_SQL_CONTAINER;

    static {
        // imagem que o postgresql vai usar
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:10-alpine");

        // inicializa
        POSTGRE_SQL_CONTAINER.start();

        // informações buscadas no arquivo application.properties
        System.setProperty("spring.datasource.url", POSTGRE_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", POSTGRE_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.password", POSTGRE_SQL_CONTAINER.getPassword());
    }
}
