package com.store.dao;

import com.store.domain.Games;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;


public interface GamesDao extends CrudRepository<Games, Long>{

}
