package snownee.fruits.food;

import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.ForgeRegistries;
import snownee.fruits.Hooks;
import snownee.kiwi.AbstractModule;
import snownee.kiwi.KiwiGO;
import snownee.kiwi.KiwiModule;

@KiwiModule("food")
@KiwiModule.Optional
@KiwiModule.Category("food")
public class FoodModule extends AbstractModule {

	public static final class Foods {
		private static Supplier<MobEffectInstance> makeSupplier(String id, int duration, int amplifier) {
			return Lazy.of(() -> {
				MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(id));
				if (effect == null) {
					return null;
				}
				return new MobEffectInstance(effect, duration, amplifier);
			});
		}

		private static final Supplier<MobEffectInstance> NOURISHED_PROVIDER = makeSupplier("farmersdelight:nourished", 6000, 0);
		private static final Supplier<MobEffectInstance> COMFORT_PROVIDER = makeSupplier("farmersdelight:comfort", 3600, 0);
		private static final Supplier<MobEffectInstance> REGENERATION_PROVIDER = makeSupplier("regeneration", 120, 0);
		private static final Supplier<MobEffectInstance> SPEED_PROVIDER = makeSupplier("speed", 1200, 0);

		public static final FoodProperties GRAPEFRUIT_PANNA_COTTA = new FoodProperties.Builder().nutrition(14).saturationMod(1).effect(SPEED_PROVIDER, 1).build();
		public static final FoodProperties DONAUWELLE = new FoodProperties.Builder().nutrition(14).saturationMod(1).effect(REGENERATION_PROVIDER, 1).build();
		public static final FoodProperties HONEY_POMELO_TEA = new FoodProperties.Builder().nutrition(1).saturationMod(Hooks.farmersdelight ? 0.3F : 4).effect(COMFORT_PROVIDER, 1).alwaysEat().build();
		public static final FoodProperties RICE_WITH_FRUITS = new FoodProperties.Builder().nutrition(9).saturationMod(0.6F).effect(COMFORT_PROVIDER, 1).build();
		public static final FoodProperties LEMON_ROAST_CHICKEN = new FoodProperties.Builder().nutrition(12).saturationMod(0.9F).effect(NOURISHED_PROVIDER, 1).build();
	}

	public static final KiwiGO<Item> GRAPEFRUIT_PANNA_COTTA = go(() -> new FoodItem(itemProp().food(Foods.GRAPEFRUIT_PANNA_COTTA)));
	public static final KiwiGO<Item> DONAUWELLE = go(() -> new FoodItem(itemProp().food(Foods.DONAUWELLE)));
	public static final KiwiGO<Item> HONEY_POMELO_TEA = go(() -> new FoodItem(itemProp().food(Foods.HONEY_POMELO_TEA).craftRemainder(Items.GLASS_BOTTLE)));
	public static final KiwiGO<Item> RICE_WITH_FRUITS = go(() -> new FoodItem(itemProp().food(Foods.RICE_WITH_FRUITS)));
	public static final KiwiGO<Item> LEMON_ROAST_CHICKEN = go(() -> new FoodItem(itemProp().food(Foods.LEMON_ROAST_CHICKEN).craftRemainder(Items.BOWL)));

}
