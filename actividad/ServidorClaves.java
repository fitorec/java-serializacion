import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author fitorec (papá de chepe)
 */
public class ServidorClaves {
	static int port = 10;
	/**
	 * Envia un objeto Alumno hacia el servidor indicado
	 *
	 * @param a Es objeto Alumno a guardar
	 * @param servidor Es el nombre de red o IP del servidor
	 * @return true si lo pudo enviar de forma exitosa.
	 **/
	public static VectorClaves generarVector() {
		VectorClaves vector = new VectorClaves();
		vector.addClave(1*2);
		vector.addClave(3*11);
		vector.addClave(5*7);
		return vector;
	}

	/**
	 * Se encarga de recibir un proceso Alumno enviado
	 * por el programa en modo cliente
	 *
	 * @return La instancia del objeto Alumno ya recibido y cargado.
	 */
	public static void startServer() {
		try {
			while(true) {
				ServerSocket serv = new  ServerSocket(ServidorClaves.port);
				System.out.println("\nServidor Inicializado esperando conexión");
				Socket socket = serv.accept();
				ObjectOutputStream outPut = new ObjectOutputStream(socket.getOutputStream());
				// Creamos el objeto
				VectorClaves vector = ServidorClaves.generarVector();
				System.out.println("\nVector a enviar: ");
				System.out.println(vector);
				outPut.writeObject(vector);
				// Vamos a recibir el vector
				System.out.println("\nEsperando respuesta del cliente");
				ObjectInputStream inPut = new ObjectInputStream(socket.getInputStream());
				vector =  (VectorClaves) inPut.readObject();
				System.out.println("\nRespuesta recibida: ");
				System.out.println(vector);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ServidorClaves.startServer();
	}
}
