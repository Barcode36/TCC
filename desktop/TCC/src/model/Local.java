package model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
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
 * @author Pedror
 */
public class Local {
    private int cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    
    //Construtores
    public Local(int cep, String rua, String bairro, String cidade, String estado){
        this.setCep(cep);
        this.setRua(rua);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setEstado(estado);
    }
    
    
    public Local(){
        
    }
    
    //gettes e setters
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public ArrayList<Local> buscaEndereco(int codigoLocal){
        URL rest;
        ArrayList<Local> local = null;
        try{
            rest = new URL("http://143.106.241.1/cl18463/tcc/api/Endereco/buscar/" + Integer.toString(codigoLocal));
            HttpURLConnection conexao = (HttpURLConnection) rest.openConnection();
            
            
            StringBuilder retorno = new StringBuilder();
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String linha;
            while((linha = entrada.readLine()) != null){
                retorno.append(linha);
            }
            entrada.close();
            conexao.disconnect();
            
            Gson gson = new Gson();
            JsonObject js = gson.fromJson(retorno.toString(), JsonObject.class);
            JsonArray jsonArray = js.getAsJsonArray("dados");
            
           
            Type usuarioListaType = new TypeToken<ArrayList<Local>>(){}.getType();   
            local = gson.fromJson(jsonArray, usuarioListaType);
            
   
        }catch(MalformedURLException ex){
            System.out.println("ERRO: " + ex);
        }catch(IOException ex){
            System.out.println("ERRO:" + ex);
        } 
        return local;
    }
    
    
    public ArrayList<Local> CadastraEndereco(StringBuilder url){
        URL rest;
        ArrayList<Local> local = null;
        try{
            rest = new URL(url.toString());
            HttpURLConnection conexao = (HttpURLConnection) rest.openConnection();
            
            StringBuilder retorno = new StringBuilder();
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            String linha;
            while((linha = entrada.readLine()) != null){
                retorno.append(linha);
            }
            entrada.close();
            conexao.disconnect();
            
        }catch(MalformedURLException ex){
            System.out.println("ERRO: " + ex);
        }catch(IOException ex){
            System.out.println("ERRO:" + ex);
        } 
        return local;
    }
    
    
    
    
    
    
}
