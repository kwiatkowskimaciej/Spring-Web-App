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
public class KlienciDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Klient> findAll(){
        String sql = "SELECT * from KLIENCI k LEFT JOIN ADRESY a ON k.nr_adresu = a.nr_adresu LEFT JOIN TELEFONY t ON k.nr_zbioru_telefonow = t.nr_zbioru_telefonow";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }
    public void save(Klient klient) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("klienci").usingColumns("nr_klienta", "imie", "nazwisko", "plec", "nr_konta", "e_mail", "nr_adresu", "nr_zbioru_telefonow", "nr_salonu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        insertActor.execute(param);
    }
    public Klient get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM KLIENCI k LEFT JOIN ADRESY a ON k.nr_adresu = a.nr_adresu LEFT JOIN TELEFONY t ON k.nr_zbioru_telefonow = t.nr_zbioru_telefonow WHERE nr_klienta = " + args[0];
        Klient klient = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }
    public void update(Klient klient) {
        String sql = "UPDATE KLIENCI SET nr_klienta=:nr_klienta, imie=:imie, nazwisko=:nazwisko, plec=:plec, nr_konta=:nr_konta, e_mail=:e_mail, nr_adresu=:nr_adresu, nr_zbioru_telefonow=:nr_zbioru_telefonow, nr_salonu=:nr_salonu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM KLIENCI WHERE nr_klienta = ?";
        jdbcTemplate.update(sql, id);
    }

}
