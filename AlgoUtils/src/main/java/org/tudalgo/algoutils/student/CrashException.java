package org.tudalgo.algoutils.student;

/**
 * An Exception that is intended to be thrown by default when a method is called that is not implemented.
 */
public class CrashException extends RuntimeException {
    /**
     * Constructs a new {@code CrashException} with the specified detail message.
     *
     * @param message the detail message.
     */
    public CrashException(final String message) {
        super(message);
    }
}
