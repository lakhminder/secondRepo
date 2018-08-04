To set this project
a) import the hibernate3 user library(already built => refer UserLibrariesInfo.txt)
b)<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6"/>
	<classpathentry kind="con" path="org.eclipse.jdt.USER_LIBRARY/Spring3"/>
	<classpathentry kind="lib" path="C:/Lucky/softwares/Struts2/struts-2.3.4.1-all/struts-2.3.4.1/lib/commons-logging-1.1.1.jar"/>
	<classpathentry kind="con" path="org.eclipse.jdt.USER_LIBRARY/AOP"/>
	<classpathentry kind="con" path="org.eclipse.jdt.USER_LIBRARY/JDBC"/>
	<classpathentry kind="con" path="org.eclipse.jdt.USER_LIBRARY/DBCP"/>
	<classpathentry kind="con" path="org.eclipse.jdt.USER_LIBRARY/Hibernate_3"/>
================================================================

1) We can use inner bean if we want to have that object locally
<beans>
	<bean id="triangle" class="org.lucky.spring.example2ApplicationContext.shapes.Triangle" >
		<property name="pointA" ref="zeroPoint"/>
		<property name="pointB">
			<bean class="org.lucky.spring.example2ApplicationContext.Point" >
				<property name="x" value="10"/>
				<property name="y" value="20"/>
			</bean>
		</property>
	</bean>
</beans>

Note: Inner Bean can be defined without id attribute

2) We can use alias for beans using 'alias' tag or 'name' attribute
<beans>
	<bean id="triangle" class="org.lucky.spring.example2ApplicationContext.shapes.Triangle" 
	name="triangle-name">
		<property name="pointA" ref="zeroPoint"/>
		<property name="pointB" ref="APoint"/>
		<property name="pointC" ref="BPoint"/>
	</bean>
	<alias name="triangle" alias="triangle-alias1"/>
	<alias name="triangle" alias="triangle-alias2"/>
</beans>

3) Use 'idref' to restrict that reference is only by Id tag 

4) Scopes of beans managed by Spring container can be of :
	a) Basic bean scopes : 
			Singleton : Only once per Spring container
			prototype : new bean created with every request or reference
	b) Web-aware Context Bean Scopes : 
			Request : New Bean per servlet request 
			Session : New Bean per session
			Global Session : New bean per global HTTP session(portlet context)
	