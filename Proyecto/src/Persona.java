import java.util.Hashtable;
import java.util.Map;

/*Esta clase modela a una persona que pide un helado*/

public class Persona extends Thread{
    
    private int nombre;
    private String helado;
    private boolean pedido;
    private boolean pagado;
    
    public Persona(){
        
        this.nombre = 0;
        this.pedido = false;
        this.pagado = false;
        this.helado = "";
    }
    
    public String run(Hashtable<String, Integer> helados, int tiempo, int opcion) throws InterruptedException{
        /*La opción 1 es brinda un tiempo aleatorio para elegir un helado,
        este tiempo se asigna desde la clase Grupo. El tiempo asignado está 
        entre 1-5 segundos. Se regresa el nombre de la persona y el helado
        seleccionado.*/
        if(opcion == 1){
            Thread.sleep(tiempo * 1000);
            elegirHelado(helados, tiempo);
            System.out.println("Helado elegido " + this.helado);
            return String.valueOf(nombre) + "." + helado;
        }
        /*Después de elegir el helado, la persona pedirá el helado
        para esto se asignan dos segundos y se regresa el nombre*/
        if(opcion == 2){
            pedirHelado();
            return "";
        }
        /*La opción dos solamente es para pagar el helado con ayuda del método
        "pagarHelado"*/
        if(opcion == 3){
            pagarHelado();
            return "";
        }
        
        return "";
    }
    
    public void setNombre(int nombre){
        
        this.nombre = nombre;
    }
    
    public boolean getPedido(){
        return pedido;
    }
    
    public void elegirHelado(Hashtable<String, Integer> helados, int tiempo){
        
        /*La selección del helado se realiza a tráves del tiempo asignado.
        Como solo se tienen tres helados y el tiempo se toma índice para
        buscar los helados, se verifica si el tiempo es mayor a tres con la
        finalidad de no generar desbordamiento. Se recorre el diccionario
        en busca del helado solicitado y se tiene un contador para saber cuándo
        se llegó al helado deseado. */
        System.out.println("Eligiendo helado");
        int a = 0;
        
        if(tiempo > 3)
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


