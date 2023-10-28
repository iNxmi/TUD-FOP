package org.tudalgo.algoutils.student.test;

/**
 * A functional interface used to generate the message for a {@link StudentTestResult}.
 *
 * @param <T> The type of the object that was tested.
 */
@FunctionalInterface
public interface StudentTestResultMessageProvider<T> {
    /**
     * Generates the message for the given {@code result}.
     *
     * @param result The {@link StudentTestResult} to generate the message for.
     * @return The generated message.
     */
    String getMessage(StudentTestResult<T> result);
}
