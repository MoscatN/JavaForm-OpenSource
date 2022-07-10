package com.store.gamestop.service;

import java.util.List;
import com.store.gamestop.domain.Games;

public interface GamesServices {
    public List<Games> GamesList();
    public void save(Games games);
    public void delete(Games games);
    public Games findGames(Games games);
}
