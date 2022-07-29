package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @Column(length = 200)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pessoa;

    @ManyToOne(targetEntity = Veiculo.class)
    private Veiculo veiculo;

    @Column(length = 200)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(length = 15)
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    private int apartamento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String data_nascimento;

    @Column(length = 14)
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

}
