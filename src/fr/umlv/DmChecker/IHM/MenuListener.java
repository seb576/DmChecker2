package fr.umlv.DmChecker.IHM;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class MenuListener extends AbstractAction{
	private static final long serialVersionUID = -6321333740177129865L;
	private IHM ihm;

	public MenuListener(IHM ihm, String texte) {
		super(texte);
		this.ihm = ihm;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}