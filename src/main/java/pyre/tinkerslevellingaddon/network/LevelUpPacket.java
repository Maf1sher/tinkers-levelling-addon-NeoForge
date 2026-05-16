package pyre.tinkerslevellingaddon.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import pyre.tinkerslevellingaddon.util.ModUtil;

public record LevelUpPacket(int level, Component toolName) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<LevelUpPacket> TYPE = new CustomPacketPayload.Type<>(ModUtil.getResource("level_up"));
    public static final StreamCodec<RegistryFriendlyByteBuf, LevelUpPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT, LevelUpPacket::level,
            ComponentSerialization.TRUSTED_STREAM_CODEC, LevelUpPacket::toolName,
            LevelUpPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(LevelUpPacket payload, IPayloadContext context) {
        context.enqueueWork(() -> ClientPacketHandler.handleLevelUpMessage(payload.level(), payload.toolName()));
    }
}
