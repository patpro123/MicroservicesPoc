package com.partho.poc.webcrawlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class HeadlineRequest {

    private String topic;
    private String country;
    private String lang;
    private String query;
    private String max;

    public String getQuery() throws IllegalAccessException {
        Field[] allFields = this.getClass().getDeclaredFields();
        String query = "";
        for(int count=0;count< allFields.length;count++){
            query = query + concatNonNullValues(allFields[count].getName(), (String) allFields[count].get(this));
        }


        return query;
    }

    private String concatNonNullValues(String paramName,String value){
        if(value != null){
            return "&"+paramName+"="+value;
        }
        return "";
    }

}
