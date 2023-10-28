package org.tudalgo.algoutils.student.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark methods from the standard library,
 * that are forbidden to be used by the student in order to implement the annotated method.
 *
 * <p>The following example shows how to use this annotation:</p>
 *
 * <pre>{@code
 *             @Forbidden("java.lang.Math.max")
 *             public static int max(int a, int b) {
 *                 if (a &gt; b) {
 *                     return a;
 *                 } else {
 *                     return b;
 *                 }
 *             }
 *         }</pre>
 * <p>Alternatively the entire class or package can be forbidden:</p>
 *
 * <pre>{@code
 *             @Forbidden("java.lang.Math")
 *             public static int max(int a, int b) {
 *                 if (a &gt; b) {
 *                      return a;
 *                 } else {
 *                     return b;
 *                 }
 *             }
 *        }</pre>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface Forbidden {
    /**
     * The forbidden methods.
     *
     * @return the forbidden methods
     */
    String[] value() default { };
}
