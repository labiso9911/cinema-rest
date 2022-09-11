package cinema.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    @GetMapping("/seats")
    public String getSeats() {
        return "test";
    }


}
