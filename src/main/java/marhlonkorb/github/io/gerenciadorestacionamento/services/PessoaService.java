package marhlonkorb.github.io.gerenciadorestacionamento.services;

import java.util.List;
import java.util.Optional;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @return pessoa
     */
    public Pessoa adicionarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
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
    public Optional<Pessoa> getpessoaPeloId(Integer id) {
        if (pessoaRepository.existsById(id)) {
            return pessoaRepository.findById(id);
        }
        return null;
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
     * @return ResponseEntity
     */
    public boolean excluirPessoa(Integer id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Altera o cadastro da pessoa
     *
     * @param id
     * @param pessoa
     */
    public Pessoa alterarCadastroPessoa(Integer id, Pessoa pessoa) {
        if (isPessoaCadastrada(id)) {
            pessoa.setId_pessoa(id);
            pessoaRepository.save(pessoa);
            return pessoa;
        }
        return null;
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
