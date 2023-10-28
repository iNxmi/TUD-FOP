package org.tudalgo.algoutils.student.test;

/**
 * The result of a {@link StudentTest}.
 *
 * @param state     the {@linkplain StudentTestState state} of the test
 * @param toTest    the object that was tested
 * @param throwable the {@link Throwable} that was thrown during the test
 * @param message   the message of the result or {@code null} if no message was set
 * @param test      the {@link StudentTest} that generated this result
 * @param <T>       the type of the object that was tested
 */
public record StudentTestResult<T>(
    StudentTestState state,
    T toTest,
    Throwable throwable,
    String message,
    StudentTest<T> test
) {

    /**
     * Returns whether the test was successful.
     *
     * @return {@code true} if the test was successful, {@code false} otherwise
     */

    public boolean hasPassed() {
        return state == StudentTestState.PASSED;
    }

    /**
     * Returns whether the test has failed.
     *
     * @return {@code true} if the test has failed, {@code false} otherwise
     */
    public boolean hasFailed() {
        return state == StudentTestState.FAILED_BY_ASSERTION || state == StudentTestState.FAILED_WITH_EXCEPTION;
    }

    /**
     * Returns whether {@link #toTest} matches the predicate of the {@link #test}.
     *
     * @return {@code true} if {@link #toTest} matches the predicate of the {@link #test}, {@code false} otherwise
     */
    public boolean hasFailedByAssertion() {
        return state == StudentTestState.FAILED_BY_ASSERTION;
    }

    /**
     * Returns whether there was an exception during the test execution.
     *
     * @return {@code true} if there was an exception during the test execution, {@code false} otherwise
     */
    public boolean hasFailedWithException() {
        return state == StudentTestState.FAILED_WITH_EXCEPTION;
    }

    /**
     * A builder for {@link StudentTestResult}s.
     *
     * @param <T> the type of the object that was tested
     */
    public static class Builder<T> {
        /**
         * The {@linkplain StudentTestState state} of the test.
         */
        private StudentTestState state = StudentTestState.NOT_STARTED;
        /**
         * The object that was tested.
         */
        private T toTest;
        /**
         * The {@link Throwable} that was thrown during the test.
         */
        private Throwable throwable;
        /**
         * The message of the result or {@code null} if no message was set.
         */
        private String message;
        /**
         * The {@link StudentTest} that generated the result.
         */
        private final StudentTest<T> test;

        /**
         * Creates a new {@link Builder} for the given {@code test}.
         *
         * @param test the {@link StudentTest} that generated the result
         */
        private Builder(StudentTest<T> test) {
            this.test = test;
        }

        /**
         * Sets the {@linkplain StudentTestState state} of the test.
         *
         * @param state the {@linkplain StudentTestState state} of the test
         * @return this {@link Builder}
         */
        public Builder<T> setState(StudentTestState state) {
            this.state = state;
            return this;
        }

        /**
         * Sets the object that was tested.
         *
         * @param toTest the object that was tested
         * @return this {@link Builder}
         */
        public Builder<T> setToTest(T toTest) {
            this.toTest = toTest;
            return this;
        }

        /**
         * Sets the {@link Throwable} that was thrown during the test.
         *
         * @param throwable the {@link Throwable} that was thrown during the test
         * @return this {@link Builder}
         */
        public Builder<T> setThrowable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        /**
         * Sets the message of the result.
         *
         * @param message the message of the result
         * @return this {@link Builder}
         */
        public Builder<T> setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * Builds the {@link StudentTestResult}.
         *
         * @return the {@link StudentTestResult}
         */
        public StudentTestResult<T> build() {
            return new StudentTestResult<>(state, toTest, throwable, message, test);
        }
    }

    /**
     * Creates a new {@link Builder} for the given {@code test}.
     *
     * @param test the {@link StudentTest} that generated the result
     * @param <T>  the type of the object that was tested
     * @return the {@link Builder}
     */
    public static <T> Builder<T> builder(StudentTest<T> test) {
        return new Builder<>(test);
    }

    /**
     * Creates a new {@link Builder} for the given {@link StudentTestResult} and copies all values from it.
     *
     * @param result the {@link StudentTestResult} to copy
     * @param <T>    the type of the object that was tested
     * @return the {@link Builder}
     */
    public static <T> Builder<T> builder(StudentTestResult<T> result) {
        return new Builder<>(result.test)
            .setState(result.state)
            .setToTest(result.toTest)
            .setThrowable(result.throwable)
            .setMessage(result.message);
    }
}
