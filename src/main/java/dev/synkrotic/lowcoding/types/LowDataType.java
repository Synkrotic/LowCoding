package dev.synkrotic.lowcoding.types;

public interface LowDataType {
    Object getValue();
    LowType getType();

    default boolean isEqualTo(LowDataType other) {
        if (other == this) return true;

        if (other.getType().equals(this.getType())) {
            return this.getValue().equals(other.getValue());
        }

        return false;
    }
}