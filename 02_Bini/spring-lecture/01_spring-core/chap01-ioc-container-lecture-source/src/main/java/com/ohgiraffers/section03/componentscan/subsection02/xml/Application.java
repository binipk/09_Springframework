import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new GenericXmlApplicationContext("section03/xmlconfig/spring-context.xml");


        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println("beanName = " + name);
        }
    }
}
