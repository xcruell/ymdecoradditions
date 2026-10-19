package com.yesmenn.natureadditions.block;

import com.yesmenn.natureadditions.block.entity.LargeCampfireBlockEntity;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.checkerframework.common.value.qual.IntVal;

public class LargeCampfireBlock extends BaseEntityBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public LargeCampfireBlock(BlockBehaviour.Properties properties) {
        super(properties
                .strength(2.0F)
                .lightLevel(state -> state.getValue(LIT) ? 15 : 0)
        );

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(LIT, false)
        );
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(LIT);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(LargeCampfireBlock::new);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LargeCampfireBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> type
    ) {
        return null;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {

        if (level.isClientSide()) {
            if (state.getValue(LIT)) {
                int Rando = random.nextInt(8);

                if (Rando == 0) {
                    level.playLocalSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.CAMPFIRE_CRACKLE, SoundSource.BLOCKS, 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
                }
                if (Rando == 4) {
                    level.playLocalSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
                }

                if (random.nextInt(5) == 0) {
                    for(int i = 0; i < random.nextInt(1) + 1; ++i) {
                        level.addParticle(ParticleTypes.LAVA, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, (double)(random.nextFloat() / 2.0F), 5.0E-5, (double)(random.nextFloat() / 2.0F));
                    }
                }
                apuVonDenSimpsons((Level)level, pos, true);
            }
        }
    }

    public static void apuVonDenSimpsons(Level level, BlockPos pos, boolean spawnExtraSmoke) {
        RandomSource randomsource = level.getRandom();
        SimpleParticleType simpleparticletype = ParticleTypes.CAMPFIRE_SIGNAL_SMOKE; //isSignalFire ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE :
        level.addAlwaysVisibleParticle(simpleparticletype, true, (double)pos.getX() + 0.5 + randomsource.nextDouble() / 3.0 * (double)(randomsource.nextBoolean() ? 1 : -1), (double)pos.getY() + 1.5 + randomsource.nextDouble() + randomsource.nextDouble(), (double)pos.getZ() + 0.5 + randomsource.nextDouble() / 3.0 * (double)(randomsource.nextBoolean() ? 1 : -1), 0.0, 0.07, 0.0);
        if (spawnExtraSmoke) {
            level.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + 0.5 + randomsource.nextDouble() / 4.0 * (double)(randomsource.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4, (double)pos.getZ() + 0.5 + randomsource.nextDouble() / 4.0 * (double)(randomsource.nextBoolean() ? 1 : -1), 0.0, 0.005, 0.0);
        }

    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        // Flint & Steel auf ein noch nicht brennendes Campfire
        if (stack.is(Items.FLINT_AND_STEEL) && !state.getValue(LIT)) {

            if (!level.isClientSide) {
                // Campfire anzünden
                level.setBlock(
                        pos,
                        state.setValue(LIT, true),
                        3
                );

                // Flint-and-Steel-Sound
                level.playSound(
                        null,
                        pos,
                        SoundEvents.FLINTANDSTEEL_USE,
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F
                );

                // Flint & Steel beschädigen
                stack.hurtAndBreak(
                        1,
                        player,
                        LivingEntity.getSlotForHand(hand)
                );
            }

            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}