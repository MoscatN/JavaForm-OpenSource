package com.store.gamestop.dao;

import com.store.gamestop.domain.Games;
import org.springframework.data.repository.CrudRepository;

public interface GamesDao extends CrudRepository<Games, Long>{

}
