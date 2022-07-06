package uk.co.speedypos.epp_log_service.helpers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This helper class is used to map the source object to the destination object.
 *
 * @author Supto Purakayasto
 * @version 1.0
 * @since 1.0
 */
public class MapperHelper {

    private static final ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    /**
     * Hide from public usage.
     */
    private MapperHelper() {
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param <D>      type of result object.
     * @param <T>      type of source object to map from.
     * @param entity   entity that needs to be mapped.
     * @param outClass class of result object.
     * @return new object of <code>outClass</code> type.
     */
    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param entityList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in <code>entityList</code>
     * @return list of mapped object with <code><D></code> type.
     */
    public static <D, T> List<D> mapList(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                         .map(entity -> map(entity, outCLass))
                         .collect(Collectors.toList());
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param entitySet set of entities that needs to be mapped
     * @param outCLass   class of result set element
     * @param <D>        type of objects in result set
     * @param <T>        type of entity in <code>entitySet</code>
     * @return list of mapped object with <code><D></code> type.
     */
    public static <D, T> Set<D> mapSet(final Collection<T> entitySet, Class<D> outCLass) {
        return entitySet.stream()
                         .map(entity -> map(entity, outCLass))
                         .collect(Collectors.toSet());
    }

    /**
     * Maps {@code source} to {@code destination}.
     *
     * @param source      object to map from
     * @param destination object to map to
     */
    public static <S, D> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}
