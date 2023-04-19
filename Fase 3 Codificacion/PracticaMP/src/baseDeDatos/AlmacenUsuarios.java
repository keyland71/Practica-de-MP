package baseDeDatos;

import clasesDeJuego.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sergio de Oro Fernández
 * @author Lucía Domínguez Rodrigo
 * @author Ángel Marqués García
 * @author Marcos Jiménez Pulido
 */
 public class AlmacenUsuarios implements Serializable{
    private Map<String, Usuario> usuarios;
    
    public AlmacenUsuarios(){
        this.cargarUsuarios();
    }

    public Usuario obtenerUsuario(String nick){
        return this.usuarios.get(nick);
    }
    public boolean existeUsuario(String nick){
        return this.usuarios.containsKey(nick);
    }
    private Map<String, Usuario> obtenerUsuarios(){
        return this.usuarios;
    }
    
    public int obtenerNumUsuarios(){
        return this.usuarios.keySet().size();
    }
    
    public void aniadirUsuario(Usuario u){
        this.usuarios.put(u.obtenerNick(), u);
        guardarUsuarios();
    }
    
    
    private void cargarUsuarios() {
        AlmacenUsuarios almacenLeido = null;
        try {
            String fic = "./archivos/AlmacenUsuarios.AlmacenUsuarios";
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fic));
            almacenLeido = (AlmacenUsuarios) entrada.readObject();
            this.usuarios = almacenLeido.obtenerUsuarios();
            entrada.close();
        } catch (Exception e) {
            System.out.println("No se ha encontrado el almacén, así que se ha creado uno nuevo");
            this.usuarios = new HashMap<>();
        }
    }
    
    public void guardarUsuarios(){
        try {
            String fic = "./archivos/AlmacenUsuarios.AlmacenUsuarios";
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fic));
            salida.writeObject(this);
            salida.close();
        } catch (Exception e) {
            System.out.println("No se ha podido guardar correctamente");
            System.out.println(e);
        }
    }

}


//esto está copiado de algún sitio
//write
//FileOutputStream fileOutputStream
//      = new FileOutputStream("yourfile.txt");
//    ObjectOutputStream objectOutputStream 
//      = new ObjectOutputStream(fileOutputStream);
//    objectOutputStream.writeObject(person);
//    objectOutputStream.flush();
//    objectOutputStream.close();
//   
//read
//    FileInputStream fileInputStream
//      = new FileInputStream("yourfile.txt");
//    ObjectInputStream objectInputStream
//      = new ObjectInputStream(fileInputStream);
//    Person p2 = (Person) objectInputStream.readObject();
//    objectInputStream.close(); 