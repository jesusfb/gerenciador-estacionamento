package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pessoa;

    @ManyToOne(targetEntity = Veiculo.class)
    private Veiculo veiculo;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Número do apartamento é obrigatório")
    private String apto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
}
