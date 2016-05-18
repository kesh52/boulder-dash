package fr.enssat.BoulderDash.models;

import fr.enssat.BoulderDash.models.DisplayableElementModel;


/**
 * CursorModel
 *
 * Represents the field cursor pointer.
 *
 * @author      Valerian Saliou <valerian@valeriansaliou.name>
 * @since       2015-06-22
 */
public class CursorModel extends DisplayableElementModel {


    /**
     * Specifies the physical parameters of the object
     */
    {
        spriteName = "cursor";
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
    public CursorModel() {
        super();
        this.loadSprite(spriteName);
    }
}