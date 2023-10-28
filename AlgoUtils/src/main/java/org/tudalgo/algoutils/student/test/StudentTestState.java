package org.tudalgo.algoutils.student.test;

/**
 * The state of a {@link StudentTest}.
 */
public enum StudentTestState {
    /**
     * The test has not been started yet.
     */
    NOT_STARTED,
    /**
     * The test has passed successfully.
     */
    PASSED,
    /**
     * The test has failed because the assertion failed.
     */
    FAILED_BY_ASSERTION,
    /**
     * The test has failed because an exception was thrown.
     */
    FAILED_WITH_EXCEPTION;

    /**
     * Returns whether the test has been run.
     *
     * @return {@code true} if the test has been run, {@code false} otherwise
     */
    public boolean finished() {
        return this != NOT_STARTED;
    }

    /**
     * Returns whether the test has passed.
     *
     * @return {@code true} if the test has passed, {@code false} otherwise
     */
    public boolean hasPassed() {
        return this == PASSED;
    }

    /**
     * Returns whether the test has failed.
     *
     * @return {@code true} if the test has failed, {@code false} otherwise
     */
    public boolean hasFailed() {
        return this == FAILED_BY_ASSERTION || this == FAILED_WITH_EXCEPTION;
    }
}
