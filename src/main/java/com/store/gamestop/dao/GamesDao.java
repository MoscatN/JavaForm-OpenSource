package com.store.gamestop.dao;

import com.store.gamestop.domain.Games;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesDao extends CrudRepository<Games, Long>{

}
