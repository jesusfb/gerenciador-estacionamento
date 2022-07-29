package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class Estacionamento {

    @Id
    private Integer id_vaga;

    @OneToOne(targetEntity = Veiculo.class, cascade = CascadeType.ALL)
    private Veiculo veiculo;

}
