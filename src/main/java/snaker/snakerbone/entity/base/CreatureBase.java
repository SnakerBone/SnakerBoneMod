package snaker.snakerbone.entity.base;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import snaker.snakerbone.data.AttributeConstants;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class CreatureBase extends PathfinderMob {
    public CreatureBase(EntityType<? extends PathfinderMob> type, Level world) {
        super(type, world);
        xpReward = AttributeConstants.CREATURE_XP_REWARD;
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1));
        goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6));
    }
}
