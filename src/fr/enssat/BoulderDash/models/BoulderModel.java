package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * BoulderModel
 *
 * Represents the boulders.
 *
 * @author      Colin Leverger <me@colinleverger.fr>
 * @since       2015-06-19
 */
public class BoulderModel extends DisplayableElementModel {

    /**
     * Specifies the physical parameters of the object
     */
	{
		spriteName = "boulder";
		flags.isDestructible = false;
		flags.canMove = true;
		flags.impactExplosive = false;
		flags.animate = true;
		priority = 2;
		collideSound = "die";
	}

    /**
     * Class constructor
     */
	public BoulderModel(boolean convertible) {
		super();
		super.setConvertibleValue(convertible);
        this.loadSprite(spriteName);
	}

    public BoulderModel() {
        this(false);
    }
}