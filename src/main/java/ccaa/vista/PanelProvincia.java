package ccaa.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import ccaa.controladores.ControladorComunidad;
import ccaa.controladores.ControladorProvincia;
import ccaa.entidades.CCAA;
import ccaa.entidades.Provincia;
import ccaa.recursos.Utils;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelProvincia extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfCode;
	private JTextField jtfLabel;
	private JTextField jtfParentCode;
	private JPanel panel;
	private JLabel lblComunidadAutnoma;
	private JComboBox jcbCCAA;
	private JButton btnDatosCcaa;

	/**
	 * Create the panel.
	 */
	public PanelProvincia() {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 178, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestión de Provincia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Parent code:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfParentCode = new JTextField();
		jtfParentCode.setColumns(10);
		GridBagConstraints gbc_jtfParentCode = new GridBagConstraints();
		gbc_jtfParentCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfParentCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfParentCode.gridx = 1;
		gbc_jtfParentCode.gridy = 2;
		panel.add(jtfParentCode, gbc_jtfParentCode);
		
		JLabel lblNewLabel_3 = new JLabel("Code:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfCode = new JTextField();
		GridBagConstraints gbc_jtfCode = new GridBagConstraints();
		gbc_jtfCode.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCode.gridx = 1;
		gbc_jtfCode.gridy = 3;
		panel.add(jtfCode, gbc_jtfCode);
		jtfCode.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Label:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfLabel = new JTextField();
		GridBagConstraints gbc_jtfLabel = new GridBagConstraints();
		gbc_jtfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLabel.gridx = 1;
		gbc_jtfLabel.gridy = 4;
		panel.add(jtfLabel, gbc_jtfLabel);
		jtfLabel.setColumns(10);
		
		lblComunidadAutnoma = new JLabel("CCAA:");
		GridBagConstraints gbc_lblComunidadAutnoma = new GridBagConstraints();
		gbc_lblComunidadAutnoma.anchor = GridBagConstraints.EAST;
		gbc_lblComunidadAutnoma.insets = new Insets(0, 0, 5, 5);
		gbc_lblComunidadAutnoma.gridx = 0;
		gbc_lblComunidadAutnoma.gridy = 6;
		panel.add(lblComunidadAutnoma, gbc_lblComunidadAutnoma);
		
		jcbCCAA = new JComboBox();
		GridBagConstraints gbc_jcbCCAA = new GridBagConstraints();
		gbc_jcbCCAA.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCCAA.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCCAA.gridx = 1;
		gbc_jcbCCAA.gridy = 6;
		panel.add(jcbCCAA, gbc_jcbCCAA);
		
		btnDatosCcaa = new JButton("Datos CCAA");
		btnDatosCcaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelComunidad panelComunidad = new PanelComunidad();
				Utils.abrirNuevoDialogo(panelComunidad, (CCAA)jcbCCAA.getSelectedItem());
			}
		});
		GridBagConstraints gbc_btnDatosCcaa = new GridBagConstraints();
		gbc_btnDatosCcaa.insets = new Insets(0, 0, 5, 0);
		gbc_btnDatosCcaa.gridx = 2;
		gbc_btnDatosCcaa.gridy = 6;
		panel.add(btnDatosCcaa, gbc_btnDatosCcaa);
		
		cargaComunidades();

	}
	
	/**
	 * 
	 */
	
	private void cargaComunidades() {
		ControladorComunidad cc = new ControladorComunidad();
		List<CCAA> comunidades = cc.findAll();
		for (CCAA c : comunidades) {
			this.jcbCCAA.addItem(c);
		}
	}

	/**
	 * 
	 */
	
	public String getParentCode() {
		return this.jtfParentCode.getText();
	}
	
	/**
	 * 
	 */
	
	public String getCode() {
		return this.jtfCode.getText();
	}
	
	/**
	 * 
	 */
	
	public String getLabel() {
		return this.jtfLabel.getText();
	}
	
	/**
	 * 
	 */
	
	public void setParentCode(String s) {
		this.jtfParentCode.setText(s);
	}
	/**
	 * 
	 */
	
	public void setCode(String s) {
		this.jtfCode.setText(s);
	}
	/**
	 * 
	 */
	
	public void setLabel(String s) {
		this.jtfLabel.setText(s);
	}
	
	/**
	 * 
	 */
	
	public void setComunidad(String parentCode) {
		this.jcbCCAA.setSelectedIndex(Integer.parseInt(parentCode) - 1);
	}
	
	/**
	 * 
	 */
	
	public CCAA getComunidad() {
		return (CCAA)this.jcbCCAA.getSelectedItem();
	}
}

