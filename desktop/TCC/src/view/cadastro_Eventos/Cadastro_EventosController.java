
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Endereco;
import model.EventPers;
import model.Local;
import model.Login;
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
    
    //Endereço
    ArrayList<Endereco> endereco = null;
    
    private Login login; 

    
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(login.pegaTipoEvento() == false)preencheCampos(); 
    } 
    
    
    //Vai para a Scene agenda
    @FXML
    void mudaTelaAgenda(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/agenda/Agenda.fxml"));
            Parent root = loader.load();
            Scene cena = new Scene(root, 1029, 547);

             Stage window = ((Stage)((Node)event.getSource()).getScene().getWindow());

             window.setScene(cena);
             window.show(); 
             window.centerOnScreen();
        }catch(IOException ex){
            System.out.println("ERRO: " + ex);
        }
        limparCampos();
    }
    
    
    
    
    
    
    //faz o cadastro de eventos
    @FXML
    void CarregarEventos(ActionEvent event){
        //cadastra o endereço
        if(login.pegaTipoEvento()){
            EventPers eventsPersC = new EventPers();
            eventsPersC.cadastrarEvento(urlCadastroEvento());    
        }else{
            
            
        }
         
        
        limparCampos();
    }
    
   
    public void preencheCampos(){

        txtTitulo.setText(login.pegaDadosEvento().get(0).getTitulo());
        txtDescricao.setText(login.pegaDadosEvento().get(0).getDescricao());
        txtCEP.setText(Integer.toString(login.pegaDadosEvento().get(0).getCep()));
        buscaEnderecoViaCEP(Integer.toString(login.pegaDadosEvento().get(0).getCep()));
    }
    
    
    //cria a url para cadastro de eventos
    public StringBuilder urlCadastroEvento(){
        Login login = new Login();//codigo do usuario
        
        StringBuilder url = new StringBuilder("http://143.106.241.1/cl18463/tcc/api/EventPers/inserir/");
            
        String dataInicio = dateInic.getValue().toString().replace("/", "-") + " " + txtHoraInic.getText() + ":" + txtMinuInic.getText();
        String dataFim = dateFim.getValue().toString().replace("/", "-") + " " + txtHoraFim.getText() + ":" + txtMinFim.getText();
        
        
        url.append(txtTitulo.getText().replace(" ", "%20"));
        url.append("/").append(dataInicio.replace(" ", "%20"));
        url.append("/").append(dataFim.replace(" ", "%20"));
        url.append("/").append(txtDescricao.getText().replace(" ", "%20"));
        url.append("/").append(Integer.toString(login.pegaCodigoUsuario()));
        url.append("/").append(endereco.get(0).getCep().replace("-", ""));
        
        System.out.println(url);
        return url;
    }
    
    //cria a url para atualizar eventos
    public StringBuilder urlAtualizaEvento(){
        TCC codigos = new TCC();//Codigos
        EventPers eventsPersA = new EventPers();
        
        StringBuilder url = new StringBuilder("http://143.106.241.1/cl18463/tcc/api/EventPers/atualizar/");
        String dataInicio = dateInic.getValue().toString().replace("/", "-") + " " + txtHoraInic.getText() + ":" + txtMinuInic.getText();
        String dataFim = dateFim.getValue().toString().replace("/", "-") + " " + txtHoraFim.getText() + ":" + txtMinFim.getText();
            
        
        url.append(Integer.toString(codigos.pegarEventoUsuario()));
        url.append("/").append(txtTitulo.getText().replace(" ", "%20"));
        url.append("/").append(dataInicio.replace(" ", "%20"));
        url.append("/").append(dataFim.replace(" ", "%20"));
        url.append("/").append(txtDescricao.getText().replace(" ", "%20"));
        url.append("/").append(Integer.toString(codigos.pegarCodigo()));
        url.append("/").append(endereco.get(0).getCep().replace("-", ""));
            
        
            
        return  url;
    }
    
    
    
    
    
    
    //Faz a busca do endereço pelo CEP
    @FXML
    void buscaEndereco(ActionEvent event){
        buscaEnderecoViaCEP(txtCEP.getText());
    }
    public void buscaEnderecoViaCEP(String cep){
        URL rest;
        
        try{
            rest = new URL("https://viacep.com.br/ws/" + cep.replace("-", "") + "/json");
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

    public void limparCampos(){
            txtTitulo.clear();
            txtCEP.clear();
            txtEndereco.setEditable(true);
            txtEndereco.clear();  
            txtDescricao.clear();
            dateInic.getEditor().clear();
            dateFim.getEditor().clear();
            txtHoraInic.clear();
            txtMinuInic.clear();
            txtMinFim.clear();
            txtHoraFim.clear();
    }
    
}
