package marhlonkorb.github.io.gerenciadorestacionamento.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(mappedBy = "placa_veiculo")
    private Collection<Veiculo> placa_veiculo;
    
    @OneToMany(mappedBy = "id_vaga")
    private Collection<Estacionamento> id_vaga;
    
    @Column(length = 200)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @Column(length = 15)
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    
    private int apartamento;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date data_nascimento;
    
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
    
    
}
