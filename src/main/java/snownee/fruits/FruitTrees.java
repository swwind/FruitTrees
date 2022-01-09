package snownee.fruits;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import net.fabricmc.api.ModInitializer;

// @Mod(FruitTrees.MODID)
public class FruitTrees implements ModInitializer {
	public static final String MODID = "fruittrees";
	public static final String NAME = "Fruit Trees";
	//	public static boolean CLOTH_CONFIG;

	public static Logger LOGGER = LogManager.getLogger(FruitTrees.NAME);
	static final Marker MARKER = MarkerManager.getMarker("Init");

	@Override
	public void onInitialize() {
		LOGGER.info("FruitTrees initialized.");
	}
}
