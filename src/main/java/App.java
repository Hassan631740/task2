import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld1 = context.getBean(HelloWorld.class);
        HelloWorld helloWorld2 = context.getBean(HelloWorld.class);

        System.out.println(helloWorld1 == helloWorld2); // should be true

        Cat cat1 = context.getBean(Cat.class);
        Cat cat2 = context.getBean(Cat.class);

        System.out.println(cat1 == cat2); // should be false
    }
}