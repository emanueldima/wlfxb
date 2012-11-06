/**
 *
 */
package eu.clarin.weblicht.wlfxb.tc.xb;

import eu.clarin.weblicht.wlfxb.utils.CommonAttributes;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Yana Panchenko
 *
 */
@XmlRootElement(name = MatchedItemTarget.XML_NAME)
@XmlAccessorType(XmlAccessType.NONE)
public class MatchedItemTarget {

    public static final String XML_NAME = "target";
    @XmlAttribute(name = CommonAttributes.NAME, required = true)
    protected String name;
    @XmlAttribute(name = CommonAttributes.VALUE, required = true)
    protected String value;

    MatchedItemTarget() {
    }

    MatchedItemTarget(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(XML_NAME);
        sb.append(" ");
        sb.append(name);
        sb.append(" ");
        sb.append(value);
        return sb.toString();
    }
}