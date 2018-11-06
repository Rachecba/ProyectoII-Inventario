
package sistema.presentation.activos;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.logic.ActivoUniversitario;

/**
 *
 * @author Rachel
 */
public class ActivosTableModel extends AbstractTableModel{
    
    List<ActivoUniversitario> filas;
    int[] columnas;
    String[] nombres;
    
    //---------Variables fijas-----------
    public static final int CODIGO = 0;
    public static final int CATEGORIA = 1;
    public static final int DESCRIPCION = 4;
    public static final int DEPENDENCIA = 3;
    public static final int RESPONSABLE = 2;
    
    public ActivosTableModel(List<ActivoUniversitario> filas, int[] columnas){
        this.filas = filas;
        this.columnas = columnas;
        nombres = new String[6];
        
        nombres[CODIGO] = "Codigo";
        nombres[CATEGORIA] = "Categoria";
        nombres[DESCRIPCION] = "Descripcion";
        nombres[DEPENDENCIA] = "Dependencia";
        nombres[RESPONSABLE] = "Responsable";
    }

    @Override
    public int getRowCount() {
       return filas.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }
    
    public ActivoUniversitario getRowAt(int fila){
        return filas.get(fila);
    }

     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ActivoUniversitario activo = filas.get(rowIndex);
      
      switch(columnas[columnIndex]){
          case CODIGO: 
              return activo.getActivoUniversitarioCodigo();
          case CATEGORIA:
              return activo.getActivoUniversitarioCategoria();
          case DESCRIPCION:
              return activo.getActivoUniversitarioDescripcion();
          case DEPENDENCIA:
              if(activo.getActivoUniversitarioResponsable() != null)
                  return activo.getActivoUniversitarioResponsable().getLaborDependencia();
              else
                  return "";
          case RESPONSABLE:
              if(activo.getActivoUniversitarioResponsable() != null)
                  return activo.getActivoUniversitarioResponsable().getLaborFuncionario();
              else
                  return "";
          default:
              return "";
      }
    }
    
    @Override
    public String getColumnName(int col){
        return nombres[columnas[col]];
    }
    
}
