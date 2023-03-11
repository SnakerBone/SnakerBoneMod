package snaker.snakerbone.entity.ai;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

/**
 * Created by SnakerBone on 2/01/2023
 **/
public class RandomFlyGoal extends Goal {
    private final Mob mob;

    public RandomFlyGoal(Mob owner) {
        mob = owner;
        setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        MoveControl controller = mob.getMoveControl();
        if (!controller.hasWanted()) {
            return true;
        } else {
            double x = controller.getWantedX() - mob.getX();
            double y = controller.getWantedY() - mob.getY();
            double z = controller.getWantedZ() - mob.getZ();
            double xyz = x * x + y * y + z * z;
            return xyz < 1 || xyz > 3600;
        }
    }

    public boolean canContinueToUse() {
        return false;
    }

    public void start() {
        RandomSource random = mob.getRandom();
        double x = mob.getX() + (double) ((random.nextFloat() * 2 - 1) * 16);
        double y = mob.getY() + (double) ((random.nextFloat() * 2 - 1) * 16);
        double z = mob.getZ() + (double) ((random.nextFloat() * 2 - 1) * 16);
        mob.getMoveControl().setWantedPosition(x, y, z, 1);
    }
}
