package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import java.util.List;
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
public class Estacionamento {

    @Id
    @Min(value = 1)
    @Max(value = 200)
    private List id_vaga;

    @OneToOne(targetEntity = Veiculo.class, cascade = CascadeType.ALL)
    private Veiculo veiculo;

}
