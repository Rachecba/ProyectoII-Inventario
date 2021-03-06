/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.solicitudes;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.logic.Bien;

/**
 *
 * @author Rachel
 */
public class BienesTableModel extends AbstractTableModel{
    
    List<Bien> filas;
    int[] columnas;
    String[] nombres;
    
    //---------Variables fijas-----------
    public static final int COMPROBANTE = 0;
    public static final int MODELO = 1;
    public static final int MARCA = 2;
    public static final int PRECIO = 3;
    public static final int CANTIDAD = 4;
    public static final int DESCRIPCION = 5;
    public static final int CATEGORIA = 6;
    
     public BienesTableModel(List<Bien> filas, int[] columnas){
        this.filas = filas;
        this.columnas = columnas;
        nombres = new String[7];
        
        nombres[COMPROBANTE] = "Comprobante";
        nombres[MODELO] = "Modelo";
        nombres[MARCA] = "Marca";
        nombres[PRECIO] = "Precio unitario";
        nombres[CANTIDAD] = "Cantidad";
        nombres[DESCRIPCION] = "Descripcion de bien";
        nombres[CATEGORIA] = "Categoria";
    }


    @Override
    public int getRowCount() {
       return filas.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }
    
    public Bien getRowAt(int fila){
        return filas.get(fila);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bien bien = filas.get(rowIndex);
      
      switch(columnas[columnIndex]){
          case COMPROBANTE: 
              return bien.getBienComprobante().getComprobanteId();
          case MODELO:
              return bien.getBienModelo();
          case MARCA:
              return bien.getBienMarca();
          case PRECIO:
              return bien.getBienPrecio();
          case CANTIDAD:
              return bien.getBienCantidad();
          case DESCRIPCION:
              return bien.getBienDescripcion();
          case CATEGORIA:
              return bien.getBienCategoria();
          default:
              return "";
      }
    }
    
    @Override
    public String getColumnName(int col){
        return nombres[columnas[col]];
    }
}
