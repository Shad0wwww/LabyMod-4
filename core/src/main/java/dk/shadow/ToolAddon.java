package dk.shadow;

import dk.shadow.config.Configuration;
import dk.shadow.listener.OnKeyPress;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.Minecraft;
import net.labymod.api.client.gui.screen.key.Key;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class ToolAddon extends LabyAddon<Configuration> {
  public Configuration configuration = (Configuration)configuration();
  @Override
  protected void enable() {
    this.registerSettingCategory();
    this.registerListener(new OnKeyPress(this));
    this.logger().info("Enable the Addon");
  }

  @Override
  protected Class<Configuration> configurationClass() {
    return Configuration.class;
  }

  public boolean isCopyKoordinatPressed() {

    Minecraft minecraft = labyAPI().minecraft();
    if (!(Boolean) configuration.enabled().get())
      return false;
    if (!minecraft.isKeyPressed((Key)configuration.copyKoordinat().get()))
      return false;
    return (minecraft.isMouseLocked());
  }

}
