package blyskavka.animalTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import blyskavka.animal.AnimalSpecies;
import blyskavka.test_config.AbstractDomainTestCase;
import ua.com.fielden.platform.test.ioc.UniversalConstantsForTesting;
import ua.com.fielden.platform.utils.IUniversalConstants;

/**
 * These are some simple unit tests to ensure the correct work of AnimalSpecies entity.
 * 
 * @author Vira
 *
 */
public class AnimalSpeciesTest extends AbstractDomainTestCase {

    @Test
    public void species_are_active_by_default() {
        final AnimalSpecies species = co(AnimalSpecies.class).findByKey("Dog");
        assertNotNull(species);
        assertTrue(species.isActive());
    }

    @Test
    public void species_can_be_made_inactive() {
        final AnimalSpecies species = co(AnimalSpecies.class).findByKey("Cat");
        assertNotNull(species);
        
        species.setActive(false);
        assertFalse(species.isActive());
    }

    /**
     * In case of a complex data population it is possible to store the data into a script by changing this method to return <code>true</code>.
     * <p>
     * This way it is possible to reuse it later in place of re-running the data population logic, which is a lot faster.
     * Please also refer method {@link #useSavedDataPopulationScript()} below -- the values returned by this and that method cannot be <code>true</code> simultaneously.
     */
    @Override
    public boolean saveDataPopulationScriptToFile() {
        return false;
    }

    /**
     * If the test data was populated and saved as a script file (hinted in method {@link #saveDataPopulationScriptToFile()} above),
     * then this method can be changed to return <code>true</code> in order to avoid execution of the data population logic and simply execute the saved script.
     * This makes the population of the test data a lot faster.
     * It is very convenient when there is a need to run the same test case multiple times interactively.
     * <p>
     * However, this method should never return <code>true</code> when running multiple test cases.
     * Therefore, it is important to change this method to return <code>false</code> before committing changes into your VCS such as Git.
     */
    @Override
    public boolean useSavedDataPopulationScript() {
        return false;
    }

    /**
     * Domain state population method.
     * <p>
     * <b>IMPORTANT:</p> this method executes only once for a Test Case. At the same time, new instances of a Test Case are created for each test method.
     * Thus, this method should not be used for initialisation of the Test Case state other than the persisted domain state.
     */
    @Override
    protected void populateDomain() {
        // Need to invoke super to create a test user that is responsible for data population
        super.populateDomain();

        // Here is how the Test Case universal constants can be set.
        // In this case the notion of now is overridden, which makes it possible to have an invariant system-time.
        // However, the now value should be after AbstractDomainTestCase.prePopulateNow in order not to introduce any date-related conflicts.
        final UniversalConstantsForTesting constants = (UniversalConstantsForTesting) getInstance(IUniversalConstants.class);
        constants.setNow(dateTime("2019-10-01 11:30:00"));

        // If the use of saved data population script is indicated then there is no need to proceed with any further data population logic.
        if (useSavedDataPopulationScript()) {
            return;
        }

        save(new_composite(AnimalSpecies.class, "Dog").setDesc("Domesticated mammals that were originally bred from wolves."));
        save(new_composite(AnimalSpecies.class, "Cat").setDesc("Rules the world."));
    }

}