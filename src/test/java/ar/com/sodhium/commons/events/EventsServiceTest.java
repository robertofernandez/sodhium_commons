package ar.com.sodhium.commons.events;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EventsServiceTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testVolatileRegister() throws InterruptedException {
        EventsService service = new EventsService();
        service.volatileRegister("test-response", new EventsListener() {
            @Override
            public void execute(String remittent, EventParameters parameters) {
                System.out.println("this shall be printed once in response" + parameters);
            }
        });

        service.register("test1", new EventsListener() {
            @Override
            public void execute(String remittent, EventParameters parameters) {
                System.out.println("this shall be printed every time " + parameters);
            }
        });

        service.volatileRegister("test1", new EventsListener() {
            @Override
            public void execute(String remittent, EventParameters parameters) {
                System.out.println("this shall be printed once " + parameters);
                parameters.setParameter("response-time", new Date());
                service.trigger("test-response", parameters, remittent);
            }
        });
        EventParameters params1 = new EventParameters();
        EventParameters params2 = new EventParameters();
        EventParameters params3 = new EventParameters();

        params1.setParameter("id", "1");
        params2.setParameter("id", "2");
        params3.setParameter("id", "3");

        service.trigger("test1", params1, "testVolatileRegister");
        service.trigger("test1", params2, "testVolatileRegister");
        service.trigger("test1", params3, "testVolatileRegister");
    }

}
