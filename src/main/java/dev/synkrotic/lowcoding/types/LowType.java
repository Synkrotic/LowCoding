package dev.synkrotic.lowcoding.types;

public enum LowType {
    NUMBER(LowNumber.class),
    BOOLEAN(LowBoolean.class);

    private final Class<? extends LowDataType> type;

    LowType(Class<? extends LowDataType> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }
}
