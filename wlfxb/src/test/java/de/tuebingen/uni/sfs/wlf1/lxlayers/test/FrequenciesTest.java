/**
 *
 */
package de.tuebingen.uni.sfs.wlf1.lxlayers.test;

import de.tuebingen.uni.sfs.wlf1.lx.api.FrequenciesLayer;
import de.tuebingen.uni.sfs.wlf1.lx.xb.FrequenciesLayerStored;
import de.tuebingen.uni.sfs.wlf1.test.utils.TestUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Yana Panchenko
 *
 */
public class FrequenciesTest {

    private static final String INPUT = "data/lx-freq/layer-input.xml";
    private static final String OUTPUT = "data/lx-freq/layer-output.xml";

    @Test
    public void testReadAndWriteBack() throws Exception {

        InputStream is = new FileInputStream(INPUT);
        OutputStream os = new FileOutputStream(OUTPUT);


        FrequenciesLayer layer = TestUtils.read(FrequenciesLayerStored.class, is);
        System.out.println(layer);
        TestUtils.write(layer, os);

        is.close();
        os.close();

        assertEquals(9, layer.size());
        assertEquals(100, layer.getFrequency(0).getValue());
        assertEquals(108, layer.getFrequency(layer.size() - 1).getValue());

    }
}