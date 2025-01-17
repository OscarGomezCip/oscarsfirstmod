package net.oscar.OscarFirstMod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.block.modblock;
import net.oscar.OscarFirstMod.item.moditems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider{
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(modblock.FIRESHARD_BLOCK.get());
        this.dropSelf(modblock.BURNEDPLANKS.get());

        this.add(modblock.LAVASHARD_STONE_MINERAL_BLOCK.get(),
                block -> createOreDrop(modblock.LAVASHARD_STONE_MINERAL_BLOCK.get(), moditems.LAVASHARD.get()));
        this.add(modblock.LAVASHARD_DEEPSLATE_MINERAL_BLOCK.get(),
                block -> createOreDrop(modblock.LAVASHARD_DEEPSLATE_MINERAL_BLOCK.get(), moditems.LAVASHARD.get()));
        this.add(modblock.LAVASHARD_NETHERRACK_MINERAL_BLOCK.get(),
                block -> createOreDrop(modblock.LAVASHARD_NETHERRACK_MINERAL_BLOCK.get(), moditems.LAVASHARD.get()));

        this.dropSelf(modblock.BURNEDPLANKS_STAIRS.get());
        this.dropSelf(modblock.BURNEDPLANKS_WALL.get());
        this.dropSelf(modblock.BURNEDPLANKS_FENCE_GATE.get());
        this.dropSelf(modblock.BURNEDPLANKS_FENCE.get());
        this.dropSelf(modblock.BURNEDPLANKS_TRAPDOOR.get());
        this.dropSelf(modblock.BURNEDPLANKS_BUTTON.get());
        this.dropSelf(modblock.BURNEDPLANKS_PRESSURE_PLATE.get());
        this.add(modblock.BURNEDPLANKS_SLAB.get(),
        block -> createSlabItemTable(modblock.BURNEDPLANKS_SLAB.get()));
        this.add(modblock.BURNEDPLANKS_DOOR.get(),
        block -> createDoorTable(modblock.BURNEDPLANKS_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return modblock.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

