package blyskavka.security.tokens.persistent;

import static java.lang.String.format;

import blyskavka.animal.AnimalSpecies;
import blyskavka.security.tokens.UsersAndPersonnelModuleToken;
import ua.com.fielden.platform.security.tokens.Template;

/**
 * A security token for entity {@link AnimalSpecies} to guard Delete.
 *
 * @author Developers
 *
 */
public class AnimalSpecies_CanDelete_Token extends UsersAndPersonnelModuleToken {
    public final static String TITLE = format(Template.DELETE.forTitle(), AnimalSpecies.ENTITY_TITLE);
    public final static String DESC = format(Template.DELETE.forDesc(), AnimalSpecies.ENTITY_TITLE);
}