package ccaa.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ccaa.controladores.ControladorComunidad;
import ccaa.entidades.CCAA;
import ccaa.recursos.Utils;

import javax.swing.JButton;
import java.awt.Font;

public class PanelComunidad extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfParentCode;
	private JTextField jtfCode;
	private JTextField jtfLabel;

	/**
	 * Create the panel.
	 */
	public PanelComunidad() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinCcaa = new JLabel("Gestión CCAA");
		lblGestinCcaa.setFont(new Font("Dialog", Font.BOLD, 24));
		GridBagConstraints gbc_lblGestinCcaa = new GridBagConstraints();
		gbc_lblGestinCcaa.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestinCcaa.gridx = 1;
		gbc_lblGestinCcaa.gridy = 0;
		add(lblGestinCcaa, gbc_lblGestinCcaa);
		
		JLabel lblNewLabel_1 = new JLabel("Parent Code:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfParentCode = new JTextField();
		GridBagConstraints gbc_jtfParentCode = new GridBagConstraints();
		gbc_jtfParentCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfParentCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfParentCode.gridx = 1;
		gbc_jtfParentCode.gridy = 3;
		add(jtfParentCode, gbc_jtfParentCode);
		jtfParentCode.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Code:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfCode = new JTextField();
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 1;
		gbc_jtfCode.gridy = 4;
		add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Label:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfLabel = new JTextField();
		GridBagConstraints gbc_jtfLabel = new GridBagConstraints();
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 1;
		gbc_jtfLabel.gridy = 5;
		add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 2;
		gbc_btnGuardar.gridy = 8;
		add(btnGuardar, gbc_btnGuardar);

		
	}
	
	/**
	 * 
	 * @param c
	 */
	
	public void muestraDatos(CCAA c) {
		this.jtfCode.setText(c.getCode());
		this.jtfParentCode.setText(c.getParent_code());
		this.jtfLabel.setText(c.getLabel());
	}
	
	/**
	 * 
	 */
	
	private void update() {
		ControladorComunidad cc = new ControladorComunidad();
		CCAA c = new CCAA();
		
		c.setCode(this.jtfCode.getSelectedText());
		c.setParent_code(this.jtfParentCode.getSelectedText());
		c.setLabel(this.jtfLabel.getSelectedText());
		
		cc.updateDocument(c);
	}
}
