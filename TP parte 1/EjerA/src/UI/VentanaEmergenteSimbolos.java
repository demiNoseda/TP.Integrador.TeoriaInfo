package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class VentanaEmergenteSimbolos extends JFrame
{

	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel[] labelSimbolos;
	private JTextField[] textFieldSimbolos;
	private JButton btnAceptar;
	private JFrame frame;
	private ActionListener actionListener;
	private JPanel panel;

	/**
	 * Create the frame.
	 */
	public VentanaEmergenteSimbolos(int cantidadSimbolos)
	{
		this.frame = new JFrame("Creacion Fuente de Markov");
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setBounds(100, 100, 741, 303);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.frame.setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(3, 0, 0, 0));

		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel);

		this.panel_3 = new JPanel();
		this.contentPane.add(this.panel_3);

		this.btnAceptar = new JButton("Aceptar");
		this.btnAceptar.setActionCommand("AceptarSimbolo");
		this.panel_3.add(this.btnAceptar);

		this.labelSimbolos = new JLabel[cantidadSimbolos];
		this.textFieldSimbolos = new JTextField[cantidadSimbolos];
		for (int i = 0; i < cantidadSimbolos; i++)
		{
			this.labelSimbolos[i] = new JLabel("S" + Integer.toString(i + 1) + ":");
			this.textFieldSimbolos[i] = new JTextField();
			this.panel_1.add(this.labelSimbolos[i]);
			this.panel_1.add(this.textFieldSimbolos[i]);
			this.textFieldSimbolos[i].setColumns(5);

		}

		this.frame.setVisible(true);
	}

	public void cerrar()
	{
		this.frame.dispose();
	}

	public void setActionListener(ActionListener actionListener)
	{
		this.btnAceptar.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public String[] getSimbolos()
	{
		int cantidadSimbolos = this.textFieldSimbolos.length;
		String[] simbolos = new String[cantidadSimbolos];
		for (int i = 0; i < cantidadSimbolos; i++)
		{
			simbolos[i] = this.textFieldSimbolos[i].getText();
		}

		return simbolos;
	}


	public boolean validaBotonAceptar()
	{
		boolean condicion = true;
		int i = 0, n = this.textFieldSimbolos.length;
		String simbolo;
		while (condicion && i < n)
		{
			simbolo = this.textFieldSimbolos[i].getText();
			i++;
			condicion = !simbolo.isEmpty();
		}

		return condicion;
	}

	/**
	 * imprimeMensaje<br>
	 * imprime un mensaje pasado por parametro en una ventana emergente<br>
	 * 
	 * @param mensaje : mensaje a imprimir
	 */
	public void imprimeMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
