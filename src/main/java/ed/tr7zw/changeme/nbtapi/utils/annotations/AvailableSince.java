package ed.tr7zw.changeme.nbtapi.utils.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import ed.tr7zw.changeme.nbtapi.utils.MinecraftVersion;

@Retention(RUNTIME)
@Target({ METHOD })
public @interface AvailableSince {

	MinecraftVersion version();

}