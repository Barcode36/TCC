package view.agenda;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import model.EventPers;
import view.TCC;
import static view.TCC.telaRootCadastroEventos;


/**
 * FXML Controller class
 *
 * @author 
 */
public class AgendaController implements Initializable {


    @FXML
    private AnchorPane panePai;

    @FXML
    private AnchorPane paneAgenda;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnOptions;

    @FXML
    private JFXButton btnPerfil;

    @FXML
    private AnchorPane paneOptions;

    @FXML
    private JFXButton btnMinimizar;

    @FXML
    private JFXButton btnMaximizar;

    @FXML
    private JFXButton btnFechar;

    @FXML
    private AnchorPane addPane;

    @FXML
    private JFXButton btnRemove;

    @FXML
    private JFXButton btnMinimizar1;

    @FXML
    private JFXButton btnMaximizar1;

    @FXML
    private JFXButton btnFechar1;
    
    @FXML
    private JFXComboBox<String> comboBoxSelecaoAno;
    
     @FXML
    private Label labelMes;

    @FXML
    private Label labelAno;
    
    @FXML
    private Button btnAno;

    @FXML
    private Button btnMes;
    
    @FXML
    private JFXComboBox<String> comboBoxSelecaoMes;
    
     @FXML
    private JFXButton btnC1;

    @FXML
    private JFXButton btnC2;

    @FXML
    private JFXButton btnC3;

    @FXML
    private JFXButton btnC4;

    @FXML
    private JFXButton btnC5;

    @FXML
    private JFXButton btnC6;

    @FXML
    private JFXButton btnC7;

    @FXML
    private JFXButton btnC8;

    @FXML
    private JFXButton btnC9;

    @FXML
    private JFXButton btnC10;

    @FXML
    private JFXButton btnC11;

    @FXML
    private JFXButton btnC12;

    @FXML
    private JFXButton btnC13;

    @FXML
    private JFXButton btnC14;

    @FXML
    private JFXButton btnC15;

    @FXML
    private JFXButton btnC16;

    @FXML
    private JFXButton btnC17;

    @FXML
    private JFXButton btnC18;

    @FXML
    private JFXButton btnC19;

    @FXML
    private JFXButton btnC20;

    @FXML
    private JFXButton btnC21;

    @FXML
    private JFXButton btnC22;

    @FXML
    private JFXButton btnC23;

    @FXML
    private JFXButton btnC24;

    @FXML
    private JFXButton btnC25;

    @FXML
    private JFXButton btnC26;

    @FXML
    private JFXButton btnC27;

    @FXML
    private JFXButton btnC28;

    @FXML
    private JFXButton btnC29;

    @FXML
    private JFXButton btnC30;

    @FXML
    private JFXButton btnC31;

    @FXML
    private JFXButton btnC32;

    @FXML
    private JFXButton btnC33;

    @FXML
    private JFXButton btnC34;

    @FXML
    private JFXButton btnC35;

    @FXML
    private JFXButton btnC36;

    @FXML
    private JFXButton btnC37;

    @FXML
    private JFXButton btnC38;

    @FXML
    private JFXButton btnC39;

    @FXML
    private JFXButton btnC40;

    @FXML
    private JFXButton btnC41;

    @FXML
    private JFXButton btnC42;
    
    @FXML
    private AnchorPane pn1;

    @FXML
    private AnchorPane pn2;

    @FXML
    private AnchorPane pn3;

    @FXML
    private AnchorPane pn4;

    @FXML
    private AnchorPane pn5;

    @FXML
    private AnchorPane pn6;

    @FXML
    private AnchorPane pn7;
    
    @FXML
    private AnchorPane pn8;
    
    @FXML
    private AnchorPane pn9;
    
    @FXML
    private AnchorPane pn10;
    
    @FXML
    private AnchorPane pn11;
    
    @FXML
    private AnchorPane pn12;
    
    @FXML
    private AnchorPane pn13;
    
    @FXML
    private AnchorPane pn14;
    
    @FXML
    private AnchorPane pn15;
    
    @FXML
    private AnchorPane pn16;
    
    @FXML
    private AnchorPane pn17;
    
    @FXML
    private AnchorPane pn18;
    
    @FXML
    private AnchorPane pn19;
    
    @FXML
    private AnchorPane pn20;
    
    @FXML
    private AnchorPane pn21;
    
    @FXML
    private AnchorPane pn22;
    
    @FXML
    private AnchorPane pn23;
    
    @FXML
    private AnchorPane pn24;
    
    @FXML
    private AnchorPane pn25;
    
    @FXML
    private AnchorPane pn26;
    
    @FXML
    private AnchorPane pn27;
    
    @FXML
    private AnchorPane pn28;
    
    @FXML
    private AnchorPane pn29;
    
    @FXML
    private AnchorPane pn30;
        
    @FXML
    private AnchorPane pn31;
  
    @FXML
    private AnchorPane pn32;
        
    @FXML
    private AnchorPane pn33;
        
    @FXML
    private AnchorPane pn34;
        
    @FXML
    private AnchorPane pn35;
        
    @FXML
    private AnchorPane pn36;
        
    @FXML
    private AnchorPane pn37;
        
    @FXML
    private AnchorPane pn38;
    
        
    @FXML
    private AnchorPane pn39;
      
    @FXML
    private AnchorPane pn40;
        
    @FXML
    private AnchorPane pn41;
        
    @FXML
    private AnchorPane pn42;
       
    @FXML
    private Label labelDe;
     
    @FXML
    private AnchorPane paneMes;
    
    @FXML
    private AnchorPane paneAno;
    
    @FXML
    private AnchorPane paneCorTest;
    
    @FXML
    private TableView<EventPers> tabelaEventosDoDia;
    
    @FXML
    private TableColumn<EventPers, String> tbcTitulo;
    
    

    
    
    
   //codigo do Usuário
   private int codigoUsuario;
    
    public  int getCodigoUsuario() {
        return codigoUsuario;
    }
    public  void setCodigoUsuario(int aCodigoUsuario) {
        codigoUsuario = aCodigoUsuario;
    }
    ///////
    TCC usuario = new TCC();

    
    
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        iniciaCalendario();
        calendario();  
    } 
    
    
   //Métodos minímizar, maximizar e fechar
   @FXML
   void maximizar(ActionEvent event) {
       TCC.maximizar();
   }

   @FXML
   void minimizar(ActionEvent event) {
      TCC.minimizar();
   }
   
   @FXML
   void fechar(ActionEvent event) {
       TCC.fechar();
   } 
   
   // Vai para o paneHome e o addPane
   @FXML
    void remove(ActionEvent event) {
        addPane.setVisible(false);
        paneAgenda.setVisible(true);
        paneAgenda.toFront();
    }

    @FXML
    void addPane(ActionEvent event) {
        addPane.setVisible(true);
        addPane.toFront();
    }
    
    // Controla o paneOptons
    @FXML
    void options(ActionEvent event) {
        if(paneOptions.visibleProperty().getValue() == true){
            paneOptions.setVisible(false);
        }else{
            paneOptions.setVisible(true);
        } 
    }
    
    //Vai para a view Perfil
    @FXML
    void vaiViewPerfil(ActionEvent event) {
        TCC.telaRootHome();
    }
    
    
   
    
    //Muda para a scene de criar eventos
    @FXML
    void mudaTelaCadastroEventos(ActionEvent event) {
        telaRootCadastroEventos();
    }
    
    
    
    
    
    
    
    
    
    //Calendario
    
    //=========================================================
    
    //Váriaveis de controle do calendario
    
    private int anoFixo = 0, mesFixo = 0, diaFixo = 0;
    private int anoAltera = 0, mesAltera = 0, diaAltera = 0;
    private int valorselecao = 0;
    
    
    private int anoAlteraAnt = 0, mesAlteraAnt = 0;
    private int anoAlteraProx = 0, mesAlteraProx = 0;

    
    //Começa a criação do calendario
    public void iniciaCalendario(){
        SimpleDateFormat ano = new SimpleDateFormat("yyyy");
        SimpleDateFormat mes = new SimpleDateFormat("MM");
        SimpleDateFormat dia = new SimpleDateFormat("dd");
        
        anoFixo = Integer.parseInt(ano.format(new Date()));
        mesFixo = Integer.parseInt(mes.format(new Date()));
        diaFixo = Integer.parseInt(dia.format(new Date()));
        
        //JOptionPane.showMessageDialog(null, anoFixo + "/" + mesFixo + "/" + diaFixo);
        
        int anoMaximo = anoFixo + 50;
        for(int i = 2000; i < anoMaximo; i++){
            comboBoxSelecaoAno.getItems().add(Integer.toString(i));
        }
        
        comboBoxSelecaoAno.setValue(Integer.toString(anoFixo));
        //comboBoxSelecaoAno.setSelectedItem(Integer.toString(anoFixo));
        
        comboBoxSelecaoMes.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril", "Maio",
                                             "junho", "julho", "Agosto", "Setembro", "Outubro", "Novenbro", "Dezembro");
        
        
        //Verifica mês
        if(mesFixo == 1){
            comboBoxSelecaoMes.setValue("Janeiro");
        }
        else if(mesFixo == 2){
            comboBoxSelecaoMes.setValue("Fevereiro");
        }
        else if(mesFixo == 3){
            comboBoxSelecaoMes.setValue("Março");
        }
        else if(mesFixo == 4){
            comboBoxSelecaoMes.setValue("Abril");
        }
        else if(mesFixo == 5){
            comboBoxSelecaoMes.setValue("Maio");
        }
        else if(mesFixo == 6){
            comboBoxSelecaoMes.setValue("junho");
        }
        else if(mesFixo == 7){
            comboBoxSelecaoMes.setValue("julho");
        }
        else if(mesFixo == 8){
            comboBoxSelecaoMes.setValue("Agosto");
        }
        else if(mesFixo == 9){
            comboBoxSelecaoMes.setValue("Setembro");
        }
        else if(mesFixo == 10){
            comboBoxSelecaoMes.setValue("Outubro");
        }
        else if(mesFixo == 11){
            comboBoxSelecaoMes.setValue("Novenbro");
        }
        else if(mesFixo == 12){
            comboBoxSelecaoMes.setValue("Dezembro");
        }
        
        btnAno.setText(comboBoxSelecaoAno.getSelectionModel().selectedItemProperty().get());
        btnMes.setText(comboBoxSelecaoMes.getSelectionModel().selectedItemProperty().get());
    }

    //
    public void calendario(){
        //Zera todos os buttons do calendario
        btnC1.setText("");
        btnC2.setText("");
        btnC3.setText("");
        btnC4.setText("");
        btnC5.setText("");
        btnC6.setText("");
        btnC7.setText("");
        btnC8.setText("");
        btnC9.setText("");
        btnC10.setText("");
        btnC11.setText("");
        btnC12.setText("");
        btnC13.setText("");
        btnC14.setText(null);
        btnC15.setText(null);
        btnC16.setText(null);
        btnC17.setText(null);
        btnC18.setText(null);
        btnC19.setText(null);
        btnC20.setText(null);
        btnC21.setText(null);
        btnC22.setText(null);
        btnC23.setText(null);
        btnC24.setText(null);
        btnC25.setText(null);
        btnC26.setText(null);
        btnC27.setText(null);
        btnC28.setText(null);
        btnC29.setText(null);
        btnC30.setText(null);
        btnC3.setText("");
        btnC31.setText("");
        btnC32.setText("");
        btnC33.setText("");
        btnC34.setText("");
        btnC35.setText("");
        btnC36.setText("");
        btnC37.setText("");
        btnC38.setText("");
        btnC39.setText("");
        btnC40.setText("");
        btnC41.setText("");
        btnC42.setText("");
        
        diaAltera = diaFixo;
        mesAltera = comboBoxSelecaoMes.getSelectionModel().getSelectedIndex();
        anoAltera = Integer.parseInt(btnAno.getText());
        //anoAltera = Integer.parseInt(comboBoxSelecaoMes.getSelectionModel().selectedItemProperty().get());
        

       
       //Controla mês anterior e o proximo mês
        int totalDiaMesAnt = 0;
        int totalDiaMesProx = 0;
        
        
       //Verifica o total de dias no mês;      
        int totalDiaMes = 0;
        
        //1
        if(mesAltera == 0){
            totalDiaMesAnt = 31;
            totalDiaMes = 31;
            if((mesAltera % 4) == 0){
                totalDiaMesProx = 29;
            }else{
                totalDiaMesProx = 28;
               
            }//2
        }else if(mesAltera == 1){
            totalDiaMesAnt = 31;
            if((anoAltera % 4) == 0){
                totalDiaMes = 29;
            }else{
                totalDiaMes = 28;
            }
            totalDiaMesProx = 31;  
        }//3
        else if(mesAltera == 2){
            if((anoAltera % 4) == 0){
                totalDiaMesAnt = 29;
            }else{
                totalDiaMesAnt = 28;
            }
            totalDiaMes = 31;
            totalDiaMesProx = 30;
        }//4
        else if(mesAltera == 3){
            totalDiaMesAnt = 31;
            totalDiaMes = 30;
            totalDiaMesProx = 31;
        }//5
        else if(mesAltera == 4){
            totalDiaMesAnt = 30;
            totalDiaMes = 31;
            totalDiaMesProx = 30;
        }//6
        else if(mesAltera == 5){
            totalDiaMesAnt = 31;
            totalDiaMes = 30;
            totalDiaMesProx = 31;
        }
        else if(mesAltera == 6){
            totalDiaMesAnt = 30;
            totalDiaMes = 31;
            totalDiaMesProx = 31;
        }//7
        else if(mesAltera == 7){
            totalDiaMesAnt = 31;
            totalDiaMes = 31;
            totalDiaMesProx = 30;
        }
        else if(mesAltera == 8){
            totalDiaMesAnt = 31;
            totalDiaMes = 30;
            totalDiaMesProx = 31;
        }
        else if(mesAltera == 9){
            totalDiaMesAnt = 30;
            totalDiaMes = 31;
            totalDiaMesProx = 30;
        }
        else if(mesAltera == 10){
            totalDiaMesAnt = 31;
            totalDiaMes = 30;
            totalDiaMesProx = 31;
        }
        else if(mesAltera == 11){
            totalDiaMesAnt = 30;
            totalDiaMes = 31;
            totalDiaMesProx = 31;
        }
        
        
        //Verificando que dia da semana do mês começa
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoAltera, mesAltera, 1);
        int setaDia = 0;
        
        int semana  = calendar.get(Calendar.DAY_OF_WEEK);
        if(semana == Calendar.SUNDAY){
            setaDia = 1;
        }else if(semana == Calendar.MONDAY){
            setaDia = 2;
        }else if(semana == Calendar.TUESDAY){
            setaDia = 3;
        }else if(semana == Calendar.WEDNESDAY){
            setaDia = 4;
        }else if(semana == Calendar.THURSDAY){
            setaDia = 5;
        }else if(semana == Calendar.FRIDAY){
            setaDia = 6;
        }else if(semana == Calendar.SATURDAY){
            setaDia = 7;
        }
        
        
        for(int i = 1; i <= totalDiaMes; i++){
            switch(setaDia){
                case 1:
                        btnC1.setText("" + i);
                        corDiaAtual(btnC1, i, pn1);
                    break;
                case 2:
                        btnC2.setText("" + i);
                        corDiaAtual(btnC2, i, pn2);
                    break;
                case 3:
                      btnC3.setText("" + i);
                      corDiaAtual(btnC3, i, pn3);
                    break;
                case 4:
                      btnC4.setText("" + i);
                      corDiaAtual(btnC4, i, pn4);
                    break;
                case 5:
                      btnC5.setText("" + i);
                      corDiaAtual(btnC5, i, pn5);
                    break;
                case 6:
                      btnC6.setText("" + i);
                      corDiaAtual(btnC6, i, pn6);
                    break;
                case 7:
                      btnC7.setText("" + i);
                      corDiaAtual(btnC7, i, pn7);
                    break;
                case 8:
                      btnC8.setText("" + i);
                      corDiaAtual(btnC8, i, pn8);
                    break;
                case 9:
                      btnC9.setText("" + i);
                      corDiaAtual(btnC9, i, pn9);
                    break;
                case 10:
                      btnC10.setText("" + i);
                      corDiaAtual(btnC10, i, pn10);
                    break;
                case 11:
                      btnC11.setText("" + i);
                      corDiaAtual(btnC11, i, pn11);
                    break;
                case 12:
                      btnC12.setText("" + i);
                      corDiaAtual(btnC12, i, pn12);
                    break;
                case 13:
                      btnC13.setText("" + i);
                      corDiaAtual(btnC13, i, pn13);
                    break;
                case 14:
                        btnC14.setText("" + i);
                        corDiaAtual(btnC14, i, pn14);
                    break;
                case 15:
                        btnC15.setText("" + i);
                        corDiaAtual(btnC15, i, pn15);
                    break;
                case 16:
                      btnC16.setText("" + i);
                      corDiaAtual(btnC16, i, pn16);
                    break;
                case 17:
                      btnC17.setText("" + i);
                      corDiaAtual(btnC17, i, pn17);
                    break;
                case 18:
                      btnC18.setText("" + i);
                      corDiaAtual(btnC18, i, pn18);
                    break;
                case 19:
                      btnC19.setText("" + i);
                      corDiaAtual(btnC19, i, pn19);
                    break;
                case 20:
                      btnC20.setText("" + i);
                      corDiaAtual(btnC20, i, pn20);
                    break;
                case 21:
                      btnC21.setText("" + i);
                      corDiaAtual(btnC21, i, pn21);
                    break;
                case 22:
                      btnC22.setText("" + i);
                      corDiaAtual(btnC22, i, pn22);
                    break;
                case 23:
                      btnC23.setText("" + i);
                      corDiaAtual(btnC23, i, pn23);
                    break;
                case 24:
                      btnC24.setText("" + i);
                      corDiaAtual(btnC24, i, pn24);
                    break;
                case 25:
                      btnC25.setText("" + i);
                      corDiaAtual(btnC25, i, pn25);
                    break;
                case 26:
                      btnC26.setText("" + i);
                      corDiaAtual(btnC26, i, pn26);
                    break;
                case 27:
                        btnC27.setText("" + i);
                        corDiaAtual(btnC27, i, pn27);
                    break;
                case 28:
                        btnC28.setText("" + i);
                        corDiaAtual(btnC28, i, pn28);
                    break;
                case 29:
                      btnC29.setText("" + i);
                      corDiaAtual(btnC29, i, pn29);
                      
                    break;
                case 30:
                      btnC30.setText("" + i);
                      corDiaAtual(btnC30, i, pn30);
                    break;
                case 31:
                      btnC31.setText("" + i);
                      corDiaAtual(btnC31, i, pn31);
                    break;
                case 32:
                      btnC32.setText("" + i);
                      corDiaAtual(btnC32, i, pn32);
                    break;
                case 33:
                      btnC33.setText("" + i);
                      corDiaAtual(btnC33, i, pn33);
                    break;
                case 34:
                      btnC34.setText("" + i);
                      corDiaAtual(btnC34, i, pn34);
                    break;
                case 35:
                      btnC35.setText("" + i);
                      corDiaAtual(btnC35, i, pn35);
                    break;
                case 36:
                      btnC36.setText("" + i);
                      corDiaAtual(btnC36, i, pn36);
                    break;
                case 37:
                      btnC37.setText("" + i);
                      corDiaAtual(btnC37, i, pn37);
                    break;
                case 38:
                      btnC38.setText("" + i);
                      corDiaAtual(btnC38, i, pn38);
                    break;
                case 39:
                      btnC39.setText("" + i);
                      corDiaAtual(btnC39, i, pn39);
                    break;
                case 40:
                        btnC40.setText("" + i);
                        corDiaAtual(btnC40, i, pn40);
                    break;
                case 41:
                        btnC41.setText("" + i);
                        corDiaAtual(btnC41, i, pn41);
                    break;
                case 42:
                      btnC42.setText("" + i);
                      corDiaAtual(btnC42, i, pn42);
                    break; 
            }
            setaDia++;
        }   
    }
    
    //Verificando o dia e setando a cor 
    public void corDiaAtual(JFXButton corDiaAtual, int i, AnchorPane pane){
        if(((i == diaFixo) && (mesAltera == mesFixo -1)) && (anoAltera == anoFixo)){
            corDiaAtual.setStyle("-fx-text-fill: black;"); 
        }else{
            corDiaAtual.setStyle("-fx-text-fill: #FFF;");
            
        }
        verificaEventosDia(pane, corDiaAtual);
    }
    
    
    //Seleciona Ano
    @FXML
    void selecionaAno(ActionEvent event) {
        btnAno.setText(comboBoxSelecaoAno.getSelectionModel().selectedItemProperty().get());
        diaAltera = diaFixo;
        calendario();
        paneAno.setVisible(false);
        labelDe.setVisible(true);
        btnMes.setVisible(true);
        btnAno.setVisible(true);
        
    }
    //Seleciona Mês
    @FXML
    void selecionaMes(ActionEvent event) {
        btnMes.setText(comboBoxSelecaoMes.getSelectionModel().selectedItemProperty().get());
        diaAltera = diaFixo;
        calendario();
        paneMes.setVisible(false);
        labelDe.setVisible(true);
        btnMes.setVisible(true);
        btnAno.setVisible(true);
    }
    
    
    
    //Button Selecioan Ano
    @FXML
    void selecAno(ActionEvent event) {
        labelDe.setVisible(false);
        btnMes.setVisible(false);
        btnAno.setVisible(false);
        paneAno.setVisible(true);
        initTable("0");
    }

    //Button Selecioan Mês
    @FXML
    void selecMes(ActionEvent event) {
        labelDe.setVisible(false);
        btnMes.setVisible(false);
        btnAno.setVisible(false);
        paneMes.setVisible(true);
        initTable("0");
    }
    
    

   
    //adiciona eventos do dia a tabela 
    @FXML
    public void eventosdoDia(ActionEvent event) {
        
        JFXButton botao =  (JFXButton) event.getSource();
        
        if(botao.getText() != ""){
            initTable(botao.getText());   
        }  
    }
    public void initTable(String dia){
        
        tbcTitulo.setCellValueFactory(new PropertyValueFactory<EventPers, String>("Titulo"));
      
        tabelaEventosDoDia.setItems(atualizaTabela(dia));
        
    }
    public ObservableList<EventPers> atualizaTabela(String dia){
        
        
        EventPers eventos = new EventPers();
        ArrayList<EventPers> eventosUsuario = null;
        
        
        if(dia.length() == 1){
            dia = "0" + dia;
        }
        String mes = "";
        
   
        if( btnMes.getText() == "Janeiro"){
            mes = "1";
        }
        else if(btnMes.getText() == "Fevereiro"){
            mes = "2";
        }
        else if(btnMes.getText() == "Março"){
            mes = "3";
        }
        else if(btnMes.getText() == "Abril"){
            mes = "4";
        }
        else if(btnMes.getText() == "Maio"){
            mes = "5";
        }
        else if(btnMes.getText() == "junho"){
            mes = "6";
        }
        else if(btnMes.getText() == "julho"){
            mes = "7";
        }
        else if(btnMes.getText() == "Agosto"){
            mes = "8";
        }
        else if(btnMes.getText() == "Setembro"){
            mes = "9";
        }
        else if(btnMes.getText() == "Outubro"){
            mes = "10";
        }
        else if(btnMes.getText() == "Novenbro"){
            mes = "11";
        }
        else if(btnMes.getText() == "Dezembro"){
            mes = "12";
        }
        
        
        String data = btnAno.getText() + "-" + mes + "-" + dia;
        eventosUsuario = eventos.buscaEventosUsuario(data, Integer.toString(usuario.pegarCodigo()));
        
        return FXCollections.observableArrayList(eventosUsuario);
    } 
 
    
    //Verifica se a eventos no dia
    public void verificaEventosDia(AnchorPane pane, JFXButton btnDia){
       
        EventPers eventos = new EventPers();
        ArrayList<EventPers> eventosUsuario = null;
        String data = btnAno.getText() + "-" + "11" + "-" + "0"+ btnDia.getText();
        System.out.println(data);
        eventosUsuario = eventos.buscaEventosUsuario(data, Integer.toString(usuario.pegarCodigo()));
        
        
        System.out.println(eventosUsuario);
        if(eventosUsuario.size() < 0){
            pane.setStyle("-fx-background-color: #0768ae;");
        }else{
            pane.setStyle("-fx-background-color: red;");
        }
        
        
        

    }
    
    
    
    
    
    
  
    //verifica calendario e cadastra evento
    public void cadastra(Button btnDia){
        if(!btnDia.getText().equals("")){
            
        }
    }
      
}
