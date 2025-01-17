package net.oscar.OscarFirstMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.OscarFirstMod;
import net.oscar.OscarFirstMod.block.modblock;
import net.oscar.OscarFirstMod.item.moditems;

public class ModItemProvider extends ItemModelProvider {

    public ModItemProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OscarFirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(moditems.LAVASHARD);
        simpleItem(moditems.CHARGED_LAVA_SHARD);
        simpleItem(moditems.LAVAFINDER);
        simpleItem(moditems.PEPPER);
        simpleItem(moditems.CHARGEDPEPPER);

        simpleBlockItem(modblock.BURNEDPLANKS_DOOR);

        fenceItem(modblock.BURNEDPLANKS_FENCE, modblock.BURNEDPLANKS);
        buttonItem(modblock.BURNEDPLANKS_BUTTON, modblock.BURNEDPLANKS);
        wallItem(modblock.BURNEDPLANKS_WALL, modblock.BURNEDPLANKS);
        trapdoorItem(modblock.BURNEDPLANKS_TRAPDOOR);
        evenSimplerBlockItem(modblock.BURNEDPLANKS_STAIRS);
        evenSimplerBlockItem(modblock.BURNEDPLANKS_SLAB);
        evenSimplerBlockItem(modblock.BURNEDPLANKS_PRESSURE_PLATE);
        evenSimplerBlockItem(modblock.BURNEDPLANKS_FENCE_GATE);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(OscarFirstMod.MOD_ID, "item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(OscarFirstMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(OscarFirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(OscarFirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("texture", new ResourceLocation(OscarFirstMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(OscarFirstMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
