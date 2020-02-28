/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.unama.entidades.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marcel
 */
public class ClienteTeste {
    
    Cliente c;
    
    public ClienteTeste() {
        c = new Cliente();
    }
    
    @Test
    public void validacaoEmail(){
        assertEquals(true, c.emailValidator("algo@gmail.com"));
    }
    @Test
    public void validacaoEmailSemArroba(){
        assertEquals(false, c.emailValidator("algogmail.com"));
    }
    @Test
    public void validacaoEmailVazio(){
        assertEquals(false, c.emailValidator(""));
    }
    @Test
    public void validacaoEmailSemPontoCom(){
        assertEquals(false, c.emailValidator("algo@gmail"));
    }
    @Test
    public void validacaoCPF(){
        assertEquals(true, c.validarCpf("133.657.032-68"));
    }
    @Test
    public void validacaoCPFVazio(){
        assertEquals(false, c.validarCpf(""));
    }
    @Test
    public void validacaoCPFIncorreto(){
        assertEquals(false, c.validarCpf("1440340304"));
    }
    @Test
    public void validacaoNome(){
        assertEquals(true, c.validarNome("Kelly"));
    }
    @Test
    public void validacaoNomeNumero(){
        assertEquals(false, c.validarNome("el1y"));
    }
    
}
