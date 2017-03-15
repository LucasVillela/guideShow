package com.kknd.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by root on 05/02/17.
 */
@Entity
public class TVShow {

    @Id
    private Integer id;
    private String name;
    private Integer numberOfSeasons;
    private String poster;
    @Column(length = 4096)
    private String overview;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Season> seasonList;

    public TVShow() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }
}
