package com.kknd.controllers;

import com.kknd.model.Season;
import com.kknd.services.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by root on 05/02/17.
 */

@RestController
public class SeasonController {

    @Autowired
    SeasonService seasonService;

    @RequestMapping(value = "tvshow/{tvid}/season/{id}",method = RequestMethod.GET)
    public Season findOne(
            @PathVariable("tvid") int tvid,
            @PathVariable("id") int id){

        return seasonService.findOne(tvid, id);
    }

}
