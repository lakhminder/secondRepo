1) create maven project and select archtype as maven-archtype-webapp

add following dependencies to add jersey
<dependency>
    	<groupId>org.glassfish.jersey.bundles</groupId>
    	<artifactId>jaxrs-ri</artifactId>
    	<version>2.16</version>
    </dependency>
    <dependency>
    	<groupId>org.glassfish.jersey.media</groupId>
    	<artifactId>jersey-media-moxy</artifactId>
    	<version>2.16</version>
    </dependency>
  </dependencies>
  
Also add following to add compiler plugin to use java 1.7 or 1.8
<build>
        <finalName>advancedJaxrs</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.5.1</version>
                <inherited>true</inherited>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
==================================================
2) Access using http://localhost:8080/advancedJaxrs/myRestUrl/eg1/resPath
