
package co.edu.unicesar.modelo;

import co.edu.unicesar.Excepciones.ExcepcionArchiv;
import co.edu.unicesar.persistencia.*;
import co.edu.unicesar.persistencia.IPublicacionDao;
import java.util.List;
import co.edu.unicesar.persistencia.ArchivoTexto;
import co.edu.unicesar.persistencia.ArchivoObjecto;
import javax.swing.JOptionPane;
/**
 *
 * @author JAIRO
 */
public class ListaPublicacion implements IPublicacionDao {
    
    private IPublicacionDao registroPublicaciones;

    public ListaPublicacion() {
         String Opcion = JOptionPane.showInputDialog("Ingrese donde desea guardar los datos \n 1 ArrayList(Temporal) \n 2 Archivo de Objecto \n 3 Archivo de Texto");
        int Opciones = Integer.parseInt(Opcion);
        switch(Opciones){
            case 1:
                this.registroPublicaciones = new ArrayListPublicacion();
                break;
            case 2:
                this.registroPublicaciones = new ArchivoObjecto();
                break;
            case 3:
                this.registroPublicaciones = new ArchivoTexto();  
                break;
        }
    }
    
    
    @Override
    public void insertarPublicacion(Publicacion p) throws ExcepcionArchiv{
        
        this.registroPublicaciones.insertarPublicacion(p);
        
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionArchiv{
        
        return this.registroPublicaciones.leerPublicaciones();
        
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionArchiv{
        
        return this.registroPublicaciones.buscarPublicacion(p);
        
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionArchiv{
        
        return this.registroPublicaciones.eliminarPublicacion(p);
        
    }
    
}
