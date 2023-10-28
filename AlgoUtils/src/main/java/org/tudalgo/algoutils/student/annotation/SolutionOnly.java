package org.tudalgo.algoutils.student.annotation;

import java.lang.annotation.*;

/**
 * This annotation is used to mark utility classes, functions or fields, that:
 * <ul>
 *     <li>are <b>only</b> present in the solution</li>
 *     <li>are <b>not</b> required to be implemented or created by the student</li>
 *     <li>are <b>not</b> tested by the grader</li>
 *     <li>were <b>not</b> originally present in the student template</li>
 * </ul>
 */
@Documented
@Inherited
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface SolutionOnly {
    /**
     * An optional reason why the annotated element is only present in the solution.
     *
     * @return the reason why the annotated element is only present in the solution
     */
    String value() default "";
}
