package boilerplate.dagger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmitriy Zaitsev
 * @since 2016-Apr-05, 13:34
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {}
