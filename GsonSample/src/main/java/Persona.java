import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Persona {
	 String Nombre;
	 String Apellidos;
	 int Edad;

	public static void main(String[] args) {
		Persona p = new Persona();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el nombre");

		p.Nombre = scanner.nextLine();
		System.out.println("Introduce el apellido");
		p.Apellidos = scanner.nextLine();
		System.out.println("Introduce la edad");
		p.Edad = Integer.parseInt(scanner.nextLine());
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(p);
		System.out.println(json.toString());
	}
}
