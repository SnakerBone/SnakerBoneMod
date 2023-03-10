package snaker.snakerbone.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

/**
 * Created by SnakerBone on 21/02/2023
 **/
public class SnakerBoneWanderGoal extends Goal {
    private final Animal entity;

    public SnakerBoneWanderGoal(Animal owner) {

        this.setFlags(EnumSet.of(Flag.MOVE));

        entity = owner;
    }

    public boolean canUse() {

        RandomSource random = entity.getRandom();

        return entity.getNavigation().isDone() && random.nextInt(3) == 0;

    }

    public boolean canContinueToUse() {

        return entity.getNavigation().isInProgress();

    }

    public void start() {

        Vec3 randomPos = this.getRandom();

        if (randomPos != null) {

            entity.getNavigation().moveTo(entity.getNavigation().createPath(new BlockPos(randomPos), 1), 1);

        }

    }

    private Vec3 getRandom() {

        Vec3 vec3;

        vec3 = entity.getViewVector(0);

        Vec3 randomPos = HoverRandomPos.getPos(entity, 8, 7, vec3.x, vec3.z, ((float) Math.PI / 2), 3, 1);

        return randomPos != null ? randomPos : AirAndWaterRandomPos.getPos(entity, 8, 4, -2, vec3.x, vec3.z, (float) Math.PI / 2);

    }
}
