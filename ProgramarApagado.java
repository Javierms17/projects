import java.awt.EventQueue;
import java.awt.TextField;
import java.lang.String;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ProgramarApagado {
	
	private JFrame frame;
	private JTextField textFieldSeg;
	private JLabel lblCantidad;
	private JButton btnNewButton;
	private JTextField textFieldMin;
	private JLabel lblMinutos;
	private JLabel lblHoras;
	private JTextField textFieldHoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramarApagado window = new ProgramarApagado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgramarApagado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 366, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldSeg = new JTextField();
		textFieldSeg.setText("0");
		textFieldSeg.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textFieldSeg.setBounds(164, 24, 86, 20);
		frame.getContentPane().add(textFieldSeg);
		textFieldSeg.setColumns(10);
		
		JButton btnProgramarApagado = new JButton("Programar Apagado");
		btnProgramarApagado.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				String a=new String(textFieldSeg.getText());
				int segundos=0;
				if(a!=null) {
				segundos=Integer.parseInt(a);
				}
				String b=new String(textFieldMin.getText());
				int minutos=0;
				if(b!=null) {
				minutos=Integer.parseInt(b);
				}
				String c=new String(textFieldHoras.getText());
				int horas=0;
				if(c!=null) {
				horas=Integer.parseInt(c);
				}
				int total=segundos+minutos*60+horas*3600;
				
				String cadena = String.valueOf(total);
				lblCantidad.setText("cantidad en segundos total: "+cadena);
				try {
					String [] cmd = {"shutdown","-s","-t", cadena}; //Comando de apagado en windows
					Runtime.getRuntime().exec(cmd);
				} catch (IOException ioe) {
					System.out.println (ioe);
				}
				
			}
		});
		btnProgramarApagado.setBounds(114, 156, 160, 23);
		frame.getContentPane().add(btnProgramarApagado);
		
		JLabel lblApagarEnsegundos = new JLabel(" Segundos:");
		lblApagarEnsegundos.setBounds(41, 27, 173, 14);
		frame.getContentPane().add(lblApagarEnsegundos);
		
		lblCantidad = new JLabel("cantidad");
		lblCantidad.setBounds(41, 117, 299, 14);
		frame.getContentPane().add(lblCantidad);
		
		btnNewButton = new JButton("Cancelar Apagado ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String [] cmd2 = {"shutdown","-a"}; //Comando de apagado en windows
					Runtime.getRuntime().exec(cmd2);
				} catch (IOException ioe) {
					System.out.println (ioe);
				}
				
				
			}
			
		});
		btnNewButton.setBounds(114, 190, 160, 23);
		frame.getContentPane().add(btnNewButton);
		
		textFieldMin = new JTextField();
		textFieldMin.setText("0");
		textFieldMin.setBounds(164, 55, 86, 20);
		frame.getContentPane().add(textFieldMin);
		textFieldMin.setColumns(10);
		
		lblMinutos = new JLabel("Minutos:");
		lblMinutos.setBounds(41, 58, 87, 14);
		frame.getContentPane().add(lblMinutos);
		
		lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(41, 89, 97, 14);
		frame.getContentPane().add(lblHoras);
		
		textFieldHoras = new JTextField();
		textFieldHoras.setText("0");
		textFieldHoras.setColumns(10);
		textFieldHoras.setBounds(164, 86, 86, 20);
		frame.getContentPane().add(textFieldHoras);
	}
}
