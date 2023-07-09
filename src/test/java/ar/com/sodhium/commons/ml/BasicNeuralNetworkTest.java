package ar.com.sodhium.commons.ml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.sodhium.commons.ml.BasicNeuralNetwork;

public class BasicNeuralNetworkTest {

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
    public void testTrain() {
        BasicNeuralNetwork network = new BasicNeuralNetwork(2, 4, 1);

        double[][] trainingData = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

        double[][] resultsData = { { 0 }, { 1 }, { 1 }, { 1 } };

        network.train(trainingData, resultsData, 10000);

        double[] testData1 = { 0, 0 };
        double[] testData2 = { 0, 1 };

        network.forwardPropagation(testData1);
        System.out.println(network.getOutput());
        network.forwardPropagation(testData2);
        System.out.println(network.getOutput());

    }

}
