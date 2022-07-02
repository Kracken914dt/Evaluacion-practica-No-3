/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicesar.persistencia;
import co.edu.unicesar.Excepciones.ExcepcionArchiv;
import co.edu.unicesar.modelo.Publicacion;
import java.util.List;

/**
 *
 * @author JAIRO
 */
public interface IPublicacionDao {
    
    void insertarPublicacion(Publicacion p) throws ExcepcionArchiv;
    List<Publicacion> leerPublicaciones()throws ExcepcionArchiv;
    Publicacion buscarPublicacion(Publicacion p)throws ExcepcionArchiv;
    Publicacion eliminarPublicacion(Publicacion p)throws ExcepcionArchiv;
    
}
