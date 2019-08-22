package com.lucifiere.coder2.client.runner;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RunWithSpringBoot {
}
