package com.kknd.repository;

import com.kknd.model.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by root on 05/02/17.
 */
public interface TVShowRepository extends JpaRepository<TVShow,Long> {
    TVShow findById(Integer id);
//    List<TVShow> findAll();
}
