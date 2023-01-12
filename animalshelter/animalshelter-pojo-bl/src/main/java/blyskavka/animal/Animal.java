package blyskavka.animal;

import ua.com.fielden.platform.entity.ActivatableAbstractEntity;
import ua.com.fielden.platform.entity.DynamicEntityKey;
import ua.com.fielden.platform.entity.annotation.CompanionObject;
import ua.com.fielden.platform.entity.annotation.CompositeKeyMember;
import ua.com.fielden.platform.entity.annotation.DescRequired;
import ua.com.fielden.platform.entity.annotation.DescTitle;
import ua.com.fielden.platform.entity.annotation.DisplayDescription;
import ua.com.fielden.platform.entity.annotation.IsProperty;
import ua.com.fielden.platform.entity.annotation.KeyTitle;
import ua.com.fielden.platform.entity.annotation.KeyType;
import ua.com.fielden.platform.entity.annotation.MapEntityTo;
import ua.com.fielden.platform.entity.annotation.MapTo;
import ua.com.fielden.platform.entity.annotation.Observable;
import ua.com.fielden.platform.entity.annotation.Title;
import ua.com.fielden.platform.entity.annotation.mutator.BeforeChange;
import ua.com.fielden.platform.entity.annotation.mutator.Handler;
import ua.com.fielden.platform.entity.validation.MaxLengthValidator;
import ua.com.fielden.platform.reflection.TitlesDescsGetter;
import ua.com.fielden.platform.utils.Pair;

/**
 * Animal Entity is a concept to reflect all the information about a single animal in a shelter's tracking system.
 *
 * @author Vira
 *
 */
@KeyType(DynamicEntityKey.class)
@KeyTitle("Key")
@CompanionObject(AnimalCo.class)
@MapEntityTo
@DescTitle("Description")
@DisplayDescription
@DescRequired
public class Animal extends ActivatableAbstractEntity<DynamicEntityKey> {

    private static final Pair<String, String> entityTitleAndDesc = TitlesDescsGetter.getEntityTitleAndDesc(Animal.class);
    public static final String ENTITY_TITLE = entityTitleAndDesc.getKey();
    public static final String ENTITY_DESC = entityTitleAndDesc.getValue();
    
    @IsProperty
    @MapTo
    @Title(value = "ChipID", desc = "This animal's unique chip ID.")
    @CompositeKeyMember(1)
    private String chipId;
    
    @IsProperty(length = 42)
    @MapTo
    @Title(value = "Name", desc = "This animal's unique name.")
    @BeforeChange(@Handler(MaxLengthValidator.class))
    @CompositeKeyMember(2)
    private String name;
    
    @IsProperty
    @MapTo
    @Title(value = "Animal Species", desc = "The species that the animal belongs to.")
    private String species;
    
    @IsProperty
    @MapTo
    @Title(value = "Cage Number", desc = "Number of the cage where the animal currently resides.")
    private String cage;
    
    @IsProperty
    @MapTo
    @Title(value = "Breed", desc = "The animal's specific breed withing its species.")
    private String breed;

    @Observable
    public Animal setBreed(final String breed) {
        this.breed = breed;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    @Observable
    public Animal setCageNumber(final String cage) {
        this.cage = cage;
        return this;
    }

    public String getCageNumber() {
        return cage;
    }

    @Observable
    public Animal setSpecies(final String species) {
        this.species = species;
        return this;
    }

    public String getSpecies() {
        return species;
    }

    @Observable
    public Animal setName(final String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    @Observable
    public Animal setChipId(final String chipId) {
        this.chipId = chipId;
        return this;
    }

    public String getChipId() {
        return chipId;
    }

}
