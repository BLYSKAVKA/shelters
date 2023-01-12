package blyskavka.animal;

import ua.com.fielden.platform.entity.fetch.IFetchProvider;
import ua.com.fielden.platform.utils.EntityUtils;
import ua.com.fielden.platform.dao.IEntityDao;

/**
 * Companion object for entity {@link Animal}.
 *
 * @author Developers
 *
 */
public interface AnimalCo extends IEntityDao<Animal> {

    static final IFetchProvider<Animal> FETCH_PROVIDER = EntityUtils.fetch(Animal.class).with(
        // TODO: uncomment the following line and specify the properties, which are required for the UI. Then remove the line after.
        // "key", "desc");
        "Please specify the properties, which are required for the UI");

}
