package org.tudalgo.algoutils.student;

/**
 * A utility class that contains some useful methods for student implementations.
 */
public final class Student {

    private static boolean crashEnabled = true;

    /**
     * Sets if a call of {@link #crash(String...)} should crash the program.
     *
     * @param enabled if a call of {@link #crash(String...)} should crash the program
     */
    public static void setCrashEnabled(boolean enabled) {
        Student.crashEnabled = enabled;
    }

    /**
     * A utility method that throws a {@code CrashException} with the specified message.
     *
     * @param messages the messages to hand to the exception. (will be concatenated with a newline)
     * @param <V>      the type of the value to be returned.
     * @return never returns anything (the method will always throw a {@code CrashException})
     * @throws CrashException if the method is called.
     * @see CrashException
     */
    public static <V> V crash(final String... messages) {
        if (crashEnabled)
            throw new CrashException(String.join("\n", messages));
        return null;
    }
}
