import java.util.Hashtable;
import java.util.Map.Entry;

/*Esta clase se encarga de gestionar la heladería. Contiene los sabores de
los helados, la cantidad de estos, la cantidad de servilletas y barquillos.
Aquí también se restan y verifican cada uno de los productos antes mencionados

Los helados y la cantidad de estos están almacenados en un diccionario*/
public class Heladeria{
    
    private boolean mostradorOcupado, cajaOcupada;
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
    
    public void restarHelado(String helado){
        
        sabores.replace(helado, sabores.get(helado), sabores.get(helado) - 1);
    }
    
    public void llenarSabor(String helado){
        
        sabores.replace(helado, 0, 10);
    }
    
    public boolean verificarSabor(String helado){
        
        if(sabores.get(helado) == 0)
            return false;
        else
            return true;
    }
    
    public boolean verificarServilletas(){
        
         if(servilletas == 0)
           return false;
         else{
             servilletas--;
             return true;
         }
    }
    
    public boolean verificarBarquillos(){
        
        if(barquillos == 0)
           return false;
         else{
             barquillos--;
             return true;
         }
    }
    
    public void llenarServilletas(){
        
        this.servilletas = 10;
    }
    
    public void llenarBarquillos(){
        
        this.barquillos = 10;
    }
}
