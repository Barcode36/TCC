package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class TCC extends Application {
    
    private static Scene rootHomeR;
    private static Scene rootAgendaR;
    private static Scene rootCadastroEventosR;
    private static Stage stage;
    
    
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
        rootCadastroEventosR = new Scene(rootCadastroEventos, 1029, 547);
        
        stage.setScene(scene);
        //stage.setScene(rootAgendaR);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    //Métodos para a troca de Scene
    public static void telaRootHome(){
        stage.setScene(TCC.rootHomeR);
        stage.centerOnScreen();
    }
    
    public static void telaRootAgenda(){
        stage.setScene(TCC.rootAgendaR);
        stage.centerOnScreen();
    }
    
    
    
    
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
