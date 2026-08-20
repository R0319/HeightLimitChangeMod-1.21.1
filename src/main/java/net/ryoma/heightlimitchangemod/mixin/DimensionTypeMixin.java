package net.ryoma.heightlimitchangemod.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.ryoma.heightlimitchangemod.NetherHeightConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionType.class)
public class DimensionTypeMixin {
    @Inject(method = "height", at = @At("RETURN"), cancellable = true)
    private void overrideNetherHeight(CallbackInfoReturnable<Integer> cir) {
        DimensionType self = (DimensionType)(Object)this;
        if (self.effectsLocation().equals(ResourceLocation.withDefaultNamespace("the_nether"))) {
            cir.setReturnValue(NetherHeightConfig.getInstance().netherHeight);
        }
    }

    @Inject(method = "logicalHeight", at = @At("RETURN"), cancellable = true)
    private void overrideNetherLogicalHeight(CallbackInfoReturnable<Integer> cir) {
        DimensionType self = (DimensionType)(Object)this;
        if (self.effectsLocation().equals(ResourceLocation.withDefaultNamespace("the_nether"))) {
            cir.setReturnValue(NetherHeightConfig.getInstance().netherHeight);
        }
    }
}
