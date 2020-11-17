import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Heladeria{
    
    private boolean mostradorOcupado, cajaOcupada;
    private int espera;
    private Controlador controlador;
    private int barquillos;
    private int servilletas;
    private Hashtable<String, Integer> sabores;
    
    public Heladeria(){
        
        this.mostradorOcupado = false;
        this.cajaOcupada = false;
        this.barquillos = 10;
        this.servilletas = 10;
        this.sabores  = new Hashtable();
        this.espera = 0;
    }
    
    public void setControlador(Controlador controlador){

        this.controlador = controlador;
    }
    
    private void activarMostrador(int opcion){
        
        mostradorOcupado = opcion == 1 ? true : false;
    }
    
    private void activarCaja(int opcion){
        
        cajaOcupada = opcion == 1 ? true : false;
    }
    
    public Hashtable<String, Integer> getSabores(){
        
        return sabores;
    }
    
    private void iniciarSabores(){
        
        sabores.put("Chocolate", 10);
        sabores.put("Vainilla", 10);
        sabores.put("Fresa", 10);

    }
    
    public void llenarSabor(String sabor){
        
        sabores.replace(sabor, 0, 10);
    }
    
    private String verificarSabores(){
        
        for (Entry<String, Integer> m : sabores.entrySet()) {
            if(m.getValue() == 0)
                return m.getKey();
        }
        
        return "";
    }
    
    public boolean verificarServilletas(){
        
         if(servilletas == 0)
           return false;
         else{
             servilletas--;
             return true;
         }
    }
    
    private boolean verificarBarquillos(){
        
        if(barquillos == 0)
           return false;
         else{
             barquillos--;
             return true;
         }
    }
        
}
