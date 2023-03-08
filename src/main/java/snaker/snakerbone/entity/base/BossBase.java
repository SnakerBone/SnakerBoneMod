package snaker.snakerbone.entity.base;

import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import snaker.snakerbone.data.SnakerBoneAttributes;
import snaker.snakerbone.entity.ai.goal.SnakerBoneSwitchGameModeGoal;

import static snaker.snakerbone.util.SnakerBonePolicy.WarningSuppression.CUSTOM_SET;

/**
 * Created by SnakerBone on 4/01/2023
 **/
@SuppressWarnings(CUSTOM_SET)
public class BossBase extends MobBase {
    private final ServerBossEvent BOSS_INFO = new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS);

    public BossBase(EntityType<? extends Monster> type, Level world) {

        super(type, world);

        xpReward = SnakerBoneAttributes.BOSS_XP_REWARD;

    }

    public BossEvent.BossBarColor getBarColor() {

        return BossEvent.BossBarColor.BLUE;

    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(9, new SnakerBoneSwitchGameModeGoal(this));
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {

        return false;

    }

    @Override
    public void startSeenByPlayer(ServerPlayer player) {

        super.startSeenByPlayer(player);

        BOSS_INFO.setColor(getBarColor());

        BOSS_INFO.addPlayer(player);

    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {

        super.stopSeenByPlayer(player);

        BOSS_INFO.removePlayer(player);

    }

    @Override
    public void tick() {

        super.tick();

        BOSS_INFO.setProgress(this.getHealth() / this.getMaxHealth());

    }
}
