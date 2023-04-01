package net.ejazcurd.springbootcurd.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@Data
@XmlRootElement(name="error")
public class ErrorResponse {

    String message;
    List<String> error;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getError() {
        return error;
    }


}
