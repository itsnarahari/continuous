package com.continuous.boot.config;

import com.continuous.boot.dao.UserRepository;
import com.continuous.boot.service.OTPSender;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PostConstructExample {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    OTPSender otpSender;

    @PostConstruct
    public void post() throws SQLException {

        otpSender.sender();
        ;

        jdbcTemplate.query("select * from users", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println("--- " + rs.getString("name"));
                return new Object();
            }
        });
        System.out.println("Post Construct for get call");
        System.out.println(userRepository.findAll());
        MetamodelImplementor model = (MetamodelImplementor) entityManager.getMetamodel();
        System.out.println(model.getManagedTypes());

        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
        Connection connection = info.getDataSource().getConnection();
        System.out.println(connection.getCatalog());
        System.out.println(connection.getSchema());

    }
}
