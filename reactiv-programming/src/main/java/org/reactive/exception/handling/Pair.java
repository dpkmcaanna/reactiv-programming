package org.reactive.exception.handling;

public class Pair<F, S> {

	public final F first;
	public final S snd;
	
	private Pair(F first, S snd) {
		this.first = first;
		this.snd = snd;
	}
	
	public static <F, S> Pair<F, S> of(F first, S snd) {
		return new Pair<F, S>(first, snd);
	}
	
	public String toString() {
		return "First: " + first + " , Second: " + snd;
	}
}
