package blyskavka.security.tokens;

import blyskavka.config.Modules;
import ua.com.fielden.platform.security.ISecurityToken;

/**
 * Top level security token for all security tokens that belong to module {@link Modules#APP_ADMIN};
 *
 * @author Generated
 */
public class AnimalsModuleToken implements ISecurityToken {

    public static final String TITLE = Modules.ANIMALS.title;
    public static final String DESC = Modules.ANIMALS.desc;

}