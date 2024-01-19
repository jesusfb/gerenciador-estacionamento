package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.ProprietarioOutputMapper;

/**
 * Output da entidade Veiculo
 */
public class VeiculoOutputMapper {

    private Long id;

    private String placa;

    private String marca;

    private String modelo;

    private String ano;
    
    private Long idVaga;

    private ProprietarioOutputMapper proprietario;

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

    public Long getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Long idVaga) {
        this.idVaga = idVaga;
    }

    public ProprietarioOutputMapper getProprietario() {
        return proprietario;
    }

    public void setProprietario(ProprietarioOutputMapper proprietario) {
        this.proprietario = proprietario;
    }
}
