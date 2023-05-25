package controle_matriculas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {
    
    @JsonProperty("username")
    private String username;
    
    @JsonProperty("password")
    private String password;
}
