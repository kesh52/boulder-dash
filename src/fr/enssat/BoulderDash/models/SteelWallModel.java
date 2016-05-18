package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * SteelWallModel
 *
 * Represents the steelWall
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class SteelWallModel extends DisplayableElementModel {

    /**
     * Specifies the physical parameters of the object
     */
	{
		spriteName = "steelwall";
		flags.isDestructible = false;
		flags.canMove = false;
		flags.impactExplosive = false;
		flags.animate = false;
		priority = 3;
		flags.falling = false;
		collideSound = "touch";
	}

    /**
     * Class constructor
     */
	public SteelWallModel() {
		super();
		this.loadSprite(spriteName);
	}
}
