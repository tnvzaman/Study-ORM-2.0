package io.welldev;

import io.welldev.dao.IlluminatiDAO;
import io.welldev.model.Illuminati;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class illuminatiHibernateMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Illuminati illuminati = new Illuminati();
        illuminati.setName("Mark Zuckerberg");
        illuminati.setCountry("USA");
        illuminati.setDesignation("Alien");
        illuminati.setBalance(100000000);

        IlluminatiDAO illuminatiDAO = (IlluminatiDAO) context.getBean("illuminatiDAO");
        illuminatiDAO.createIlluminati(illuminati);
        System.out.println(illuminati.getName()+ " has joined US!! ");

        List<Illuminati> list = illuminatiDAO.listIlluminati();
        System.out.println("All Illuminatis : ");

        for (Illuminati illuminati1:
             list) {
            System.out.println(illuminati.getName());
        }
    }
}