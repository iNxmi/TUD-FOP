package org.tudalgo.algoutils.student.test;

import java.util.function.Predicate;

/**
 * A generic test used by students to test their solutions.
 *
 * @param <T> The type of the object to test.
 */
public class StudentTest<T> {
    /**
     * The {@link Predicate} used to test the object.
     */
    protected Predicate<T> predicate;
    /**
     * The {@link StudentTestResultMessageProvider} used to generate the message for the result.
     */
    protected StudentTestResultMessageProvider<T> messageProvider;

    /**
     * Creates a new {@link StudentTest} with the given {@code predicate} and {@code messageProvider}.
     *
     * @param predicate       The {@link Predicate} used to test the object.
     * @param messageProvider The {@link StudentTestResultMessageProvider} used to generate the message for the result.
     */
    public StudentTest(Predicate<T> predicate, StudentTestResultMessageProvider<T> messageProvider) {
        this.predicate = predicate;
        this.messageProvider = messageProvider;
    }

    /**
     * Tests the given {@code toTest} object with the {@link #predicate} and returns a {@link StudentTestResult} with
     * the result.
     *
     * @param toTest The object to test.
     * @return The generated {@link StudentTestResult}.
     */
    public StudentTestResult<T> test(T toTest) {
        final var resultBuilder = StudentTestResult
            .builder(this)
            .setToTest(toTest);
        try {
            if (predicate.test(toTest)) {
                resultBuilder.setState(StudentTestState.PASSED);
            } else {
                resultBuilder.setState(StudentTestState.FAILED_BY_ASSERTION);
                resultBuilder.setThrowable(new AssertionError());
            }
        } catch (Throwable throwable) {
            resultBuilder
                .setState(StudentTestState.FAILED_WITH_EXCEPTION)
                .setThrowable(throwable);
        }
        resultBuilder.setMessage(messageProvider.getMessage(resultBuilder.build()));
        return resultBuilder.build();
    }
}
