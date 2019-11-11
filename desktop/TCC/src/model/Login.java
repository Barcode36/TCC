package model;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Login {

    
    private static int codigoUsuario;
    private static int codigoEvento;
   
    
    
     //Endereço
    private static ArrayList<Endereco> endereco = null;
    
    private static boolean tipoEvento;
    private static ArrayList<EventPers> dadosEvento;
    
    
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
}
