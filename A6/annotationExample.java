import java.lang.annotation.Target;
import java.lang.Class;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface CricketPlayer{
    int age() default 34;
    String country() default "India";
}

@CricketPlayer(age=35, country="India")
class Virat{
    @CricketPlayer
    int runs;
    int innings;

    @CricketPlayer
    public void setRuns(int runs){
        this.runs = runs;
    }
    public void setInnings(int innings){
        this.innings=innings;
    }
    public int getRuns(){
        return this.runs;
    }
    public int getInnings(){
        return this.innings;
    }
}

public class annotationExample{
    public static void main(String arg[])  {
        try{
            Virat v = new Virat();
            v.setRuns(15000);
            v.setInnings(250);
            System.out.println(v.getRuns());
            System.out.println(v.getInnings());

            Class c = v.getClass();
            Annotation an = c.getAnnotation(CricketPlayer.class);
            System.out.println(an.annotationType().getMethod("age").invoke(an));
            CricketPlayer cp = (CricketPlayer)an;
            System.out.println("Age of Virat: "+cp.age());
            System.out.println("Age of Virat: "+cp.country());
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
}