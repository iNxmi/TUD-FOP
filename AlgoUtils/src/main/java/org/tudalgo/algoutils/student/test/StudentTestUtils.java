package org.tudalgo.algoutils.student.test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Utility class for tests written by students.
 */
public class StudentTestUtils {
    /**
     * The {@link PrintStream} to use for test output.
     */
    public static PrintStream S_TEST_OUT = System.out;
    /**
     * The {@link PrintStream} to use for test error output.
     */
    public static PrintStream S_TEST_ERR = System.err;

    /**
     * The list of all {@linkplain StudentTestResult test results} created by the student tests.
     */

    public static List<StudentTestResult<?>> testResults = new ArrayList<>();

    /**
     * Utility method to create a {@link StudentTest} with the given {@code predicate} and {@code messageProvider} and
     * apply it to the given {@code toTest} value. The result is added to {@link #testResults}.
     *
     * @param toTest          the value to test
     * @param predicate       the predicate to test the value with
     * @param messageProvider the message provider to create the message for the result
     * @param <T>             the type of the value to test
     */
    private static <T> void simpleStudentTest(
        T toTest,
        Predicate<T> predicate,
        StudentTestResultMessageProvider<T> messageProvider
    ) {
        var test = new StudentTest<>(predicate, messageProvider);
        final var result = test.test(toTest);
        testResults.add(result);
        if (result.hasFailed()) {
            S_TEST_ERR.println(result.message());
            result.throwable().printStackTrace(S_TEST_ERR);
        }
    }

    /**
     * Checks that the given {@code expected} value is equal to the given {@code actual} value.
     * If the values are not equal, an error message is printed to {@link #S_TEST_ERR}.
     *
     * <p>This method is intended to be used in the context of a test case from the student.
     *
     * <p>Example:
     * <pre>{@code
     *            public static int max(int a, int b) {
     *              return a > b ? a : b;
     *            }
     *            public static void main(String[] args) {
     *              testEquals(3, max(2, 3));
     *              testEquals(3, max(3, 2));
     *              testEquals(3, max(3, 3));
     *            }
     *      }</pre>
     *
     * @param expected the expected value
     * @param actual   the actual value
     */
    public static void testEquals(Object expected, Object actual) {
        simpleStudentTest(
            actual,
            a -> a.equals(expected),
            r -> String.format("Expected: <%s>, but was: <%s>", expected, r.toTest())
        );
    }

    /**
     * Checks that the given {@code actual} value is in the range {@code [min, max]}. The range is inclusive.
     * If the value is not in the range, an error message is printed to {@link #S_TEST_ERR}.
     *
     * <p>This method is intended to be used in the context of a test case from the student.
     *
     * <p>Example:
     * <pre>{@code
     *           public static void main(String[] args) {
     *               testWithinRange(0, 10, 5);
     *               testWithinRange(0, 10, 0);
     *               testWithinRange(0, 10, 10);
     *               testWithinRange(0, 10, -1); // will print an error message
     *           }
     *     }</pre>
     *
     * @param min    the minimum value of the range
     * @param max    the maximum value of the range
     * @param actual the actual value
     */
    public static <T extends Comparable<T>> void testWithinRange(T min, T max, T actual) {
        simpleStudentTest(
            actual,
            a -> a.compareTo(min) >= 0 && a.compareTo(max) <= 0,
            r -> String.format("Expected: <%s> to be in range <%s, %s>, but was not", actual, min, max)
        );
    }

    /**
     * Checks that the given {@code actual} value is in the range {@code [min, max]}. The range is inclusive.
     * If the value is not in the range, an error message is printed to {@link #S_TEST_ERR}.
     *
     * <p>This method is intended to be used in the context of a test case from the student.
     *
     * <p>Example:
     * <pre>{@code
     *          public static void main(String[] args) {
     *              testWithinRange(0, 10, 5);
     *              testWithinRange(0, 10, 0);
     *              testWithinRange(0, 10, 10);
     *              testWithinRange(0, 10, -1); // will print an error message
     *          }
     *      }</pre>
     *
     * @param min    the minimum value of the range
     * @param max    the maximum value of the range
     * @param actual the actual value
     */
    public static void testWithinRange(double min, double max, double actual) {
        testWithinRange(Double.valueOf(min), Double.valueOf(max), Double.valueOf(actual));
    }

    /**
     * Prints a summary of the test results to {@link #S_TEST_OUT}.
     * The summary contains the number of passed and failed tests.
     *
     * <p>This method is intended to be used in the context of a test case from the student.
     * Ideally, it is called at the end of the {@code main} method.
     */
    public static void printTestResults() {
        final var passed = testResults.stream().filter(StudentTestResult::hasPassed).count();
        final var failedByAssertion = testResults.stream().filter(StudentTestResult::hasFailedByAssertion).count();
        final var failedWithException = testResults.stream().filter(StudentTestResult::hasFailedWithException).count();
        final var failed = failedByAssertion + failedWithException;
        final StringBuilder messageBuilder = new StringBuilder();
        if (failed == 0) {
            messageBuilder.append(String.format("All %s test(s) passed!%n", passed));
        } else {
            messageBuilder.append(String.format("%s of %s total test(s) passed!%n", passed, testResults.size()));
            if (failedByAssertion > 0) {
                messageBuilder.append(String.format(" %s test(s) were executed, but failed by assertion.%n", failedByAssertion));
            }
            if (failedWithException > 0) {
                messageBuilder.append(String.format(" %s test(s) threw an exception during execution.%n", failedWithException));
            }
        }
        final var message = messageBuilder.toString();
        // get length of longest line
        final var longestLine = message.lines().mapToInt(String::length).max().orElse("Test results summary".length());
        // print header
        S_TEST_OUT.println("=".repeat(longestLine));
        S_TEST_OUT.println("Test results summary");
        S_TEST_OUT.println("-".repeat(longestLine));
        S_TEST_OUT.print(message);
        // print footer
        S_TEST_OUT.println("=".repeat(longestLine));
    }
}
