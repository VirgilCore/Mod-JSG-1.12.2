package tauri.dev.jsg.machine.pcbfabricator;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tauri.dev.jsg.config.craftings.CraftingConfig;
import tauri.dev.jsg.fluid.JSGFluids;
import tauri.dev.jsg.item.JSGItems;

import java.util.ArrayList;

import static tauri.dev.jsg.Constants.ONE_INGOT_IN_FLUID_MB;

public class CircuitFabricatorRecipes {

    public static CircuitFabricatorRecipe CIRCUIT_CONTROL_CRYSTAL = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 800;
        }

        @Override
        public int getEnergyPerTick() {
            return 512;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(null);
                add(null);

                add(new ItemStack(JSGItems.TRINIUM_DUST));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_BASE));
                add(new ItemStack(JSGItems.TRINIUM_DUST));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };
    public static CircuitFabricatorRecipe CIRCUIT_CONTROL_NAQUADAH = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.MOLTEN_NAQUADAH_ALLOY, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 800;
        }

        @Override
        public int getEnergyPerTick() {
            return 512;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(null);
                add(null);

                add(new ItemStack(JSGItems.TITANIUM_DUST));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_BASE));
                add(new ItemStack(JSGItems.TITANIUM_DUST));

                add(new ItemStack(JSGItems.PLATE_NAQUADAH));
                add(new ItemStack(JSGItems.PLATE_NAQUADAH));
                add(new ItemStack(JSGItems.PLATE_NAQUADAH));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CIRCUIT_CONTROL_NAQUADAH);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{0.4f, 0.4f, 0.6f};
        }
    };

    public static CircuitFabricatorRecipe SG_CRYSTAL_GLYPH = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(new ItemStack(JSGItems.CRYSTAL_YELLOW));
                add(new ItemStack(JSGItems.CRYSTAL_RED));
                add(new ItemStack(JSGItems.CRYSTAL_TEAL);

                add(new ItemStack(JSGItems.TITANIUM_DUST));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.TITANIUM_DUST));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_STARGATE);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };
    public static CircuitFabricatorRecipe SG_CRYSTAL_MILKYWAY = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(new ItemStack(JSGItems.CRYSTAL_RED));
                add(null);

                add(new ItemStack(JSGItems.CRYSTAL_RED));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.CRYSTAL_RED));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_MILKYWAY);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };
    public static CircuitFabricatorRecipe SG_crystal_aqua = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(new ItemStack(JSGItems.CRYSTAL_AQUA));
                add(null);

                add(new ItemStack(JSGItems.CRYSTAL_BLUE));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.CRYSTAL_BLUE));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_PEGASUS);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };
    public static CircuitFabricatorRecipe SG_CRYSTAL_UNIVERSE = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(new ItemStack(JSGItems.CRYSTAL_WHITE));
                add(null);

                add(new ItemStack(JSGItems.CRYSTAL_WHITE));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.CRYSTAL_WHITE));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_UNIVERSE);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };

    public static CircuitFabricatorRecipe TR_CRYSTAL_GOAULD = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.NAQUADAH_MOLTEN_RAW, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(new ItemStack(JSGItems.CRYSTAL_YELLOW));
                add(new ItemStack(JSGItems.TITANIUM_DUST));
                add(new ItemStack(JSGItems.CRYSTAL_TEAL));

                add(new ItemStack(JSGItems.CRYSTAL_RED));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.CRYSTAL_BLUE));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_GOAULD);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{0.22f, 0.31f, 0.26f};
        }
    };
    public static CircuitFabricatorRecipe TR_CRYSTAL_ORI = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(new ItemStack(JSGItems.TRINIUM_DUST));
                add(null);

                add(new ItemStack(JSGItems.CRYSTAL_TOKRA));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.CRYSTAL_TOKRA));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_ORI);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };
    public static CircuitFabricatorRecipe TR_CRYSTAL_ANCIENT = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(new ItemStack(JSGItems.TRINIUM_DUST));
                add(new ItemStack(JSGItems.CRYSTAL_BLUE));
                add(new ItemStack(JSGItems.TRINIUM_DUST));

                add(new ItemStack(JSGItems.CRYSTAL_AQUA));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.CRYSTAL_AQUA));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_ANCIENT);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };

    public static CircuitFabricatorRecipe DHD_CRYSTAL_GLYPH = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(new ItemStack(JSGItems.CRYSTAL_AQUA));
                add(new ItemStack(JSGItems.CRYSTAL_TEAL));
                add(new ItemStack(JSGItems.CRYSTAL_RED));

                add(new ItemStack(JSGItems.NAQUADAH_DUST));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.NAQUADAH_DUST));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_GLYPH_DHD);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };
    public static CircuitFabricatorRecipe DHD_CRYSTAL_CONTROL_PEGASUS = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 500;
        }

        @Override
        public int getEnergyPerTick() {
            return 250;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(new ItemStack(JSGItems.NAQUADAH_DUST));
                add(new ItemStack(JSGItems.CRYSTAL_AQUA));
                add(new ItemStack(JSGItems.NAQUADAH_DUST));

                add(new ItemStack(JSGItems.CRYSTAL_RED));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_NAQUADAH));
                add(new ItemStack(JSGItems.CRYSTAL_TEAL));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_CONTROL_PEGASUS_DHD);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };

    public static CircuitFabricatorRecipe UPGRADE_CAPACITY = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(new ItemStack(JSGItems.NAQUADAH_RAW_DUST));
                add(null);

                add(new ItemStack(JSGItems.CRYSTAL_RED));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_NAQUADAH));
                add(new ItemStack(JSGItems.CRYSTAL_RED));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_UPGRADE_CAPACITY);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };
    public static CircuitFabricatorRecipe UPGRADE_EFFICIENCY = new CircuitFabricatorRecipe() {
        @Override
        public FluidStack getSubFluidStack() {
            return new FluidStack(JSGFluids.SILICON_MOLTEN_WHITE, ONE_INGOT_IN_FLUID_MB);
        }

        @Override
        public int getWorkingTime() {
            return 200;
        }

        @Override
        public int getEnergyPerTick() {
            return 232;
        }

        @Override
        public ArrayList<ItemStack> getPattern() {
            return new ArrayList<ItemStack>() {{
                add(null);
                add(new ItemStack(JSGItems.TRINIUM_DUST));
                add(null);

                add(new ItemStack(JSGItems.CRYSTAL_WHITE));
                add(new ItemStack(JSGItems.CIRCUIT_CONTROL_CRYSTAL));
                add(new ItemStack(JSGItems.CRYSTAL_WHITE));

                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
                add(new ItemStack(Items.QUARTZ));
            }};
        }

        @Override
        public ItemStack getResult() {
            return new ItemStack(JSGItems.CRYSTAL_UPGRADE_EFFICIENCY);
        }

        @Override
        public float[] getBeamColors() {
            return new float[]{1f, 1f, 1f};
        }
    };

    public static final CircuitFabricatorRecipe[] RECIPES = {
            CIRCUIT_CONTROL_CRYSTAL,
            CIRCUIT_CONTROL_NAQUADAH,

            SG_CRYSTAL_GLYPH,
            SG_CRYSTAL_MILKYWAY,
            SG_crystal_aqua,
            SG_CRYSTAL_UNIVERSE,

            TR_CRYSTAL_GOAULD,
            TR_CRYSTAL_ORI,
            TR_CRYSTAL_ANCIENT,

            DHD_CRYSTAL_GLYPH,
            DHD_CRYSTAL_CONTROL_PEGASUS,

            UPGRADE_CAPACITY,
            UPGRADE_EFFICIENCY
    };

    public static void addToConfig() {
        CraftingConfig config = new CraftingConfig(CircuitFabricatorRecipe.ID);
        for (CircuitFabricatorRecipe recipe : RECIPES) {
            config.addKey(recipe.getResult().getItem().getRegistryName());
        }
        CraftingConfig.addConfig(config);
    }
}
