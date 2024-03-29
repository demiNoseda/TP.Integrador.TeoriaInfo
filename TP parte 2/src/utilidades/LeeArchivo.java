package utilidades;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public abstract class LeeArchivo
{

	public static String leerArchivo(String direccion) throws IOException, FileNotFoundException
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(direccion), "UTF-8"));
			int caracter = reader.read();
			while (caracter != -1)
			{
				sb.append((char) caracter);
				caracter = reader.read();
			}
		} finally
		{
			if (reader != null)
			{
				reader.close();

			}
		}
		return sb.toString();
	}

	public static HashMap<Integer, Integer> obtenerFrecuencia(String direccion, int[] cantidadSimbolos) throws IOException, FileNotFoundException
	{
		HashMap<Integer, Integer> listaSimbolos = new HashMap<Integer, Integer>();
		BufferedReader reader = null;
		cantidadSimbolos[0] = 0;
		try
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(direccion), "UTF-8"));
			int caracter = reader.read();
			while (caracter != -1)
			{
				cantidadSimbolos[0] += 1;
				if (listaSimbolos.containsKey(caracter))
				{
					listaSimbolos.replace(caracter, listaSimbolos.get(caracter) + 1);
				} else
				{
					listaSimbolos.put(caracter, 1);
				}
				caracter = reader.read();
			}

		}finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return listaSimbolos;
	}

}
