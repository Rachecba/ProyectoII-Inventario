/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.dependencias;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.logic.Dependencia;

/**
 *
 * @author Rachel
 */
public class DependenciasTableModel extends AbstractTableModel{
    
    List<Dependencia> filas;
    int[] columnas;
    String[] nombres;
    
    //---------Variables fijas-----------
    public static final int NOMBRE = 0;
    public static final int ADMINISTRADOR = 1;
    
    public DependenciasTableModel(List<Dependencia> filas, int[] columnas){
        this.filas = filas;
        this.columnas = columnas;
        nombres = new String[2];
        
        nombres[NOMBRE] = "Nombre";
        nombres[ADMINISTRADOR] = "Administrador";
    }

    @Override
    public int getRowCount() {
       return filas.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }
    
    public Dependencia getRowAt(int fila){
        return filas.get(fila);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dependencia dependencia = filas.get(rowIndex);
      
      switch(columnas[columnIndex]){
          case NOMBRE: 
              return dependencia.getDependenciaNombre();
          case ADMINISTRADOR:
              return dependencia.getDependenciaAdministrador().getFuncionarioNombre();
          default:
              return "";
      }
    }
    
    @Override
    public String getColumnName(int col){
        return nombres[columnas[col]];
    }
    
}
