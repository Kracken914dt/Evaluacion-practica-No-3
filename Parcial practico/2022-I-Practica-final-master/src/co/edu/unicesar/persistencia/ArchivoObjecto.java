
package co.edu.unicesar.persistencia;
import co.edu.unicesar.Excepciones.ExcepcionArchiv;
import co.edu.unicesar.modelo.Publicacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArchivoObjecto implements IPublicacionDao {

    private File archivo;
    private FileInputStream modoLectura;
    private FileOutputStream modoEscritura;

    public ArchivoObjecto() {
        this("RegistroPublicacion.bin");
    }

    public  ArchivoObjecto(String path) {
        this.archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileInputStream getModoLectura() {
        return modoLectura;
    }

    public void setModoLectura(FileInputStream modoLectura) {
        this.modoLectura = modoLectura;
    }

    public FileOutputStream getModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(FileOutputStream modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    
    private void guardarArchivo(List<Publicacion> lista) throws ExcepcionArchiv {
        try {
            this.modoEscritura = new FileOutputStream(this.archivo);
            ObjectOutputStream oos = new ObjectOutputStream(this.modoEscritura);
            oos.writeObject(lista);
            oos.close();

        } catch (FileNotFoundException e) {
            throw new ExcepcionArchiv("Erro al abrir archivo de objetos, no existe");
        } catch (SecurityException e) {
            throw new ExcepcionArchiv("No tiene acceso para el archivo en modo escritura");
        } catch (NullPointerException e) {
            throw new ExcepcionArchiv("EL manejador de archivo en escritura en Null");
        } catch (IOException e) {
            throw new ExcepcionArchiv("Error al escribir en el archivo");
        }

    }

     private List<Publicacion> leerArchivo() throws ExcepcionArchiv {
        
        if(!this.archivo.exists()){
            return new ArrayList<Publicacion>();
        }
        
        try {
            this.modoLectura = new FileInputStream(this.archivo);
            ObjectInputStream ois = new ObjectInputStream(this.modoLectura);
            List<Publicacion> lista = (List<Publicacion>)ois.readObject();
            ois.close();
            return lista;

        } catch (FileNotFoundException e) {
            throw new ExcepcionArchiv("Erro al abrir archivo de objetos en modo lectura , no existe");
        } catch (SecurityException e) {
            throw new ExcepcionArchiv("No tiene acceso para el archivo en modo lectura");
        } catch (StreamCorruptedException e) {
            throw new ExcepcionArchiv("Error con el flujo de datos de cabecera del objeto");
        } catch (NullPointerException e) {
            throw new ExcepcionArchiv("EL manejador de archivo en lectura en Null");
        } catch (IOException e) {
            throw new ExcepcionArchiv("Error al leer en el archivo");
        }
        catch(ClassNotFoundException e){
            throw new ExcepcionArchiv("Error, el objeto leido del archivo no tiene clase definida");
        }

    }
    @Override
    public void insertarPublicacion(Publicacion p) throws ExcepcionArchiv {
        List<Publicacion> lista = this.leerArchivo();
        lista.add(p);
        this.guardarArchivo(lista);
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionArchiv {
            return this.leerArchivo();
    }

    
    
    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionArchiv {
          List<Publicacion> lista = this.leerArchivo();
          for(Publicacion b: lista){
              if(b.getIdbn().equals(p.getIdbn())){
                  return b;
              }
          }
          return null;    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionArchiv {
        List<Publicacion> lista = this.leerArchivo();
        Iterator<Publicacion>i = lista.iterator();
        Publicacion eliminado=null;
        while(i.hasNext()){
            Publicacion leido = i.next();
            if(leido.getIdbn().equals(p.getIdbn())){
                eliminado = leido;
                i.remove();
            }
        }
        this.guardarArchivo(lista);
        return eliminado;    }

}

    


