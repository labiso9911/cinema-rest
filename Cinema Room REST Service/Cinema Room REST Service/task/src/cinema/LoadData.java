package cinema;

import cinema.models.Cinema;
import cinema.models.Scene;
import cinema.models.Seat;
import cinema.repositories.CinemaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(CinemaRepository cinemaRepository) {

        List<Seat> seats = new ArrayList<>();

        for (int i = 1; i > 10; i++){
            for (int y = 1; y > 10; y++){
                Seat seat = new Seat();
                seat.setRow(i);
                seat.setColumn(y);
                seats.add(seat);
            }
        }


        Cinema cinema = new Cinema();
        cinema.setName("Lasses super cinema");
        List<Scene> scenes = new ArrayList<>();
        Scene scene1 = new Scene();
        scene1.setSceneNumber(1);
        scene1.setSeats(seats);
        scenes.add(scene1);
        cinema.setSceneList(scenes);
        return args -> {
            log.info("preloading " + cinemaRepository.save(cinema));
        };
    }
}
