package ru.bagaev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.bagaev.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }


    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(Person.class))
                        .stream().findAny().orElse(null);
    }


    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name, age) VALUES (?, ?)",
                person.getName(), person.getAge());
    }

    public void update(int id, Person updatedPerson) {

       jdbcTemplate.update("UPDATE Person SET name=?, age=? WHERE person_id = ?", updatedPerson.getName(),
               updatedPerson.getAge(), id);

    }

    public void delete(int id) {
       jdbcTemplate.update("DELETE FROM Person WHERE person_id = ?", id);
    }

}
