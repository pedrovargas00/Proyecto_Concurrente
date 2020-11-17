
public class Barberia extends Thread{
    
    private boolean barberos[];
    private boolean clientes[];
    private boolean clientesEspera[];
    private int espera;
    private Controlador controlador;
    private AtencionCliente atencionCliente;
    
    public Barberia(){
        
        this.barberos = new boolean[4];
        this.clientes = new boolean[4];
        this.clientesEspera = new boolean[3];
        this.espera = 0;
    }
    
    public void setControlador(Controlador controlador){

        this.controlador = controlador;
    }
    
    public void setAtencionCliente(AtencionCliente atencionCliente){
        
        this.atencionCliente = atencionCliente;
    }
    
    public void run() {
        
        System.out.println("Entra a run");
        while (true) {
            // Inicio semáforo
            for (int i = 0; i < barberos.length; i++) {
                if (!barberos[i]){
                    //Desactiva al cliente y al barbero
                    atencionCliente.quitarCliente(i + 1);
                    atencionCliente.dormir(i + 1);
                }else
                    atencionCliente.activar(i + 1);
            }

            for (int i = 0; i < clientesEspera.length; i++)
                //Atiende a un cliente en espera
                if (!clientesEspera[i])
                    atencionCliente.desocuparSillaEspera(i + 1);
        }
    }
    
    //Clientes en espera
    private void ocuparSilla(int silla) {
        
        System.out.println("Ocupando silla " + silla);
        switch (silla) {
            case 1:
                controlador.activarEspera1(true);
                break;
            case 2:
                controlador.activarEspera2(true);
                break;
            case 3:
                controlador.activarEspera3(true);
                break;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void nuevoProceso() {
        
        System.out.println("Entra a nuevo proceso");
        int contador = -1;
        boolean aux = false;
        
        //Habilita a los barberos
        for (int i = 0; i < barberos.length; i++) {
            if (!barberos[i]) {
                barberos[i] = true;
                contador = i + 1;
                aux = true;
                break;
            }
        }
        
        //Despierta a los barberos y a sus respectivos clientes
        if (aux)
            atencionCliente.despertar(contador);
        else {
            //Si todos los barberos están ocupados, examina las sillas
            for (int i = 0; i < clientesEspera.length; i++) {
                if (!clientesEspera[i]) {
                    clientesEspera[i] = true;
                    contador = i + 1;
                    aux = true;
                    break;
                }
            }
            if (aux) {
                // Asignar silla de espera
                ocuparSilla(contador);
            } else {
                // Colocar en línea de espera "afuera"
                espera++;
            }
        }
        System.out.println("Sale de nuevo proceso");
    }
        
}
