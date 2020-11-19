import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{
    
    private Controlador controlador;
    
    public GUI(){
        
        init();
    }
    
    public void setControlador(Controlador controlador){
        
        this.controlador = controlador;
        //controlador.activarBarberia();
    }
    
    public void init(){
        
        
    }
    
    
}
