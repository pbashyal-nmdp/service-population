/*

    service-population Population ID Service
    Copyright (c) 2012-2015 National Marrow Donor Program (NMDP)

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.fsf.org/licensing/licenses/lgpl.html
    > http://www.opensource.org/licenses/lgpl-license.php

*/
package org.nmdp.population.service;

import org.nmdp.population.dao.PopulationRepository;
import org.nmdp.population.domain.Population;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PopulationServiceImpl implements PopulationService {

    private final PopulationRepository populationRepository;

    @Autowired
    public PopulationServiceImpl(@Qualifier("populationRepository") PopulationRepository populationRepository) {
        this.populationRepository = populationRepository;
    }

    @Override
    public Population getPopulation(Long populationId) {
        return populationRepository.findOne(populationId);
    }

    @Override
    public Population createPopulation(String name, String description) {
        return populationRepository.save(new Population(name, description));
    }
}
