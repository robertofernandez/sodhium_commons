package ar.com.sodhium.commons.concurrent;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.sodhium.commons.exceptions.ExceptionPrinter;
import ar.com.sodhium.commons.exceptions.ExceptionsListener;

public class TaskExecutorTest {

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
    public void testInsidePushTask() throws InterruptedException {
        AtomicBoolean outerExecuted = new AtomicBoolean(false);
        AtomicBoolean innerExecuted = new AtomicBoolean(false);
        TaskExecutor executor = new TaskExecutor("ttest", new ExceptionsListener() {
            @Override
            public void onException(Exception e) {
                System.out.println("E: " + ExceptionPrinter.printException(e));
            }
        });

        executor.pushTask(new TaskHandler() {
            @Override
            public String getDescription() {
                return "outer";
            }

            @Override
            public void execute() {
                System.out.println("" + System.currentTimeMillis() + ": outer executed");
                outerExecuted.set(true);
                executor.pushTask(new TaskHandler() {

                    @Override
                    public String getDescription() {
                        return "inner";
                    }

                    @Override
                    public void execute() {
                        System.out.println("" + System.currentTimeMillis() + ": inner executed");
                        innerExecuted.set(true);
                    }
                });
            }
        });

        executor.init();

        //FUTURE improve using latch
        Thread.sleep(100L);

        assertTrue(outerExecuted.get());
        assertTrue(innerExecuted.get());
    }

}
