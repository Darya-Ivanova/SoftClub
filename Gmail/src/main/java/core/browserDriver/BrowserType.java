package core.browserDriver;

public enum BrowserType {

    FireFox,
    Chrome,
    Edge;

    public static BrowserType getBrowserType(final String value) {
        if(value == null || value.trim().isEmpty()) {
            throw new UnsupportedOperationException("Value required");
        }
        for(BrowserType browserType: BrowserType.values()) {
            if(value.equalsIgnoreCase(browserType.name())) {
                return browserType;
            }
        }
        throw new IllegalArgumentException("Value did not match existing value");
    }
}
