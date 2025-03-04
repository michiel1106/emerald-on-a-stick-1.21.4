package bikerboys.eoas.mixin;

import bikerboys.eoas.ModItems.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(VillagerEntity.class)
public abstract class ExampleMixin extends MerchantEntity {


	public ExampleMixin(EntityType<? extends MerchantEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("TAIL"), method = "tick")
	private void init(CallbackInfo info) {

		this.goalSelector.add(3, new TemptGoal((VillagerEntity) (Object) this, 0.5F, (stack) -> {
			return stack.isOf(ModItems.EMERALD_ON_A_STICK);
		}, false));
	}


	@Inject(at = @At("RETURN"), method = "createVillagerAttributes", cancellable = true)
	private static void villaaer(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
		cir.setReturnValue(
				cir.getReturnValue()
						.add(EntityAttributes.TEMPT_RANGE, 16.0) // Adds a 16-block following range
		);

	}
}