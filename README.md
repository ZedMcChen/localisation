Exmples of implementing fully localised web pages using Spring MVC.

The examples have been built and run with Spring Framework version 4.2.4.RELEASE
on Tomcat 8 :

For comparison, there are four example projects:

singlelang: referential web page in single language (English) using Spring MVC;

messagesource: internationalisation with Spring MessageSource

localisedtemplate: localisation using locale specific view sources;

fulllocalisation: fully localised Spring MVC with localised DAOs,
    MessageSource and localised view sources.


1) singlelang

This is a referential web page in single language (English). Its implementation is
pretty straight forward. But please note the following.

i)  The configuration is done entirely in Java through class WebApplicationInitializer;
    and there is not XML files, not even 'web.xml';

ii) The default @Requestmapping pattern for @Pathvariable "email" truncates at the 
    first dot (.), a new pattern is defined to get round this problem.