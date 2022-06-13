package org.example.ch6;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SingerDaoJdbcTemplate implements SingerDao {
  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Singer> findAll() {
    return null;
  }

  @Override
  public List<Singer> findByFirstName(String firstName) {
    return null;
  }

  @Override
  public String findNameById(Long id) {
    return this.jdbcTemplate.queryForObject(
        "select first_name || ' ' || last_name from singer where id = ?",
        String.class,
        1);
  }

  @Override
  public String findLastNameById(Long id) {
    return null;
  }

  @Override
  public String findFirstNameById(Long id) {
    return null;
  }

  @Override
  public void insert(Singer singer) {

  }

  @Override
  public void update(Singer singer) {

  }

  @Override
  public void delete(Long singerId) {

  }

  @Override
  public List<Singer> findAllWithAlbums() {
    return null;
  }

  @Override
  public void insertWithAlbum(Singer singer) {

  }
}
