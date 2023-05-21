package main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ui.Aplicacao;
import ui.FactoryJFrameClaro;
import ui.JFrameClaro;
import ui.JFrameEscuro;

public class ClienteAplicacaoA {

	/*
	 * 
	 * 
	 * 1. Veja a implementção do main() desta classe e o execute.
	 * Esta classe simula uma codigo cliente que usa e depende de um new para um produto que é um objeto da classe
	 * {JFrameClaro}. Veja que esse produto usado aqui no {main()} vai poder ser de outra classe, futuramente, 
	 * considerando os blocos de código correspondentes a 03 lógicas de manipulação  de produtos {JFrame},
	 * que possuem uma linha de comentário sobre cada uma delas. Existe também o produto {JFrameEscuro}).
	 * 
	 * 
	 * 2. Precisamos que um segundo cliente, que é a classe {ClienteAplicacaoB}, reaproveite as lógicas aqui presentes
	 * após a fabricação de produtos {JFrame}. Eis que, a classe {ClienteAplicacaoB} difere desta classe {ClienteAplicacaoA}
	 * por utilizar um new para criar produtos da classe {JFrameEscuro}, no lugar de {JFrameClaro}. Nesse momento deve
	 * de ocorrer a replicação integral do restante do código aqui em {ClienteAplicacaoA}, dentro de {ClienteAplicacaoB}.
	 * Realize isso para perceber esse esforço e incapacidade de reuso de código de fabricação e pós-fabricação para
	 * produtos {JFrame} diferentes, por blocos de código-cliente diferentes. Acesse o TODO_FACTORY.METHOD.01.2
	 * presente na classe {ClienteAplicacaoB} para simular o que se pede.
	 * 
	 * 
	 * 3. Veja que há uma replicação inconveniente entre {ClienteAplicacaoA} e {ClienteAplicacaoB},
	 * também a impossibilidade de se alterar o código aqui de {ClienteAplicacaoA} pois pode já estar em uso e
	 * e necessidade de mudanças quanto ao tipo de produto concreto {JFrame} fabricado que, independentemente
	 * de quais subtipos fossem, deveríamos ser capazes de reusar as mesmas linhas das 03 lógicas de pós-fabricação
	 * logo em seguida a criação desse objetos. Portanto, assuma que o desenvolvedor do código das 03 lógicas e
	 * dos produtos verificou que seria interessante aplicar o padrão FACTORY METHOD para esse vibilizar esse reuso de
	 * lógica de pós-fabricação e também de desacoplar o código de clientes dosprodutos de um subtipo específico deles.
	 * Na hierarquia de classes paralelas do padrão, do lado do supertipo PRODUTO, há o supertipo {JFrame}, com os produtos
	 * {JFrameClaro} e {JFrameEscuro} como subtipos, nesse caso por herança.
	 * 
	 * Do lado do supertipo das classes CRIADOR/CRIADORAS, considere o encapsulamento disso via classes do padrão,
	 * que promoverão o reuso e a flexibilidade necessárias para mudarmos de produto sob essa lógica de reuso.
	 * Portanto, chame as classes CRIADORAS de {ModoAppNormal} e {ModoAppEscuro}, para maior coesão.
	 * Acesse o TODO_FACTORY.METHOD.01.3 presente na classe CRIADORA ABSTRATA {Aplicacao} para resolver este passo da prática
	 * (ela já contém todos os métodos para você terminar de implementar). Altere o codigo do main() aqui abaixo nesta classe,
	 * comentando o código original replicado das 03 lógicas e adicionando o código para usarmos o padrão e repita esse processo
	 * na outra classe {ClienteAplicacaoB}.
	 * 
	 * ---------- 
	 * [PERGUNTA A] 
	 * Comparando-se antes e depois aplicado, o código dos clientes do padrão nas classes {ClienteAplicacaoA} e {ClienteAplicacaoB}
	 * conhecem o tipo concreto dos produtos JFrame? Isso é proposital? O que isso traz de positivo para o código desses clientes?Ap
	 * 
	 * [COLOQUE A RESPOSTA AQUI]
	 * ----------
	 * Não, isso é proposital, dessa maneira o acoplamento da classe cliente e a classe produto é bastante redusido pois ela lida apenas com a interface abstrata do produto e não precisa conhecer a implementação concreta. Isso facilita a substituição de produtos por outros tipos compatíveis, sem afetar o cliente.
	 * ---------- 
	 * 
	 * [PERGUNTA B] 
	 * O problema de replicação da lógica pós-fabricação sobre o produto que varia foi resolvido como?
	 * Explique como um cliente do padrão agora fabrica um JFrame ao seu gosto, reusando tal lógica.
	 * 
	 * [COLOQUE A RESPOSTA AQUI]
	 * ----------
	 * Agora a logica de pós-fabricação esta guardada na classe "Factory" que ela esta usando. Com essa implementação o cliente so presisa intanciar a classe "Factory" e chamar o metodo fabricarJFrame para que ele tenha um objeto Jframe da maneira que ele precisa. 
	 * ----------
	 * 
	 * 4. Considerando a aplicação do padrão, imagine que o cliente representado pela classe
	 * {AplicacaoClienteB}, resolveu lidar com um novo subtipo de produtos {JFrame}. 
	 * Agora, fabrica-se um {JFrame} default (sem especializações) em {ClienteAplicacaoB.main()}:
	 * experimente isso.
	 * 
	 * [COLOQUE A RESPOSTA AQUI]
	 * ----------
	 * Considerando o padrão deveria se criar um subtipo da classe {JFrame} que poderia se chamar JFrameDefault fazer a implemtação da logica para cria esse modelo de JFrame e criar um subtipo da classe {Aplicação} que poderia se chamar FactoryJFrameDefaut para servir como contrutor de JFrame default e fazer a classe {ClienteAplicacaoB} ultilizar esse construtor.
	 * ----------
	 * 
	 * [PERGUNTA C] 
	 * Como fazemos para que um novo subtipo de produto seja retrocompatível com o código pós-fabricação
	 * e com o mecanismo para reuso desse código de lógica pós-fabricação do padrão? Explique o processo
	 * de adicionar um novo subtipo de produto ao conjunto do padrão.
	 *  
	 * [COLOQUE A RESPOSTA AQUI]
	 * ---------- 
	 * Apos se criar um novo produto que é um subtipo de JFrame só precisaria contruir uma clsse "Factory" para que ela podesse contruir esse novo tipo de produto.
	 * ---------- 
	 * 
	 * [PERGUNTA D] 
	 * O código cliente presente em {ClienteAplicacaoB.main()} se esforçou muito para trocar
	 * para o novo subtipo de produto? E a classe {ClienteAplicacaoA} teve que ser modificada ou não e porquê?
	 *  
	 * [COLOQUE A RESPOSTA AQUI]
	 * ----------
	 * Levando em conta que o padãor esta aplicado ela não tem quase exforso para ultilizar outro subtipo de produto. Sim, precisou se retirar o codigo que se replicava para colocar o codigo que usa o padrão.
	 * ---------- 
	 * 
	 */
	public static void main(String[] args) {
		/*
		
		//codigo sem padrao: instaciando produto concreto com new e dependendo dele
		JFrameClaro janela = new JFrameClaro();

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
		
		Aplicacao factoryJFrameClaro = new FactoryJFrameClaro();
		JFrame janela = factoryJFrameClaro.fabricarJFrame();
		
		
	}

}