package dk.shadow.listener;

import dk.shadow.ToolAddon;
import net.labymod.api.Laby;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.entity.player.Player;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.input.KeyEvent;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class OnKeyPress {

  private final ToolAddon main;

  public OnKeyPress(ToolAddon main) {
    this.main = main;
  }

  @Subscribe
  public void onKeyInput(KeyEvent event) {


    if (main.isCopyKoordinatPressed() && main.configuration.enabled().get()) {
      Player player = Laby.labyAPI().minecraft().getClientPlayer();

      System.out.println("Key pressed");
      String playerPosX = String.valueOf((player == null) ? 0 : (int) (player.getPosX()));
      String playerPosY = String.valueOf((player == null) ? 0 : (int) (player.getPosY()));
      String playerPosZ = String.valueOf((player == null) ? 0 : (int) (player.getPosZ()));


      main.displayMessage(Component.text("Kopier" + " " + playerPosX + "," + " " + playerPosY + "," + " " + playerPosZ,
          NamedTextColor.GREEN));

      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(playerPosX + "," + " " + playerPosY + "," + " " + playerPosZ), null);


    }

  }
}
