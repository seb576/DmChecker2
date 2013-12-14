package fr.umlv.DmChecker.IHM;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class IHM extends JFrame {
	private static final long serialVersionUID = 4898588697476928984L;
	
	
	
	/*
	private JLabel nameLableTop;
	private JLabel titleIHMComment;
	private JLabel criterionsGraphic;
	private JLabel titleFonctionComment;
	private JLabel criterionsFonction;
	private JLabel othersCriterions;
	private JButton buttonPrevious;
	private JButton buttonNext;
	private JButton buttonRun;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem openRepository;
	private JMenuItem save;
	private JMenuItem list;
	private JMenuItem exportNote;
	private JMenuItem quit;
	private JMenuItem former;
	private JTextArea graphicComment;
	private JTextArea fonctionComment;
	private ButtonGroup evaluationGraphic;
	private ButtonGroup evaluationFonctional;
	private JRadioButton radioButton0;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JRadioButton radioButton5;
	private JRadioButton radioButton6;
	private JRadioButton radioButton7;
	private JRadioButton radioButton8;
	private JRadioButton radioButton9;
	private JRadioButton radioButton10;
	private JRadioButton fradioButton0;
	private JRadioButton fradioButton1;
	private JRadioButton fradioButton2;
	private JRadioButton fradioButton3;
	private JRadioButton fradioButton4;
	private JRadioButton fradioButton5;
	private JRadioButton fradioButton6;
	private JRadioButton fradioButton7;
	private JRadioButton fradioButton8;
	private JRadioButton fradioButton9;
	private JRadioButton fradioButton10;
	*/
	private final String nomExe;
	private final String repertoire;
	private final String fichierDeDonnees;
	private final String fichierDeCriteres;

	public IHM(String nomExe, String repertoire, String fichierDeDonnees, String fichierDeCriteres) {
		super("DMChecker");
		this.nomExe = nomExe;
		this.repertoire = repertoire;
		this.fichierDeDonnees = fichierDeDonnees;
		this.fichierDeCriteres = fichierDeCriteres;
		buildWindow();
	}

	private void buildWindow() {
		setSize(600, 800);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setContentPane(buildContendPanel());
	}

	private JPanel buildContendPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		/*
		// Labels create zone
		nameLableTop = new JLabel(
				"<html><body>name forname<br>name forname</body></html>");
		nameLableTop.setPreferredSize(new Dimension(550, 40));
		titleIHMComment = new JLabel(
				"<html><body>Crit�re Graphique</body></html>");
		titleIHMComment.setPreferredSize(new Dimension(585, 20));
		titleIHMComment.setHorizontalAlignment(JLabel.CENTER);
		criterionsGraphic = new JLabel("Crit�res");
		criterionsGraphic.setPreferredSize(new Dimension(585, 60));
		// TODO extension si plus de crit�re ?
		titleFonctionComment = new JLabel(
				"<html><body>Crit�re Fonctionnel</body></html>");
		titleFonctionComment.setPreferredSize(new Dimension(585, 20));
		titleFonctionComment.setHorizontalAlignment(JLabel.CENTER);
		criterionsFonction = new JLabel("Crit�res");
		criterionsFonction.setPreferredSize(new Dimension(585, 60));
		// TODO extention si plus de crit�re ?
		othersCriterions = new JLabel("other");
		othersCriterions.setPreferredSize(new Dimension(585, 60));
		// Buttons create zone
		// TODO mettre une image pour next et previous
		buttonPrevious = new JButton(new ButtonListener(this, "Previous"));
		buttonNext = new JButton(new ButtonListener(this, "Next"));
		buttonRun = new JButton(new ButtonListener(this, "Run"));
		buttonPrevious.setPreferredSize(new Dimension(50, 30));
		buttonNext.setPreferredSize(new Dimension(50, 30));
		buttonRun.setPreferredSize(new Dimension(450, 30));
		// Menu creation
		menubar = new JMenuBar();
		menu = new JMenu("Menu");
		// TODO ajouter icone ImageIcon icon = new
		// ImageIcon(getClass().getResource("exit.png")); / JMenuItem eMenuItem
		// = new JMenuItem("Exit", icon);
		openRepository = new JMenuItem("Ouvrir repertoire");
		save = new JMenuItem("Sauveagarder");
		list = new JMenuItem("Liste des ?");
		// TODO a clarifier et modif en liste quand on sais de quoi il s'agit
		exportNote = new JMenuItem("Exporter");
		// TODO liste de ens a aller chercher
		quit = new JMenuItem("Quitter");
		former = new JMenuItem("Former");
		// TODO a clarifier
		menu.add(openRepository);
		menu.add(save);
		menu.add(list);
		menu.add(exportNote);
		menu.add(quit);
		menu.add(former);
		menubar.add(menu);
		// Texte Arean create zone
		graphicComment = new JTextArea(3, 52);
		// The values are number of lines and number of char, notin px
		fonctionComment = new JTextArea(3, 52);
		// Radiobuttun
		evaluationGraphic = new ButtonGroup();
		radioButton0 = new JRadioButton("0");
		radioButton1 = new JRadioButton("1");
		radioButton2 = new JRadioButton("2");
		radioButton3 = new JRadioButton("3");
		radioButton4 = new JRadioButton("4");
		radioButton5 = new JRadioButton("5");
		radioButton6 = new JRadioButton("6");
		radioButton7 = new JRadioButton("7");
		radioButton8 = new JRadioButton("8");
		radioButton9 = new JRadioButton("9");
		radioButton10 = new JRadioButton("10");
		evaluationGraphic.add(radioButton0);
		evaluationGraphic.add(radioButton1);
		evaluationGraphic.add(radioButton2);
		evaluationGraphic.add(radioButton3);
		evaluationGraphic.add(radioButton4);
		evaluationGraphic.add(radioButton5);
		evaluationGraphic.add(radioButton6);
		evaluationGraphic.add(radioButton7);
		evaluationGraphic.add(radioButton8);
		evaluationGraphic.add(radioButton9);
		evaluationGraphic.add(radioButton10);
		evaluationFonctional = new ButtonGroup();
		fradioButton0 = new JRadioButton("0");
		fradioButton1 = new JRadioButton("1");
		fradioButton2 = new JRadioButton("2");
		fradioButton3 = new JRadioButton("3");
		fradioButton4 = new JRadioButton("4");
		fradioButton5 = new JRadioButton("5");
		fradioButton6 = new JRadioButton("6");
		fradioButton7 = new JRadioButton("7");
		fradioButton8 = new JRadioButton("8");
		fradioButton9 = new JRadioButton("9");
		fradioButton10 = new JRadioButton("10");
		evaluationFonctional.add(fradioButton0);
		evaluationFonctional.add(fradioButton1);
		evaluationFonctional.add(fradioButton2);
		evaluationFonctional.add(fradioButton3);
		evaluationFonctional.add(fradioButton4);
		evaluationFonctional.add(fradioButton5);
		evaluationFonctional.add(fradioButton6);
		evaluationFonctional.add(fradioButton7);
		evaluationFonctional.add(fradioButton8);
		evaluationFonctional.add(fradioButton9);
		evaluationFonctional.add(fradioButton10);
		// line1 ?
		setJMenuBar(menubar);
		// line2 30
		panel.add(buttonPrevious);
		panel.add(buttonRun);
		panel.add(buttonNext);
		// line3 40
		panel.add(nameLableTop);
		// line4 20
		panel.add(titleIHMComment);
		// line5 ?
		panel.add(radioButton0);
		panel.add(radioButton1);
		panel.add(radioButton2);
		panel.add(radioButton3);
		panel.add(radioButton4);
		panel.add(radioButton5);
		panel.add(radioButton6);
		panel.add(radioButton7);
		panel.add(radioButton8);
		panel.add(radioButton9);
		panel.add(radioButton10);
		// line6
		panel.add(criterionsGraphic);
		// line7 60
		panel.add(graphicComment);
		// line8
		panel.add(titleFonctionComment);
		// line 9
		panel.add(fradioButton0);
		panel.add(fradioButton1);
		panel.add(fradioButton2);
		panel.add(fradioButton3);
		panel.add(fradioButton4);
		panel.add(fradioButton5);
		panel.add(fradioButton6);
		panel.add(fradioButton7);
		panel.add(fradioButton8);
		panel.add(fradioButton9);
		panel.add(fradioButton10);
		// line 10
		panel.add(criterionsFonction);
		// line 11
		panel.add(fonctionComment);
		// line 12
		panel.add(othersCriterions);
		*/
		return panel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNomExe() {
		return nomExe;
	}

	public String getRepertoire() {
		return repertoire;
	}

	public String getFichierDeDonnees() {
		return fichierDeDonnees;
	}

	public String getFichierDeCriteres() {
		return fichierDeCriteres;
	}

	/*
	public void editNameLabelTop(String[] texte) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html><body>");
		for (String param : texte) {
			sb.append(param + "</br>");
		}
		// TODO : retirer le dernier </br>
		sb.substring(-4);
		sb.append("</body></html>");
		nameLableTop.setText(sb.toString());
	}

	public void editNameLabelTop(String texte) {
		String message = "<html><body>" + texte + "</body></html>";
		nameLableTop.setText(message);
	}

	public JButton getButtonPrevious() {
		return buttonPrevious;
	}

	public JButton getButtonNext() {
		return buttonNext;
	}

	public JButton getButtonRun() {
		return buttonRun;
	}

	public String getGraphicComment() {
		return graphicComment.toString();
	}
	*/

}
