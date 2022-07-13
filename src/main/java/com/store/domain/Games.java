package com.store.domain;

import javax.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Games")
public class Games implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id 
    private Long GamesID;
    private String Title;
    private String Release_Date;
    @Column(length = 64, nullable = true)
    private String Image;
    @Column(length = 64, nullable = true)
    private String Video;
    private String Available;
    private String Genre;               //DropDownList

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    @Transient
    public String getGameImagePath()
    {
        if(Image == null || GamesID == null) return null;
        
        return "/games-photos/" + GamesID + "/" + Image;
    }
}
