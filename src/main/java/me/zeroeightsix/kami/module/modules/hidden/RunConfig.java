package me.zeroeightsix.kami.module.modules.hidden;

import me.zeroeightsix.kami.module.Module;
import me.zeroeightsix.kami.module.modules.capes.Capes;
import me.zeroeightsix.kami.module.modules.chat.CustomChat;
import me.zeroeightsix.kami.module.modules.client.ActiveModules;
import me.zeroeightsix.kami.module.modules.client.CommandConfig;
import me.zeroeightsix.kami.module.modules.client.InfoOverlay;
import me.zeroeightsix.kami.module.modules.client.InventoryViewer;
import me.zeroeightsix.kami.module.modules.misc.DiscordSettings;
import me.zeroeightsix.kami.module.modules.render.TabFriends;
import me.zeroeightsix.kami.setting.Setting;
import me.zeroeightsix.kami.setting.Settings;

import static me.zeroeightsix.kami.KamiMod.MODULE_MANAGER;

/**
 * @author S-B99
 * Horribly designed class for uh, running things only once.
 */
@Module.Info(name = "RunConfig", category = Module.Category.HIDDEN, showOnArray = Module.ShowOnArray.OFF, description = "Default manager for first runs")
public class RunConfig extends Module {
    private Setting<Boolean> hasRunCapes = register(Settings.b("Capes", false));
    private Setting<Boolean> hasRunDiscordSettings = register(Settings.b("DiscordSettings", false));
    private Setting<Boolean> hasRunFixGui = register(Settings.b("FixGui", false));
    private Setting<Boolean> hasRunTabFriends = register(Settings.b("TabFriends", false));
    private Setting<Boolean> hasRunCustomChat = register(Settings.b("CustomChat", false));

    public void onEnable() {
        MODULE_MANAGER.getModule(ActiveModules.class).enable();
        MODULE_MANAGER.getModule(CommandConfig.class).enable();
        MODULE_MANAGER.getModule(InfoOverlay.class).enable();
        MODULE_MANAGER.getModule(InventoryViewer.class).enable();

        if (!hasRunCapes.getValue()) {
            MODULE_MANAGER.getModule(Capes.class).enable();
            hasRunCapes.setValue(true);
        }
        if (!hasRunDiscordSettings.getValue()) {
            MODULE_MANAGER.getModule(DiscordSettings.class).enable();
            hasRunDiscordSettings.setValue(true);
        }
        if (!hasRunFixGui.getValue()) {
            MODULE_MANAGER.getModule(FixGui.class).enable();
            hasRunFixGui.setValue(true);
        }
        if (!hasRunTabFriends.getValue()) {
            MODULE_MANAGER.getModule(TabFriends.class).enable();
            hasRunTabFriends.setValue(true);
        }
        if (!hasRunCustomChat.getValue()) {
            MODULE_MANAGER.getModule(CustomChat.class).enable();
            hasRunCustomChat.setValue(true);
        }
        disable();
    }
}
