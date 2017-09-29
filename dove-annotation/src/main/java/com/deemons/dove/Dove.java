package com.deemons.dove;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建者      chenghaohao
 * 创建时间     2017/9/29 11:17
 * 包名       com.deemons.dove
 * 描述
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD,ElementType.CONSTRUCTOR})
public @interface Dove {
}
