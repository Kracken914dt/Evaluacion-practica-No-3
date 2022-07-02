/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicesar.persistencia;

import co.edu.unicesar.modelo.Publicacion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 *
 * @author JAIRO
 */
public class ArrayListPublicacion implements IPublicacionDao {
    private List<Publicacion> listaPublicacion;

    public ArrayListPublicacion() {
        this.listaPublicacion = new ArrayList();
    }
    
    
    @Override
    public void insertarPublicacion(Publicacion p) {
        this.listaPublicacion.add(p);
    }
    
    public int total() {
        return this.listaPublicacion.size();
    }

    @Override
    public List<Publicacion> leerPublicaciones() {
       List<Publicacion> lista = new ArrayList(this.listaPublicacion);
       return lista;
    }

    @Override
    public Publicacion buscarPublicacion(Publicacion p) {
        Publicacion buscar=null;
        for(Publicacion i: this.listaPublicacion){
            if(i.getIdbn().equals(p.getIdbn())){
                buscar = i;
                break;
            }
        }
        return buscar;
        
    }

    @Override
    public Publicacion eliminarPublicacion(Publicacion p) {
        Iterator<Publicacion> i = this.listaPublicacion.iterator();
        Publicacion eliminado=null;
        while(i.hasNext()){
            Publicacion aux = i.next();
            if(aux.getIdbn().equals(p.getIdbn())){
                eliminado = aux;
                i.remove();
                break;
            }
        }
        return eliminado;
    }
    
}
