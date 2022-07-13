package com.store.service;

import com.store.domain.Games;
import com.store.dao.GamesDao;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GamesServicesImpl implements GamesServices{
    private final Path root = Paths.get("uploads"); 
    @Autowired
    private GamesDao gamesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Games> GamesList()
    {
        return (List<Games>) gamesDao.findAll();
    }

    @Override
    @Transactional()
    public void save(Games games)
    {
        gamesDao.save(games);
    }
    @Override
    @Transactional()
    public void delete(Games games)
    {
        gamesDao.delete(games);
    }
    @Override
    @Transactional(readOnly = true)
    public Games findGames(Games games)
    {
        return gamesDao.findById(games.getGamesID()).orElse(null);
    }
}
