package blyskavka.security.tokens.persistent;

import static java.lang.String.format;

import ua.com.fielden.platform.reflection.TitlesDescsGetter;
import ua.com.fielden.platform.security.tokens.Template;
import blyskavka.animal.Animal;
import blyskavka.security.tokens.AnimalsModuleToken;

/**
 * A security token for entity {@link Animal} to guard Delete.
 *
 * @author Vira
 *
 */
public class Animal_CanDelete_Token extends AnimalsModuleToken {
    public final static String TITLE = format(Template.DELETE.forTitle(), Animal.ENTITY_TITLE);
    public final static String DESC = format(Template.DELETE.forDesc(), Animal.ENTITY_TITLE);
}