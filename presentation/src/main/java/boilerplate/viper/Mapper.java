package boilerplate.viper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-04, 02:21
 */
public abstract class Mapper<From, To> {
  public abstract To map(From entity);

  public final Collection<To> map(Collection<From> collection) {
    final Collection<To> result = new ArrayList<>(collection.size());
    //noinspection Convert2streamapi
    for (From from : collection) {
      result.add(map(from));
    }
    return result;
  }
}
