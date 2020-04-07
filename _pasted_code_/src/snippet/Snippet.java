package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xmlns:mvc="http://www.springframework.org/schema/mvc"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context 
	    http://www.springframework.org/schema/context/spring-context.xsd
	    http://www.springframework.org/schema/tx 
	    http://www.springframework.org/schema/tx/spring-tx.xsd
	    http://www.springframework.org/schema/mvc 
	    http://www.springframework.org/schema/mvc/spring-mvc.xsd">
	    
	    <context:component-scan base-package="com.revature"></context:component-scan>
	    
	    <mvc:annotation-driven></mvc:annotation-driven>
	    <tx:annotation-driven/>
	    
	    <bean name="ourDataSource" class="org.apache.commons.dbcp.BasicDataSource">
	    	<property name="url" value="jdbc:oracle:thin:@revature-training.cehe1xne1cax.us-east-1.rds.amazonaws.com:1521:orcl"/>
	    	<property name="username" value="ormdemo2"/>
	    	<property name="password" value="password"/>
	    	<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
	    </bean>
	    <bean name="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
	    	<property name="dataSource" ref="ourDataSource"/>
	    	<property name="packagesToScan" value="com.revature"/>
	    	<property name="hibernateProperties">
	    		<props>
	    			<prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>
	    			<prop key="show_sql">true</prop>
	    			<prop key="hibernate.hbm2ddl.auto">update</prop>
	    			<prop key="hibernate.default_schema">ormdemo2</prop>
	    		</props>
	    	</property>
	    </bean>
	    <bean name="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
	    	<property name="sessionFactory" ref="sessionFactory"/>
	    	<property name="nestedTransactionAllowed" value="true"/>
	    </bean>
	</beans>
}

