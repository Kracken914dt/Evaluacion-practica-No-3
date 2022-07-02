package co.edu.unicesar.vista;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI_Consulta extends JDialog{
    private JPanel principal, datos, busqueda;
    private JTable tabla;
    private JTextField txtBusqueda;
    private JLabel lbBusqueda;
    private DefaultTableModel modelotabla;
    private String titulos[]={"Idbn", "Titulo", "Autor", "Anio", "Costo"};
    private JScrollPane panelTabla;
    private Container contenedor;

    public GUI_Consulta(Frame frame, boolean bln) {
        super(frame, bln);
        this.setTitle("Catalogo de Libro y Audio Libro - Consulta");
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.inicializarComponentes();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void inicializarComponentes() {
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new FlowLayout());
        
        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
        this.iniciarPanelDatos();
        this.iniciarPanelBusqueda();
        this.contenedor.add(this.principal);
    }

    private void iniciarPanelDatos() {
        this.modelotabla = new DefaultTableModel(null, this.titulos);
        this.tabla = new JTable();
        this.tabla.setModel(this.modelotabla);
        this.panelTabla = new JScrollPane(this.tabla);
        this.datos = new JPanel();
        this.datos.setLayout(new FlowLayout());
        this.datos.add(this.panelTabla);
        this.datos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.principal.add(this.datos, BorderLayout.CENTER);
    }

    private void iniciarPanelBusqueda() {
        this.busqueda = new JPanel();
        this.busqueda.setLayout(new FlowLayout());
        
        this.lbBusqueda = new JLabel("Codigo Idbn: ");
        this.txtBusqueda = new JTextField(15);
        
        this.busqueda.add(this.lbBusqueda);
        this.busqueda.add(this.txtBusqueda);
        
        this.busqueda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        this.principal.add(this.busqueda, BorderLayout.NORTH);
    }
    
}
