package org.example.decorator;

import com.google.common.base.Stopwatch;
import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class TimedDocument implements Document {
    public String document;
    @Override
    public String parse() throws ClassNotFoundException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String myCall = new SmartDocument(document).parse();
        stopwatch.stop(); // optional
        System.out.println("Time elapsed for uncached parsing: "+ stopwatch.elapsed(TimeUnit.SECONDS) + " " + "seconds");

        Stopwatch stopwatchSecond = Stopwatch.createStarted();
        String myCallSecond = new CachedDocument(document).parse();
        stopwatchSecond.stop();
        System.out.println("Time elapsed for cached parsing: "+ stopwatchSecond.elapsed(TimeUnit.SECONDS) + " " + "seconds");
        return myCall;
    }

}
