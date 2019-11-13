package model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Elais Pedro
 */
public class Usuario {
    //Atributos
    private int codigo;
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    private String telefone;
    private String foto;
    
    //Construtores
    public Usuario(int codigo, String nome, String usuario, String email, String senha, String telefone, String foto){
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setUsuario(usuario);
        this.setEmail(email);
        this.setSenha(senha);
        this.setTelefone(telefone);
        this.setFoto(foto);
    }
    
    public Usuario(){
        
    }

    //Métodos getters e setters
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
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
    
    public ArrayList<Usuario> buscaDadosUsuario(int codigoUsuario){
        ArrayList<Usuario> dadosUsuario = null;
        URL url;
        System.out.println(codigoUsuario);
        try{
            url = new URL("http://143.106.241.1/cl18463/tcc/api/usuario/buscar/" + Integer.toString(codigoUsuario));
           HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            
            StringBuilder retorno = new StringBuilder();
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String linha;
            while((linha = entrada.readLine()) != null){
                retorno.append(linha);
            }
            entrada.close();
            conexao.disconnect();
            
            Gson gson = new Gson();
            System.out.println(retorno);
            JsonObject js = gson.fromJson(retorno.toString(), JsonObject.class);
            JsonArray jsonArray = js.getAsJsonArray("dados");
            


            Type typeDadosUsuario = new TypeToken<ArrayList<Usuario>>(){}.getType();
            dadosUsuario = gson.fromJson(jsonArray, typeDadosUsuario);
        }catch(MalformedURLException ex){
            System.out.println("ERRO: " + ex);
        }catch(IOException ex){
            System.out.println("ERRO: " + ex);
        }
        
        
        
        return dadosUsuario;
    }
    
}

