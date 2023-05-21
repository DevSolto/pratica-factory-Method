package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameClaro extends JFrame {

	private Color corFundo = new Color(220, 220, 220);
	private Color corFonte = new Color(0, 0, 0);
	
	public JFrameClaro() {
		setExtendedState(MAXIMIZED_BOTH);
		setBackground(corFundo);
		setForeground(corFonte);
	}
	

	@Override
	public Component add(Component comp) {
		if (comp instanceof Container) {
			for (Component filho : ((Container)comp).getComponents()) {
				setEsquemaCores(filho);
			}
		} 
		setEsquemaCores(comp);
		return super.add(comp);
	}

	public Component setEsquemaCores(Component comp) {
		//setando cor de fonte do componente adicionado
		comp.setBackground(corFundo);

		//setando fonte
		Font font = comp.getFont();
		//				comp.setFont(font.deriveFont(Font.PLAIN));

		//setando cor da fonte
		comp.setForeground(corFonte);
		return comp;
	}
	
	public void setIconeURL(String url) {
		try {
			setIconImage(new ImageIcon(new URL(url)).getImage());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	

}
