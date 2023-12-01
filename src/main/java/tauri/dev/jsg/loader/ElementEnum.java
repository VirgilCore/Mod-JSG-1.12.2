package tauri.dev.jsg.loader;

import net.minecraft.util.ResourceLocation;
import tauri.dev.jsg.JSG;
import tauri.dev.jsg.loader.model.ModelLoader;
import tauri.dev.jsg.loader.texture.TextureLoader;
import tauri.dev.jsg.renderer.biomes.BiomeOverlayEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ElementEnum {

    KAWOOSH("kawoosh.obj", "kawoosh.png", false), // kawoosh.png does not exist, but different texture is binding instead of it! - MineDragonCZ_

    // --------------------------------------------------------------------------------------------
    // Milky Way

    MILKYWAY_DHD("milkyway/DHD.obj", "milkyway/dhd.jpg", true),
    MILKYWAY_GATE("milkyway/gate.obj", "milkyway/gatering7.jpg", true),
    MILKYWAY_RING("milkyway/ring.obj", "milkyway/gatering7.jpg", true),

    MILKYWAY_CHEVRON_LIGHT("milkyway/chevronLight.obj", "milkyway/chevron.png", true),
    MILKYWAY_CHEVRON_FRAME("milkyway/chevronFrame.obj", "milkyway/gatering7.jpg", true),
    MILKYWAY_CHEVRON_MOVING("milkyway/chevronMoving.obj", "milkyway/chevron.png", true),
    MILKYWAY_CHEVRON_BACK("milkyway/chevronBack.obj", "milkyway/gatering7.jpg", true),

    ORLIN_GATE("orlin/gate_orlin.obj", "orlin/gate_orlin.jpg", true),

    // --------------------------------------------------------------------------------------------
    // Universe

    UNIVERSE_GATE("universe/universe_gate.obj", "universe/universe_gate.jpg", true),
    UNIVERSE_CHEVRON("universe/universe_chevron.obj", "universe/universe_chevron.png", true),
    UNIVERSE_SYMBOL("universe/universe_chevron.obj", "universe/universe_chevron_light.png", true),
    UNIVERSE_DIALER("universe/universe_dialer.obj", "universe/universe_dialer.jpg", true),
    UNIVERSE_DIALER_BROKEN("universe/universe_dialer.obj", "universe/universe_dialer_broken.jpg", true),

    // --------------------------------------------------------------------------------------------
    // Pegasus

    PEGASUS_DHD("pegasus/DHD.obj", "pegasus/dhd.jpg", true),
    PEGASUS_GATE("pegasus/gate.obj", "pegasus/gatering7.jpg", true),
    PEGASUS_RING("pegasus/ring_atlantis.obj", "pegasus/gatering7.jpg", true),

    PEGASUS_CHEVRON_LIGHT("pegasus/chevronLight.obj", "pegasus/chevron.png", true),
    PEGASUS_CHEVRON_FRAME("pegasus/chevronFrame.obj", "pegasus/gatering7.jpg", true),
    PEGASUS_CHEVRON_MOVING("pegasus/chevronMoving.obj", "pegasus/chevron.png", true),
    PEGASUS_CHEVRON_BACK("pegasus/chevronBack.obj", "pegasus/gatering7.jpg", true),


    // --------------------------------------------------------------------------------------------
    // Transport rings

    RING_GOAULD("transportrings/rings_goauld.obj", "transportrings/rings_goauld.jpg", false),
    RING_ORI("transportrings/rings_ori.obj", "transportrings/rings_ori.jpg", false),
    RING_ANCIENT("transportrings/rings_ancient.obj", "transportrings/rings_ancient.jpg", false),

    RINGS_CONTROLLER_GOAULD("transportrings/controller/goauld/plate_goauld.obj", "transportrings/controller/goauld/goauld_panel.jpg", true),
    RINGS_CONTROLLER_GOAULD_LIGHT("transportrings/controller/goauld/indicator_lights.obj", "transportrings/controller/goauld/goauld_light.jpg", true),

    // --------------------------------------------------------------------------------------------
    // Irises/Shields

    SHIELD("iris/shield.obj", "iris/shield.jpg", true),
    IRIS("iris/iris_blade.obj", "iris/iris_blade.jpg", true),

    GDO("iris/gdo.obj", "iris/gdo.png", false),

    // --------------------------------------------------------------------------------------------
    // Tools

    ZAT("tools/zat.obj", "tools/zat.png", false),
    STAFF("tools/staff.obj", "tools/staff.png", false),

    // --------------------------------------------------------------------------------------------
    // Platforms

    PLATFORM_SHIPS_MOVING("platforms/rings/ships/ships_moving.obj", "platforms/rings/ships/ships_moving.jpg", true),
    PLATFORM_SHIPS_OVERLAY("platforms/rings/ships/ships_overlay.obj", "platforms/rings/ships/ships_overlay.jpg", true),
    PLATFORM_SHIPS_BASE("platforms/rings/ships/ships_base.obj", "platforms/rings/ships/ships_base.jpg", true),

    // --------------------------------------------------------------------------------------------
    // Machines

    molecular_constructor("machine/assembler/mcd.obj", "machine/assembler/mcd_base.png", false),

    // Lab
    LAB_MACHINE("machine/lab/machine.obj", "machine/lab/machine.jpg", false),
    LAB_TUBES("machine/lab/tubes.obj", "machine/lab/tubes.png", false),
    LAB_INTERFACE("", "machine/lab/interface.jpg", false),

    // --------------------------------------------------------------------------------------------
    // ZPM

    ZPM("zpm/zpm.obj", "zpm/zpm0.png", false),
    ZPM_HUB("zpm/pg_zpm_hub.obj", "zpm/hub/pg_zpm_hub.jpg", false),
    ZPM_HUB_LIGHTS("zpm/pg_lights.obj", "zpm/hub/pg_lights0.jpg", false),
    ZPM_SLOT("zpm/slot.obj", "zpm/slot.png", false),
    //ZPM_ASURAN_SLOT("zpm/asuran_zpm_slot.obj", "zpm/asuran_zpm_slot_texture.png", false), => light overlay: asuran_zpm_light.png
    //this model is same size as ZPM hub, but different position

    // --------------------------------------------------------------------------------------------
    // DESTINY PROPS

    DESTINY_COUNTDOWN("props/destiny/countdown.obj", "props/destiny/countdown.png", false),
    DESTINY_BEARING_OFF("props/destiny/bearing_light.obj", "props/destiny/bearing_light_off.png", false),
    DESTINY_BEARING_ON("props/destiny/bearing_light.obj", "props/destiny/bearing_light_on.png", false),
    DESTINY_BEARING_BODY("props/destiny/bearing_body.obj", "props/destiny/bearing_body.png", false),

    DESTINY_CHEVRON("props/destiny/floor_chevron.obj", "universe/universe_chevron.png", false),
    DESTINY_VENT_MOVING("props/destiny/vent_moving.obj", "props/destiny/vent_moving.png", false),
    DESTINY_VENT_HOLE("props/destiny/vent_hole.obj", "props/destiny/vent_hole.png", false),

    // --------------------------------------------------------------------------------------------
    // DECOR PROPS

    DECOR_ABYDOS_POT("props/decor/abydos_pot.obj", "props/decor/abydos_pot.png", false),
    DECOR_DRONE_WEAPON_OFF("props/decor/drone_weapon.obj", "props/decor/drone_weapon_off.png", false),
    DECOR_DRONE_WEAPON_ON("props/decor/drone_weapon.obj", "props/decor/drone_weapon_on.png", false),
    DECOR_ANCIENT_OBELISK("props/decor/ancient_obelisk.obj", "props/decor/ancient_obelisk.png", false),


    // --------------------------------------------------------------------------------------------
    // DECOR PROPS - BRAZIERS

    DECOR_ABYDOS_LAMP("props/decor/braziers/brazier_type_1.obj", "props/decor/braziers/abydos_brazier.png", false);
    // Message for Minedragon :D => model: brazier_type_1.obj , textures: abydos_brazier.png; hatak_brazier.png
    //                              model: brazier_type_2.obj , textures: goauld_brazier.png; anubis_brazier.png

    // --------------------------------------------------------------------------------------------

    public final ResourceLocation modelResource;
    public final Map<BiomeOverlayEnum, ResourceLocation> biomeTextureResourceMap = new HashMap<>();

    ElementEnum(String model, String texture, boolean hasOverlays) {
        this.modelResource = ModelLoader.getModelResource(model);

        for (BiomeOverlayEnum biomeOverlay : BiomeOverlayEnum.values())
            if (!hasOverlays) {
                biomeTextureResourceMap.put(biomeOverlay, TextureLoader.getTextureResource(texture));
            } else {
                String[] split = texture.split("\\.");
                biomeTextureResourceMap.put(biomeOverlay, TextureLoader.getTextureResource(split[0] + biomeOverlay.suffix + "." + split[1]));
            }
    }

    public static void renderModel(String path){
        ModelLoader.getModel(ModelLoader.getModelResource(path)).render();
    }

    public void render() {
        ModelLoader.getModel(modelResource).render();
    }

    private final List<BiomeOverlayEnum> nonExistingReported = new ArrayList<>();

    public void bindTexture(BiomeOverlayEnum biomeOverlay) {
        ResourceLocation resourceLocation = biomeTextureResourceMap.get(biomeOverlay);
        bindTexture(biomeOverlay, resourceLocation);
    }

    public void bindTexture(BiomeOverlayEnum biomeOverlay, ResourceLocation resourceLocation) {
        if (TextureLoader.isNotTextureLoaded(resourceLocation)) {
            // Probably doesn't exist

            if (!nonExistingReported.contains(biomeOverlay)) {
                JSG.error(this + " tried to use BiomeOverlay " + biomeOverlay + " but it doesn't exist. (" + resourceLocation + ")");
                nonExistingReported.add(biomeOverlay);
            }

            resourceLocation = biomeTextureResourceMap.get(BiomeOverlayEnum.NORMAL);
        }

        TextureLoader.getTexture(resourceLocation).bindTexture();
    }

    public void bindTextureAndRender(BiomeOverlayEnum biomeOverlay) {
        bindTexture(biomeOverlay);
        render();
    }

    public void bindTextureAndRender() {
        bindTextureAndRender(BiomeOverlayEnum.NORMAL);
    }
}
