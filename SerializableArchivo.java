import java.io.*;
import java.util.*;

/**
 *
 * @author fitorec
 */
public class SerializableArchivo {
	/**
	 * Guarda un objeto Alumno a en el archivo indicado
	 * en el parametro nombreArchivo
	 *
	 * @param a Es objeto Alumno a guardar
	 * @param nombreArchivo Es el nombre del archivo a generar
	 * @return true si lo pudo guardar de forma exitosa.
	 **/
	public static boolean guardarAlumno(Alumno a, String nombreArchivo) {
		ObjectOutputStream outPut;
		try {
			outPut = new ObjectOutputStream(
					new FileOutputStream(nombreArchivo + ".obj")
			);
			outPut.writeObject(a);
			outPut.close();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * Se encarga de leer un proceso Alumno guardado
	 * en el archivo indicado en nombreArchivo
	 *
	 * @return La instancia del objeto Alumno ya cargado.
	 */
	public static Alumno leerAlumno(String nombreArchivo) {
		Alumno a = null;
		ObjectInputStream inPut;
		try {
			inPut = new ObjectInputStream(
					new FileInputStream(nombreArchivo + ".obj")
			);
			a = (Alumno) inPut.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Imprime la información de como usar este programa
	 **/
	public static void info() {
		System.out.println("Error ejecute el programa con los argumentos:");
		System.out.println("\t generar : para crear y guardar un Alumno");
		System.out.println("\t cargar  : para cargar un Alumno de un archivo");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		if (args.length != 1) { // Error debe recibir un argumento
			SerializableArchivo.info();
			return;
		}
		Scanner scan = new Scanner(System.in);
		Alumno a = null;
		String nombreArchivo = "";
		switch (args[0].toLowerCase()) {
			case "generar":
				System.out.print("Inserte el valor Mínimo: ");
				int min = scan.nextInt();
				System.out.print("\nInserte el valor Maximo: ");
				int max = scan.nextInt();
				a = new Alumno(min, max);
				System.out.println("\n" + a);
				System.out.print("\nNombre del archivo en donde se va guardar: ");
				nombreArchivo = scan.next();
				SerializableArchivo.guardarAlumno(a, nombreArchivo);
				System.out.println("El alumno fue guardado");
				break;
			case "cargar":
				System.out.print("\nInserte el nombre del archivo ");
				System.out.print("a leer: ");
				nombreArchivo = scan.next();
				a = leerAlumno(nombreArchivo);
				System.out.println("Alumno cargado:");
				System.out.println(a);
				break;
			default:
				SerializableArchivo.info();
		}
	}
}
