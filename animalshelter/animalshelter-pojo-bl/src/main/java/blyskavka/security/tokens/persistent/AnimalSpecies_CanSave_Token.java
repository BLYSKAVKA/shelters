package blyskavka.security.tokens.persistent;

import static java.lang.String.format;

import blyskavka.animal.AnimalSpecies;
import blyskavka.security.tokens.UsersAndPersonnelModuleToken;
import ua.com.fielden.platform.security.tokens.Template;

/**
 * A security token for entity {@link AnimalSpecies} to guard Save.
 *
 * @author Developers
 *
 */
public class AnimalSpecies_CanSave_Token extends UsersAndPersonnelModuleToken {
    public final static String TITLE = format(Template.SAVE.forTitle(), AnimalSpecies.ENTITY_TITLE);
    public final static String DESC = format(Template.SAVE.forDesc(), AnimalSpecies.ENTITY_TITLE);
}