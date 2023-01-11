package blyskavka.security.tokens.open_simple_master;

import static java.lang.String.format;

import blyskavka.animal.AnimalSpecies;
import blyskavka.security.tokens.UsersAndPersonnelModuleToken;
import ua.com.fielden.platform.security.tokens.Template;

/**
 * A security token for entity {@link AnimalSpecies} to guard Open.
 *
 * @author Developers
 *
 */
public class AnimalSpeciesMaster_CanOpen_Token extends UsersAndPersonnelModuleToken {
    public final static String TITLE = format(Template.MASTER_OPEN.forTitle(), AnimalSpecies.ENTITY_TITLE + " Master");
    public final static String DESC = format(Template.MASTER_OPEN.forDesc(), AnimalSpecies.ENTITY_TITLE);
}