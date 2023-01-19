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
public class FirmyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Firma> findAll(){
        String sql = "SELECT * from FIRMY f LEFT JOIN KLIENCI k ON f.nr_klienta=k.nr_klienta LEFT JOIN TELEFONY t ON f.nr_zbioru_telefonow = t.nr_zbioru_telefonow";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Firma.class));
    }
    public void save(Firma firma) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("firmy").usingColumns("nr_firmy", "nazwa", "nip", "regon", "krs", "nr_konta", "e_mail", "nr_klienta", "nr_adresu", "nr_zbioru_telefonow");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(firma);
        insertActor.execute(param);
    }
    public Firma get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM FIRMY f LEFT JOIN KLIENCI k ON f.nr_klienta=k.nr_klienta LEFT JOIN TELEFONY t ON f.nr_zbioru_telefonow = t.nr_zbioru_telefonow WHERE nr_firmy = " + args[0];
        Firma firma = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Firma.class));
        return firma;
    }
    public void update(Firma firma) {
        String sql = "UPDATE FIRMY SET nr_firmy=:nr_firmy, nazwa=:nazwa, nip=:nip, regon=:regon, krs=:krs, nr_konta=:nr_konta, e_mail=:e_mail, nr_klienta=:nr_klienta, nr_adresu=:nr_adresu, nr_zbioru_telefonow=:nr_zbioru_telefonow";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(firma);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM FIRMY WHERE nr_firmy = ?";
        jdbcTemplate.update(sql, id);
    }
}
