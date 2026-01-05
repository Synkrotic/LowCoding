package dev.synkrotic.lowcoding.types;

public interface LowText extends LowDataType {
    @Override
    default LowType getType() {
        return LowType.TEXT;
    }
}
