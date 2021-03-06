package com.kknd.controllers;

import com.kknd.model.TVShow;
import com.kknd.services.TVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by root on 05/02/17.
 */


@RestController
@RequestMapping("tvshow")
public class TVShowController {

    @Autowired
    private TVShowService tvShowService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<String> findAll(){
            return tvShowService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public TVShow findOne(
            @PathVariable("id") String id){

            return tvShowService.findOne(id);
    }

}
