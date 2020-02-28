import edu.unama.entidades.Cliente;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTeste {
    Cliente c;
    
    public ClienteTeste() {
        c = new Cliente();
    } 
        
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void informarEmailValido() {
       boolean respostaF = c.validarEmail("sememail.com");
        assertEquals(false, respostaF);
        
        boolean respostaV = c.validarEmail("sem@email.com");
        assertEquals(true, respostaV);
    }
    
    @Test 
    public void informarCpfValido(){
        String resultado = c.validarCpf("11122233344");
        assertEquals("cpf valido", resultado);
    }
    
    @Test
    public void informarNomeValido(){
        String resultado = c.validarNome("matheus");
        assertEquals("verdadeiro", resultado);
    }
}
