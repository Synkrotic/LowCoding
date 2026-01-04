package dev.synkrotic.lowcoding.types;

public interface LowBoolean extends LowDataType {
    default LowType getType() {
        return LowType.BOOLEAN;
    }
}
