package sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;
import java.sql.Date;

public class Parser {

    public List<Employee> parse(String jsonString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        List<Employee> employeeList = objectMapper.readValue(jsonString, typeFactory.constructCollectionType(List.class, Employee.class));
        return employeeList;
    }
}
