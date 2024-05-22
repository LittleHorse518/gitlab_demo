package org.example;



import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SDKMethod {
    public ScheduledExecutorService executorService;
    public ScheduledFuture<?> scheduledFuture;

    public String patternTransfer(String str) {

                Pattern.compile("^([a-z]+)[:：]( )*(@([A-Z0-9]+-[0-9]+))( )?(@([A-Z0-9]+-[0-9]+))?( )?(.+)?$");
                Pattern.compile("^(fix)[:：]( )*(@([A-Z0-9]+-[0-9]+))( )?(@([A-Z0-9]+-[0-9]+))?( )?(resolved)?( )?(.+)?$");
        Pattern pattern1 = Pattern.compile("feat[:：]\\s*?@([\\w-]+)\\s*?@([\\w-]+)\\s*?(.+)");
        Pattern pattern2 = Pattern.compile("fix[:：]\\s*?@([\\w-]+)\\s*?@([\\w-]+)\\s*?resolved\\s*?(.|\\n)+");
        Matcher matcher1 = pattern1.matcher(str);
        Matcher matcher2 = pattern2.matcher(str);
        if(matcher2.matches()){
            String group1 = matcher2.group(1);
            String group2 = matcher2.group(2);
            if (group1.equals(group2)){
                return group1;
            } else {
                return group1 +"#"+group2;
            }
        }
        return "noneMatch";
    }

    public void timerMethod() {
        if(scheduledFuture != null && !scheduledFuture.isDone()){
            scheduledFuture.cancel(false);
        }
        scheduledFuture = executorService.schedule(this::callback,2_000, TimeUnit.MILLISECONDS);

    }

    private void callback(){
        System.out.println("callback!!!");
    }

    //        insertBean(DAO XXX) ;
//        RETURN dao_xxx.getID();
}