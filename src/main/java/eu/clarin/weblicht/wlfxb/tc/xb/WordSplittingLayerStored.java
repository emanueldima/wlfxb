/**
 *
 */
package eu.clarin.weblicht.wlfxb.tc.xb;

import eu.clarin.weblicht.wlfxb.tc.api.Token;
import eu.clarin.weblicht.wlfxb.tc.api.WordSplit;
import eu.clarin.weblicht.wlfxb.tc.api.WordSplittingLayer;
import eu.clarin.weblicht.wlfxb.utils.CommonAttributes;
import eu.clarin.weblicht.wlfxb.utils.WlfUtilities;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 * @author Yana Panchenko
 *
 */
@XmlRootElement(name = WordSplittingLayerStored.XML_NAME)
@XmlAccessorType(XmlAccessType.NONE)
public class WordSplittingLayerStored extends TextCorpusLayerStoredAbstract implements WordSplittingLayer {

    public static final String XML_NAME = "WordSplittings";
    @XmlAttribute(name = CommonAttributes.TYPE)
    private String type;
    @XmlElement(name = WordSplitStored.XML_NAME)
    private List<WordSplitStored> splits = new ArrayList<WordSplitStored>();
    private TextCorpusLayersConnector connector;

    protected void setLayersConnector(TextCorpusLayersConnector connector) {
        this.connector = connector;
        for (WordSplitStored split : splits) {
            connector.token2ItsSplit.put(connector.tokenId2ItsToken.get(split.tokRef), split);
        }
    }

    protected WordSplittingLayerStored() {
    }

    protected WordSplittingLayerStored(String type) {
        this.type = type;
    }

    protected WordSplittingLayerStored(TextCorpusLayersConnector connector) {
        this.connector = connector;
    }

    @Override
    public boolean isEmpty() {
        return splits.isEmpty();
    }

    @Override
    public int size() {
        return splits.size();
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public WordSplit getSplit(int index) {
        return splits.get(index);
    }

    @Override
    public WordSplit getSplit(Token token) {
        return this.connector.token2ItsSplit.get(token);
    }

    @Override
    public Token getToken(WordSplit split) {
        if (split instanceof WordSplitStored) {
            return this.connector.tokenId2ItsToken.get(((WordSplitStored) split).tokRef);
        } else {
            throw new UnsupportedOperationException(WlfUtilities.layersErrorMessage(WordSplit.class, WordSplittingLayer.class));
        }

    }

    @Override
    public WordSplit addSplit(Token token, int[] splitIndices) {
        WordSplitStored wordSplit = new WordSplitStored();
        wordSplit.splitIndices = splitIndices;
        wordSplit.tokRef = token.getID();
        splits.add(wordSplit);
        return wordSplit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(XML_NAME);
        sb.append(" {");
        sb.append(type);
        sb.append("}: ");
        sb.append(splits.toString());
        return sb.toString();
    }
}