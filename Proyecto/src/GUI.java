import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{
    
    private Controlador controlador;
    private JLabel barbero1JL, barbero2JL, barbero3JL, barbero4JL;
    private JLabel cliente1JL, cliente2JL, cliente3JL, cliente4JL;
    private JLabel clienteEspera1JL, clienteEspera2JL, clienteEspera3JL;
    private JLabel estado1JL, estado2JL, estado3JL, estado4JL;
    
    public GUI(){
        
        init();
    }
    
    public void setControlador(Controlador controlador){
        
        this.controlador = controlador;
        //controlador.activarBarberia();
    }
    
    public void init(){
        
        barbero1JL = new JLabel();
        barbero2JL = new JLabel();
        barbero3JL = new JLabel();
        barbero4JL = new JLabel();
        cliente1JL = new JLabel();
        cliente2JL = new JLabel();
        cliente3JL = new JLabel();
        cliente4JL = new JLabel();
        clienteEspera1JL = new JLabel();
        clienteEspera2JL = new JLabel();
        clienteEspera3JL = new JLabel();
        estado1JL = new JLabel();
        estado2JL = new JLabel();
        estado3JL = new JLabel();
        estado4JL = new JLabel();
        
        
    }
    
    public void activarBarbero1(boolean activar){
        
        barbero1JL.setVisible(activar);
    }
    
    public void activarBarbero2(boolean activar){
        
        barbero2JL.setVisible(activar);
    }
    
    public void activarBarbero3(boolean activar){
        
        barbero3JL.setVisible(activar);
    }
    
    public void activarBarbero4(boolean activar){
        
        barbero4JL.setVisible(activar);
    }
    
    public void activarCliente1(boolean activar){
        
        cliente1JL.setVisible(activar);
    }
    
    public void activarCliente2(boolean activar){
        
        cliente2JL.setVisible(activar);
    }
    
    public void activarCliente3(boolean activar){
        
        cliente3JL.setVisible(activar);
    }
    
    public void activarCliente4(boolean activar){
        
        cliente4JL.setVisible(activar);
    }
    
    public void activarEspera1(boolean activar){
        
        clienteEspera1JL.setVisible(activar);
    }
    
    public void activarEspera2(boolean activar){
        
        clienteEspera2JL.setVisible(activar);
    }
    
    public void activarEspera3(boolean activar){
        
        clienteEspera3JL.setVisible(activar);
    }
    
    public void estado1(String st){
        
        estado1JL.setText(st);
    }
    
    public void estado2(String st){
        
        estado2JL.setText(st);
    }
    
    public void estado3(String st){
        
        estado3JL.setText(st);
    }
    
    public void estado4(String st){
        
        estado4JL.setText(st);
    }
}
