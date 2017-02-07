package com.kknd.services;

import com.kknd.model.Season;
import com.kknd.model.TVShow;
import com.kknd.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by root on 06/02/17.
 */

@Service
public class SeasonServiceImpl implements SeasonService{

    @Autowired
    SeasonRepository seasonRepository;

    public Season findOne(int tvid,int id){
        return null;
        //return seasonRepository.findOne(tvid, id);
    }


}
