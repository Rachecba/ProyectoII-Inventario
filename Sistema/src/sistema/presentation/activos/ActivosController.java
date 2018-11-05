
package sistema.presentation.activos;

import java.util.List;
import sistema.Sesion;
import sistema.logic.ActivoUniversitario;
import sistema.logic.Model;

/**
 *
 * @author Rachel
 */
public class ActivosController {
    
    Model mainModel;
    Sesion sesion;   
    ActivosView view;
    ActivosModel model;
    
    public ActivosController(ActivosModel model, ActivosView view, Model mainModel,Sesion sesion) {
        this.mainModel= mainModel;
        this.sesion=sesion;
        
        this.view = view;
        this.model = model;
        
        this.model.inicializaFuncionarios(mainModel.getFuncionariosBox());
        this.model.inicializaDependencias(mainModel.getDependenciasBox());
        
        this.view.setController(this);
        this.view.setModel(model);
    }
    
    public void buscar(String filter) throws Exception{
        model.setFiltro(filter);
        this.buscar();        
    }
    
    public void buscarTodos() throws Exception{
//         ActivoUniversitario activo = new ActivoUniversitario();
         model.setFiltro("");
         this.buscar();
     }
    
    public void buscar() throws Exception{        
            List<ActivoUniversitario> activos = mainModel.buscarActivos(model.getFiltro());
            model.setTable(activos);
            model.notificar();
            
            if(activos.isEmpty())
                throw new Exception("Activo no encontrado");
    
    }
    
    public void buscarEtiquetados() throws Exception{
        List<ActivoUniversitario> activos = mainModel.buscarActivosEtiquetados();
        model.setTable(activos);
        model.notificar();
        
        if(activos.isEmpty())
            throw new Exception("Activo no encontrado");
    }
    
     public void ocultar(){
        view.setVisible(false);
    }
     
    public void mostrar(){
        view.setVisible(true);
    }
    
}
