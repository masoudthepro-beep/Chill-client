package com.chill;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "chillmod", name = "Chill Mod", version = "1.0")
public class ChillMod {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.type != RenderGameOverlayEvent.ElementType.TEXT) return;
        Minecraft mc = Minecraft.getMinecraft();

        // CYAN HUD ELEMENTS
        mc.fontRendererObj.drawStringWithShadow("§b[ §fCHILL §b] §f" + Minecraft.getDebugFPS() + " FPS", 4, 4, -1);
        mc.fontRendererObj.drawStringWithShadow("§7User: §bMinecraft Player", 4, 14, -1);
    }

    @SubscribeEvent
    public void onGuiInit(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.gui instanceof GuiIngameMenu) {
            event.buttonList.add(new net.minecraft.client.gui.GuiButton(500, 
                event.gui.width / 2 - 100, 10, 200, 20, "§bCHILL SETTINGS"));
        }
    }
}
