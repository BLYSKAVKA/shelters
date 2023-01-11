package blyskavka.animal;

import ua.com.fielden.platform.entity.fetch.IFetchProvider;
import ua.com.fielden.platform.utils.EntityUtils;

import static metamodels.MetaModels.AnimalSpecies_;

import ua.com.fielden.platform.dao.IEntityDao;

/**
 * Companion object for entity {@link AnimalSpecies}.
 *
 * @author Vira Saliieva
 *
 */
public interface AnimalSpeciesCo extends IEntityDao<AnimalSpecies> {

    static final IFetchProvider<AnimalSpecies> FETCH_PROVIDER = EntityUtils.fetch(AnimalSpecies.class).with(
            AnimalSpecies_.title(), AnimalSpecies_.desc(), AnimalSpecies_.active());

}
