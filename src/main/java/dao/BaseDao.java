package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class BaseDao <T>{
    protected ObjectMapper objectMapper;
    protected File file;
    protected TypeReference<List<T>> typeReference;

    protected BaseDao(ObjectMapper objectMapper, File file, TypeReference<List<T>> typeReference) {
        this.objectMapper = objectMapper;
        this.file = file;
        this.typeReference = typeReference;
    }

    protected List<T> getAllEntity() throws IOException {
        return objectMapper.readValue(file, typeReference);
    }
    protected void writeToFile(List<T> obj) throws IOException {
        objectMapper.writeValue(file, obj);
    }
}
