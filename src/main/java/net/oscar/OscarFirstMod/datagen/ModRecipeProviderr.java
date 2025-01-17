package net.oscar.OscarFirstMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.oscar.OscarFirstMod.block.modblock;
import net.oscar.OscarFirstMod.item.moditems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProviderr extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> LAVABURNER = List.of(moditems.LAVASHARD.get());

    public ModRecipeProviderr(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, LAVABURNER, RecipeCategory.MISC, moditems.CHARGED_LAVA_SHARD.get(), 0.5f, 100, "lava");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, modblock.FIRESHARD_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', moditems.LAVASHARD.get())
                .unlockedBy(getHasName(moditems.LAVASHARD.get()), has(moditems.LAVASHARD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, modblock.BURNEDPLANKS.get())
                .pattern("   ")
                .pattern(" #O")
                .pattern("   ")
                .define('#', moditems.CHARGED_LAVA_SHARD.get())
                .define('O', Blocks.OAK_PLANKS)
                .unlockedBy(getHasName(moditems.CHARGED_LAVA_SHARD.get()), has(moditems.CHARGED_LAVA_SHARD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, moditems.CHARGEDPEPPER.get())
                .pattern("   ")
                .pattern(" #O")
                .pattern("   ")
                .define('#', moditems.CHARGED_LAVA_SHARD.get())
                .define('O', moditems.PEPPER.get())
                .unlockedBy(getHasName(moditems.CHARGED_LAVA_SHARD.get()), has(moditems.CHARGED_LAVA_SHARD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, moditems.LAVAFINDER.get())
                .pattern(" OX")
                .pattern(" #O")
                .pattern("#  ")
                .define('#', Items.STICK)
                .define('O', moditems.CHARGED_LAVA_SHARD.get())
                .define('X', Items.REDSTONE)
                .unlockedBy(getHasName(moditems.CHARGED_LAVA_SHARD.get()), has(moditems.CHARGED_LAVA_SHARD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, moditems.LAVALAUNCHER.get())
                .pattern("  X")
                .pattern(" # ")
                .pattern("#  ")
                .define('#', Items.BLAZE_ROD)
                .define('X', moditems.CHARGED_LAVA_SHARD.get())
                .unlockedBy(getHasName(moditems.CHARGED_LAVA_SHARD.get()), has(moditems.CHARGED_LAVA_SHARD.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, moditems.SUPREME_LAVALAUNCHER.get())
                .pattern("   ")
                .pattern("O#X")
                .pattern("   ")
                .define('#', moditems.LAVALAUNCHER.get())
                .define('X', Items.LAVA_BUCKET)
                .define('O', moditems.CHARGED_LAVA_SHARD.get())
                .unlockedBy(getHasName(moditems.CHARGED_LAVA_SHARD.get()), has(moditems.CHARGED_LAVA_SHARD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, moditems.LAVASHARD.get(), 9)
                .requires(modblock.FIRESHARD_BLOCK.get())
                .unlockedBy(getHasName(modblock.FIRESHARD_BLOCK.get()), has(modblock.FIRESHARD_BLOCK.get()))
                .save(pWriter);
    }
}
