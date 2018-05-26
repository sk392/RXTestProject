package latte.example.com.rxtestproject;

import org.junit.Test;

import io.reactivex.Observable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
   String result="";
    @Test
    public void returnValue(){
        result = "";
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(s -> result=s);
        assertTrue(result.equals("Hello"));

    }


}