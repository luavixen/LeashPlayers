package dev.foxgirl.leashplayers;

import dev.foxgirl.leashplayers.mixin.AccessorGameRules;
import dev.foxgirl.leashplayers.mixin.AccessorGameRules$BooleanRule;
import dev.foxgirl.leashplayers.mixin.AccessorGameRules$IntRule;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("leashplayers")
public final class LeashPlayers {
    private static GameRules.Key<GameRules.BooleanRule> ruleEnabled;
    private static GameRules.Key<GameRules.IntRule> ruleDistanceMin;
    private static GameRules.Key<GameRules.IntRule> ruleDistanceMax;

    public static LeashSettings getSettings(World world) {
        return new LeashSettings() {
            private GameRules getGameRules() {
                return world.getGameRules();
            }

            @Override
            public boolean isEnabled() {
                return getGameRules().getBoolean(ruleEnabled);
            }

            @Override
            public double getDistanceMin() {
                return getGameRules().get(ruleDistanceMin).get();
            }

            @Override
            public double getDistanceMax() {
                return getGameRules().get(ruleDistanceMax).get();
            }
        };
    }

    public LeashPlayers() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        ruleEnabled = AccessorGameRules.callRegister("leashPlayersEnabled", GameRules.Category.PLAYER, AccessorGameRules$BooleanRule.callCreate(true));
        ruleDistanceMin = AccessorGameRules.callRegister("leashPlayersDistanceMin", GameRules.Category.PLAYER, AccessorGameRules$IntRule.callCreate(4));
        ruleDistanceMax = AccessorGameRules.callRegister("leashPlayersDistanceMax", GameRules.Category.PLAYER, AccessorGameRules$IntRule.callCreate(10));
    }
}
