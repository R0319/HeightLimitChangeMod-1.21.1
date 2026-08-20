package net.ryoma.heightlimitchangemod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeightLimitChangeMod implements ModInitializer {
	public static final String MOD_ID = "heightlimitchangemod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		NetherHeightConfig.load();
		LOGGER.info("Nether height set to: " + NetherHeightConfig.getInstance().netherHeight);
	}
}