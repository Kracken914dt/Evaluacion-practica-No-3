
package co.edu.unicesar.vista;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.*;
public class GUI_Registro extends JDialog{
    private JPanel panelPrincipal, panelDatos, panelOpciones;
    private JButton btnNuevo, brnguardar, btnCancelar;
    private JLabel lbIdbn, lbTitulo, lbAutor, lbAnio, lbCosto;
    private JTextField txtIdbn;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAnio;
    private JFormattedTextField txtCosto;
    private Container contenedor;
    
    public GUI_Registro(Frame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("Registro de Computadores - Version 1.0");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.iniciarComponentes();
        //this.setSize(300, 200);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void iniciarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new FlowLayout());
        
        this.panelPrincipal = new JPanel();
        this.panelPrincipal.setLayout(new BorderLayout());
        
        this.iniciarPanelDatos();
        this.iniciarPanelOpciones();
        
        this.panelPrincipal.setBorder(BorderFactory.createTitledBorder("Datos basicos de pc"));
       
        this.contenedor.add(this.panelPrincipal);
    }

    private void iniciarPanelDatos() {
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(5,5,5,5));
        
        this.lbIdbn= new JLabel("Idbn : ");
        this.lbTitulo = new JLabel("Titulo: ");
        this.lbAutor = new JLabel("Autor: ");
        this.lbAnio = new JLabel("Anio: ");
        this.lbCosto = new JLabel("Costo $: ");
        
        this.txtIdbn = new JTextField(15);
        this.txtCosto = new JFormattedTextField(new Integer(0));
        
        
        this.panelDatos.add(this.lbIdbn);
        this.panelDatos.add(this.txtIdbn);
        
        this.panelDatos.add(this.lbTitulo);
        this.panelDatos.add(this.txtTitulo);
        
        this.panelDatos.add(this.lbAutor);
        this.panelDatos.add(this.txtAutor);
        
        this.panelDatos.add(this.lbAnio);
        this.panelDatos.add(this.txtAnio);
        
        this.panelDatos.add(this.lbCosto);
        this.panelDatos.add(this.txtCosto);
        
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.panelPrincipal.add(this.panelDatos, BorderLayout.CENTER);
        
    }

    private void iniciarPanelOpciones() {
        this.panelOpciones = new JPanel();
        this.panelOpciones.setLayout(new GridLayout(5,5,5,5));
        
        this.brnguardar = new JButton("Guardar");
        this.btnCancelar = new JButton("Cancelar");
        this.btnNuevo = new JButton("Nuevo");
        
        this.panelOpciones.add(this.btnNuevo);
        this.panelOpciones.add(this.brnguardar);
        this.panelOpciones.add(this.btnCancelar);
        
        this.panelOpciones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.panelPrincipal.add(this.panelOpciones, BorderLayout.EAST);
    }
}
