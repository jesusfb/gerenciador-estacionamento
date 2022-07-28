package marhlonkorb.github.io.gerenciadorestacionamento.data.entities;

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
    
    @ManyToOne(targetEntity = Pessoa.class)
    private Integer id_pessoa;
    
    @OneToOne(targetEntity = Veiculo.class, cascade = CascadeType.ALL)
    private String placa_veiculo;
    
}
