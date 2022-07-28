package marhlonkorb.github.io.gerenciadorestacionamento.data.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
public class Veiculo {
    
    @Id
    @NotBlank
    @Column(length = 9)
    @JoinColumn(table = "pessoa", referencedColumnName = "placa_veiculo")
    private String placa_veiculo;
    
    @NotBlank
    @Column(length = 40)
    private String marca;
    
    @NotBlank
    @Column(length = 20)
    private String modelo;
    
    @NotBlank
    @JsonFormat(pattern = "yyyy")
    private Date ano;
    
}
