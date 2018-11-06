/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitudes;

import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import sistema.logic.Solicitud;

/**
 *
 * @author Rachel
 */
public class SolicitudesTableModel extends AbstractTableModel {
    List<Solicitud> rows;
    int[] cols;
    
    public  SolicitudesTableModel(int[] cols, List<Solicitud> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    @Override
    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case ESTADO: return Icon.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Solicitud solicitud = rows.get(row);
        switch (cols[col]){
            case ID: return solicitud.getSolicitudId();
            case COMPROBANTE: return solicitud.getSolicitudComprobante();
            case DEPENDENCIA: return solicitud.getSolicitudDependencia();
            case REGISTRADOR: return solicitud.getSolicitudRegistradorDeBienes();
            case ESTADO: return Solicitud(solicitud);
            default: return "";
        }
    }    

    private Icon Solicitud(Solicitud s){
        String file="";
        if (s.getSolicitudEstado().equals("Recibida")) file="recibida.jpeg" ;
        if (s.getSolicitudEstado().equals("Por verificar")) file="verificar.jpeg" ;
        if (s.getSolicitudEstado().equals("Rechazada")) file="rechazada.jpeg" ;
        if (s.getSolicitudEstado().equals("Espera de rotulacion")) file="rotulacion.jpeg" ;
        if (s.getSolicitudEstado().equals("Procesada")) file="procesada.jpeg" ;
        return new ImageIcon( getClass().getResource( "/sistema/presentation/iconos/estados/"+file)); 
    }
    
    public Solicitud getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int COMPROBANTE=0;
    public static final int DEPENDENCIA=1;
    public static final int ESTADO=2;
    public static final int REGISTRADOR=3;
    public static final int ID = 4;

    String[] colNames = new String[11];
    
    private void initColNames(){
        colNames[ID]= "Identificador";
        colNames[COMPROBANTE]= "Comprobante";
        colNames[DEPENDENCIA]= "Dependencia";
        colNames[REGISTRADOR]= "Registrador";
        colNames[ESTADO]= "Estado";
    }
}
