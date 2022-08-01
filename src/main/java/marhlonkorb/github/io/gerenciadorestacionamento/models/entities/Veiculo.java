package marhlonkorb.github.io.gerenciadorestacionamento.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
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
    @JoinColumn(table = "pessoa", referencedColumnName = "id_veiculo")
    private Integer id_veiculo;

    @ManyToOne(targetEntity = Pessoa.class)
    private Pessoa pessoa;

    @NotBlank(message = "A marca do veículo é obrigatória informar")
    @Column(length = 40)
    private String marca;

    @NotBlank(message = "O modelo do veículo é obrigatório informar")
    @Column(length = 20)
    private String modelo;

    @NotBlank(message = "O ano do veículo é obrigatório informar")
    @JsonFormat(pattern = "yyyy")
    private Date ano;

}
