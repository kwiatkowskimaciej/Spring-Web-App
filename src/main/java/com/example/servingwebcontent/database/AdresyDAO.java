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
public class AdresyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Adres> findAll(){
        String sql = "SELECT * from ADRESY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }
    public void save(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("nr_adresu", "panstwo", "kod_pocztowy", "rejon", "miejscowosc", "ulica", "numer", "numer_lokalu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }
    public Adres get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM ADRESY WHERE nr_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }
    public void update(Adres adres) {
        String sql = "UPDATE ADRESY SET nr_adresu=:nr_adresu, panstwo=:panstwo, kod_pocztowy=:kod_pocztowy, rejon=:rejon, miejscowosc=:miejscowosc, ulica=:ulica, numer=:numer, numer_lokalu=:numer_lokalu WHERE nr_adresu=:nr_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM ADRESY WHERE nr_adresu = ?";
        jdbcTemplate.update(sql, id);
    }
}
