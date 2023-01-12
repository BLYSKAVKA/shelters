package blyskavka.security.tokens.persistent;

import static java.lang.String.format;

import blyskavka.animal.Animal;
import blyskavka.security.tokens.AnimalsModuleToken;
import ua.com.fielden.platform.security.tokens.Template;

/**
 * A security token for entity {@link Animal} to guard Save.
 *
 * @author Vira
 *
 */
public class Animal_CanSave_Token extends AnimalsModuleToken {
    public final static String TITLE = format(Template.SAVE.forTitle(), Animal.ENTITY_TITLE);
    public final static String DESC = format(Template.SAVE.forDesc(), Animal.ENTITY_TITLE);
}