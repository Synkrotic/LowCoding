package dev.synkrotic.lowcoding.types;

public interface LowNumber extends LowDataType {
    @Override
    default LowType getType() {
        return LowType.NUMBER;
    }
}
