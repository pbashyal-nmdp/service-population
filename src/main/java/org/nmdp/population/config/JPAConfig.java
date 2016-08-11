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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "org.nmdp.population.dao", entityManagerFactoryRef = "getEntityManagerFactory")
@EnableTransactionManagement
public class JPAConfig {

    @Value("${db.driverClass}")
    private String driverClass;
    @Value("${db.url}")
    private String dbURL;
    @Value("${db.user}")
    private String dbUser;
    @Value("${db.password}")
    private String dbPassword;
    @Value("${db.dialect}")
    private String dbDialect;
    @Value("${db.showSQL}")
    private String showSQL;
    @Value("${db.defaultSchema}")
    private String defaultSchema;

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(dbURL);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("org.nmdp.population.domain");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", dbDialect);
        properties.setProperty("show_sql", showSQL);
        properties.put("hibernate.default_schema", defaultSchema);
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txnMgr = new JpaTransactionManager();
        txnMgr.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return txnMgr;
    }

}
