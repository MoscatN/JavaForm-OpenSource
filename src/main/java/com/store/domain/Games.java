package com.store.domain;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import java.io.Serializable; 
import org.springframework.lang.Nullable;

@Data
@Entity
@Table(name = "Games")
public class Games implements Serializable
{    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GameID;
    private String Title;
    private String Genre;       //DropDownList
    private Date Release_Date;
    private String Image;
    private String Video;
    private Boolean Available;
}
