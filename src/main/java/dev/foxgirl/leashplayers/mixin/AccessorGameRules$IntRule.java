package dev.foxgirl.leashplayers.mixin;

import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameRules.IntRule.class)
public interface AccessorGameRules$IntRule {
    @Invoker("create")
    static GameRules.Type<GameRules.IntRule> callCreate(int initialValue) {
        throw new AssertionError();
    }
}
