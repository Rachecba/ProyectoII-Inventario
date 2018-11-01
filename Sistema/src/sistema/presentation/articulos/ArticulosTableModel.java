
package sistema.presentation.articulos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.logic.Categoria;

/**
 *
 * @author Rachel
 */
public class ArticulosTableModel extends AbstractTableModel{
    
    List<Categoria> filas;
    int[] columnas;
    String[] nombres;
    
    //---------Variables fijas-----------
    public static final int NOMBRE = 0;
    public static final int DESCRIPCION = 1;
    
     public ArticulosTableModel(List<Categoria> filas, int[] columnas){
        this.filas = filas;
        this.columnas = columnas;
        nombres = new String[2];
        
        nombres[NOMBRE] = "Nombre";
        nombres[DESCRIPCION] = "Descripcion";
    }

     @Override
    public String getColumnName(int col){
        return nombres[columnas[col]];
    }

    @Override
    public int getRowCount() {
        return this.filas.size();   
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoria = filas.get(rowIndex);
      
      switch(columnas[columnIndex]){
          case NOMBRE: 
              return categoria.getCategoriaNombre();
          case DESCRIPCION:
              return categoria.getCategoriaDescripcion();
          default:
              return "";
      }
    }
    
    public Categoria getRowAt(int fila){
        return filas.get(fila);
    }   
    
}
