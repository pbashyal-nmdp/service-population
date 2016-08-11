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

package org.nmdp.population.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.nmdp.population"))
                .paths(PathSelectors.ant("/population/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("Population ID Service ",
                "Service to register and retrieve Population ID",
                "0.0.1",
                null,
                new Contact("Pradeep Bashyal", null, "pbashyal@nmdp.org"),
                "Copyright NMDP",
                "CC Non-commercial Non-Redistributable");
    }
}
