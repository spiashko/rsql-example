package com.spiashko.rsqlexample.rsql;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface RsqlSpec {

    String requestParamName() default "filter";

    AndPathVarEq[] extensionFromPath() default {};

}
