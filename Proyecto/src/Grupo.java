import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Grupo extends Thread{
    
    private Persona integrantes[];
    private Queue<Integer> personasCola;
    private Hashtable<String, Integer> helados;
    
    public Grupo(int numero, Hashtable<String, Integer> helados){
        
        this.integrantes = new Persona[numero];
        personasCola = new LinkedList();
        this.helados = helados;
    }
    
    public void run(int opcion){
        
        Random r = new Random();
        int tiempo;
        
        if(opcion == 1){
            for(int i = 0; i < integrantes.length; i++){
                tiempo = r.nextInt(5) + 1;
                try {
                    personasCola.add(integrantes[i].run(helados, tiempo, 1));
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());;
                }
            }
        }
        if(opcion == 2)
            if(verificarPedido())
                for(int i = 0; i < integrantes.length; i++){
                    try {
                        integrantes[i].run(null, 0, 2);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());;
                    }
                }
        
    }
    
    public boolean verificarPedido(){
        
        for(int i = 0; i < integrantes.length; i++){
            if(!integrantes[i].getPedido())
                return false;
        }
        
        return true;
    }
    
}
