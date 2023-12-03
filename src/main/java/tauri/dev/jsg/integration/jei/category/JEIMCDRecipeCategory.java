package tauri.dev.jsg.integration.jei.category;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import tauri.dev.jsg.JSG;
import tauri.dev.jsg.block.JSGBlocks;
import tauri.dev.jsg.integration.jei.AbstractJEIRecipe;

import javax.annotation.Nonnull;

public class JEIMCDRecipeCategory implements IRecipeCategory<AbstractJEIRecipe> {

    public static final String UID = "jsg_mcd";
    public static final ResourceLocation BACK_TEXTURE = new ResourceLocation(JSG.MOD_ID, "textures/gui/container_mcd_jei.png");

    public final IDrawable background;
    public final IDrawable icon;
    public final IDrawable progressBar;

    public JEIMCDRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(BACK_TEXTURE, 0, 0, 157, 53);
        this.icon = helper.createDrawableIngredient(new ItemStack(JSGBlocks.MACHINE_MCD));
        this.progressBar = helper.createAnimatedDrawable(helper.createDrawable(BACK_TEXTURE, 176, 128, 216 - 176, 142 - 128), 40, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Nonnull
    @Override
    public String getUid() {
        return UID;
    }

    @Nonnull
    @Override
    public String getTitle() {
        return I18n.format("gui.mcd.name");
    }

    @Nonnull
    @Override
    public String getModName() {
        return JSG.MOD_NAME;
    }

    @Nonnull
    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(@Nonnull Minecraft minecraft){
        progressBar.draw(minecraft, 86, 19);
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull AbstractJEIRecipe mcdRecipe, @Nonnull IIngredients ingredients) {
        // input slots
        recipeLayout.getItemStacks().init(0, true, 0, 18);
        int i = 0;
        for (int y1 = 0; y1 < 3; y1++) {
            for (int x1 = 0; x1 < 3; x1++) {
                recipeLayout.getItemStacks().init(1 + i, true, 24 + (18 * x1), (18 * y1));
                i++;
            }
        }
        recipeLayout.getItemStacks().init(++i, true, 92, 18);

        // output slot
        recipeLayout.getItemStacks().init(++i, false, 136, 18);
        recipeLayout.getItemStacks().set(ingredients);
    }
}
