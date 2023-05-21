package ui;

import javax.swing.JFrame;

public class FactoryJFrameClaro extends Aplicacao{

	@Override
	public JFrame fabricarJFrame() {
		JFrameClaro janela = new JFrameClaro();
		instalarListenerFechamento(janela);
		instalarAreasDeLayout(janela);
		iniciar(janela);
		//acesso a um metodo especifico do produto JFrameClaro, que vai variar nesta classe cliente. foco de acoplamento.
		janela.setIconeURL("https://www.ifpb.edu.br/++theme++verde/img/favicon.ico");
		return janela;
	}

}
