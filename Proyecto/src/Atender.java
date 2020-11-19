import java.util.LinkedList;
import java.util.Queue;

/*Esta clase se encarga de atender a las personas */
public class Atender{
   
    private Heladeria heladeria;
    private Queue<Grupo> colaGrupo;
    
    public Atender(){
        
        this.colaGrupo = new LinkedList();
        this.heladeria = new Heladeria();
    }
    
    private void guardarGrupos(){

        colaGrupo.add(new Grupo(3, heladeria.getSabores()));
        colaGrupo.add(new Grupo(3, heladeria.getSabores()));
        colaGrupo.add(new Grupo(3, heladeria.getSabores()));
    }
    
    //Revisar
    
    private void verificarProductos(String helado) throws InterruptedException{
        
        if(!heladeria.verificarBarquillos()){
                System.out.println("Rellenando barquillos");
                Thread.sleep(2000);
                heladeria.llenarBarquillos();
        }
        if(!heladeria.verificarServilletas()){
                System.out.println("Rellenando servilletas");
                Thread.sleep(2000);
                heladeria.llenarServilletas();
        }
        if(!heladeria.verificarSabor(helado)){
                System.out.println("Rellenando sabor " + helado);
                Thread.sleep(2000);
                heladeria.llenarSabor(helado);
        }
    }
    
    private void obtenerPersonas(){
        
        for(int i = 0; i < colaGrupo.peek().getTamanioGrupo(); i++){
            
            colaGrupo.poll().run(1);
        }
    }
        
    private void servilletas(){}
    private void barquillos(){}
    //Implementar semáforos
}
