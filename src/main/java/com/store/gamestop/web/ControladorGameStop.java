package com.store.gamestop.web;
import com.store.gamestop.domain.Games;
import java.util.List;

import com.store.gamestop.service.GamesServices;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorGameStop {
    @Autowired
    private GamesServices gamesServices;

    @GetMapping("/")
    public String home(Model model)
    {
        List<Games> games = gamesServices.GamesList();
        log.info("Running...");         //Console message
        model.addAttribute("games", games);
        return "index";
    }

    @GetMapping("/Create")
    public String create(Games games)
    {
        return "Modify";
    }
    @PostMapping("/save")
    public String save(Games games)
    {
        gamesServices.save(games);
        return "redirect:/";
    }

    @GetMapping("/edit/{GameID}")
    public String delete(Games games)
    {
        gamesServices.delete(games);
        return "redirect:/";
    }
}
