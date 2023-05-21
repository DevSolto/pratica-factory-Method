package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ui.Aplicacao;
import ui.FactoryJFrameClaro;
import ui.FactoryJFrameEscuro;
import ui.JFrameClaro;
import ui.JFrameEscuro;

public class ClienteAplicacaoB {

	
	public static void main(String[] args) {
		/**
		 * 
		 * 
		 * 
		 * 0. Veja primeiro os passos de TODO_FACTORY.METHOD.01 na classe {ClienteAplicacaoA}, 
		 * antes de continuar aqui.
		 * 
		 * 1. Implemente a replicação de código para reusar as 03 lógicas pós fabricação sobre o produto
		 * pertencente a classe {JFrameEscuro} que é um subtipo {JFrame}.
		 * 
		 * 3. Agora, execute este main() para ver o produto janela em modo escuro.
		 * 
		 *
		//codigo sem padrao: instaciando produto concreto com new e dependendo dele
		JFrameEscuro janela = new JFrameEscuro();

		//codigo sem padrao: manipulando logica 01 sobre o produto no proprio cliente
		janela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		//codigo sem padrao: manipulando logica 02 sobre o produto no proprio cliente
		JSplitPane split = new JSplitPane();
		split.setLeftComponent(new JPanel());
		split.setRightComponent(new JPanel());
		split.setDividerLocation(350);
		janela.add(split);

		//codigo sem padrao: manipulando logica 03 sobre o produto no proprio cliente
		janela.setVisible(true);
		*/
		
		Aplicacao factoryJFrameEscuro = new FactoryJFrameEscuro();
		JFrame janela = factoryJFrameEscuro.fabricarJFrame();
	}
}
