
import java.util.Random;


public class AtencionCliente extends Thread{
    
    private int contador = -1;
    private Controlador controlador;
    private boolean clientesEspera[];
    private boolean barberos[];
    
    public AtencionCliente(boolean clientesEspera[], boolean barberos[]){
        
        this.clientesEspera = clientesEspera;
        this.barberos = barberos;
    }
    
    public AtencionCliente(){}
    
    //Espera antes de lanzar los hilos
    public void run() {
        
        int numeroAleatorio = getRandomNumberInRange(10, 15);

        try {
            Thread.sleep(numeroAleatorio * 1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        clienteSatisfecho();
    }

    public void setControlador(Controlador controlador){
        
        this.controlador = controlador;
    }
    
    private void clienteSatisfecho() {
        
        barberos[contador - 1] = false;
        System.out.println("Adios, te atendio " + contador);
        verificarEspera();
    }

    private void verificarEspera() {
        
        if (clientesEspera[0] == true) {
            if (clientesEspera[1] == true) {
                if (clientesEspera[2] == true) {
                    clientesEspera[2] = false;
                    desocuparSillaEspera(3);
                }else{
                    clientesEspera[1] = false;
                        desocuparSillaEspera(2);
                }
            } else {
                clientesEspera[0] = false;
                desocuparSillaEspera(1);
            }
            barberos[contador - 1] = true;
            System.out.println("Hola, te atiende " + contador);
            despertar(contador);
        }
        
    }

    public void desocuparSillaEspera(int silla) {
        
        System.out.println("Desocupando silla " + silla);
        switch (silla) {
            case 1:
                controlador.activarEspera1(false);
                break;
            case 2:
                controlador.activarEspera2(false);
                break;
            case 3:
                controlador.activarEspera3(false);;
                break;
            default:
                break;
        }
    }
    
    //Puede usarse o no
    public void actualizarcobro(){
        int preciocorte = 20;
        int b1 = 0, b2=0, b3=0, b4 = 0;    //monto acumulado para barbero 1,2,3
        int total=0;        // monto acumulado total
        
        controlador.estado1("$ "+String.valueOf(b1));
        controlador.estado2("$ "+String.valueOf(b2));
        controlador.estado3("$ "+String.valueOf(b3));
        controlador.estado4("$ "+String.valueOf(b4));
    }
    
    public void activar(int barbero) {
        
        System.out.println("Activando al cliente-barbero " + barbero);
        switch (barbero) {
            case 1:
                controlador.activarBarbero1(true);
                controlador.activarCliente1(true);
                controlador.estado1("Atendiendo");
                break;
            case 2:
                controlador.activarBarbero2(true);
                controlador.activarCliente2(true);
                controlador.estado2("Atendiendo");
                break;
            case 3:
                controlador.activarBarbero3(true);
                controlador.activarCliente3(true);
                controlador.estado3("Atendiendo");
                break;
            case 4:
                controlador.activarBarbero4(true);
                controlador.activarCliente4(true);
                controlador.estado4("Atendiendo");
                break;
        }
    }
    
    public int despertar(int barbero) {
        
        AtencionCliente atender = new AtencionCliente();
        
        /*Cada barbero atiende a un cliente, es por ello que se
        crean hilos del mismo tipo de la clase*/
        System.out.println("Despertando al cliente-barbero " + barbero);
        switch (barbero) {
            case 1:
                atender.contador = barbero;
                atender.start();
                controlador.activarBarbero1(true);
                controlador.activarCliente1(true);
                break;
            case 2:
                atender.contador = barbero;
                atender.start();
                controlador.activarBarbero2(true);
                controlador.activarCliente2(true);
                break;
            case 3:
                atender.contador = barbero;
                atender.start();
                controlador.activarBarbero3(true);
                controlador.activarCliente3(true);
                break;

            case 4:
                atender.contador = barbero;
                atender.start();
                controlador.activarBarbero4(true);
                controlador.activarCliente4(true);
                break;
        }
        return 1;
    }

    public void quitarCliente(int cliente) {
        
        System.out.println("Quitando el cliente " + cliente);
        switch (cliente) {
            case 1:
                controlador.activarCliente1(false);
                break;
            case 2:
                controlador.activarCliente2(false);
                break;
            case 3:
                controlador.activarCliente3(false);
                break;
            case 4:
                controlador.activarCliente4(false);
                break;
            default:
                break;
        }
    }

    public int dormir(int barbero) {
        
        System.out.println("Durmiendo al barbero " + barbero);
        switch (barbero){
            case 1:
                controlador.activarBarbero1(false);
                controlador.estado1("Durmiendo");
                break;
            case 2:
                controlador.activarBarbero2(false);
                controlador.estado2("Durmiendo");
                break;
            case 3:
                controlador.activarBarbero3(false);
                controlador.estado3("Durmiendo");
                break;
            case 4:
                controlador.activarBarbero3(false);
                controlador.estado4("Durmiendo");
                break;
            default:
                controlador.activarBarbero4(false);
                controlador.estado4("Durmiendo");
                break;
        }
        return 1;
    }

    private static int getRandomNumberInRange(int min, int max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
