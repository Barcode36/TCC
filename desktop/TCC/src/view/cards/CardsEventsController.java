/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view.cards;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import model.Login;

/**
 * FXML Controller class
 *
 * @author Pedror
 */
public class CardsEventsController implements Initializable {

    
    private int posicao;
    
    @FXML
    private JFXButton btnEvento;
    
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setbtnEvento(String titulo){
        btnEvento.setText("Evento:  " + titulo);
    }
    
    public int getPosicao() {
        return posicao;
    }
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
    @FXML
    public void eventosSelecionado(ActionEvent event) {
        Login login = new Login();
        login.setaCodigoEvento(posicao);
    }
            
            
}
