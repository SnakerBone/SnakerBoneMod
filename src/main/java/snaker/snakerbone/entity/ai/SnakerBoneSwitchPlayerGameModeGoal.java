package snaker.snakerbone.entity.ai;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import snaker.snakerbone.config.SnakerBoneCommonConfig;

import java.util.List;

/**
 * Created by SnakerBone on 28/02/2023
 **/
public class SnakerBoneSwitchPlayerGameModeGoal extends Goal {
    private final Mob mob;

    public SnakerBoneSwitchPlayerGameModeGoal(Mob owner) {

        mob = owner;

    }

    @Override
    public void tick() {

        Level world = mob.level;

        List<ServerPlayer> players = world.getEntitiesOfClass(ServerPlayer.class, mob.getBoundingBox().inflate(8));

        if (players.stream().anyMatch(ServerPlayer::isCreative)) {

            Component text = Component.translatable("status.snakerbone.creative_player_hurt_mob");

            for (ServerPlayer player : players) {

                player.setGameMode(GameType.SURVIVAL);

                mob.setTarget(player);

                player.displayClientMessage(text, true);

                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50, 2));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 10));

            }
        }
    }

    @Override
    public boolean canUse() {

        return SnakerBoneCommonConfig.playerVulnerableInCreative.get() && mob.getLastHurtByMob() instanceof ServerPlayer;

    }
}
