package ui;

import javax.swing.JFrame;

public class FactoryJFrameEscuro extends Aplicacao{

	@Override
	public JFrame fabricarJFrame() {
		JFrameEscuro janela = new JFrameEscuro();
		instalarListenerFechamento(janela);
		instalarAreasDeLayout(janela);
		iniciar(janela);
		return janela;
	}

}
