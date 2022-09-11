package cinema.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "seat")
public class Seat {
    private @Id @GeneratedValue Long id;
    int row;
    int column;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "scene_id", referencedColumnName = "id")
    private Scene scene;
}
