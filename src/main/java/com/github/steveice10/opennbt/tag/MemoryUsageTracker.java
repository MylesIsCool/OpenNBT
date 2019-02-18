package com.github.steveice10.opennbt.tag;

public class MemoryUsageTracker {
    private final long maxUsage;
    private long usage;
    public static final int MOJANG_DEFAULT_NETWORK_LIMIT = 2097152;
    public static final MemoryUsageTracker UNLIMITED = new MemoryUsageTracker(-1);

    public MemoryUsageTracker(long maxUsage) {
        this.maxUsage = maxUsage;
    }

    public void addAndCheck(long value) {
        if (maxUsage == -1) return;
        usage += value;
        if (usage > maxUsage) {
            throw new IllegalStateException("Memory usage is higher than " + maxUsage + " (" + usage + ")");
        }
    }
}
