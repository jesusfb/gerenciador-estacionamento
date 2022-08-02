package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_veiculo;

    @NotBlank(message = "A placa do veículo deve ser informada")
    private String placa;

    @ManyToOne(targetEntity = Pessoa.class)
    private Pessoa pessoa;

    @NotBlank(message = "A marca do veículo é obrigatória informar")
    private String marca;

    @NotBlank(message = "O modelo do veículo é obrigatório informar")
    private String modelo;

    @JsonFormat(pattern = "yyyy")
    private Date ano;
}
