package com.example.servingwebcontent.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SalonyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public SalonyDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public List<Salon> findAll(){
        String sql = "SELECT * from SALONY_SAMOCHODOWE";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Salon.class));
    }
    public void save(Salon Salon) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("salony_samochodowe").usingColumns("nr_salonu", "nazwa", "data_zalozenia", "nr_adresu", "nr_zbioru_telefonow");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Salon);
        insertActor.execute(param);
    }
    public Salon get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM SALONY_SAMOCHODOWE WHERE nr_salonu = " + args[0];
        Salon salon = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Salon.class));
        return salon;
    }
    public void update(Salon Salon) {
        String sql = "UPDATE SALONY_SAMOCHODOWE SET nr_salonu=:nr_salonu, nazwa=:nazwa, data_zalozenia=:data_zalozenia, nr_adresu=:nr_adresu, nr_zbioru_telefonow=:nr_zbioru_telefonow WHERE nr_salonu=:nr_salonu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Salon);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM SALONY_SAMOCHODOWE WHERE nr_salonu = ?";
        jdbcTemplate.update(sql, id);
    }
}
