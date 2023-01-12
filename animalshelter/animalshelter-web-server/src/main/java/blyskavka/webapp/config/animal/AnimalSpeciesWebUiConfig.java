package blyskavka.webapp.config.animal;

import static blyskavka.common.LayoutComposer.CELL_LAYOUT;
import static blyskavka.common.LayoutComposer.FLEXIBLE_LAYOUT_WITH_PADDING;
import static blyskavka.common.LayoutComposer.FLEXIBLE_ROW;
import static blyskavka.common.LayoutComposer.MARGIN;
import static blyskavka.common.StandardScrollingConfigs.standardStandaloneScrollingConfig;
import static java.lang.String.format;
import static metamodels.MetaModels.AnimalSpecies_;
import static ua.com.fielden.platform.web.PrefDim.mkDim;
import static ua.com.fielden.platform.web.layout.api.impl.LayoutBuilder.cell;

import java.util.Optional;

import com.google.inject.Injector;

import blyskavka.animal.AnimalSpecies;
import blyskavka.common.LayoutComposer;
import blyskavka.common.StandardActions;
import blyskavka.main.menu.animal.MiAnimalSpecies;
import ua.com.fielden.platform.web.PrefDim.Unit;
import ua.com.fielden.platform.web.action.CentreConfigurationWebUiConfig.CentreConfigActions;
import ua.com.fielden.platform.web.app.config.IWebUiBuilder;
import ua.com.fielden.platform.web.centre.EntityCentre;
import ua.com.fielden.platform.web.centre.api.EntityCentreConfig;
import ua.com.fielden.platform.web.centre.api.actions.EntityActionConfig;
import ua.com.fielden.platform.web.centre.api.impl.EntityCentreBuilder;
import ua.com.fielden.platform.web.interfaces.ILayout.Device;
import ua.com.fielden.platform.web.view.master.EntityMaster;
import ua.com.fielden.platform.web.view.master.api.IMaster;
import ua.com.fielden.platform.web.view.master.api.actions.MasterActions;
import ua.com.fielden.platform.web.view.master.api.impl.SimpleMasterBuilder;

/**
 * {@link AnimalSpecies} Web UI configuration.
 *
 * @author Developers
 *
 */
public class AnimalSpeciesWebUiConfig {

    public final EntityCentre<AnimalSpecies> centre;
    public final EntityMaster<AnimalSpecies> master;

    public static AnimalSpeciesWebUiConfig register(final Injector injector, final IWebUiBuilder builder) {
        return new AnimalSpeciesWebUiConfig(injector, builder);
    }

    private AnimalSpeciesWebUiConfig(final Injector injector, final IWebUiBuilder builder) {
        centre = createCentre(injector, builder);
        builder.register(centre);
        master = createMaster(injector);
        builder.register(master);
    }

    /**
     * Creates entity centre for {@link AnimalSpecies}.
     *
     * @param injector
     * @return created entity centre
     */
    private EntityCentre<AnimalSpecies> createCentre(final Injector injector, final IWebUiBuilder builder) {
        final String layout = LayoutComposer.mkGridForCentre(1, 2);

        final EntityActionConfig standardNewAction = StandardActions.NEW_ACTION.mkAction(AnimalSpecies.class);
        final EntityActionConfig standardDeleteAction = StandardActions.DELETE_ACTION.mkAction(AnimalSpecies.class);
        final EntityActionConfig standardExportAction = StandardActions.EXPORT_ACTION.mkAction(AnimalSpecies.class);
        final EntityActionConfig standardEditAction = StandardActions.EDIT_ACTION.mkAction(AnimalSpecies.class);
        final EntityActionConfig standardSortAction = CentreConfigActions.CUSTOMISE_COLUMNS_ACTION.mkAction();
        builder.registerOpenMasterAction(AnimalSpecies.class, standardEditAction);

        final EntityCentreConfig<AnimalSpecies> ecc = EntityCentreBuilder.centreFor(AnimalSpecies.class)
                //.runAutomatically()
                .addFrontAction(standardNewAction)
                .addTopAction(standardNewAction).also()
                .addTopAction(standardDeleteAction).also()
                .addTopAction(standardSortAction).also()
                .addTopAction(standardExportAction)
                .addCrit(AnimalSpecies_).asMulti().autocompleter(AnimalSpecies.class).also()
                .addCrit(AnimalSpecies_.desc()).asMulti().text().also()
                .addCrit(AnimalSpecies_.active()).asMulti().bool()
                .setLayoutFor(Device.DESKTOP, Optional.empty(), layout)
                .setLayoutFor(Device.TABLET, Optional.empty(), layout)
                .setLayoutFor(Device.MOBILE, Optional.empty(), layout)
                .withScrollingConfig(standardStandaloneScrollingConfig(0))
                .addProp(AnimalSpecies_).order(1).asc().minWidth(100)
                    .withSummary("total_count_", "COUNT(SELF)", format("Count:The total number of matching %ss.", AnimalSpecies.ENTITY_TITLE))
                    .withAction(standardEditAction).also()
                .addProp(AnimalSpecies_.desc()).minWidth(300).also()
                .addProp(AnimalSpecies_.active()).minWidth(70)
                //.addProp("prop").minWidth(100).withActionSupplier(builder.getOpenMasterAction(Entity.class)).also()
                .addPrimaryAction(standardEditAction)
                .build();

        return new EntityCentre<>(MiAnimalSpecies.class, ecc, injector);
    }

    /**
     * Creates entity master for {@link AnimalSpecies}.
     *
     * @param injector
     * @return created entity master
     */
    private EntityMaster<AnimalSpecies> createMaster(final Injector injector) {
//        final String layout = LayoutComposer.mkGridForMasterFitWidth(1, 2);
        
        String layout = cell(
                cell(cell(CELL_LAYOUT).repeat(2).withGapBetweenCells(MARGIN)).
                cell(cell(CELL_LAYOUT), FLEXIBLE_ROW), FLEXIBLE_LAYOUT_WITH_PADDING).toString();

        final IMaster<AnimalSpecies> masterConfig = new SimpleMasterBuilder<AnimalSpecies>().forEntity(AnimalSpecies.class)
                .addProp(AnimalSpecies_.title()).asSinglelineText().also()
                .addProp(AnimalSpecies_.active()).asCheckbox().also()
                .addProp(AnimalSpecies_.desc()).asMultilineText().also()
                .addAction(MasterActions.REFRESH).shortDesc("Cancel").longDesc("Cancel action")
                .addAction(MasterActions.SAVE)
                .setActionBarLayoutFor(Device.DESKTOP, Optional.empty(), LayoutComposer.mkActionLayoutForMaster())
                .setLayoutFor(Device.DESKTOP, Optional.empty(), layout)
                .setLayoutFor(Device.TABLET, Optional.empty(), layout)
                .setLayoutFor(Device.MOBILE, Optional.empty(), layout)
                .withDimensions(mkDim(LayoutComposer.SIMPLE_ONE_COLUMN_MASTER_DIM_WIDTH, 480, Unit.PX))
                .done();

        return new EntityMaster<>(AnimalSpecies.class, masterConfig, injector);
    }
}