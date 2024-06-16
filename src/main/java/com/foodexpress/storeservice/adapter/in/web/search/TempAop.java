package com.foodexpress.storeservice.adapter.in.web.search;

import com.foodexpress.storeservice.common.Paged;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class TempAop {

    private static final Map<String, String> tempThumbnail = new HashMap<>();

    static {
        tempThumbnail.put("7405fe90-aef8-4c50-946e-3f49ef476a0f", "baemin.jpeg");
        tempThumbnail.put("e752bcc2-98b8-45e7-8a87-dd11f469582b", "realpig.jpeg");
        tempThumbnail.put("44ec84be-7419-48cb-a444-4b624fa4eaf5", "Kimbap_heaven.jpeg");
        tempThumbnail.put("fe22323f-862f-4e33-93fa-b4b8bacd7c6a", "hanubino.jpeg");
        tempThumbnail.put("57be0ad5-7b43-41ab-a2c3-793adcac354c", "macdonalds.jpeg");
        tempThumbnail.put("25c2f10a-acb0-48dc-8bf8-8501eb78eb43", "burger_king.jpeg");
        tempThumbnail.put("8f57952b-3d08-4a6d-8f4d-ce1f3a59bf90", "ukdaejang.jpeg");
        tempThumbnail.put("983e35d5-076e-4d72-8306-d2605d2cd954", "bhc.jpeg");
        tempThumbnail.put("c5e52346-3f36-449b-a06f-09d99465d562", "gogirimakguksu.jpeg");
        tempThumbnail.put("d229dfa6-d300-4a30-abc9-ca8bc0aa4964", "pizza_ddeok_bok_gi.jpg");
    }

    @Around("execution(* com.foodexpress.storeservice.adapter.in.web.search.SearchStoreController.getStoreList(..))")
    public Object setTempThumbnails(ProceedingJoinPoint joinPoint) throws Throwable {
        Paged<StoreInfo> infoPaged = (Paged<StoreInfo>)joinPoint.proceed();
        List<StoreInfo> storeInfos = infoPaged.data();
        storeInfos.forEach(storeInfo -> storeInfo.setThumbUrl(tempThumbnail.get(storeInfo.getUuid())));
        return infoPaged;
    }

}
