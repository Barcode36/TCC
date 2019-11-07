
package view.cadastro_Eventos;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import model.Endereco;
import view.TCC;
import static view.TCC.telaRootAgenda;

/**
 * FXML Controller class
 *
 * @author Pedror
 */
public class Cadastro_EventosController implements Initializable {

    
    
     @FXML
    private JFXTextField txtTitulo;

    @FXML
    private JFXTextField txtMinuInic;

    @FXML
    private JFXTextField txtHoraInic;

    @FXML
    private JFXTextField txtCEP;

    @FXML
    private JFXTextField txtEndereco;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private JFXDatePicker dateInic;

    @FXML
    private JFXDatePicker dateFim;

    @FXML
    private JFXTextField txtHoraFim;

    @FXML
    private JFXTextField txtMinFim;
    
    
    
    
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    //Vai para a Scene agenda
    @FXML
    void mudaTelaAgenda(ActionEvent event) {
        telaRootAgenda();
    }
    
    //Endereço
    ArrayList<Endereco> endereco = null;
    
    //Faz a busca do endereço pelo CEP
    @FXML
    void buscaEndereco(ActionEvent event){
        URL rest;
        
        try{
            rest = new URL("https://viacep.com.br/ws/" + txtCEP.getText().replace("-", "") + "/json");
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

            String concatenar = "{\"dados\":[" + retorno.toString() + "]}";
            JsonObject jso = gson.fromJson(concatenar, JsonObject.class);
            JsonArray jsonArray = jso.getAsJsonArray("dados");


            Type enderecoListaType = new TypeToken<ArrayList<Endereco>>(){}.getType();
            endereco =  gson.fromJson(jsonArray, enderecoListaType);
            
            txtEndereco.setText(endereco.get(0).getLogradouro() + " - " + endereco.get(0).getBairro() + " - " + endereco.get(0).getLocalidade() + " - " + endereco.get(0).getUf());                  
            txtEndereco.setEditable(false);
  
        }catch(MalformedURLException ex){
            System.out.println("ERRO: " + ex);
        }
        catch(IOException ex){
            System.out.println("ERRO: " + ex);
        }
    }
    
    
    //faz o cadastro de eventos
    @FXML
    void cadastrarEventos(ActionEvent event){
        //cadastra o endereço
        
        
        /*try(){
            url = new URL("http://143.106.241.1/cl18463/tcc/api/endereco/inserir/" + "/" + " "+ endereco.get(0).getLogradouro() + "/" + endereco.get(0).getBairro() + "/" + endereco.get(0).getLocalidade() + "/" + endereco.get(0).getUf());
            
            
        }*/
        
        ///cadastro de eventos
        URL rest;
        try{
          
            TCC codigo = new TCC();//codigo do usuario
            StringBuilder url = new StringBuilder("http://143.106.241.1/cl18463/tcc/api/EventPers/inserir/");
            
            
            
            
            String dataInicio = dateInic.getValue().toString().replace("/", "-") + " " + txtHoraInic.getText() + ":" + txtMinuInic.getText();
            String dataFim = dateFim.getValue().toString().replace("/", "-") + " " + txtHoraFim.getText() + ":" + txtMinFim.getText();
            
            
            System.out.println(dataInicio);
           
            url.append(txtTitulo.getText().replace(" ", "%20"));
            url.append("/").append(dataInicio.replace(" ", "%20"));
            url.append("/").append(dataFim.replace(" ", "%20"));
            url.append("/").append(txtDescricao.getText().replace(" ", "%20"));
            url.append("/").append(Integer.toString(codigo.pegarCodigo()));
            url.append("/").append("1");
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
            
            System.out.println(url);
            Gson gson = new Gson();
            JsonObject js = gson.fromJson(retorno.toString(), JsonObject.class);
            
            System.out.println(retorno);
            if(Boolean.parseBoolean(js.get("dados").toString())){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("Evento cadastrado com sucesso!");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("Não foi possível criar um novo evento, tente novamente!");
                alert.showAndWait();
            }
            
        }catch(MalformedURLException ex){
            System.out.println("ERRO: " + ex);
        }catch(IOException ex){
            System.out.println("ERRO: " + ex);
        }
        
        
         
        
        
        
        
        
    }
    
    
    
    
}
