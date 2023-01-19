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
public class FabrykiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Fabryka> findAll(){
        String sql = "SELECT * from FABRYKI f LEFT OUTER JOIN ADRESY a ON f.nr_adresu = a.nr_adresu LEFT OUTER JOIN TELEFONY t ON f.nr_zbioru_telefonow = t.nr_zbioru_telefonow";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Fabryka.class));
    }
    public void save(Fabryka fabryka) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("fabryki").usingColumns("nr_fabryki", "nazwa", "e_mail", "nr_konta", "czy_zagraniczny", "odleglosc", "nr_adresu", "nr_zbioru_telefonow");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(fabryka);
        insertActor.execute(param);
    }
    public Fabryka get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM FABRYKI f LEFT OUTER JOIN ADRESY a ON f.nr_adresu = a.nr_adresu LEFT OUTER JOIN TELEFONY t ON f.nr_zbioru_telefonow = t.nr_zbioru_telefonow WHERE nr_fabryki = " + args[0];
        Fabryka fabryka = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Fabryka.class));
        return fabryka;
    }
    public void update(Fabryka fabryka) {
        String sql = "UPDATE FABRYKI SET nr_fabryki=:nr_fabryki, nazwa=:nazwa, e_mail=:e_mail, nr_konta=:nr_konta, czy_zagraniczny=:czy_zagraniczny, odleglosc=:odleglosc, nr_adresu=:nr_adresu, nr_zbioru_telefonow=:nr_zbioru_telefonow";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(fabryka);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM FABRYKI WHERE nr_fabryki = ?";
        jdbcTemplate.update(sql, id);
    }
}
