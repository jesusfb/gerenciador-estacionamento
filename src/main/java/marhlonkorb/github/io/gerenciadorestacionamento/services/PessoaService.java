package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    VeiculoService veiculoService;

    /**
     * Adiciona novo cadastro de pessoa se ainda não existir
     *
     * @param pessoa
     */
    public void adicionarPessoa(Pessoa pessoa) {
        if (!pessoaRepository.existsById(pessoa.getId_pessoa())) {
            pessoaRepository.save(pessoa);
        }
    }

    private boolean isPessoaCadastrada(Integer id) {
        return pessoaRepository.existsById(id);
    }

    /**
     * Retorna objeto do tipo pessoa se existir
     *
     * @param Id
     * @return Optiona<Pessoa>
     */
    /**
     * Exclui cadastro de pessoa se existir o id da pessoa
     *
     * @param pessoa
     */
    public void excluirPessoa(Pessoa pessoa) {
        pessoaRepository.findAll().
                removeIf(Pessoa -> pessoa.getId_pessoa().equals(Pessoa.getId_pessoa()));
    }

    /**
     * Altera o cadastro da pessoa
     *
     * @param id
     * @param pessoa
     */
    public void alterarCadastroPessoa(Integer id, Pessoa pessoa) {
        excluirPessoa(pessoa);
        pessoa.setId_pessoa(id);
        adicionarPessoa(pessoa);
    }

    /**
     * Verifica se uma pessoa tem veículo cadastrado
     *
     * @param pessoa
     * @return boolean
     */
    public boolean temVeiculoCadastrado(Pessoa pessoa, Veiculo veiculo) {
        return pessoaRepository.findAll().contains(pessoa.getPlaca_veiculo().equals(veiculo.getPlaca_veiculo()));
    }

    /**
     * Adiciona uma placa de veículo ao cadastro do cliente
     *
     * @param veiculo
     * @param pessoa
     */
    public void adicionarVeiculoCadastrado(Veiculo veiculo, Pessoa pessoa) {
        if (isPessoaCadastrada(pessoa.getId_pessoa()) && veiculoService.isVeiculoCadastrado(veiculo.getPlaca_veiculo())) {
            pessoa.setPlaca_veiculo(veiculo.getPlaca_veiculo());
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
    public void run(String... args) throws Exception {

        Pessoa pessoa = new Pessoa(null, null, null,
                "Marhlon", "03187153097", 103,
                "13/05/95", "51997948382");

        //pessoaRepository.save(pessoa);
    }
}
