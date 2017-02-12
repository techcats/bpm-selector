package com.techcats.bpmselector.client;

import com.techcats.bpmselector.config.properties.WolframAlphaConfiguration;
import com.wolfram.alpha.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WolframApiClient {

    @Autowired
    private WolframAlphaConfiguration config;

    private WAEngine engine;

    private void initEngine() {
        engine = new WAEngine();
        engine.setAppID(config.getAppid());
        engine.addFormat("plaintext");
    }

    public void query(int age, String gender) throws WAException {
        if (engine == null) {
            initEngine();
        }
        WAQuery query = engine.createQuery();
        query.setInput(age+"+"+gender+"+"+"heart+rate");
        query.addAssumption("*FVarOpt-_**HeartRate.THR--");




        //query.setInput("26 female heart rate");

        engine.toURL(query);
        WAQueryResult result = engine.performQuery(query);

        System.out.println("Successful query. Pods follow:\n");

        for (WAPod pod : result.getPods()) {
            if (!pod.isError()) {
                System.out.println(pod.getTitle());
                System.out.println("------------");
                for (WASubpod subpod : pod.getSubpods()) {
                    for (Object element : subpod.getContents()) {
                        if (element instanceof WAPlainText) {
                            if(((WAPlainText) element).getText().contains("BPM"))
                                System.out.println(((WAPlainText) element).getText());
                            System.out.println(((WAPlainText) element).getText());

                            System.out.println("");
                        }
                    }
                }
                System.out.println("");
            }
        }
    }

}
