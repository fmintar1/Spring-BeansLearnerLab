package zipcode.rocks.BeanLab.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import zipcode.rocks.BeanLab.Models.Instructor;
import zipcode.rocks.BeanLab.Models.Instructors;

@Configuration
public class InstructorsConfig {
    
    @Bean
    public Instructors tcUsaInstructors() {
        List<Instructor> tList = new ArrayList<>();
        tList.add(new Instructor(1L, "Michael Phelps"));
        tList.add(new Instructor(2L, "Gordon Ramsay"));
        tList.add(new Instructor(3L, "Beyonce Knowles"));
        return new Instructors(tList);
        
    }
    @Bean
    public Instructors tcUkInstructors() {
        List<Instructor> tList = new ArrayList<>();
        tList.add(new Instructor(1L, "James Gordon"));
        tList.add(new Instructor(2L, "Fran Silva"));
        tList.add(new Instructor(3L, "Kris Older"));
        tList.add(new Instructor(4L, "Dolio Duhrand"));
        return new Instructors(tList);
    }

    @Bean
    @Primary
    public Instructors instructors() {
        List<Instructor> tList = new ArrayList<>();
        tList.add(new Instructor(1L, "Desa Burton"));
        tList.add(new Instructor(2L, "Kris Younger"));
        tList.add(new Instructor(3L, "Dolio Durant"));
        tList.add(new Instructor(4L, "Dan Stabb"));
        tList.add(new Instructor(5L, "Lossie Freeman"));
        return new Instructors(tList);
    }

    

}
