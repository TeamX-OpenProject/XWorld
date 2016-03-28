package org.teamx.xworldcore.api.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Shustin
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public abstract @interface IXCommand {

    public String permission() default "";

    public String name() default "";

    public String[] aliases()  default {};

    public String noPermission() default "§cYou do not have permission to perform that action";

    public String description() default "";

    public String usage() default "";

    public int minArgs();

    public int maxArgs();

}
