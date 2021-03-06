package blusunrize.immersiveengineering.common.util.compat.jei.metalpress;

import blusunrize.immersiveengineering.api.crafting.MetalPressRecipe;
import blusunrize.immersiveengineering.common.IEContent;
import blusunrize.immersiveengineering.common.blocks.metal.BlockTypes_MetalMultiblock;
import blusunrize.immersiveengineering.common.util.compat.jei.IERecipeCategory;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class MetalPressRecipeCategory extends IERecipeCategory<MetalPressRecipe, MetalPressRecipeWrapper>
{
	private final IDrawable slotDrawable;
	static ItemStack metalPressStack;
	public MetalPressRecipeCategory(IGuiHelper helper)
	{
		super("metalPress","tile.immersiveengineering.metalMultiblock.metal_press.name", helper.createBlankDrawable(140,50), MetalPressRecipe.class, new ItemStack(IEContent.blockMetalMultiblock,1,BlockTypes_MetalMultiblock.METAL_PRESS.getMeta()));
		slotDrawable = helper.getSlotDrawable();
		metalPressStack = new ItemStack(IEContent.blockMetalMultiblock,1, BlockTypes_MetalMultiblock.METAL_PRESS.getMeta());
	}

	@Override
	public void drawExtras(Minecraft minecraft)
	{
		slotDrawable.draw(minecraft, 20, 3);
		slotDrawable.draw(minecraft, 102, 3);
	}

	@Override
	@Deprecated
	public void setRecipe(IRecipeLayout recipeLayout, MetalPressRecipeWrapper recipeWrapper)
	{
		//Deprecated
	}
	@Override
	public void setRecipe(IRecipeLayout recipeLayout, MetalPressRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		guiItemStacks.init(0, true, 20, 3);
		guiItemStacks.init(1, true, 71, 0);
		guiItemStacks.init(2, false, 102, 3);
		guiItemStacks.set(0, recipeWrapper.recipeInputs[0]);
		guiItemStacks.set(1, recipeWrapper.recipeInputs[1]);
		guiItemStacks.set(2, ingredients.getOutputs(ItemStack.class));
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(MetalPressRecipe recipe)
	{
		return new MetalPressRecipeWrapper(recipe);
	}
}