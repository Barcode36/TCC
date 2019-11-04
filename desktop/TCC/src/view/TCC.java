package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
<<<<<<< HEAD
import view.login_cadastro.Login_CadastroController;
=======
>>>>>>> 7b319896efdbf0c1b4f08f9505e9e01422a906e5



public class TCC extends Application {
    
    private static Scene rootHomeR;
    private static Scene rootAgendaR;
    private static Scene rootCadastroEventosR;
    private static Stage stage;
    
    
<<<<<<< HEAD
    //Codigo do usuário
    private static int codigoUsuario;

    public static int getCodigoUsuario() {
        return codigoUsuario;
    }
    public static void setCodigoUsuario(int aCodigoUsuario) {
        codigoUsuario = aCodigoUsuario;
    }
    
    
    
=======
>>>>>>> 7b319896efdbf0c1b4f08f9505e9e01422a906e5
    @Override
    public void start(Stage stage) throws Exception {
    
        
        this.stage = stage;
        
        //View login/cadastro
        Parent root = FXMLLoader.load(getClass().getResource("login_cadastro/Login_Cadastro.fxml"));
        Scene scene = new Scene(root); 
        
        // View Home
        Parent rootHome = FXMLLoader.load(getClass().getResource("home/ViewHome.fxml"));
        rootHomeR = new Scene(rootHome, 1029, 547);
         
        //View Agenda 
        Parent rootAgenda = FXMLLoader.load(getClass().getResource("agenda/Agenda.fxml"));
        rootAgendaR = new Scene(rootAgenda, 1029, 547);
        
        //Cadastro de eventos
        
        Parent rootCadastroEventos = FXMLLoader.load(getClass().getResource("cadastro_Eventos/Cadastro_Eventos.fxml"));
<<<<<<< HEAD
        rootCadastroEventosR = new Scene(rootCadastroEventos, 737, 552);
        
        stage.setScene(scene);
        //stage.setScene(rootCadastroEventosR);
=======
        rootCadastroEventosR = new Scene(rootCadastroEventos, 1029, 547);
        
        stage.setScene(scene);
        stage.setScene(rootHomeR);
>>>>>>> 7b319896efdbf0c1b4f08f9505e9e01422a906e5
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

<<<<<<< HEAD
    //Métodos para a troca de Scene 
    
    public static void telaRootHome(int codgigoUsuario){
        TCC.codigoUsuario = codgigoUsuario;
        stage.setScene(TCC.rootHomeR);
        stage.centerOnScreen();
        System.out.println(TCC.codigoUsuario);
    }
    //sobrescrever o método telaRootHome
    public static void telaRootHome(){
        stage.setScene(TCC.rootHomeR);
        stage.centerOnScreen();
        System.out.println(TCC.codigoUsuario);
    }
    
    
=======
    //Métodos para a troca de Scene
    public static void telaRootHome(){
        stage.setScene(TCC.rootHomeR);
        stage.centerOnScreen();
    }
    
>>>>>>> 7b319896efdbf0c1b4f08f9505e9e01422a906e5
    public static void telaRootAgenda(){
        stage.setScene(TCC.rootAgendaR);
        stage.centerOnScreen();
    }
    
<<<<<<< HEAD
    public static void telaRootCadastroEventos(){
        stage.setScene(rootCadastroEventosR);
        stage.centerOnScreen();
    }
    
    
    
    
    //Método para passar o codigo do Usuário
    public int pegarCodigo(){
        return codigoUsuario;
    }

 
=======
    
    
>>>>>>> 7b319896efdbf0c1b4f08f9505e9e01422a906e5
    
    //Métodos minímizar, maximizar efechar
    
    public static void minimizar(){
        stage.setIconified(true);
    }
    
    public static void maximizar(){
        
   
        if(stage.getHeight() <= 547){
            stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
            stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
            stage.centerOnScreen();
        }else{
            stage.setHeight(547);
            stage.setWidth(1029);
            stage.centerOnScreen();
        } 
    }
    
    public static void fechar(){
        stage.close();
    }
  
    //Main
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}
