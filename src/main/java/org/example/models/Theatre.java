package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final Integer id ;
    private final String name ;
    List<Screen> screens ;

    public Theatre(Integer id, String name) {
        this.id = id ;
        this.name = name ;
        this.screens = new ArrayList<>();
    }

    public void addScreens(Screen screen) {
        this.screens.add(screen) ;
    }

}
