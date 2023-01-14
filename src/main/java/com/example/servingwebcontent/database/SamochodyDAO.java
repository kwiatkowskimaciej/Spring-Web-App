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
public class SamochodyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public SalonyDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public List<Samochod> findAll(){
        String sql = "SELECT * from SAMOCHODY s LEFT OUTER JOIN MODELE m ON s.nr_modelu = m.nr_modelu";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Samochod.class));
    }
    public void save(Samochod samochod) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("samochody").usingColumns("nr_samochodu", "vin", "rok_produkcji", "typ_nadwozia", "rodzaj_silnika", "typ_napedu", "moc", "ilosc_osob", "poj_bagaznika", "nr_rejestracyjny", "kolor", "cena", "nr_fabryki", "nr_salonu", "nr_klienta", "nr_modelu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(samochod);
        insertActor.execute(param);
    }
    public Samochod get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM SAMOCHODY s LEFT OUTER JOIN MODELE m ON s.nr_modelu = n.nr_modelu WHERE nr_samochodu = " + args[0];
        Samochod samochod = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Samochod.class));
        return samochod;
    }
    public void update(Samochod samochod) {//zmienić
        String sql = "UPDATE SAMOCHODY SET nr_samochodu=:nr_samochodu, vin=:vin, rok_produkcji=:rok_produkcji, typ_nadwozia=:typ_nadwozia, rodzaj_silnika=:rodzaj_silnika, typ_napedu=:typ_napedu, moc=:moc, ilosc_osob=:ilosc_osob, poj_bagaznika=:poj_bagaznika, nr_rejestracyjny=:nr_rejestracyjny, kolor=:kolor, cena=:cena, nr_fabryki=:nr_fabryki, nr_salonu=:nr_salonu, nr_klienta=:nr_klienta, nr_modelu=:nr_modelu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(samochod);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int id) {
        String sql = "DELETE FROM SAMOCHODY WHERE nr_samochodu = ?";
        jdbcTemplate.update(sql, id);
    }
}
