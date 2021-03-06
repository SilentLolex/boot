package com.books.algorithm.edition.four.c1;

/******************************************************************************
 *  Compilation:  javac Flips.java
 *  Execution:    java Flips n
 *  Dependencies: Counter.java StdRandom.java StdOut.java
 *
 *  Simulate the flipping of n fair coins.
 *
 *  % java Flips 10
 *  5 heads
 *  5 tails
 *  delta: 0
 *
 *  % java Flips 10
 *  8 heads
 *  2 tails
 *  delta: 6
 *
 *  % java Flips 1000000
 *  499710 heads
 *  500290 tails
 *  delta: 580
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @Author: SilentLolex
 * @Date: 20220111
 */

public class Flips {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            }
            else{
                tails.increment();
            }
        }
        StdOut.println(heads);
        StdOut.println(tails);
        int delta = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(delta));
        d();
    }

    public static void d() {
        int s = 1;
    }

    public  void dr() {
        int s = 1;
        drf();
    }

    public  void drf() {
        int s = 1;
    }
}
