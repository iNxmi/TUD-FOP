package org.tudalgo.algoutils.student.io;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.lang.String.format;

/**
 * A utility class for reading properties from files located in {@code src/main/resources/}.
 */
public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static final Map<String, Properties> PROPERTIES_MAP = new HashMap<>();

    /**
     * Returns the {@link Properties} for the file specified by {@code path} located in {@code src/main/resources/}.
     *
     * @param path the path to the property file
     * @return the properties
     */
    public static Properties getProperties(final String path) {
        return PROPERTIES_MAP.computeIfAbsent(path, fn -> {
            final var properties = new Properties();
            final var stream = PropertyUtils.class.getResourceAsStream("/" + fn);
            try {
                properties.load(stream);
            } catch (final IOException | IllegalArgumentException | NullPointerException e) {
                throw new RuntimeException(format("cannot load properties from file %s", path), e);
            }
            return properties;
        });
    }

    /**
     * Returns the value of property {@code key} in file specified by {@code path} located in {@code src/main/resources/}.
     *
     * @param path the name of the properties file
     * @param key  the name of the property
     * @return the value of the property
     */
    public static String getStringProperty(final String path, final String key) {
        return getProperties(path).getProperty(key);
    }

    /**
     * Returns the value of property {@code key} in file specified by {@code path} located in {@code src/main/resources/}.
     *
     * @param path the name of the properties file
     * @param key  the name of the property
     * @return the value of the property
     */
    public static boolean getBooleanProperty(final String path, final String key) {
        final var value = getStringProperty(path, key);
        try {
            return Boolean.parseBoolean(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException(format("cannot parse boolean from %s", value), e);
        }
    }

    /**
     * Returns the value of property {@code key} in file specified by {@code path} located in {@code src/main/resources/}.
     *
     * @param path the name of the properties file
     * @param key  the name of the property
     * @return the value of the property
     */
    public static char getCharProperty(final String path, final String key) {
        final var value = getStringProperty(path, key);
        if (value.length() > 1) {
            throw new RuntimeException(format("cannot parse char from %s", value));
        }
        return value.charAt(0);

    }

    /**
     * Returns the value of property {@code key} in file specified by {@code path} located in {@code src/main/resources/}.
     *
     * @param path the name of the properties file
     * @param key  the name of the property
     * @return the value of the property
     */
    public static double getDoubleProperty(final String path, final String key) {
        final var value = getStringProperty(path, key);
        try {
            return Double.parseDouble(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException(format("cannot parse double from %s", value), e);
        }
    }

    /**
     * Returns the value of property {@code key} in file specified by {@code path} located in {@code src/main/resources/}.
     *
     * @param path the name of the properties file
     * @param key  the name of the property
     * @return the value of the property
     */
    public static int getIntProperty(final String path, final String key) {
        final var value = getStringProperty(path, key);
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException(format("cannot parse int from %s", value), e);
        }
    }

    /**
     * Returns the value of property {@code key} in file specified by {@code path} located in {@code src/main/resources/}.
     *
     * @param path the name of the properties file
     * @param key  the name of the property
     * @return the value of the property
     */
    public static long getLongProperty(final String path, final String key) {
        final var value = getStringProperty(path, key);
        try {
            return Long.parseLong(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException(format("cannot parse long from %s", value), e);
        }
    }
}
