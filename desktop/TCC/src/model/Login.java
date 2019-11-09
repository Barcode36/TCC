package model;

/**
 *
 * @author aluno
 */
public class Login {

    
    private static int codigoUsuario;
    
    public static int getCodigoUsuario() {
        return codigoUsuario;
    }
    public static void setCodigoUsuario(int aCodigoUsuario) {
        codigoUsuario = aCodigoUsuario;
    }
    
    
    
    public int pegaCodigoUsuario(){
        return codigoUsuario;
    }
    
    public void enviaCodigoUsuario(int codigoUsuario){
        this.codigoUsuario = codigoUsuario;
    }
    
    
    
}
