package com.kknd.services;

import com.kknd.config.Constants;
import com.kknd.model.Episode;
import com.kknd.model.Season;
import com.kknd.model.TVShow;
import com.kknd.repository.TVShowRepository;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.TmdbTvEpisodes;
import info.movito.themoviedbapi.TmdbTvSeasons;
import info.movito.themoviedbapi.model.tv.TvEpisode;
import info.movito.themoviedbapi.model.tv.TvSeason;
import info.movito.themoviedbapi.model.tv.TvSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 05/02/17.
 */


@Service
public class TVShowServiceImpl implements TVShowService{

    @Autowired
    private TVShowRepository tvShowRepository;


    public TVShow findOne(int id){
        TVShow tvShow = tvShowRepository.findById(id);
        if(tvShow == null){
            this.populateTvShow(id);
            tvShow = tvShowRepository.findById(id);
        }
        return tvShow;
    }

    private void populateTvShow(int id){

        TmdbApi tmdbApi = new TmdbApi(Constants.API_KEY);
        TmdbTV tvSeries = tmdbApi.getTvSeries();
        TmdbTvEpisodes episodes = tmdbApi.getTvEpisodes();
        TmdbTvSeasons seasons = tmdbApi.getTvSeasons();
        TvSeries showFound = tvSeries.getSeries(id,"en");
        List<Season> seasonList = new ArrayList<>();

        //Monta TvShow
        TVShow tvShow = new TVShow();
        tvShow.setName(showFound.getName());
        tvShow.setId(showFound.getId());
        tvShow.setNumberOfSeasons(showFound.getNumberOfSeasons());
        tvShow.setOverview(showFound.getOverview());
        tvShow.setPoster(showFound.getPosterPath());

        //Monta lista temporadas
        showFound.getSeasons().forEach(item -> {
            TvSeason tvSeason = seasons.getSeason(id,item.getSeasonNumber(),"en");
            Season season = new Season();
            season.setId(tvSeason.getId());
            season.setEpisodeCount(tvSeason.getEpisodes().size());
            season.setSeasonNumber(tvSeason.getSeasonNumber());
            season.setPoster(tvSeason.getPosterPath());
            List<Episode> episodeList = new ArrayList<>();

            //Monta lista episodios
            tvSeason.getEpisodes().forEach(index -> {
                TvEpisode tvEpisode = episodes.getEpisode(id,season.getSeasonNumber(),index.getEpisodeNumber(),"en");
                Episode episode = new Episode();
                episode.setId(tvEpisode.getId());
                episode.setPoster(tvEpisode.getStillPath());
                episode.setEpisodeName(tvEpisode.getName());
                episode.setOverview(tvEpisode.getOverview());
                episode.setEpisodeNumber(tvEpisode.getEpisodeNumber());
                episodeList.add(episode);
            });
            season.setEpisodeList(episodeList);
            seasonList.add(season);
        });

        tvShow.setSeasonList(seasonList);

        tvShowRepository.save(tvShow);
    }
}
