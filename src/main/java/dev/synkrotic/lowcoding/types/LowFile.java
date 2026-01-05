package dev.synkrotic.lowcoding.types;

public interface LowFile extends LowDataType {
    @Override
    default LowType getType() {
        return LowType.FILE;
    }
}
