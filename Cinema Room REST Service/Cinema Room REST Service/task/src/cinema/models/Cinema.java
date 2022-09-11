package cinema.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cinema")
public class Cinema {

    private @Id @GeneratedValue Long id;
    private String name;
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Scene> sceneList;

}
