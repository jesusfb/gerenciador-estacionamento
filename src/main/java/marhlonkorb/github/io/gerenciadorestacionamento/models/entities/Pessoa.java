package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pessoa;

    @ManyToOne(targetEntity = Veiculo.class)
    private Veiculo veiculo;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    private String apto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

}
