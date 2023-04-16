package baseDeDatos;

import clasesDeJuego.Usuario;
import java.io.Serializable;
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

    private void cargarUsuarios() {
        //carga usuarios
    }
    
    public void guardar(){
        //guarda usuarios
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