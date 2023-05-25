package controle_matriculas.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controle_matriculas.mapper.TurmaMapper;

@Configuration
public class TurmaMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TurmaMapper TurmaMapper() {
        return new TurmaMapper();
    }
}
