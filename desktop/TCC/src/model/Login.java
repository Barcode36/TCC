package model;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Login {

    
    private static int codigoUsuario;
    private static int codigoEvento;
   
    
    //para verificar o tipo de evento do button carregar da class cadastro_evento
    private static boolean tipoEvento;
    
    //Endereço
    private static ArrayList<Endereco> endereco = null;
    
    private static ArrayList<Usuario> dadosUsuario = null;
    
    private static ArrayList<EventPers> dadosEvento = null;
    

    
    public static boolean isTipoEvento() {
        return tipoEvento;
    }
    public static void setTipoEvento(boolean tipoEvento) {
        Login.tipoEvento = tipoEvento;
    }
    public static ArrayList<EventPers> getDadosEvento() {
        return dadosEvento;
    }
    public static void setDadosEvento(ArrayList<EventPers> dadosEvento) {
        Login.dadosEvento = dadosEvento;
    }
    
    public void setaDadosUSuario(ArrayList<Usuario> dadosUsuario){
        this.dadosUsuario = dadosUsuario;
    }
    public ArrayList<Usuario> pegaDadosUsuario(){
        return dadosUsuario;
    }
    
    
    
    
    public static int getCodigoUsuario() {
        return codigoUsuario;
    }
    public static void setCodigoUsuario(int aCodigoUsuario) {
        codigoUsuario = aCodigoUsuario;
    }

    public static int getCodigoEvento() {
        return codigoEvento;
    }

    public static void setCodigoEvento(int aCodigoEvento) {
        codigoEvento = aCodigoEvento;
    }
    public int pegaIndexEvento(){
        return codigoEvento;
    }
    
    public  void setaIndexEvento(int index){
        Login.codigoEvento = index;
    }
    
    public void setaCodigoEvento(int codigoEvento){
        this.codigoEvento = codigoEvento;
    }
    
    public int pegaCodigoUsuario(){
        return codigoUsuario;
    }
    
    public void setaCodigoUsuario(int codigoUsuario){
        this.codigoUsuario = codigoUsuario;
    }
    
    public boolean pegaTipoEvento(){
        return tipoEvento;
    }
    
    public ArrayList<EventPers> pegaDadosEvento(){
        return dadosEvento;
    }
    
    public void setaTipoEvento(boolean tipoEvento){
        this.tipoEvento = tipoEvento;
    }

    public int pegaCodigoEvento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
