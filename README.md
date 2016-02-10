Exmples of implementing fully localised web pages using Spring MVC.

The examples have been built and run with Spring Framework 
version 4.2.4.RELEASE on Tomcat 7 and 8 :

For comparison, there are four example projects:

singlelang: referential web page in single language (English) using Spring MVC;

messagesrc: internationalisation with Spring MessageSource

localisedtemplate: localisation using locale specific view sources;

fulllocalisation: fully localised Spring MVC with localised DAOs,
    MessageSource and localised view sources.


1) singlelang

This is a referential web page in single language (English). Its implementation
is pretty straight forward. But please note the following.

i)  The configuration is done entirely in Java through class 
    WebApplicationInitializer, and there is not XML files, not even 'web.xml'.

ii) The default @Requestmapping pattern for @Pathvariable "email" 
    truncates at the first dot (.), a new pattern is defined to get round 
    this problem.
    
    
2) messagesrc:

i)   For languages (French, Chinese as well as the default English) are shown
     here in the demo.

ii)  In the message mapping, apostrophe got swallowed by Spring for it being 
     considered single quote, so '' is needed to print apostrophe 
     (see file message_fr.properties);

iii) No explicit error message keys have been defined for model class UserAuth.
     Instead, spring generated keys (e.g. login.error.emailRequired, see file 
     message_fr.properties for example) are used.



3) localisedtemplate

i)   One major difficulty with localising a web page using messagesource is 
     that the page template is fixed and is used for all languages. This 
     makes it difficult to really localise page contents on a web page. 
     For example, Facebook and Youtube are blocked in China, and it would be
     better to have localised Chinese page template which does not contain 
     links to these sites.
     
ii)  To support localised templates, a LocaleViewResolver is created which
     incorporates a given locale into the view name. 
     
iii) The above LocaleViewResolver is then chained with a fallbackViewResolver
     which provides a fallback view name if the localised page template is
     not available for the localised view name.
     
iv)  Validation error messages are provided by spring as no MessageSource is
     explicitly defined.
     
     
   
