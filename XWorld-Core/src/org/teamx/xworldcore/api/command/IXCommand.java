package org.teamx.xworldcore.api.command;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

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

}
