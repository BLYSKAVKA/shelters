package blyskavka.animal;

import ua.com.fielden.platform.entity.ActivatableAbstractEntity;
import ua.com.fielden.platform.entity.DynamicEntityKey;
import ua.com.fielden.platform.entity.annotation.CompanionObject;
import ua.com.fielden.platform.entity.annotation.CompositeKeyMember;
import ua.com.fielden.platform.entity.annotation.DescTitle;
import ua.com.fielden.platform.entity.annotation.IsProperty;
import ua.com.fielden.platform.entity.annotation.KeyTitle;
import ua.com.fielden.platform.entity.annotation.KeyType;
import ua.com.fielden.platform.entity.annotation.MapEntityTo;
import ua.com.fielden.platform.entity.annotation.MapTo;
import ua.com.fielden.platform.entity.annotation.Observable;
import ua.com.fielden.platform.entity.annotation.Title;
import ua.com.fielden.platform.reflection.TitlesDescsGetter;
import ua.com.fielden.platform.utils.Pair;

/**
 * Animal Species master entity object.
 *
 * @author Vira
 * 
 */
@KeyType(DynamicEntityKey.class)
@KeyTitle("Animal species")
@CompanionObject(AnimalSpeciesCo.class)
@MapEntityTo
@DescTitle("Description of the species.")
public class AnimalSpecies extends ActivatableAbstractEntity<DynamicEntityKey> {

    private static final Pair<String, String> entityTitleAndDesc = TitlesDescsGetter.getEntityTitleAndDesc(AnimalSpecies.class);
    public static final String ENTITY_TITLE = entityTitleAndDesc.getKey();
    public static final String ENTITY_DESC = entityTitleAndDesc.getValue();

    @IsProperty(length = 42)
    @MapTo
    @CompositeKeyMember(1)
    @Title(value = "Title", desc = "Title of the animal species.")
    private String title;

    @Observable
    public AnimalSpecies setTitle(final String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    @Override
    @Observable
    public AnimalSpecies setActive(boolean active) {
        super.setActive(active);
        return this;
    }
}
