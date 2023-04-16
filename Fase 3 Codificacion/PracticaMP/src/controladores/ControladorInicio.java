package controladores;

import java.util.Scanner;
import menus.MenuInicio;
import menus.MenuRegistro;
import menus.MenuIniciarSesion;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
public class ControladorInicio {

    private MenuInicio menuInicio;
    private MenuRegistro menuRegistro;
    private MenuIniciarSesion menuIniciarSesion;
    //private FabricaUsuarios fabricaUsuarios;
    private int modo; //modo 0 es seleccion, modo 1 es introducir Nick registrarse, modo 2 es tipo de usuario, modo 3 es si/no, modo 4 es introducir nick iniciosesion

    public ControladorInicio() {
        this.menuInicio = new MenuInicio();
        this.menuRegistro = new MenuRegistro();
        this.menuIniciarSesion = new MenuIniciarSesion();
        this.modo = 0;
    }

    public void iniciarControlador() {
        boolean salir = false;
        while (!salir) {
            this.modo = 0;
            String opcion = this.menuInicio.mostrarMensaje(0);
            boolean valido = validarEntrada(opcion);
            if (valido) {
                salir = procesarEntrada(opcion);
            } else {
                this.menuInicio.mostrarMensajeError(0);
            }
        }
    }

    private boolean validarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> {
                return opcion.equals("1") || opcion.equals("2") || opcion.equals("3");
            }
            case 1 -> {
                return nickUnico(opcion) || opcion.equals("salir"); //habrá que revisar lo de salir por el tema mayusculas
            }
            case 2 ->{
                return opcion.equals("admin") ||opcion.equals("jugador");
            }
            case 3 ->{
                return opcion.equals("si") || opcion.equals("no");
            }
            case 4 -> {
                return nickUnico(opcion) || opcion.equals("salir"); 
            }
            case 5 -> {
               return contraseniaValida(opcion) || opcion.equals("salir");
            }
            case 6 ->{ //ya hay un caso que hace esto (modo 3), por qué no reutilizarlo?
                return opcion.equals("si") || opcion.equals("no");
            }
        }
        return false;
    }

    
    private boolean procesarEntrada(String opcion) {
        switch (this.modo) {
            case 0 -> { //menú de inicio, decides si iniciar sesión o registrarte
                switch (opcion) {
                    case "1" ->
                        iniciarSesion();
                    case "2" ->
                        registrarse();
                    default -> {
                        String optSalir = this.menuInicio.mostrarMensaje(1);
                        this.modo = 3;
                        boolean valido = validarEntrada(optSalir);
                        if (valido) {
                            return optSalir.equals("si");
                        }
                    }
                }
            }
            case 1 -> {
                if (!opcion.equals("salir")){
                    
                }
            }
            case 3 ->{
                if (opcion.equals("si")){
                    //crear usuario con la fabrica de usuarios
                    System.out.println("El usuario no se ha creado porque no está implementado"); // Está a modo de placeholder, aún no está terminado
                }
            }
            case 6 ->{
                if (opcion.equals("si")){
                    // <BYPASS>
                    System.out.println("Quieres iniciar sesión como admin o jugador? (admin/jugador)");
                    Scanner sc = new Scanner(System.in);
                    String isAdmin = sc.nextLine();
                    // </BYPASS>
                    if (isAdmin.equals("admin")){
                        ControladorAdmin cAdmin = new ControladorAdmin();
                        cAdmin.iniciarControlador();
                    } else {
                        //ControladorJugador cJug = new ControladorJugador();
                        //cJug.iniciarControlador();
                    }
                    //Iniciar sesión; Crear un ControladorJugador/ControladorAdmin y pasarle el control
                    System.out.println("no se inicia sesion poque no esta implementado jugador/admin"); // Está a modo de placeholder, aún no está terminado
                }
            }
        }
        return false;
    }

    private void registrarse(){
        String opcion = "";
        boolean valido = false;
        while (!valido){
            this.modo = 1;
            opcion = this.menuRegistro.mostrarMensaje(0);
            valido = validarEntrada(opcion);
        
            if (!valido) {
                this.menuInicio.mostrarMensajeError(0); //ponía this.modo
            }
        }
        String nick = opcion;
        String usuario = this.menuRegistro.mostrarMensaje(1);
        String contrasenia = this.menuRegistro.mostrarMensaje(2);
        
        do { //introduce tipo de usuario
            this.modo = 2;
            opcion = this.menuRegistro.mostrarMensaje(3);
            valido = validarEntrada(opcion);
        } while (!valido); //pedir input hasta recibir uno válido
        
        String tipoUsuario = opcion;
        
        
        do { //quieres crear este usuario?
            this.modo = 3;
            opcion = this.menuRegistro.mostrarMensaje(4);
            valido = validarEntrada(opcion);
        } while (!valido); //pedir input hasta recibir uno válido
        
        procesarEntrada(opcion);
        
    }

    private boolean nickUnico(String opcion) {
        //debería comprobar en la base de datos si el nick es único, y devolver True en caso de que lo sea
        return true;
    }
    
   private  void iniciarSesion(){
        String opcion;
        boolean valido = false;
        do {
            this.modo = 4;
            opcion = this.menuIniciarSesion.mostrarMensaje(0);
            valido = validarEntrada(opcion);
        
            if (!valido) {
                this.menuIniciarSesion.mostrarMensajeError(0); 
           }
        } while (!valido);
        if (opcion.equals("salir")){
            return;
        }
        
        do{ //introduce contraseña
            this.modo = 5;
            opcion = this.menuIniciarSesion.mostrarMensaje(1);
            valido = validarEntrada(opcion);
        } while (!valido); //pedir contraseña hasta que sea válida.
        if (opcion.equals("salir")){
            return;
        }

    
        do { //quieres iniciarsesion
            this.modo = 6;
            opcion = this.menuIniciarSesion.mostrarMensaje(2);
            valido = validarEntrada(opcion);
        } while (!valido); //pedir input hasta recibir uno válido*/
        
        procesarEntrada(opcion);
   }
   
 
   private boolean contraseniaValida (String opcion) {
        //debería comprobar en la base de datos si la contraseña introducida coincide con la del usuario introducido
        return true;
    }
   
}
