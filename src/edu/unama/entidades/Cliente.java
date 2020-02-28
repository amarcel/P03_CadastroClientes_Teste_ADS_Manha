
package edu.unama.entidades;

import br.com.caelum.stella.validation.CPFValidator;
import br.unama.bd.SQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.validator.routines.EmailValidator;

public class Cliente {
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    
    public boolean criarTabCliente() {
        try {
            Connection conexao = SQLite.conectar();
            System.out.println("Criando tabela de cliente...");
            Statement sentenca = conexao.createStatement();

            // criando uma tabela
            sentenca.execute("CREATE TABLE IF NOT EXISTS tab_cliente( "
                    + "codigo INTEGER, "
                    + "nome VARCHAR(200), "
                    + "cpf VARCHAR(14), "
                    + "email VARCHAR(100) "
                    + ")");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean inserirCliente() {
        try {
            Connection conexao = SQLite.conectar();
            PreparedStatement sentenca = conexao.prepareStatement("INSERT INTO tab_cliente "
                    + "( nome, cpf, email ) "
                    + "VALUES (?,?,?)");
            sentenca.setString(1, this.nome);
            sentenca.setString(2, this.cpf);
            sentenca.setString(3, this.email);
            
            sentenca.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
        return false;
    }
    
    public void selecionarClientes() {
        try {
            Connection conexao = SQLite.conectar();
            PreparedStatement sql = conexao.prepareStatement("select * from tab_cliente");
            ResultSet resultSet = sql.executeQuery();
             while (resultSet.next()) {
                Integer cod  = resultSet.getInt("codigo");
                String nome  = resultSet.getString("nome");
                String cpf   = resultSet.getString("cpf");
                String email = resultSet.getString("email");

                System.out.println( cod + " | " + nome + " | " + cpf + " | " + email);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (validarCpf(cpf)==true){
            this.cpf = cpf;
        }else{
            throw new Exception("CPF inválido"); 
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
       if (emailValidator(email)==true){
        this.email = email;
       }else{
        throw new Exception("Email inválido");   
       }
    }
    
    public boolean emailValidator(String email){
        return EmailValidator.getInstance().isValid(email);
    }
    
    public boolean validarCpf(String cpf){
        CPFValidator cpfValidator = new CPFValidator(); 
        try{ cpfValidator.assertValid(cpf); 
            return true; 
        }catch(Exception e){ 
            return false; 
        } 
    }
    
   public boolean validarNome(String nome){
       String nomeV = nome;
       if(nomeV.length() < 5){ 
          return false; 
       }else{
           return true;
       }
       
    }
   
    
}
