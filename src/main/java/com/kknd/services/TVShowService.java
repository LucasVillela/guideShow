package com.kknd.services;

import com.kknd.model.TVShow;

import java.util.List;

/**
 * Created by root on 05/02/17.
 */
public interface TVShowService {
    TVShow findOne(String id);
    List<String> findAll();
}
