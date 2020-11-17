import java.util.LinkedList;
import java.util.Queue;

public class Atender extends Thread{
   
    private Queue<Grupo> colaGrupo;
    private Heladeria heladeria;
    
    public Atender(){
        
        this.colaGrupo = new LinkedList();
        this.heladeria = new Heladeria();
    }
    
        private void guardarGrupos(){
        
        colaGrupo.add(new Grupo(3, heladeria.getSabores()));
        colaGrupo.add(new Grupo(3, heladeria.getSabores()));
        colaGrupo.add(new Grupo(3, heladeria.getSabores()));
    }
}
