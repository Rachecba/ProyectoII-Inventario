/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitud;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.logic.Bien;

/**
 *
 * @author leaca
 */
public class BienTableModel extends AbstractTableModel {
    List<Bien> rows;
    int[] cols;
    
    public  BienTableModel(int[] cols, List<Bien> rows){
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
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Bien bien = rows.get(row);
        switch (cols[col]){
            case DESCRIPCION: return bien.getBienDescripcion();
            case MODELO: return bien.getBienModelo();
            case MARCA: return bien.getBienMarca();
            case PRECIO: return bien.getBienPrecio();
            case CANTIDAD: return bien.getBienCantidad();
            default: return "";
        }
    }    
    
    public Bien getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int DESCRIPCION=0;
    public static final int MARCA=1;
    public static final int PRECIO=2;
    public static final int SOLICITUD=3;
    public static final int ID = 4;
    public static final int CANTIDAD=5;
    public static final int MODELO=6;

    String[] colNames = new String[11];
    
    private void initColNames(){
        colNames[DESCRIPCION]= "Descripcion";
        colNames[MARCA]= "Marca";
        colNames[MODELO]= "Modelo";
        colNames[PRECIO]= "Precio";
        colNames[SOLICITUD]= "Solicitud";
        colNames[CANTIDAD]= "Cantidad";
    }
}
