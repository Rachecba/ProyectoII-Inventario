package sistema;

import javax.persistence.EntityManagerFactory;
import sistema.data.PuestoDAO;
import sistema.logic.Model;
import sistema.logic.Puesto;
import sistema.presentation.activos.ActivosController;
import sistema.presentation.activos.ActivosView;
import sistema.presentation.articulos.ArticulosController;
import sistema.presentation.dependencias.DependenciasController;
import sistema.presentation.funcionarios.FuncionariosController;
import sistema.presentation.login.LoginController;
import sistema.presentation.login.LoginModel;
import sistema.presentation.login.LoginView;
import sistema.presentation.principal.PrincipalController;
import sistema.presentation.principal.PrincipalModel;
import sistema.presentation.principal.PrincipalView;
import sistema.presentation.solicitudes.SolicitudesController;
import sistema.presentation.solicitudes.SolicitudesView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rachel
 */
public class Application {

    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Puesto p = new Puesto();
        PuestoDAO pDao = new PuestoDAO(factory);
        p.setPuestoNombre("Puesto1");
        
        pDao.create(p);
        
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
        
     //   ActivosModel activosModel = new ActivosModel();
        ActivosView activosView = new ActivosView();
        
     //   ActivosController activosController = new ActivosController(activosModel, activosView, mainMode, sesion);
     //   ACTIVOS_CONTROLLER = activosController;
     
     //   ArticulosModel articulosModel = new ArticulosModel();
     //   ArticulosView articulosView = new ArticulosView();
     //   ArticulosController articulosController = new ArticulosController();
     //   ARTICULOS_CONTROLLER = articulosController;
        
//        DependenciasModel dependenciasModel = new DependenciasModel();
//        DependenciasView dependenciasView = new DependenciasView();
//        DependenciasController dependenciasController = new DependenciasController();
//        DEPENDENCIAS_CONTROLLER = dependenciasController;

//        FuncionariosModel funcionariosModel = new FuncionariosModel();
//        FuncionariosView funcionariosView = new FuncionariosView();
//        FuncionariosController funcionariosController = new FuncionariosController();
//        FUNCIONARIOS_CONTROLLER = funcionariosController;
        
 //       SolicitudesModel solicitudesModel = new SolicitudesModel();
 //      SolicitudesView solicitudesView = new SolicitudesView();
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
}
