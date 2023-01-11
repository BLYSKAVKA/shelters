package blyskavka.config;

import blyskavka.security.tokens.AnimalsModuleToken;
import blyskavka.security.tokens.AppAdminModuleToken;
import blyskavka.security.tokens.UsersAndPersonnelModuleToken;
import ua.com.fielden.platform.security.ISecurityToken;
import ua.com.fielden.platform.utils.StreamUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Enumerates application modules and their configurations.
 *
 * @author Generated
 */
public enum Modules {

    USERS_AND_PERSONNEL("Users and Personnel", "A module to manage systems users and company personnel.",
            "mainMenu:help", "#ffeb3b", "#c8b900",
            UsersAndPersonnelModuleToken.class),
    APP_ADMIN("Administration", "A module to manage application administration.",
            "mainMenu:tablecodes", "#EFDCD5", "#BCAAA4",
           AppAdminModuleToken.class),
    ANIMALS("Animal records", "A module to manage animal records and all other details that pertain to the shelter's inhabitants.",
            "mainMenu:equipment", "#EFDCD5", "#BCAAA4",
           AnimalsModuleToken.class);

    public final String title;
    public final String desc;
    public final String icon;
    public final String bgColour;
    public final String captionBgColour;
    public final Class<? extends ISecurityToken> topSecurityToken;

    Modules(final String title, final String desc,
            final String icon, final String bgColour, final String captionBgColour,
            final Class<? extends ISecurityToken> topSecurityToken) {
        this.title = title;
        this.desc = desc;
        this.icon = icon;
        this.bgColour = bgColour;
        this.captionBgColour = captionBgColour;
        this.topSecurityToken = topSecurityToken;
    }
}
