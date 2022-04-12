package mrjake.aunis.renderer.transportrings;

import mrjake.aunis.loader.ElementEnum;
import mrjake.aunis.loader.model.ModelLoader;
import mrjake.aunis.tileentity.transportrings.TRControllerAbstractTile;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;


public class TRControllerGoauldRenderer extends TRControllerAbstractRenderer {
    @Override
    public void renderController(TRControllerAbstractTile te, TRControllerAbstractRendererState rendererState) {
        ElementEnum.RINGSCONTROLLER_GOAULD.bindTextureAndRender(te.getBiomeOverlay());
        int symbolId = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 2; x++) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(x * -0.25, y * -0.1, 0);
                ElementEnum button = ElementEnum.RINGSCONTROLLER_GOAULD_BUTTON;
                ResourceLocation texture = ((TRControllerGoauldRendererState) rendererState).getButtonTexture(symbolId, rendererState.getBiomeOverlay());
                if (rendererDispatcher != null && rendererDispatcher.renderEngine != null && texture != null) {
                    rendererDispatcher.renderEngine.bindTexture(texture);
                    ModelLoader.getModel(button.modelResource).render();
                }
                GlStateManager.popMatrix();
                //if(te.getWorld().getTotalWorldTime() % 40 == 0)
                    //Aunis.info(rendererState.isButtonActive(SymbolGoauldEnum.valueOf(symbolId)) + "");
                symbolId++;
            }
        }
    }
}
