package net.oscar.OscarFirstMod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.oscar.OscarFirstMod.OscarFirstMod;
import net.oscar.OscarFirstMod.block.modblock;
import net.oscar.OscarFirstMod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OscarFirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(modblock.LAVASHARD_STONE_MINERAL_BLOCK.get(),
        modblock.LAVASHARD_DEEPSLATE_MINERAL_BLOCK.get(),
        modblock.LAVASHARD_NETHERRACK_MINERAL_BLOCK.get(),
        modblock.FIRESHARD_BLOCK.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(modblock.LAVASHARD_STONE_MINERAL_BLOCK.get(),
                        modblock.LAVASHARD_DEEPSLATE_MINERAL_BLOCK.get(),
                        modblock.LAVASHARD_NETHERRACK_MINERAL_BLOCK.get(),
                        modblock.FIRESHARD_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(modblock.BURNEDPLANKS.get(),
        modblock.BURNEDPLANKS_DOOR.get(),
        modblock.BURNEDPLANKS_TRAPDOOR.get(),
        modblock.BURNEDPLANKS_STAIRS.get(),
        modblock.BURNEDPLANKS_SLAB.get(),
        modblock.BURNEDPLANKS_BUTTON.get(),
        modblock.BURNEDPLANKS_PRESSURE_PLATE.get(),
        modblock.BURNEDPLANKS_FENCE.get(),
        modblock.BURNEDPLANKS_FENCE_GATE.get(),
        modblock.BURNEDPLANKS_WALL.get());

        this.tag(BlockTags.FENCES)
                .add(modblock.BURNEDPLANKS_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(modblock.BURNEDPLANKS_FENCE_GATE.get());
        this.tag(BlockTags.DOORS)
                .add(modblock.BURNEDPLANKS_DOOR.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(modblock.BURNEDPLANKS_TRAPDOOR.get());
        this.tag(BlockTags.STAIRS)
                .add(modblock.BURNEDPLANKS_STAIRS.get());
        this.tag(BlockTags.SLABS)
                .add(modblock.BURNEDPLANKS_SLAB.get());
        this.tag(BlockTags.BUTTONS)
                .add(modblock.BURNEDPLANKS_BUTTON.get());
        this.tag(BlockTags.PRESSURE_PLATES)
                .add(modblock.BURNEDPLANKS_PRESSURE_PLATE.get());
        this.tag(BlockTags.WALLS)
                .add(modblock.BURNEDPLANKS_WALL.get());
    }
}
