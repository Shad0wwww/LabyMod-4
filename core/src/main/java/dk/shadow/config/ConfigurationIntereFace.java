package dk.shadow.config;

import net.labymod.api.client.gui.screen.key.Key;
import net.labymod.api.configuration.loader.ConfigAccessor;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public interface ConfigurationIntereFace extends ConfigAccessor {
  ConfigProperty<Boolean> enabled();
  ConfigProperty<Key> copyKoordinat();
}
