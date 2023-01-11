package blyskavka.animal;

import com.google.inject.Inject;

import java.util.Collection;
import java.util.List;

import ua.com.fielden.platform.entity.fetch.IFetchProvider;
import ua.com.fielden.platform.security.Authorise;
import ua.com.fielden.platform.dao.annotations.SessionRequired;
import blyskavka.security.tokens.persistent.AnimalSpecies_CanSave_Token;
import blyskavka.security.tokens.persistent.AnimalSpecies_CanDelete_Token;
import ua.com.fielden.platform.dao.CommonEntityDao;
import ua.com.fielden.platform.entity.query.IFilter;
import ua.com.fielden.platform.entity.annotation.EntityType;

/**
 * DAO implementation for companion object {@link AnimalSpeciesCo}.
 *
 * @author Developers
 *
 */
@EntityType(AnimalSpecies.class)
public class AnimalSpeciesDao extends CommonEntityDao<AnimalSpecies> implements AnimalSpeciesCo {

    @Inject
    public AnimalSpeciesDao(final IFilter filter) {
        super(filter);
    }
    
    @Override
        public AnimalSpecies new_() {
            return super.new_().setActive(true);
        }

    @Override
    @SessionRequired
    @Authorise(AnimalSpecies_CanSave_Token.class)
    public AnimalSpecies save(AnimalSpecies entity) {
        return super.save(entity);
    }

    @Override
    @SessionRequired
    @Authorise(AnimalSpecies_CanDelete_Token.class)
    public int batchDelete(final Collection<Long> entitiesIds) {
        return defaultBatchDelete(entitiesIds);
    }

    @Override
    @SessionRequired
    @Authorise(AnimalSpecies_CanDelete_Token.class)
    public int batchDelete(final List<AnimalSpecies> entities) {
        return defaultBatchDelete(entities);
    }

    @Override
    protected IFetchProvider<AnimalSpecies> createFetchProvider() {
        return FETCH_PROVIDER;
    }
}