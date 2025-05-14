package com.firstgroup.gamemanagerapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok
            ("""
                    DEVELOPERS OF THE FIRST GROUP'S GAME MANAGER API\
                    
                    ISAIAH RAPHAEL ALMUENA\
                    
                    PRINZ EDWARD LIKIYAN DUCYOGEN\
                    
                    CARLO MIGUEL GERONIMO\
                    
                    JOHN DRAY BUENAVENTURA LAO\
                    
                    YNGWIE SEBASTIAN GARCIA PATRICIO\
                    
                    DIANE SHANE LLORCA OMAPAS\
                    
                    LHAY ANN BAÑO ZAÑO""");
    }
}
