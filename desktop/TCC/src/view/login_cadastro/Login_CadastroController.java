package view.login_cadastro;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Login;
import model.Usuario;
import view.TCC;
import view.home.ViewHomeController;


/**
 * FXML Controller class
 *
 * @author gabri
 */
public class Login_CadastroController implements Initializable {

 
    @FXML
    private AnchorPane paneCadastro;

    @FXML
    private JFXButton btnExit1;

    @FXML
    private Button btnCadastrar;

    @FXML
    private CheckBox checkbox;

    @FXML
    private JFXButton btnVoltaLogin;

    @FXML
    private JFXTextField txtNome;

    @FXML
    private JFXTextField txtUsuarioCa;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtSenha1;

    @FXML
    private JFXPasswordField txtSenha2;

    @FXML
    private JFXTextField txtTelefone;

    @FXML
    private AnchorPane paneLogin;

    @FXML
    private Button btnIrcadastro;

    @FXML
    private Button btnEntrar;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXPasswordField txtSenha;

    @FXML
    private JFXTextField txtUsuario;
    
    
    
    
    //Responsavel para armazenar o Codigo do Usuário ao fazer login
    private static int codigoUsuario;
    
    public static int getCodigoUsuario() {
        return codigoUsuario;
    }
    public static void setCodigoUsuario(int aCodigoUsuario) {
        codigoUsuario = aCodigoUsuario;
    }
    ///////////
    
    
    @FXML
    void login(ActionEvent event) throws SQLException, ClassNotFoundException{
        
        
        
        URL rest;
        
        try{
            rest = new URL("http://143.106.241.1/cl18463/tcc/api/usuario/buscar/"+ this.txtUsuario.getText() + "/" + this.txtSenha.getText());
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
            
            //verifica se o usuário existe 
            if(jsonArray.size() > 0){
                
                //pega o codigo do usuário
                ArrayList<Usuario> usuario = null;
                
                Type usuarioListaType = new TypeToken<ArrayList<Usuario>>(){}.getType();
                usuario = gson.fromJson(jsonArray, usuarioListaType);
                
                
                try{
                    Login login = new Login();
                    login.setCodigoUsuario(usuario.get(0).getCodigo());

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/home/ViewHome.fxml"));
                    Parent root = loader.load();
                    Scene cena = new Scene(root, 935, 521);
                    
                    login.setaDadosUSuario(usuario);
                    
                    ViewHomeController controller = loader.getController();
                    controller.initialize(usuario);
                    
                    Stage window = ((Stage)((Node)event.getSource()).getScene().getWindow());

                    window.setScene(cena);
                    window.show();
                    window.centerOnScreen();
                    
                }catch(IOException ex){
                    System.out.println("ERRO:" + ex);
                }
                
            }else{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("");
                alert.setHeaderText("Usuário ou Senha inválido!");
                alert.setContentText("Tente Novamente!");

                alert.showAndWait();
            }
            
        }catch(MalformedURLException ex){
            System.out.println("Erro: " + ex);
        }catch(IOException ex){
            System.out.println("Erro: " + ex);
        }
    }
    
    
    
    @FXML
    void cadastrar(ActionEvent event){

        if(verificaCampos()){
            
            URL rest;
            try{
                StringBuilder url = new StringBuilder("http://143.106.241.1/cl18463/tcc/api/usuario/inserir/");
                url.append(txtNome.getText().replace(" ", "%20"));
                url.append("/").append(txtUsuarioCa.getText());
                url.append("/").append(txtEmail.getText());
                url.append("/").append(txtSenha1.getText());
                url.append("/").append(txtTelefone.getText());
                rest = new URL(url.toString());
                
                System.out.println(url.toString());
                
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


                if(Boolean.parseBoolean(js.get("dados").toString())){
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("");
                    alert.setHeaderText("Cadastro efetuado com sucesso!");
                    alert.showAndWait();
                    
                    
                    /*txtNome.clear();
                    txtUsuarioCa.clear();
                    txtEmail.clear();
                    txtSenha1.clear();
                    txtSenha2.clear();
                    txtTelefone.clear();*/
                    
                    paneCadastro.setVisible(false);
                    paneLogin.setVisible(true);
                    paneLogin.toFront();  
                }else{
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("");
                    alert.setHeaderText("Não foi possível realizar o cadastro, tente novamente!");
                    alert.showAndWait();
                }
                
                
            } catch (MalformedURLException ex) { 
                System.out.println("Erro: " + ex);
            } catch (IOException ex) {
                System.out.println("Erro: " + ex);
            }
             
        }
        
    }
    
    
    
    
   
    @FXML
    void vaiTelaCadastro(ActionEvent event) {
        paneLogin.setVisible(false);
        paneCadastro.setVisible(true);
        paneCadastro.toFront();
    }
    
    @FXML
    void vaiTelaLogin(ActionEvent event) {
        paneCadastro.setVisible(false);
        paneLogin.setVisible(true);
        paneLogin.toFront();
    }
    
    @FXML
    void exit(ActionEvent event) throws IOException {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
    
    
    
    //Verifica se os campos foram preenchidos coretamente
    private boolean verificaCampos(){
        if(txtNome.getText().trim().isEmpty() || txtUsuarioCa.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty() ||
                txtSenha1.getText().trim().isEmpty() || txtSenha2.getText().trim().isEmpty()|| txtTelefone.getText().trim().isEmpty()){
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Obrigatorio o preenchimento de todos os campos!");
            alert.setContentText("Preencha todos os campos!");
            alert.showAndWait();
            return false;
        /*}else if(){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("");
            alert.setHeaderText("Nome de usuário já existente!");
            alert.showAndWait();
            return false;*/   
        }else if(!txtSenha1.getText().equals(txtSenha2.getText())){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Senhas incompatíveis!");
            alert.showAndWait();
            return false;  
        }else if(txtSenha1.getText().length() < 4){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Senha muito pequena!");
            alert.setContentText("mínimo 4 caracteres");
            alert.showAndWait();
            return false;
        }else if(txtSenha1.getText().length() > 10){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Senha muito extensa!");
            alert.setContentText("máximo 10 caracteres");
            alert.showAndWait();
            return false;
        }
        
        int maiusculas = 0;
        int minusculas = 0;
        int numeros = 0;
        
        for(int i = 0; i < txtSenha1.getText().length(); i++){
            if((txtSenha1.getText().charAt(i) >= 'a' && txtSenha1.getText().charAt(i) <= 'z')){
                minusculas++;
            }else if((txtSenha1.getText().charAt(i) >= 'A' && txtSenha1.getText().charAt(i) <= 'Z')){
                maiusculas++;
            }else if((txtSenha1.getText().charAt(i) >= '0') && txtSenha1.getText().charAt(i) <= '9'){
                numeros++;
            }
        }
        if(maiusculas < 1 || minusculas < 1){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("É necessário no mínimo um caractere maiusculo e minusculo!");
            alert.showAndWait();
            return false;
        }else if(numeros < 2){
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("É necessário no mínimo dois caractere númerico!");
            alert.showAndWait();
            return false;
        }

        return true;
    }
}
