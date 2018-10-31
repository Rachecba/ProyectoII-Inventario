/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.dependencias;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.logic.Funcionario;
import sistema.logic.Labor;

/**
 *
 * @author Rachel
 */
public class FuncionariosTableModel extends AbstractTableModel{
     
    List<Labor> filas;
    int[] columnas;
    String[] nombres;
    
    //---------Variables fijas-----------
    public static final int PUESTO = 0;
    public static final int FUNCIONARIO = 1;
    
    public FuncionariosTableModel(List<Labor> filas, int[] columnas){
        this.filas = filas;
        this.columnas = columnas;
        nombres = new String[2];
        
        nombres[PUESTO] = "Puesto";
        nombres[FUNCIONARIO] = "Funcionario";
    }

     @Override
    public int getRowCount() {
       return filas.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }
    
    public Labor getRowAt(int fila){
        return filas.get(fila);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Labor labor = filas.get(rowIndex);
      
      switch(columnas[columnIndex]){
          case PUESTO: 
              return labor.getLaborPuesto().getPuestoNombre();
          case FUNCIONARIO:
              return labor.getLaborFuncionario().getFuncionarioNombre();
          default:
              return "";
      }
    }
    
     @Override
    public String getColumnName(int col){
        return nombres[columnas[col]];
    }
    
}
