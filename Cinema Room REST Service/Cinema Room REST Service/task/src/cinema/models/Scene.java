package cinema.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "scene")
public class Scene {

    private @Id
    @GeneratedValue Long id;
    int sceneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    private Cinema cinema;

    @OneToMany(mappedBy = "scene", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Seat> seats;

}
