package net.oscar.OscarFirstMod.block;


import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.OscarFirstMod;
import net.oscar.OscarFirstMod.item.moditems;

import java.util.function.Supplier;

public class modblock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OscarFirstMod.MOD_ID);

    public static final RegistryObject<Block> FIRESHARD_BLOCK = registerBlock("fireshard_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> LAVASHARD_STONE_MINERAL_BLOCK = registerBlock("lavashard_stone_mineral_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> LAVASHARD_DEEPSLATE_MINERAL_BLOCK = registerBlock("lavashard_deepslate_mineral_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> LAVASHARD_NETHERRACK_MINERAL_BLOCK = registerBlock("lavashard_netherrack_mineral_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> BURNEDPLANKS = registerBlock("burnedplanks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> BURNEDPLANKS_STAIRS = registerBlock("burnedplanks_stairs",
            () -> new StairBlock(() -> modblock.BURNEDPLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> BURNEDPLANKS_SLAB = registerBlock("burnedplanks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));

    public static final RegistryObject<Block> BURNEDPLANKS_BUTTON = registerBlock("burnedplanks_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_BUTTON),
                    BlockSetType.DARK_OAK, 20, true));
    public static final RegistryObject<Block> BURNEDPLANKS_PRESSURE_PLATE = registerBlock("burnedplanks_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS),
                    BlockSetType.DARK_OAK));

    public static final RegistryObject<Block> BURNEDPLANKS_FENCE = registerBlock("burnedplanks_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> BURNEDPLANKS_FENCE_GATE = registerBlock("burnedplanks_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> BURNEDPLANKS_WALL = registerBlock("burnedplanks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));

    public static final RegistryObject<Block> BURNEDPLANKS_DOOR = registerBlock("burnedplanks_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion(), BlockSetType.DARK_OAK));
    public static final RegistryObject<Block> BURNEDPLANKS_TRAPDOOR = registerBlock("burnedplanks_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS).noOcclusion(), BlockSetType.DARK_OAK));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
