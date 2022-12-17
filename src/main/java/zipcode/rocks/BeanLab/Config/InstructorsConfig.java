package zipcode.rocks.BeanLab.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import zipcode.rocks.BeanLab.Models.Instructor;
import zipcode.rocks.BeanLab.Models.Instructors;

@Configuration
public class InstructorsConfig {
    
    @Bean
    public Instructors tcUsaInstructors(List<Instructor> usaInstructors) {
        return new Instructors(usaInstructors);
        
    }
    @Bean
    public Instructors tcUkInstructors(List<Instructor> ukInstructors) {
        return new Instructors(ukInstructors);
    }

    @Bean
    @Primary
    public Instructors instructors(List<Instructor> instructors) {
        return new Instructors(instructors);
    }

    

}
