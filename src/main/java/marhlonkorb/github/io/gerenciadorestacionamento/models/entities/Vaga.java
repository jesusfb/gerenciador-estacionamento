package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Getter
@Setter
@Entity
public class Vaga {

    @Id
    @Min(value = 1)
    @Max(value = 200)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_lista;

    @OneToOne(targetEntity = Veiculo.class, cascade = CascadeType.ALL)
    private Veiculo veiculo;

}
