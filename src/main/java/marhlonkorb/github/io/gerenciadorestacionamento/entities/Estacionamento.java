package marhlonkorb.github.io.gerenciadorestacionamento.entities;

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
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Pessoa id_pessoa;
    
    @OneToOne(targetEntity = Veiculo.class)
    private Veiculo placa_veiculo;
}
