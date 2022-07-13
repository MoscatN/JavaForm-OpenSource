package com.store.service;

import java.util.List;
import com.store.domain.Games;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface GamesServices {
    public List<Games> GamesList();
    
    public void save(Games games);
    
    public void delete(Games games);
    
    public Games findGames(Games games);
}
