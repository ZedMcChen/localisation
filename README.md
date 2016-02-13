Exmples of implementing fully localised web pages using Spring MVC.

The examples have been built and run with Spring Framework 
version 4.2.4.RELEASE on Tomcat 7 and 8.



For comparison, there are four example projects:

singlelang: referential web pages in single language (English) using Spring MVC;

messagesrc: internationalisation with Spring MessageSource

localisedtemplate: localisation using locale specific view sources;

fullylocalised: fully localised Spring MVC with view sources and  MessageSource.



1) singlelang

i)   Referential web pages in single language (English), its implementation
     is pretty straight forward. But please note the following.

ii)  The configuration is done entirely in Java through class 
     WebApplicationInitializer, and there is not XML files, not even 'web.xml'.

iii)  The default @Requestmapping pattern for @Pathvariable "email" 
     truncates at the first dot (.), a new pattern is defined to get round 
     this problem. (See method showGreetingsMessage() in LoginController.java)
    
iv)  Validation error messages are the default ones provided by Spring 
     and they should be customised. For example, the validation error 
     message for the password field is "size must be between 8 and 2147483647"
     because only the minimum password character length is imposed. This 
     message should be improved. This is done in the project fullylocalised.
    
v)   To run:

     $ cd singlelang
     $ mvn clean tomcat7:run
     
Then navigate to http://localhost:8080/singlelang



2) messagesrc:

i)   Three languages (French, Chinese as well as the default English) are 
     shown here in the demo.

ii)  In the message mapping, apostrophe gets swallowed up by Spring for it
     being considered a single quote, so '' is needed to print apostrophe 
     (see file message_fr.properties);

iii) No explicit error message keys have been defined for model class UserAuth.
     Instead, Spring generated keys (e.g. login.error.emailRequired, see file 
     message_fr.properties for example) are used.
    
iv)  To run:

     $ cd messagesrc
     $ mvn clean tomcat7:run
     
Then navigate to http://localhost:8080/messagesrc




3) localisedtemplate

i)   One major difficulty with localising a web page using messagesource is 
     that the page template is fixed and is used for all languages. This 
     makes it difficult to really localise page contents. 
     For example, Facebook and Youtube are blocked in China, and it would be
     better to have localised Chinese page templates which do not contain 
     links to these sites.
     
ii)  To support localised templates, a LocaleViewResolver is created which
     incorporates a given locale value into the view name. 
     
iii) The above LocaleViewResolver is then chained with a fallbackViewResolver
     which provides a fallback view name if the localised page template is
     not available for the localised view name.
     
iv)  Validation error messages are provided by Spring as no MessageSource is
     explicitly defined.
    
v)   To run:

     $ cd localisedtemplate
     $ mvn clean tomcat7:run
     
Then navigate to http://localhost:8080/localisedtemplate

     


4) fullylocalised

i)   Though localised template can be used to fully localised page contents,
     it nevertheless has problems. For example, in Spring, it is quite easy
     to configure message sources for validation errors, but it is very
     difficult to template validation error messages.     

ii)  Therefore, to fully localise web contents, both localised templates and
     message sources should be used.
     
iii) In a really fully localised MVC, the user locale is passed into 
     controller methods and is used to query backend repositories and to 
     create models.
    
iv)  To run:

     $ cd fullylocalised
     $ mvn clean tomcat7:run
     
Then navigate to http://localhost:8080/fullylocalised




To run all the code, do the following:

a) At the project root,

     $ mvn clean install

b) start tomcat in the runall directory

     $ cd runall
     $ mvn clean tomcat7:run

Then navigate to http://localhost:8080






   
