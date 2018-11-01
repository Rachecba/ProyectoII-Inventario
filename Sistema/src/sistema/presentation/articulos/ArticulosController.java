
package sistema.presentation.articulos;

import java.util.List;
import sistema.Application;
import sistema.Sesion;
import sistema.logic.Categoria;
import sistema.logic.Model;

/**
 *
 * @author Rachel
 */
   public class ArticulosController {
    
    Model mainModel;
    Sesion sesion;
    ArticulosModel model;
    ArticulosView view;
    
    public ArticulosController(ArticulosModel model, ArticulosView view, Model main, Sesion sesion){
        this.model = model;
        this.mainModel = main;
        this.view = view;
        this.sesion = sesion;
        
        view.setController(this);
        view.setModel(model);
    }
    
     public void ocultar(){
        view.setVisible(false);
    }
     
     public void mostrar(){
         view.setVisible(true);
     }
     
     public void setModo(int modo, int fila){
         Categoria seleccionada = model.getTable().getRowAt(fila);
         this.model.setModo(modo, seleccionada);
     }
     
     public void setTabla() throws Exception{
         List<Categoria> categorias = mainModel.buscarCategorias(model.getFiltro());
         model.setTable(categorias);
         model.notificar();
         
         if(categorias.isEmpty())
             throw new Exception("Categoria no encontrada");
     }
     
     public void buscarTodos() throws Exception{
         Categoria categoria = new Categoria();
         model.setFiltro(categoria);
         this.model.setModo(Application.AGREGAR, categoria);
         this.setTabla();
     }
     
     public void buscar(Categoria filtro) throws Exception{
         model.setFiltro(filtro);
         model.setModo(Application.AGREGAR, filtro);
         this.setTabla();
     }
     
     public void reset(){
         model.inicializa();
     }
     
     public void agregarCategoria(Categoria nueva) throws Exception{
         
         switch(this.model.getModo()){
             case Application.AGREGAR:
                 mainModel.agregarCategoria(nueva);
                 this.model.setFiltro(nueva);
                 this.model.setModo(Application.AGREGAR, nueva);
                 this.setTabla();
                 break;
                 
             case Application.EDITAR:
                 mainModel.agregarCategoria(nueva);
                 this.model.setModo(Application.AGREGAR, nueva);
                 this.setTabla();
                 break;
         }
     }
     
     public void borrar(int fila) throws Exception{
         Categoria seleccionada = model.getTable().getRowAt(fila);
         model.setModo(Application.AGREGAR, new Categoria());
         
         try{
             mainModel.eliminarCategoria(seleccionada);
         }catch(Exception ex){
             System.out.print("Error" + ex);
         }
         
         this.setTabla();
     }
}
