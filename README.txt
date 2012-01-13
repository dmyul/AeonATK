AeonATK version: 1.0
01/13/2011

AeonATK is a web application written in the Grails framework. It was designed to interface a request in an Aeon Client with an Archivists' Toolkit database.

Pre-requisites
---------------------
Archivists' Toolkit (www.archiviststoolkit.org)
Java (http://www.java.com/)
Groovy (http://groovy.codehaus.org/)
Grails (http://grails.org/)
Tomcat (http://tomcat.apache.org/) or other application container

Please refer to individual documentation for each of these

Database
----------------------

You will need a working AT Database for this application. Vist  for more info.

In order to get this running you will need to configure the database file at /grails-app/conf/DataSource.groovy . 

The file is distributed with each environment preset to 'update'.I would suggest not changing this, as you could wipe your database with little trouble. I would also suggest using a read only connection for this, to further protect possible modification of your database. 

If you are using a database other than mysql you will need to add the appropriate jar file to the /lib directory and supply the appropriate url string in DataSource.groovy


Security
--------------------

The app is Secured through a secret code in the Aeon client plugin. This distribution is preset with the phrase "password" as a security token, you should change this if you are going to put this application into production. 

To do this edit the security service at: services/edu/yale/mssa/SecurityService.groovy

change the md5 hash in the line
	
	def hash = "5f4dcc3b5aa765d61d8327deb882cf99"

to the md5 hash of the passcode you encode in the plugin. 


Test Run
----------------------

go to the root of this installation and execute the following command
	
	grails run-app
	
If the database is configured correctly you should see

	Welcome to Grails 1.3.7 - http://grails.org/
	Licensed under Apache Standard License 2.0
	Grails home is set to: /opt/grails-1.3.7

	Base Directory: /Users/dm/Projects/AeonATK
	Resolving dependencies...
	Dependencies resolved in 1436ms.
	Running script /opt/grails-1.3.7/scripts/RunApp.groovy
	Environment set to development
	     [copy] Copying 1 file to /Users/dm/Projects/AeonATK/target/classes
	   [delete] Deleting directory /Users/dm/.grails/1.3.7/projects/AeonATK/tomcat
	Running Grails application..
	Server running. Browse to http://localhost:8080/AeonATK

You should see the main screen at the url above

If you do either search you should get a screen that simply says "Invalid Session", this is a good sign. 


Bypassing Security
-------------------------
In order to bypass the security mechanism you can provide the secret manually through a get request. If you did not change the passcode in the security section you can establish a validated sessions with the following url:
	http://localhost:8080/AeonATK/resources/aeon/?secret=password

**remember, you put the md5 hash of the passcode in the SecurityService.groovy and the plain text in the url as above. 

You should now have a validated session and both searches should return collection and series and items from your AT database. 


Production
--------------------------

If you are able to get everything running you can compile the application for production by running 
	grails war

This will create a new production .war file in the /target directory which you can deploy to you application server

Good Luck, 

Don Mennerich
donald.mennerich@yale.edu


