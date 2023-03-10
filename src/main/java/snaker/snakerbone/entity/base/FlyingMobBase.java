package snaker.snakerbone.entity.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import snaker.snakerbone.data.SnakerBoneAttributes;
import snaker.snakerbone.entity.ai.SnakerBoneFlyingControl;
import snaker.snakerbone.entity.ai.SnakerBoneLookAroundGoal;
import snaker.snakerbone.entity.ai.SnakerBoneRandomFlyGoal;
import snaker.snakerbone.entity.ai.SnakerBoneSwitchPlayerGameModeGoal;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class FlyingMobBase extends FlyingMob implements Enemy {
    protected FlyingMobBase(EntityType<? extends FlyingMobBase> type, Level world) {

        super(type, world);

        moveControl = new SnakerBoneFlyingControl(this);

        xpReward = SnakerBoneAttributes.MOB_XP_REWARD;

    }

    @Override
    protected boolean shouldDespawnInPeaceful() {

        return true;

    }

    @Override
    public boolean causeFallDamage(float distance, float multiplier, DamageSource source) {

        return false;

    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {


    }

    @Override
    public boolean onClimbable() {

        return false;

    }

    protected void registerGoals() {
        goalSelector.addGoal(4, new SnakerBoneRandomFlyGoal(this));
        goalSelector.addGoal(6, new SnakerBoneLookAroundGoal(this));
        goalSelector.addGoal(1, new SnakerBoneSwitchPlayerGameModeGoal(this));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
}
