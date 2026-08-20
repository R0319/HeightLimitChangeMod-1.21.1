package net.ryoma.heightlimitchangemod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NetherHeightConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static NetherHeightConfig instance;

    public int netherHeight = 384;

    public static NetherHeightConfig getInstance() {
        return instance;
    }

    public static void load() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve("heightlimitchangemod.json");
        if (Files.exists(configPath)) {
            try {
                String json = Files.readString(configPath);
                instance = GSON.fromJson(json, NetherHeightConfig.class);
            } catch (IOException e) {
                HeightLimitChangeMod.LOGGER.error("Failed to load config", e);
                instance = new NetherHeightConfig();
            }
        } else {
            instance = new NetherHeightConfig();
            try {
                Files.writeString(configPath, GSON.toJson(instance));
            } catch (IOException e) {
                HeightLimitChangeMod.LOGGER.error("Failed to save default config", e);
            }
        }
    }
}
