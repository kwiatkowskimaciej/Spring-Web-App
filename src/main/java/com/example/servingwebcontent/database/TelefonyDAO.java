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
public class TelefonyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Telefon> findAll(){
        String sql = "SELECT * from TELEFONY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Telefon.class));
    }
    public void save(Telefon telefon) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("telefony").usingColumns("nr_zbioru_telefonow", "pierwszy_telefon", "drugi_telefon", "trzeci_telefon");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(telefon);
        insertActor.execute(param);
    }
    public Telefon get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM TELEFONY WHERE nr_serwisu = " + args[0];
        Telefon telefon = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Telefon.class));
        return telefon;
    }
    public void update(Telefon telefon) {
        String sql = "UPDATE TELEFONY SET nr_zbioru_telefonow=:nr_zbioru_telefonow, pierwszy_telefon:pierwszy_telefon, drugi_telefon=:drugi_telefon, trzeci_telefon=:trzeci_telefon";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(telefon);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM TELEFONY WHERE nr_serwisu = ?";
        jdbcTemplate.update(sql, id);
    }

}
