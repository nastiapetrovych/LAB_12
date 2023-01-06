package org.example.decorator;

public class Main {
    public static void main (String[] args) throws ClassNotFoundException {
        new CachedDocument("gs://photosnastia/ph2.png").parse();
        new TimedDocument("gs://photosnastia/ph2.png").parse();
    }
}
