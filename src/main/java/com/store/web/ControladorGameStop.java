package com.store.web;

import com.store.dao.GamesDao;
import com.store.domain.Games;
import java.util.List;
import com.store.service.GamesServices;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
public class ControladorGameStop {

    @Autowired
    private GamesServices gamesServices;
    
    @Autowired 
    private GamesDao repo; 

    @GetMapping("/games")
    public String home(Model model) {
        List<Games> games = gamesServices.GamesList();
        log.info("Running...");         //Console message
        model.addAttribute("games", games);
        return "Games";
    }

    @GetMapping("/games/Create")
    public String create(Games games) {
        return "ModifyGame";
    }

    @PostMapping("/games/save")
    public RedirectView save(Games games, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        games.setImage(fileName);
        
        Games savedGames = repo.save(games); 
        String uploadDir = "games-photos/" + savedGames.getGamesID();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
       
        return new RedirectView("/games", true);
    }

    @GetMapping("/games/edit/{GamesID}")
    public String edit(Games games, Model model) {
        games = gamesServices.findGames(games);
        model.addAttribute("games", games);
        return "ModifyGame";
    }

    @GetMapping("/games/delete/{GamesID}")
    public String delete(Games games) {
        gamesServices.delete(games);
        return "redirect:/games";
    }
}