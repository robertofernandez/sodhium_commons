package ar.com.sodhium.commons.files.persistence;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersistenceManagerTest {

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

    @Ignore
    @Test
    public void testWriteFile() throws IOException {
        PersistenceManager<TestClass> pm = new PersistenceManager<>();
        TestClass instance1 = new TestClass("i3");
        pm.writeFile(instance1, "output/o3.json");
    }

    @Ignore
    @Test
    public void testReadFolder() throws IOException {
        PersistenceManager<TestClass> pm = new PersistenceManager<>();
        for (TestClass testClass : pm.readFolder(TestClass.class, "output/folder1")) {
            System.out.println(testClass);
        }
    }

    public class TestClass {
        @SerializedName("name")
        @Expose
        private String name;

        public TestClass(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TestClass [name=" + name + "]";
        }

    }

}
