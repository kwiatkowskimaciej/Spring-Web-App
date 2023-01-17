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
public class SerwisyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Serwis> findAll(){
        String sql = "SELECT * from SERWISY s LEFT JOIN ADRESY a ON s.nr_adresu = a.nr_adresu LEFT JOIN TELEFONY t ON s.nr_zbiorow_telefonow = t.nr_zbioru_telefonow";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Serwis.class));
    }
    public void save(Serwis serwis) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("serwisy").usingColumns("nr_serwisu", "nazwa", "liczba_stanowisk", "nr_salonu", "nr_adresu", "nr_zbiorow_telefonow");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(serwis);
        insertActor.execute(param);
    }
    public Serwis get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM SERWISY s LEFT JOIN ADRESY a ON s.nr_adresu = a.nr_adresu LEFT JOIN TELEFONY t ON s.nr_zbioru_telefonow = t.nr_zbiorow_telefonow WHERE nr_serwisu = " + args[0];
        Serwis serwis = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Serwis.class));
        return serwis;
    }
    public void update(Serwis serwis) {
        String sql = "UPDATE SERWISY SET nr_serwisu=:nr_serwisu, nazwa=:nazwa, liczba_stanowisk=:liczba_stanowisk, nr_salonu=:nr_salonu, nr_adresu=:nr_adresu, nr_zbiorow_telefonow=:nr_zbiorow_telefonow";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(serwis);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM SERWISY WHERE nr_serwisu = ?";
        jdbcTemplate.update(sql, id);
    }

}
