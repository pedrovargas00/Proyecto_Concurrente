import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Persona extends Thread{
    
    private int nombre;
    private String helado;
    private boolean pedido;
    private boolean pagado;
    
    public Persona(int nombre){
        
        this.nombre = nombre;
        this.pedido = false;
        this.pagado = false;
        this.helado = "";
    }
    
    public int run(Hashtable<String, Integer> helados, int tiempo, int opcion) throws InterruptedException{
        
        if(opcion == 1){
            Thread.sleep(tiempo * 1000);
            elegir(helados, tiempo);
            System.out.println("Helado elegido " + this.helado);
            pedirHelado();
            return nombre;
        }
        if(opcion == 2){
            pagarHelado();
            return 0;
        }
        
        return 0;
    }
    
    public boolean getPedido(){
        return pedido;
    }
    
    public void elegir(Hashtable<String, Integer> helados, int tiempo){
        
        System.out.println("Eligiendo helado");
        int a = 0;
        
        if(tiempo > 4)
            tiempo = 3;
        for (Map.Entry<String, Integer> m : helados.entrySet()) {
            if(a == tiempo)
                this.helado = m.getKey();
            a++;
        }
    }
    
    public void pedirHelado() throws InterruptedException{
        
        System.out.println("Pidiendo helado");
        Thread.sleep(2000);
        this.pedido = true;
    }
    
    public void pagarHelado() throws InterruptedException{
        
        System.out.println("Pagando helado");
        Thread.sleep(2000);
        this.pagado = true;
    }
    
}


