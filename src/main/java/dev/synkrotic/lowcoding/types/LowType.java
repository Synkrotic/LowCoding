package dev.synkrotic.lowcoding.types;

public enum LowType {
    NUMBER(LowNumber.class),
    TEXT(LowText.class),
    BOOLEAN(LowBoolean.class),
    FILE(LowFile.class);

    private final Class<? extends LowDataType> type;

    LowType(Class<? extends LowDataType> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }
}
