package view;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.EventPers;
import view.login_cadastro.Login_CadastroController;



public class TCC extends Application {
    
    private static Scene rootHomeR;
    private static Scene rootAgendaR;
    private static Scene rootCadastroEventosR;
    private static Stage stage;
    
    
    //Codigo do usuário
    private static int codigoUsuario;

    public static int getCodigoUsuario() {
        return codigoUsuario;
    }
    public static void setCodigoUsuario(int aCodigoUsuario) {
        codigoUsuario = aCodigoUsuario;
    }
    
    //Código de eventos para edeitar
    private static int event;
    
     public static int getEvent() {
        return event;
    }
    public void setEvent(int event) {
        this.event = event;
    }
    
    
    //Array de eventos para edeitar
    private static ArrayList<EventPers> eventPers;
    
    public static ArrayList<EventPers> getEventPers() {
        return eventPers;
    }
    public static void setEventPers(ArrayList<EventPers> aEventPers) {
        eventPers = aEventPers;
    }
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
    
        
        this.stage = stage;
        
        //View login/cadastro
        Parent root = FXMLLoader.load(getClass().getResource("login_cadastro/Login_Cadastro.fxml"));
        Scene scene = new Scene(root); 
        
        // View Home
        // Parent rootHome = FXMLLoader.load(getClass().getResource("home/ViewHome.fxml"));
        //rootHomeR = new Scene(rootHome, 1029, 547);
         
        //View Agenda 
        //Parent rootAgenda = FXMLLoader.load(getClass().getResource("agenda/Agenda.fxml"));
        //rootAgendaR = new Scene(rootAgenda, 1029, 547);
        
        //Cadastro de eventos
        
        //Parent rootCadastroEventos = FXMLLoader.load(getClass().getResource("cadastro_Eventos/Cadastro_Eventos.fxml"));
        //rootCadastroEventosR = new Scene(rootCadastroEventos, 737, 552);
        
        stage.setScene(scene);
        //stage.setScene(rootCadastroEventosR);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

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
    
    
    public static void telaRootAgenda(){
        stage.setScene(TCC.rootAgendaR);
        stage.centerOnScreen();
    }

    //método que vai para a scene Cadastro_ventos_controller com parâmetro de eventos
    public static void telaRootCadastroEventos(int eventoCodigo){
        event = eventoCodigo;
        stage.setScene(rootCadastroEventosR);
        stage.centerOnScreen(); 
    }
    //Método que vai para a sece Cadastro_ventos_controller 
    public static void telaRootCadastroEventos(){
        stage.setScene(rootCadastroEventosR);
        stage.centerOnScreen();
    }
    //Método que vai para a sece Cadastro_ventos_controller passando como parâmetro um ArrayLiss<EventPers> 
    public static void telaRootCadastroEventos(ArrayList<EventPers> aEventPers){
        eventPers = aEventPers;
        stage.setScene(rootCadastroEventosR);
        stage.centerOnScreen();
    }
    
    
    
    //Método para passar o codigo do Usuário
    public int pegarCodigo(){
        return codigoUsuario;
    }
    //Método para passar o código do Evento
    public int pegarEventoUsuario(){
        return event;
    }
    //Método para passar o Evento
    public ArrayList<EventPers> pegarArrayEventoUsuario (){
        return getEventPers();
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
