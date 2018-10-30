package sistema;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sistema.data.PuestoDAO;
import sistema.logic.Model;
import sistema.logic.Puesto;
import sistema.presentation.activos.ActivosController;
import sistema.presentation.activos.ActivosView;
import sistema.presentation.articulos.ArticulosController;
import sistema.presentation.dependencias.DependenciasController;
import sistema.presentation.dependencias.DependenciasModel;
import sistema.presentation.dependencias.DependenciasView;
import sistema.presentation.funcionarios.FuncionariosController;
import sistema.presentation.funcionarios.FuncionariosModel;
import sistema.presentation.funcionarios.FuncionariosView;
import sistema.presentation.login.LoginController;
import sistema.presentation.login.LoginModel;
import sistema.presentation.login.LoginView;
import sistema.presentation.principal.PrincipalController;
import sistema.presentation.principal.PrincipalModel;
import sistema.presentation.principal.PrincipalView;
import sistema.presentation.solicitudes.SolicitudesController;
import sistema.presentation.solicitudes.SolicitudesView;

/**
 *
 * @author Rachel
 */
public class Application {

    public static void main(String[] args) {
//        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "SistemaPU" );
//        PuestoDAO pDao = new PuestoDAO(emfactory);
//        for(Puesto p : pDao.findAll()){
//            System.out.print(p.toString() + "\n\n");
//        }
                
        
        //-----------------------------------------------------------------
        Model mainModel = Model.instance();
        Sesion sesion = new Sesion();
        
        PrincipalModel principalModel = new PrincipalModel();
        PrincipalView principalView = new PrincipalView();
        PrincipalController principalController = new PrincipalController(principalView, principalModel, mainModel, sesion);
        PRINCIPAL_CONTROLLER = principalController;
        
        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginModel, loginView, mainModel, sesion);
        LOGIN_CONTROLLER = loginController;
        loginView.setVisible(true);
        
     //   ActivosModel activosModel = new ActivosModel();
//        ActivosView activosView = new ActivosView();
//        principalView.addInternalFrame(activosView);
     //   ActivosController activosController = new ActivosController(activosModel, activosView, mainMode, sesion);
     //   ACTIVOS_CONTROLLER = activosController;
     
     //   ArticulosModel articulosModel = new ArticulosModel();
     //   ArticulosView articulosView = new ArticulosView();
     //   principalView.addInternalFrame(articulosView);
     //   ArticulosController articulosController = new ArticulosController();
     //   ARTICULOS_CONTROLLER = articulosController;
        
        DependenciasModel dependenciasModel = new DependenciasModel();
        DependenciasView dependenciasView = new DependenciasView();
        principalView.addInternalFrame(dependenciasView);
        DependenciasController dependenciasController = new DependenciasController(dependenciasModel, dependenciasView, mainModel, sesion);
        DEPENDENCIAS_CONTROLLER = dependenciasController;

        FuncionariosModel funcionariosModel = new FuncionariosModel();
        FuncionariosView funcionariosView = new FuncionariosView();
        principalView.addInternalFrame(funcionariosView);
        FuncionariosController funcionariosController = new FuncionariosController(funcionariosModel, funcionariosView, mainModel, sesion);
        FUNCIONARIOS_CONTROLLER = funcionariosController;
        
 //       SolicitudesModel solicitudesModel = new SolicitudesModel();
 //       SolicitudesView solicitudesView = new SolicitudesView();
 //       principalView.addInternalFrame(solicitudesView);
 //       SolicitudesController solicitudesController = new SolicitudesController();
 //       SOLICITUDES_CONTROLLER solicitudesController;
 
    }
    
    //-------------------VARIABLES GLOBALES----------------------------
        
        public static PrincipalController PRINCIPAL_CONTROLLER;
        public static LoginController LOGIN_CONTROLLER;
        public static ActivosController ACTIVOS_CONTROLLER;
        public static ArticulosController ARTICULOS_CONTROLLER;
        public static DependenciasController DEPENDENCIAS_CONTROLLER;
        public static FuncionariosController FUNCIONARIOS_CONTROLLER;
        public static SolicitudesController SOLICITUDES_CONTROLLER;
        
        //-----------------ROLES DE USUARIO--------------------------------
        public static String ADMINISTRADOR = "Administrador";
        public static String SECRETARIA = "Secretaria OCCB";
        public static String JEFE_OCCB = "Jefe OCCB";
        public static String REGISTRADOR_BIENES = "Registrador de bienes";
        public static String JEFE_RRHH = "Jefe RRHH";
        
        //---------------MODOS-------------------
        public static  final int AGREGAR=0; //depende de los permisos del usuario
        public static final int EDITAR=1;
        public static final int CONSULTAR=2;
        public static final int EDITAR_FUNCIONARIO = 3; //para editar funcionario en la pantalla de dependencias
}
