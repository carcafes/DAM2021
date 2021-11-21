package parte2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class lenguaje {
	public static void main(String[] args) throws IOException {
		Random r = new Random();
		int cantidad;
		 File archivo = null;
		// Generador de numeros al azar

		String ruta;
		String contenido;

		if (args.length != 0) {
			cantidad = Integer.parseInt(args[0]);
			ruta = "./" + args[1];
		} else {
			cantidad = 10;
			ruta = "./miFicheroDeLenguaje.txt";
		}

		archivo = new File("" + ruta);

		if (archivo.exists()) {
			existe(archivo,cantidad);
		} else {
			noExiste(archivo,cantidad);
		}

	}

	public static String palabra(int longitud) {
		String aux = "";
		aux += todas();
		for (int i = 0; i < longitud - 1; i++) {
			if ((i % 2) == 0)
				aux += vocal();
			else
				aux += todas();
		}

		return aux;

	}

	public static String todas() {
		String aux = "";
		Random r = new Random();
		switch (r.nextInt(26) + 1) {
		case 1:
			aux += "A";
			break;
		case 2:
			aux += "B";
			break;
		case 3:
			aux += "C";
			break;
		case 4:
			aux += "D";
			break;
		case 5:
			aux += "E";
			break;
		case 6:
			aux += "F";
			break;
		case 7:
			aux += "G";
			break;
		case 8:
			aux += "H";
			break;
		case 9:
			aux += "I";
			break;
		case 10:
			aux += "J";
			break;
		case 11:
			aux += "K";
			break;
		case 12:
			aux += "L";
			break;
		case 13:
			aux += "M";
			break;
		case 14:
			aux += "N";
			break;
		case 15:
			aux += "O";
			break;
		case 16:
			aux += "P";
			break;
		case 17:
			aux += "Q";
			break;
		case 18:
			aux += "R";
			break;
		case 19:
			aux += "S";
			break;
		case 20:
			aux += "T";
			break;
		case 21:
			aux += "U";
			break;
		case 22:
			aux += "V";
			break;
		case 23:
			aux += "W";
			break;
		case 24:
			aux += "X";
			break;
		case 25:
			aux += "Y";
			break;
		case 26:
			aux += "Z";
			break;

		}
		return aux;
	}

	public static String vocal() {
		Random r = new Random();
		String aux = "";
		switch (r.nextInt(5) + 1) {
		case 1:
			aux += "A";
			break;
		case 2:
			aux += "E";
			break;
		case 3:
			aux += "I";
			break;
		case 4:
			aux += "O";
			break;
		case 5:
			aux += "U";
			break;
		}
		return aux;
	}

	public static synchronized void existe(File archivo,int cantidad) throws IOException {
		PrintWriter pw = null;
		BufferedReader br = null;
		Random r = new Random();
		br = new BufferedReader(new FileReader(archivo));
		pw = new PrintWriter(new FileWriter(archivo, true));
		for (int i = 0; i < cantidad; i++) {
			pw.println(palabra(r.nextInt(3) + 3));
			pw.flush();
		}
		br.close();
		pw.close();
	}

	public static synchronized void noExiste(File archivo,int cantidad) throws IOException {
		PrintWriter pw = null;
		Random r = new Random();
		pw = new PrintWriter(new FileWriter(archivo));
		for (int i = 0; i < cantidad; i++) {
			pw.println(palabra(r.nextInt(3) + 3));
			pw.flush();
		}
		pw.close();
	}
}
