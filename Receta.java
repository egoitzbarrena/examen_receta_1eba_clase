import java.util.ArrayList;

public class Receta {

	private String nombreReceta;
	private ArrayList<Ingrediente> ingredientes;
	private String preparacion;

	public String getNombreReceta () {
	
		return this.nombreReceta;
	}

	public void setNombreReceta (String nombreReceta1) {

		this.nombreReceta = nombreReceta1;
	}
//-------------------
	public ArrayList<Ingrediente> getIngredientes() {
	
		return this.ingredientes;
	}

	public void setIngredientes (ArrayList<Ingrediente> ingredientes1) {

		this.ingredientes = ingredientes1;
	}
//--------------------
	public String getPreparacion () {
	
		return this.preparacion;
	}

	public void setPreparacion (String preparacion1) {

		this.preparacion = preparacion1;
	}

}


