package com.data;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
public class JdbcTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void jdbcTemplateTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long aLong = jdbcTemplate.queryForObject("select count(*) from kmcgc_flow_config", Long.class);
        log.info("count: {}",aLong);
    }
}
