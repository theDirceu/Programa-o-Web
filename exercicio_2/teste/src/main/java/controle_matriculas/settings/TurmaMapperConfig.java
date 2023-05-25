package controle_matriculas.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controle_matriculas.mapper.TurmaMapper;;

@Configuration
public class TurmaMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public TurmaMapper turmaMapper() {
        return new TurmaMapper();
    }
}