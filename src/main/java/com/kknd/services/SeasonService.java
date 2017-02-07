package com.kknd.services;

import com.kknd.model.Season;

/**
 * Created by root on 06/02/17.
 */
public interface SeasonService {
    Season findOne(int tvid, int id);
}
