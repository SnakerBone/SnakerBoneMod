package snaker.snakerbone.entity.ai;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class LookAroundGoal extends Goal {
    private final Mob mob;

    public LookAroundGoal(Mob owner) {
        mob = owner;
        setFlags(EnumSet.of(Goal.Flag.LOOK));
    }

    public boolean canUse() {
        return true;
    }

    public void tick() {
        if (mob.getTarget() == null) {
            Vec3 movement = mob.getDeltaMovement();
            mob.setXRot(-((float) Mth.atan2(movement.x, movement.z)) * (180 / (float) Math.PI));
            mob.xRotO = mob.getXRot();
        } else {
            LivingEntity target = mob.getTarget();
            if (target.distanceToSqr(mob) < 4096) {
                double x = target.getX() - mob.getX();
                double z = target.getZ() - mob.getZ();
                mob.setXRot(-((float) Mth.atan2(x, z)) * (180 / (float) Math.PI));
                mob.xRotO = mob.getXRot();
            }
        }
    }
}
