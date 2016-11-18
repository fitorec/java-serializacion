import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author fitorec (papá de chepe)
 */
public class SerializableNetwork {
	static int port = 10;

	/**
	 * Envia un objeto Alumno hacia el servidor indicado
	 *
	 * @param a Es objeto Alumno a guardar
	 * @param servidor Es el nombre de red o IP del servidor
	 * @return true si lo pudo enviar de forma exitosa.
	 **/
	public static boolean enviarAlumno(Alumno a, String servidor) {
		try {
			Socket socket = new Socket(servidor, SerializableNetwork.port);
			ObjectOutputStream outPut = new ObjectOutputStream(socket.getOutputStream());
			outPut.writeObject(a);
			outPut.close();
			socket.close();
			return true;
		} catch(Exception e) {
			System.out.println("Error al intentar clear el sock");
		}
		return false;
	}

	/**
	 * Se encarga de recibir un proceso Alumno enviado
	 * por el programa en modo cliente
	 *
	 * @return La instancia del objeto Alumno ya recibido y cargado.
	 */
	public static Alumno recibirAlumno() {
		try {
			ServerSocket serv = new  ServerSocket(SerializableNetwork.port);
			System.out.println("\nServidor Inicializado esperando conexión");
			Socket socket = serv.accept();
			ObjectInputStream inPut = new ObjectInputStream(socket.getInputStream());
			return (Alumno) inPut.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Imprime la información de como usar este programa
	 **/
	public static void info() {
		System.out.println("Error ejecute el programa con los argumentos:");
		System.out.println("\t client : para crear y enviar un Alumno");
		System.out.println("\t server : para recibir un Alumno por la red");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		if (args.length != 1) { // Error debe recibir un argumento
			SerializableNetwork.info();
			return;
		}
		Scanner scan = new Scanner(System.in);
		Alumno a = null;
		switch (args[0].toLowerCase()) {
			case "client":
				System.out.print("Inserte el valor Mínimo: ");
				int min = scan.nextInt();
				System.out.print("\nInserte el valor Maximo: ");
				int max = scan.nextInt();
				a = new Alumno(min, max);
				System.out.println("\n" + a);
				System.out.print("\nIP/HostName del servidor: ");
				String ipServer = scan.next();
				SerializableNetwork.enviarAlumno(a, ipServer);
				System.out.println("El alumno fue guardado");
				break;
			case "server":
				System.out.print("\nIniciando servicio...");
				a = SerializableNetwork.recibirAlumno();
				System.out.println("Alumno cargado:");
				System.out.println(a);
				break;
			default:
				SerializableNetwork.info();
		}
	}
}
