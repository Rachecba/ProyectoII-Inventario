
package sistema.presentation.activos;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.Application;
import sistema.Sesion;
import sistema.logic.ActivoUniversitario;
import sistema.logic.Dependencia;
import sistema.logic.Funcionario;
import sistema.logic.Labor;
import sistema.logic.Model;
import sistema.logic.Solicitud;
import sistema.logic.Usuario;

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
        
        this.model.inicializaLabores(mainModel.getLaboresBox());
        
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
    
    public void datosUbicacion(int fila, Labor labor) throws Exception{
        ActivoUniversitario activo = model.getActivos().getRowAt(fila);
        
        mainModel.saveUbicacion(activo, labor);
        this.buscar();
    }
    
    public void changeEstadoProcesada(int fila) throws Exception{
        ActivoUniversitario activo = this.model.getActivos().getRowAt(fila);
        Solicitud nueva = activo.getActivoUniversitarioBien().getBienComprobante().getSolicitud();
        nueva.setSolicitudEstado("Procesada");
        mainModel.cambiarEstadoSolicitud(nueva);
        this.buscar();
    }
    
    public void codigoDeBarras(int fila) throws DocumentException, Exception{
        
        ActivoUniversitario activo = model.getActivos().getRowAt(fila);
        
        try {            
            Document doc = new Document();
            String userProfile = System.getenv("USERPROFILE");
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream(userProfile + "/Desktop/CodigoBarras.pdf"));
            
            doc.open();
            
            Barcode128 code = new Barcode128();
            code.setCode(activo.getActivoUniversitarioCodigo());
            Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            img.scalePercent(200);
            
            doc.add(img);
            
            doc.close();
        
        } catch (FileNotFoundException ex) {
            throw new Exception("Error al creer el codigo de barras.");
        }
    }
    
    public boolean permisoAdmin(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario"); //si es true, no es registrador, si es false si es registrador
       
        if (!Arrays.asList(Application.ADMINISTRADOR).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de registrador de bienes
            return false;
        }
        else
            return true;
    }
    
    public boolean permisoJefeOCCB(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario"); //si es true, no es registrador, si es false si es registrador
       
        if (!Arrays.asList(Application.JEFE_OCCB).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de registrador de bienes
            return false;
        }
        else
            return true;
    }
    
    public boolean permisoRegistrador(){
        Usuario principal = (Usuario) sesion.getAttribute("Usuario"); //si es true, no es registrador, si es false si es registrador
       
        if (!Arrays.asList(Application.REGISTRADOR_BIENES).contains(principal.getUsuarioRol())){ //verifica si el rol del usuario es de registrador de bienes
            return false;
        }
        else
            return true;
    }
    
    public void setModo(int modo){
         this.model.setModo(modo, "");
     }
    
     public void ocultar(){
        view.setVisible(false);
    }
     
    public void mostrar(){
        view.setVisible(true);
        view.inicializaPantalla();
    }
    
    public boolean getSession(){
        if(sesion.getAttribute("Usuario") == null)
            return false;
        else
            return true;
    }
    
    
}
