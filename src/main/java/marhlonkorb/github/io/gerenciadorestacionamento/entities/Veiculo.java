package marhlonkorb.github.io.gerenciadorestacionamento.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
public class Veiculo {
    
    @Id
    @NotBlank
    @Column(length = 9)
    private String placa_veiculo;
    
    @NotBlank
    @Column(length = 50)
    private String marca;
    
    @NotBlank
    @Column(length = 100)
    private String modelo;
    
    @NotBlank
    @JsonFormat(pattern = "yyyy")
    private Date ano;
    
}
