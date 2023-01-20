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
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pracownik> findAll(){
        String sql = "SELECT * from PRACOWNICY p LEFT OUTER JOIN ADRESY a ON p.nr_adresu = a.nr_adresu LEFT OUTER JOIN TELEFONY t ON p.nr_zbioru_telefonow = t.nr_zbioru_telefonow NATURAL JOIN STANOWISKA";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
    }
    public void save(Pracownik pracownik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("nr_pracownika", "imie", "nazwisko", "data_urodzenia", "plec", "pesel", "data_zatrudnienia", "nr_konta", "e_mail", "nr_salonu", "nr_serwisu", "nr_adresu", "nr_zbioru_telefonow", "nr_stanowiska");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }
    public Pracownik get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM PRACOWNICY p LEFT OUTER JOIN ADRESY a ON p.nr_adresu = a.nr_adresu LEFT OUTER JOIN TELEFONY t ON p.nr_zbioru_telefonow = t.nr_zbioru_telefonow NATURAL JOIN STANOWISKA WHERE nr_pracownika = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }
    public void update(Pracownik pracownik) {
        String sql = "UPDATE PRACOWNICY SET nr_pracownika=:nr_pracownika, imie=:imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, pesel=:pesel, data_zatrudnienia=:data_zatrudnienia, nr_konta=:nr_konta, e_mail=:e_mail, nr_salonu=:nr_salonu, nr_serwisu=:nr_serwisu, nr_adresu=:nr_adresu, nr_zbioru_telefonow=:nr_zbioru_telefonow, nr_stanowiska=:nr_stanowiska WHERE nr_pracownika=:nr_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM PRACOWNICY WHERE nr_pracownika = ?";
        jdbcTemplate.update(sql, id);
    }
}
