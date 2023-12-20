package algo.otus.algorithm.dancingLinks;

public interface DownLinkable<T extends Node> {
    T addBelow(T n) throws IllegalArgumentException;
}