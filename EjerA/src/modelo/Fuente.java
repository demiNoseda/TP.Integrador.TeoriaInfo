package modelo;

import excepciones.ProbabilidadTotalException;
import excepciones.SimboloNoEncontradoException;

public abstract class Fuente
{

	public Fuente()
	{

	}

	public abstract double getEntropia() throws ProbabilidadTotalException;

	public abstract double getCantInformacion(String simbolo) throws SimboloNoEncontradoException;

}
