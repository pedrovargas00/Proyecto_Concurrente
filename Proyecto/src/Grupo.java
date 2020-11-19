import java.util.Hashtable;

import java.util.Random;

/*Esta clase modela a un grupo de personas, es por ello que tiene un arrglo de
tipo Persona*/
public class Grupo extends Thread{
    
    private Persona integrantes[];
    private Hashtable<Integer, String> personasHelado;
    private String res, heladoSel[];
    private Hashtable<String, Integer> helados;
    
    /*numero es la cantidad de personas del grupo*/
    public Grupo(int numero, Hashtable<String, Integer> helados){
        
        this.integrantes = new Persona[numero];
        this.personasHelado = new Hashtable();
        this.res = "";
        this.heladoSel = new String[2];
        this.helados = helados;
        
        asignarNombre();
    }
    
    public void run(int opcion){
        
        Random r = new Random();
        int tiempo;
        
        /*La opción 1 se encarga de asignar el tiempo de elección del helado a
        cada integrante del grupo. Posteiormente, ejecuta el hilo de la persona.
        La persona que seleccione primero va a ser la que primera se atenderá.
        Se recibe el nombre del paciente y el helado, esto se guarda en un
        diccionario.
        */
        if(opcion == 1){
            for(int i = 0; i < integrantes.length; i++){
                tiempo = r.nextInt(5) + 1;
                try {
                    res = integrantes[i].run(helados, tiempo, 1);
                    heladoSel = res.split(".");
                    personasHelado.put(Integer.parseInt(heladoSel[0]), heladoSel[1]);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());;
                }
            }
        }
        /*La opción 2 la persona pide y recibe el helado.*/
        if(opcion == 2)
            for(int i = 0; i < integrantes.length; i++){
                try {
                    integrantes[i].run(null, 0, 2);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());;
                }
            }
        /*La opción 3 realiza el pago de helado por cada integrante. Antes
        se verifica si la persona ya recibió su helado.*/
        if(opcion == 3)
            if(verificarPedido())
                for(int i = 0; i < integrantes.length; i++){
                    try {
                        integrantes[i].run(null, 0, 3);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());;
                    }
                }
        
    }
    
    private void asignarNombre(){
        
        for(int i = 0; i < integrantes.length; i++)
            integrantes[i].setNombre(i);
    }
    
    private boolean verificarPedido(){
        
        for(int i = 0; i < integrantes.length; i++){
            if(!integrantes[i].getPedido())
                return false;
        }
        
        return true;
    }
    
    public int getTamanioGrupo(){
        
        return integrantes.length;
    }
    
}
