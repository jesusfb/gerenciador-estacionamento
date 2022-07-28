package marhlonkorb.github.io.gerenciadorestacionamento.models.services;

import marhlonkorb.github.io.gerenciadorestacionamento.data.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.services.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service
public class PessoaService implements CommandLineRunner {
    
    @Autowired
    PessoaRepository pessoaRepository;
    
    /**
     * Adiciona novo cadastro de pessoa se ainda não existir
     * @param pessoa
     */
    public void adicionarPessoa(Pessoa pessoa){
        if(!pessoaRepository.existsById(pessoa.getId_pessoa())){
            pessoaRepository.save(pessoa);
        }
        
    }
    
    /**
     * Excluir cadastro de pessoa se existir o id da pessoa
     * @param pessoa
     */
    public void excluiPessoa(Pessoa pessoa){
        if(pessoaRepository.existsById(pessoa.getId_pessoa())){
            pessoaRepository.delete(pessoa);
        }
    }
    
    /**
     * Altera o cadastro da pessoa
     * @param id
     * @param pessoa
     */
    public void alterarCadastroPessoa(Integer id, Pessoa pessoa){
        if(pessoaRepository.existsById(pessoa.getId_pessoa())) {
            pessoa.setId_pessoa(id);
            adicionarPessoa(pessoa);
        } else {
            System.out.println("Pessoa não cadastrada");
        }
    }
    
    /**
     * Retorna uma lista do tipo Pessoa caso existam registros no banco
     * @return Object
     */
    public Object getListPessoa(){
        if (pessoaRepository.count() == 0){
            return null;
        }
        return pessoaRepository.findAll();
    }
    
    /**
     * Mock da inserção de um novo usuário para testar funcionamento do insert
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception{
        
        Pessoa pessoa = new Pessoa(null, null, null,
                "Marhlon", "03187153097", 103,
                "13/05/95", "51997948382");
        pessoaRepository.save(pessoa);
    }
    
}


