package snaker.snakerbone.entity.base;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import snaker.snakerbone.data.SnakerBoneAttributes;
import snaker.snakerbone.entity.ai.SnakerBoneSwitchPlayerGameModeGoal;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class MobBase extends Monster {
    public MobBase(EntityType<? extends Monster> type, Level world) {

        super(type, world);

        xpReward = SnakerBoneAttributes.MOB_XP_REWARD;

    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new SnakerBoneSwitchPlayerGameModeGoal(this));
        goalSelector.addGoal(6, new RandomStrollGoal(this, 1));
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.3, false));
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }
}
