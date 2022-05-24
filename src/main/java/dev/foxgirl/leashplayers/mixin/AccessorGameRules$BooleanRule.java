package dev.foxgirl.leashplayers.mixin;

import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.BooleanRule.class)
public interface AccessorGameRules$BooleanRule {
    @Invoker("create")
    static GameRules.Type<GameRules.BooleanRule> callCreate(boolean initialValue) {
        throw new AssertionError();
    }
}
