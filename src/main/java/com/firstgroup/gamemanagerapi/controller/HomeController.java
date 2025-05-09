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
            ("DEVELOPERS OF THE FIRST GROUP'S GAME MANAGER API"
                + "\nISAIAH RAPHAEL ALMUENA"
                + "\nPRINZ EDWARD LIKIYAN DUCYOGEN"
                + "\nCARLO MIGUEL GERONIMO"
                + "\nJOHN DRAY BUENAVENTURA LAO"
                + "\nYNGWIE SEBASTIAN GARCIA PATRICIO"
                + "\nDIANE SHANE LLORCA OMAPAS"
                + "\nLHAY ANN BAÑO ZAÑO");
    }
}
