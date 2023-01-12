package blyskavka.animal;

import com.google.inject.Inject;

import java.util.Collection;
import java.util.List;

import ua.com.fielden.platform.entity.fetch.IFetchProvider;
import ua.com.fielden.platform.security.Authorise;
import ua.com.fielden.platform.dao.annotations.SessionRequired;
import blyskavka.security.tokens.persistent.Animal_CanSave_Token;
import blyskavka.security.tokens.persistent.Animal_CanDelete_Token;
import ua.com.fielden.platform.dao.CommonEntityDao;
import ua.com.fielden.platform.entity.query.IFilter;
import ua.com.fielden.platform.entity.annotation.EntityType;

/**
 * DAO implementation for companion object {@link AnimalCo}.
 *
 * @author Developers
 *
 */
@EntityType(Animal.class)
public class AnimalDao extends CommonEntityDao<Animal> implements AnimalCo {

    @Inject
    public AnimalDao(final IFilter filter) {
        super(filter);
    }

    @Override
    @SessionRequired
    @Authorise(Animal_CanSave_Token.class)
    public Animal save(Animal entity) {
        return super.save(entity);
    }

    @Override
    @SessionRequired
    @Authorise(Animal_CanDelete_Token.class)
    public int batchDelete(final Collection<Long> entitiesIds) {
        return defaultBatchDelete(entitiesIds);
    }

    @Override
    @SessionRequired
    @Authorise(Animal_CanDelete_Token.class)
    public int batchDelete(final List<Animal> entities) {
        return defaultBatchDelete(entities);
    }

    @Override
    protected IFetchProvider<Animal> createFetchProvider() {
        return FETCH_PROVIDER;
    }
}