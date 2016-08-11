/*
 *
 *     service-population Population ID Service
 *     Copyright (c) 2012-2015 National Marrow Donor Program (NMDP)
 *
 *     This library is free software; you can redistribute it and/or modify it
 *     under the terms of the GNU Lesser General Public License as published
 *     by the Free Software Foundation; either version 3 of the License, or (at
 *     your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful, but WITHOUT
 *     ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
 *     FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 *     License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this library;  if not, write to the Free Software Foundation,
 *     Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.
 *
 *     > http://www.fsf.org/licensing/licenses/lgpl.html
 *     > http://www.opensource.org/licenses/lgpl-license.php
 *
 *
 */

package org.nmdp.population.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Population implements Serializable{

    @XmlAttribute
    @Id
    @GeneratedValue
    private long id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String description;

    public Population() {
    }

    public Population(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Population(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Population{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
