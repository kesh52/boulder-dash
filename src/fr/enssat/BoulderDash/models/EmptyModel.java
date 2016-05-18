package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * EmptyModel
 *
 * Represents "nothing".
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class EmptyModel extends DisplayableElementModel {

    /**
     * Specifies the physical parameters of the object
     */
	{
		spriteName = "black";
		flags.isDestructible = false;
		flags.canMove = false;
		flags.impactExplosive = false;
		flags.animate = false;
		priority = 0;
		flags.falling = false;
		collideSound = null;
	}

    /**
     * Class constructor
     */
	public EmptyModel() {
		super();
		this.loadSprite(spriteName);
	}
}
