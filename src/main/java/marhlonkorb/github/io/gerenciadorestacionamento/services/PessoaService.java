package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.List;
import java.util.Optional;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    /**
     * Adiciona novo cadastro de pessoa se ainda não existir
     *
     * @param pessoa
     */
    public void adicionarPessoa(Pessoa pessoa) {
        if(pessoa.getId_pessoa() != null){
            ResponseEntity.badRequest().body("Registro já existe.");
            return;
        }
        pessoaRepository.save(pessoa);
    }

    /**
     * Retorna lista de pessoas cadastradas
     *
     * @return
     */
    public List<Pessoa> getlistpessoa() {
        return pessoaRepository.findAll();
    }
    
    
    /**
     * Retorna a pessoa pelo id
     *
     * @param id
     * @return Pessoa
     */
    public Pessoa getpessoaPeloId(Integer id) {
        return pessoaRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Pessoa não encontrada."));
    }

    /**
     * Verifica se a pessoa com o Id passado está cadastrada
     *
     * @param id
     * @return boolean
     */
    private boolean isPessoaCadastrada(Integer id) {
        return pessoaRepository.existsById(id);
    }

    /**
     * Exclui cadastro de pessoa se existir o id da pessoa
     *
     * @param id
     */
    public ResponseEntity<?> excluirPessoa(Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent()){
        pessoaRepository.deleteById(id);
        return ResponseEntity.ok("Registro excluído com sucesso.");
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Altera o cadastro da pessoa
     *
     * @param id
     * @param pessoa
     */
    public void alterarCadastroPessoa(Integer id, Pessoa pessoa) {
        if(isPessoaCadastrada(id)){
        excluirPessoa(id);
        pessoa.setId_pessoa(id);
        adicionarPessoa(pessoa);
            ResponseEntity.ok("Registro alterado com sucesso");
        }
        
        else{
            ResponseEntity.notFound().build();
        }
    }

    /**
     * Verifica se uma pessoa tem veículo cadastrado
     *
     * @param pessoa
     * @return boolean
     */
    private boolean temVeiculoCadastrado(Pessoa pessoa, Veiculo veiculo) {
        return pessoaRepository.findAll().contains(pessoa.getVeiculo().
                equals(veiculoRepository.findAll()
                        .equals(veiculo)));
    }

    /**
     * Adiciona um veiculo ao cadastro do cliente se o veículo está cadastrado
     *
     * @param veiculo
     * @param pessoa
     */
    public void adicionarVeiculoCadastrado(Veiculo veiculo, Pessoa pessoa) {
        if (isPessoaCadastrada(pessoa.getId_pessoa()) && !temVeiculoCadastrado(pessoa, veiculo)) {
            pessoa.setVeiculo(veiculo);
            alterarCadastroPessoa(pessoa.getId_pessoa(), pessoa);
        } else {
            System.out.println("Não foi possível adicionar o registro ao cadastro da pessoa.");
        }
    }

    /**
     * Mock da inserção de um novo usuário para testar funcionamento do insert
     *
     * @param args
     * @throws Exception
     */
    /*public void run(String... args) throws Exception {

        Pessoa pessoa = new Pessoa(null, null,
                "Marhlon", "03187153097", "103",LocalDate.now(), "51997948382");

        pessoaRepository.save(pessoa);
    }*/
}
