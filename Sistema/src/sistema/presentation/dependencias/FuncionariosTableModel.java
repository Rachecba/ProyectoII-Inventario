/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.dependencias;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sistema.logic.Funcionario;

/**
 *
 * @author Rachel
 */
public class FuncionariosTableModel extends AbstractTableModel{
     
    List<Funcionario> filas;
    int[] columnas;
    String[] nombres;
    
    //---------Variables fijas-----------
    public static final int CEDULA = 0;
    public static final int NOMBRE = 1;
    
    public FuncionariosTableModel(List<Funcionario> filas, int[] columnas){
        this.filas = filas;
        this.columnas = columnas;
        nombres = new String[2];
        
        nombres[CEDULA] = "Cedula";
        nombres[NOMBRE] = "Nombre";
    }

     @Override
    public int getRowCount() {
       return filas.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }
    
    public Funcionario getRowAt(int fila){
        return filas.get(fila);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario funcionario = filas.get(rowIndex);
      
      switch(columnas[columnIndex]){
          case CEDULA: 
              return funcionario.getFuncionarioCedula();
          case NOMBRE:
              return funcionario.getFuncionarioNombre();
          default:
              return "";
      }
    }
    
     @Override
    public String getColumnName(int col){
        return nombres[columnas[col]];
    }
    
}
