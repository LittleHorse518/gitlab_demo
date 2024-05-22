package org.example;

public class TimeMethod {

    public void waitMethod() throws InterruptedException {
        for(int time=0;time<30000;time+=500)
        {
            Thread.sleep(500);
        }
        callback();
    }

    private void callback(){
        System.out.println("callback!!!");
    }
}
