import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CenaAmigos {


public static void main(String[] args) throws IOException {
	ArrayList<Receta> recetas = new ArrayList<Receta>();
	System.out.println("Hola, cúantas recetas quieres insertar?");
	Scanner scan = new Scanner(System.in);
	int numRecetas = scan.nextInt();
	ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

		for (int i = 0; i<numRecetas; i++) {
			Receta receta = new Receta();

			System.out.println("Dame el nombre de la receta");
			receta.setNombreReceta(scan.next());

			System.out.println("Dame el nº de ingredientes de la receta");
			int numIngredientes = scan.nextInt();

			for (int j= 0; j < numIngredientes; j++) {
				Ingrediente ingrediente = new Ingrediente();

				System.out.println("Dame el nombre del ingrediente" + (j+1));
				ingrediente.setNombreIngrediente(scan.next());
				char enGramos;
				do{
					System.out.println("La cantidad es en gramos?(Y/N)");
					enGramos = scan.next().charAt(0);
					switch (enGramos) {
						case 'Y':
							ingrediente.setEnGramos(true);
							System.out.println("Dame la cantidad en gramos");
							ingrediente.setCantidadGramos(scan.nextInt());
							break;
						case 'N':
							ingrediente.setEnGramos(false);
							System.out.println("Dame la cantidad en unidades");
							ingrediente.setCantidadUnidad(scan.nextInt());
							break;
						default:
							System.out.println("Lo siento, inténtalo otra vez");
							break;
					}
				} while((enGramos != 'Y') && (enGramos != 'N'));
	
				ingredientes.add(ingrediente); 
			}
			receta.setIngredientes(ingredientes);
			System.out.println("Finalmente, explícame brevemente su preparación");
			receta.setPreparacion(scan.next());
			recetas.add(receta);
		}

		File archivo = new File ("/home/zubiri/ProyectosJava/azterketa/recetas.txt");
		FileWriter fw = new FileWriter (archivo);

		for (int k=0; k<recetas.size(); k++) {

			fw.write(recetas.get(k).getNombreReceta() + ";");

			for (int l=0; l<ingredientes.size(); l++) {
				fw.write(ingredientes.get(l).getNombreIngrediente() + "*");
				fw.write(ingredientes.get(l).getCantidadUnidad() + "*");
				fw.write(ingredientes.get(l).getCantidadGramos() + "*");
	
				if (l == ingredientes.size() - 1) {
				fw.write(ingredientes.get(l).getEnGramos() + ";");
				}
				else {
				fw.write(ingredientes.get(l).getEnGramos() + "#");
				}

			}

			fw.write(recetas.get(k).getPreparacion() + "\n");
	
		}
	
		
		fw.close();

		try{
			File listaRecetas2 = new File("/home/zubiri/ProyectosJava/azterketa/recetas.txt");
			FileInputStream fis = new FileInputStream(listaRecetas2);
	        InputStreamReader isr = new InputStreamReader(fis, "UTF8");
	        BufferedReader br = new BufferedReader(isr);

	        String linea;
	        linea = br.readLine();
	        String [] campos = null;
	        System.out.println("\nTus recetas...");
	        while(linea!=null){
	        	campos = linea.split(";");
	        	System.out.println("--------------------------------");
	        	System.out.println("Nombre: "+campos[0]);
	       		System.out.println("Descripcion: "+campos[2]);
	       		String ingre = campos[1];
	       		campos = ingre.split("#");
	       		for(int x=0; x<campos.length; x++){
	       			String ingreAtribSeparados = campos[x];
	       			String [] campos2 = ingreAtribSeparados.split("\\*");
	       			System.out.println("Ingredientes: ");
	       			System.out.println("Nombre: "+campos2[0]);
	       			System.out.println("Gramos: "+campos2[1]);
	       			System.out.println("Unidades: "+campos2[2]);
	       			System.out.println("--------------------------------");
	       			//System.out.println("¿En gramos?: "+campos2[3]);
	       		}
	       		
	       		linea = br.readLine();
	        }
	        
	    }catch(Exception ioe){
	    	System.out.println("Error: "+ioe);
	    }

	}
}

