package cn.mcxkly.classicandsimplestatusbars.mixin;

import cc.xypp.battery_shield.hud.PlayerShieldOverlay;
import cn.mcxkly.classicandsimplestatusbars.Config;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerShieldOverlay.class, remap = false)
public class BatteryShieldMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int width, int height, CallbackInfo ci) {
        if ( Config.All_On || Config.Battery_Shield_On ) {
            ci.cancel();
        }
    }
}