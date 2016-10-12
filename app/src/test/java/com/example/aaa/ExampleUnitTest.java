package com.example.aaa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import xiaofei.library.shelly.Shelly;
import xiaofei.library.shelly.function.Action1;
import xiaofei.library.shelly.function.Function1;

import static junit.framework.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testToyRoom() {
        Shelly.<String>createDomino("file name")
                .background()
                .flatMap(new Function1<String, List<Byte>>() {
                    @Override
                    public List<Byte> call(String input) {
//                        File[] files = new File(input).listFiles();
                        byte[] bytes = input.getBytes();
                        List<Byte> result = new ArrayList<>();
                        for (Byte by : bytes) {
                            result.add(by);
                        }
                        return result;
                    }
                })
                .perform(new Action1<Byte>() {
                    @Override
                    public void call(Byte input) {
                        System.out.print(input.toString());
                    }
                })
                .commit();
    }

    @Test
    public void test() {
        long playDuration = 0;
        System.out.print(playDuration / 3600);
        System.out.print(playDuration % 3600 / 60);
        System.out.print(playDuration % 60);
    }

    @Test
    public void testExecutors() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.print(aLong + "");
                    }
                });
    }

    @Test
    public void stringText(){
        String likesTxt = -1 >= 0 ? (10 + "\n赞") : ("--\n赞");
        System.out.print(likesTxt);
    }
}