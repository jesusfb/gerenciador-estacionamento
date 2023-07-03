package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Input da entidade Veiculo
 */
public class VeiculoInputMapper {

    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private String ano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
