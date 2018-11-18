package wang.ismy.bloga.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.Serializable;
import java.lang.reflect.Field;

public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString(){
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {

        }
        return super.toString();
    }
}
