/**
 * wlfxb - a library for creating and processing of TCF data streams.
 *
 * Copyright (C) Yana Panchenko.
 *
 * This file is part of wlfxb.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.clarin.weblicht.wlfxb.lx.xb;

import eu.clarin.weblicht.wlfxb.lx.api.Term;
import eu.clarin.weblicht.wlfxb.utils.CommonAttributes;
import javax.xml.bind.annotation.*;

/**
 * @author Yana Panchenko
 *
 */

@XmlRootElement(name = TermStored.XML_NAME)
@XmlAccessorType(XmlAccessType.NONE)
public class TermStored implements Term {

    public static final String XML_NAME = "term";
    @XmlAttribute(name = CommonAttributes.ENTRY_REFERENCE)
    protected String entryId;
    @XmlValue
    protected String word;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (entryId != null) {
            sb.append(entryId);
        } else if (word != null) {
            sb.append(word);
        }
        return sb.toString();
    }
}
