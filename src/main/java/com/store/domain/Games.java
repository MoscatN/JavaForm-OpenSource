package com.store.domain;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Entity
@Table(name = "Games")
public class Games {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long GameID;
    private String Title;
    private String Genre;       //DropDownList
    private Date Release_Date;
    @Nullable
    private String Image;
    @Nullable
    private String Video;
    @Nullable
    private Boolean Available;
}
