package com.kknd.repository;

import com.kknd.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by root on 06/02/17.
 */
public interface SeasonRepository extends JpaRepository<Season,Long> {
}
