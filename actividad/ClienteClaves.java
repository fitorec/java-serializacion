import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author fitorec (papá de chepe)
 */
public class ClienteClaves {
	static int port = 10;

	/**
	 * Se encarga de recibir un procesos VectorClaves enviados del servidor
	 * a los cuales para cada clave le busca la solución y devuelve el vectorClaves
	 * al servidor
	 */
	public static void startClient(Server IP) {
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ClienteClaves.startClient("127.0.0.1");
	}
}
