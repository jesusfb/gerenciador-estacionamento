package marhlonkorb.github.io.gerenciadorestacionamento.validador.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmailValidadorTest {

    final IEmailValidador iEmailValidador = new EmailValidador();

    @Test
    void deveLancarExceptionQuandoEmailForNulo(){
        // Assertiva para verificar que a exceção esperada foi lançada
        Exception exception = assertThrows(RuntimeException.class, () -> iEmailValidador.validar(null));
        // Verifica se a mensagem da exceção é a esperada
        assertEquals("E-mail é obrigatório.", exception.getMessage());
    }

    @Test
    void deveLancarExceptionQuandoEmailForVazio(){
        // Assertiva para verificar que a exceção esperada foi lançada
        Exception exception = assertThrows(RuntimeException.class, () -> iEmailValidador.validar(""));
        // Verifica se a mensagem da exceção é a esperada
        assertEquals("E-mail é obrigatório.", exception.getMessage());
    }

    @Test
    void deveLancarExceptionQuandoFormatoEmailForInvalido(){
        // Assertiva para verificar que a exceção esperada foi lançada
        Exception exception = assertThrows(RuntimeException.class, () -> iEmailValidador.validar("teste"));
        // Verifica se a mensagem da exceção é a esperada
        assertEquals("Formato de e-mail inválido.", exception.getMessage());
    }

    @Test
    void naoDeveLancarExceptionQuandoFormatoEmailForValido(){
        // Verifica que nenhuma exceção foi lançada
        assertDoesNotThrow(() -> iEmailValidador.validar("teste@teste.com"));
    }
}
