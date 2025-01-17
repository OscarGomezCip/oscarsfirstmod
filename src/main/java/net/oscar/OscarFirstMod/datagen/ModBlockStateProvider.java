package net.oscar.OscarFirstMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.OscarFirstMod;
import net.oscar.OscarFirstMod.block.modblock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OscarFirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(modblock.FIRESHARD_BLOCK);

        blockWithItem(modblock.LAVASHARD_STONE_MINERAL_BLOCK);
        blockWithItem(modblock.LAVASHARD_DEEPSLATE_MINERAL_BLOCK);
        blockWithItem(modblock.LAVASHARD_NETHERRACK_MINERAL_BLOCK);

        blockWithItem(modblock.BURNEDPLANKS);
        stairsBlock(((StairBlock) modblock.BURNEDPLANKS_STAIRS.get()), blockTexture(modblock.BURNEDPLANKS.get()));
        slabBlock(((SlabBlock) modblock.BURNEDPLANKS_SLAB.get()), blockTexture(modblock.BURNEDPLANKS.get()), blockTexture(modblock.BURNEDPLANKS.get()));

        buttonBlock(((ButtonBlock) modblock.BURNEDPLANKS_BUTTON.get()), blockTexture(modblock.BURNEDPLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) modblock.BURNEDPLANKS_PRESSURE_PLATE.get()), blockTexture(modblock.BURNEDPLANKS.get()));

        fenceBlock(((FenceBlock) modblock.BURNEDPLANKS_FENCE.get()), blockTexture(modblock.BURNEDPLANKS.get()));
        fenceGateBlock(((FenceGateBlock) modblock.BURNEDPLANKS_FENCE_GATE.get()), blockTexture(modblock.BURNEDPLANKS.get()));
        wallBlock(((WallBlock) modblock.BURNEDPLANKS_WALL.get()), blockTexture(modblock.BURNEDPLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) modblock.BURNEDPLANKS_DOOR.get()), modLoc("block/burnedplanks_door_bottom"), modLoc("block/burnedplanks_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) modblock.BURNEDPLANKS_TRAPDOOR.get()), modLoc("block/burnedplanks_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
