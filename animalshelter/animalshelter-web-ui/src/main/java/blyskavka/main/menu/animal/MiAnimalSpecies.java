package blyskavka.main.menu.animal;

import ua.com.fielden.platform.entity.annotation.EntityType;
import ua.com.fielden.platform.ui.menu.MiWithConfigurationSupport;
import blyskavka.animal.AnimalSpecies;
/**
 * Main menu item representing an entity centre for {@link AnimalSpecies}.
 *
 * @author Developers
 *
 */
@EntityType(AnimalSpecies.class)
public class MiAnimalSpecies extends MiWithConfigurationSupport<AnimalSpecies> {

}
