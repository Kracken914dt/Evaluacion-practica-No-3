
package co.edu.unicesar.vista;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.*;

public class GUI_Principal extends JDialog{
    private JLabel lbIdbn, lbTitulo, lbAutor, lbAnio, lbCosto;
    private JTextField txtIdbn;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAnio;
    private JFormattedTextField txtCosto;
    private JPanel panelDatos, panelBotones, principal;
    private JButton btnGuardar, btnCancelar, btnNuevo;
    private Container contenedor;
    
    
     public GUI_Principal(Frame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("Catalogo de Computadores - Registro - Version 1.0");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.inicializarComponentes();
        this.pack();
        //this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    private void inicializarComponentes() {
        this.contenedor=this.getContentPane();
        this.contenedor.setLayout(new FlowLayout());
        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
        this.principal.setBorder(BorderFactory.createTitledBorder("Registro de nuevo Libro"));
        this.inicializarPanelDatos();
        this.inicializarPanelBotones();
        this.contenedor.add(this.principal);
    }

    private void inicializarPanelDatos() {
        this.panelDatos=new JPanel();
        this.panelDatos.setLayout(new GridLayout(5,2,5,5));
        
        this.panelDatos = new JPanel();
        this.panelDatos.setLayout(new GridLayout(5,2,5,5));
        
        this.lbIdbn= new JLabel("Idbn: ");
        this.lbTitulo = new JLabel("Titulo: ");
        this.lbAutor = new JLabel("Autor: ");
        this.lbAnio = new JLabel("Anio: ");
        this.lbCosto = new JLabel("Costo $: ");
        
        this.txtIdbn = new JTextField(15);
        this.txtCosto = new JFormattedTextField(0);
        
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
        
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new FlowLayout());
        subPanel.add(this.panelDatos);
        subPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.principal.add(subPanel, BorderLayout.CENTER);
        
    }

    private void inicializarPanelBotones() {
        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(new GridLayout(3,1,5,5));
        
        this.btnNuevo = new JButton("Nuevo");
        this.btnGuardar = new JButton("Guardar");
        this.btnCancelar = new JButton("Cancelar");
        
        this.panelBotones.add(this.btnNuevo);
        this.panelBotones.add(this.btnGuardar);
        this.panelBotones.add(this.btnCancelar);
        
        JPanel subPanel = new JPanel();
        subPanel.setLayout(new FlowLayout());
        
        subPanel.add(this.panelBotones);
        subPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.principal.add(subPanel, BorderLayout.EAST);
    
    }
}
