package org.reactive.exception.handling;

@FunctionalInterface
public interface CheckedFunction<T, R> {
	R apply(T t) throws Exception;
}
