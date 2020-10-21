package modelo;

public class GeneradorMemoriaNula
{
	private String[] vectorSimbolos = new String[100]; // considero probabilidades con una presicion de 2 decimales
	private int limiteVectorSimbolos = 0; // primer ubicacion libre del vector de simbolos

	public GeneradorMemoriaNula()
	{
		super();
	}

	/**
	 * Pre : la probabilidad total de la fuente nunca superara el 1 por lo que el
	 * vector no superara su limite de 100 posiciones
	 * 
	 * @param simbolo
	 */
	public void addSimbolo(Simbolo simbolo)
	{
		for (int i = 0; i < (int) (simbolo.getProbabilidad() * 100); i++) // revisar si el cast funciona correctamente
		{
			this.vectorSimbolos[i + this.limiteVectorSimbolos] = simbolo.getDato();
		}
		this.limiteVectorSimbolos += (int) simbolo.getProbabilidad() * 100;
	}

	/**
	 * Pre: la probabilidad acumulada debe ser 1, por lo que el vector simbolos debe
	 * tener las 100 posiciones ocupadas
	 */
	public String generaSimbolo()
	{
		return this.vectorSimbolos[(int) (Math.random() % this.limiteVectorSimbolos + 1)];
	}

}
