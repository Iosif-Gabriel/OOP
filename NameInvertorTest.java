import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameInvertorTest {

    @Test
    public void nullReturnsNull(){
        Assert.assertEquals(null,NameInvertor.invert(null));
    }

    @Test
    public void spaceReturnSpace(){
        Assert.assertEquals(" ",NameInvertor.invert(" "));
    }

    @Test
    public void nothingReturNothing(){
        Assert.assertEquals("",NameInvertor.invert(""));
    }

    @Test
    public void nameRetursName(){
        Assert.assertEquals("Viorel",NameInvertor.invert("   Viorel   "));
        Assert.assertEquals("Viorel",NameInvertor.invert("Viorel"));
    }

    @Test
    public void inversareNume() {
        Assert.assertEquals("Popescu, Viorel",NameInvertor.invert(" Viorel Popescu "));
        Assert.assertEquals("Popescu, Viorel",NameInvertor.invert("    Viorel     Popescu    "));

    }

    @Test
    public void formalTitles(){
        Assert.assertEquals("Popescu, Viorel Mr.",NameInvertor.invert(" Mr. Viorel Popescu "));
        Assert.assertEquals("Popescu, Cornelia Mrs.",NameInvertor.invert("Mrs. Cornelia Popescu"));

    }

    @Test
    public void formalTitlesPHD(){
        Assert.assertEquals("Popescu, Viorel Mr. Phd.",NameInvertor.invert(" Mr. Phd. Viorel Popescu "));
        Assert.assertEquals("Popescu, Cornelia Mrs. Phd.",NameInvertor.invert("Mrs. Phd. Cornelia Popescu"));

    }


}