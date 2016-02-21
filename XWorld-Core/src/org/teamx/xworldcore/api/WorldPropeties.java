package org.teamx.xworldcore.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shustin
 */
public class WorldPropeties {

    private static final Map<String, String> PROPERTIES; ;

    static {

        PROPERTIES = new HashMap<String, String>();
        PROPERTIES.put("monsters", "mobs.spawning.monsters.spawn");
        PROPERTIES.put("animals", "mobs.spawning.animals.spawn");
        PROPERTIES.put("weather", "weather.changing.weather");
        PROPERTIES.put("storm", "weather.changing.weather.storm");

        /**
         *
         * If you want to fill this map:
         * Go to {@link org.teamx.xworldcore.api.world.IXWorld}.
         *
         */

    }

}
