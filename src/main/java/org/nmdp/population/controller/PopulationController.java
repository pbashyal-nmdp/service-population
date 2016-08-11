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

package org.nmdp.population.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.nmdp.population.domain.Population;
import org.nmdp.population.domain.PopulationRequest;
import org.nmdp.population.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population")
@Api(value = "Population", description = "Population ID Service")
public class PopulationController {

    private final PopulationService populationService;

    @Autowired
    public PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    @RequestMapping(value = "/{populationId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "getPopulationForId", response = Population.class)
    public
    @ResponseBody
    Population getPopulation(@PathVariable Long populationId) {
        return populationService.getPopulation(populationId);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public
    @ResponseBody
    Population createPopulation(@RequestBody PopulationRequest populationRequest) {
        return populationService.createPopulation(populationRequest.getName(), populationRequest.getDescription());
    }
}
