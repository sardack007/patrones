package testmongo;

import org.bson.types.ObjectId;
import testmongo.database.DBSingleton;
import testmongo.models.*;
import testmongo.repository.*;

import java.time.LocalDate;
import java.time.Month;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        System.out.println( "Ingresando Datos" );
        //User
        RepoUser repoUser = new RepoUser();
        User user = new User();
        user.setNickname("nickname");
        user.setEmail("email@email.com");
        user.setFirstname("primer nombre");
        user.setLastname("apellido");
        user.setPassword("constrasenauser");
        user.setAge(15);
        user.setGenre("F");
        repoUser.saverUser(user);
        //Administrator
        RepoAdministrator repoAdministrator = new RepoAdministrator();
        Administrator administrator = new Administrator();
        administrator.setNickname("nickadministrator");
        administrator.setEmail("email@email.com");
        administrator.setFirstname("primer nombre");
        administrator.setLastname("apellido");
        administrator.setPassword("constrasena");
        administrator.setIdPerson(new ObjectId("5cfdbbb4e50f536aa8ebc15b"));
        repoAdministrator.saveAdministrator(administrator);
        //Athlete
        RepoAthlete repoAthlete = new RepoAthlete();
        Athlete athlete = new Athlete("federacion","peru","disciplina","urlFacebook","twitter", 22, "M");
        athlete.setFirstname("jim");
        athlete.setLastname("mac");
        athlete.setEmail("asd@sdf");
        athlete.setPassword("contrasena");
        repoAthlete.saveAthlete(athlete);
        //Headquarters
        RepoHeadquarters repoHeadquarters = new RepoHeadquarters();
        Headquarters headquarters = new Headquarters();
        headquarters.setName("headquarteName");
        headquarters.setAddress("av Venezuela");
        headquarters.setCapacity(1500);
        repoHeadquarters.saveHeadquarters(headquarters);
        headquarters = repoHeadquarters.getHeadquartersByName(headquarters.getName());
        //Event
        RepoEvent repoEvent = new RepoEvent();
        Event event = new Event();
        event.setName("evento1");
        event.setIdHeadquarters(headquarters.getIdHeadquarters());
        event.setAvarageMark(15.4);
        event.setStartDate(LocalDate.now());
        event.setEndDate(LocalDate.of(1989, Month.NOVEMBER, 11));
        repoEvent.saveEvent(event);
        //Service
        RepoService repoService = new RepoService();
        Service service = new Service();
        service.setName("servicio1");
        service.setAvarageMark(10.6);
        service.setIdheadquarters(headquarters.getIdHeadquarters());
        repoService.saveService(service);


        // Close connection
        DBSingleton.getInstance().close();
        */
//        RepoEvent repoEvent = new RepoEvent();
//        repoEvent.GetEvents().forEach(System.out::println);


        CommentService commentService = new CommentService();
        commentService.setDate(LocalDate.now());
        commentService.setMessage("mensaje de servicio 2");
        commentService.setIdService(new ObjectId("5d1b988b014d311abaa8256d"));
        RepoCommentService repoCommentService = new RepoCommentService();
        repoCommentService.saveCommentService(commentService);

        repoCommentService.getAllComments().forEach(System.out::println);
    }
}
