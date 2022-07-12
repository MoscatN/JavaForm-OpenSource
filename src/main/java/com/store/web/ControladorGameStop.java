package com.store.web;
import com.store.domain.Games;
import java.util.List;
import com.store.service.GamesServices;
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

    @GetMapping("/games")
    public String home(Model model)
    {
        List<Games> games = gamesServices.GamesList();
        log.info("Running...");         //Console message
        model.addAttribute("games", games);
        return "Games";
    }

    @GetMapping("/games/Create")
    public String create(Games games)
    {
        return "ModifyGame";
    }
    @PostMapping("/games/save")
    public String save(Games games)
    {
        gamesServices.save(games);
        return "redirect:/games";
    }

    @GetMapping("/games/edit/{GamesID}")
    public String edit(Games games, Model model)
    {
        games = gamesServices.findGames(games);
        model.addAttribute("games", games);
        return "ModifyGame";
    }

    @GetMapping("/games/delete/{GamesID}")
    public String delete(Games games)
    {
        gamesServices.delete(games);
        return "redirect:/games";
    }
}
