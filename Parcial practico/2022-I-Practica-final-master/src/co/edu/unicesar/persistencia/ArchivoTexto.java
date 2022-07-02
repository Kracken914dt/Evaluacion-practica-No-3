
package co.edu.unicesar.persistencia;

import co.edu.unicesar.Excepciones.*;
import co.edu.unicesar.modelo.Publicacion;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArchivoTexto implements IPublicacionDao{
    private File archivo;
    private FileWriter modoEscritura;
    private Scanner modoLectura;

    public ArchivoTexto() {
        this("Registro.pb");
    }
    public ArchivoTexto(String ruta){
        this.archivo=new File(ruta);
    }


    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
     
    public FileWriter getmodoEscritura(){
        return modoEscritura;
    }

    public void setModoEscritura(FileWriter modoEscritura) {
        this.modoEscritura = modoEscritura;
    }

    public Scanner getModoLectura() {
        return modoLectura;
    }

    public void setModoLectura(Scanner modoLectura) {
        this.modoLectura = modoLectura;
    }
            

    @Override
    public void insertarPublicacion(Publicacion p)throws ExcepcionArchiv{
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(archivo, true);
            pw = new PrintWriter(this.modoEscritura);
            pw.println(p.getDataFileFormat());

        } catch (IOException ioe) {
            throw new ExcepcionArchiv("El archivo en modo escritura no existe o no pude ser creado");
         
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
 private Publicacion cargarDatos(String[] data){
        String idbn = data[0];
        String titulo = data[1];
        String autor = data[2];
        int anio = Integer.valueOf(data[3]);
        double costo = Double.valueOf(data[4]);
        return new Publicacion(idbn, titulo, autor, anio, costo) {
            @Override
            public String getDataStringFormat() {   
                return this.idbn + ";" + this.titulo + ";" + this.autor + ";" + this.anio + ";" + this.costo;
            }

            @Override
            public String getStringFormat() { 
                return this.idbn + ";" + this.titulo + ";" + this.autor + ";" + this.anio + ";" + this.costo;
            }
        };
    }

 @Override
    public List<Publicacion> leerPublicaciones() throws ExcepcionArchiv {
        List<Publicacion> lista;
        try {
            this.modoLectura = new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.modoLectura.hasNext()){
                String datos[] = this.modoLectura.nextLine().split(";");
                Publicacion p = this.cargarDatos(datos);
                lista.add(p);
            }
            return lista;
            
        } catch (FileNotFoundException ioe) {
            throw new ExcepcionArchiv("Error al abrir archivo en modo lectura, no existe");
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) throws ExcepcionArchiv{
        Publicacion buscado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String datos[] = this.modoLectura.nextLine().split(";");
                Publicacion aux = this.cargarDatos(datos);
                if(aux.getIdbn().equals(p.getIdbn())){
                    buscado=aux;
                    
                }
            }
            return buscado;
            
        } catch (FileNotFoundException ioe) {
            throw new ExcepcionArchiv("Error al abrir archivo en modo lectura, no existe");
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
        
    }
    private void renombrarArchivo(File tmp) throws IOException{
        if(!tmp.exists())
            throw new IOException("El archivo temporal no existe");
            
        if(!this.archivo.delete()){
            tmp.delete();
            throw new IOException("No es posible eliminar el archivo original");
        }
        
        if(!tmp.renameTo(this.archivo)){
            throw new IOException("No es posible renombrar el archivo temporal");
        }    
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) throws ExcepcionArchiv {
        Publicacion eliminado=null;
        ArchivoTexto archivoTmp = new ArchivoTexto("Registro.tmp");
        try {
            this.modoLectura = new Scanner(this.archivo);
            while(this.modoLectura.hasNext()){
                String datos[] = this.modoLectura.nextLine().split(";");
                Publicacion aux = this.cargarDatos(datos);
                if(aux.getIdbn().equals(p.getIdbn())){
                    eliminado = aux;
                }
                else{
                    archivoTmp.insertarPublicacion(aux);
                }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTmp.archivo);
            return eliminado;
            
        } catch (FileNotFoundException ioe) {
            throw new ExcepcionArchiv("Error al abrir archivo en modo lectura, no existe");
        }
        catch(IOException e){
            throw new ExcepcionArchiv(e.getMessage());
        }
        finally{
            if(this.modoLectura!=null)
                this.modoLectura.close();
        }
    }
}

