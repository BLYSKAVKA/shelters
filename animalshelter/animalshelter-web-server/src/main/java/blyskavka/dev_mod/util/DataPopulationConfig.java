package blyskavka.dev_mod.util;

import java.util.Properties;

import com.google.inject.Injector;

import blyskavka.config.ApplicationDomain;
import blyskavka.dbsetup.HibernateSetup;
import blyskavka.filter.NoDataFilter;
import blyskavka.ioc.ApplicationServerModule;
import blyskavka.serialisation.SerialisationClassProvider;

import ua.com.fielden.platform.entity.factory.EntityFactory;
import ua.com.fielden.platform.entity.query.IdOnlyProxiedEntityTypeCache;
import ua.com.fielden.platform.entity.query.metadata.DomainMetadata;
import ua.com.fielden.platform.ioc.ApplicationInjectorFactory;
import ua.com.fielden.platform.ioc.NewUserNotifierMockBindingModule;
import ua.com.fielden.platform.security.NoAuthorisation;
import ua.com.fielden.platform.test.DbDrivenTestCase;
import ua.com.fielden.platform.test.IDomainDrivenTestCaseConfiguration;

import ua.com.fielden.platform.utils.DefaultDates;
import ua.com.fielden.platform.utils.DefaultUniversalConstants;

/**
 * Provides animalshelter specific implementation of {@link IDomainDrivenTestCaseConfiguration} to be used for creation and population of the target development database from within of IDE.
 *
 * @author Generated
 */
public final class DataPopulationConfig implements IDomainDrivenTestCaseConfiguration {

    private final EntityFactory entityFactory;
    private final Injector injector;
    private final ApplicationServerModule module;

    /**
     * Default constructor is required for dynamic instantiation by {@link DbDrivenTestCase}.
     */
    public DataPopulationConfig(final Properties props) {
        // instantiate all the factories and Hibernate utility
        try {
            // application properties
            props.setProperty("app.name", "animalshelter");
            props.setProperty("reports.path", "");
            props.setProperty("domain.path", "../animalshelter-pojo-bl/target/classes");
            props.setProperty("domain.package", "blyskavka");
            props.setProperty("tokens.path", "../animalshelter-pojo-bl/target/classes");
            props.setProperty("tokens.package", "blyskavka.security.tokens");
            props.setProperty("workflow", "development");
            props.setProperty("email.smtp", "localhost");
            props.setProperty("email.fromAddress", "animalshelter_support@team.com.ua");

            final ApplicationDomain applicationDomainProvider = new ApplicationDomain();
            module = new ApplicationServerModule(
                    HibernateSetup.getHibernateTypes(),
                    applicationDomainProvider,
                    applicationDomainProvider.domainTypes(),
                    SerialisationClassProvider.class,
                    NoDataFilter.class,
                    NoAuthorisation.class,
                    DefaultUniversalConstants.class,
                    DefaultDates.class,
                    props);
            injector = new ApplicationInjectorFactory()
                    .add(module)
                    .add(new NewUserNotifierMockBindingModule())
                    .getInjector();
            entityFactory = injector.getInstance(EntityFactory.class);
        } catch (final Exception e) {
            throw new IllegalStateException("Could not create data population configuration.", e);
        }
    }

    @Override
    public EntityFactory getEntityFactory() {
        return entityFactory;
    }

    @Override
    public <T> T getInstance(final Class<T> type) {
        return injector.getInstance(type);
    }

    @Override
    public DomainMetadata getDomainMetadata() {
        return module.getDomainMetadata();
    }

    @Override
    public IdOnlyProxiedEntityTypeCache getIdOnlyProxiedEntityTypeCache() {
        return module.getIdOnlyProxiedEntityTypeCache();
    }

}
