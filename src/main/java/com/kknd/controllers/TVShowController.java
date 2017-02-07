package com.kknd.controllers;

import com.kknd.model.TVShow;
import com.kknd.services.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by root on 05/02/17.
 */


@RestController
@RequestMapping("tvshow")
public class TVShowController {

    @Autowired
    private TVShowService tvShowService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public TVShow findOne(
            @PathVariable("id") int id){

            return tvShowService.findOne(id);
    }

}
