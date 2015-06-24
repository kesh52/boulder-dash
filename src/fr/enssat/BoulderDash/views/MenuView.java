package fr.enssat.BoulderDash.views;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import fr.enssat.boulderdash.helpers.LevelSelectorHelper;
import fr.enssat.BoulderDash.views.MenuImage;
import fr.enssat.BoulderDash.views.MenuLevelSelector;
import fr.enssat.BoulderDash.views.MenuLevelSelector;
import fr.enssat.BoulderDash.controllers.NavigationBetweenViewController;


/**
 * MenuView
 *
 * Menu view
 *
 * @author      Valerian Saliou <valerian@valeriansaliou.name>
 * @since       2015-06-23
 */
public class MenuView extends JFrame {
	private NavigationBetweenViewController navigationBetweenViewController;
    private MenuImage menuImage;
    private MenuLevelSelector menuLevelSelector;
	private JPanel actionPanel;
    private JButton game, editor, quit;

    /**
     * Class constructor
     */
	public MenuView(NavigationBetweenViewController navigationBetweenViewController) {
		this.navigationBetweenViewController = navigationBetweenViewController;
		this.initializeView();
		this.createLayout();
	}

    /**
     * Initializes the view
     */
    private void initializeView() {
        this.setVisible(true);
        this.setResizable(false);

        // UI parameters
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 200, 100);
        this.setSize(432, 536);

        // App parameters
        this.setTitle("Boulder Dash menu");
    }

    /**
     * Creates the view layout
     */
    private void createLayout() {
        LevelSelectorHelper levelSelectorHelper = new LevelSelectorHelper(false);
        this.menuLevelSelector = levelSelectorHelper.createLevelList();

        JPanel targetPanel = new JPanel();

        this.menuImage = new MenuImage();
    	this.actionPanel = new JPanel();
    	
        // Add some buttons on the actionPanel
        this.game = this.createButton("game", "Game");
        this.editor = this.createButton("editor", "Editor");
        this.quit = this.createButton("quit", "Quit");

        this.add(this.menuImage, BorderLayout.CENTER);
        this.add(targetPanel, BorderLayout.SOUTH);

        targetPanel.add(this.menuLevelSelector, BorderLayout.NORTH);
        targetPanel.add(this.actionPanel, BorderLayout.SOUTH);
    }

    /**
     * Creates the given button
     *
     * @param   name  Button name
     * @return  Created button
     */
	public JButton createButton(String id, String name) {
		JButton button = new JButton(name);
		button.addActionListener(this.navigationBetweenViewController);
		button.setActionCommand(id);

		this.actionPanel.add(button);

		return button;
	}

    /**
     * Gets the selected level identifier!
     *
     * @return  Level identifier
     */
    public String getLevelIdentifier() {
        return this.menuLevelSelector.getChoiceValue();
    }
}
