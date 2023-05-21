package ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 * 
 * 
 * 1. Associe as lógicas do cliente que serão reusadas com os métodos abaixo comentados.
 * 
 * 2. Estenda esta classe CRIADORA ABSTRATA para que se implemente o método-fábrica (factory method)
 * {fabricarJFrame()}, que devolve o supertipo de produto {JFrame} somente nas subclasses
 * CRIADORAS {ModoAppNormal} e {ModoAppEscuro}: implemente {fabricarJFrame()} encapsulando 
 * o new com o respectivo subtipo de {JFrame}, {JFrameClaro} ou {JFrameEscuro}
 * que já estão disponíveis no pacote de classes ui.
 *
 */
public abstract class Aplicacao {
	
	
	//correspondente da logica 01, do main() de ClienteAplicacaoaA
	public void instalarListenerFechamento(JFrame janela) {
		janela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	//correspondente da logica 02, do main() de ClienteAplicacaoA
	public void instalarAreasDeLayout(JFrame janela) {
		JSplitPane split = new JSplitPane();
		split.setLeftComponent(new JPanel());
		split.setRightComponent(new JPanel());
		split.setDividerLocation(350);
		janela.add(split);
	}
	
	
	//correspondente da logica 03, do main() de ClienteAplicacaoA
	public void iniciar(JFrame janela) {
		janela.setVisible(true);
	}
	
	//factory-method que dever� ser implementado por subclasses que entregar�o um produto com new, que corresponda ao supertipo para produtos {JFrame}.
	public abstract JFrame fabricarJFrame();
	
}
