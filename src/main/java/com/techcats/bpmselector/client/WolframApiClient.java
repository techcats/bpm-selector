package com.techcats.bpmselector.client;

import com.techcats.bpmselector.config.properties.WolframAlphaConfiguration;
import com.techcats.bpmselector.data.models.User;
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

    public void query(User user) throws WAException {
        if (engine == null) {
            initEngine();
        }
        WAQuery query = engine.createQuery();
        query.setInput("heart rate age " + user.getAge() + " gender " + user.getGender());
        query.addAssumption("*FVarOpt-_**HeartRate.THR--");
        engine.toURL(query);
        WAQueryResult result = engine.performQuery(query);
        for (WAPod pod : result.getPods()) {
            if (!pod.isError()) {
                for (WASubpod subpod : pod.getSubpods()) {
                    for (Object element : subpod.getContents()) {
                        if (element instanceof WAPlainText) {
                            String value = ((WAPlainText) element).getText();
                            if (value.contains("resting heart rate")) {
                                user.setRestHeartRate(Integer.parseInt(value.replaceAll(".+\\|\\s+", "").replace(" bpm  (beats per minute)", "")));
                            }
                            if (value.contains("target heart rate")) {
                                user.setRestHeartRate(Integer.parseInt(value.replaceAll(".+\\|\\s+", "").replace(" bpm  (beats per minute)", "")));
                            }
                        }
                    }
                }
            }
        }
    }

}
